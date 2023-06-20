package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.repository;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    List<Patient> getPatientsByDateOfBirthBefore(LocalDate date);
}
