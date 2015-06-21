 AmCharts.makeChart("linegraphdiv", {

                type: "serial",
                dataProvider: [{
                    "date": "2012-01-01",
                        "value": 8
                }, {
                    "date": "2012-01-01",
                        "value": 8
                }, {
                    "date": "2012-01-02",
                        "value": 10
                }, {
                    "date": "2012-01-03",
                        "value": 12
                }, {
                    "date": "2012-01-04",
                        "value": 14
                }, {
                    "date": "2012-01-05",
                        "value": 11
                }, {
                    "date": "2012-01-06",
                        "value": 6
                }, {
                    "date": "2012-01-07",
                        "value": 7
                }, {
                    "date": "2012-01-08",
                        "value": 9
                }, {
                    "date": "2012-01-09",
                        "value": 13
                }, {
                    "date": "2012-01-10",
                        "value": 15
                }, {
                    "date": "2012-01-11",
                        "value": 19
                }, {
                    "date": "2012-01-12",
                        "value": 21
                }, {
                    "date": "2012-01-13",
                        "value": 22
                }, {
                    "date": "2012-01-14",
                        "value": 20
                }, {
                    "date": "2012-01-15",
                        "value": 18
                }, {
                    "date": "2012-01-16",
                        "value": 14
                }, {
                    "date": "2012-01-17",
                        "value": 16
                }, {
                    "date": "2012-01-18",
                        "value": 18
                }, {
                    "date": "2012-01-19",
                        "value": 17
                }, {
                    "date": "2012-01-20",
                        "value": 15
                }, {
                    "date": "2012-01-21",
                        "value": 12
                }, {
                    "date": "2012-01-22",
                        "value": 10
                }, {
                    "date": "2012-01-23",
                        "value": 8
                }],

                pathToImages: "../amcharts/images/",

                dataDateFormat: "YYYY-MM-DD",
                categoryField: "date",


                categoryAxis: {
                    parseDates: true,
                    minPeriod: "DD",
                    gridAlpha: 0.1,
                    minorGridAlpha: 0.1,
                    axisAlpha: 0,
                    minorGridEnabled: true,
                    inside: true
                },

                valueAxes: [{

                    tickLength: 0,
                    axisAlpha: 0,
                    showFirstLabel: false,
                    showLastLabel: false,

                    guides: [{
                        value: 10,
                        toValue: 20,
                        fillColor: "#00CC00",
                        inside: true,
                        fillAlpha: 0.2,
                        lineAlpha: 0
                    }]

                }],


                graphs: [{
                    lineColor: "#00CC00",
                    valueField: "value",
                    dashLength: 3,
                    bullet: "round",
                    balloonText: "[[category]]<br><b><span style='font-size:14px;'>value:[[value]]</span></b>"
                }],

                chartCursor: {},
                chartScrollbar: {},

                mouseWheelZoomEnabled:true,

                trendLines: [{
                    initialDate: new Date(2012, 0, 2, 12),
                    finalDate: new Date(2012, 0, 11, 12),
                    initialValue: 10,
                    finalValue: 19,
                    lineColor: "#CC0000"
                },
                {
                    initialDate: new Date(2012, 0, 17, 12),
                    finalDate: new Date(2012, 0, 22, 12),
                    initialValue: 16,
                    finalValue: 10,
                    lineColor: "#CC0000"
                }]
            });