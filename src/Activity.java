/**
 * Created by EmilieKvist on 29-03-2017.
 */
public class Activity {
    public String activityName;
    public double estimatedTimeUse;
    public double timeUsed;

    public Activity(String activityName, double estimatedTimeUse){
        this.activityName = activityName;
        this.estimatedTimeUse = estimatedTimeUse;
    }

    public void setTimeUsed(double timeUsed){
        this.timeUsed = timeUsed;
    }

    public double remainingTime(){
        return estimatedTimeUse - timeUsed;
    }
}
