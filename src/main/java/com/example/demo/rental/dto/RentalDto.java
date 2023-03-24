package com.example.demo.rental.dto;

import com.example.demo.place.dto.PlaceDto;
import com.example.demo.user.dto.UserDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class RentalDto {
    private String rentalid= UUID.randomUUID().toString();
    private String rentalstart;
    private String rentalend;
    private String person;
    private UserDTO user;
    private PlaceDto place;
}
