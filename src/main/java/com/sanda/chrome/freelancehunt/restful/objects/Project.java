package com.sanda.chrome.freelancehunt.restful.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by cdc89 on 17.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    String project_id;
    String url;
    String url_api;
    UserProjectFrom from;
    String name;
    String description;
    String description_html;
    String status_id;
    String status_name;
    String bid_count;
    String has_placed_bid;
    Date publication_time;
    Date expire_time;
    String is_job;
    String is_featured;
    String is_identity_verified;
    Map<String, String> skills;

    public String convertSkills() {
        String result = "";
        Set<Map.Entry<String, String>> set = skills.entrySet();
        for (Map.Entry<String, String> entry : set) {
            result += entry.getKey() + " - " + entry.getValue() + "; ";
        }
        return result;
    }

    @Override
    public String toString() {
        return "PROJECT:\n"+
                "project_id - " + project_id + "; \n" +
                "name - " + name + "; \n" +
                "url - "+ url + "; \n" +
                "description_html - " + description_html + "; \n" +
                "description - " + description + "; \n" +
                "publication_time  - "+ publication_time + "; \n" +
                "skills - " + convertSkills()+"; \n";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_api() {
        return url_api;
    }

    public void setUrl_api(String url_api) {
        this.url_api = url_api;
    }

    public UserProjectFrom getFrom() {
        return from;
    }

    public void setFrom(UserProjectFrom from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_html() {
        return description_html;
    }

    public void setDescription_html(String description_html) {
        this.description_html = description_html;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getBid_count() {
        return bid_count;
    }

    public void setBid_count(String bid_count) {
        this.bid_count = bid_count;
    }

    public String getHas_placed_bid() {
        return has_placed_bid;
    }

    public void setHas_placed_bid(String has_placed_bid) {
        this.has_placed_bid = has_placed_bid;
    }

    public Date getPublication_time() {
        return publication_time;
    }

    public void setPublication_time(Date publication_time) {
        this.publication_time = publication_time;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    public String getIs_job() {
        return is_job;
    }

    public void setIs_job(String is_job) {
        this.is_job = is_job;
    }

    public String getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(String is_featured) {
        this.is_featured = is_featured;
    }

    public String getIs_identity_verified() {
        return is_identity_verified;
    }

    public void setIs_identity_verified(String is_identity_verified) {
        this.is_identity_verified = is_identity_verified;
    }

    public Map<String, String> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, String> skills) {
        this.skills = skills;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }
}
