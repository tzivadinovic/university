import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteDeliveryProductComponent } from './delete-delivery-product.component';

describe('DeleteDeliveryProductComponent', () => {
  let component: DeleteDeliveryProductComponent;
  let fixture: ComponentFixture<DeleteDeliveryProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteDeliveryProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteDeliveryProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
