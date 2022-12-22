package com.rider.rlab_im_map_plugin.tool;

import java.io.Serializable;

public enum ImFavorFrom implements Serializable {
    UNKNOWN("unknown"),
    IMMAP_GLOBAL("global"),
    IMMAP_BRAZIL("brazil");
    
    private final String name;

    private ImFavorFrom(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(ImFavorFrom imFavorFrom) {
        return imFavorFrom != null && imFavorFrom.toString().equals(this.name);
    }
}
