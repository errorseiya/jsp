<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>sample1_from</title>
</head>
<body>

<br/>
<% String links[] = {"link1","リンク2" }; %>

<!-- aタグで情報送信 -->

<% for(int i = 0; i < links.length ; i++){%>
<!-- 
href="送り先のURL?name=value" 
href="送り先のURL?name=value1&name2=value2&…"
-->
<a href="sample1_to.jsp?text=<%= links[i]%>">リンク処理<%=i %></a>
<br/>
<% } %>

</body>
</html>