import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopWidget1Component } from './top-widget1.component';

describe('TopWidget1Component', () => {
  let component: TopWidget1Component;
  let fixture: ComponentFixture<TopWidget1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopWidget1Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopWidget1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
