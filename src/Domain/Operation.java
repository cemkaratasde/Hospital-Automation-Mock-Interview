package Domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Operation {

    private UUID id;
    private Hospital hospital;
    private Patient patient;
    private List<Doctor> doctors;
    private List<Nurse> nureses;
    private List<Tool> toolKit;
    private LocalDateTime appointmentDateTime;

    private Operation(){}

    public Operation(UUID id, Hospital hospital, Patient patient, List<Doctor> doctors, List<Nurse> nureses, List<Tool> toolKit, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.hospital = hospital;
        this.patient = patient;
        this.doctors = doctors;
        this.nureses = nureses;
        this.toolKit = toolKit;
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNureses() {
        return nureses;
    }

    public void setNureses(List<Nurse> nureses) {
        this.nureses = nureses;
    }

    public List<Tool> getToolKit() {
        return toolKit;
    }

    public void setToolKit(List<Tool> toolKit) {
        this.toolKit = toolKit;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", patient=" + patient +
                ", doctors=" + doctors +
                ", nureses=" + nureses +
                ", toolKit=" + toolKit +
                ", appointmentDateTime=" + appointmentDateTime +
                '}';
    }
}
