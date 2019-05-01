import { Component, OnInit } from '@angular/core';
import {Release} from '../../classes/release';
import{ReleasemanagementService} from '../../service/releasemanagement.service';

@Component({
  selector: 'app-lookup',
  templateUrl: './lookup.component.html',
  styleUrls: ['./lookup.component.css']
})
export class LookupComponent implements OnInit {
  private releases:Release[];
  searchText;

  constructor(private _service:ReleasemanagementService) { }

  ngOnInit() {
    this._service.getReleases().subscribe((res:any[])=>{
      console.log(res);
      this.releases=res;
    })
  }

}
