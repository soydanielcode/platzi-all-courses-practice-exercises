package Model;

public class Nurse extends User{
    private int id;
    private String speciality;

    public Nurse(String names, String mail, String phoneNumber, String birthday, String speciality) {
        super(names, mail,phoneNumber, birthday);
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Nurse: " + super.toString() + "\nSpeciality = '" + speciality + '\'';
    }
}
