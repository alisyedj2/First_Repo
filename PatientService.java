package com.hospitalmanagementsystem3.Hospital.management.system3.service;


import com.hospitalmanagementsystem3.Hospital.management.system3.models.Bed;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Doctor;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Hospital;
import com.hospitalmanagementsystem3.Hospital.management.system3.models.Patient;
import com.hospitalmanagementsystem3.Hospital.management.system3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
        @Autowired
        HospitalService hospitalService;
        @Autowired
        BedService bedService;
        @Autowired
        PatientRepository patientRepository;
        public void register(Patient p){
            UUID id=UUID.randomUUID();
            p.setpId(id);
            UUID ab=p.getHospitalId();
            Hospital h=hospitalService.getHospitalByID(ab);
            List<Doctor> doctors=h.getDoctors();
            Doctor d=doctors.get(0);
            p.setDocId(d.getDocId());
            d.getPatients().add(p);
//            Doctor doctor=hospitalService.getMinimumPatientDoctorInHospital(p.getHospitalId());
//            p.setDocId(doctor.getDocId());
//            doctor.getPatients().add(p);
//
//             Bed bed=bedService.getUnOccupiedBedHospital(p.getHospitalId());
//             p.setBedId(bed.getBedId());
//            //generate uuid for the patient
//            //get doctor who is handeing minimum number of patient in that particular hospital
//            //get unoccupied bed
//            //set status for the bed with the docId and patientId
//            bed.setBooked(true);
//            bed.setPatient(p.getBedId());
//            bed.setDoctor(doctor.getDocId());

            //save patient to database
           patientRepository.registerPatient(p);

        }
        public Patient getPatientById(UUID id){
         Patient p=   patientRepository.getPatientById(id);
         return p;
        }
}
