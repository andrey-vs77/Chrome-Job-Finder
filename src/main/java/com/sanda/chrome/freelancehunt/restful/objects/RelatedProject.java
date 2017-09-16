package com.sanda.chrome.freelancehunt.restful.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cdc89 on 03.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedProject {
    String project_id;

    @Override
    public String toString(){
        if (project_id==null)
            return "";
        return project_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }
}
