package com.sanda.chrome.freelancehunt.restful.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cdc89 on 03.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFrom {
    String profile_id;
    String login;
    String url;
    String avatar;
    @Override
    public String toString(){
        return "profile_id - "+profile_id+"; "
                +"login - "+login+"; "
                +"url - "+url+"; "
                +"avatar - "+avatar;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
