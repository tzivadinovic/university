import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteCashRegisterComponent } from './delete-cash-register.component';

describe('DeleteCashRegisterComponent', () => {
  let component: DeleteCashRegisterComponent;
  let fixture: ComponentFixture<DeleteCashRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteCashRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteCashRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
