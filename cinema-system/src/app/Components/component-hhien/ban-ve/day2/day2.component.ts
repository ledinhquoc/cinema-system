import { Component, OnInit } from '@angular/core';
import { BanVeService } from '../../../../Services/ban-ve.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-day2',
  templateUrl: './day2.component.html',
  styleUrls: ['./day2.component.css']
})
export class Day2Component implements OnInit {
  public movies;

  constructor(private banVeService: BanVeService,
              private router: Router) { }

  ngOnInit(): void {
    this.banVeService.getAllmovies().subscribe(data => { this.movies = data; });
  }

  chonGhe() {
    this.router.navigateByUrl('chon-ghe');
  }
}
