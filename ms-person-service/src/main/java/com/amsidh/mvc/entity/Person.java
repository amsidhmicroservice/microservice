package com.amsidh.mvc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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

