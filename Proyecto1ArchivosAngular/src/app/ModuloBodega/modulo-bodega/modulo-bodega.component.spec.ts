import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuloBodegaComponent } from './modulo-bodega.component';

describe('ModuloBodegaComponent', () => {
  let component: ModuloBodegaComponent;
  let fixture: ComponentFixture<ModuloBodegaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModuloBodegaComponent]
    });
    fixture = TestBed.createComponent(ModuloBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
