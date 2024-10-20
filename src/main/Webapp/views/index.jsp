<%@ page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h2> My Calculator : </h2>
        <form action="calculate">
            <label for="num1">Enter 1st Number:</label>
            <input type="text" id="num1" name="num1"><br>

            <label for="num2">Enter 2nd Number:</label>
            <input type="text" id="num2" name="num2"><br>

            <label>Select Operation:</label><br>
            <input type="radio" id="add" name="operation" value="add" checked>
            <label for="add">Addition</label><br>

            <input type="radio" id="subtract" name="operation" value="subtract">
            <label for="subtract">Subtraction</label><br>

            <input type="radio" id="multiply" name="operation" value="multiply">
            <label for="multiply">Multiplication</label><br>

            <input type="radio" id="divide" name="operation" value="divide">
            <label for="divide">Division</label><br>

            <input type="submit" value="submit">
        </form>
    </body>
</html>
