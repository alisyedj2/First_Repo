package com.hospitalmanagementsystem3.Hospital.management.system3.service;

import com.hospitalmanagementsystem3.Hospital.management.system3.models.Doctor;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Hospital;
import com.hospitalmanagementsystem3.Hospital.management.system3.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalService hospitalService;

    public List<Doctor> getAllDoctor(){
        return doctorRepository.getAllDoctor();
    }
    public void registerDoctor(Doctor d){
        d.setDocId(UUID.randomUUID());

      Hospital hospital=hospitalService.getHospitalByID(d.getHospitalId());
      hospital.getDoctors().add(d);
        doctorRepository.registerDoctor(d);
    }

}
