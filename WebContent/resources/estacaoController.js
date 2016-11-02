var app = angular.module('app', []);

app.value("urlBase", "http://localhost:8080/simulationSmartFier/rest/estacao/id/");

app.controller('estacaoController', function($scope, $http, urlBase) {

	$scope.estacoes = null;
	$scope.sensores = null;
	$scope.funcionario = null;
	$scope.dados = null;
	$http.get(urlBase + "estacao000").success(function(data) {
		console.log(data);
	}).error(function() {
		alert('deu certo, mas cade o resultado');
	});

});