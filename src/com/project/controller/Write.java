package com.project.controller;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Write {
	public static void writeFile(Controller packet) throws Exception {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Path path = Paths.get("/opt/tomcat/2019", sdf.format(d) + ".txt"); // 패킷을 저장할 경로 지정. /opt/tomcat/년도/날짜.txt
		ArrayList<String> contents = new ArrayList<String>(); // packet 내용을 저장할 배열 리스트
		contents.add(packet.raw()); // packet내용 저장
		Charset charset = Charset.forName("UTF-8"); // 인코딩 방식 
		StandardOpenOption createOpt = StandardOpenOption.CREATE; // 파일이 없을 경우 새로 생성
		
		Files.write(path, contents, charset, createOpt); // 파일 저장
	}
}