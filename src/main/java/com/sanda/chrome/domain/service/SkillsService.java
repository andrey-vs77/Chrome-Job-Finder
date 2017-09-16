package com.sanda.chrome.domain.service;

import com.sanda.chrome.domain.entity.Skills;
import com.sanda.chrome.domain.repo.JobRepository;
import com.sanda.chrome.domain.repo.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by cdc89 on 05.02.2017.
 */
@Repository
@Transactional(readOnly = true)
public class SkillsService {
    @Autowired
    private SkillsRepository skillsRepository;

    public List<Skills> findByJobId(int jobId){
        return skillsRepository.findByJobId(jobId);
    }

    @Transactional
    public Skills save(Skills skill){
        return skillsRepository.save(skill);
    }
}
