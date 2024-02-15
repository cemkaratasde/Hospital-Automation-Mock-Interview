package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Hospital {
    private Integer id;
    private String name;
    private String address;
    private List<Doctor> doctors;
    private List<Nurse> nurses = new ArrayList<>();

    private List<Operation> operations= new ArrayList<>();

    private List<Appointment> appointments= new ArrayList<>();

    public Hospital(){}

    public Hospital(Integer id, String name, String address, List<Doctor> doctors, List<Nurse> nurses, List<Operation> operations, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.doctors = doctors;
        this.nurses = nurses;
        this.operations = operations;
        this.appointments = appointments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
