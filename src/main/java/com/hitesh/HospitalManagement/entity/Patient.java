package com.hitesh.HospitalManagement.entity;

import com.hitesh.HospitalManagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Setter
@Getter
@Table(uniqueConstraints = {
        //  @UniqueConstraint(name = "Unique_Patient_Email", columnNames = {"email"}),
        @UniqueConstraint(name = "unique_name_birthDate", columnNames = {"name", "birthDate"})
},
        indexes = {
                @Index(name = "idx_patient_birthDate", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    //    @ToString.Exclude
    private LocalDate birthDate;
    @Column(unique = true, nullable = false)
    private String Email;
    private String gender;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
}
