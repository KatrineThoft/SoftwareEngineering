package ApplicationLayer;


/**
 * Created by EmilieKvist on 29-03-2017.
 */
//Class representing the client object
public class Client {
	//Creating fields
    public String clientName;
    public Date endDate;
    public double estimatedTimeUse;
    public String projectName;
    public TimeManager firm;
    public Employee wantedPM;
    public ProjectManager projectManager;

    //Constructor for creating a client without a project manager
    public Client (String clientName, Date endDate, double estimatedTimeUse, String projectName, TimeManager firm){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
        this.firm = firm;
        addToFirm(firm);
    }

    //Constructor for creating a client with a project manager
    public Client (String clientName, Date endDate, double estimatedTimeUse, String projectName, Employee employee, TimeManager firm){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
        this.firm = firm;
        this.wantedPM = employee;
        addToFirm(firm);
    }


    //Adding the client to our TimeManager (representing the firm)
    public void addToFirm(TimeManager firm){
        firm.getClients().add(this);
    }

    //Getter methods for fields
    public Date getEndDate() {
        return endDate;
    }

    public double getEstimatedTimeUse() {
        return estimatedTimeUse;
    }
    
}
