package com.hitesh.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Setter
@Getter
@Table(name = "patient_tbl",uniqueConstraints = {
          @UniqueConstraint(name = "Unique_Patient_Email",columnNames = {"email"}),
        @UniqueConstraint(name = "unique_name_birthDate",columnNames = {"name","birthDate"})
        },
        indexes = {
                 @Index(name ="idx_patient_birthDate",columnList ="birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birthDate;
    private String name;
    private String Email;
    private String gender;
}
