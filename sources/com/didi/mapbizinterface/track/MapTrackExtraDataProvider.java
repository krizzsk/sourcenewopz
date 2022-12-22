package com.didi.mapbizinterface.track;

import android.content.Context;
import com.didi.mapbizinterface.common.AppStateMonitor;
import com.didi.mapbizinterface.common.NetStateManager;
import com.didi.mapbizinterface.utils.ApolloUtils;
import com.didi.mapbizinterface.utils.ThreadDispatcher;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdu.didi.protobuf.AppPage;
import com.sdu.didi.protobuf.AppState;
import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.sdu.didi.protobuf.SimpleLocationInfo;
import java.util.ArrayList;
import java.util.List;

public class MapTrackExtraDataProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile boolean f29077a;

    private MapTrackExtraDataProvider() {
        this.f29077a = false;
    }

    private static class SingletonHolder {
        static MapTrackExtraDataProvider INSTANCE = new MapTrackExtraDataProvider();

        private SingletonHolder() {
        }
    }

    public static MapTrackExtraDataProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(final Context context) {
        ThreadDispatcher.runOnMainThread(new Runnable() {
            public void run() {
                if (context != null && !MapTrackExtraDataProvider.this.f29077a) {
                    boolean unused = MapTrackExtraDataProvider.this.f29077a = true;
                    AppStateMonitor.getInstance().init(context);
                    NetStateManager.getInstance().init(context);
                }
            }
        });
    }

    public MapTrackExtraMessageData getExtraTrackMessageData(TrackMessageParams trackMessageParams) {
        DIDILocation dIDILocation = null;
        MapTrackExtraMessageData.Builder flp_strategy = new MapTrackExtraMessageData.Builder().satellite_num(Integer.valueOf(m20495a(trackMessageParams != null ? trackMessageParams.f29081c : null))).network_state(NetStateManager.getInstance().getNetworkState()).signal_level(Integer.valueOf(NetStateManager.getInstance().getSignalLevel())).flp_strategy(m20500b(trackMessageParams != null ? trackMessageParams.f29081c : null));
        if (trackMessageParams != null) {
            dIDILocation = trackMessageParams.f29081c;
        }
        MapTrackExtraMessageData build = flp_strategy.original_loc_source(m20503d(dIDILocation)).app_state(m20496a()).app_page(m20499b()).track_sdk_flag(Integer.valueOf((trackMessageParams == null || trackMessageParams.f29082d == null) ? 0 : trackMessageParams.f29082d.intValue())).vdr_locations(m20502c()).build();
        if (ApolloUtils.isDebugLogEnabled()) {
            try {
                SystemUtils.log(3, "snser", String.valueOf(build), (Throwable) null, "com.didi.mapbizinterface.track.MapTrackExtraDataProvider", 77);
            } catch (Exception unused) {
            }
        }
        return build;
    }

    public MapTrackExtraPointData getExtraTrackPointData(TrackPointParams trackPointParams) {
        DIDILocation dIDILocation = null;
        MapTrackExtraPointData.Builder app_state = new MapTrackExtraPointData.Builder().satellite_num(Integer.valueOf(m20495a(trackPointParams != null ? trackPointParams.f29083a : null))).original_loc_source(m20503d(trackPointParams != null ? trackPointParams.f29083a : null)).app_state(m20496a());
        if (trackPointParams != null) {
            dIDILocation = trackPointParams.f29083a;
        }
        MapTrackExtraPointData build = app_state.flp_simplified_strategy(m20501c(dIDILocation)).build();
        if (ApolloUtils.isDebugLogEnabled()) {
            try {
                SystemUtils.log(3, "snser", String.valueOf(build), (Throwable) null, "com.didi.mapbizinterface.track.MapTrackExtraDataProvider", 98);
            } catch (Exception unused) {
            }
        }
        return build;
    }

    public void updateBizInfo(int i, Object obj) {
        BizInfoProvider.m20490a().mo79984a(i, obj);
    }

    /* renamed from: a */
    private int m20495a(DIDILocation dIDILocation) {
        if (dIDILocation == null || dIDILocation.getExtra() == null) {
            return -1;
        }
        return dIDILocation.getExtra().getInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, -1);
    }

    /* renamed from: b */
    private String m20500b(DIDILocation dIDILocation) {
        if (dIDILocation == null || dIDILocation.getExtra() == null) {
            return null;
        }
        return dIDILocation.getExtra().getString(DIDILocation.EXTRA_KEY_FLP_STRATEGY, (String) null);
    }

    /* renamed from: c */
    private String m20501c(DIDILocation dIDILocation) {
        if (dIDILocation == null || dIDILocation.getExtra() == null) {
            return null;
        }
        return dIDILocation.getExtra().getString(DIDILocation.EXTRA_KEY_SIMPLIFIED_FLP_STRATEGY, (String) null);
    }

    /* renamed from: d */
    private String m20503d(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            return dIDILocation.getSource();
        }
        return null;
    }

    /* renamed from: com.didi.mapbizinterface.track.MapTrackExtraDataProvider$2 */
    static /* synthetic */ class C102452 {

        /* renamed from: $SwitchMap$com$didi$mapbizinterface$common$AppStateMonitor$AppState */
        static final /* synthetic */ int[] f29078xe1aa486a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.mapbizinterface.common.AppStateMonitor$AppState[] r0 = com.didi.mapbizinterface.common.AppStateMonitor.AppState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29078xe1aa486a = r0
                com.didi.mapbizinterface.common.AppStateMonitor$AppState r1 = com.didi.mapbizinterface.common.AppStateMonitor.AppState.FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29078xe1aa486a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.mapbizinterface.common.AppStateMonitor$AppState r1 = com.didi.mapbizinterface.common.AppStateMonitor.AppState.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.mapbizinterface.track.MapTrackExtraDataProvider.C102452.<clinit>():void");
        }
    }

    /* renamed from: a */
    private AppState m20496a() {
        int i = C102452.f29078xe1aa486a[AppStateMonitor.getInstance().getAppState().ordinal()];
        if (i == 1) {
            return AppState.FOREGROUND_ACTIVE;
        }
        if (i != 2) {
            return null;
        }
        return AppState.BACKGROUND;
    }

    /* renamed from: b */
    private AppPage m20499b() {
        Object a = BizInfoProvider.m20490a().mo79982a(4097);
        if (a instanceof AppPage) {
            return (AppPage) a;
        }
        return AppPage.OTHERS;
    }

    /* renamed from: c */
    private List<SimpleLocationInfo> m20502c() {
        if (!NetStateManager.getInstance().isNetAvailable()) {
            return new ArrayList();
        }
        List<DIDILocation> a = BizInfoProvider.m20490a().mo79983a(4098, DIDILocation.class, 60);
        ArrayList arrayList = new ArrayList();
        for (DIDILocation next : a) {
            arrayList.add(new SimpleLocationInfo.Builder().lat(Double.valueOf(next.getLatitude())).lng(Double.valueOf(next.getLongitude())).speed(Double.valueOf((double) next.getSpeed())).direction(Double.valueOf((double) next.getBearing())).time64_loc(Long.valueOf(next.getTime())).build());
        }
        return arrayList;
    }
}
