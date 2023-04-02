package com.example.demo.rental.service;

import com.example.demo.place.dto.PlaceDto;
import com.example.demo.place.entity.Place;
import com.example.demo.rental.entity.Rental;
import com.example.demo.rental.repository.RentalRepository;
import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RentalService {
    private  final RentalRepository rentalRepository;

    public void createRental(LocalDateTime RentalStart, LocalDateTime RentalEnd, String Person, User user, Place place){
        Rental rental=new Rental();
        rental.setRentalstart(RentalStart);
        rental.setRentalend(RentalEnd);
        rental.setPerson(Person);
        rental.setUser(user);
        rental.setPlace(place);
        this.rentalRepository.save(rental);
    }

    public Optional<Rental> getRental(String rentalid){
        return rentalRepository.findById(rentalid);
    }
}
