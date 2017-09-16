package com.sanda.chrome.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by cdc89 on 03.02.2017.
 */
@Entity
public class Job implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column
    private String type;

    @Column
    private String level;

    @Column
    private String duration;

    @Column
    private String posted;

    @Column(length = 5000)
    private String description;

    @Column
    private String proposals;

    @Column
    private String clientPayment;

    @Column
    private String clientFeedback;

    @Column
    private String clientExpenses;

    @Column
    private String clientLocation;

    @Column
    private Boolean viewed=false;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date parseDate;

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProposals() {
        return proposals;
    }

    public void setProposals(String proposals) {
        this.proposals = proposals;
    }

    public String getClientPayment() {
        return clientPayment;
    }

    public void setClientPayment(String clientPayment) {
        this.clientPayment = clientPayment;
    }

    public String getClientFeedback() {
        return clientFeedback;
    }

    public void setClientFeedback(String clientFeedback) {
        this.clientFeedback = clientFeedback;
    }

    public String getClientExpenses() {
        return clientExpenses;
    }

    public void setClientExpenses(String clientExpenses) {
        this.clientExpenses = clientExpenses;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Skills> skills;

    public Set<Skills> getSkills() {
        return skills;
    }


    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getParseDate() {
        return parseDate;
    }

    public void setParseDate(Date parseDate) {
        this.parseDate = parseDate;
    }
}
