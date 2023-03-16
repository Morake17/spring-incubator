package entelect.training.incubator.spring.booking.model;


import lombok.Data;

@Data
public class BookingSearchRequest {
    private String customerId;
    private String referenceId;
}
