import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../../../Services/customer.service';
import { FilmModel } from '../models/film.model'

@Component({
  selector: 'app-film-management',
  templateUrl: './film-management.component.html',
  styleUrls: ['./film-management.component.css']
})
export class FilmManagementComponent implements OnInit {
	public movies: Array<FilmModel> = [];
  moviesNew: Array<FilmModel> = [];
  moviesEdit: Array<FilmModel> = [];

  public hidden: boolean = true;
  public addnews: boolean = true;
  public p;

  constructor(
  	public customerService: CustomerService
  	) { }

  ngOnInit(): void {
     this.customerService.getAllMovies().subscribe(data => {
      this.movies = data;
      console.log(this.movies)
      this.moviesNew = [];
      this.moviesEdit = [];
      this.movies.forEach((item, index) => {
        this.movies[index].isEdit = false;
      });
    });
  }
  
  edit(id, index) {
    if (id !== null && id !== undefined) {
      this.moviesEdit.push(this.movies[index]);
    }
    this.movies[index].isEdit = !this.movies[index].isEdit;
  }

  onAddRow() {
    let dr = new FilmModel();
    this.movies.push(dr);
    dr.isEdit = true;
  }
  
  save() {
    if (this.moviesEdit != []) {
      for (let i = 0; i < this.moviesEdit.length; i++) {
        if (this.movies[i].id == null) {
          this.movies.splice(i, 1);
        }
      }
      this.customerService.editFilm(this.moviesEdit).subscribe(data => {
      });
    }
    for (let i = 0; i < this.movies.length; i++) {
      if (this.movies[i].id == null) {
        this.moviesNew.push(this.movies[i]);
      }
    }
    if (this.moviesNew != []) {
      this.customerService.addNewFilm(this.moviesNew).subscribe(data => {
      });
    }
    location.reload();
  }
  delete(id, index) {
  if (id == null) {
    this.movies.splice(index, 1);
    console.log(this.moviesNew);
  } else {
    if(confirm("Bạn có chắc muốn xóa phim này không??")){
      this.customerService.delFilm(id).subscribe(result => {
        this.ngOnInit();
      }, error => console.error(error));
      window.alert('Đã xóa thành công!');
    }
  }
}


}
