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