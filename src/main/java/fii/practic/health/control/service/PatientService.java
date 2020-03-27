package fii.practic.health.control.service;

import fii.practic.health.boundry.dto.PatientDTO;
import fii.practic.health.entity.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAll();

    Patient getById(Long id);

    Patient save(Patient patient);

    Patient update(Patient toUpdatePatient);

    void deletePatient(Long id);

}
