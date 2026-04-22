<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Sum of First and Last Digit</h2>

    <form action="Q1.jsp" method="post">
        Enter a number: <input type="number" name="number">
        <input type="submit" value="Calculate Sum">
    </form>

    <%
        try {
            int number = Integer.parseInt(request.getParameter("number"));
            // Calculate the sum of the first and last digits
            int lastDigit = number % 10;
            int firstDigit = 0;
            while (number != 0) {
                
                firstDigit = number % 10;
                number /= 10;
            }

            int sum = firstDigit + lastDigit;
    %>
            <p style="color: red; font-size: 18px;">Sum of first and last digit: <%= sum %></p>
    <%
        } catch (NumberFormatException e) {
    %>
            <p style="color: red; font-size: 18px;">Please enter a valid number.</p>
    <%
        }
    %>

</body>
</html>
