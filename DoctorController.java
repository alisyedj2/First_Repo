package com.hospitalmanagementsystem3.Hospital.management.system3.controller;

import com.hospitalmanagementsystem3.Hospital.management.system3.models.Doctor;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Hospital;
import com.hospitalmanagementsystem3.Hospital.management.system3.service.DoctorService;
import com.hospitalmanagementsystem3.Hospital.management.system3.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    HospitalService hospitalService;
    @GetMapping("/getAllDoctor")
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }
    @PostMapping("/register")
    public String register(@RequestBody Doctor obj){
        doctorService.registerDoctor(obj);
        return "Doctor added successfully";
    }

}
