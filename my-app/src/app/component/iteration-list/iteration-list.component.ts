import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Iteration} from '../../classes/iteration';
import{Release} from '../../classes/release';
import{ReleasemanagementService} from '../../service/releasemanagement.service';

@Component({
  selector: 'app-iteration-list',
  templateUrl: './iteration-list.component.html',
  styleUrls: ['./iteration-list.component.css']
})
export class IterationListComponent implements OnInit {

  private iterations:Iteration[];
  private release:Release;

  constructor(private _service:ReleasemanagementService, private _route:Router) { }

  ngOnInit() {
    this.release=this._service.rGetter();
    this._service.getIterationByReleaseId(this.release.releaseId).subscribe((res:any[])=>{
     console.log(res);
     this.iterations=res;
    });
   
  }
  
  saveIteration(){
    let iteration = new Iteration();
    this._service.iSetter(iteration);
    this._route.navigate(['/iterationForm']);
  }

  deleteIteration(iteration){
    this._service.deleteIteration(iteration.iterationId).subscribe((data)=>{
      this.iterations.splice(this.iterations.indexOf(iteration),1);
    }, (error)=> {
      console.log(error);
    });
  }
  updateIteration(iteration){
    this._service.iSetter(iteration);
    this._route.navigate(['/iterationForm']);
  }

  addItem(iteration){
    let re = new Release();
    re.releaseId = iteration.iterationId;
    this._service.rSetter(re);
    this._route.navigate(['/itemForm']);
  }

  viewItems(iteration){
    let re = new Release();
    re.releaseId = iteration.iterationId;
    this._service.rSetter(re);
    this._route.navigate(['/itemList']);
  }
}
