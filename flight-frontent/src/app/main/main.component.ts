import { Component, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OnInit, Injectable } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent{
  public booking: Booking[];

  constructor(private http: HttpClient) {
    this.booking = [];
  }

  public getBookingData(customerId : number, referenceNumber : number) {
    const body = {"customerId": customerId, "flightId": referenceNumber};
    return this.http.post<any>('http://localhost:8080/bookings', body);
  }
}

export class Booking {
  constructor(
    @Inject('customerId') public customerId: number,
      public flightId: number,
      public referenceNumber: string
  ) {}
}