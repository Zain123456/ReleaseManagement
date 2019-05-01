import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Release} from '../../classes/release';
import{ReleasemanagementService} from '../../service/releasemanagement.service';




@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  private releases:Release[];


  constructor(private _service:ReleasemanagementService, private _route:Router) { }

  ngOnInit() {
    this._service.getReleases().subscribe((res:any[])=>{
      console.log(res);
      this.releases=res;
    })
  }


  saveRelease(){
    let release = new Release();
    this._service.rSetter(release);
    this._route.navigate(['/releaseForm']);
  }


  deleteRelease(release){
    this._service.deleteRelease(release.releaseId).subscribe((data)=>{
      this.releases.splice(this.releases.indexOf(release),1);

    }, (error)=> {
      console.log(error);
    });
  }

  updateRelease(release){
    this._service.rSetter(release);
    this._route.navigate(['/releaseForm']);
  }
  
  getIterationById(release){
    this._service.rSetter(release);
    this._route.navigate(['/iterationList']);
  }

  addIteration(release){
    this._service.rSetter(release);
    this._route.navigate(['/iterationForm']);
  }

  addItem(release){
    this._service.rSetter(release);
    this._route.navigate(['/itemForm']);
  }

  getItemsById(release){
    this._service.rSetter(release);
    this._route.navigate(['/itemList']);
  }
  


}
