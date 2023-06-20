package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
public interface PatientService {
    Patient addPatient(Patient patient);
    Patient getPatientById(Integer patientId);
    List<Patient> getAllElderPatient();
    void deletePatientById(Integer patientId);
    Patient updatePatient(Patient patient);


}
