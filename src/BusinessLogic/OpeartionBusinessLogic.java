package BusinessLogic;

import Domain.*;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static Domain.DoctorType.OPERATOR;

public class OpeartionBusinessLogic {

    public static List<Operation> operationsRepo = new ArrayList<>();

    public void enrollNewOpeartion(Hospital hospital, List<Doctor> doctors, List<Nurse> nurses, List<Tool> tools, Patient patient, LocalDateTime appointmentTime) {
        boolean allDoctorsAreOperator = true;

        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorType() != OPERATOR) ;
            allDoctorsAreOperator = false;
            break;
        }

        if (returnPatientOperationsThisYear(patient) < setMaxOpeartionLimitInAYear() &&
                allDoctorsAreOperator &&
                nurses.size() < setMaxNurseLimitPerOperation()) {
            Operation operation = new Operation(UUID.randomUUID(), hospital, patient, doctors, nurses, tools, appointmentTime);
            operationsRepo.add(operation);
            patient.getOperations().set(patient.getOperations().size() + 1, operation);
            hospital.getOperations().set(hospital.getOperations().size() + 1, operation);
            for (int i = 0; i < doctors.size(); i++) {
                doctors.get(i).getOpeartions().set(doctors.get(i).getOpeartions().size() + 1, operation);
            }
            for (int i = 0; i < nurses.size(); i++) {
                nurses.get(i).getOperations().set(nurses.get(i).getOperations().size() + 1, operation);
            }
            System.out.println("Appointment saved.");
        }

        System.out.println("Check the max sizes for doctor nurse and patient opreation");
    }

    public Integer returnPatientOperationsThisYear(Patient patient) {
        Integer thisYear = LocalDateTime.now().getYear();
        for (int i = 0; i < patient.getOperations().size(); i++) {
            if (patient.getOperations().get(i).getAppointmentDateTime().getYear() == thisYear) {
                return 1;
            }
        }
        return 0;
    }

    public Integer setMaxNurseLimitPerOperation() {
        return 5;
    }

    public Double calculateOperationCost(Operation operation) {
        double cost = 0;
        for (int i = 0; i < operation.getToolKit().size(); i++) {
            cost += operation.getToolKit().get(i).getPrice();
        }
        return cost;
    }

    public void maxOperationCost(Hospital hospital) {
        double operationCost = 0;
        Integer index= 0;
        for (int i = 0; i < operationsRepo.size(); i++) {
//            double countTool = 0;
//            double countDoctor = 0;
            double totalCount = 0;
            for (int j = 0; j < operationsRepo.get(i).getToolKit().size(); j++) {
                totalCount += operationsRepo.get(i).getToolKit().get(j).getPrice();
            }
            for (int x = 0; x < operationsRepo.get(i).getDoctors().size(); x++) {
                totalCount += operationsRepo.get(i).getDoctors().get(x).getSalary();
            }
            if (operationCost < totalCount) {
                operationCost = totalCount;
                index = i;
            }
        }
        System.out.println("Maximum operation cost is : " + operationCost + "\n" +
                "Operation Id is : " + operationsRepo.get(index).getId());
}

    public Integer setMaxOpeartionLimitInAYear(){
        return 1;
    }
}
