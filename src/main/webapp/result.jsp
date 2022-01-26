<%--
  Author: Martin Arango (marangol)
  This file is a part of the view component of the MVC
  It is where the results displayed
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<%-- The body displays the parameters passed by the controller as the result--%>
<body>
<h1>The ${hash_algorithm} hash of ${input_str} is</h1>
<h2>Hex: ${hash_hex}</h2>
<h2>Base64: ${hash_base64}</h2>
</body>
</html>
