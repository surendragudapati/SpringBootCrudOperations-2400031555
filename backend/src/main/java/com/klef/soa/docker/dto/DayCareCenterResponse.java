package com.klef.soa.docker.dto;

import lombok.Data;

@Data
public class DayCareCenterResponse
{
    private Long id;
    private String centerName;
    private String location;
    private Integer childCapacity;
    private Boolean licensed;
}