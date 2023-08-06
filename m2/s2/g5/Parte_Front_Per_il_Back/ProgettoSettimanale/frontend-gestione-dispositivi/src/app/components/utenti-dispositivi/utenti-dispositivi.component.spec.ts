import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtentiDispositiviComponent } from './utenti-dispositivi.component';

describe('UtentiDispositiviComponent', () => {
  let component: UtentiDispositiviComponent;
  let fixture: ComponentFixture<UtentiDispositiviComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UtentiDispositiviComponent]
    });
    fixture = TestBed.createComponent(UtentiDispositiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
