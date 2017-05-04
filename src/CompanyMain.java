import javafx.application.Application;

import java.sql.Time;

/**
 * Created by EmilieKvist on 28-04-2017.
 */
public class CompanyMain {
    public static TimeManager SoftwareHuset;
    public static Employee currentEmpl;

    public static void main(String[] args) {
        SoftwareHuset = new TimeManager();
        currentEmpl = new Employee("Bob", SoftwareHuset);
        currentEmpl.setOngoingActivities();
        SoftwareHuset.addEmployee(currentEmpl);
        GUIdraft.main(args);
    }


}
