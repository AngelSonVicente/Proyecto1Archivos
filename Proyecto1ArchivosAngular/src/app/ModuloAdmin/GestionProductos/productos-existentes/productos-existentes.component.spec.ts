import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductosExistentesComponent } from './productos-existentes.component';

describe('ProductosExistentesComponent', () => {
  let component: ProductosExistentesComponent;
  let fixture: ComponentFixture<ProductosExistentesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductosExistentesComponent]
    });
    fixture = TestBed.createComponent(ProductosExistentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
