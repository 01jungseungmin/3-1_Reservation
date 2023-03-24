package com.example.demo.rental.entity;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RentalCreateForm {
    @NotEmpty(message = "시설 이용 시작 시간은 필수항목입니다.")
    private String rentalstart;

    @NotEmpty(message = "시설 이용 종료 시간은 필수항목입니다.")
    private String placelocation;

    @NotEmpty(message = "시설 이용자 이름은 필수항목입니다.")
    private String person;
}
