package ApplicationLayer;

/**
 * Created by EmilieKvist on 29-03-2017.
 */

//Object representing the activities of a project
public class Activity {
	//Creating fields
    private String activityName;
    private Project project;
    private double estimatedTimeUse;
    private double timeUsed;

    //Constructor
    public Activity(String activityName, Project p){
        this.activityName = activityName;
        this.timeUsed = 0;
        this.project = p;
    }

    
    //Getter and setter methods for the fields
    public String getActivityName() {
        return activityName;
    }

    public double getTimeUsed() {
        return timeUsed;
    }

    public Project getProject() {
        return this.project;
    }

    public double getEstimatedTimeUse() {
        return estimatedTimeUse;
    }

    public void setEstimatedTimeUse(double estimatedTimeUse) {
        this.estimatedTimeUse = estimatedTimeUse;
    }

    public void updateTimeUsed(double h){
        this.timeUsed = this.timeUsed + h;
    }

    public double getRemainingTime() {
        return estimatedTimeUse - timeUsed;
    }



}
