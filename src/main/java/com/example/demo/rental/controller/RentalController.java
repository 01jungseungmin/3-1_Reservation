package com.example.demo.rental.controller;

import com.example.demo.place.entity.Place;
import com.example.demo.place.service.PlaceService;
import com.example.demo.rental.entity.Rental;
import com.example.demo.rental.entity.RentalCreateForm;
import com.example.demo.rental.service.RentalService;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RentalController {
    private  final RentalService rentalService;
    private final UserService userService;
    private final PlaceService placeService;


    @GetMapping("/reservation/{placeid}")
    @PostMapping("/reservation/{placeid}")
    public String Reservation(RentalCreateForm rentalCreateForm,@PathVariable("placeid") String placeid, Model model){
        Place place=this.placeService.getPlace(placeid);
        model.addAttribute("places",place);

        return "reservation.html";
    }

    @PostMapping("/sendRental/{placeid}")
    public String Reservationing(@Valid RentalCreateForm rentalCreateForm, Principal principal,@PathVariable("placeid") String placeid, Model model) throws Exception{
        User user=this.userService.getUser(principal.getName());
        Place place=this.placeService.getPlace(placeid);
        model.addAttribute("places",place);
        this.rentalService.createRental(place, user,rentalCreateForm.getRentaldate(),rentalCreateForm.getRentaltime());

        return "redirect:/user";
    }

    @GetMapping("/admin/user/rental")
    public String UserRental(Model model){
        List<Rental> rentals=rentalService.findRentals();
        model.addAttribute("rentals",rentals);
        return "UserRentalPlace.html";
    }
}
