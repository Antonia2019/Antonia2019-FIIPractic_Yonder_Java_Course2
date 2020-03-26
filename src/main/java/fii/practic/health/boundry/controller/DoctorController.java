package fii.practic.health.boundry.controller;

import fii.practic.health.boundry.dto.DoctorDTO;
import fii.practic.health.control.service.PatientService;
import fii.practic.health.entity.model.Doctor;
import fii.practic.health.control.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public Doctor save(@RequestBody DoctorDTO doctorDTO){
        return doctorService.save(modelMapper.map(doctorDTO, Doctor.class));
    }

    @PutMapping
    @RequestMapping(value = "/{id}")
    public Optional<Doctor> update(@RequestBody DoctorDTO doctorDTO){
        return doctorService.update(modelMapper.map(doctorDTO, Doctor.class));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@RequestBody Long id) {
        doctorService.deleteDoctor(id);
    }

}
