import { Component, OnInit } from '@angular/core';

import {ActivatedRoute} from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import {FilmService} from '../service/film.service';

@Component({
  selector: 'app-detail-film',
  templateUrl: './detail-film.component.html',
  styleUrls: ['./detail-film.component.scss']
})
export class DetailFilmComponent implements OnInit {
  public filmDetail;
  public  id: number;
  constructor(private filmService: FilmService,  private route: ActivatedRoute,
              public sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    console.log(this.id);
    this.filmService.getFilmById(this.id).subscribe(data => {
      this.filmDetail = data;
    });
  }

}
