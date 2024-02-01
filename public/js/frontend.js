// JavaScript Document

jQuery(document).ready(function($){
	"use strict";
	$('.fg-gallery-caption').on('mouseover mouseout', function(event) {
			if (event.type == 'mouseover') {
				$(this).parents('.fastgallery-gallery-icon').find('.fg_zoom').addClass('fg_over');
				return false;
			} else {
				$(this).parents('.fastgallery-gallery-icon').find('.fg_zoom').removeClass('fg_over');
				return false;				
			}
			
	});
	
	$('.FGM-Collage .fg-gallery-caption').on('mouseover mouseout', function(event) {
			if (event.type == 'mouseover') {
				$(this).parents('.gallery-icon').find('.fg_zoom').addClass('fg_over');
				return false;
			} else {
				$(this).parents('.gallery-icon').find('.fg_zoom').removeClass('fg_over');
				return false;				
			}
			
	});
	
});