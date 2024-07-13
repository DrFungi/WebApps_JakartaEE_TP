
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Tax Calculator</title>
  <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<h1 class="centered">CANADA Tax Calculator</h1>

<%-- This is a JSP comment: The following form is used to capture user input for income and province --%>
<form action="calculate" method="post">
  <label for="income">Total Income:</label>
  <input type="text" id="income" name="income" required><br><br>
  <label for="province">Province:</label>
  <select id="province" name="province" required>
    <option value="Quebec">Quebec</option>
    <option value="AB">Alberta</option>
    <option value="BC">British Columbia</option>
    <option value="MB">Manitoba</option>
    <option value="NB">New Brunswick</option>
    <option value="NL">Newfoundland and Labrador</option>
    <option value="NS">Nova Scotia</option>
    <option value="ON">Ontario</option>
    <option value="PE">Prince Edward Island</option>
    <option value="SK">Saskatchewan</option>
    <!-- Add other provinces/territories as needed -->
  </select>
  <p>WARNING!!!! THE ONLY WORKING OPTION IN THIS PROTOTYPE IS QUEBEC</p><br><br>
  <label for="calculateFederal">Check below to calculate and add federal tax:</label>
  <input type="checkbox" id="calculateFederal" name="calculateFederal" value="true"><br><br>
  <button type="submit">Calculate Tax</button>
</form>
<br>
<br>

<c:if test="${not empty taxQ}">
  <h2>Tax Result:</h2>
  <p>your Quebec tax to pay: ${taxQ}</p>
</c:if>
<c:if test="${calculateFederal}">
  <c:if test="${not empty taxC}">
    <p>Your Federal tax to pay: ${taxC}</p>
    <p>Your Total tax to pay: ${taxT}</p>
  </c:if>
</c:if>
</body>
</html>
