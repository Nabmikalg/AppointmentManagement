package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.impl;

import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model.Patient;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.repository.PatientRepository;
import edu.miu.cs.cs425.appointmentmgmtsystemwebapi.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Integer patientId) {
       return patientRepository.findById(patientId).orElseThrow(()-> new RuntimeException("patient Id does not exist"));

    }

    @Override
    public List<Patient> getAllElderPatient() {
        return patientRepository
                .getPatientsByDateOfBirthBefore(LocalDate.now().minusYears(65));

    }


    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);

    }

    @Override
    public Patient updatePatient(Patient patient) {
        patientRepository.findById(patient.getPatientId()).orElseThrow(()-> new RuntimeException("Patient id does not exist"));
        return patientRepository.save(patient);
    }
}
