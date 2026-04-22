<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>

    <h2>Greeting Page</h2>

    <form action="Q2.jsp" method="post">
        Enter your name: <input type="text" name="username">
        <input type="submit" value="Greet">
    </form>

    <%
        // Get the current time
        java.util.Date currentDate = new java.util.Date();
        java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH");
        int hour = Integer.parseInt(timeFormat.format(currentDate));

        // Greeting message
        String greeting = "";
        if (hour >= 0 && hour < 12) {
            greeting = "Good morning";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }

        // Get username from the request
        String username = request.getParameter("username");

        // Display greeting message
        if (username != null && !username.isEmpty()) {
    %>
            <p>Hello, <%= username %>. <%= greeting %>!</p>
    <%
        }
    %>

</body>
</html>
