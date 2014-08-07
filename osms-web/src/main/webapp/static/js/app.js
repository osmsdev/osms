require.config({
	//By default load any module IDs from js/lib
    //baseUrl: 'static/js',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
	"waitSeconds": 60, 
	/*"urlArgs": "bust="+document.getElementById('version').value,*/
	paths: {
    	"jquery": "lib/jquery-1.8.3.min",
    	"underscore": "lib/lodash.underscore.min",
        "backbone": "lib/backbone-min",
        "mainRouter" : "mainRouter",
        "jqueryBlockUI": "lib/jquery.blockUI",
        "text": "plugins/text",
        "domReady": "plugins/domReady",
        "bootStrap": "lib/bootstrap"
    },
    shim: {
        backbone: {
            deps: ['jquery', 'underscore'],
            exports: 'Backbone'
        },
        underscore: {
            exports: '_'
        },
        jqueryBlockUI: {
			"deps":["jquery"],
			"exports": "jqueryBlockUI"
		}
    }
    	
});


require(["jquery", "domReady", "jqueryBlockUI"], 
		function($, domReady) {
    
	domReady(function () {
		
		$("body").block({ message: '<div class="loader"></div>', overlayCSS: { width: "100%", height: "100%" }, css: { width:	'128px',backgroundColor:'',border:'0px solid #aaa',top:'250px', cursor: 'default'},centerX: true,centerY: false});
		
		require(["main"], function(Main){
			Main.init();
		});
		
	});
	
});