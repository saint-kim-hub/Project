import java.util.Date;
import java.text.SimpleDateFormat;

public class Format {
	private static Date d = new Date(); // 현재 시간
	public static String format() { // 형태 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		
		return sdf.format(d);
	}
}
