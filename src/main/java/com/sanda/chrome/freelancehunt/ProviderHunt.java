package com.sanda.chrome.freelancehunt;

import com.sanda.chrome.domain.Provider;
import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.service.JobService;
import com.sanda.chrome.freelancehunt.filter.FilterProjects;
import com.sanda.chrome.freelancehunt.restful.Requests;
import com.sanda.chrome.freelancehunt.restful.objects.Project;
import com.sanda.chrome.util.SiteProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdc89 on 17.02.2017.
 */
@Component
public class ProviderHunt implements SiteProcessor{

    private static final Logger log = LoggerFactory.getLogger(ProviderHunt.class);
    @Autowired
    private FilterProjects filterProjects;
    @Autowired
    Requests requests;
    @Autowired
    JobService jobService;

    private int currentPage = 1;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void processProjects(String baseUrl) {
        List<Project> projectList = loadNextPage(baseUrl);
        int countNotAcceptedProjects=0;
        for (Project project : projectList) {
            if (filterProjects.acceptProject(project)) {
                Job job=prepareJob(project);
                //start logging
                StringBuilder skillsStr=new StringBuilder();
                job.getSkills().forEach(x->skillsStr.append(x.getSkill()+"; "));
                String logInfo=String.format("save job = url - %s; skills - %s",job.getUrl(), skillsStr);
                log.debug(logInfo);
                //end logging
                jobService.save(job);
            } else {
                //start logging
                StringBuilder skillsStr=new StringBuilder();
                project.getSkills().values().stream().forEach(x->skillsStr.append(x+"; "));
                String logInfo=String.format("not accept project = url - %s; skills - %s",project.getUrl(),skillsStr);
                log.debug(logInfo);
                //end logging
                countNotAcceptedProjects++;
            }
        }
        if (countNotAcceptedProjects==projectList.size()){
            return;
        }
        processProjects(baseUrl);
    }

    private List<Project> loadNextPage(String baseUrl) {
        String url = baseUrl + "&page=" + currentPage;
        List<Project> projectList = requests.getProjects(url);
        currentPage++;
        return projectList;
    }

    private Job prepareJob(Project project) {
        JobAdapter jobAdapter=new JobAdapter(project);
        return jobAdapter.convert();
    }

    @Override
    public void process(String url) throws IllegalAccessException {
        processProjects(url);
    }
}
