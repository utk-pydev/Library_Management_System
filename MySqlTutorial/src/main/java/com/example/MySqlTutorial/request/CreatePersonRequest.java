package com.example.MySqlTutorial.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePersonRequest {

    @NotBlank(message = "First Name should be empty")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Date of birth should not be empty")
    private String dob;
}
