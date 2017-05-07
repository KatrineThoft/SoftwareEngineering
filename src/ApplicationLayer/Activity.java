package ApplicationLayer;

/**
 * Created by EmilieKvist on 29-03-2017.
 */
public class Activity {
    private String activityName;
    private Project project;
    private double estimatedTimeUse;
    private double timeUsed;

    public Activity(String activityName, Project p){
        this.activityName = activityName;
        this.timeUsed = 0;
        this.project = p;
    }

    public Project getProject() {
        return this.project;
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

    public String getActivityName() {
        return activityName;
    }

    public double getEstimatedTimeUse() {
        return estimatedTimeUse;
    }

    public double getTimeUsed() {
        return timeUsed;
    }


}
