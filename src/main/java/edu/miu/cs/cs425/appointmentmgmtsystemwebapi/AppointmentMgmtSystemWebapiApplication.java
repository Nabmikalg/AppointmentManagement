package edu.miu.cs.cs425.appointmentmgmtsystemwebapi;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Appointment;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Patient;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.repository.AppointmentRepository;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.AppointmentService;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@RequiredArgsConstructor
public class AppointmentMgmtSystemWebapiApplication {//implements ApplicationRunner {
   private final AppointmentService appointmentService;
   private final PatientService patientService;

    public static void main(String[] args) {
        SpringApplication.run(AppointmentMgmtSystemWebapiApplication.class, args);

    }

//    @Transactional
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        var patient1= new Patient(null,"EP117","Anna","Smith",LocalDate.of(1958,03,26),null);
//        var patient2= new Patient(null,"P101","Bob","Jones",LocalDate.of(1997,12,18),null);
//
////          var savePatient1= patientService.addPatient(patient1);
////          var savePatient2= patientService.addPatient(patient2);
//
//        var appointment1= new Appointment(null, LocalDate.of(2023,9,1), LocalTime.of(10,00,00),
//                "Dr Tony Elliot","D4 Med Plaza",patient1);
//        var appointment2= new Appointment(null, LocalDate.of(2023,4,30), LocalTime.of(14,30,00),
//                null,"D4 Med Plaza", patient2);
//        var appointment3= new Appointment(null, LocalDate.of(2023,11,15), LocalTime.of(18,00,00),
//                "Dr Robin Pelvic",null,patient1);
//        var savedappointment1= appointmentService.addAppointment(appointment1);
//        var savedappointment2= appointmentService.addAppointment(appointment2);
//        var savedappointment3= appointmentService.addAppointment(appointment3);
//


}
