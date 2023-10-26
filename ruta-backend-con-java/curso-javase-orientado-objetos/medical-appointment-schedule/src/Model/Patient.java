package Model;

public class Patient {
    private int id;
    private String height;
    private String weight;
    private String blood;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeight() {
        return height + " mts.";
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight + " Kg.";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return  "Patient: " + super.toString() +
                "\nheight='" + height + '\'' +
                "\nweight='" + weight + '\'' +
                "\nblood='" + blood + '\'';
    }
}
