<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<title>Prime Number Checker</title>
</head>
<body>

<h2>Prime Number Checker</h2>

<form action="Q1.jsp" method="post">
    Enter a number: <input type="number" name="number">
    <input type="submit" value="Check Prime">
</form>

<%! 
    // Method to check if a number is prime
    boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
%>

<%
int number;
try {
    number = Integer.parseInt(request.getParameter("number"));
    boolean isPrime = checkPrime(number);
    String result = isPrime ? "Prime" : "Not Prime";
%>
    <p style="color: red;">Result: <%= result %></p>
<%
} catch (NumberFormatException e) {
%>
    <p style="color: red;">Please enter a valid number.</p>
<%
}
%>

</body>
</html>
