 var chart;
            var data = [
                {
                    "title": "Website visits",
                    "value": 200
                },
                {
                    "title": "Downloads",
                    "value": 123
                },
                {
                    "title": "Requested price list",
                    "value": 98
                },
                {
                    "title": "Contaced for more info",
                    "value": 72
                },
                {
                    "title": "Purchased",
                    "value": 65
                },
                {
                    "title": "Contacted for support",
                    "value": 45
                },
                {
                    "title": "Purchased additional products",
                    "value": 36
                }
			];

            AmCharts.ready(function () {

                chart = new AmCharts.AmFunnelChart();
                chart.rotate = true;
                chart.titleField = "title";
                chart.balloon.fixedPosition = true;
                chart.marginRight = 210;
                chart.marginLeft = 15;
                chart.labelPosition = "right";
                chart.funnelAlpha = 0.9;
                chart.valueField = "value";
                chart.startX = -500;
                chart.dataProvider = data;
                chart.startAlpha = 0;
                chart.depth3D = 100;
                chart.angle = 30;
                chart.outlineAlpha = 1;
                chart.outlineThickness = 2;
                chart.outlineColor = "#FFFFFF";
                chart.write("pydiv");
            });