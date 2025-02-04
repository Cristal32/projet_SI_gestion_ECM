import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TuteursComponent } from './tuteurs.component';

describe('TuteursComponent', () => {
  let component: TuteursComponent;
  let fixture: ComponentFixture<TuteursComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TuteursComponent]
    });
    fixture = TestBed.createComponent(TuteursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
