import { HttpService } from "src/app/Services/http.service";
import { Component, OnInit } from "@angular/core";
import { Chart } from "chart.js";
import {
  ActivatedRouteSnapshot,
  ActivatedRoute,
  Router,
} from "@angular/router";

@Component({
  selector: "app-movie-statistic",
  templateUrl: "./movie-statistic.component.html",
  styleUrls: ["./movie-statistic.component.css"],
})
export class MovieStatisticComponent implements OnInit {
  mode: string;
  incomes: any[];
  constructor(
    private myHttp: HttpService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  private backgroundColor$ = [
    "rgba(255, 99, 132, 0.2)",
    "rgba(54, 162, 235, 0.2)",
    "rgba(255, 206, 86, 0.2)",
    "rgba(75, 192, 192, 0.2)",
    "rgba(153, 102, 255, 0.2)",
    "rgba(255, 159, 64, 0.2)",
  ];
  private borderColor$ = [
    "rgba(255, 99, 132, 1)",
    "rgba(54, 162, 235, 1)",
    "rgba(255, 206, 86, 1)",
    "rgba(75, 192, 192, 1)",
    "rgba(153, 102, 255, 1)",
    "rgba(255, 159, 64, 1)",
  ];
  ngOnInit(): void {
    this.mode = this.route.snapshot.data.mode;
    this.initiateChart();
  }

  initiateChart() {
    let ctx = document.getElementById("myChart");
    let chart: Promise<Chart>;
    switch (this.mode) {
      case "movies":
        chart = this.initiateMovieChart();
        break;
      case "members":
        chart = this.initiateCustomerChart();
        break;
      case "genres":
        chart = this.initiateMovieGenreChart();
        break;
      case "show-times":
        chart = this.initiateShowTimeChart();
        break;
      case "incomes":
        this.initiateIncomeChart();
        return;
    }

    chart.then((result) => {
      let myChart = new Chart(ctx, {
        type: "horizontalBar",
        data: result.data,
        options: {
          scales: {
            yAxes: [
              {
                ticks: {
                  beginAtZero: true,
                },
              },
            ],
          },
        },
      });
    });
  }
  initiateMovieChart(): Promise<Chart> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();
      let soldTicketsDataset$ = {
        label: "Ve ban duoc",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      let totalMoneyDataset$ = {
        label: "Tong tien",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      this.myHttp
        .getAll("movies/sold-tickets")
        .subscribe((statistics: any[]) => {
          statistics.map((statistic) => {
            labels$.push(statistic[1]);

            soldTicketsDataset$.data.push(statistic[2]);
            soldTicketsDataset$.backgroundColor.push(this.backgroundColor$[0]);
            soldTicketsDataset$.borderColor.push(this.borderColor$[0]);

            totalMoneyDataset$.data.push(statistic[3]);
            totalMoneyDataset$.backgroundColor.push(this.backgroundColor$[1]);
            totalMoneyDataset$.borderColor.push(this.borderColor$[1]);
          });
        });

      resolve({
        data: {
          labels: labels$,
          datasets: [soldTicketsDataset$, totalMoneyDataset$],
        },
      });
    });
  }
  initiateCustomerChart(): Promise<Chart> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();
      let ticketQuantitiesDataset$ = {
        label: "So luong ve",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      let totalMoneyDataset$ = {
        label: "Tong tien",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      let totalPointsDataset$ = {
        label: "Diem tich luy",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      this.myHttp.getAll("customers/top").subscribe((statistics: any[]) => {
        statistics.map((statistic) => {
          labels$.push(statistic[0] + "\n" + statistic[1]);

          ticketQuantitiesDataset$.data.push(statistic[2]);
          ticketQuantitiesDataset$.backgroundColor.push(
            this.backgroundColor$[0]
          );
          ticketQuantitiesDataset$.borderColor.push(this.borderColor$[0]);

          totalMoneyDataset$.data.push(statistic[3]);
          totalMoneyDataset$.backgroundColor.push(this.backgroundColor$[1]);
          totalMoneyDataset$.borderColor.push(this.borderColor$[1]);

          totalPointsDataset$.data.push(statistic[4]);
          totalPointsDataset$.backgroundColor.push(this.backgroundColor$[2]);
          totalPointsDataset$.borderColor.push(this.borderColor$[2]);
        });
      });

      resolve({
        data: {
          labels: labels$,
          datasets: [
            ticketQuantitiesDataset$,
            totalMoneyDataset$,
            totalPointsDataset$,
          ],
        },
      });
    });
  }

  initiateMovieGenreChart(): Promise<Chart> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();

      let soldTicketsDataset$ = {
        label: "So ve ban duoc",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };

      this.myHttp
        .getAll("movie-genres/top-sold")
        .subscribe((statistics: any[]) => {
          statistics.map((statistic) => {
            labels$.push(statistic[0]);

            soldTicketsDataset$.data.push(statistic[1]);
            soldTicketsDataset$.backgroundColor.push(this.backgroundColor$[0]);
            soldTicketsDataset$.borderColor.push(this.borderColor$[0]);
          });
        });

      resolve({
        data: {
          labels: labels$,
          datasets: [soldTicketsDataset$],
        },
      });
    });
  }
  initiateShowTimeChart(): Promise<Chart> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();

      let soldTicketsDataset$ = {
        label: "So ve ban duoc",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };

      this.myHttp.getAll("show-times/top").subscribe((statistics: any[]) => {
        statistics.map((statistic) => {
          labels$.push(statistic[0]);

          soldTicketsDataset$.data.push(statistic[1]);
          soldTicketsDataset$.backgroundColor.push(this.backgroundColor$[0]);
          soldTicketsDataset$.borderColor.push(this.borderColor$[0]);
        });
      });

      resolve({
        data: {
          labels: labels$,
          datasets: [soldTicketsDataset$],
        },
      });
    });
  }

  initiateIncomeChart(dataIndex: number = 0) {
    if (!this.incomes) {
      this.myHttp.getAll("incomes").subscribe((incomes: any[]) => {
        this.incomes = incomes;
        console.log("good afternoon", this.incomes);
      });
    }
    let labels$ = new Array<any>();

    let IncomesDataset$ = {
      label: "Thu nhap",
      data: [],
      backgroundColor: [],
      borderColor: [],
      borderWidth: 1,
      minBarLength: 4,
    };

    labels$.push(this.incomes[dataIndex].month);

    IncomesDataset$.data.push(this.incomes[dataIndex].income);
    IncomesDataset$.backgroundColor.push(this.backgroundColor$[0]);
    IncomesDataset$.borderColor.push(this.borderColor$[0]);

    let ctx = document.getElementById("myChart");
    let myChart = new Chart(ctx, {
      type: "horizontalBar",
      data: { labels: labels$, datasets: [IncomesDataset$] },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true,
              },
            },
          ],
        },
      },
    });
  }

  switchMode(mode: string) {
    this.router.navigate([mode]);
  }

  switchYear(yearIndex: number) {
    this.initiateIncomeChart(yearIndex);
  }
}
interface Chart {
  data: {
    labels: string[];
    datasets: {
      label: string;
      data: any[];
      backgroundColor?: string[];
      borderColor?: string[];
      borderWidth?: number;
    }[];
  };
}
