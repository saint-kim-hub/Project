<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File, java.nio.file.Files, java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset, java.nio.file.Path" %>
<%@ page import="java.util.TreeMap, java.util.List, java.util.Collections" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
	
	File dir = new File("/opt/tomcat/2019");
	File[] fileList = dir.listFiles();
	
	try {
		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isFile()) {
				String name = file.getName();
				Path path = Paths.get(dir.getPath(), name);
				Charset charset = Charset.forName("UTF-8");
				List<String> fileContents = Files.readAllLines(path, charset);
				map.put(name.substring(0, name.length() - 4), String.join("", fileContents));
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<c:forEach var="map" items="<%=map%>">
	<div class="range"></div>
	<li>
		<div class="space">${map.key}</div>
		<div class="dot">
			<form action="com.project.controller.Controller">
				<button type="submit" name="del" value="${map.key}">삭제</button>
			</form>
		</div>
		<div class="textbox">${map.value}</div>
	</li>
</c:forEach>