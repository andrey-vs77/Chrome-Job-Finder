package com.sanda.chrome.domain.service;

import com.sanda.chrome.domain.Provider;
import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.repo.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by cdc89 on 05.02.2017.
 */
//@Repository
    @Service
@Transactional(readOnly = true)
public class JobService {

    private static final Logger log = LoggerFactory.getLogger(JobService.class);

    @Autowired
    private JobRepository jobRepository;

    @PersistenceContext
    private EntityManager em;

    public Job findByUrl(String url) {
        log.debug(url);
        return jobRepository.findByUrl(url);
    }

    public List<Job> findByViewed(boolean viewed){
        return jobRepository.findByViewed(viewed);
    }

    @Transactional
    public Job save(Job job){
        return jobRepository.save(job);
    }
}
