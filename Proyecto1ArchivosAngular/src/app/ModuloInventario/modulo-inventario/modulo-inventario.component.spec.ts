import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuloInventarioComponent } from './modulo-inventario.component';

describe('ModuloInventarioComponent', () => {
  let component: ModuloInventarioComponent;
  let fixture: ComponentFixture<ModuloInventarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModuloInventarioComponent]
    });
    fixture = TestBed.createComponent(ModuloInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
