import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarritoIngresoSucursalComponent } from './carrito-ingreso-sucursal.component';

describe('CarritoIngresoSucursalComponent', () => {
  let component: CarritoIngresoSucursalComponent;
  let fixture: ComponentFixture<CarritoIngresoSucursalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarritoIngresoSucursalComponent]
    });
    fixture = TestBed.createComponent(CarritoIngresoSucursalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
