package com.sanda.chrome.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cdc89 on 07.02.2017.
 */
@Entity
public class StopWord  implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String word;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
