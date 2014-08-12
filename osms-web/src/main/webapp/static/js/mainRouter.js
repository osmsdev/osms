define( [ 'jquery', 
          'backbone'],
function( $, Backbone) {
	
	var MainRouter = Backbone.Router.extend({
		
		  initialize: function(){
			  
			/*EA.events.off("addAnalytics");
			EA.events.on("addAnalytics", function(userName, publisherName){
				Util.addAnalytics(userName, publisherName);
			});*/
			//Constants.setProp('ishomePageRendered',false);  	
			//Initializer.init();
		  },
		  
		  routes: {
			//"": "showAccountView",
			"": "showLoginView",
			"login" : "showLoginView"
		  },
		  
		  showLoginView: function(){
		      var self = this;
		      if(this.LoginPage){
		    	  this.LoginPage.remove();
		      }
		      
			  require(["Authentication/login/view/LoginView"],
					  function(LoginView){
				  			self.LoginPage = new LoginView();
				  			console.log(self.LoginPage);
				  			$('#content').html(self.LoginPage.$el);
			  });
			  
			  //this.reportingView = undefined;
			    
		  },
		  
		  showDashBoardView: function(){
			  $(".FixedHeader_Header").remove();
			  RefObj.set("dashboard", new DashBoardView());
			  $("#content").html(RefObj.get("dashboard").$el);
			  
			  $(".mainLink li a").removeClass('active');
			  $(".mainLink li:nth-child(1) a").addClass('active');
			  console.log($("#content").find("#advname"));
			 /* setTimeout(function(){$("#advname").html(i18next.t("app.missionCtrl"));}, 1000);*/
			  this.reportingView = undefined;
		  }
		  
		});
	
	return MainRouter;
	

} );