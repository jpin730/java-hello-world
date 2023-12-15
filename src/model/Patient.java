package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {

  private String birthday;
  private double weight;
  private double height;
  private String blood;

  private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();

  public Patient(String name, String email, String birthday, double weight, double height,
      String blood) {
    super(name, email);
    this.birthday = birthday;
    this.weight = weight;
    this.height = height;
    this.blood = blood;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getWeight() {
    return weight + " kg";
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getHeight() {
    return height + " m";
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public String getBlood() {
    return blood;
  }

  public void setBlood(String blood) {
    this.blood = blood;
  }

  public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
    return appointmentDoctors;
  }

  public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
    AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
    appointmentDoctor.schedule(date, time);
    appointmentDoctors.add(appointmentDoctor);
  }

  @Override
  public String toString() {
    return "Patient{" +
        "birthday='" + birthday + '\'' +
        ", weight=" + weight +
        ", height=" + height +
        ", blood='" + blood + '\'' +
        '}' + super.toString();
  }
}
