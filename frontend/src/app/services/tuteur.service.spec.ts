import { TestBed } from '@angular/core/testing';

import { TuteurService } from './tuteur.service';

describe('TuteurService', () => {
  let service: TuteurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TuteurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
