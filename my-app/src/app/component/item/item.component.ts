import { Component, OnInit } from '@angular/core';
import {Item} from '../../classes/item';
import{ReleasemanagementService} from '../../service/releasemanagement.service';
import {Router} from '@angular/router';
import {Release} from '../../classes/release';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  private items:Item[];
  private release:Release;

  constructor(private _service:ReleasemanagementService, private _route:Router) { }

  ngOnInit() {
    this.release=this._service.rGetter();
    this._service.getItemsById(this.release.releaseId).subscribe((res:any[])=>{
     console.log(res);
     this.items=res;
    });
  }

  addItem(){
    let item= new Item();
    this._service.itSetter(item);
    this._route.navigate(['/itemForm']);
  }

}
