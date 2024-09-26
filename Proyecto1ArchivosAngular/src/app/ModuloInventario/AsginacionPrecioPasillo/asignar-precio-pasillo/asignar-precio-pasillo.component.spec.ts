import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsignarPrecioPasilloComponent } from './asignar-precio-pasillo.component';

describe('AsignarPrecioPasilloComponent', () => {
  let component: AsignarPrecioPasilloComponent;
  let fixture: ComponentFixture<AsignarPrecioPasilloComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsignarPrecioPasilloComponent]
    });
    fixture = TestBed.createComponent(AsignarPrecioPasilloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
