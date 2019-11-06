import java.util.Date;
import java.text.SimpleDateFormat;

public class Format {
	private static Date d = new Date();
	public static String time() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		
		return sdf.format(d);
	}
	public static String date() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		return sdf.format(d);
	}
}
