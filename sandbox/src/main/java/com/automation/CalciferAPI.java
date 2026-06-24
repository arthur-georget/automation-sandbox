package com.automation;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/codeReviewed")
public class CalciferAPI {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String codeReviewed() {
        CalciferProcess calciferProcess = new CalciferProcess();
        String githubStatus = "";
        try {
            githubStatus = calciferProcess.getGithubStatus();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "HTTP request successfully received. Github status: " + githubStatus;
    }
}