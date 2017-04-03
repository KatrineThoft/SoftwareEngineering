import org.junit.jupiter.api.Test;

import org.junit.Assert.*;

/**
 * Created by Daniel Hildebrand on 27-03-2017.
 */

public class Test1 {
    @Test
    public void ClientTest(){
        TimeManager endDate = TimeManager.setDate(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName);

        Project project01 = new Project(NovoNordisk);

        assertEqual(client01.getName(),"NovoNordisk" );


    
    }
    @Test
    public void ProjectTest(){

    }
}
