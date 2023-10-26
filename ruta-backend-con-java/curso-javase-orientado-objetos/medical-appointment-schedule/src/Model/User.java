package Model;

public abstract class User {
    private int id;
    private String names;
    private String mail;
    private String phoneNumber;
    private String birthday;

    public User(String names, String mail) {
        this.names = names;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  "Names = '" + names + '\'' +
                "\nMail = '" + mail + '\'' +
                "\nPhoneNumber = '" + phoneNumber + '\'' +
                "\nBirthday = '" + birthday ;
    }
}
