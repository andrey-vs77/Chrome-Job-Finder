package com.sanda.chrome.freelancehunt.filter;

import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.service.JobService;
import com.sanda.chrome.freelancehunt.ProviderHunt;
import com.sanda.chrome.freelancehunt.restful.objects.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by cdc89 on 16.02.2017.
 */
@Component
public class FilterProjects {

    private static final Logger log = LoggerFactory.getLogger(FilterProjects.class);

    @Autowired
    JobService jobService;
    /**
     *
     * @param project
     * @return true if project should be written to DB
     */
    public boolean acceptProject(Project project){
        if (!acceptProjectDate(project)){
            return false;
        }
        if (findProjectInDB(project)){
            return false;
        }
        return true;
    }

    private boolean findProjectInDB(Project project) {
        Job job=jobService.findByUrl(project.getUrl());
        if (job!=null){
            String logInfo=String.format("findProjectInDB  return true = url - %s",job.getUrl());
            log.debug(logInfo);
            return true;
        }
        log.debug("findProjectInDB return false");
        return false;
    }

    private boolean acceptProjectDate(Project project) {
        Date postDate=project.getPublication_time();
        String logInfo=String.format("acceptProjectDate = post date - %s",postDate);
        log.debug(logInfo);
        Date minDate=getMinDate();
        logInfo=String.format("acceptProjectDate = min date - %s",minDate);
        log.debug(logInfo);
        if (postDate.before(minDate)){
            return false;
        }
        log.debug("acceptProjectDate return true");
        return true;
    }

    public Date getMinDate(){
        //calculate min date
        Calendar cal = Calendar.getInstance();
        Date currentDate=new Date();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE,-1);
        cal.clear(Calendar.MILLISECOND);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MINUTE);
        cal.set(Calendar.HOUR_OF_DAY,0);
        Date minDate=cal.getTime();
        return  minDate;
    }

}
