import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReleaseFormComponent } from './component/release-form/release-form.component';
import { HeaderComponent } from './component/header/header.component';
import { MainpageComponent } from './component/mainpage/mainpage.component';
import { ListComponent } from './component/list/list.component';
import { IterationFormComponent } from './component/iteration-form/iteration-form.component';
import { IterationListComponent } from './component/iteration-list/iteration-list.component';
import { ItemComponent } from './component/item/item.component';
import { ItemFormComponent } from './component/item-form/item-form.component';
import { FooterComponent } from './component/footer/footer.component';
import { LookupComponent } from './component/lookup/lookup.component';
import { IterationLookupComponent } from './component/iteration-lookup/iteration-lookup.component';


const appRoutes:Routes= [
  {path:'',component:MainpageComponent},
  {path:'releaseList',component:ListComponent},
  {path:'releaseForm',component:ReleaseFormComponent},
  {path:'iterationList',component:IterationListComponent},
  {path:'iterationForm', component:IterationFormComponent},
  {path:'itemList',component:ItemComponent},
  {path:'itemForm',component:ItemFormComponent},
  {path:'lookUp',component:LookupComponent},
  {path:'iterationLookUp',component:IterationLookupComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ReleaseFormComponent,
    HeaderComponent,
    MainpageComponent,
    ListComponent,
    IterationFormComponent,
    IterationListComponent,
    ItemComponent,
    ItemFormComponent,
    FooterComponent,
    LookupComponent,
    IterationLookupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
