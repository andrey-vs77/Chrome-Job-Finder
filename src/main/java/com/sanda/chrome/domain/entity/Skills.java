package com.sanda.chrome.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cdc89 on 05.02.2017.
 */
@Entity
public class Skills implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String skill;

    @ManyToOne
    @JoinColumn(name ="jobId")
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Skills(){

    }

    public Skills(String skill){
        this.skill=skill;
    }
}