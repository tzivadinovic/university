import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteProcurementComponent } from './delete-procurement.component';

describe('DeleteProcurementComponent', () => {
  let component: DeleteProcurementComponent;
  let fixture: ComponentFixture<DeleteProcurementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteProcurementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteProcurementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
