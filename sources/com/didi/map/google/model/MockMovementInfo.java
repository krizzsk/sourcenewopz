package com.didi.map.google.model;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.nav.inertia.CarMoveInfo;
import java.util.ArrayList;
import java.util.List;

public class MockMovementInfo {
    public int carAnimEda = -1;
    public LatLng carAnimLatLng;
    public CarMoveInfo carMoveInfo;
    public int driverMatchEda = -1;
    public LatLng oriDriverLatLng;
    public List<SctxAnimData> sctxAnimDataList = new ArrayList();

    public static class SctxAnimData {
        public double animDistance = -1.0d;
        public double animLat;
        public double animLng;
        public int carAnimEda = -1;
        public String jumpOverException = "";
        public long localTime;
        public long ntpTimestamp;
    }

    public MockMovementInfo(CarMoveInfo carMoveInfo2) {
        this.carMoveInfo = carMoveInfo2;
    }
}
