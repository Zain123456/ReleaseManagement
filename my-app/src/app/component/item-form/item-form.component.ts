import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import {ReleasemanagementService} from '../../service/releasemanagement.service';
import {Item} from '../../classes/item';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  form = new FormGroup({
    name: new FormControl ('',Validators.required)
  })

  private item:Item;

  constructor(private _service:ReleasemanagementService, private _router:Router) { }
  
  ngOnInit() {
    this.item= this._service.itGetter();
    this.item.release = this._service.rGetter().releaseId;
  }

  processForm(){
    if(this.item.itemId==undefined){
      this._service.addItems(this.item).subscribe((item)=>{
        this._router.navigate(['/itemList']);
      },(error)=>{
        console.log(error);
      });
    }
  }

}
