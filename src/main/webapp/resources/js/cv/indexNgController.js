app.controller('IndexNgController', ['$scope','$http', function HomeNgController($scope, $http) {
	$http.get('/cvportal/rest/cvs')
		.success(function(cvs){
			$scope.cvs = cvs;
		});
}]);