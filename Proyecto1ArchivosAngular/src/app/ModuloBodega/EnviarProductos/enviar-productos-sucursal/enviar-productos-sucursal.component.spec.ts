import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnviarProductosSucursalComponent } from './enviar-productos-sucursal.component';

describe('EnviarProductosSucursalComponent', () => {
  let component: EnviarProductosSucursalComponent;
  let fixture: ComponentFixture<EnviarProductosSucursalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EnviarProductosSucursalComponent]
    });
    fixture = TestBed.createComponent(EnviarProductosSucursalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
