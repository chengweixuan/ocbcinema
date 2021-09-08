package com.weixuan.ocbcinemabackend.cinema;

import com.weixuan.ocbcinemabackend.repository.Seat;
import com.weixuan.ocbcinemabackend.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    final static int CINEMA_SIZE = 30;

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

                sendEmail(name, email, seatNo);

                return seatRepository.save(seat);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat Not Found");
        }
    }

    public void clearCinema() {
        for (int i = 1; i <= CINEMA_SIZE; i++) {
            Seat emptySeat = new Seat();

            emptySeat.setId(i);
            emptySeat.setBooked(false);
            emptySeat.setName("");
            emptySeat.setEmail("");

            seatRepository.deleteById(i);
            seatRepository.save(emptySeat);
        }
    }

    public void sendEmail(String name, String email, int seatNo) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Booking For OCBCinema Confirmation");
        message.setText("Hi " + name + "! \nThank your for booking a seat at OCBCinema! \n\n\n Your seat number is " +
                seatNo);

        javaMailSender.send(message);
    }
}
