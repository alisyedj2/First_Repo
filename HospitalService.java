package com.hospitalmanagementsystem3.Hospital.management.system3.service;

import com.hospitalmanagementsystem3.Hospital.management.system3.models.Doctor;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Hospital;
import com.hospitalmanagementsystem3.Hospital.management.system3.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
//service layer invoke repository layer

public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;



    public List<Hospital> getAllHospital(){
        return hospitalRepository.getAllHospital();
    }
    public void registerHospital(Hospital h){
        h.setHospitalID(UUID.randomUUID());
        hospitalRepository.registerHospital(h);
    }
    public Hospital getHospitalByID(UUID id){
        return hospitalRepository.getHospitalById(id);
    }


    public Doctor getMinimumPatientDoctorInHospital(UUID hospitalId){
        Hospital obj=null;
        obj=hospitalRepository.getHospitalById(hospitalId);
        List<Doctor>doctors=obj.getDoctors();
//        Doctor minDoctor=null;
//        int min=Integer.MAX_VALUE;
//        for(Doctor doc:doctors){
//            if(min>doc.getPatients().size()){
//                min=doc.getPatients().size();
//                minDoctor=doc;
//            }
//        }
        return doctors.get(0);
    }
}
