<%--
  Author: Martin Arango (marangol)
  This file is a part of the view component of the MVC
  It is the default page of the site
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project1Task1</title>
</head>
<body>
<h1><%= "Project1Task1" %>
</h1>
<%-- This is the HTML form that captures the input string and the
 hash algorithm selected--%>
<form action="computeHashes-servlet" method="get" id="hash_form">
    <label for="inputStr">Text data</label><br>
    <input type="text" id="inputStr" name="inputStr"><br><br>
    <legend>Hashing algorithm</legend>
    <input type="radio" id="sha256" name="hashAlgorithm" value="SHA256">
    <label for="sha256">SHA-256</label><br>
    <input type="radio" id="md5" name="hashAlgorithm" value="MD5" checked>
    <label for="md5">MD5</label><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>