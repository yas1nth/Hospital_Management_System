package com.example.hms.controllers;

import com.example.hms.models.Appointment;
import com.example.hms.service.AppointmentService;
import com.example.hms.service.WebhookService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @Autowired
  private WebhookService webhookService;

  @PostMapping
  public Appointment createAppointment(@RequestBody Appointment appointment){
    System.out.println("Creating Appointment");

    Appointment appointmentCreated = appointmentService.saveAppointment(appointment);

    //Create the Payload for Appointment Webhook Call
    Map<String,Object> payload = new HashMap<>();
    payload.put("Appointment Id", appointment.getId());
    payload.put("Doctor Id", appointment.getDoctorId());
    payload.put("Patient Id", appointment.getPatientId());
    payload.put("Date", appointment.getDate());

    //Send the payload to webhook
    String webhookUrl = "http://localhost:8081/webhook";
    webhookService.sendWebhook(webhookUrl, payload);

    return appointmentCreated;
  }

  @GetMapping
  public List<Appointment> getAllAppointments(){
    System.out.println("Fetching all appointments");
    return appointmentService.getAllAppointments();
  }

  @GetMapping("/{id}")
  public Appointment getAppointmentById(@PathVariable Long id){
    System.out.println("Fetching appointment by id");
    return appointmentService.getAppointmentById(id);
  }

  @PutMapping("/{id}")
  public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment){
    System.out.println("Updating appointment by id");
    return appointmentService.updateAppointment(id, appointment);
  }

  @DeleteMapping("/{id}")
  public void deleteAppointment(@PathVariable Long id){
    System.out.println("Deleting appointment by id");
    appointmentService.deleteAppointment(id);
  }
}
