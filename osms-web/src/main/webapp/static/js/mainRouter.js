define( [ 'jquery', 
          'backbone',
          'LeftNavigation/views/LeftNavigationView'],
function( $, Backbone, LeftNavigationView) {
	
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
			"login" : "showLoginView",
			"home" : "showDashBoardView"
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
			  var leftNavigationView = new LeftNavigationView();
			  $('#content').html(leftNavigationView.$el);
		  }
		  
		});
	
	return MainRouter;
	

} );