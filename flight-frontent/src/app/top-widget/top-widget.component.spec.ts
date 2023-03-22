import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TopWidgetComponent } from './top-widget.component';

describe('TopWidgetComponent', () => {
  let component: TopWidgetComponent;
  let fixture: ComponentFixture<TopWidgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopWidgetComponent ],
      imports: [ HttpClientTestingModule ],
      providers: [ { provide: 'customerId', useValue: 123 } ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

});
