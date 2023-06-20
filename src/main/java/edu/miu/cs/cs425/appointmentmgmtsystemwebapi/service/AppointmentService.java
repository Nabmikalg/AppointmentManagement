package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Appointment;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AppointmentService {
    Appointment addAppointment(Appointment appointment);
    Appointment getAppointmentById(Long appointmentId);
    List<Appointment> getAllAppointment();
    void deleteAppointmentById(Long appointmentId);
    Appointment updateAppointment(Appointment appointment);
    List<Appointment> getAllVipAppointment();
    List<Appointment> getAllUpcomingAppointments();

}
