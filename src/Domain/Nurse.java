package Domain;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Nurse extends CommonAttributes{
    private Hospital hospital;
    private List<Operation> operations;

    public Nurse(){}

    public Nurse(Hospital hospital, List<Operation> operations) {
        this.hospital = hospital;
        this.operations = operations;
    }

    public Nurse(Integer id, String firstName, String lastName, Integer age, Hospital hospital, List<Operation> operations) {
        super(id, firstName, lastName, age);
        this.hospital = hospital;
        this.operations = operations;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "hospital=" + hospital +
                ", operations=" + operations +
                '}';
    }
}
