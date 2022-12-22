package com.didi.sdk.misconfig.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Smooth implements Serializable {
    private static final long serialVersionUID = 1;
    @SerializedName("goingFrequency")
    private int mGoingFrequency = 10;
    @SerializedName("homeFrequency")
    private int mHomeFrequency = 5;

    public int getHomeFrequency() {
        return this.mHomeFrequency;
    }

    public void setHomeFrequency(int i) {
        this.mHomeFrequency = i;
    }

    public int getGoingFrequency() {
        return this.mGoingFrequency;
    }

    public void setGoingFrequency(int i) {
        this.mGoingFrequency = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Smooth smooth = (Smooth) obj;
        if (this.mHomeFrequency == smooth.mHomeFrequency && this.mGoingFrequency == smooth.mGoingFrequency) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.mHomeFrequency * 31) + this.mGoingFrequency;
    }
}
