package com.didi.sdk.misconfig.model;

import java.io.Serializable;

public class WarmupActivity implements Serializable {
    private String activityCover;
    private String description;
    private String h5link;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getActivityCover() {
        return this.activityCover;
    }

    public void setActivityCover(String str) {
        this.activityCover = str;
    }

    public String getH5link() {
        return this.h5link;
    }

    public void setH5link(String str) {
        this.h5link = str;
    }

    public String toString() {
        return "WarmupActivity{title='" + this.title + '\'' + ", description='" + this.description + '\'' + ", activityCover='" + this.activityCover + '\'' + ", h5link='" + this.h5link + '\'' + '}';
    }
}
