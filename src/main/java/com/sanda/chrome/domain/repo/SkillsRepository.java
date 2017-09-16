package com.sanda.chrome.domain.repo;

import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cdc89 on 05.02.2017.
 */
@Transactional(readOnly = true)
public interface SkillsRepository extends JpaRepository<Skills, Integer>{
    public List<Skills> findByJobId(int jobId);
}
