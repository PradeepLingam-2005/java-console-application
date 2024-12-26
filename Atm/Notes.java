public class Notes implements Cloneable {
    private String note;
    private double count;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
    public Notes clone() throws CloneNotSupportedException {
        return (Notes) super.clone();
    }
}
