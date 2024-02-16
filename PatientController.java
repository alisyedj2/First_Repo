package com.hospitalmanagementsystem3.Hospital.management.system3.controller;

import com.hospitalmanagementsystem3.Hospital.management.system3.models.Patient;
import com.hospitalmanagementsystem3.Hospital.management.system3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
   @PostMapping("/register")
   public String registerPatient(@RequestBody Patient obj){
       patientService.register(obj);
       return "Patient got registered successfully";
   }
   @GetMapping("/{pid}/details")
   public Patient getPatientById(@PathVariable UUID pid){
       Patient p=patientService.getPatientById(pid);
       return p;
   }

}
