package loan;

public class Installment {
    private  final Double value;

    private  Boolean late;

    private int days;

    public Installment(Double value) {
        this.value = value;
    }

    public Double getValue() {


        return value;
    }

    public void setLate(Boolean late) {
        this.late = late;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Boolean getLate() {
        return late;
    }

    public int getDays() {
        return days;
    }
}
