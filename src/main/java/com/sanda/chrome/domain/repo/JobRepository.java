package com.sanda.chrome.domain.repo;

import com.sanda.chrome.domain.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cdc89 on 03.02.2017.
 */
@Transactional(readOnly = true)
public interface JobRepository  extends JpaRepository<Job, Integer>{//
    public Job findByUrl(String url);
    public List<Job> findByViewed(Boolean viewed);
}
