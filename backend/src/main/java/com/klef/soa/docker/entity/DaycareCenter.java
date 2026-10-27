package com.klef.soa.docker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class DaycareCenter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center Name is required")
    private String centerName;

    @NotBlank(message = "Location is required")
    private String location;

    @Min(value = 1)
    @Max(value = 500)
    private Integer childCapacity;

    private Boolean licensed;
}
