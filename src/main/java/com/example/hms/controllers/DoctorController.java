package com.example.hms.controllers;

import com.example.hms.models.Doctor;
import com.example.hms.service.DoctorService;
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
@RequestMapping("/api/v1/doctors")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  @GetMapping
  public List<Doctor> getAllDoctors(){
    System.out.println("Fetching all doctors");
    return doctorService.getAllDoctors();
  }

  @PostMapping
  public Doctor createDoctor(@RequestBody Doctor doctor){
    System.out.println("Creating Doctor");
    return doctorService.saveDoctor(doctor);
  }

  @GetMapping("/{id}")
  public Doctor getDoctorById(@PathVariable Long id){
    System.out.println("Fetching doctor by id");
    return doctorService.getDoctorById(id);
  }

  @PutMapping("/{id}")
  public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
    System.out.println("Updating doctor by id");
    return doctorService.updateDoctor(id, doctor);
  }

  @DeleteMapping("/{id}")
  public void deleteDoctor(@PathVariable Long id){
    System.out.println("Deleting doctor by id");
    doctorService.deleteDoctor(id);
  }

}
