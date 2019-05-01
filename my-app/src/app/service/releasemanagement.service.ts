import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Release} from '../classes/release';
import {Item} from'../classes/item';
import {Iteration} from '../classes/iteration';

let headers = new HttpHeaders().set('Content-Type','application/json');
let options ={
  headers:headers
}

@Injectable({
  providedIn: 'root'
})
export class ReleasemanagementService {
  private baseUrl:string='http://localhost:8400/api';

  private item = new Item();
  private release = new Release();
  private iteration = new Iteration();

  constructor(private _http:HttpClient) { }

  getReleases(){
    return this._http.get(this.baseUrl+'/releases',options);
  }
  saveRelease(release:Release){
    return this._http.post(this.baseUrl+'/releases',JSON.stringify(release),options);
  }

  deleteRelease(id:Number){
    return this._http.delete(this.baseUrl+'/releases/' +id,options);
  }

  updateRelease(release:Release){
    return this._http.put(this.baseUrl + '/releases',JSON.stringify(release),options);
  }

  getIteration(){
    return this._http.get(this.baseUrl + '/iterations', options);
  }

  saveIteration(iteration:Iteration){
    return this._http.post(this.baseUrl+'/iterations',JSON.stringify(iteration),options);
  }
  deleteIteration(id:Number){
    return this._http.delete(this.baseUrl+'/iterations/id=' + id, options);
  }
  updateIteration(iteration:Iteration){
    return this._http.put(this.baseUrl+'/iterations',JSON.stringify(iteration),options);
  }

  getIterationByReleaseId(id:Number){
    return this._http.get(this.baseUrl+'/iterations/releaseId=' + id,options );
  }
  getItemsById(id:Number){
    return this._http.get(this.baseUrl+'/item/releaseId=' + id,options );
  }

  viewItems(){
    return this._http.get(this.baseUrl+'/items',options);
  }

  addItems(item:Item){
    return this._http.post(this.baseUrl+'/additems',JSON.stringify(item),options);
  }

  itSetter(item:Item){
    this.item = item;
  }

  itGetter(){
    return this.item;
  }

  iSetter(iteration:Iteration){
    this.iteration = iteration;
  }

  iGetter(){
    return this.iteration;
  }

  rSetter(release:Release) {
    this.release=release;
  }

  rGetter() {
    return this.release;
  }
}
