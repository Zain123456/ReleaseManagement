import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {ReleasemanagementService} from '../../service/releasemanagement.service';
import { Release } from 'src/app/classes/release';

@Component({
  selector: 'app-release-form',
  templateUrl: './release-form.component.html',
  styleUrls: ['./release-form.component.css']
})
export class ReleaseFormComponent implements OnInit {
  error:any={isError:false,errorMessage:''};
  form = new FormGroup({
    title: new FormControl('',Validators.required),
    desc: new FormControl('',Validators.required),
    sDate: new FormControl('',Validators.required),
    pDate: new FormControl('',Validators.required),
    rDate: new FormControl('', Validators.required),
    type: new FormControl('',Validators.required),
    stage: new FormControl('',Validators.required),
    status: new FormControl('',Validators.required),
    manager: new FormControl('',Validators.required)
  });
  private release:Release;

  constructor(private _service:ReleasemanagementService, private _router:Router) { }

  ngOnInit() {
    this.release = this._service.rGetter();
  }

  compareTwoDates(){
    if(new Date(this.form.controls['rDate'].value)<new Date(this.form.controls['sDate'].value)){
       this.error={isError:true,errorMessage:"Release Date can't before start date"};
    }
 }

  processForm(){
    if(this.release.releaseId==undefined){
      this._service.saveRelease(this.release).subscribe((release)=>{

        this._router.navigate(['/releaseList']);
      },(error)=>{
        console.log(error);
      });

    }else{
      this._service.updateRelease(this.release).subscribe((release)=>{
        this._router.navigate(['/releaseList']);
      },(error)=>{
        console.log(error);
      });
    }
    
  }

}
