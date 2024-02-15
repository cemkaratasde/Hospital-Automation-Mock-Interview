package BusinessLogic;

import Domain.Appointment;
import Domain.Doctor;
import Domain.Hospital;
import Domain.Patient;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class AppointmentBusinessLogic {

    public static List<Appointment> appointmentsRepo = new ArrayList<>();

    public List<Appointment> returnAllAppointmentsOfPatitent(Patient patient) {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList = (List<Appointment>) patient.getAppointments();
        return appointmentList;
    }

    public Integer returnAllAppointmentsOfPatitentThisMonth(Patient patient) {
        Month thisMonth = LocalDateTime.now().getMonth();
        int countAppointmentsThisMonth = 0;
        for (int i = 0; i < patient.getAppointments().size(); i++) {
            if (patient.getAppointments().get(i).getAppointmentDateTime().getMonth() == thisMonth) {
                countAppointmentsThisMonth++;
            }
        }
        return countAppointmentsThisMonth;
    }

    public void makeNewAppointment(Patient patient, Hospital hospital, Doctor doctor) {
        if (returnAllAppointmentsOfPatitentThisMonth(patient) < setMonthlyAppointmentLimit()) {
            LocalDateTime now = LocalDateTime.now();
            Appointment appointment = new Appointment(UUID.randomUUID(), hospital, patient, doctor, now);
            appointmentsRepo.add(appointment);
            patient.getAppointments().set(patient.getAppointments().size() + 1, appointment);
            doctor.getAppointment().set(doctor.getAppointment().size() + 1, appointment);
            hospital.getAppointments().set(hospital.getAppointments().size() + 1, appointment);
            System.out.println("Appointment created for : " + patient.getId());
        }
        System.out.println("You have already exceeded the monthly appointment limit for a patient\n" +
                "your total appointments this month : " + patient.getAppointments().size());
    }

    public String returnPatientMaxAppointment() {
        Integer index = 1;
        Integer maxCount = 0;
        for (int i = 0; i < appointmentsRepo.size(); i++) {
            Integer count = 0;
            for (int j = 0; j < appointmentsRepo.size(); j++) {
                if (appointmentsRepo.get(i) == appointmentsRepo.get(j)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        String message = index + " Patient with the max number of appointment is : \n" + "id " + appointmentsRepo.get(index).getPatient().getId() + "\n" + "full name " + appointmentsRepo.get(index).getPatient().getFirstName() + " " + appointmentsRepo.get(index).getPatient().getLastName();
        return  message;
    }

    public Integer setMonthlyAppointmentLimit () {
            return 3;
        }
    }
