package com.didi.dimina.container.bridge.navigationbar;

import java.io.Serializable;
import java.util.List;

public class NavigationBarButtonParams implements Serializable {
    private List<NavigationBarButtonParam> lefts;
    private List<NavigationBarButtonParam> rights;

    public List<NavigationBarButtonParam> getLefts() {
        return this.lefts;
    }

    public void setLefts(List<NavigationBarButtonParam> list) {
        this.lefts = list;
    }

    public List<NavigationBarButtonParam> getRights() {
        return this.rights;
    }

    public void setRights(List<NavigationBarButtonParam> list) {
        this.rights = list;
    }
}
