<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/css/Login.css" />"
	rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
	<script
         src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular.js"></script>
       <script
         src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-route.js"></script>
        <script src="<c:url value="/resources/js/FadeInRegisterForm.js"/>"></script>
        <script src="<c:url value="/resources/js/Copyright.js"/>"></script>
        <script src="<c:url value="/resources/js/RegisterVsLogin.js"/>"></script>
        <script src="<c:url value="/resources/js/formShuffle.js"/>"></script>
        <script src="<c:url value="/resources/js/FormController.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-ui-1.10.3.custom.min.js"/>"></script>
        <script src="<c:url value="/resources/js/Utilities.js"/>"></script>


<title>Login Page</title>

</head>
<body>



        <div class="slide-viewer">
          <div class="slide-group">
            <div class="slide slide-1">
              <img src="http://alittleadrift.com/wp-content/uploads/2010/01/typing-laptop.jpg" alt="No two are the same" />
            </div>
            <div class="slide slide-2">
              <img src="http://luxurybusla.com/wp-content/uploads/2016/02/Black-Laptop-on-Simple-Counter-front-White-Chair-on-Grey-Hardwood-Floors-plus-Human-Picture-and-Glass-Window-beside-Red-Painting-on-Wall.jpg" alt="Monsieur Mints"  />
            </div>
            <div class="slide slide-3">
              <img src="http://previews.123rf.com/images/ouhdesire/ouhdesire1501/ouhdesire150100018/35305652-Laptop-with-blank-notepad-and-pencil-with-sheets-of-crumpled-paper-on-old-wooden-table-Top-view-of-w-Stock-Photo.jpg" alt="The Flower Series"  />
            </div>
            <div class="slide slide-4">
              <img src="http://tech.firstpost.com/wp-content/uploads/2015/12/Image221.jpg" alt="Salt o' The Sea"  />
            </div>
          </div>
        </div>
        <div class="slide-buttons"></div>

        <div class="filter-white">

<div data-ng-app="formShuffle">
    <ng-view></ng-view>
</div>
    <div id="login-side-bar">

        <div id="logo-holder"></div>
        <div id="login-content">
            <p>Login or register <br/> for Recruitment Inc.</p>
        </div>
        <div id="login-options">
            <table class="login-table" cellspacing="15">
                <tr><td><a href="/Account/Register">Register here.</a></td><td><a href="/Account/Login">Login here.</a></td></tr>
            </table>
        </div>
        <div class="spacing"></div>
        <div id="switch-container">
        <label class="switch">
            <input id="usercheckbox" type="checkbox">
            <div class="slider round"><p>New User</p></div>
        </label>
            </div>
        </div>

</div>

<script src="<c:url value="/resources/js/Slider.js"/>"></script>
<script src="<c:url value="/resources/js/Validation.js"/>"></script>
<script src="<c:url value="/resources/js/LoginValidation.js"/>"></script>
<script src="<c:url value="/resources/js/CheckNameAjax.js"/>"></script>

</body>
</html>