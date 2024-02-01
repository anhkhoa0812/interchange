(function(gravityformsautoplaceholders, $, undefined) {
	function init(){
		create_placeholders();
		add_modernizr_placeholders_for_ie();
	}

	function add_modernizr_placeholders_for_ie() {
		if(!Modernizr.input.placeholder){$("input,textarea").each(function(){if($(this).val()=="" && $(this).attr("placeholder")!=""){$(this).val($(this).attr("placeholder"));$(this).focus(function(){if($(this).val()==$(this).attr("placeholder")) $(this).val("");});$(this).blur(function(){if($(this).val()=="") $(this).val($(this).attr("placeholder"));});}});}
	}

	function create_placeholders() {
		var scope = gravityformsautoplaceholders.class_specific ? '.gfap_placeholder' : '.gform_wrapper';
		create_placeholders_from_gravity_form_labels(scope);
	}

	function create_placeholders_from_gravity_form_labels(scope) {
		$('input[type="text"], textarea', scope).each(function(){
			var self = $(this);
			var id = self.attr('id');
			var form = self.parents('form');
			var label = form.find('label[for="' + id + '"]');
			if (label.length) {
				var text = label.last().text();
				var container_text = self.parents('.gfield').eq(0).find('label').first().text();
				if (text === 'First' && text !== container_text) {
					text = 'First ' + container_text;
				}
				else if (text === 'Last' && text !== container_text) {
					text = 'Last ' + container_text;
				}
				self.attr('placeholder', text);
				label.hide();
			}
		});
	}

	$(document).ready(function(){
		init();
	});
}(window.gravityformsautoplaceholders = window.gravityformsautoplaceholders || {}, jQuery));