var app = angular.module('app', []);

// ============================================================
// Services
// ============================================================
app.service('ValidationService', function() {
	
	var factory = {}; 
	 
    factory.isValidPage = function(data) {
		
		var $ = angular.element,
			$form = $('.form:first');
		
		// Clear elements
		$form.find('.validation.message').remove();
		var $formElements = $.find('input[type=text], input[type=radio], input[type=checkbox], select, textarea');
		$.each($formElements, function(i, el) {
			$(el).removeClass('invalid');
		});
		
		// Set errors
		if(data.errors) {
			$.each(data.errors, function(i, error) {
				var $errField = $('#' + error.field);
				if(i === 0) {
					$errField.focus();
				}
				
				$errField.addClass('invalid');
				$('<div class="validation message">' + error.message + '</div>').insertBefore($errField);
				
			});
		}
		
		return !data.errors
	};
 
    return factory;
});

//============================================================
// Factories
//============================================================
// ...

//============================================================
// Directives
//============================================================
// ...