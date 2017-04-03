import org.junit.jupiter.api.Test;

import org.junit.Assert.*;

/**
 * Created by Daniel Hildebrand on 27-03-2017.
 */

public class Test1 {
    @Test
    public void ClientTest(){
        //Step 1: Test that the client is correctly constructed
        TimeManager endDate = TimeManager.setDate(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName);

        Project project01 = new Project(client01);

        assertFalse(client01,null);

        assertEqual(client01.getName(),"NovoNordisk" );

        Calendar date = new Calendar(23,1,2018);

        assertEqual(client01t.getEndDate, date);

        assertEqual(client01.getEstimatedTimeUse,100);

        //Step 2: Check that client can designate a project manager
        String eName = "Hanne"
       Employee projectManager = new Employee(eName);

        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, projectManager);

        Project project02 = new Project(client02);

        assertEqual(project02.getProjectManager,"Hanne");




    }
    @Test
    public void ProjectTest(){

    }
}
