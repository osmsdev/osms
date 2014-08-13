define([ "jquery", 
         "backbone",
         "underscore",
         "mainRouter",
         "text!Authentication/login/tpl/loginTpl.html",
         "jqueryBlockUI"],
function($, Backbone, _, MainRouter, loginTpl) {
	var view = Backbone.View.extend({
		
		events: {
			  "click  .login-button": "submitLogin",
			  "keypress #userName" : "submitName",
			  "keypress #password" : "submitName"
		},
		
		initialize : function(options) {
			$("body").unblock();
			console.log($(this.el));
			this.tpl = _.template(loginTpl);
			console.log(this.tpl);
			console.log(loginTpl);
			$(this.el).html(loginTpl);
			this.render();
			/*this.listenTo(this.model, "success", this.onSuccess);
			this.listenTo(this.model, "failure", this.onError);*/
		
		},
		
		render : function() {			
			return this;
		},
		
		submitLogin: function(e){
		 	var that = this;
		 	e.preventDefault();

		 	this.$el.find('#loginSubmit').attr("disabled", true);

		 	var formValues = {
		 		username: this.$el.find('#login').val(),
		 		password: this.$el.find('#password').val()
		 	};

		 	$.ajax({
		 		type:'post',
		 		cache:false,
		 		url: window.location.hash + 'rest/api/system/authenticate',	
		 		contentType :"application/x-www-form-urlencoded",
		 		dataType:"json",
		 		data: formValues,
		 		success: function (data) {
		 			    console.log(data);
		 			    if(data.error != undefined){
		 			    	console.log(data.error);
		 			    }else{
		 			    	console.log('sucess');
		 			    	var route = new MainRouter();
				 			route.navigate('home', true);
		 			    }
		 			    
		 		},
		 		error: function(error) {
	            	// TODO
	            	console.log(error);  
		 		},
	            complete: function () {
	            	that.$el.find('#loginSubmit').removeAttr("disabled");
	            }
	        });
		 }
	});
	return view;

});