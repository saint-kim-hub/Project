<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File, java.nio.file.Files, java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset, java.nio.file.Path" %>
<%@ page import="java.util.List" %>
<%
	File dir = new File("/opt/tomcat/2019"); // 폴더 경로
	File[] fileList = dir.listFiles();
	try {
		for (int i = 0; i < fileList.length; i++) { // 폴더 내에 있는 파일 찾기
			File file = fileList[i];
			if (file.isFile()) { // 파일일 경우
				Path path = Paths.get("/opt/tomcat/2019", file.getName()); // 폴더 경로 + 파일
				Charset charset = Charset.forName("EUC-KR"); // 인코딩 방식
				List<String> fileContents = Files.readAllLines(path, charset); // 파일 내용
				for (String temp:fileContents) { // 찾은 파일 안에 있는 내용 출력
					out.println(temp); // 출력
				}
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>