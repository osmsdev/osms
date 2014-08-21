define([
  'jquery',
  'underscore',
  'backbone',
  'text!LeftNavigation/tpl/leftNavigation.html'
], function($, _, Backbone, leftNavigationTpl){

  var LeftNavigationView = Backbone.View.extend({
    events: {
      "mouseenter .navLinkWrap": "onMouseEnter",
      "mouseleave .navLinkWrap": "onMouseLeave"
    },

    initialize: function(options){
      this.options = options;
      this.render();
    },

    render: function(){
      $("body").unblock();	
      this.$el.empty().html("");
      this.$el.append(_.template(leftNavigationTpl));
    },

      // Add the active class in the current navigation item page
      setActiveClass: function(index) {
        $(".mainLink li a").removeClass('active');
        $(".mainLink li:nth-child(" + index + ") a").addClass('active');
      },

    onMouseEnter: function(){
      $(".navLinkWrap").stop().animate({width:'221px'},500);
    },

    onMouseLeave: function(event){
      $(".navLinkWrap").stop().animate({width:'50px'},500);     
    },

  });

  return LeftNavigationView;
  
});
