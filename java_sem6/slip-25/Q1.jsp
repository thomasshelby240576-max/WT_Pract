<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
<body>

<h2>Voter Eligibility Checker</h2>

<form action="" method="post">
    Name: <input type="text" id="name" name="name" required><br><br>
    Age:<input type="number" id="age" name="age" required><br><br>
    <input type="submit" value="Check Eligibility">
</form>

<%
    // Get parameters from the request
    String name = request.getParameter("name");
    String ageString = request.getParameter("age");
    
    if (name != null && ageString != null && !name.isEmpty() && !ageString.isEmpty()) {
        try {
            int age = Integer.parseInt(ageString);

            // Check eligibility for voting
            boolean isEligible = age >= 18;

            // Display result
    %>
            <p>Name: <%= name %></p>
            <p>Age: <%= age %></p>
            <p>
            <% if (isEligible) { %>
                Congratulations! You are eligible to vote.
            <% } else { %>
                Sorry, you are not eligible to vote yet.
            <% } %>
            </p>
    <%
        } catch (NumberFormatException e) {
            // Handle invalid age input
            %>
            <p>Please enter a valid age.</p>
            <%
        }
    }
%>

</body>
</html>
