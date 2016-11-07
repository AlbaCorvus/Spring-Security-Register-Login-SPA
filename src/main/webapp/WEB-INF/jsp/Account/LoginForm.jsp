<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div ng-controller="FormController"> <!-- FormController for angularjs returns this view when url is proc -->
 <div id="login-box">



        <!-- validation form for spring security check -->
		<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
            <section>
                       <b>Login Here</b>
                   </section>
                   <section>

                   <label>Username:</label>
                       </section>
                       <section>
                   <input id="loginusername" type="text" name="username"/> <!-- name=username important! for security.xml spring filter to pick up this value -->
                   <p class="loginnameerror"></p>
                   </section>
                   <section>
                   <label>Password</label>
                       </section>
                   <section>
                   <input id="loginpassword" type="password" name="password"/>  <!-- name=password important! for security.xml spring filter to pick up this value -->
                   </section>
                   <input type="submit" value="Login" disabled="disabled"/>
                   <a href="/">Cancel</a>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>

	</div>
	</div>