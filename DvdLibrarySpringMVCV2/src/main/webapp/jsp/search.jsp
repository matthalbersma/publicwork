<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search</title>
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
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/dvdlist">Dvd List</a></li>
                    <li role="presentation"class="active" ><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
            </div>
            <h1>DVD Search</h1>

        </div>
        <div class="container">
            <div class="container col-md-8" id="displaybody"></div>
            <div class="container col-md-4">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="search-title" class="col-md-4 control-label">Title:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="search-title" placeholder="Title"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="search-year" class="col-md-4 control-label">Release Year:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="search-year"  placeholder="Release Year"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="search-rating" class="col-md-4 control-label">Rated</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="search-rating" placeholder="MPAA Rating"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="search-director" class="col-md-4 control-label">Director</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="search-director" placeholder="Director"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="search-imdb" class="col-md-4 control-label">IMDB ID</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="search-imdb" placeholder="IMDB ID"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="search-button" class="btn btn-default">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="infoModalFragment.jsp"%>
        <%@include file="editModalFragment.jsp"%>       
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/src.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>


    </body>