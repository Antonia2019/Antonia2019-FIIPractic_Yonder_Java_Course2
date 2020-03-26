package fii.practic.health.control.service;

import fii.practic.health.entity.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> getAll();

    Patient getById(Long id);

    Patient save(Patient patient);

    Optional<Patient> update(Patient patient);

    Optional<Patient> deletePatient(Long id);

}
