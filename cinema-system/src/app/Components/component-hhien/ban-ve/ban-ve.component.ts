import { Component, OnInit } from '@angular/core';
import { BanVeService } from '../../../Services/ban-ve.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ban-ve',
  templateUrl: './ban-ve.component.html',
  styleUrls: ['./ban-ve.component.css']
})
export class BanVeComponent implements OnInit {
  public days;

  constructor(private banVeService: BanVeService,
              private router: Router) { }

  ngOnInit(): void {
    this.banVeService.getAllmovies().subscribe(data => { this.days = data; });
  }

}
