package fii.practic.health.boundry.dto;


import fii.practic.health.entity.model.Email;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class DoctorDTO {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String speciality;

    private String address;

    private String phoneNumber;

    private String emailAddress;

//    private List<Patient> patients;

}
