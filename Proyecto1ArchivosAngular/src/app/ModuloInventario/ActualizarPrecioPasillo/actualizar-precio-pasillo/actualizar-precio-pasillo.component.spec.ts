import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarPrecioPasilloComponent } from './actualizar-precio-pasillo.component';

describe('ActualizarPrecioPasilloComponent', () => {
  let component: ActualizarPrecioPasilloComponent;
  let fixture: ComponentFixture<ActualizarPrecioPasilloComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActualizarPrecioPasilloComponent]
    });
    fixture = TestBed.createComponent(ActualizarPrecioPasilloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
