package com.example.demo.rental.entity;

import com.example.demo.place.entity.Place;
import com.example.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="rental")
public class Rental {
    @Id
    private String rentalid= UUID.randomUUID().toString();

    private String rentalstart;

    private String rentalend;

    private String person;

    @ManyToOne
    @JoinColumn(name="userhash")
    private User user;

    @ManyToOne
    @JoinColumn(name="placeid")
    private Place place;
}
