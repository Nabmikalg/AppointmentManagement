package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.repository;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> getAppointmentByAppointmentDateGreaterThanEqual(LocalDate date);
}
