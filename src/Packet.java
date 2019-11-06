import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Packet {
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
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		Packet packet = new Packet();
		packet.addItem(Item.create("key", 6, Format.time()));
		packet.addItem(Item.create("text", 1000, request.getParameter("Txt")));
	}
}