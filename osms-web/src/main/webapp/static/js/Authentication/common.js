//The build will inline common dependencies into this file.

//For any third party dependencies, like jQuery, place them in the lib folder.

//Configure loading modules from the lib directory,
//except for 'app' ones, which are in a sibling
//directory.
requirejs.config({
    baseUrl: 'static/js',
    paths: {
    	"jquery": "lib/jquery-1.8.3.min",
    	"underscore": "lib/underscore-min",
        "backbone": "lib/backbone-min",
        "jqueryBlockUI": "lib/jquery.blockUI"
    },
    shim: {
        backbone: {
            deps: ['jquery', 'underscore'],
            exports: 'Backbone'
        },
        underscore: {
            exports: '_'
        },
        "jqueryBlockUI": {
			"deps":["jquery"],
			"exports": "jqueryBlockUI"
		}
    }
});