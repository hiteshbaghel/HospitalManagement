package com.hitesh.HospitalManagement;

import com.hitesh.HospitalManagement.entity.Patient;
import com.hitesh.HospitalManagement.repository.PatientRepository;
import com.hitesh.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Test
    public void patientRepositoryTest(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethod(){
        Patient patient = patientService.getPatientById(1L);
        System.out.println(patient);
    }
}
