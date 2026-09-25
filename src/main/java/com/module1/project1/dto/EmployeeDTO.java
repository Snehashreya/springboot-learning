package com.module1.project1.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

//    @NotNull(message = "Name is required") // ensures field is not null
//    @NotEmpty(message = "Name cannot should be empty") //size atleast 1 character should be there
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3,max=10, message = "number of characters in name should be in the range 3 -10")
    private String name;

    @NotBlank(message = "Email of employee cannot be blank")
    @Email(message = "email should be a valid email")
    private String email;

    @NotBlank(message = "Age of employee cannot be blank")
    @Max(value =80, message = "age cannot be greater than 80")
    @Min(value =18, message = "age cannot be greater than 18")
    private Integer age;

    @NotBlank(message = "role of employee cannot be blank")
    @Pattern(regexp = "^(ADMIN|USER)$",message = "role of employee should be ADMIN or USER")
    private String role; //ADMIN //USER

    @PastOrPresent(message = "data of joining cannot be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "employee should be active")
    private Boolean isActive;

    @NotBlank
    @Positive(message = "Salary of employee should be positive")
    @Digits(integer = 6, fraction = 2,message = "salary can be in the form XXXX.YY")
    @DecimalMax(value = "10000.99")
    @DecimalMin(value = "100.99")
    private Double salary;

}
