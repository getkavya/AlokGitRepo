angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.post('http://localhost:9085/greeting?name=Alok Mahehswari').
        then(function(response) {
            $scope.greeting = response.data;
        });
});
