package com.example.hms.service;

import com.example.hms.models.Appointment;
import com.example.hms.repository.AppointmentRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

   public List<Appointment> getAllAppointments() {
       return appointmentRepository.findAll();
   }

   public Appointment getAppointmentById(Long id) {
       return appointmentRepository.findById(id).orElse(null);
   }

   public Appointment saveAppointment(Appointment appointment) {
      return appointmentRepository.save(appointment);
   }

   public void deleteAppointment(Long id) {
       appointmentRepository.deleteById(id);
   }

   public Appointment updateAppointment(Long Id,Appointment appointment){
        Appointment existingAppointment = appointmentRepository.findById(Id).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setDate(appointment.getDate());
            existingAppointment.setDoctorId(appointment.getDoctorId());
            existingAppointment.setPatientId(appointment.getPatientId());
            return appointmentRepository.save(existingAppointment);
        }
        return null;
   }

}
