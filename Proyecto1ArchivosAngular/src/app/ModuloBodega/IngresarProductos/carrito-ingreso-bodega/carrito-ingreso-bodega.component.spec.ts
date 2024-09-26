import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarritoIngresoBodegaComponent } from './carrito-ingreso-bodega.component';

describe('CarritoIngresoBodegaComponent', () => {
  let component: CarritoIngresoBodegaComponent;
  let fixture: ComponentFixture<CarritoIngresoBodegaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarritoIngresoBodegaComponent]
    });
    fixture = TestBed.createComponent(CarritoIngresoBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
