app.controller('CreateNgController', ['$scope','$http', 'ValidationService', function HomeNgController($scope, $http, ValidationService) {
	
	$scope.cv = {};
	
	// load the languages
	$http.get('/cvportal/rest/languages/').success(function(languages){
		$scope.languages = languages;
		_checkLanguage();
	});
	
	// Create it!
	$scope.create = function() {
		
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
    		
    		_checkLanguage();
        })
        .error(function(data) {
        	// ... 
        	_checkLanguage();
        });
	};
	
	function _checkLanguage() {
		$scope.cv.language = $scope.cv.language === undefined ? $scope.languages[0] : $scope.cv.language;
	}
	
}]);