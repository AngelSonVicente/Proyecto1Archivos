import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Reporte5Component } from './reporte5.component';

describe('Reporte5Component', () => {
  let component: Reporte5Component;
  let fixture: ComponentFixture<Reporte5Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Reporte5Component]
    });
    fixture = TestBed.createComponent(Reporte5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
