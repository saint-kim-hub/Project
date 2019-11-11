package com.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items = new ArrayList<Item>(); // 키와 값을 입력 받을 배열 리스트  
	private Map<String, Object> commandMap = new HashMap<>();
       
    public Controller() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {
    	loadProperties("com.project.properties.command");
    }

    public void addItem(Item item) {
		this.items.add(item);
	}
    
	public String raw() { // 배열 리스트를 문자열로 변환
		StringBuffer result = new StringBuffer();
		for (Item item:items) {
			result.append(item.raw());
		}
		return result.toString();
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("Txt") != null) {
			Controller packet = new Controller();
			packet.addItem(Item.create("text", 1000, request.getParameter("Txt"))); // 나머지 문자열
	    	
	    	try {
	    		Write.writeFile(packet); // 파일에 저장하기 위해 Write.java파일로 패킷 전송
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	response.sendRedirect("/Project/");
		}
		
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
    	Enumeration<String> actionEnumeHome = rbHome.getKeys();
    	while (actionEnumeHome.hasMoreElements()) {
    		String command = actionEnumeHome.nextElement();
    		String className = rbHome.getString(command);
    		try {
    			Class<?> commandClass = Class.forName(className);
    			Object commandInstance = commandClass.newInstance();
    			commandMap.put (command, commandInstance);
    		} catch (ClassNotFoundException e) {
    			continue;
    		} catch (InstantiationException e) {
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			e.printStackTrace();
    		}
    	}
	}
	private void requestPro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI(); 
			String contPath = request.getContextPath();
			if (command.indexOf(contPath) == 0) {
				command = command.substring(contPath.length());
			}
			com = (CommandAction) commandMap.get(command);
			if (com == null) {
				System.out.println("Not Found" + command);
				return;
			}
			view = com.requestPro(request, response);
			if (view == null) {
				return;
			}
		} catch (Throwable e) {
			throw new ServletException();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(view);
		dis.forward(request, response);
	}
}
