import { TestBed } from '@angular/core/testing';

import { TypeStageService } from './type-stage.service';

describe('TypeStageService', () => {
  let service: TypeStageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeStageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
