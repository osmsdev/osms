define(function (require) {
    var $ = require('jquery'),
        backbone = require('backbone'),
        underscore = require('underscore'),
        text = require('text'),
        LoginModel = require('Authentication/login/model/LoginModel'),
        LoginView = require('Authentication/login/view/LoginView');

    $(function () {
    
        new LoginView({
        	model: new LoginModel(),
        	el : "#login"
        });
        
    });
});
