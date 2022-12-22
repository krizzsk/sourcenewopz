package com.dmap.navigation.api.core;

import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;

public interface INaviTrafficUpdater {
    public static final int PUSH_CONNECT_MIN_TIME = 5000;
    public static final int PUSH_RECONNECT_TIME = 120000;

    public interface Callback {
        void onBegin();

        void onFinish(ITrafficResponse iTrafficResponse);
    }

    public interface ITrafficResponse {
        ArrayList<Integer> getEtas();

        int getExpireTime();

        byte[] getExtendData();

        byte[] getNaviEvents();

        long getServerTimestamp();

        byte[] getTrafficEvent();

        ArrayList<Integer> getTrafficIndex();

        ArrayList<LatLng> getTrafficInsertPoint();
    }

    void cancel();

    void enqueue(Callback callback);

    byte[] getRequestData();

    void parseData(byte[] bArr, Callback callback);
}
