import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRetailStoreComponent } from './edit-retail-store.component';

describe('EditRetailStoreComponent', () => {
  let component: EditRetailStoreComponent;
  let fixture: ComponentFixture<EditRetailStoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditRetailStoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditRetailStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
