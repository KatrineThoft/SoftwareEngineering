import java.sql.Time;
import java.util.List;

/**
 * Created by Daniel Hildebrand on 27-03-2017.
 */
public class Project {

        public String projectID;
        public String projectName;
        public TimeManager endDate;
        public List<Employee> workingEmployees;
        public double TimeUsed;
        public ProjectManager projectManager;
        public Client client;
        public double estimatedTimeUse;
        public List<Activity> activities;



        public Project(Client client) {
            this.client = client;
            this.projectName = client.getProjectName;
            this.endDate = client.getEndDate;
            this.estimatedTimeUse = client.getEstimatedTimeUse();
            this.projectID = getProjectId();
        }

}
    //public String getProjectID(){
    //   return ProjectID();
    // }
    //  public String ProjectName(String){}
    //int EndDate= 5;

    //}

}
