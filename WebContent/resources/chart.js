google.charts.load('current', {
	'packages' : [ 'line' ]
});
google.charts.setOnLoadCallback(drawChart);

function drawChart(dadosSensor, grandeza) {

	rows = dadosSensor;
	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Data');
	data.addColumn('number', grandeza);

	if (rows == null) {
		data.addRows([ [ "1", 4 ] ]);
	} else {
		console.log("estou no drawchart");
		console.log(rows);
		data.addRows(rows);
	}

	var options = {
		chart : {
			title : 'Gráfico de ' + grandeza
		// subtitle : 'dollars (USD)'
		},
		width : 900,
		height : 500,
		axes : {
			x : {
				0 : {
					side : 'bottom'
				}

			}
		
		}
		
	};

	var chart = new google.charts.Line(document.getElementById('line_top_x'));

	chart.draw(data, options);
}
