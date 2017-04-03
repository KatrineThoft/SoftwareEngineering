import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by katrinethoft on 03/04/17.
 */
public class TimeManager {
    int month;
    int year;
    int date;

    public void setDate(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Calendar getDate(){
        return GregorianCalendar.getInstance();
    }
}
