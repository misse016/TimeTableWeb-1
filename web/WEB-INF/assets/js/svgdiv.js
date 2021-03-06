var chart;

            var chartData = [
                {
                    "name": "John",
                    "startTime": 8,
                    "endTime": 11,
                    "color": "#FF0F00"
                },
                {
                    "name": "Joe",
                    "startTime": 10,
                    "endTime": 13,
                    "color": "#FF9E01"
                },
                {
                    "name": "Susan",
                    "startTime": 11,
                    "endTime": 18,
                    "color": "#F8FF01"
                },
                {
                    "name": "Eaton",
                    "startTime": 15,
                    "endTime": 19,
                    "color": "#04D215"
                }
            ];


            AmCharts.ready(function () {
                // SERIAL CHART
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "name";
                chart.rotate = true;
                chart.columnWidth = 0.9;
                chart.startDuration = 1;

                // AXES
                // Category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.gridAlpha = 0.1;
                categoryAxis.axisAlpha = 0;
                categoryAxis.gridPosition = "start";

                // Value
                var valueAxis = new AmCharts.ValueAxis();
                valueAxis.gridAlpha = 0.1;
                valueAxis.axisAlpha = 0;
                valueAxis.unit = ":00";
                chart.addValueAxis(valueAxis);

                // GRAPH
                var graph = new AmCharts.AmGraph();
                graph.valueField = "endTime";
                graph.openField = "startTime";
                graph.type = "column";
                graph.lineAlpha = 0;
                graph.colorField = "color";
                graph.fillAlphas = 0.8;
                graph.balloonText = "<b>[[category]]</b><br>starts at [[startTime]]:00<br>ends at [[endTime]]:00";
                chart.addGraph(graph);

                chart.creditsPosition = "top-right";

                // WRITE
                chart.write("barfloatdiv");
            });