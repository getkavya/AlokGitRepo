angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:9085/greeting?name=Alok Mahehswari').
        then(function(response) {
            $scope.greeting = response.data;            
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            next();
           });
});
