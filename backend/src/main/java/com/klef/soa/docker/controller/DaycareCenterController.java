package com.klef.soa.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.docker.dto.DayCareCenterRequest;
import com.klef.soa.docker.dto.DayCareCenterResponse;
import com.klef.soa.docker.entity.DaycareCenter;
import com.klef.soa.docker.service.DaycareCenterService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/daycare")
public class DaycareCenterController
{
    @Autowired
    private DaycareCenterService service;

    @GetMapping("/")
    public String test()
    {
        return "Test API Call";
    }

    @PostMapping("/add")
    public ResponseEntity<DayCareCenterResponse> add(
            @Valid @RequestBody DayCareCenterRequest request)
    {
        DaycareCenter center = new DaycareCenter();

        center.setCenterName(request.getCenterName());
        center.setLocation(request.getLocation());
        center.setChildCapacity(request.getChildCapacity());
        center.setLicensed(request.getLicensed());

        DaycareCenter saved = service.add(center);

        DayCareCenterResponse response = new DayCareCenterResponse();

        response.setId(saved.getId());
        response.setCenterName(saved.getCenterName());
        response.setLocation(saved.getLocation());
        response.setChildCapacity(saved.getChildCapacity());
        response.setLicensed(saved.getLicensed());

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<DaycareCenter>> displayAll()
    {
        List<DaycareCenter> centers = service.displayAll();
        return ResponseEntity.ok(centers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)
    {
        String msg = service.deleteById(id);
        return ResponseEntity.ok(msg);
    }
}