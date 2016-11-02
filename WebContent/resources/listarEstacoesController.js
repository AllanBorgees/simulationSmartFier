var app = angular.module('app', []);

app.value("urlBase", "http://localhost:8080/simulationSmartFier/rest/");


app
		.controller(
				'listarEstacoesController',
				function($scope, $http, urlBase) {
					$scope.informacoes = null;
					$scope.estacoes = null;
					$scope.dado = null;
					$scope.sensorDadosLista = null;
					$scope.coluna = null;
					$scope.datae = null;
					$scope.datas = null;
					$http.get(urlBase + "estacao/getestacoes").success(
							function(data) {
								// console.log(data);
								$scope.estacoes = data.estacao;

							}).error(function() {
						alert('deu certo, mas cade o resultado');
					});

					$scope.dadosEstacoes = function(idEstacao) {
						$http
								.get(
										urlBase
												+ "estacao/getestacoesfuncionariosensores/"
												+ idEstacao).success(
										function(data) {
											$scope.dado = data;

											console.log("jhgsdhjsghdgsgdshgj");
											
//											window.setInterval('teste()', 6000);
											
											
										}).error(function() {
									alert('deu certo, mas cade o resultado');
								});
					};

					$scope.sensorDados = function(sensor) {
						
						$scope.grandeza = sensor.grandeza;
						console.log("datae " + $scope.datae);
						console.log("datas " + $scope.datas);
						$scope.dataEntrada = $scope.dataConversor($scope.datae
								.toString());
						$scope.dataSaida = $scope.dataConversor($scope.datas
								.toString());
						//						

						
						
						console.log("data entrada " + $scope.dataEntrada);
						console.log("data saida " + $scope.dataSaida);
						// console.log($scope.grandeza);
						$http
								.get(
										urlBase + "dado/getdadossensor/id/"
												+ sensor.sensor_id + "/"
												+ $scope.dataEntrada + "/"
												+ $scope.dataSaida)
								.success(
										function(data) {

											// console.log(data.dados);
											$scope.lineData = [];
											$scope.sensorDadosLista = data.dados;
		//											if($scope.sensorDadosLista==null){
//												$scope.informacoes = "pegou";
//												return
//											}
											
											for (i = 0; i < Object
													.keys($scope.sensorDadosLista).length; i++) {
												temp = [
														epochToData($scope.sensorDadosLista[i]._dtepoch),
														parseInt($scope.sensorDadosLista[i].valor) ];
												$scope.lineData.push(temp);
												console
														.log($scope.sensorDadosLista[i].valor);
											}

											// console.log("###########################3");
											// console.log()

											drawChart($scope.lineData,
													$scope.grandeza);

										}).error(function() {
									console.log("estou no errado");

								});

					};

					$scope.dataConversor = function(date) {
						var nomeMeses = [ 'January', 'February', 'March',
								'April', 'May', 'June', 'July', 'August',
								'September', 'October', 'November', 'December' ]

						var data = date;

						var mes = (data.substr(4, 3));
						for (mesPos in nomeMeses) {

							if (nomeMeses[mesPos].substr(0, 3) == data.substr(
									4, 3)) {
								var mes = nomeMeses[mesPos];
							}
						}
						var ano = (data.substr(0, 4));
						var hora = (data.substr(16, 2));
						var GTM = subtrair(parseInt(hora));
						var dataepoch = new Date(mes + " "
								+ (data.substr(8, 2)) + ", "
								+ (data.substr(12, 4)) + " " + GTM + ":"
								+ (data.substr(19, 2)) + ":00");
						var myEpoch = dataepoch.getTime() / 1000.0;

						return myEpoch.toString();

					};
					

				});

function epochToData(epoch) {
	var contador = 0;
	var nomeMeses = [ 'January', 'February', 'March', 'April', 'May', 'June',
			'July', 'August', 'September', 'October', 'November', 'December' ];

	var reverterDataGTM = new Date(0);
	reverterDataGTM.setUTCSeconds(epoch);
	var dataRevertida = reverterDataGTM.toString();
	var data_Revertid = dataRevertida.substr(4, 11);
	var hora = (parseInt(dataRevertida.substr(16, 2))) + 3;
	// alert(hora);

	for (nome in nomeMeses) {
		// alert((nomeMeses[nome]));
		// alert(dataRevertida.substr(4, 3));
		// alert("Entrou");
		var mes = 0;
		if ((nomeMeses[nome].substr(0, 3)) == dataRevertida.substr(4, 3)) {
			// alert((nome.substr(0, 3)));
			// alert(dataRevertida.substr(4, 3));
			var mes = contador;
			var contador = 0;
			if (mes + 1 >= 0 && mes + 1 <= 9) {
				var numeroMes = '0' + (mes + 1).toString();

			} else {
				var numeroMes = (mes + 1).toString()

			}

		} else {
			contador += 1;

		}

	}

	var dataConvertida = dataRevertida.substr(8, 2) + '/' + numeroMes + '/'
			+ dataRevertida.substr(11, 4) + " - " + hora.toString()
			+ dataRevertida.substr(18, 6);
	return dataConvertida
}

function subtrair(valorHora) {
	var horas = [ 00, 01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 14,
			15, 16, 17, 18, 19, 20, 21, 22, 23, 24 ];
	if (valorHora == 00) {
		return '21';
	} else if (valorHora == 01) {
		return '22';
		
	} 
	else if (valorHora == 02) {
		return '23';
	}else {
		conversor = horas[valorHora] - 03
		if (conversor >= 0 && conversor <= 9) {
			return "0" + conversor.toString()
		} else {
			return conversor.toString()
		}
	}
}

