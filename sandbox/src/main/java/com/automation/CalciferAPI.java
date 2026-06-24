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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String codeReviewed(Map<String, Object> body) {
        CalciferProcess calciferProcess = new CalciferProcess();
        String githubStatus = "";
        String branchName = "preprod";
        if (body != null && body.containsKey("branch")) {
            branchName = (String) body.get("branch");
        }
        try {
            githubStatus = calciferProcess.getGithubStatus();
            calciferProcess.triggerAutoMerge(branchName);
        } catch (IOException e){
            e.printStackTrace();
        }
        return "HTTP request successfully received pour la branche " + branchName + ". Github status: " + githubStatus;
    }
}