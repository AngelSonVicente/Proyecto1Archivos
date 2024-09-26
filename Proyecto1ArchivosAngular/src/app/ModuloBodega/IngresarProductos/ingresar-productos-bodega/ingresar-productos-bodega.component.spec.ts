import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresarProductosBodegaComponent } from './ingresar-productos-bodega.component';

describe('IngresarProductosBodegaComponent', () => {
  let component: IngresarProductosBodegaComponent;
  let fixture: ComponentFixture<IngresarProductosBodegaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IngresarProductosBodegaComponent]
    });
    fixture = TestBed.createComponent(IngresarProductosBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
