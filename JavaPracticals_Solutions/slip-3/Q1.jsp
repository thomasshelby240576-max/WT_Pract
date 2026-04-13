<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Details</title>
<style>
    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>

<h2>Patient Details</h2>

<%
// Sample data for demonstration
class Patient {
    private int pNo;
    private String pName;
    private String address;
    private int age;
    private String disease;

    public Patient(int pNo, String pName, String address, int age, String disease) {
        this.pNo = pNo;
        this.pName = pName;
        this.address = address;
        this.age = age;
        this.disease = disease;
    }

    public int getPNo() {
        return pNo;
    }

    public String getPName() {
        return pName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }
}

// Sample patient data
Patient[] patients = {
    new Patient(1, "Austin", "Nashik", 20, "Fever"),
    new Patient(2, "Vaishnavi", "Camp", 15, "Headache"),
    new Patient(3, "Kunal", "Nashik", 19, "Flu"),
    new Patient(4, "Arpita", "Pune", 21, "Cough")
};
%>

<table>
    <tr>
        <th>Patient Number</th>
        <th>Patient Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Disease</th>
    </tr>
    <% for (Patient patient : patients) { %>
    <tr>
        <td><%= patient.getPNo() %></td>
        <td><%= patient.getPName() %></td>
        <td><%= patient.getAddress() %></td>
        <td><%= patient.getAge() %></td>
        <td><%= patient.getDisease() %></td>
    </tr>
    <% } %>
</table>

</body>
</html>
