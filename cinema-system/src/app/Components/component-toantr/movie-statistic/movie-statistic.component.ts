import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Chart } from "chart.js";
import { HttpService } from "src/app/Services/http.service";

@Component({
  selector: "app-movie-statistic",
  templateUrl: "./movie-statistic.component.html",
  styleUrls: ["./movie-statistic.component.css"],
})
export class MovieStatisticComponent implements OnInit {
  mode: string;
  incomeYears: number[];
  private myChart: Chart;
  constructor(
    private myHttp: HttpService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  private backgroundColor$ = [
    "rgb(172, 0, 230)",
    "rgb(77, 77, 255)",
    "rgb(255, 51, 51)",
    "rgb(187, 51, 255)",
    "rgb(0, 204, 0)",
    "rgb(255, 163, 26)",
  ];
  private borderColor$ = [
    "rgb(134, 0, 179)",
    "rgb(0, 0, 230)",
    "rgb(255, 0, 0)",
    "rgb(153, 0, 230)",
    "rgb(0, 128, 0)",
    "rgb(204, 122, 0)",
  ];
  ngOnInit(): void {
    this.mode = this.route.snapshot.data.mode;
    this.initiateChart();
  }

  initiateChart() {
    let chart: Promise<Chart$>;
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
        chart = this.initiateIncomeChart();
        break;
    }

    chart.then((result) => {
      let ctx = document.getElementById("myChart");
      this.myChart = new Chart(ctx, {
        type:
          this.mode === "show-times"
            ? "polarArea"
            : this.mode === "incomes"
            ? "bar"
            : "horizontalBar",
        data: result.data,
        options:
          this.mode === "show-times"
            ? undefined
            : {
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
  initiateMovieChart(): Promise<Chart$> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();
      let soldTicketsDataset$ = {
        label: "Vé bán đuợc",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      let totalMoneyDataset$ = {
        label: "Tổng tiền",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      this.myHttp
        .getAll("movies/sold-tickets")
        .subscribe((statistics: any[]) => {
          new Promise<any>((resolve) => {
            statistics.map((statistic) => {
              labels$.push(
                statistic[1] +
                  ` [${this.getQuarterOfYearName(statistic[4])} / Năm ${
                    statistic[5]
                  }]`
              );

              soldTicketsDataset$.data.push(statistic[2]);
              soldTicketsDataset$.backgroundColor.push(
                this.backgroundColor$[0]
              );
              soldTicketsDataset$.borderColor.push(this.borderColor$[0]);

              totalMoneyDataset$.data.push(statistic[3]);
              totalMoneyDataset$.backgroundColor.push(this.backgroundColor$[1]);
              totalMoneyDataset$.borderColor.push(this.borderColor$[1]);
            });
            resolve();
          }).then(() => {
            resolve({
              data: {
                labels: labels$,
                datasets: [soldTicketsDataset$, totalMoneyDataset$],
              },
            });
          });
        });
    });
  }
  initiateCustomerChart(): Promise<Chart$> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();
      let ticketQuantitiesDataset$ = {
        label: "Số lượng vé",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      let totalMoneyDataset$ = {
        label: "Tổng tiền",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      let totalPointsDataset$ = {
        label: "Điểm tích lũy",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };
      this.myHttp.getAll("customers/top").subscribe((statistics: any[]) => {
        new Promise<any>((resolve) => {
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
          resolve();
        }).then(() => {
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
      });
    });
  }

  initiateMovieGenreChart(): Promise<Chart$> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();

      let soldTicketsDataset$ = {
        label: "Số vé bán đuợc",
        data: [],
        backgroundColor: [],
        borderColor: [],
        borderWidth: 1,
        minBarLength: 4,
      };

      this.myHttp
        .getAll("movie-genres/top-sold")
        .subscribe((statistics: any[]) => {
          new Promise<any>((resolve) => {
            statistics.map((statistic) => {
              labels$.push(
                statistic[0] +
                  ` [${this.getQuarterOfYearName(statistic[2])} / Năm ${
                    statistic[3]
                  }]`
              );

              soldTicketsDataset$.data.push(statistic[1]);
              soldTicketsDataset$.backgroundColor.push(
                this.backgroundColor$[0]
              );
              soldTicketsDataset$.borderColor.push(this.borderColor$[0]);
            });
            resolve();
          }).then(() => {
            resolve({
              data: {
                labels: labels$,
                datasets: [soldTicketsDataset$],
              },
            });
          });
        });
    });
  }
  initiateShowTimeChart(): Promise<Chart$> {
    return new Promise((resolve) => {
      let labels$ = new Array<any>();

      let soldTicketsDataset$ = {
        data: [],
        backgroundColor: this.backgroundColor$,
        borderColor: this.borderColor$,
      };

      this.myHttp.getAll("show-times/top").subscribe((statistics: any[]) => {
        new Promise<any>((resolve) => {
          statistics.map((statistic) => {
            labels$.push(statistic[0]);

            soldTicketsDataset$.data.push(statistic[1]);
          });
          resolve();
        }).then(() => {
          resolve({
            data: {
              labels: labels$,
              datasets: [soldTicketsDataset$],
            },
          });
        });
      });
    });
  }

  initiateIncomeChart(year?: number): Promise<Chart$> {
    let labels$ = new Array<any>();

    let IncomesDataset$ = {
      label: "Thu nhập",
      data: [],
      backgroundColor: this.backgroundColor$,
      borderColor: this.borderColor$,
      borderWidth: 1,
      minBarLength: 4,
    };

    const getIncomeYears = (): Promise<any> => {
      return new Promise((resolve) => {
        if (this.incomeYears) {
          resolve();
          return;
        }
        this.myHttp.getAll("income-years").subscribe((years: number[]) => {
          this.incomeYears = years;
          console.log("Step 1: get income years", this.incomeYears);
          resolve();
        });
      });
    };

    const getIncomeByYear = (): Promise<Array<Array<any>>> => {
      return new Promise((resolve) => {
        this.myHttp
          .getById("incomes", year ? year : this.incomeYears[0])
          .subscribe((incomes: Array<Array<any>>) => {
            console.log("Step 2: raw incomes", incomes);
            resolve(incomes);
          });
      });
    };

    const filteringIncomes = (incomes: Array<Array<any>>): Promise<void> => {
      return new Promise((resolve) => {
        incomes.map((income, index) => {
          console.log("Step 2.5+: single income: ", income);
          labels$.push(`Tháng ${income[1]}`); //month
          IncomesDataset$.data.push(`${income[0]}`);
        });
        console.log("Step 3: filtering data and finish tasks", {
          data: { labels: labels$, datasets: [IncomesDataset$] },
        });
        resolve();
      });
    };

    return new Promise<Chart$>((resolve) => {
      getIncomeYears().then(() => {
        getIncomeByYear().then((incomes) => {
          filteringIncomes(incomes).then(() => {
            resolve({ data: { labels: labels$, datasets: [IncomesDataset$] } });
          });
        });
      });
    });
  }

  switchMode(mode: string) {
    this.router.navigate([mode]);
  }

  switchYear(year: number) {
    this.initiateIncomeChart(year).then((result) => {
      let ctx = document.getElementById("myChart");
      this.myChart = new Chart(ctx, {
        type: "bar",
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

  getQuarterOfYearName(month: any) {
    let month$ = <number>month;
    if (month$ >= 1 && month$ <= 3) {
      return "Quý 1";
    } else if (month$ >= 4 && month$ <= 6) {
      return "Quý 2";
    } else if (month$ >= 7 && month$ <= 9) {
      return "Quý 3";
    } else if (month$ >= 10 && month$ <= 12) {
      return "Quý 4";
    } else return "ERROR";
  }
}
interface Chart$ {
  data: {
    labels: string[];
    datasets: {
      label?: string;
      data: any[];
      backgroundColor?: string[];
      borderColor?: string[];
      borderWidth?: number;
    }[];
  };
}
