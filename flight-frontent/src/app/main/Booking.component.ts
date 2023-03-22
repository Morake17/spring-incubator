import { HttpClient } from '@angular/common/http';
import { OnInit, Injectable } from '@angular/core';

export class Booking {
    constructor(
        public customerId: number,
        public flightId: number,
        public referenceNumber: string
    ) {
		
	}

}

// @Injectable({
// 	providedIn: 'root'
//   })

// export class User{
	// public booking: Booking[];

	// constructor(private http: HttpClient) {
	// 	this.booking = [];
	// }

	// ngOnInit(): void {
	// 	this.getBookingData();
	// }

	// public getBookingData() {
		
	// 	const body = {"customerId": 123, "flightId": 23};
		
	// 	return this.http.post<any>('http://localhost:8080/bookings', body);
	// }
// }