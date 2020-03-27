package fii.practic.health.boundry.dto;


import fii.practic.health.entity.model.Email;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PatientDTO {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Integer age;

    private String emailAddress;

    private String address;

    private String phoneNumber;

    private Long doctorId;


}
