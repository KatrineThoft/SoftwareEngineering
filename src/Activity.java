/**
 * Created by EmilieKvist on 29-03-2017.
 */
public class Activity {
    private String activityName;
    private double estimatedTimeUse;
    private double timeUsed;

    public Activity(String activityName, double estimatedTimeUse){
        this.activityName = activityName;
        this.estimatedTimeUse = estimatedTimeUse;
        this.timeUsed = 0;
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
