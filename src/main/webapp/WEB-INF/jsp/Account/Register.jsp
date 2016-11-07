
<div ng-controller="FormController">
<div class="registry-form-holder">
    <form name="login-form" action="${pageContext.request.contextPath}/recruitment/newregisterinfo" method='GET'>

        <section>
            <b>Register Here</b>
        </section>
        <section>

        <label>Username:</label>
            </section>
            <section>
        <input type="text" id="registerusername" name="username"/>
        <p class="registernameerror"></p>
        </section>
        <section>
        <label>Email</label>
            </section>
        <section>
        <input type="text" id="registeremail" name="email"/>
        <p class="registeremailerror"></p>
        </section>
        <input type="submit" value="Sign Up" disabled="disabled"/>
        <a href="/">Cancel</a>


        </form>

    </div>

    </div>