package com.didi.sdk.sidebar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OriginData implements Serializable {
    private List<RedPoints> fireTorchs = new ArrayList();
    private Map<String, Map<String, SidebarPage>> levels = new HashMap();
    private List<RedPoints> redPoints = new ArrayList();

    public List<RedPoints> getRedPoints() {
        return this.redPoints;
    }

    public void setRedPoints(List<RedPoints> list) {
        this.redPoints = list;
    }

    public List<RedPoints> getFireTorchs() {
        return this.fireTorchs;
    }

    public void setFireTorchs(List<RedPoints> list) {
        this.fireTorchs = list;
    }

    public Map<String, Map<String, SidebarPage>> getLevels() {
        return this.levels;
    }

    public void setLevels(Map<String, Map<String, SidebarPage>> map) {
        this.levels = map;
    }

    public String toString() {
        return "OriginData{levels=" + this.levels + '}';
    }
}
