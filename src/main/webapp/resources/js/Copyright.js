$(document).ready(function () {
    copyrightdiv = document.createElement("div");
    copyrightdiv.innerHTML="<b>&#64;Copyright Chris Mulcahy 2016</b>";
    copyrightdiv.setAttribute("id", "copyright");
    copyrightdiv.style.display="none";
    document.getElementById("login-side-bar").appendChild(copyrightdiv);
    $(copyrightdiv).fadeIn(4000);
});