<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ page import="java.nio.file.Path, java.nio.file.Paths, java.nio.file.Files" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.nio.charset.Charset, java.nio.file.StandardOpenOption" %> 
<%
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
	SimpleDateFormat stf = new SimpleDateFormat("HHmmss");
	Path path = Paths.get("/opt/tomcat/2019", sdf.format(d)+ ".txt");
	List<String> contents = new ArrayList<String>();
	contents.add(stf.format(d) + request.getParameter("Txt") + "\r\n");
	Charset charset = Charset.forName("UTF-8");
	StandardOpenOption createOpt = StandardOpenOption.CREATE;
	StandardOpenOption appendOpt = StandardOpenOption.APPEND;
	
	out.println(path.getParent());
	try {
		Files.write(path, contents, charset, createOpt, appendOpt);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	response.sendRedirect("http://13.125.165.75:8080/Project/index.jsp");
%>