import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaFipeComponent } from './consulta-fipe.component';

describe('ConsultaFipeComponent', () => {
  let component: ConsultaFipeComponent;
  let fixture: ComponentFixture<ConsultaFipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultaFipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultaFipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
