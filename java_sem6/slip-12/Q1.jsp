<%@ page language="java"%>

<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>
    <font color="red">
        <h2>Perfect Number Checker</h2>
        <form action="Q1.jsp" method="post">
            Enter a number: <input type="number" name="number">
            <input type="submit" value="Check Perfect">
        </form>
        <% 
            if (request.getParameter("number") != null) {
                int num = Integer.parseInt(request.getParameter("number"));
                int sum = 0;
                for (int i = 1; i <= num / 2; i++) {
                    if (num % i == 0) {
                        sum += i;
                    }
                }
                if (sum == num) {
                    out.println(num + " is Perfect");
                } else {
                    out.println(num + " is not perfect");
                }
            }
        %> 
    </font>
</body>
</html>
