package fii.practic.health.control.service;

import fii.practic.health.entity.model.Patient;
import fii.practic.health.entity.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

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
    public Patient save(Patient doctor) {
        return patientRepository.save(doctor);
    }

    @Override
    public Optional<Patient> update(Patient patient) {
        return patientRepository.findById(patient);
    }

    @Override
    public Optional<Patient> deletePatient(Long id) {
        return patientRepository.findById(id);
    }

//    @Override
//    public void deletePatient(Long id) {
//         patientRepository.deleteById(id);
//    }

}
