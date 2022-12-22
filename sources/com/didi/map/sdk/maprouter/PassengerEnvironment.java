package com.didi.map.sdk.maprouter;

import com.didi.map.sdk.maprouter.china.CommonData;

public class PassengerEnvironment {
    public static void setClientVersion(String str) {
        CommonData.getInstance().setClientVersion(str);
    }

    public static void setPassengerPhoneNumber(String str) {
        CommonData.getInstance().setPhoneNumber(str);
    }

    public static void setTicket(String str) {
        CommonData.getInstance().setTicket(str);
    }

    public static void setDriverId(String str) {
        CommonData.getInstance().setDriverId(str);
    }

    public static void setTraverId(String str) {
        CommonData.getInstance().setTravelId(str);
    }

    public static void setBizType(int i) {
        CommonData.getInstance().setBizType(i);
    }

    public static void setCountryId(String str) {
        CommonData.getInstance().setCountryId(str);
    }

    public static void setOrderId(String str) {
        CommonData.getInstance().setOrderId(str);
    }

    public static void setOrderStage(int i) {
        CommonData.getInstance().setOrderStage(i);
    }

    public static void setOrderStartPoint(double d, double d2) {
        CommonData.getInstance().setStartLat(d);
        CommonData.getInstance().setStartLon(d2);
    }

    public static void setOrderDestPoint(double d, double d2) {
        CommonData.getInstance().setDestLat(d);
        CommonData.getInstance().setDestLon(d2);
    }

    public static void setOrderGetonPoint(double d, double d2) {
        CommonData.getInstance().setGetOnLat(d);
        CommonData.getInstance().setGetOnLon(d2);
    }

    public static void setLastOrderId(String str) {
        CommonData.getInstance().setLastOrderId(str);
    }

    public void setRouteId(String str) {
        CommonData.getInstance().setRouteId(str);
    }

    public void setTripStep(int i) {
        CommonData.getInstance().setTripStep(i);
    }

    public void setMapType(int i) {
        CommonData.getInstance().setMapType(i);
    }

    public void setTerminal(int i) {
        CommonData.getInstance().setTerminal(i);
    }
}
