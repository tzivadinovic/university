import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDeliveryProductComponent } from './add-delivery-product.component';

describe('AddDeliveryProductComponent', () => {
  let component: AddDeliveryProductComponent;
  let fixture: ComponentFixture<AddDeliveryProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDeliveryProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDeliveryProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
