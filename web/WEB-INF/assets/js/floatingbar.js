var chart;

            var chartData = [
                {
                    "country": "Czech Republic",
                    "litres": 156.9,
                    "short": "CZ"
                },
                {
                    "country": "Ireland",
                    "litres": 131.1,
                    "short": "IR"
                },
                {
                    "country": "Germany",
                    "litres": 115.8,
                    "short": "DE"
                },
                {
                    "country": "Australia",
                    "litres": 109.9,
                    "short": "AU"
                },
                {
                    "country": "Austria",
                    "litres": 108.3,
                    "short": "AT"
                },
                {
                    "country": "UK",
                    "litres": 99,
                    "short": "UK"
                },
                {
                    "country": "Belgium",
                    "litres": 93,
                    "short": "BE"
                }
            ];

            AmCharts.ready(function () {
                // SERIAL CHART
                var chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "country";
                chart.startDuration = 2;
                // change balloon text color
                chart.balloon.color = "#000000";

                // AXES
                // category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.gridAlpha = 0;
                categoryAxis.axisAlpha = 0;
                categoryAxis.labelsEnabled = false;

                // value
                var valueAxis = new AmCharts.ValueAxis();
                valueAxis.gridAlpha = 0;
                valueAxis.axisAlpha = 0;
                valueAxis.labelsEnabled = false;
                valueAxis.minimum = 0;
                chart.addValueAxis(valueAxis);

                // GRAPH
                var graph = new AmCharts.AmGraph();
                graph.balloonText = "[[category]]: [[value]]";
                graph.valueField = "litres";
                graph.descriptionField = "short";
                graph.type = "column";
                graph.lineAlpha = 0;
                graph.fillAlphas = 1;
                graph.fillColors = ["#ffe78e", "#bf1c25"];
                graph.labelText = "[[description]]";
                graph.balloonText = "[[category]]: [[value]] Litres";
                chart.addGraph(graph);

                chart.creditsPosition = "top-right";

                // WRITE
                chart.write("barfloatdiv");
            });