package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.PermissionSwitchUtils;
import com.didichuxing.bigdata.p173dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p173dp.locsdk.utils.TraceUtils;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rui.config.RConfigConstants;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor */
class LocConfessor {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile boolean f45868a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile boolean f45869b = false;

    /* renamed from: c */
    private Context f45870c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile long f45871d = DIDILocationUpdateOption.IntervalMode.NORMAL.getValue();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f45872e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile LocationUpdateInternalListener f45873f;

    /* renamed from: g */
    private LocationUpdateInternalListener f45874g;

    /* renamed from: h */
    private int f45875h;

    /* renamed from: i */
    private long f45876i;

    /* renamed from: j */
    private List<Pair<String, Long>> f45877j;

    /* renamed from: k */
    private StringBuilder f45878k = new StringBuilder("");
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f45879l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C15136c f45880m;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor$RetrieveLocationCallback */
    interface RetrieveLocationCallback {
        void onLocationChanged(DIDILocation dIDILocation);

        void onLocationError(int i, ErrInfo errInfo);
    }

    /* renamed from: b */
    private void m32913b(long j) {
    }

    /* renamed from: a */
    public String mo114481a() {
        return String.valueOf(m32916d());
    }

    /* renamed from: d */
    private StringBuilder m32916d() {
        return this.f45878k;
    }

    /* renamed from: a */
    private void m32909a(StringBuilder sb) {
        this.f45878k = sb;
    }

