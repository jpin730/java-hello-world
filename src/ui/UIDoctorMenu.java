package ui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class UIDoctorMenu {

  public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

  public static void showDoctorMenu() throws ParseException {
    String option;

    do {
      System.out.println("\nDoctor");
      System.out.println("Welcome " + UIMenu.doctorLogged.getName());
      System.out.println("1. Add Available Appointment");
      System.out.println("2. My Scheduled Appointments");
      System.out.println("0. Logout");

      Scanner sc = new Scanner(System.in);
      option = sc.nextLine();

      switch (option) {
        case "1":
          showAddAvailableAppointmentsMenu();
          break;
        case "2":
          break;


      }

    } while (!option.equals("0"));
  }


  private static void showAddAvailableAppointmentsMenu() throws ParseException {
    String option;

    do {
      System.out.println("\nAdd Available Appointment");

      for (int i = 0; i < 3; i++) {
        System.out.println((i + 1) + ". " + UIMenu.MONTHS[i]);
      }

      System.out.println("0. Return");

      System.out.print("Select a month: ");

      Scanner sc = new Scanner(System.in);
      option = sc.nextLine();

      if (option.equals("1") || option.equals("2") || option.equals("3")) {

        int monthSelected = Integer.parseInt(option);

        System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected - 1]);

        System.out.print("Insert the date available [yyyy-mm-dd]: ");
        String date = sc.nextLine();

        System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
        String responseDate = sc.nextLine();

        if (responseDate.equals("2")) {
          continue;
        }

        String responseTime;
        String time;
        do {
          System.out.print("Insert the time available for date [hh:mm]: ");
          time = sc.nextLine();
          System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
          responseTime = sc.nextLine();
        } while (responseTime.equals("2"));

        UIMenu.doctorLogged.addAvailableAppointment(date, time);
        checkDoctorAvailableAppointments(UIMenu.doctorLogged);

      } else if (option.equals("0")) {
        showDoctorMenu();
      }

    } while (!option.equals("0"));
  }

  private static void checkDoctorAvailableAppointments(Doctor doctor) {
    if (!doctor.getAvailableAppointments().isEmpty()
        && !doctorsAvailableAppointments.contains(doctor)) {
      doctorsAvailableAppointments.add(doctor);
    }
  }
}
