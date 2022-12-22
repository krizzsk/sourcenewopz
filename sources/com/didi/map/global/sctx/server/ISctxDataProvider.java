package com.didi.map.global.sctx.server;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.sctx.model.PushInfo;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import java.util.List;

public interface ISctxDataProvider {
    public static final long DEFAULT_SYNC_INTERVAL = 3000;
    public static final long MAX_SYNC_INTERVAL = 15000;
    public static final long MIN_SYNC_INTERVAL = 1000;

    /* renamed from: com.didi.map.global.sctx.server.ISctxDataProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getRoutePoints(ISctxDataProvider iSctxDataProvider) {
            return null;
        }

        public static List $default$getTrafficItems(ISctxDataProvider iSctxDataProvider) {
            return null;
        }
    }

    public interface DataSearchOptions {
        Context getContext();

        PushInfo getPushInfo();

        PassengerOrderRouteReq getRequestBody();

        String getUrl();
    }

    public enum SyncMode {
        HTTP,
        PUSH,
        GOOGLE
    }

    void destroy();

    DataSearchOptions getDataSearchOptions();

    List<LatLng> getRoutePoints();

    List<TrafficItem> getTrafficItems();

    boolean isRunning();

    void pauseSync();

    void resumeSync();

    void runImmediately(PassengerOrderRouteReq passengerOrderRouteReq);

    void setCallback(IDataCallback iDataCallback);

    void setInterval(long j);

    void startSync();

    void stopSync();
}
