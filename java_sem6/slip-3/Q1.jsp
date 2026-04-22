<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Patient Details</title>
<style>
table { border-collapse: collapse; width: 80%; margin: 20px auto; }
th, td { border: 1px solid #ddd; padding: 8px; }
th { background: #f2f2f2; }
</style>
</head>
<body>

<h2 align="center">Patient Details</h2>

<%
String[][] patients = {
    {"1","Austin","Nashik","20","Fever"},
    {"2","Vaishnavi","Camp","15","Headache"},
    {"3","Kunal","Nashik","19","Flu"},
    {"4","Arpita","Pune","21","Cough"}
};
%>

<table>
<tr>
    <th>No</th><th>Name</th><th>Address</th><th>Age</th><th>Disease</th>
</tr>

<% for(String[] p : patients){ %>
<tr>
    <% for(String data : p){ %>
        <td><%= data %></td>
    <% } %>
</tr>
<% } %>

</table>

</body>
</html>