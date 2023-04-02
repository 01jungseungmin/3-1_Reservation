package com.example.demo.rental.controller;

import com.example.demo.place.dto.PlaceDto;
import com.example.demo.place.entity.Place;
import com.example.demo.place.service.PlaceService;
import com.example.demo.rental.entity.RentalCreateForm;
import com.example.demo.rental.service.RentalService;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RentalController {
    private  final RentalService rentalService;
    private final UserService userService;
    private final PlaceService placeService;

    @GetMapping("/reservation/{placeid}")
    @PostMapping("/reservation/{placeid}")
    public String Reservation(RentalCreateForm rentalCreateForm, @PathVariable ("placeid") String placeid,Model model){
        Place place = this.placeService.getPlace(placeid);
        model.addAttribute("placeid", place.getPlaceid());
        model.addAttribute("rentalCreateForm", rentalCreateForm);
        return "reservation.html";
    }

    @PostMapping("/sendRental")
    public String Resrevationing(RentalCreateForm rentalCreateForm, @PathVariable ("placeid") String placeid,Principal principal,Model model){
        User user=this.userService.getUser(principal.getName());
        Place place = this.placeService.getPlace(placeid);
        this.rentalService.createRental(rentalCreateForm.getRentalstart(),rentalCreateForm.getRentalend(),rentalCreateForm.getPerson(),user, place);
        return "redirect:/user";
    }
}
