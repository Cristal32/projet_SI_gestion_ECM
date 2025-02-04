import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EtudiantsComponent } from './etudiants.component';

describe('EtudiantsComponent', () => {
  let component: EtudiantsComponent;
  let fixture: ComponentFixture<EtudiantsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EtudiantsComponent]
    });
    fixture = TestBed.createComponent(EtudiantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
