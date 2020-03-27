package fii.practic.health.control.service;

import fii.practic.health.boundry.dto.PatientDTO;
import fii.practic.health.entity.model.Patient;
import fii.practic.health.entity.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {


    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient toUpdatePatient) {
        Optional<Patient> existingPatient = patientRepository.findById(toUpdatePatient.getId());
        return patientRepository.save(existingPatient.get());
    }

    @Override //functioneaza
    public void deletePatient(Long id) {
        Optional<Patient> patientDb = patientRepository.findById(id);
        patientRepository.delete(patientDb.get());
    }

}
