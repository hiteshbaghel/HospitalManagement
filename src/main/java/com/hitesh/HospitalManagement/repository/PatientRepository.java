package com.hitesh.HospitalManagement.repository;

import com.hitesh.HospitalManagement.entity.Patient;
import com.hitesh.HospitalManagement.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    Patient findByNameAndEmail(String name , String Email);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate , String email);
    Patient findByBirthDate(LocalDate date);
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByNameContainingOrderByIdDesc(String name);
    @Query("SELECT p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroup);
}
