package com.hospitalmanagementsystem3.Hospital.management.system3.service;

import com.hospitalmanagementsystem3.Hospital.management.system3.HospitalManagementSystem3Application;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Bed;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Hospital;
import com.hospitalmanagementsystem3.Hospital.management.system3.repository.BedRepository;
import com.hospitalmanagementsystem3.Hospital.management.system3.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BedService {
    @Autowired
    BedRepository bedRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    public Bed getUnOccupiedBedHospital(UUID hospitalId){
       List<Bed> beds=bedRepository.getAllBeds();
       for(Bed obj:beds){
           if(obj.isBooked()==false&&obj.getHospitalId().toString().equals(hospitalId)){
               return obj;
           }
       }
       return null;
    }
    public void addBed(UUID hospitalId){
        Bed bed=new Bed();
        bed.setBedId(UUID.randomUUID());
        bed.setHospitalId(hospitalId);
       Hospital h= hospitalRepository.getHospitalById(hospitalId);
         h.getBeds().add(bed);
        bedRepository.addBed(bed);
    }
}
