<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>sample1_to.jsp</title>
</head>
<body>

<h2>sample1_to.js</h2>

<!-- セッションIDを取得 -->
<p>session ID:<%= session.getId() %></p>


<!-- セッションで値を取得 -->
<!-- session.getAttribute("第１引数") とすることで値を取得できる-->
<p>foo:<%= session.getAttribute("foo") %></p>

<!-- 下記は、session.getAttribute("foo")で得られる値が、「String型」ではない事を確認しただけ -->
<% String foo = session.getAttribute("foo").toString() ; %>
<p>hoge:<%= session.getAttribute("hoge") %></p>

<h2>request Object</h2>

<!-- リフェラーを取得 -->
<!-- 今回であれば、//localhost:8080/jsp/day05/sample1_from.jsp が取得できる -->
<p>Referer:<%= request.getHeader("referer") %></p>
<p><a href = "sample1_from.jsp">sample1_from.jsp</a></p>

</body>
</html>

<!-- 
リフェラーとは、]

ブラウザで表示する直前に閲覧していたページのURLの情報です。

これを辿っていくと閲覧者がどこのサイトから訪問したのか、
また、サイト内でどのような軌跡を辿ったのかなどを調べることができます。
 -->
