package Domain;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Patient extends CommonAttributes{
    private List<Operation> operations;
    private List<Appointment> appointments;

    public Patient(){
        super();
    }

    public Patient(Integer id, String firstName, String lastName, Integer age, List<Operation> operations, List<Appointment> appointments) {
        super(id, firstName, lastName, age);
        this.operations = operations;
        this.appointments = appointments;
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
        return "Patient{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
