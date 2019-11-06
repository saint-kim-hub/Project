public class Item {
	private String key;
	private int length;
	private String text;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String raw() {
	    StringBuffer padded = new StringBuffer(this.text);
	    while (padded.toString().getBytes().length < this.length) {
	        padded.append(' ');
	    }
	    
	    return padded.toString();
	}

	public static Item create(String key, int length, String text) {
		Item item = new Item();
		item.setKey(key);
		item.setLength(length);
		item.setText(text);
		
		return item;
	}
}