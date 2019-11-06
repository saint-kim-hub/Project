import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Packet")
public class Packet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items = new ArrayList<Item>();
       
    public Packet() {
        super();
    }
    public void addItem(Item item) {
		this.items.add(item);
	}
	public String raw() {
		StringBuffer result = new StringBuffer();
		for (Item item:items) {
			result.append(item.raw());
		}
		return result.toString();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Packet packet = new Packet();
		packet.addItem(Item.create("key", 6, Format.time()));
		packet.addItem(Item.create("text", 1000, request.getParameter("Txt")));
		
		try {
			Write.writeFile(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/Project/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
