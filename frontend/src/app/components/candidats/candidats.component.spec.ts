import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatsComponent } from './candidats.component';

describe('CandidatsComponent', () => {
  let component: CandidatsComponent;
  let fixture: ComponentFixture<CandidatsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CandidatsComponent]
    });
    fixture = TestBed.createComponent(CandidatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
