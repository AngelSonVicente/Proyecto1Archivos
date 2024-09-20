import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuloCajeroComponent } from './modulo-cajero.component';

describe('ModuloCajeroComponent', () => {
  let component: ModuloCajeroComponent;
  let fixture: ComponentFixture<ModuloCajeroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModuloCajeroComponent]
    });
    fixture = TestBed.createComponent(ModuloCajeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
