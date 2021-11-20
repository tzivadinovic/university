import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDeliveryProductComponent } from './edit-delivery-product.component';

describe('EditDeliveryProductComponent', () => {
  let component: EditDeliveryProductComponent;
  let fixture: ComponentFixture<EditDeliveryProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditDeliveryProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDeliveryProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
