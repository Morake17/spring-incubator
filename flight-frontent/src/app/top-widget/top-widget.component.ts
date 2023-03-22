import { Component, Inject } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { OnInit, Injectable } from '@angular/core';

@Component({
  selector: 'app-top-widget',
  templateUrl: './top-widget.component.html',
  styleUrls: ['./top-widget.component.css']
})
export class TopWidgetComponent {
  // public booking: Booking[];

  // constructor(private http: HttpClient, @Inject('customerId') private customerId: number) {
  //   this.booking = [];
  // }

  // ngOnInit(): void {
  //   this.getBookingData();
  // }

  // public getBookingData() {
  //   const body = {"customerId": this.customerId, "flightId": 23};
  //   return this.http.post<any>('http://localhost:8080/bookings', body);
  // }
}

// export class Booking {
//   constructor(
//       public customerId: number,
//       public flightId: number,
//       public referenceNumber: string
//   ) {}
// }
