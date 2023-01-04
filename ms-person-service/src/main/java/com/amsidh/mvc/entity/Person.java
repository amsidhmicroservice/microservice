package com.amsidh.mvc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize
public class Person {
    @Id
    private Long personId;
    private String name;
    private Long mobileNumber;
    private String emailId;
}

