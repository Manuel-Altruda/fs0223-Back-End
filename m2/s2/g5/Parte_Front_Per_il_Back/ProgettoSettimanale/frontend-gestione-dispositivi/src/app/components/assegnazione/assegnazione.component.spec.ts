import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssegnazioneComponent } from './assegnazione.component';

describe('AssegnazioneComponent', () => {
  let component: AssegnazioneComponent;
  let fixture: ComponentFixture<AssegnazioneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssegnazioneComponent]
    });
    fixture = TestBed.createComponent(AssegnazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
