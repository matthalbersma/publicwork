<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>These are some of the labs we've done</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/luckyseven">Lucky Sevens</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>
                </ul>    
            </div>
            <h1>Unit conversion</h1>
            <p>Pick a conversion type</p>
            <select onchange="choice()" id="first">
                <option>-select--</option>
                <option value="1">Temperature</option>
                <option value="2">Weight</option>
                <option value="3">Volume</option>
            </select><br><br>
            <form method=post action="converter">
                <select onchange="choice1()" id= "U1" name=unit1>
                    <option>--select--</option>
                </select>
                <br><h2>To</h2>
                <select id="u2" name=unit2>
                    <option>--Select--</option>    
                </select>
                <h2>Amount to convert</h2>
                <input type=text name=convert1><br>
                <input type=submit>
            </form>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
             <script src="${pageContext.request.contextPath}/js/Unit.js"></script>
    </body>
</html>

