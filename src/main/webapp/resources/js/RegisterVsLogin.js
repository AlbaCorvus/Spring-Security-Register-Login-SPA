$(document).ready(function () {
    
    document.getElementsByClassName("slider")[0].addEventListener("click", function () {
        if (document.getElementById("usercheckbox").checked == true) {
            $(".slider").children().css({float :"right",marginRight :"10px"});
            $(".slider").children().html("New User");
            window.location.href="login#/register";
        }
        else {
            $(".slider").children().css({float :"left",marginLeft : "10px"});
            $(".slider").children().html("Login");
            window.location.href="login#/enter";
        }
    });

    
    
});