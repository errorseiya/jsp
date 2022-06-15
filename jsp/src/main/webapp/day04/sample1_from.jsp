<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>day04_sample1_from</title>
</head>
<body>

<form action="sample1_to.jsp" method="post">
<table>
    <tr>
        <th colspan="2">名前</th>
    </tr>
    <tr>
        <th>姓</th><td><input type="text" id="family" name="family"/></td>
    </tr>
    <tr>
        <th>名</th><td><input type="text" id="name" name="name"/></td>
    </tr>
</table>
<br/>
<p><b>性別</b>
<input type="radio" id="sex" name="sex" value="男" checked>男
<input type="radio" id="sex" name="sex" value="女" >女
</p>
<br/>
<b>年代</b><br/>
<% String age[] = {"10歳未満","10代","20代","30代","40代以上"}; %>
<select id="age_id" name="age_id">
<%for(int i = 0; i < age.length ; i++){ %>
    <option value="<%= i %>"><%= age[i] %></option>
<%} %>
</select>
<br/>
<br/>
<input type="submit" id="送信" name="送信" value="送信" />
</form>

</body>
</html>