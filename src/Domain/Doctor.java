package Domain;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends CommonAttributes{
    private Hospital hospital;
    private List<Operation> opeartions = new ArrayList<>();
    private List<Appointment> appointment = new ArrayList<>();
    private Enum DoctorType;

    private Double salary;

    public Doctor(){

    }

    public Doctor(Hospital hospital, List<Operation> opeartions, List<Appointment> appointment, Enum doctorType) {
        this.hospital = hospital;
        this.opeartions = opeartions;
        this.appointment = appointment;
        DoctorType = doctorType;
    }

    public Doctor(Integer id, String firstName, String lastName, Integer age, Hospital hospital, List<Operation> opeartions, List<Appointment> appointment, Enum doctorType) {
        super(id, firstName, lastName, age);
        this.hospital = hospital;
        this.opeartions = opeartions;
        this.appointment = appointment;
        DoctorType = doctorType;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Operation> getOpeartions() {
        return opeartions;
    }

    public void setOpeartions(List<Operation> opeartions) {
        this.opeartions = opeartions;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    public Enum getDoctorType() {
        return DoctorType;
    }

    public void setDoctorType(Enum doctorType) {
        DoctorType = doctorType;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ",hospital=" + hospital +
                ", DoctorType=" + DoctorType +
                ", salary=" + salary +
                '}';
    }
}
