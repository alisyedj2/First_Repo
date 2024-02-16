package com.hospitalmanagementsystem3.Hospital.management.system3.controller;

import com.hospitalmanagementsystem3.Hospital.management.system3.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bed")
public class BedController {
    @Autowired
    BedService bedService;
    @PostMapping("/add")
    public String add(@RequestParam UUID hospitalId){
        bedService.addBed(hospitalId);
        return "Bed added successfully";
    }
}
