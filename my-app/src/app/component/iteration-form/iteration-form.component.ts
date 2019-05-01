import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {ReleasemanagementService} from '../../service/releasemanagement.service';
import {Iteration} from '../../classes/iteration';

@Component({
  selector: 'app-iteration-form',
  templateUrl: './iteration-form.component.html',
  styleUrls: ['./iteration-form.component.css']
})
export class IterationFormComponent implements OnInit {
  form = new FormGroup({
    title: new FormControl('',Validators.required),
    desc: new FormControl('',Validators.required),
    sDate: new FormControl('',Validators.required),
    eDate: new FormControl('',Validators.required),
    status: new FormControl('',Validators.required),
    type: new FormControl('',Validators.required)

  })
  private iteration:Iteration;

  constructor(private _service:ReleasemanagementService, private _router:Router) { }

  ngOnInit() {
    this.iteration = this._service.iGetter();
    this.iteration.release = this._service.rGetter().releaseId;
  }

  processForm(){
    if(this.iteration.iterationId==undefined){
      this._service.saveIteration(this.iteration).subscribe((iteration)=>{
        this._router.navigate(['/iterationList']);
      },(error)=>{
        console.log(error);
      });
    }else{
      this._service.updateIteration(this.iteration).subscribe((iteration)=>{
        this._router.navigate(['/iterationList']);
      },(error)=>{
        console.log(error);
      })
    }
  }

}
