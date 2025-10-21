package com.hitesh.HospitalManagement.repository;

import com.hitesh.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.hitesh.HospitalManagement.entity.Patient;
import com.hitesh.HospitalManagement.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterBirthDate(@Param("birthDate")LocalDate birthDate);

    //@Query("SELECT p.bloodGroup,Count(p) from Patient p group by p.bloodGroup ")
    //List<Object[]> countEachBloodGroup ();
    @Query("SELECT new com.hitesh.HospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup,"+"Count(p)) from Patient p group by p.bloodGroup ")
    List<BloodGroupCountResponseEntity> countEachBloodGroup();

    @Query(value = "select * from patient", nativeQuery = true)
  //  List<Patient> findAllPatient();
    Page<Patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int patientUpdateNameWithId(@Param("name") String name,@Param("id") Long id);

}
