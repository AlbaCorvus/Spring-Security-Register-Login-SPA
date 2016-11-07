(function () {
    var app = angular.module("formShuffle", ["ngRoute"]);

    var config = function ($routeProvider) {
        $routeProvider
        .when("/register", {
            templateUrl: "/RecruitmentSpring/recruitment/register"
        })
        .when("/enter",
        { templateUrl: "/RecruitmentSpring/recruitment/loginform" })
        .otherwise({ redirectTo: "/register" });
    }
    app.config(config);

}());