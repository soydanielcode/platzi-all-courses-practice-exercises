package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private int id;
    private String speciality;
    private ArrayList<AvailableAppointment>availableAppointments = new ArrayList<>();

    public Doctor(String names, String mail, String speciality) {
        super(names, mail);
        this.speciality = speciality;
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public void addAvailableAppointments(String date, String time) {
        this.availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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
        return "Dr: " + super.toString() + "\nspeciality='" + speciality + '\'';
    }

    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return format.format(date);
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
            return  "\nDate = " + date.getDate() +
                    "\nTime = '" + time + '\'';
        }
    }
}
