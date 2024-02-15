package Domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private UUID id;
    private Hospital hospital;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;

    public Appointment(){}

    public Appointment(UUID id, Hospital hospital, Patient patient, Doctor doctor, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.hospital = hospital;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", appointmentDateTime=" + appointmentDateTime +
                '}';
    }
}
