package com.didiglobal.common.common.mew.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class EMewUIConfig implements Serializable {
    @SerializedName("background_item")
    public Background background;
    @SerializedName("balcony_item")
    public Balcony balcony;
    @SerializedName("reversed")
    public int reversed;

    public static class Background implements Serializable {
        @SerializedName("index")
        public int index;
        @SerializedName("translation_y")
        public int translation_y;
    }

    public static class Balcony implements Serializable {
        @SerializedName("elevation")
        public int elevation;
        @SerializedName("index")
        public int index;
    }
}
