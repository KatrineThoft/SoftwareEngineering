/**
 * Created by EmilieKvist on 26-04-2017.
 */
public class Date {
    public int date;
    public int month;
    public int year;

    public Date(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public void alterDate(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }
}
