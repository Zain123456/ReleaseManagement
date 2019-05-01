import { Component, OnInit } from '@angular/core';
import {Iteration} from '../../classes/iteration';
import{ReleasemanagementService} from '../../service/releasemanagement.service';

@Component({
  selector: 'app-iteration-lookup',
  templateUrl: './iteration-lookup.component.html',
  styleUrls: ['./iteration-lookup.component.css']
})
export class IterationLookupComponent implements OnInit {
  private iterations:Iteration[];
  searchI;

  constructor(private _service:ReleasemanagementService) { }

  ngOnInit() {
    this._service.getIteration().subscribe((res:any[])=>{
      console.log(res);
      this.iterations=res;
    });
  }

}
