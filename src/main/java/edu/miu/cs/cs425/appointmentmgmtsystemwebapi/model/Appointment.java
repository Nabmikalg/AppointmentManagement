package edu.miu.cs.cs425.appointmentmgmtsystemwebapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long appointmentId;
    @Column(nullable=false)
    private LocalDate appointmentDate;
    @Column(nullable=false)
    private LocalTime appiontmentTime;
    private String dentistName;
    private String surgeryLocation;


   @JsonIgnoreProperties("appointments")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Patient_Id")
    private Patient patient;

}
