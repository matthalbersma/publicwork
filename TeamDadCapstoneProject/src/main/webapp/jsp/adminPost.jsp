<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Sad Dad Dyskount Liquors</title>
        <meta name="description" content="Blueprint: On-Scroll Animated Header" />
        <meta name="keywords" content="fixed header, animatied header, javascript, wed design, template, on scroll" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/datetimepicker-master/build/jquery.datetimepicker.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/AnimatedHeader/css/component.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/AnimatedHeader/css/default.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/teamDad.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    </head>
    <body>
        <div class="container">

            <div class="cbp-af-header">
                <div class="cbp-af-inner">
                    <div class="dropdown">
                        <h2 class="fa fa-bars dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown"></h2>
                        <ul class="dropdown-menu" id="dropMen">
                        </ul>
                    </div>
                    <h1>sad dad dyskØunt liquors</h1>
                    <nav>
                        <a href="home"><h2 class="fa fa-home"></h2></a>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="post">Create Post</a>
                            <div class="hold"></div>
                        </sec:authorize>

                        <sec:authorize access="hasRole('ROLE_MARKETING')">
                            <a href="post">Create Marketing Post</a>
                            <div class="holdMar"></div>
                        </sec:authorize>
                    </nav>
                </div>
            </div>

            <div class="main">

                <div class='searchDiv'><div class="input-group">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" id="searchBtn"><span class= "glyphicon glyphicon-search"></span></button>
                        </span>
                        <input type="text" id="searchField" class="form-control" placeholder="Search for...">
                    </div>
                </div>
            </div>
            <div id="logInButtons">

                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MARKETING')">
                    <div class="row">
                        <div class="col-xs-11"></div>
                        <div class="col-xs-1"><a class="logOutLink" id="logOutLink" href="${pageContext.request.contextPath}/j_spring_security_logout"> <div class="fa fa-lock"></div></a></div>
                    </div>
                </sec:authorize>
                <sec:authorize access="not hasAnyRole('ROLE_ADMIN', 'ROLE_MARKETING')">
                    <div class="row">
                        <div class="col-xs-11"></div>
                        <div class="col-xs-1"><a class="logInLink" id="logInLink" href="admin"> <div class='fa fa-lock'></div></a></div>
                    </div>
                </sec:authorize>
            </div>

            <div class="row">
                <div class='col-xs-3'></div>
                <div class='col-xs-9'>
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="teamTitle" class="col-sm-2 control-label">Title:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="teamTitle" data-toggle="tooltip" data-placement="bottom" title="Static pages require a title!"  placeholder="Title Required For Static Pages">
                            </div>
                        </div>
                    </form>
                    <div id='summernote'>

                    </div>
                    <div class="row" id="datesRow">
                        <div class="col-xs-6">Go Live date<input id="goLive" type="text" placeholder=" Publish Instantly"></div>
                        <div class="col-xs-6">Expiration Date<input id="expire" type="text" placeholder=" Never Expire"></div>
                    </div>
                    <div class="row">

                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-xs-6"></div>
                            <div class="col-xs-1">Status:</div>
                            <div class="col-xs-4">
                                <select class="form-control" id="statusMenu" name="status">
                                    <option>Post</option>
                                    <option>Pending</option>
                                    <option>Static</option>
                                </select>
                            </div>
                        </sec:authorize>

                        <div class="col-xs-1"><button id="postit" class="btn btn-primary">Save</button></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row postRowSpacer"></div>
        <div id="logInButtons">
            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MARKETING')">
                <div class="row">
                    <div class="col-xs-11"></div>
                    <div class="col-xs-1"><a class="logOutLink" id="logOutLink" href="${pageContext.request.contextPath}/j_spring_security_logout"> <div class="fa fa-lock"></div></a></div>
                </div>
            </sec:authorize>
            <sec:authorize access="not hasAnyRole('ROLE_ADMIN', 'ROLE_MARKETING')">
                <div class="row">
                    <div class="col-xs-11"></div>
                    <div class="col-xs-1"><a class="logInLink" id="logInLink" href="admin"> <div class='fa fa-lock'></div></a></div>
                </div>
            </sec:authorize>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <script src="${pageContext.request.contextPath}/js/teamDadAdmin.js"></script>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_MARKETING')">
            <script src="${pageContext.request.contextPath}/js/teamDadMarketing.js"></script>
        </sec:authorize>   

        <sec:authorize access="not hasAnyRole('ROLE_ADMIN', 'ROLE_MARKETING')">
            <script src="${pageContext.request.contextPath}/js/teamDad.js"></script>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <script src="${pageContext.request.contextPath}/js/teamdadcontent.js"></script>
        </sec:authorize>
        <script src="${pageContext.request.contextPath}/AnimatedHeader/js/modernizr.custom.js"></script>
        <script src="${pageContext.request.contextPath}/AnimatedHeader/js/classie.js"></script>
        <script src="${pageContext.request.contextPath}/AnimatedHeader/js//cbpAnimatedHeader.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
        <script src="${pageContext.request.contextPath}/datetimepicker-master/build/jquery.datetimepicker.full.min.js"></script>


    </body>
</html>
