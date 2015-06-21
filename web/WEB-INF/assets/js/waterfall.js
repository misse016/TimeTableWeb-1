 var chart;

            var chartData = [
                {
                    "name": "Income A",
                    "open": 0,
                    "close": 11.13,
                    "color": "#54cb6a",
                    "balloonValue": 11.13
                },
                {
                    "name": "Income B",
                    "open": 11.13,
                    "close": 15.81,
                    "color": "#54cb6a",
                    "balloonValue": 4.68
                },
                {
                    "name": "Total Income",
                    "open": 0,
                    "close": 15.81,
                    "color": "#169b2f",
                    "balloonValue": 15.81
                },
                {
                    "name": "Expenses A",
                    "open": 12.92,
                    "close": 15.81,
                    "color": "#cc4b48",
                    "balloonValue": 2.89
                },
                {
                    "name": "Expenses B",
                    "open": 8.64,
                    "close": 12.92,
                    "color": "#cc4b48",
                    "balloonValue": 4.24
                },
                {
                    "name": "Revenue",
                    "open": 0,
                    "close": 8.64,
                    "color": "#1c8ceb",
                    "balloonValue": 11.13
                }
            ];


            AmCharts.ready(function () {
                // Waterfall chart is a simple serial chart with some specific settings
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "name";
                chart.columnWidth = 0.6;
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
                chart.addValueAxis(valueAxis);

                // GRAPH                          
                var graph = new AmCharts.AmGraph();
                graph.valueField = "close";
                graph.openField = "open";
                graph.type = "column";
                graph.lineAlpha = 1;
                graph.lineColor = "#BBBBBB";
                graph.colorField = "color";
                graph.fillAlphas = 0.8;
                graph.balloonText = "<span style='color:[[color]]'>[[category]]</span><br><span style='font-size:13px;'><b>$[[balloonValue]] Mln</b></span>";
                graph.labelText = "$[[balloonValue]]";
                chart.addGraph(graph);

                // Trend lines used for connectors
                var trendLine = new AmCharts.TrendLine();
                trendLine.initialCategory = "Income A";
                trendLine.finalCategory = "Income B";
                trendLine.initialValue = 11.13;
                trendLine.finalValue = 11.13;
                trendLine.lineColor = "#888888";
                trendLine.dashLength = 3;
                chart.addTrendLine(trendLine);

                trendLine = new AmCharts.TrendLine();
                trendLine.initialCategory = "Income B";
                trendLine.finalCategory = "Expenses A";
                trendLine.initialValue = 15.81;
                trendLine.finalValue = 15.81;
                trendLine.lineColor = "#888888";
                trendLine.dashLength = 3;
                chart.addTrendLine(trendLine);

                trendLine = new AmCharts.TrendLine();
                trendLine.initialCategory = "Expenses A";
                trendLine.finalCategory = "Expenses B";
                trendLine.initialValue = 12.92;
                trendLine.finalValue = 12.92;
                trendLine.lineColor = "#888888";
                trendLine.dashLength = 3;
                chart.addTrendLine(trendLine);

                trendLine = new AmCharts.TrendLine();
                trendLine.initialCategory = "Expenses B";
                trendLine.finalCategory = "Revenue";
                trendLine.initialValue = 8.64;
                trendLine.finalValue = 8.64;
                trendLine.lineColor = "#888888";
                trendLine.dashLength = 3;
                chart.addTrendLine(trendLine);

                // WRITE                  
                chart.write("waterdiv");
            });