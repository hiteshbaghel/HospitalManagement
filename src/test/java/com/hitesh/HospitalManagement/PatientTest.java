package com.hitesh.HospitalManagement;

import com.hitesh.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.hitesh.HospitalManagement.entity.Patient;
import com.hitesh.HospitalManagement.repository.PatientRepository;
import com.hitesh.HospitalManagement.service.PatientService;
import com.hitesh.HospitalManagement.type.BloodGroupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;

    @Test
    public void patientRepositoryTest() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethod() {
//        Patient patient = patientService.getPatientById(1L);
//
//        Patient patient1 = patientRepository.findById(1L).orElseThrow(()-> new IllegalArgumentException("Patient not found ID : " + patient.getId()));
//        System.out.println(patient1);
//
//        Patient patient = patientRepository.findByName("Neha Iyer");
//
//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1992,12,1), "kabir.singh@example.com");
//
//        List<Patient> patientList = patientRepository.findByBirthDateBetween(LocalDate.of(1990,5,10),LocalDate.of(1995,8,20));
//
//        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("Di");
//
//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//
//        List<Patient> patientList = patientRepository.findByBornAfterBirthDate(LocalDate.of(1990,5,10));

//        List<Patient> patientList = patientRepository.findAllPatient();
//        for (Patient patient : patientList) {
//            System.out.println(patient);
//        }

//        List<Object[]> bloudGroupList = patientRepository.countEachBloodGroup();
//        for(Object [] objects :bloudGroupList){
//            System.out.println(objects[0]+" "+objects[1]);
//        }

//        int rowsUpdated = patientRepository.patientUpdateNameWithId("Arav Sharma", 1L);
//        System.out.println(rowsUpdated);

        List<BloodGroupCountResponseEntity> bloudGroupList = patientRepository.countEachBloodGroup();
        for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity :bloudGroupList){
            System.out.println(bloodGroupCountResponseEntity);
        }

    }
}
