import { Component, OnInit } from '@angular/core';
import { BanVeService } from '../../../../Services/ban-ve.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-day5',
  templateUrl: './day5.component.html',
  styleUrls: ['./day5.component.css']
})
export class Day5Component implements OnInit {
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
