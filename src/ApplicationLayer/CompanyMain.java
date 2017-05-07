package ApplicationLayer;

import java.util.Calendar;

/**
 * Created by EmilieKvist on 28-04-2017.
 */
public class CompanyMain {
    public static void main(String[]args) {
        java.util.Date date01 = new java.util.Date(2017,5,1);
        java.util.Date date02 = Calendar.getInstance().getTime();
        System.out.println("ours: " + date01);
        System.out.println("real: " + date02);
    }
}
