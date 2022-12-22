package com.didi.trackupload.sdk;

import android.content.Context;
import android.util.Log;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public class TrackManager {

    /* renamed from: a */
    private static final String f36993a = "TrackManager";

    private TrackManager() {
        TrackLog.m31343d(f36993a, "TrackManager newInstance hashcode=0x" + Integer.toHexString(hashCode()));
    }

    private static class SingletonHolder {
        static final TrackManager INSTANCE = new TrackManager();

        private SingletonHolder() {
        }
    }

    public static TrackManager getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public int init(Context context, TrackInitParams trackInitParams) {
        if (!(context == null || trackInitParams == null)) {
            TrackController.getIntance().mo95129a(context, trackInitParams);
        }
        int a = TrackController.getIntance().mo95125a();
        TrackLog.m31343d(f36993a, "init version=1.0.002");
        TrackLog.m31343d(f36993a, "init err=" + TrackErrInfo.toErrString(a) + " context=" + context + " params=" + trackInitParams);
        StringBuilder sb = new StringBuilder();
        sb.append("init trace=");
        sb.append(Log.getStackTraceString(new Throwable()));
        TrackLog.m31343d(f36993a, sb.toString());
        return a;
    }

    public TrackClient createTrackClient(TrackClientType trackClientType, String str) {
        TrackClient a = TrackController.getIntance().mo95128a(trackClientType, str);
        TrackLog.m31343d(f36993a, "createTrackClient client=" + a);
        return a;
    }

    public int startTrackOnce(TrackClientType trackClientType, String str, ITrackDataDelegate iTrackDataDelegate) {
        TrackOnceClient trackOnceClient = new TrackOnceClient(trackClientType, str);
        trackOnceClient.mo95161a(iTrackDataDelegate);
        int a = trackOnceClient.mo95160a();
        TrackLog.m31343d(f36993a, "startTrackOnce err=" + TrackErrInfo.toErrString(a) + " client=" + trackOnceClient);
        return a;
    }

    @Deprecated
    public void setSubtitudeLoc(DIDILocation dIDILocation) {
        LocationCenter.getIntance().setSubtitudeLoc(dIDILocation);
    }
}
