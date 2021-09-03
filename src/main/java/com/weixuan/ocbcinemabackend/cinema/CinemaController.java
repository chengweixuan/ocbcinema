package com.weixuan.ocbcinemabackend.cinema;

import com.weixuan.ocbcinemabackend.repository.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/getSeats")
    public List<Seat> getSeats() {
        return cinemaService.getSeats();
    }

    @PostMapping("/bookSeat")
    public Seat bookSeat(@RequestParam int seatNo, @RequestParam String name, @RequestParam String email) {
        return cinemaService.bookSeat(seatNo, name, email);
    }

    @GetMapping("/test")
    public Seat test() {
        return cinemaService.throwException();
    }
}
