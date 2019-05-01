import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IterationLookupComponent } from './iteration-lookup.component';

describe('IterationLookupComponent', () => {
  let component: IterationLookupComponent;
  let fixture: ComponentFixture<IterationLookupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IterationLookupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IterationLookupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
