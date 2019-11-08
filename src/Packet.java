import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Packet")
public class Packet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items = new ArrayList<Item>(); // 키와 값을 입력 받을 배열 리스트  
//	private HashMap<String, Item> nameAccess = new HashMap<String, Item>(); 
       
    public Packet() {
        super();
    }
    
//    public Item getItem(String name) {
//		return nameAccess.get(name);
//	}
    public void addItem(Item item) {
		this.items.add(item);
//		nameAccess.put(item.getKey(), item);
	}
    
	public String raw() { // 배열 리스트를 문자열로 변환
		StringBuffer result = new StringBuffer();
		for (Item item:items) {
			result.append(item.raw());
		}
		return result.toString();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Packet packet = new Packet();
//		packet.addItem(Item.create("key", 6, Format.time())); // 키 값 6자리
		packet.addItem(Item.create("text", 1000, request.getParameter("Txt"))); // 나머지 문자열
		
		try {
			Write.writeFile(packet); // 파일에 저장하기 위해 Write.java파일로 패킷 전송
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/Project/"); // 파일 전송 후 index페이지로 이동
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // index.jsp 페이지의 form에서 보낸 POST를 GET으로 전달
	}

}
