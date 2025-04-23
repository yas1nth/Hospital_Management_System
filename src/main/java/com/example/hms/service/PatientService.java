package com.example.hms.service;

import com.example.hms.models.Patient;
import com.example.hms.repository.PatientRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

  @Autowired
  private PatientRepository patientRepository;

  private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

   public List<Patient> getAllPatients() {
       return patientRepository.findAll();
   }

   public Patient getPatientById(Long id) {
       return patientRepository.findById(id).orElse(null);
   }

   public Patient savePatient(Patient patient) {
       return patientRepository.save(patient);
   }

   public void deletePatient(Long id) {
       patientRepository.deleteById(id);
   }

   public Patient updatePatient(Long id,Patient patient){
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setName(patient.getName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setGender(patient.getGender());
            return patientRepository.save(existingPatient);
        }
        return null;
   }

}
