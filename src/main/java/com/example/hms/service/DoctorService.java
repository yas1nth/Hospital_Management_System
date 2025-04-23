package com.example.hms.service;

import com.example.hms.models.Doctor;
import com.example.hms.repository.DoctorRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

   public List<Doctor> getAllDoctors() {
       return doctorRepository.findAll();
   }

   public Doctor getDoctorById(Long id) {
       return doctorRepository.findById(id).orElse(null);
   }

   public Doctor saveDoctor(Doctor doctor) {
       return doctorRepository.save(doctor);
   }

   public Doctor updateDoctor(Long id,Doctor doctor){
     Doctor existingDoc = doctorRepository.findById(id).orElse(null);
      if (existingDoc != null) {
          existingDoc.setName(doctor.getName());
          existingDoc.setSpeciality(doctor.getSpeciality());
          existingDoc.setGender(doctor.getGender());
          return doctorRepository.save(existingDoc);
      }
      return null;
   }

   public void deleteDoctor(Long id) {
       doctorRepository.deleteById(id);
   }
}