    /* renamed from: a */
    public void mo114485a(List<Pair<String, Long>> list) {
        this.f45877j = list;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor$RetriveLocLoopTask */
    private class RetriveLocLoopTask implements Runnable {
        public RetriveLocLoopTask() {
        }

        public void run() {
            if (LocConfessor.this.f45869b && LocConfessor.this.f45880m != null) {
                LocConfessor.this.m32918e();
                if (LocConfessor.this.f45879l > DIDILocationUpdateOption.IntervalMode.BATTERY_SAVE.getValue()) {
                    LocConfessor locConfessor = LocConfessor.this;
                    long unused = locConfessor.f45879l = locConfessor.f45871d;
                }
                C15136c b = LocConfessor.this.f45880m;
                LocConfessor locConfessor2 = LocConfessor.this;
                b.mo114556a((RetrieveLocationCallback) new RetrieveLocationCallbackImpl(locConfessor2.f45879l));
                if (LocConfessor.this.f45869b && ThreadDispatcher.getWorkThread().isAlive()) {
                    ThreadDispatcher.getWorkThread().postDelayed(LocConfessor.this.f45872e, LocConfessor.this.f45871d);
                    LocConfessor locConfessor3 = LocConfessor.this;
                    long unused2 = locConfessor3.f45879l = locConfessor3.f45879l + LocConfessor.this.f45871d;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m32918e() {
        this.f45880m.mo114560b(this.f45871d);
    }

    protected LocConfessor(Context context) {
        this.f45870c = context;
        NetUtils.init(context);
        this.f45875h = Utils.getCoordinateType();
    }

    /* renamed from: a */
    public void mo114483a(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45873f = locationUpdateInternalListener;
    }

    /* renamed from: b */
    public void mo114488b(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f45874g = locationUpdateInternalListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo114484a(String str) {
        DLog.m32737d("LocConfessor:start");
        if (!this.f45868a) {
            C15136c createLocationStrategy = LocationStrategyFactory.getIntance().createLocationStrategy(this.f45870c, this.f45875h);
            this.f45880m = createLocationStrategy;
            createLocationStrategy.mo114557a(this.f45874g);
            this.f45880m.mo114555a(this.f45871d);
            this.f45880m.mo114558a(str);
            this.f45872e = new RetriveLocLoopTask();
            ThreadDispatcher.getWorkThread().post(this.f45872e);
            this.f45869b = true;
            this.f45868a = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo114487b() {
        if (this.f45868a) {
            if (this.f45880m != null) {
                this.f45880m.mo114554a();
                this.f45880m.mo114557a((LocationUpdateInternalListener) null);
                this.f45880m = null;
            }
            ThreadDispatcher.getWorkThread().removeCallbacks(this.f45872e);
            this.f45872e = null;
            this.f45869b = false;
            this.f45879l = 0;
            this.f45871d = DIDILocationUpdateOption.IntervalMode.NORMAL.getValue();
            this.f45873f = null;
            this.f45874g = null;
            this.f45868a = false;
        }
    }

    /* renamed from: c */
    public long mo114489c() {
        return this.f45871d;
    }

    /* renamed from: a */
    public void mo114482a(final long j) {
        C15136c cVar = this.f45880m;
        if (cVar != null) {
            cVar.mo114555a(j);
        }
        if (!this.f45868a) {
            this.f45879l = 0;
            this.f45871d = j;
        } else if (ThreadDispatcher.getWorkThread().isAlive()) {
            ThreadDispatcher.getWorkThread().post(new Runnable() {
                public void run() {
                    if (LocConfessor.this.f45868a) {
                        long unused = LocConfessor.this.f45879l = 0;
                        long unused2 = LocConfessor.this.f45871d = j;
                        ThreadDispatcher.getWorkThread().removeCallbacks(LocConfessor.this.f45872e);
                        ThreadDispatcher.getWorkThread().post(LocConfessor.this.f45872e);
                    }
                }
            });
        }
        if (!this.f45870c.getPackageName().equals("com.sdu.didi.gsui")) {
            return;
        }
        if (j == DIDILocationUpdateOption.IntervalMode.NORMAL.getValue() || j == DIDILocationUpdateOption.IntervalMode.BATTERY_SAVE.getValue()) {
            PermissionSwitchUtils.PermissionSwitchState permissionSwitchState = PermissionSwitchUtils.getPermissionSwitchState(this.f45870c);
            HashMap hashMap = new HashMap();
            hashMap.put("phone", TraceUtils.getPhone(this.f45870c));
            hashMap.put("ui_version", Build.ID);
            hashMap.put("sdk_version", String.valueOf(11016));
            hashMap.put("location_switch_level", String.valueOf(Utils.getLocationSwitchLevel(this.f45870c)));
            hashMap.put("location_permission", String.valueOf(Utils.getLocationPermissionLevel(this.f45870c)));
            hashMap.put("pemissiomDIDINLPManagern_switch_state", String.valueOf(permissionSwitchState.ordinal()));
            OmegaSDKAdapter.trackEvent("pemission_switch_state", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114486a(Set<LocationListenerWrapper> set) {
        if (set != null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (LocationListenerWrapper next : set) {
                sb.append(next.getOption().getModuleKey());
                sb.append(":");
                sb.append(next.getListener());
                sb.append("@");
                sb.append(next.getOption().getInterval().getValue());
                sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                sb2.append(next.getOption().getModuleKey());
                sb2.append(":");
                sb2.append(next.getOption().getHexModuleKey());
                sb2.append(RConfigConstants.KEYWORD_COLOR_SIGN);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            m32909a(sb);
            C15136c cVar = this.f45880m;
            if (cVar != null) {
                cVar.mo114559a(m32916d());
            }
            DLog.m32737d("updateListenerInfo listeners=" + sb.toString());
            DLog.m32737d("updateListenerInfo moduleKeys=" + sb2.toString());
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor$RetrieveLocationCallbackImpl */
    private class RetrieveLocationCallbackImpl implements RetrieveLocationCallback {
        private long mIntervalCount;

        RetrieveLocationCallbackImpl(long j) {
            this.mIntervalCount = j;
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (LocConfessor.this.f45873f != null) {
                dIDILocation.getExtra().putInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, GpsManager.getInstance().getFixLocSatelliteNum());
                dIDILocation.getExtra().putFloat(DIDILocation.EXTRA_KEY_GPS_SIGNAL_LEVEL, GpsManager.getInstance().getGpsSignalLevel());
                LocConfessor.this.f45873f.onLocationUpdate(dIDILocation, this.mIntervalCount);
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            if (LocConfessor.this.f45873f != null) {
                LocConfessor.this.f45873f.onLocationErr(errInfo, this.mIntervalCount);
            }
        }
    }
}
