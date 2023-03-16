package entelect.training.incubator.spring.booking.controller;

import entelect.training.incubator.spring.booking.model.Booking;
import entelect.training.incubator.spring.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "bookings")
public class BookingController {

    private final BookingService bookingService;

    private final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Integer id) {
        LOGGER.info("Processing booking search request for booking id={}", id);
        Booking customer = this.bookingService.getBooking(id);

        if (customer != null) {
            LOGGER.trace("Found booking");
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }

        LOGGER.trace("Booking not found");
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        LOGGER.info("Processing booking creation request for booking={}", booking);

        final Booking savedCustomer = bookingService.createBooking(booking);

        LOGGER.trace("booking created");
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping(path = "search")
    public ResponseEntity<?> search(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.searchBooking(booking), HttpStatus.OK);
    }
}
