package com.sanda.chrome.freelancehunt.restful.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cdc89 on 17.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProjectFrom extends UserFrom {
    String url_api;
    String fname;
    String sname;

    public String getUrl_api() {
        if (url_api==null)
            url_api="";
        return url_api;
    }

    public void setUrl_api(String url_api) {
        this.url_api = url_api;
    }

    public String getFname() {
        if (fname==null)
            fname="";
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        if (sname==null)
            sname="";
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return super.toString() + "; " +
                "url_api - " + getUrl_api() + "; " +
                "fname - " + getFname() + "; " +
                "sname - " + getSname();

    }
}
