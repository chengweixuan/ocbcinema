package com.weixuan.ocbcinemabackend.cinema;

import com.weixuan.ocbcinemabackend.repository.Seat;
import com.weixuan.ocbcinemabackend.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }
}
