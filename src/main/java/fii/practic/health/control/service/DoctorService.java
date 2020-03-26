package fii.practic.health.control.service;

import fii.practic.health.entity.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> getAll();

    Doctor getById(Long id);

    Doctor save(Doctor doctor);

    List<Doctor> findDoctorsByPatientsFirstName(String firstName);

    Optional<Doctor> update(Doctor doctor);

    void deleteDoctor(Long id);

}
