package com.sdk.poibase.model.reversegeotop;

import java.io.Serializable;

public class ReverseParam implements Serializable {
    public float accuracy;
    public boolean isFence;
    public boolean isFilterRecom;
    public boolean isHistory;
    public boolean isPassenger = true;
    public String mapSdkType;
    public String mapType;
    public String maplevel;
    public String passengerId;
    public String phoneNum;
    public int productid;
    public String provider;
    public double reverseLat;
    public double reverseLng;
    public int strategy = 0;
    public double userLat;
    public double userLng;

    public String toString() {
        return "ReverseParam{productid=" + this.productid + ", isPassenger=" + this.isPassenger + ", mapSdkType='" + this.mapSdkType + '\'' + ", mapType='" + this.mapType + '\'' + ", reverseLng=" + this.reverseLng + ", reverseLat=" + this.reverseLat + ", userLng=" + this.userLng + ", userLat=" + this.userLat + ", phoneNum='" + this.phoneNum + '\'' + ", passengerId='" + this.passengerId + '\'' + ", isHistory=" + this.isHistory + ", isFilterRecom=" + this.isFilterRecom + ", isFence=" + this.isFence + ", strategy=" + this.strategy + ", maplevel=" + this.maplevel + '}';
    }
}
