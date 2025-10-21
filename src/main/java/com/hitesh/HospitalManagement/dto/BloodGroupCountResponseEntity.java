package com.hitesh.HospitalManagement.dto;

import com.hitesh.HospitalManagement.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {
    private BloodGroupType bloodGroup;
    private Long count;

}
