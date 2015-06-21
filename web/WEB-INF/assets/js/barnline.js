 AmCharts.makeChart("bardiv", {
                type: "serial",
                theme: "dark",
                dataProvider: [{
                    "year": 2005,
                        "income": 23.5,
                        "expenses": 18.1
                }, {
                    "year": 2006,
                        "income": 26.2,
                        "expenses": 22.8
                }, {
                    "year": 2007,
                        "income": 30.1,
                        "expenses": 23.9
                }, {
                    "year": 2008,
                        "income": 29.5,
                        "expenses": 25.1
                }, {
                    "year": 2009,
                        "income": 24.6,
                        "expenses": 25
                }],
                categoryField: "year",
                startDuration: 1,
                rotate: true,

                categoryAxis: {
                    gridPosition: "start"
                },
                valueAxes: [{
                    position: "top",
                    title: "Million USD",
                    minorGridEnabled: true
                }],
                graphs: [{
                    type: "column",
                    title: "Income",
                    valueField: "income",
                    fillAlphas:1,
                    balloonText: "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b></span>"
                }, {
                    type: "line",
                    title: "Expenses",
                    valueField: "expenses",
                    lineThickness: 2,
                    bullet: "round",
                    balloonText: "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b></span>"
                }],
                legend: {
                    useGraphSettings: true
                },

                creditsPosition:"top-right"

            });