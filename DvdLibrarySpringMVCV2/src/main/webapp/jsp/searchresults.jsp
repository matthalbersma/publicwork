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

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD's I Own</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                 <li role="presentation"><a href="${pageContext.request.contextPath}/dvdlist">Dvd List</a></li>
                <li role="presentation"class="active" ><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
            </div>
                <div class="container">
                    <c:forEach var="dvd" items="${results}">
                        <s:url value="deleteDVD"
                           var="deleteDVD_url">
                        <s:param name="id" value="${dvd.id}"/>
                    </s:url>
                    <s:url value="editDvd"
                           var="editDvd_url">
                        <s:param name="id" value="${dvd.id}"/>
                    </s:url>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4">
                                <img src=${dvd.coverURL}>
                            </div>
                            <div class="col-md-8">
                                <h3>${dvd.title}
                                <a class="btn btn-sm btn-primary"
                                 href="${deleteDVD_url}">Delete</a>
                                <a class="btn btn-sm btn-primary"
                                   href="${editDvd_url}">Edit</a></h3>
                                                          
                                Year: ${dvd.releaseDate}<br>
                                Rating: ${dvd.mpaaRating}<br>
                                Director: ${dvd.director}<br>
                                Note: ${dvd.userRating}
                            </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
 

    </body>
</html>
