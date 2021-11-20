import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProcurementComponent } from './edit-procurement.component';

describe('EditProcurementComponent', () => {
  let component: EditProcurementComponent;
  let fixture: ComponentFixture<EditProcurementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditProcurementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProcurementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
