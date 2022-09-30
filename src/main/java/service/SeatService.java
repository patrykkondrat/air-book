package service;

import dao.SeatDao;
import model.Flight;
import model.Seat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
public class SeatService {
    private final SeatDao seatDao;

    public SeatService(@Qualifier("seatBooking") SeatDao seatDao) {
        this.seatDao = seatDao;
    }

    public boolean isValidSeat(Seat seat, Flight fligth) {

        return true;
    }

    public int bookSeat (String seat, String flight) {

        return 0;
    }
}