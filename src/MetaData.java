import BusinessLogic.AppointmentBusinessLogic;
import BusinessLogic.HospitalBusinesLogic;
import BusinessLogic.OpeartionBusinessLogic;
import Domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static Domain.DoctorType.OPERATOR;
import static Domain.DoctorType.PROFESSOR;

public class MetaData {
    public static void main(String[] args) {
        HospitalBusinesLogic hospitalBusinesLogic = new HospitalBusinesLogic();
        AppointmentBusinessLogic appointmentBusinessLogic = new AppointmentBusinessLogic();
        OpeartionBusinessLogic opeartionBusinessLogic = new OpeartionBusinessLogic();


        LocalDateTime now = LocalDateTime.now();
        System.out.println("Started loading metadata : " + now);
        //Loading Metadata

        Hospital hospital = new Hospital();
        hospital.setId(1);
        hospital.setName("Sifa Yuvasi");
        hospital.setAddress("Lotharingerstrasse 231312");

        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setFirstName("doctor");
        doctor.setLastName("OZ");
        doctor.setAge(56);
        doctor.setHospital(hospital);
        doctor.setSalary(3435.56);
        doctor.setDoctorType(OPERATOR);

        Doctor doctor2 = new Doctor();
        doctor2.setId(2);
        doctor2.setFirstName("John");
        doctor2.setLastName("Dalton");
        doctor2.setAge(56);
        doctor2.setHospital(hospital);
        doctor2.setSalary(6873.34);
        doctor2.setDoctorType(PROFESSOR);

        Doctor doctor3 = new Doctor();
        doctor3.setId(3);
        doctor3.setFirstName("Best");
        doctor3.setLastName("Doctor Ever");
        doctor3.setAge(56);
        doctor3.setHospital(hospital);
        doctor3.setDoctorType(OPERATOR);
        doctor3.setSalary(9984.43);

        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        doctorList.add(doctor3);

        List<Doctor> doctorList2 = new ArrayList<>();
        doctorList2.add(doctor2);

        List<Doctor> doctorListFalse = new ArrayList<>();
        doctorListFalse.add(doctor);
        doctorListFalse.add(doctor2);
        doctorListFalse.add(doctor3);

        Nurse nurse = new Nurse();
        nurse.setId(1);
        nurse.setFirstName("nurse");
        nurse.setLastName("pssst");
        nurse.setAge(24);

        Nurse nurse2 = new Nurse();
        nurse.setId(2);
        nurse.setFirstName("nurse2");
        nurse.setLastName("two");
        nurse.setAge(24);

        List<Nurse> nurseList = new ArrayList<>();
        nurseList.add(nurse);
        nurseList.add(nurse2);

        Tool tool = new Tool(1,"scissors",1.3);
        Tool tool2= new Tool(2,"camera",2.3);
        Tool tool3 = new Tool(3,"hand cologne",4.3);

        List<Tool> toolList1 = new ArrayList<>();
        toolList1.add(tool);
        toolList1.add(tool2);

        List<Tool> toolList2 = new ArrayList<>();
        toolList2.add(tool);
        toolList2.add(tool2);
        toolList2.add(tool3);

        List<Tool> toolList3 = new ArrayList<>();
        toolList3.add(tool);

        Patient patient = new Patient();
        patient.setId(1231);
        patient.setFirstName("james");
        patient.setLastName("hettfield");
        patient.setAge(60);

        Patient patient2 = new Patient();
        patient2.setId(1232);
        patient2.setFirstName("Kirk");
        patient2.setLastName("Hammet");
        patient2.setAge(60);

        //add to database Appointment

        Appointment appointment = new Appointment(UUID.randomUUID(),hospital,patient,doctor,LocalDateTime.now());
        Appointment appointment2 = new Appointment(UUID.randomUUID(),hospital,patient,doctor,LocalDateTime.now());
        Appointment appointment3 = new Appointment(UUID.randomUUID(),hospital,patient,doctor,LocalDateTime.now());
        Appointment appointment4 = new Appointment(UUID.randomUUID(),hospital,patient,doctor,LocalDateTime.now());
        Appointment appointment5 = new Appointment(UUID.randomUUID(),hospital,patient2,doctor,LocalDateTime.now());

        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);
        appointmentList.add(appointment2);
        appointmentList.add(appointment3);
        appointmentList.add(appointment4);

        patient.setAppointments(appointmentList);

        List<Appointment> appointmentList2 = new ArrayList<>();
        appointmentList2.add(appointment5);

        patient2.setAppointments(appointmentList2);


        //Add to database Operations

        Operation operation = new Operation(UUID.randomUUID(),hospital,patient,doctorList,nurseList,toolList1,LocalDateTime.now());
        //ENUM TYPE not OPERATOR
        Operation operation2 = new Operation(UUID.randomUUID(),hospital,patient,doctorListFalse,nurseList,toolList1,LocalDateTime.now());
        Operation operation3 = new Operation(UUID.randomUUID(),hospital,patient2,doctorList,nurseList,toolList2,LocalDateTime.now());



        List<Operation> operationList = new ArrayList<>();
        operationList.add(operation);

        List<Operation> operationList2 = new ArrayList<>();

        List<Operation> operationListSifaYuvasi = new ArrayList<>();
        operationListSifaYuvasi.add(operation);
        operationListSifaYuvasi.add(operation3);
        hospital.setOperations(operationListSifaYuvasi);

        patient.setAppointments(appointmentList);
        patient2.setAppointments(appointmentList2);

        patient.setOperations(operationList);
        patient2.setOperations(operationList2);


        appointmentBusinessLogic.appointmentsRepo.add(appointment);
        appointmentBusinessLogic.appointmentsRepo.add(appointment2);
        appointmentBusinessLogic.appointmentsRepo.add(appointment3);
        appointmentBusinessLogic.appointmentsRepo.add(appointment4);
        appointmentBusinessLogic.appointmentsRepo.add(appointment5);

        opeartionBusinessLogic.operationsRepo.add(operation);
        opeartionBusinessLogic.operationsRepo.add(operation3);

        ///////////////////////////////
        LocalDateTime finish = LocalDateTime.now();
        System.out.println("METADATA LOADED SUCCESSFULLY" + finish + "\n------------------");
        System.out.println(appointmentBusinessLogic.returnPatientMaxAppointment());
        opeartionBusinessLogic.maxOperationCost(hospital);
        System.out.println(appointmentBusinessLogic.returnAllAppointmentsOfPatitent(patient));

    }
}
