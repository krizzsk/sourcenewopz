package com.didi.map.global.component.dropoff.data;

import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;

public interface IDropOffDataTask {

    public interface TaskCallback {
        void onDataFailed();

        void onDataStart();

        void onDataSuccess(DestPoiReverseInfo destPoiReverseInfo);
    }

    void destroy();

    int getId();

    void start();

    void stop();
}
