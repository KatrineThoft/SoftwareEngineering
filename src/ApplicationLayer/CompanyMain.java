package ApplicationLayer;

/**
 * Created by EmilieKvist on 28-04-2017.
 */
public class CompanyMain {
    public static TimeManager SoftwareHuset;
    public static Employee currentEmpl;

    public static void main(String[] args) {
        SoftwareHuset = new TimeManager();
        //ApplicationLayer.Employee currentEmpl;
        GUIdraft.main(args);
    }
}