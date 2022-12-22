package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeTracker */
public class AccTimeTracker implements IAccTimeTracker {

    /* renamed from: a */
    private static final String f45972a = "AccTimeTracker| ";

    /* renamed from: b */
    private static final int f45973b = 60000;

    /* renamed from: c */
    private static final int f45974c = 1000;

    /* renamed from: d */
    private Context f45975d;

    /* renamed from: e */
    private boolean f45976e = false;

    /* renamed from: f */
    private List<AccTimeLocModel> f45977f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f45978g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f45979h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Runnable f45980i = new Runnable() {
        public void run() {
            if (AccTimeTracker.this.f45979h < 0) {
                long unused = AccTimeTracker.this.f45979h = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - AccTimeTracker.this.f45979h >= 60000) {
                long unused2 = AccTimeTracker.this.f45979h = currentTimeMillis;
                AccTimeTracker.this.m32999a();
            }
            if (AccTimeTracker.this.f45978g != null) {
                AccTimeTracker.this.f45978g.postDelayed(AccTimeTracker.this.f45980i, 1000);
            }
        }
    };

    public AccTimeTracker(Context context) {
        this.f45975d = context;
        this.f45977f = new ArrayList();
        this.f45978g = new Handler(Looper.getMainLooper());
    }

    public void startTracking() {
        if (AccTimeFilterHelper.getInstance().shouldTrack() && !this.f45976e) {
            this.f45976e = true;
            Handler handler = this.f45978g;
            if (handler != null) {
                handler.post(this.f45980i);
            }
            DLog.m32737d("AccTimeTracker| start tracking");
        }
    }

    public void stopTracking() {
        if (AccTimeFilterHelper.getInstance().shouldTrack() && this.f45976e) {
            this.f45976e = false;
            Handler handler = this.f45978g;
            if (handler != null) {
                handler.removeCallbacks(this.f45980i);
            }
            List<AccTimeLocModel> list = this.f45977f;
            if (list != null) {
                list.clear();
            }
            DLog.m32737d("AccTimeTracker| stop tracking");
        }
    }

    public void updateNotifiedLocation(DIDILocation dIDILocation, String str) {
        Handler handler;
        if (AccTimeFilterHelper.getInstance().shouldTrack() && (handler = this.f45978g) != null) {
            handler.post(new Runnable(dIDILocation, str) {
                public final /* synthetic */ DIDILocation f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    AccTimeTracker.this.m33000a(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33000a(DIDILocation dIDILocation, String str) {
        if (dIDILocation != null) {
            AccTimeLocModel accTimeLocModel = new AccTimeLocModel();
            accTimeLocModel.lat = dIDILocation.getLatitude();
            accTimeLocModel.lng = dIDILocation.getLongitude();
            accTimeLocModel.timestampProduce = dIDILocation.getLocalTime();
            accTimeLocModel.timestampDriver = System.currentTimeMillis();
            accTimeLocModel.timestampNTP = dIDILocation.getTime();
            accTimeLocModel.typeStr = str;
            List<AccTimeLocModel> list = this.f45977f;
            if (list != null) {
                list.add(accTimeLocModel);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32999a() {
        List<AccTimeLocModel> list;
        try {
            Gson gson = new Gson();
            String str = "";
            if (this.f45977f != null && this.f45977f.size() > 0) {
                str = gson.toJson((Object) this.f45977f);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = Utils.isLocationPermissionGranted(this.f45975d) ? 1 : 0;
            long driverId = PlatInfo.getInstance().getDriverId();
            HashMap hashMap = new HashMap();
            hashMap.put("list", str);
            hashMap.put("timestamp_upload", Long.valueOf(currentTimeMillis));
            hashMap.put("loc_permission", Integer.valueOf(i));
            hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(driverId));
            OmegaSDKAdapter.trackEvent("map_location_strategy_source_bt", (Map<String, Object>) hashMap);
            StringBuilder sb = new StringBuilder();
            sb.append("AccTimeTracker| map_location_strategy_source_bt: flush all data, size is: ");
            sb.append(this.f45977f != null ? this.f45977f.size() : -1);
            sb.append(", timestamp_upload: ");
            sb.append(currentTimeMillis);
            sb.append(", loc_permission: ");
            sb.append(i);
            sb.append(", driver_id: ");
            sb.append(driverId);
            DLog.m32737d(sb.toString());
            list = this.f45977f;
            if (list == null) {
                return;
            }
        } catch (Exception e) {
            DLog.m32737d("AccTimeTracker| flush exception:" + e.getMessage() + ", " + e.getClass());
            list = this.f45977f;
            if (list == null) {
                return;
            }
        } catch (Throwable th) {
            List<AccTimeLocModel> list2 = this.f45977f;
            if (list2 != null) {
                list2.clear();
                DLog.m32737d("AccTimeTracker| data cleared");
            }
            throw th;
        }
        list.clear();
        DLog.m32737d("AccTimeTracker| data cleared");
    }
}
