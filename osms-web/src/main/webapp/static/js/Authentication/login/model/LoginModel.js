define( [
	'jquery', 'backbone', 'underscore'
],
function($, Backbone, _) {
	var Model = Backbone.Model.extend({
		
		fetch : function(options) {         
           var self = this;
		   var config = {
				   type: 'post',
                   cache: false,
                   url: "newLogin.htm",
                   data: jQuery("#login").serialize(),
                   success : function(response){
                	 self.trigger('success',response);
                   },
                   error:function(response){
                	 self.trigger('failure',response);
                   }
                   };	
			
           Backbone.Model.prototype.fetch.apply(this, [config]);    
           
        },
		
		parse: function(record) {
			return record;
		}
		
	});
	
	return Model;
});
