define([ "jquery", 
         "backbone",
         "underscore",
         "mainRouter",
         "text!Authentication/login/tpl/loginTpl.html",
         "jqueryBlockUI"],
function($, Backbone, _, MainRouter, loginTpl) {
	var view = Backbone.View.extend({
		
		events: {
			  "click  #submit": "submitLogin",
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
		 		name: this.$el.find('#email').val(),
		 		password: this.$el.find('#password').val()
		 	};
		 	
		 	window.loaderOn();

		 	$.ajax({
		 		url: window.config.url_prefix + 'rest/ws/login',
		 		type:'POST',
		 		dataType:"json",
		 		data: JSON.stringify(formValues),
		 		success: function (data) {
		 				/*var user =  new UserModel(data.data);
		 				user.initBusinessUnit();
		 				user.saveLocalStorage();
		 				LocalStorage.set('bu', user.get('businessUnit'));
		 				window.loaderOff();*/	
		 				MainRouter.navigate('home', true);
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