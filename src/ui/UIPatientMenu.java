package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import model.Doctor;
import model.Doctor.AvailableAppointment;

public class UIPatientMenu {

  public static void showPatientMenu() {
    String option;
    do {

      System.out.println("\nPatient");
      System.out.println("Welcome: " + UIMenu.patientLogged.getName());
      System.out.println("1. Book an appointment");
      System.out.println("2. My Appointments");
      System.out.println("0. Logout");

      Scanner sc = new Scanner(System.in);
      option = sc.nextLine();

      switch (option) {
        case "1":
          showBookAppointmentMenu();
          break;
        case "2":
          showPatientMyAppointments();
          break;
      }


    } while (!option.equals("0"));
  }

  private static void showBookAppointmentMenu() {
    String option;
    do {
      System.out.println("\nBook an appointment");

      Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();

      int k = 0;
      for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
        ArrayList<AvailableAppointment> availableAppointments
            = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

        Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

        for (int j = 0; j < availableAppointments.size(); j++) {
          k++;
          System.out.println(k + ". " + availableAppointments.get(j).getDate());
          doctorAppointments.put(j,
              UIDoctorMenu.doctorsAvailableAppointments.get(i));

          doctors.put(k, doctorAppointments);
        }
      }

      System.out.print("Select date: ");
      Scanner sc = new Scanner(System.in);
      String responseDateSelected = sc.nextLine();

      Map<Integer, Doctor> doctorAvailableSelected = doctors.get(
          Integer.parseInt(responseDateSelected));
      Integer indexDate = 0;
      Doctor doctorSelected = new Doctor("", "", "");

      for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
        indexDate = doc.getKey();
        doctorSelected = doc.getValue();
      }

      System.out.println(doctorSelected.getName() +
          ". Date: " +
          doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
          ". Time: " +
          doctorSelected.getAvailableAppointments().get(indexDate).getTime());

      System.out.println("Confirm your appointment: \n1. Yes \n2. Change");
      option = sc.nextLine();

      if (option.equals("1")) {
        UIMenu.patientLogged.addAppointmentDoctors(
            doctorSelected,
            doctorSelected.getAvailableAppointments().get(indexDate).getDate(),
            doctorSelected.getAvailableAppointments().get(indexDate).getTime());

        showPatientMenu();
      }

    } while (!option.equals("0"));
  }

  private static void showPatientMyAppointments() {
    String option;
    do {
      System.out.println("::My Appointments");
      if (UIMenu.patientLogged.getAppointmentDoctors().isEmpty()) {
        System.out.println("Don't have appointments");
        break;
      }

      for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
        int j = i + 1;
        System.out.println(j + ". " +
            "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
            " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
            "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor()
            .getName()
        );
      }

      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      option = sc.nextLine();

    } while (!option.equals("0"));
  }

}
