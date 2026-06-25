package com.automation;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import java.io.IOException;

@Path("/codeReviewed")
public class CalciferAPI {
    private CalciferProcess calciferProcess;

    // Default prod constructor
    public CalciferAPI() {
        this.calciferProcess = new CalciferProcess();
    }

    // Test constructor (to inject mock)
    public CalciferAPI(CalciferProcess calciferProcess) {
        this.calciferProcess = calciferProcess;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String codeReviewed(Map<String, Object> body) {
        String githubStatus = "";
        String branchName = "main";
        
        if (body != null && body.containsKey("branch")) {
            branchName = (String) body.get("branch");
        }

        try {
            githubStatus = this.calciferProcess.getGithubStatus();
            this.calciferProcess.triggerAutoMerge(branchName); 
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return "HTTP request successfully received for " + branchName + " branch. Github status -> " + githubStatus;
    }
}