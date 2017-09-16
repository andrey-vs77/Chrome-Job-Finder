package com.sanda.chrome.freelancehunt.restful.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cdc89 on 03.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedElement {
    UserFrom from;
    String time;
    String time_millis;
    String message;
    Boolean is_new;
    RelatedProject related;

    @Override
    public String toString(){
        if (related == null){
            related=new RelatedProject();
            related.setProject_id("");
        }
        return "from - "+from.toString()+"; "
                +"time - " + time+"; "
                +"time_millis - "+time_millis+"; "
       +"message - "+message+ "; "
       +"is_new - "+is_new.toString()+ "; "
       +"related - "+related.toString()+ "; ";
    }

    public UserFrom getFrom() {
        return from;
    }

    public void setFrom(UserFrom from) {
        this.from = from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime_millis() {
        return time_millis;
    }

    public void setTime_millis(String time_millis) {
        this.time_millis = time_millis;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIs_new() {
        return is_new;
    }

    public void setIs_new(Boolean is_new) {
        this.is_new = is_new;
    }

    public RelatedProject getRelated() {
        return related;
    }

    public void setRelated(RelatedProject related) {
        this.related = related;
    }
}

