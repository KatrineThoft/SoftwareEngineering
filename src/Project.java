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
        public double timeUsed;
        //public ProjectManager projectManager;
        public Client client;
        public double estimatedTimeUse;
        public List<Activity> activities;
        public boolean active;

    public Project(Client client) {
            this.client = client;
            /*this.projectName = client.getProjectName();
            this.endDate = client.getEndDate();
            this.estimatedTimeUse = client.getEstimatedTimeUse();
            this.projectID = getProjectId();
            */
        }

        public void setProjectID(int projectID) {
                this.projectID = projectID;
        }

        public String getProjectID() {
                return projectID;
        }

        public Client getClient() {
                return client;
        }

        public String getProjectName() {
                return projectName;
        }

        public TimeManager getEndDate() {
                return endDate;
        }

        public double getEstimatedTimeUse() {
                return estimatedTimeUse;
        }

        public double getTimeUsed() {
                return timeUsed;
        }

        public void setTimeUsed(double timeUsed) {
                this.timeUsed = timeUsed;
        }

        public double getRemainingTime() {
            double remainingTime=estimatedTimeUse-timeUsed;
                return remainingTime;
        }
}
