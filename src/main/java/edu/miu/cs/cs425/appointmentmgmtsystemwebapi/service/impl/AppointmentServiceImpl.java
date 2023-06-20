package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.impl;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Appointment;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.repository.AppointmentRepository;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.repository.PatientRepository;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);

    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment Id does not exist"));
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return  appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAllVipAppointment() {
        var appointments = appointmentRepository.findAll();
        var vip = appointments.stream()
                .filter(appointment -> appointment.getPatient().getDateOfBirth()
                        .isBefore(LocalDate.now().minusYears(65)))
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .collect(Collectors.toList());

        {
            return vip;
        }
    }

    @Override
    public List<Appointment> getAllUpcomingAppointments() {
       return getAllAppointment().stream()
                .filter(appointment -> appointment.getAppointmentDate().isAfter(LocalDate.now()))
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppiontmentTime))
                .collect(Collectors.toList());

    }


    @Override
    public void deleteAppointmentById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);

    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        appointmentRepository.findById(appointment.getAppointmentId()).orElseThrow(()-> new RuntimeException("Appointment Id Does not Exist"));
        return appointmentRepository.save(appointment);
    }
}
