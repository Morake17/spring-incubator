package entelect.training.incubator.spring.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Booking {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random rnd = new SecureRandom();

    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }


    @Id
    private int customerId;
    private int flightId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String referenceNumber  = generateRandomString(7);

    public Booking(int customerId, int flightId, String referenceNumber) {
        this.customerId = customerId;
        this.flightId = flightId;
        this.referenceNumber = referenceNumber;
    }
    public Booking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public Booking(int customerId) {
        this.customerId = customerId;
    }

    public Booking(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }//We are making different contructors for the different sitautons and then
    //we are going to take them into the map then make a seach based on the
    //attribute of intrest in our map

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "customerId=" + customerId +
                ", flightId=" + flightId +
                ", referenceNumber='" + referenceNumber + '\'' +
                '}';
    }
}
