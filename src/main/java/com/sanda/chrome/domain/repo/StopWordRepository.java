package com.sanda.chrome.domain.repo;

import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.entity.StopWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cdc89 on 07.02.2017.
 */
@Transactional(readOnly = true)
public interface StopWordRepository   extends JpaRepository<StopWord, Integer> {
}
