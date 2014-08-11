define([ "jquery", 
         "backbone",
         "underscore",
         "text!Authentication/login/tpl/loginTpl.html",
         "jqueryBlockUI"],
function($, Backbone, _, loginTpl) {
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
			/*this.listenTo(this.model, "success", this.onSuccess);
			this.listenTo(this.model, "failure", this.onError);*/
		
		},
		
		render : function() {			
			return this;
		},
		
		submitLogin: function(event){
			this.model.fetch();
			
			$("body").block({
				message: '<div class="loader"></div>',
				overlayCSS: {
					width: "100%",
					height: "100%"
				},
				css: {
					width: '128px',
					cursor: 'default',
					backgroundColor: '',
					border: '0px solid #aaa',
					top: '78px'
				},
				centerX: true,
				centerY: false
			});
		},
		
		submitName : function(event){			
			  if(event.keyCode == 13){				 
			    $('#submit').click();
			  }
		},
		
		onError:function(model, response, options){
			if(response.attributes.errors[0].messages[0].code == "F"){
				$("#p").html(response.attributes.errors[0].messages[0].message);
				$("#p").show();
				$("body").unblock();
			}
		},
		
		onSuccess:function(response){
			if(response.attributes.code == "F"){
				$("#p").html(response.attributes.status);
				$("#p").show();
				$("body").unblock();
			}else if(response.attributes.code == "S"){
				location.href= 'home.htm';
				$("body").unblock();
			}
		}
		
	});
	return view;

});