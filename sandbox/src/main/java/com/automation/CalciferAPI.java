package com.automation;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/codeReviewed")
public class CalciferAPI {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String codeReviewed() {
        return "HTTP request successfully received. Calcifer will now asks Github to merge concerned branch to preprod and then build it.";
    }
}