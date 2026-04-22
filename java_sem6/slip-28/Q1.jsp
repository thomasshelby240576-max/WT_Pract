<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reverse String</title>
</head>
<body>

<h2>Reverse String</h2>

<form action="Q1.jsp" method="post">
    Enter a String: <input type="text" name="inputString">
    <input type="submit" value="Reverse">
</form>

<%
String inputString = request.getParameter("inputString");
if (inputString != null && !inputString.isEmpty()) {
    String reversedString = new StringBuilder(inputString).reverse().toString();
%>
    <p>Original String: <%= inputString %></p>
    <p>Reversed String: <%= reversedString %></p>
<%
}
%>

</body>
</html>
