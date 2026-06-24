package com.automation;

import java.io.IOException;

import org.kohsuke.github.GitHub;

public class CalciferProcess {
    private GitHub github;
    public CalciferProcess(){
        System.getenv().forEach((key, value) -> System.out.println(key + " = " + value));
        try{
            github = GitHub.connect();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public String getGithubStatus() throws IOException{
        if (github != null && github.isCredentialValid()){
            return "Connected to Github as : " + github.getMyself().getLogin();
        }
        return "Github connection failed.";
    }
}
