public class Month {
    private int number;
    private String name;
    private int days;

    public Month(int number,String name,int days) {
        this.number = number;
        this.name = name;
        this.days = days;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

}
