package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer patientId;
    @NotBlank(message =" Patient number can not be null")
    private String patientNumber;
    @NotBlank(message =" Patient first Name can not be null")
    private String firstName;
    @NotBlank(message =" Patient last Name can not be null")
    private String lastName;
    @NotNull(message =" Patient date of birth can not be null")
    private LocalDate dateOfBirth;
   @JsonIgnoreProperties("patient")
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
