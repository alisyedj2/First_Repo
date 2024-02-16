package com.hospitalmanagementsystem3.Hospital.management.system3.controller;

import com.hospitalmanagementsystem3.Hospital.management.system3.models.Hospital;
import com.hospitalmanagementsystem3.Hospital.management.system3.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//we are telling this file is from controller package
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/getAllHospital")
    public List<Hospital> getAllHospital(Hospital h){
        return hospitalService.getAllHospital();
    }

    @PostMapping("/registerHospital")
    public String registerHospital(@RequestBody Hospital obj){
        hospitalService.registerHospital(obj);
        return "Hospital added successfully";
    }
    @GetMapping("")
    public Hospital getHospitalById(@RequestParam UUID id){
        return hospitalService.getHospitalByID(id);
    }
}
