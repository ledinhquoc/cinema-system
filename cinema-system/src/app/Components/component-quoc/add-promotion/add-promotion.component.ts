import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder, Validators,FormControl} from '@angular/forms';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import {Router} from '@angular/router';
import { UploadChangeParam } from 'ng-zorro-antd/upload/interface';
import { NzMessageService } from 'ng-zorro-antd/message/';
import { FilmService } from 'src/app/services/film.service';



@Component({
  selector: 'app-add-promotion',
  templateUrl: './add-promotion.component.html',
  styleUrls: ['./add-promotion.component.css']
})
export class AddPromotionComponent implements OnInit {
  dateFormat = 'dd/MM/yyyy';
  date_start: Date |null = null;
  date_end: Date | null = null;
  endOpen = false;
  public selected;
  show = true;
  check: boolean;
  public promotion;
  validateForm: FormGroup;
  selectedFile:File = null;
  inputValue: string;
  url:string;
  defaultFileList = [
  ];

  disabledStartDate = (date_start: Date): boolean =>{
    if(!date_start || !this.date_end){
      return false;
    }
    return date_start.getTime() > this.date_end.getTime();
  }

  disabledEndDate = (date_end: Date): boolean =>{
    if(!date_end || !this.date_start){
      return false;
    }
    return date_end.getTime() <= this.date_start.getTime();
  }

  onStartChange(date: Date): void {
    this.date_start = date;
  }

  onEndChange(date: Date): void {
    this.date_end = date;
  }

  handleStartOpenChange(open: boolean): void {
    if(!open){
      this.endOpen = true;
    }
    console.log('handleStartOpenChange',open,this.endOpen)
  }

  handleEndOpenChange(open: boolean): void {
      this.endOpen = open;
    
  }



  fileList2 = [...this.defaultFileList];

  constructor(
              private http: HttpClient,
              public promotionService: FilmService,
              public router : Router,
              public fb: FormBuilder,
              public msg: NzMessageService
  ) { }

        
  
  handleChange(info: UploadChangeParam): void {
    if (info.file.status !== 'uploading') {
      console.log(info.file, info.fileList);
      this.url = '../assets/images/' + info.file.name;
      console.log(info.file.name);
    }
    if (info.file.status === 'done') {
      this.msg.success(`${info.file.name} file uploaded successfully`);
    } else if (info.file.status === 'error') {
      this.msg.error(`${info.file.name} file upload failed.`);
    }
  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      promotionImage: [''],
      promotionTitle: ['', [Validators.required]],
      promotionBeginDate: ['', [Validators.required]],
      promotionEndDate: ['', [Validators.required]],
      promotionDiscount: ['', [Validators.required]],
      promotionDescription: ['', [Validators.required]],
      agree: [true]
    });
  }

  submitForm(value:{title:string,date_start:Date,date_end:Date,discount:number,detail:string}): void {
    for (const key in this.validateForm.controls) {
      this.validateForm.controls[key].markAsDirty();
      this.validateForm.controls[key].updateValueAndValidity();
    }

  }

  getImage(e: MouseEvent):void {
  
    e.preventDefault();
  }

  updateConfirmValidator(): void {
    /** wait for refresh value */
    Promise.resolve().then(() => this.validateForm.controls.checkPassword.updateValueAndValidity());
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls.password.value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  addNewPromotion(){

    this.validateForm.controls['promotionImage'].setValue(this.url);
    this.promotionService.addNewPromotion(this.validateForm.value).subscribe(data =>{
      this.router.navigateByUrl('/list-discount')
    })
  }

  

}
