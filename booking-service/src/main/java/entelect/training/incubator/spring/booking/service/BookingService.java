package entelect.training.incubator.spring.booking.service;

import entelect.training.incubator.spring.booking.controller.BookingController;
import entelect.training.incubator.spring.booking.model.Booking;
import entelect.training.incubator.spring.booking.model.BookingSearchRequest;
import entelect.training.incubator.spring.booking.model.SearchType;
import entelect.training.incubator.spring.booking.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.*;
import java.util.function.Supplier;

@Component
public class BookingService {
    private final Logger LOGGER = LoggerFactory.getLogger(BookingService.class);
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking getBooking(Integer id) {
        Optional<Booking> BookingOptional = bookingRepository.findById(id);
        return BookingOptional.orElse(null);
    }

    public List<Booking> searchBooking1(Booking booking){
        List<Booking> answer = new ArrayList<>();
        for(Booking temp : bookingRepository.findAll()){
            LOGGER.info("The customer Id is "+temp.getCustomerId());
            if(temp.getCustomerId() == booking.getCustomerId()){
                answer.add(temp);
            }
        }
        return answer;
    }

    public List<Booking> searchBooking2(Booking booking){
        List<Booking> answer = new ArrayList<>();
        for(Booking temp : bookingRepository.findAll()){
            if(temp.getReferenceNumber().equals(booking.getReferenceNumber())){
                answer.add(temp);
            }
        }
        return answer;
    }


    public List<Booking> searchBooking(Booking booking){

        LOGGER.info("The size of the booking database is "+bookingRepository.findAll().spliterator().getExactSizeIfKnown());

        if(booking.getCustomerId() == 0){
            return searchBooking2(booking);
        }
        return searchBooking1(booking);
    }
}
