import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Write {
	public static void writeFile(Packet packet) throws Exception {
		Path path = Paths.get("/opt/tomcat/2019", Format.format() + ".txt"); // 패킷을 저장할 경로 지정. /opt/tomcat/년도/날짜.txt
//		Path path = Paths.get("d://2019", Format.format() + ".txt");
		ArrayList<String> contents = new ArrayList<String>(); // packet 내용을 저장할 배열 리스트
		contents.add(packet.raw()); // packet내용 저장
		Charset charset = Charset.forName("UTF-8"); // 인코딩 방식 
		StandardOpenOption createOpt = StandardOpenOption.CREATE; // 파일이 없을 경우 새로 생성
//		StandardOpenOption appendOpt = StandardOpenOption.APPEND; // 파일이 있을 경우 파일안에 추가
		
		Files.write(path, contents, charset, createOpt); // 파일 저장
	}
}