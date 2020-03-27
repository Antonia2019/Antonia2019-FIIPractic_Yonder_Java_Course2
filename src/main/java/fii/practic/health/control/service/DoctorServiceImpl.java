package fii.practic.health.control.service;

import fii.practic.health.entity.model.Doctor;
import fii.practic.health.entity.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findDoctorsByPatientsFirstName(String firstName) {
        return doctorRepository.findDoctorsByPatientsFirstName(firstName);
    }

    @Override
    public Doctor update(Doctor doctor) {
        Optional<Doctor> doctorUpdate = doctorRepository.findById(doctor.getId());
        return doctorRepository.save(doctorUpdate.get());
    }

    @Override
    public void deleteDoctor(Long id) {
        Optional<Doctor> doctorDB = doctorRepository.findById(id);
        doctorRepository.delete(doctorDB.get());
    }
}
