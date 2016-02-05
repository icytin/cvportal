app.controller('HandleNgController', ['$scope','$http', '$location', 'ValidationService', function HandleNgController($scope, $http, $location, ValidationService) {
	
	var parts = $location.absUrl().split('/'),
		id = parts[parts.length - 1];
	
	// Load the cv
	$http.get('/cvportal/rest/cv/' + id)
		.success(function(cv){
			$scope.cv = cv;
			
			// load the languages
			$http.get('/cvportal/rest/languages/')
			.success(function(languages){
				$scope.languages = languages;
			});
			
		});
	
}]);