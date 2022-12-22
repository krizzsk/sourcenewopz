package com.didi.app.delegate;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;

public class MapViewHolder {
    public static final int TYPE_MAIN = 0;

    /* renamed from: a */
    private View f8247a;

    private MapViewHolder() {
    }

    private static final class Sigleton {
        /* access modifiers changed from: private */
        public static final MapViewHolder INSTANCE = new MapViewHolder();

        private Sigleton() {
        }
    }

    public static final MapViewHolder getInstance() {
        return Sigleton.INSTANCE;
    }

    public View getMapView() {
        return this.f8247a;
    }

    public void setMapView(View view) {
        this.f8247a = view;
    }

    public View preInitGoogleMapImpl(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            View inflate = LayoutInflater.from(context).inflate(R.layout.v_map, (ViewGroup) null);
            SystemUtils.log(3, "MapViewHolder", "preInitGoogleMap time: " + (System.currentTimeMillis() - currentTimeMillis), (Throwable) null, "com.didi.app.delegate.MapViewHolder", 58);
            return inflate;
        } catch (Throwable th) {
            OmegaSDK.trackError("map_init", th);
            SystemUtils.log(6, "MapViewHolder", "preInitGoogleMap fail" + th.getMessage(), (Throwable) null, "com.didi.app.delegate.MapViewHolder", 62);
            return null;
        }
    }

    public void initMap(Context context) {
        SystemUtils.log(4, "initMap", "initMap: start", (Throwable) null, "com.didi.app.delegate.MapViewHolder", 68);
        if (this.f8247a == null) {
            this.f8247a = preInitGoogleMapImpl(context);
        }
    }

    public void postInitMap(final Context context) {
        if (this.f8247a == null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                public void run() {
                    SystemUtils.log(3, "MapViewHolder", "postInitMap", (Throwable) null, "com.didi.app.delegate.MapViewHolder$1", 79);
                    MapViewHolder.this.initMap(context);
                }
            });
        }
    }
}
