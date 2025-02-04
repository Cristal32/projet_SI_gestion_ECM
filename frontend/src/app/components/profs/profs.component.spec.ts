import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfsComponent } from './profs.component';

describe('ProfsComponent', () => {
  let component: ProfsComponent;
  let fixture: ComponentFixture<ProfsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfsComponent]
    });
    fixture = TestBed.createComponent(ProfsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
