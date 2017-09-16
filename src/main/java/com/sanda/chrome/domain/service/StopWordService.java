package com.sanda.chrome.domain.service;

import com.sanda.chrome.domain.entity.StopWord;
import com.sanda.chrome.domain.repo.StopWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cdc89 on 07.02.2017.
 */
@Repository
@Transactional(readOnly = true)
public class StopWordService {
    @Autowired
    StopWordRepository stopWordRepository;

    public List<StopWord> findAll(){
        return stopWordRepository.findAll();
    }
}
