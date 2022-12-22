package com.didi.sdk.nation;

public enum MapType {
    MAPTYPE_SOSO("soso", 2),
    MATYPE_GMAP("gmap", 4),
    MAPTYPE_WGS84("wgs84", 3),
    MATYPE_HMS("hmap", 5);
    
    private int mapTypeInt;
    private String mapTypeString;

    private MapType(String str, int i) {
        this.mapTypeString = str;
        this.mapTypeInt = i;
    }

    public String getMapTypeString() {
        return this.mapTypeString;
    }

    public int getMapTypeInt() {
        return this.mapTypeInt;
    }
}
