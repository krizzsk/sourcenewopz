package com.didi.sdk.sidebar.model;

import java.io.Serializable;
import java.util.List;

public class SidebarPage implements Serializable {
    List<List<SidebarItem>> groupList;
    private String name;
    private String subLevel;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<List<SidebarItem>> getGroupList() {
        return this.groupList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getSubLevel() {
        return this.subLevel;
    }

    public void setSubLevel(String str) {
        this.subLevel = str;
    }

    public String toString() {
        return "SidebarPage{name='" + this.name + '\'' + ", subLevel='" + this.subLevel + '\'' + ", title='" + this.title + '\'' + ", groupList=" + this.groupList + '}';
    }

    public void setGroupList(List<List<SidebarItem>> list) {
        this.groupList = list;
    }
}
