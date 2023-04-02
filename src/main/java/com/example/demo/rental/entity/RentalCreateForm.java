package com.example.demo.rental.entity;


import com.example.demo.place.entity.Place;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RentalCreateForm {
    @NotNull(message = "시설 이용 시작 시간은 필수항목입니다.")
    private LocalDateTime rentalstart;

    @NotNull(message = "시설 이용 종료 시간은 필수항목입니다.")
    private LocalDateTime rentalend;

    @NotEmpty(message = "시설 이용자 이름은 필수항목입니다.")
    private String person;

    private String place;
}
