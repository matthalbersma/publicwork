<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Edit DVD</h1>
            <hr/>
        </div>
        <div class="container">
            <a class="btn btn-primary btn-block" href="dvdlist">Return to List</a><br>
            <sf:form class="form-horizontal"
                     role="form"
                     action="editdvdpost"
                     method="POST"
                     modelAttribute="dvd">
                <div class="form-group">
                    <label for="title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="title" path="title" placeholder="Title"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="year" class="col-md-4 control-label">Release Year:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="year" path="releaseDate" placeholder="Release Year"/>

                    </div>
                </div>
                <div class="form-group">
                    <label for="Rating" class="col-md-4 control-label">Rated</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="Rating" path="mpaaRating" placeholder="MPAA Rating"/>

                    </div>
                </div>
                <div class="form-group">
                    <label for="addDirector" class="col-md-4 control-label">Director</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="addDirector" path="director" placeholder="Director"/>

                    </div>
                </div>
                <div class="form-group">
                    <label for="addIMDB" class="col-md-4 control-label">IMDB ID</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="addIMDB" path="imdbID" placeholder="IMDB ID"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="addURL" class="col-md-4 control-label">Cover Art URL</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="addURL" path="coverURL" placeholder="Cover Art URL"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="addNotes" class="col-md-4 control-label">User Notes</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="addNotes" path="userRating" placeholder="User Notes"/>
                        <sf:hidden path="id"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" id="add-button" class="btn btn-default">Update</button>
                    </div>
                </div>
            </sf:form>
        </div>
    </div>
    <!-- Placed at the end of the document so the pages load faster -->
          <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

</body>

