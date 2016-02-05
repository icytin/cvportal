app.controller('EditNgController', ['$scope','$http', '$location', 'ValidationService', function EditNgController($scope, $http, $location, ValidationService) {
	
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
	
	// Save it
	$scope.save = function() {
		
		// Adjustments
		$scope.cv.travelability = parseInt($scope.cv.travelability);
		$scope.cv.language = $scope.cv.language.id;
		
        $http({
            method : 'POST',
            url : '/cvportal/rest/cv',
            data : $scope.cv
        })
        .success(function(data) {
    		if(ValidationService.isValidPage(data)) {
    			window.location = '/cvportal';
    		}
        })
        .error(function(data) {
        	// ... 
        });
	};	
}]);