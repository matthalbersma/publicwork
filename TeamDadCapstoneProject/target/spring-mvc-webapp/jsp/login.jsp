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
        <title>Sad Dad Tech Blog</title>
        <meta name="description" content="Blueprint: On-Scroll Animated Header" />
        <meta name="keywords" content="fixed header, animatied header, javascript, wed design, template, on scroll" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/teamDad.css" rel="stylesheet">
        <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/datetimepicker-master/build/jquery.datetimepicker.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/AnimatedHeader/css/component.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/AnimatedHeader/css/default.css" rel="stylesheet">
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
                    <h1>Sad Dad Tech Blog</h1>
                    <nav>
                        <a href="home"><h2 class="fa fa-home"></h2></a>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="post">Create Post</a>
                            <div class="hold"></div>
                        </sec:authorize>
                            
                        <sec:authorize access="hasRole('ROLE_MARKETING')">
                            <a href="post">Create Marketing Post</a>
                        </sec:authorize>
                    </nav>
                </div>
            </div>

            <header class="clearfix">
            </header>	

            <div class="main">
                <div class="logInDiv" id="logInDiv">
                    <div class="row">
                        <div class="col-xs-12"><c:if test="${param.login_error == 1}">
                                <p class="invalidLogin">Invalid username or password.<p>
                                </c:if>
                        </div>
                    </div>
                    <form method="post" class="signin" action="j_spring_security_check">
                        <fieldset>
                            <div class="row">
                                <div class="col-xs-3"></div>    
                                <div class="col-xs-2 loginLabel">Username</div> 
                                <div class="col-xs-4">
                                    <input id="username_or_email"
                                           name="j_username"
                                           type="text"
                                           class="form-control"/>
                                </div>
                                <div class="col-xs-3"></div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-xs-3"></div>
                                <div class="col-xs-2 loginLabel">Password</div>
                                <div class="col-xs-4">
                                    <input id="password"
                                           name="j_password"
                                           type="password"
                                           class="form-control"/>
                                </div>
                                <div class="col-xs-3"></div>
                            </div>
                            <br>
                            <div class='row'>
                                <div class="col-xs-6"></div>
                                <div class="col-xs-6"><input id='signInBtn' name="commit" type="submit" value="Sign In" />
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/AnimatedHeader/js/modernizr.custom.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/AnimatedHeader/js/classie.js"></script>
        <script src="${pageContext.request.contextPath}/AnimatedHeader/js//cbpAnimatedHeader.min.js"></script>
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
    </body>
</html>

