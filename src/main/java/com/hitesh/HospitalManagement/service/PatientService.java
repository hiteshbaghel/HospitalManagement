package com.hitesh.HospitalManagement.service;

import com.hitesh.HospitalManagement.entity.Patient;
import com.hitesh.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        p1.setName("Rohit Sharma");
        patientRepository.save(p1);
        return p1;
    }
}
