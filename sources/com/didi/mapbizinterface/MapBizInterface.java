package com.didi.mapbizinterface;

import android.content.Context;
import com.didi.mapbizinterface.track.MapTrackExtraDataProvider;
import com.didi.mapbizinterface.utils.ThreadDispatcher;

public class MapBizInterface {
    private MapBizInterface() {
    }

    private static class SingletonHolder {
        static MapBizInterface INSTANCE = new MapBizInterface();

        private SingletonHolder() {
        }
    }

    public static MapBizInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(final Context context) {
        ThreadDispatcher.runOnMainThread(new Runnable() {
            public void run() {
                MapTrackExtraDataProvider.getInstance().init(context);
            }
        });
    }
}
