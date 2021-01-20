var ctx = document.getElementById("linechart");
if (ctx !== null) {
  var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: "line",

    // The data for our dataset
    data: {
      labels: [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec",
      ],
      datasets: [
        {
          label: "",
          backgroundColor: "transparent",
          borderColor: "rgb(82, 136, 255)",
          // tong tien trong tung thang
          data: [
            100,
            11000,
            10000,
            14000,
            11000,
            17000,
            14500,
            18000,
            5000,
            23000,
            14000,
            19000,
          ],
          lineTension: 0.3,
          pointRadius: 5,
          pointBackgroundColor: "rgba(255,255,255,1)",
          pointHoverBackgroundColor: "rgba(255,255,255,1)",
          pointBorderWidth: 2,
          pointHoverRadius: 8,
          pointHoverBorderWidth: 1,
        },
      ],
    },

    // Configuration options go here
    options: {
      responsive: true,
      maintainAspectRatio: false,
      legend: {
        display: false,
      },
      layout: {
        padding: {
          right: 10,
        },
      },
      scales: {
        xAxes: [
          {
            gridLines: {
              display: false,
            },
          },
        ],
        yAxes: [
          {
            gridLines: {
              display: true,
              color: "#eee",
              zeroLineColor: "#eee",
            },
            ticks: {
              callback: function (value) {
                var ranges = [
                  { divider: 1e6, suffix: "M" },
                  { divider: 1e4, suffix: "k" },
                ];
                function formatNumber(n) {
                  for (var i = 0; i < ranges.length; i++) {
                    if (n >= ranges[i].divider) {
                      return (
                        (n / ranges[i].divider).toString() + ranges[i].suffix
                      );
                    }
                  }
                  return n;
                }
                return formatNumber(value);
              },
            },
          },
        ],
      },
      tooltips: {
        callbacks: {
          title: function (tooltipItem, data) {
            return data["labels"][tooltipItem[0]["index"]];
          },
          label: function (tooltipItem, data) {
            return "$" + data["datasets"][0]["data"][tooltipItem["index"]];
          },
        },
        responsive: true,
        intersect: false,
        enabled: true,
        titleFontColor: "#888",
        bodyFontColor: "#555",
        titleFontSize: 12,
        bodyFontSize: 18,
        backgroundColor: "rgba(256,256,256,0.95)",
        xPadding: 20,
        yPadding: 10,
        displayColors: false,
        borderColor: "rgba(220, 220, 220, 0.9)",
        borderWidth: 2,
        caretSize: 10,
        caretPadding: 15,
      },
    },
  });
}

var activity = document.getElementById("activity");
if (activity !== null) {
  var activityData = [
    {
      data: [0, 65, 52, 115, 98, 165, 125, 150, 170, 160, 190, 195],
    },
    {
      data: [0, 65, 77, 33, 49, 100, 100, 106, 119, 125, 110, 115],
    },
  ];

  var config = {
    // The type of chart we want to create
    type: "line",
    // The data for our dataset
    data: {
      labels: [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec",
      ],
      datasets: [
        {
          label: "Active",
          backgroundColor: "transparent",
          borderColor: "rgb(82, 136, 255)",
          data: activityData[0].data,
          lineTension: 0,
          pointRadius: 5,
          pointBackgroundColor: "rgba(255,255,255,1)",
          pointHoverBackgroundColor: "rgba(255,255,255,1)",
          pointBorderWidth: 2,
          pointHoverRadius: 7,
          pointHoverBorderWidth: 1,
        },
      ],
    },
    // Configuration options go here
    options: {
      responsive: true,
      maintainAspectRatio: false,
      legend: {
        display: false,
      },
      scales: {
        xAxes: [
          {
            gridLines: {
              display: false,
            },
            ticks: {
              fontColor: "#8a909d", // this here
            },
          },
        ],
        yAxes: [
          {
            gridLines: {
              fontColor: "#8a909d",
              fontFamily: "Roboto, sans-serif",
              display: true,
              color: "#eee",
              zeroLineColor: "#eee",
            },
            ticks: {
              // callback: function(tick, index, array) {
              //   return (index % 2) ? "" : tick;
              // }
              stepSize: 50,
              fontColor: "#8a909d",
              fontFamily: "Roboto, sans-serif",
            },
          },
        ],
      },
      tooltips: {
        callbacks: {
          title: function (tooltipItem, data) {
            return data["labels"][tooltipItem[0]["index"]];
          },
          label: function (tooltipItem, data) {
            return (
              "Total : " + data["datasets"][0]["data"][tooltipItem["index"]]
            );
          },
        },
        responsive: true,
        intersect: false,
        enabled: true,
        titleFontColor: "#888",
        bodyFontColor: "#555",
        titleFontSize: 12,
        bodyFontSize: 18,
        backgroundColor: "rgba(256,256,256,0.95)",
        xPadding: 20,
        yPadding: 10,
        displayColors: false,
        borderColor: "rgba(220, 220, 220, 0.9)",
        borderWidth: 2,
        caretSize: 10,
        caretPadding: 15,
      },
    },
  };

  var ctx = document.getElementById("activity").getContext("2d");
  var myLine = new Chart(ctx, config);

  var items = document.querySelectorAll("#user-activity .nav-tabs .nav-item");
  items.forEach(function (item, index) {
    item.addEventListener("click", function () {
      config.data.datasets[0].data = activityData[index].data;
      myLine.update();
    });
  });
}
