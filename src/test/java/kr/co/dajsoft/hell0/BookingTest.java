package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.entity.Booking;
import kr.co.dajsoft.hell0.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingTest {

    @Autowired
    private BookingRepository bookingRepository;

    //@Test
    public void insertBooking(){
        Booking booking = Booking.builder().bookingNAME("정효재").bookingPAYMENT("O").bookingPLACEADDRESS("서울시 서대문구").bookingPLACENAME("우리집").bookingTEAMMEMBER(11).build();
        bookingRepository.save(booking);

    }
}
