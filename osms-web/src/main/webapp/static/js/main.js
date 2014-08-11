define(["jquery", "backbone", "mainRouter", "domReady", "jqueryBlockUI" ], 
		function($, Backbone, MainRouter, domReady) {
    
		var _init = function(){
	
			$("body").block({ message: '<div class="loader"></div>', overlayCSS: { width: "100%", height: "100%" }, css: { width:	'128px',backgroundColor:'',border:'0px solid #aaa',top:'250px', cursor: 'default'},centerX: true,centerY: false});
			
			                var mainRouter = new MainRouter();
				        	/*ReferenceObj.setRouter(mainRouter);*/
				        	// Start the history 
				        	// using HTML5 push state
				        	Backbone.history.start();
				        	mainRouter = null; 			
				};
		
		
		return {
			init: _init
		};	
	
	
});