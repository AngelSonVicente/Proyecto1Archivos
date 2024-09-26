import { TestBed } from '@angular/core/testing';

import { CarritoBodegaService } from './carrito-bodega.service';

describe('CarritoBodegaService', () => {
  let service: CarritoBodegaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarritoBodegaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
