import { Component, OnInit } from '@angular/core';
import {FilmService} from '../service/film.service';


@Component({
  selector: 'app-list-film',
  templateUrl: './list-film.component.html',
  styleUrls: ['./list-film.component.scss']
})
export class ListFilmComponent implements OnInit {
  page = 1;
  search: string;
  public film;
  constructor(private filmService: FilmService) { }

  ngOnInit(): void {
    this.filmService.getAllFilm().subscribe(data => {
      this.film = data;
    });
  }
}
