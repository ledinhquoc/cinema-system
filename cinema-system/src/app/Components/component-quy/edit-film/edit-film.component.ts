import { Component, OnInit } from '@angular/core';
import {FilmService} from '../../component-tuan/service/film.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Params, Router} from '@angular/router';

@Component({
  selector: 'app-edit-film',
  templateUrl: './edit-film.component.html',
  styleUrls: ['./edit-film.component.css']
})
export class EditFilmComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    public  filmService: FilmService,
    public formBuilder: FormBuilder,
    public router: Router,
    public acticform : ActivatedRoute
  ) {
  }
  get f() { return this.formAddFilm.controls; }
  submitted = true;
  formAddFilm : FormGroup;
  movieTypeAction: any;
  isHanhDong: any;
  isVienTuong: any;
  isHoatHinh: any;
  isVoThuat: any;
  isHaiHuoc: any;
  isChienTranh: any;
  isKinhDi: any;
  isKinhDien: any;
  isLangMang: any;
  isKiemHiep: any;
  isPhieuDu: any;
  isTamLy: any;
  isTinhCam: any;
  isAmNhac: any;
  film;
  from: any;
  movieName: any;
  dateStart: any;
  dateEnd: any;
  actor: any;
  movieStudio: any;
  directors: any;
  durations: any;
  content: any;
  srcVideo: any;
  srcImg: any;
  id: any ;
  // ischeckform: boolean= true;
  isCheckFormDay = false;
  checkTypeMovie: string[];
  ngOnInit(): void {
    this.formAddFilm = this.formBuilder.group({
      movieName: [this.movieName,[Validators.required]],
      movieType: [this.movieTypeAction,[Validators.required]],
      dateStart: [this.dateStart,[Validators.required]],
      dateEnd: [this.dateEnd,[Validators.required ]],
      movieStudio: [this.movieStudio,[Validators.required]],
      directors: [this.directors,[Validators.required]],
      actor: [this.actor,[Validators.required]],
      duration: [this.durations,[Validators.required]],
      content: [this.content,[Validators.required]],
      srcImg: [this.srcImg,[Validators.required]],
      srcVideo: [this.srcVideo,[Validators.required]],
    })
       this.acticform.params.subscribe(data =>{
           this.id = data.id ;
      this.filmService.getFilmById(this.id).subscribe(data =>{
        this.formAddFilm.patchValue(data);
        this.dateStart = data.dateStart;
         this.dateEnd = data.dateEnd ;
         this.checkTypeMovie = data.movieType.split(',') ;
        console.log(this.checkTypeMovie)
        for(let i=0 ; i< this.checkTypeMovie.length; i++){
          if(this.checkTypeMovie[i] === 'Hành động'){
            this.isHanhDong = true ;
          }  if(this.checkTypeMovie[i] === 'Viễn tưởng'){
            this.isVienTuong = true ;
          }  if(this.checkTypeMovie[i] === 'Hoạt hình'){
            this.isHoatHinh = true ;
          }  if(this.checkTypeMovie[i] === 'Võ thuật'){
            this.isVoThuat = true ;
          }  if(this.checkTypeMovie[i] === 'Hài hước'){
            this.isHaiHuoc = true ;
          }  if(this.checkTypeMovie[i] === 'Chiến tranh'){
            this.isChienTranh = true ;
          }  if(this.checkTypeMovie[i] === 'Kinh dị'){
            this.isKinhDi = true ;
          }  if(this.checkTypeMovie[i] === 'Kinh điển'){
            this.isKinhDien = true ;
          }  if(this.checkTypeMovie[i] === 'Lãng mạng'){
            this.isLangMang = true ;
          }  if(this.checkTypeMovie[i] === 'Kiếm hiệp'){
            this.isKiemHiep = true ;
          } if(this.checkTypeMovie[i] === 'Phiêu du'){
            this.isPhieuDu = true ;
          }  if(this.checkTypeMovie[i] === 'Tâm lý'){
            this.isTamLy = true ;
          }  if(this.checkTypeMovie[i] === 'Tình cảm'){
            this.isTinhCam = true ;
          }  if(this.checkTypeMovie[i] === 'Âm nhạc'){
            this.isAmNhac = true ;
          }
        }
    })
       })
  }
  checkValue(event: any){
  }
  addNewFilm() {
    this.movieTypeAction = '' ;
    if (this.isHanhDong === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Hành động');
    }
    if (this.isVienTuong === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Viễn tưởng')
    } if (this.isHoatHinh === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Hoạt hình')
    }if (this.isVoThuat === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Võ thuật')
    }if (this.isHaiHuoc === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Hài hước')
    }if (this.isChienTranh === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Chiến tranh')
    }if (this.isKinhDi === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Kinh dị')
    }if (this.isKinhDien === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Kinh điển')
    }if (this.isLangMang === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Lãng mạng')
    }if (this.isKiemHiep === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Kiếm hiệp')
    }if (this.isPhieuDu === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Phiêu du')
    }if (this.isTamLy === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Tâm lý')
    }if (this.isTinhCam === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Tình cảm')
    }if (this.isAmNhac === true){
      this.movieTypeAction= this.movieTypeAction.concat(',Âm nhạc')
    }


    this.movieTypeAction = this.movieTypeAction.substr(1,this.movieTypeAction.length);
    this.submitted = true;
    this.srcImg = this.srcImg.split('\\')
    this.srcImg = this.srcImg[(this.srcImg.length)-1]
    if(this.formAddFilm.invalid && this.movieTypeAction !== ''){
      this.submitted = true ;
      alert('Vui lòng kiểm tra lại thông tin');
    }else
      if(this.dateEnd <= this.dateStart  ){
      alert('Ngày kết thúc phải lớn hơn ngày bắt đầu')
    }else if (this.movieTypeAction === ''){
        alert('vui lòng chon thể loại phim')
      }
      else  if (this.formAddFilm.invalid === false){
        this.ngOnInit()
        this.srcImg = this.srcImg.split('\\')
        this.srcImg = this.srcImg[(this.srcImg.length)-1]
      this.filmService.updateFilm(this.formAddFilm.value,this.id).subscribe(data=>{
        console.log(data)
        this.router.navigateByUrl('admin-movies').then(r => null);
      })
    }
  }
}
