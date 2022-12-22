package com.rider.rlab_im_map_plugin.tool;

import java.io.Serializable;

public enum ImCallFrom implements Serializable {
    UNKNOWN("unknown"),
    IMMAP_RLAB_B("ImMap_RLab_B"),
    IMMAP_RLAB_C("ImMap_RLab_C"),
    IMMAP_RLAB_D("ImMap_RLab_D");
    
    private final String name;

    private ImCallFrom(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(ImCallFrom imCallFrom) {
        return imCallFrom != null && imCallFrom.toString().equals(this.name);
    }
}
