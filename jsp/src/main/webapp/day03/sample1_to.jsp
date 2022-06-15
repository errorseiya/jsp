<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>sample2_to</title>
</head>
<body>

<%
//リクエストパラメーターを受けとる前にrequest.setCharacterEncoding("文字コード（本書ではutf-8）");を
//記述し、リクエストで扱う文字のコードをutf-8としている
//JSPの場合、日本語は文字化けしてしまうクソが
    request.setCharacterEncoding("utf-8");

//送信された値を取得、request.getParameter("name属性");
    String text = request.getParameter("text");
%>
<b>受信結果</b><br/>
<p><%=text %></p>
<a href="sample1_from.jsp">戻る</a>

</body>
</html>