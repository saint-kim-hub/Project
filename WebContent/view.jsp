<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File, java.nio.file.Files, java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset, java.nio.file.Path" %>
<%@ page import="java.util.TreeMap, java.util.List, java.util.Collections" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	TreeMap<String, List> map = new TreeMap<>(Collections.reverseOrder());
	
	File dir = new File("/opt/tomcat/2019");
	File[] fileList = dir.listFiles();
	
	try {
		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isFile()) {
				Path path = Paths.get("/opt/tomcat/2019", file.getName());
				Charset charset = Charset.forName("UTF-8");
				List<String> fileContents = Files.readAllLines(path, charset);
				map.put(file.getName(), fileContents);
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
		<div class="dot"><a onclick=""></a></div>${map.value}
	</li>
</c:forEach>