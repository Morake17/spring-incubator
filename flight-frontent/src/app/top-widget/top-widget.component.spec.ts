import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TopWidgetComponent, Booking } from './top-widget.component';

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

  it('should get booking data', () => {
    const mockResponse = {
      customerId: 123,
      flightId: 23,
      referenceNumber: 'ABC123'
    };

//    spyOn(component['http'], 'post').and.returnValue(of(mockResponse));

    component.getBookingData();

    expect(component['http'].post).toHaveBeenCalledWith('http://localhost:8080/bookings', { customerId: 123, flightId: 23 });
    expect(component.booking.length).toEqual(1);
    expect(component.booking[0] instanceof Booking).toBeTruthy();
    expect(component.booking[0].customerId).toEqual(123);
    expect(component.booking[0].flightId).toEqual(23);
    expect(component.booking[0].referenceNumber).toEqual('ABC123');
  });
});
