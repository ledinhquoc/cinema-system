import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder, Validators,FormControl} from '@angular/forms';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import {Router,ActivatedRoute} from '@angular/router';
import { UploadChangeParam } from 'ng-zorro-antd/upload/interface';
import { NzMessageService } from 'ng-zorro-antd/message/';
import { FilmService } from 'src/app/services/film.service';

@Component({
  selector: 'app-edit-promotion',
  templateUrl: './edit-promotion.component.html',
  styleUrls: ['./edit-promotion.component.css']
})
export class EditPromotionComponent implements OnInit {
  dateFormat = 'dd/MM/yyyy';
  date_start: Date |null = null;
  date_end: Date | null = null;
  endOpen = false;
  public selected;
  show = true;
  check: boolean;
  public promotion;
  editValidateForm: FormGroup;
  selectedFile:File = null;
  inputValue: string;
  url:string;
  public promotionId;
  check1 = false;
  defaultFileList = [
    
  ];
  fileList2 = [...this.defaultFileList];

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

  constructor(
    private http: HttpClient,
              public promotionService: FilmService,
              public router : Router,
              public fb: FormBuilder,
              public msg: NzMessageService,
              public activatedRoute: ActivatedRoute,
  ) { }
  
  handleChange(info: UploadChangeParam): void {
    if (info.file.status !== 'uploading') {
      console.log(info.file, info.fileList);
      if(info.file.name !== null){
        this.check1 = true;
        this.url = '../assets/images/' + info.file.name;
      }
      console.log(info.file.name);

    }
    if (info.file.status === 'done') {
      this.msg.success(`${info.file.name} file uploaded successfully`);
    } else if (info.file.status === 'error') {
      this.msg.error(`${info.file.name} file upload failed.`);
    }
  }

  ngOnInit(): void {
    this.editValidateForm = this.fb.group({
      promotionImage: [''],
      promotionTitle: ['', [Validators.required]],
      promotionBeginDate: ['', [Validators.required]],
      promotionEndDate: ['', [Validators.required]],
      promotionDiscount: ['', [Validators.required]],
      promotionDescription: ['', [Validators.required]],
      agree: [true]
    });

    this.activatedRoute.params.subscribe(data => {
      this.promotionId = data.id;
      this.promotionService.getPromotionById(this.promotionId).subscribe(data => {
        this.editValidateForm.patchValue(data);
        console.log(data);
      })
    })
  }

  submitForm(value:{title:string,date_start:Date,date_end:Date,discount:number,detail:string}): void {
    for (const key in this.editValidateForm.controls) {
      this.editValidateForm.controls[key].markAsDirty();
      this.editValidateForm.controls[key].updateValueAndValidity();
    }

  }

  getImage(e: MouseEvent):void {
  
    e.preventDefault();
  }

  updateConfirmValidator(): void {
    /** wait for refresh value */
    Promise.resolve().then(() => this.editValidateForm.controls.checkPassword.updateValueAndValidity());
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.editValidateForm.controls.password.value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  editPromotion(){
    if(this.check1 = true){
      this.editValidateForm.controls['promotionImage'].setValue(this.url);
    }
   
    this.promotionService.editPromotion(this.editValidateForm.value,this.promotionId).subscribe(data =>{
      this.router.navigateByUrl('/')
    })
  }

}
