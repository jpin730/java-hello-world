package model;

public class Nurse extends User {

  private String speciality;

  public Nurse(String name, String email, String speciality) {
    super(name, email);
    this.speciality = speciality;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  @Override
  public String toString() {
    return "Nurse{" +
        "speciality='" + speciality + '\'' +
        '}' + super.toString();
  }
}
