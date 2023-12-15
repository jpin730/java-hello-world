package ui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;
import model.Patient;

public class UIMenu {

  public static final String[] MONTHS = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
  };

  public static Doctor doctorLogged;
  public static Patient patientLogged;

  public static void showMenu() throws ParseException {

    String option;

    do {
      System.out.println("\nWelcome to My Appointments");
      System.out.println("1. Doctor");
      System.out.println("2. Patient");
      System.out.println("0. Exit");

      System.out.print("Select an option: ");

      Scanner sc = new Scanner(System.in);
      option = sc.nextLine();

      switch (option) {
        case "1":
          System.out.println("\nDoctor");
          authUser(1);
          break;

        case "2":
          System.out.println("\nPatient");
          authUser(2);
          break;

        case "0":
          System.out.println("\nThank you for you visit");
          break;

        default:
          System.out.println("\nPlease select a correct option");
      }
    } while (!option.equals("0"));
  }

  private static void authUser(int userType) throws ParseException {
    // userType = 1 Doctor
    // userType = 2 Patient

    ArrayList<Doctor> doctors = new ArrayList<>();

    doctors.add(new Doctor("John Doe", "jdoe@mail.com", "Cardiologist"));
    doctors.add(new Doctor("Mary Smith", "msmith@mail.com", "Pediatrician"));
    doctors.add(new Doctor("Jackie Jackson", "jjackson@mail", "Surgeon"));

    ArrayList<Patient> patients = new ArrayList<>();
    patients.add(new Patient("Milton Daniels", "jsmith@mail.com", "1990-01-01", 200, 1.80, "A+"));
    patients.add(new Patient("Kevin Peterson", "kpeter@mail.com:", "1992-01-01", 220, 1.90, "B-"));
    patients.add(new Patient("Martha Allen", "mallen@mail.com", "1994-01-01", 180, 1.65, "O+"));

    boolean emailCorrect = false;

    do {
      System.out.print("\nYour email (0 to exit): ");
      Scanner sc = new Scanner(System.in);
      String email = sc.nextLine();

      if (email.equals("0")) {
        break;
      }

      if (userType == 1) {
        for (Doctor doctor : doctors) {
          if (doctor.getEmail().equals(email)) {
            emailCorrect = true;
            doctorLogged = doctor;
            UIDoctorMenu.showDoctorMenu();
          }
        }
      }

      if (userType == 2) {
        for (Patient patient : patients) {
          if (patient.getEmail().equals(email)) {
            emailCorrect = true;
            patientLogged = patient;
            UIPatientMenu.showPatientMenu();
          }
        }
      }


    } while (!emailCorrect);

  }


}
