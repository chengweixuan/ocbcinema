package com.weixuan.ocbcinemabackend.cinema;

import com.weixuan.ocbcinemabackend.repository.Seat;
import com.weixuan.ocbcinemabackend.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    public Seat throwException() {
        throw  new ResponseStatusException(HttpStatus.CONFLICT, "Seat Is Booked");
    }

    public Seat bookSeat(int seatNo, String name, String email) {
        Seat seat = new Seat();

        if (seatRepository.existsById(seatNo)) {
            boolean isBooked = seatRepository.getById(seatNo).isBooked();
            if (isBooked) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Seat is Booked");
            } else {
                seat.setId(seatNo);
                seat.setBooked(true);
                seat.setName(name);
                seat.setEmail(email);
                seatRepository.deleteById(seatNo);
                return seatRepository.save(seat);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat Not Found");
        }
    }
}
