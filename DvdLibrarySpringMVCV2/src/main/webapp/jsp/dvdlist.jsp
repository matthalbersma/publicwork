<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Dvd Library List</title>
        <!-- Bootstrap core CSS -->

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/hover.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
                        <h1>Movies</h1>
            <hr/>
            <nav class="navbar navbar-tabs">   
                <ul class="nav nav-tabs">
                    <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/dvdlist">Dvd List</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
            </nav>
            <a class="btn btn-primary btn-block" data-toggle="modal" href="#addModal">Add a DVD</a><br>
            <div id="displaybody" class="container"></div>
        </div>
        <%@include file="addModalFragment.jsp" %>
        <%@include file="infoModalFragment.jsp"%>
        <%@include file="editModalFragment.jsp"%>       
        <script src="${pageContext.request.contextPath}/js/src.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>
        <!-- Placed at the end of the document so the pages load faster -->

    </body>
</html>
