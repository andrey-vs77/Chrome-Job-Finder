package com.sanda.chrome.util;

import com.sanda.chrome.domain.Provider;
import com.sanda.chrome.freelancehunt.ProviderHunt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by cdc89 on 07.02.2017.
 */
@Component
public class Schedule {

    private static final Logger log = LoggerFactory.getLogger(Schedule.class);
    @Autowired
    Provider provider;
    @Autowired
    ProviderHunt providerHunt;

    @Scheduled(fixedRate = 1800000, initialDelay = 60000)
    public void scheduleEmailNewJobsNoStopWords() throws IllegalAccessException {
        log.info("Schedule.scheduleEmailNewJobsNoStopWords()");
        providerHunt.setCurrentPage(1);
        process(providerHunt, "https://api.freelancehunt.com/projects?skills=13,99,103,85,121");
        process(provider,null);
//        try {
//            providerHunt.processProjects("https://api.freelancehunt.com/projects?skills=13,99,103,85,121");
//            provider.emailNewJobsNoStopWords();
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            provider.sendEmailNotice("ERROR", e.getMessage());
//        }
    }

    private void process(SiteProcessor siteProcessor, String url) {
        try {
            siteProcessor.process(url);
        } catch (Exception e) {
            log.error(e.getMessage());
            provider.sendEmailNotice("ERROR", e.getMessage());
        }
    }

    @Scheduled(fixedRate = 43200000, initialDelay = 60000)
    public void scheduleEmailNewJobsWithStopWords() throws IllegalAccessException {
        log.info("Schedule.scheduleEmailNewJobsWithStopWords()");
        provider.emailUnViewedJobsWithStopWords();
    }
}
