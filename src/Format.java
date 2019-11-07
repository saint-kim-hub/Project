import java.util.Date;
import java.text.SimpleDateFormat;

public class Format {
	private static Date d = new Date(); // 현재 시간
	public static String time() { // 시간 형태 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		
		return sdf.format(d);
	}
	public static String date() { // 날짜 형태 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		return sdf.format(d);
	}
}
