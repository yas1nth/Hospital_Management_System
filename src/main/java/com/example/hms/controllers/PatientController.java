package com.example.hms.controllers;

import com.example.hms.models.Patient;
import com.example.hms.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

  @Autowired
  private PatientService patientService;

  @GetMapping
  public List<Patient> getAllPatients(){
    return patientService.getAllPatients();
  }

  @PostMapping
  public Patient createPatient(@RequestBody Patient patient){
    return patientService.savePatient(patient);
  }

  @GetMapping("/{id}")
  public Patient getPatientById(@PathVariable Long id){
    System.out.println("Getting patient by id");
    return patientService.getPatientById(id);
  }

  @DeleteMapping("/{id}")
  public void deletePatient(@PathVariable Long id){
    System.out.println("Deleting patient by id");
    patientService.deletePatient(id);
  }

  @PutMapping("/{id}")
  public Patient updatePatient(@PathVariable Long id,@RequestBody Patient patient){
    System.out.println("Updating patient by id");
    return patientService.updatePatient(id,patient);
  }
}
