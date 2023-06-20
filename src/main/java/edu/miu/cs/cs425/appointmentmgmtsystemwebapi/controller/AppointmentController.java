package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.controller;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Appointment;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/amsweb/api/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;


    @GetMapping("/list")
    public ResponseEntity<?> getAllAppointment(){
        return new ResponseEntity<>(appointmentService.getAllAppointment(),HttpStatus.OK);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByid(@PathVariable Long id){
        try{
            return new ResponseEntity<>(appointmentService.getAppointmentById(id),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/vip/list")
    public ResponseEntity<?> getAllVipAppointment(){
        return new ResponseEntity<>(appointmentService.getAllVipAppointment(),HttpStatus.OK);

    }
    @GetMapping("/upcoming/list")
    public ResponseEntity<?> getAllUpcomingAppointments(){
        return new ResponseEntity<>(appointmentService.getAllUpcomingAppointments(),HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<?> addNewAppointment(@RequestBody Appointment appointment){
        return new ResponseEntity<>(appointmentService.addAppointment(appointment),HttpStatus.OK);
    }

@PutMapping("/update/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable Long id,@RequestBody Appointment appointment){
        try{
            appointment.setAppointmentId(id);
            return new ResponseEntity<>(appointmentService.updateAppointment(appointment),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
}



}
