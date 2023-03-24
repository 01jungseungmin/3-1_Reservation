package com.example.demo.rental.repository;

import com.example.demo.rental.entity.Rental;
import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,String> {
}
