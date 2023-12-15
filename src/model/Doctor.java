package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

  private String speciality;
  ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

  public Doctor(String name, String email, String speciality) {
    super(name, email);
    this.speciality = speciality;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public void addAvailableAppointment(String date, String time) throws ParseException {
    availableAppointments.add(new Doctor.AvailableAppointment(date, time));
  }

  public ArrayList<AvailableAppointment> getAvailableAppointments() {
    return availableAppointments;
  }

  @Override
  public String toString() {
    return "Doctor{" +
        "speciality='" + speciality + '\'' +
        ", availableAppointments=" + availableAppointments +
        '}' + super.toString();
  }

  public static class AvailableAppointment {

    private int id;
    private Date date;
    private String time;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public AvailableAppointment(String date, String time) throws ParseException {
      try {
        this.date = format.parse(date);
      } catch (ParseException error) {
        this.date = format.parse("2000-01-01");
      }
      this.time = time;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    @Override
    public String toString() {
      return "AvailableAppointment{" +
          "id=" + id +
          ", date=" + date +
          ", time='" + time + '\'' +
          '}';
    }
  }
}
