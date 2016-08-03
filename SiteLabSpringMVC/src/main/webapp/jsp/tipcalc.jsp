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
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                    <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>
                </ul>    
            </div>

            <h2>Welcome to the Tip Calculator</h2>
            <h4>Let's compute your tip!</h4>
            <p>

            <form class="form-horizontal" role="form" method="post" action="tipcalc">
                <div class="form-group">
                    <label class="col-md-4 control-label"> What's your bill?  </label>
                    <div class="col-md-8">
                        <input type=text name="amount"><br>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label"> What's your tip percentage?</label>
                    <div class="col-md-8">
                        <input type=text name="percentage"><br>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type=submit class="btn btn-default">Calculate</button>
                    </div>
                </div>
            </form>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>