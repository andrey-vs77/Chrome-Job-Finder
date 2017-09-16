package com.sanda.chrome.freelancehunt.restful.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cdc89 on 17.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Skill {

    int skill_id;
    String skill_name;
    Object content;

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public Object getContent() {
        if (content==null)
            content="";
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format("id - %d; name - %s",skill_id, skill_name);
    }
}
