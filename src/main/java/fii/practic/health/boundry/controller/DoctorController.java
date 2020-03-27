package fii.practic.health.boundry.controller;

import javax.validation.constraints.NotNull;
import fii.practic.health.boundry.dto.DoctorDTO;
import fii.practic.health.control.service.PatientService;
import fii.practic.health.entity.model.Doctor;
import fii.practic.health.control.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController {

    private DoctorService doctorService;

    private PatientService patientService;

    private ModelMapper modelMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, PatientService patientService, ModelMapper modelMapper) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Doctor> getAll(){
        return doctorService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Doctor getById(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @GetMapping(value = "/filter")
    public List<Doctor> getDoctorsByPatientsFirstName(@RequestParam(value = "firstName") String firstName){
        return doctorService.findDoctorsByPatientsFirstName(firstName);
    }

    // Nu functioneaza
    @PostMapping
    public Doctor save(@RequestBody Doctor doctor){
        Doctor saveDoctor = doctorService.save(doctor);
        return saveDoctor;
    }

    //  Nu functioneaza -- (Metoda la fel ca la PatientController)
//    @PostMapping
//    public Doctor save(@RequestBody DoctorDTO doctorDTO){
//        return doctorService.save(modelMapper.map(doctorDTO, Doctor.class));
//    }

    @PutMapping
    @RequestMapping(value = "/{id}")
    public Doctor update(@RequestBody Doctor doctor){
        Doctor updateDoctor = doctorService.update(modelMapper.map(doctor, Doctor.class));
        return updateDoctor;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable @NotNull Long id) {
        doctorService.deleteDoctor(id);
    }

}
