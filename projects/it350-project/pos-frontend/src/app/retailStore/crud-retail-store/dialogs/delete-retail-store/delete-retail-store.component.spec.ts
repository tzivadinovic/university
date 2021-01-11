import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteRetailStoreComponent } from './delete-retail-store.component';

describe('DeleteRetailStoreComponent', () => {
  let component: DeleteRetailStoreComponent;
  let fixture: ComponentFixture<DeleteRetailStoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteRetailStoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteRetailStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
