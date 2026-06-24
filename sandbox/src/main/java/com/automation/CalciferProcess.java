package com.automation;

import java.io.IOException;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHWorkflow;

public class CalciferProcess {
    private GitHub github;
    public CalciferProcess(){
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

    public void triggerAutoMerge(String targetBranch) throws IOException {
        if (github == null) {
            System.out.println("Github not connected.");
            return;
        }

        GHRepository repository = github.getRepository("arthur-georget/automation-sandbox");

        GHWorkflow workflow = repository.getWorkflow("preprod-auto-merge.yml");

        workflow.dispatch(targetBranch);
        
        System.out.println("Github action preprod auto merge launched!");
    }
}
