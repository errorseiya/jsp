<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>掲示板</title>
</head>
<body>
<h1>ひとこと掲示板</h1>

<form action="Hitokoto" method="post">


	<label>名前:</label>
	<input type="text" id="name" name="name">

	<label>コメント:</label>
	<input type="text" id="comment" name="comment">


	<input type="submit" value="送信">
	
</form>

<% if( request.getAttribute("error") != null ) { %>
	<% if(request.getAttribute("error") == "コメントが入力されていません"){ %>
	<p><%= request.getAttribute("error") %></p>
	<% }else{ %>
	<%= request.getAttribute("name") %><p>さんがコメントしました。</p>)
	<%= request.getAttribute("comment") %>
	<% } %>
<% } %>
</body>
</html>



<!-- http://localhost:8080/jsp/keizibanapp/KeizibanApp.jsp　でアクセス可能 -->