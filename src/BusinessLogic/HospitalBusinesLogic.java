package BusinessLogic;

import Domain.Doctor;
import Domain.Hospital;
import Domain.Nurse;

import java.util.HashMap;
import java.util.List;

public class HospitalBusinesLogic {

    static HashMap<Integer, Hospital> hospitalRepo = new HashMap<>();

    public Integer setDoctorLimit(){
        return 20;
    }

    public Integer setNurseLimit(int n){
        return 50;
    }

    public void hireNewDoctor(Hospital hospital, Doctor doctor){
        int currentSize = hospital.getDoctors().size();
        if (currentSize < setDoctorLimit()){
            hospital.getDoctors().set(currentSize+1,doctor);
            doctor.setHospital(hospital);
            System.out.println("Doctor got hired : " + doctor);
        }
        System.out.println("You have exceeded the maximum number of doctors to be hired.");
    }

    public void hireNewNurse(Hospital hospital, Nurse nurse){
        int currentSize = hospital.getNurses().size();
        if (currentSize < setDoctorLimit()){
            hospital.getNurses().set(currentSize+1,nurse);
            nurse.setHospital(hospital);
            System.out.println("Nurse got hired : " + nurse);
        }
        System.out.println("You have exceeded the maximum number of nurses to be hired.");
    }

}
