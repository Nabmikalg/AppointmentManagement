package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.controller;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Appointment;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Patient;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.AppointmentService;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/AMSweb/Patient")
public class PatientCotroller {
    private final PatientService patientService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllPatient(){
        return new ResponseEntity<>(patientService.getAllElderPatient(),HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByid(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable Integer id){
        patientService.deletePatientById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);}


    @PostMapping("/add")
public ResponseEntity<?> addPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.addPatient(patient),HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Integer id,@RequestBody Patient patient){
        try{
            patient.setPatientId(id);
            return new ResponseEntity<>(patientService.updatePatient(patient),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
