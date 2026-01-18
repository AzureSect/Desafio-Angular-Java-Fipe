import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadoFipeComponent } from './resultado-fipe.component';

describe('ResultadoFipeComponent', () => {
  let component: ResultadoFipeComponent;
  let fixture: ComponentFixture<ResultadoFipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResultadoFipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultadoFipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
