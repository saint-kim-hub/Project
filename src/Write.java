import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Write {
	public static void writeFile(Packet packet) throws Exception {
		Path path = Paths.get("/opt/tomcat/2019", Format.date() + ".txt");
		ArrayList<String> contents = new ArrayList<String>();
		contents.add(packet.raw());
		Charset charset = Charset.forName("EUC-KR");
		StandardOpenOption createOpt = StandardOpenOption.CREATE;
		StandardOpenOption appendOpt = StandardOpenOption.APPEND;
		
		Files.write(path, contents, charset, createOpt, appendOpt);
	}
}