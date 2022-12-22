package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.didi.mapbizinterface.track.MapTrackExtraDataProvider;
import com.didi.trackupload.sdk.Constants;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.FLPDiffInfoGetter;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import rui.config.RConfigConstants;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocCenter */
public class LocCenter {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static boolean f45853j = ApolloProxy.getInstance().justifyStartAtStopErr();

    /* renamed from: o */
    private static CountDownLatch f45854o = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HashSet<LocationListenerWrapper> f45855a;

    /* renamed from: b */
    private ReadWriteLock f45856b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private Context f45857c = null;

    /* renamed from: d */
    private LocConfessor f45858d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f45859e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f45860f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ErrInfo f45861g = null;

    /* renamed from: h */
    private long f45862h;

    /* renamed from: i */
    private StatusBroadcastManager f45863i;

    /* renamed from: k */
    private BroadcastReceiver f45864k = new BroadcastReceiver() {
        public void onReceive(Context context, final Intent intent) {
            ThreadDispatcher.getMainThread().run(new Runnable() {
                public void run() {
                    LocCenter.this.m32892a(intent.getStringExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_TYPE"), intent.getIntExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_VALUE", -1), "");
                }
            });
        }
    };

    /* renamed from: l */
    private LocationUpdateInternalListener f45865l = new LocationUpdateInternalListener() {
        public void onLocationUpdate(final DIDILocation dIDILocation, final long j) {
            if (LocCenter.this.m32899b(dIDILocation)) {
                ThreadDispatcher.getMainThread().removeCallbacks((int) Const.MESSAGE_WHAT_ERRINFO);
                ThreadDispatcher.getMainThread().post(new Runnable() {
                    public void run() {
                        if (LocCenter.this.f45859e) {
                            LocationStorage.getInstance().mo114508a(dIDILocation, "loop");
                            if (LocCenter.this.f45855a != null) {
                                LocCenter.this.m32885a(dIDILocation, (int) j);
                            }
                        }
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("internal listener # on location update but zero loc, provider:");
            sb.append(dIDILocation != null ? dIDILocation.getProvider() : null);
            DLog.m32737d(sb.toString());
        }

        public void onLocationErr(final ErrInfo errInfo, long j) {
            ThreadDispatcher.getMainThread().postDelayed(Const.MESSAGE_WHAT_ERRINFO, new Runnable() {
                public void run() {
                    if (LocCenter.this.f45859e && LocCenter.this.f45855a != null) {
                        ErrInfo unused = LocCenter.this.f45861g = errInfo;
                        LocCenter.this.f45861g.setLocalTime(System.currentTimeMillis());
                        LocCenter.this.m32887a(errInfo);
                        DLog.m32737d(String.valueOf(errInfo));
                    }
                }
            }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
        }
    };

    /* renamed from: m */
    private LocationUpdateInternalListener f45866m = new LocationUpdateInternalListener() {
        public void onLocationErr(ErrInfo errInfo, long j) {
        }

        public void onLocationUpdate(final DIDILocation dIDILocation, final long j) {
            if (LocCenter.this.m32899b(dIDILocation)) {
                if ((LocCenter.this.f45860f || LocCenter.this.m32902d()) && (!DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource()) || LocCenter.this.f45867n)) {
                    LocationStorage.getInstance().mo114508a(dIDILocation, "direct");
                }
                if (LocCenter.this.f45860f) {
                    ThreadDispatcher.getMainThread().removeCallbacks((int) Const.MESSAGE_WHAT_ERRINFO);
                    ThreadDispatcher.getMainThread().post(new Runnable() {
                        public void run() {
                            if (LocCenter.this.f45859e && LocCenter.this.f45855a != null) {
                                LocCenter.this.m32885a(dIDILocation, (int) j);
                            }
                        }
                    });
                }
                ThreadDispatcher.getMainThread().post(new Runnable() {
                    public void run() {
                        if (LocCenter.this.f45859e && LocCenter.this.f45855a != null) {
                            LocCenter.this.m32884a(dIDILocation);
                        }
                    }
                });
                if (DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource()) && !LocCenter.this.f45867n) {
                    MapTrackExtraDataProvider.getInstance().updateBizInfo(4098, dIDILocation);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f45867n = false;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32884a(DIDILocation dIDILocation) {
        HashSet<LocationListenerWrapper> hashSet;
        if (dIDILocation != null && (hashSet = this.f45855a) != null && hashSet.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
            while (it.hasNext()) {
                LocationListenerWrapper next = it.next();
                if (next.getOption().isDirectNotify()) {
                    long elapsedRealtime = dIDILocation.getElapsedRealtime() - next.getNotifyLocTime();
                    long directNotifyValue = next.getOption().getInterval().getDirectNotifyValue();
                    sb.append(Const.jaLeft);
                    sb.append(next.getOption().getHexModuleKey());
                    sb.append(":");
                    sb.append(directNotifyValue);
                    sb.append(":");
                    sb.append(elapsedRealtime);
                    if (elapsedRealtime >= directNotifyValue) {
                        next.setNotifyLocTime(dIDILocation.getElapsedRealtime());
                        if (!DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource()) || this.f45867n) {
                            next.getListener().onLocationChanged(dIDILocation);
                        } else if (next.getListener() == Config.mNaviLocListener) {
                            next.getListener().onLocationChanged(dIDILocation);
                        }
                        sb.append(":");
                        sb.append(dIDILocation.getTime());
                        sb.append(":");
                        sb.append(dIDILocation.getLongitude());
                        sb.append(":");
                        sb.append(dIDILocation.getLatitude());
                    }
                    sb.append(Const.jaRight);
                }
            }
            DLog.m32737d(sb.toString());
        }
    }

    public ErrInfo getLastErrInfo() {
        return this.f45861g;
    }

    public LocCenter(Context context) {
        DLog.m32737d("-LocCenter- LocCenter#onCreate");
        this.f45857c = context;
        this.f45855a = new HashSet<>();
        DLog.m32737d("-LocCenter- new locConfessor");
        this.f45858d = new LocConfessor(this.f45857c);
        StatusBroadcastManager instance = StatusBroadcastManager.getInstance();
        this.f45863i = instance;
        instance.init(this.f45857c);
    }

    public void stop() {
        if (f45853j) {
            f45854o = new CountDownLatch(1);
        }
        this.f45859e = false;
        this.f45860f = false;
        this.f45861g = null;
        ThreadDispatcher.getWorkThread().post(new Runnable() {
            public void run() {
                DLog.m32737d("[stop]justify start at stop:" + LocCenter.f45853j + ",runing:" + LocCenter.this.f45859e);
                if (!LocCenter.this.f45859e || !LocCenter.f45853j) {
                    LocCenter.this.m32901c();
                }
            }
        });
        this.f45863i.unRegisterStatusReceiver(this.f45864k);
        this.f45867n = false;
    }

    public void start(LocationListenerWrapper locationListenerWrapper, final String str) {
        CountDownLatch countDownLatch;
        if (f45853j && (countDownLatch = f45854o) != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LocationStorage.getInstance().setAppId(str);
        this.f45859e = true;
        this.f45862h = Utils.getTimeBoot();
        this.f45861g = null;
        addLocListener(locationListenerWrapper);
        OmegaSDKAdapter.trackEvent("firstlocate_start");
        this.f45860f = true;
        DLog.m32737d("firstlocate_start");
        ThreadDispatcher.getWorkThread().start();
        ThreadDispatcher.getNetThread().start();
        ThreadDispatcher.getWorkThread().post(new Runnable() {
            public void run() {
                DLog.m32737d("[start]justify start at stop:" + LocCenter.f45853j + ",runing:" + LocCenter.this.f45859e);
                if (LocCenter.this.f45859e || !LocCenter.f45853j) {
                    LocCenter.this.m32891a(str);
                }
            }
        });
        this.f45863i.registerStatusReceiver(this.f45864k);
        this.f45867n = ApolloProxy.getInstance().enableInertialVDRAsNormal();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32891a(String str) {
        DLog.m32737d("-LocCenter- start cmd");
        TimeServiceManager.getInstance().start(this.f45857c, Utils.isGlobal());
        try {
            this.f45858d.mo114483a(this.f45865l);
            this.f45858d.mo114488b(this.f45866m);
            this.f45858d.mo114484a(str);
        } catch (Throwable th) {
            DLog.m32737d("LocCenter # start request didi location exception, " + th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m32901c() {
        CountDownLatch countDownLatch;
        DLog.m32737d("-LocCenter- stop cmd");
        try {
            if (this.f45858d != null) {
                this.f45858d.mo114487b();
            }
        } catch (Throwable th) {
            DLog.m32737d("LocCenter # stop remove didi location exception, " + th.getMessage());
        }
        TimeServiceManager.getInstance().stop(this.f45857c);
        ThreadDispatcher.getWorkThread().stop();
        ThreadDispatcher.getNetThread().stop();
        if (f45853j && (countDownLatch = f45854o) != null) {
            countDownLatch.countDown();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m32899b(DIDILocation dIDILocation) {
        return dIDILocation != null && dIDILocation.getError() == 0 && Math.abs(dIDILocation.getLongitude()) > 1.0E-7d && Math.abs(dIDILocation.getLatitude()) > 1.0E-7d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo114463a() {
        return this.f45859e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32887a(ErrInfo errInfo) {
        Lock readLock = this.f45856b.readLock();
        try {
            readLock.lock();
            if (this.f45855a != null && this.f45855a.size() > 0) {
                Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
                while (it.hasNext()) {
                    it.next().getListener().onLocationError(errInfo.getErrNo(), errInfo);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    public long getMinInterval() {
        LocConfessor locConfessor = this.f45858d;
        if (locConfessor != null) {
            return locConfessor.mo114489c();
        }
        return 0;
    }

    public String getListenersInfo() {
        LocConfessor locConfessor = this.f45858d;
        return locConfessor != null ? locConfessor.mo114481a() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32885a(DIDILocation dIDILocation, int i) {
        if (this.f45855a != null) {
            m32886a(dIDILocation, (long) i);
        }
        if (this.f45860f) {
            this.f45860f = false;
            HashMap hashMap = new HashMap();
            hashMap.put("first_loc_time", Long.valueOf(Utils.getTimeBoot() - this.f45862h));
            hashMap.put("provider", dIDILocation.getSource());
            OmegaSDKAdapter.trackEvent(FLPDiffInfoGetter.getInstance().getJustStartOmegaKey(), (Map<String, Object>) hashMap);
            DLog.m32737d("firstlocate_suc");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32892a(String str, int i, String str2) {
        Lock readLock = this.f45856b.readLock();
        try {
            readLock.lock();
            if (this.f45855a != null && this.f45855a.size() > 0) {
                Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
                while (it.hasNext()) {
                    it.next().getListener().onStatusUpdate(str, i, str2);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: a */
    private void m32886a(DIDILocation dIDILocation, long j) {
        Lock readLock = this.f45856b.readLock();
        try {
            readLock.lock();
            if (!(dIDILocation == null || this.f45855a == null || this.f45855a.size() <= 0)) {
                StringBuilder sb = new StringBuilder();
                sb.append(dIDILocation);
                sb.append("@");
                sb.append(j);
                Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
                while (it.hasNext()) {
                    LocationListenerWrapper next = it.next();
                    if (j % next.getOption().getInterval().getValue() == 0) {
                        if (!DIDILocation.SOURCE_GOOGLE_FLP.equals(dIDILocation.getSource())) {
                            if (!DIDILocation.SOURCE_HUAWEI_FLP.equals(dIDILocation.getSource())) {
                                if (!"gps".equals(dIDILocation.getProvider())) {
                                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                                    sb.append(next.getOption().getHexModuleKey());
                                    next.getListener().onLocationChanged(dIDILocation);
                                }
                            }
                        }
                        if (!next.getOption().isDirectNotify()) {
                            sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                            sb.append(next.getOption().getHexModuleKey());
                            next.getListener().onLocationChanged(dIDILocation);
                        } else if (SystemClock.elapsedRealtime() - next.getNotifyLocTime() > 60000 && SystemClock.elapsedRealtime() - next.f45883a > 30000) {
                            Event event = new Event("locsdk_err_direct_notify_not_work");
                            event.putAttr("t_loc", Long.valueOf(dIDILocation.getElapsedRealtime()));
                            event.putAttr("t_sys", Long.valueOf(SystemClock.elapsedRealtime()));
                            event.putAttr("t_notify", Long.valueOf(next.getNotifyLocTime()));
                            event.putAttr("key", next.getOption().getModuleKey());
                            OmegaSDKAdapter.trackEvent("locsdk_err_direct_notify_not_work");
                            next.f45883a = SystemClock.elapsedRealtime();
                        }
                    }
                }
                DLog.m32737d(sb.toString());
            }
        } finally {
            readLock.unlock();
        }
    }

    public void addLocListener(LocationListenerWrapper locationListenerWrapper) {
        if (locationListenerWrapper != null) {
            Lock writeLock = this.f45856b.writeLock();
            try {
                writeLock.lock();
                if (!this.f45855a.contains(locationListenerWrapper)) {
                    boolean z = false;
                    Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        LocationListenerWrapper next = it.next();
                        if (next.getListener() == locationListenerWrapper.getListener()) {
                            next.setOption(locationListenerWrapper.getOption());
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f45855a.add(locationListenerWrapper);
                    }
                    long a = m32882a(this.f45855a);
                    if (!(this.f45858d == null || a == this.f45858d.mo114489c())) {
                        this.f45858d.mo114482a(a);
                    }
                    this.f45858d.mo114486a((Set<LocationListenerWrapper>) this.f45855a);
                    writeLock.unlock();
                    DLog.m32737d("-LocCenter- loclisteners added, now size is " + this.f45855a.size());
                }
            } finally {
                writeLock.unlock();
            }
        }
    }

    public void removeLocListener(DIDILocationListener dIDILocationListener) {
        Lock writeLock = this.f45856b.writeLock();
        try {
            writeLock.lock();
            Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
            while (it.hasNext()) {
                LocationListenerWrapper next = it.next();
                if (next.getListener() == dIDILocationListener) {
                    this.f45855a.remove(next);
                    if (this.f45855a.size() > 0) {
                        long a = m32882a(this.f45855a);
                        if (!(this.f45858d == null || a == this.f45858d.mo114489c())) {
                            this.f45858d.mo114482a(a);
                        }
                    }
                    this.f45858d.mo114486a((Set<LocationListenerWrapper>) this.f45855a);
                    return;
                }
            }
            writeLock.unlock();
            DLog.m32737d("-LocCenter- loclisteners removed, now size is " + this.f45855a.size());
        } finally {
            writeLock.unlock();
        }
    }

    public void removeAllLocListeners() {
        Lock writeLock = this.f45856b.writeLock();
        try {
            writeLock.lock();
            this.f45855a.clear();
            this.f45858d.mo114486a((Set<LocationListenerWrapper>) this.f45855a);
        } finally {
            writeLock.unlock();
        }
    }

    /* renamed from: a */
    private long m32882a(HashSet<LocationListenerWrapper> hashSet) {
        long value = DIDILocationUpdateOption.IntervalMode.BATTERY_SAVE.getValue();
        Iterator<LocationListenerWrapper> it = hashSet.iterator();
        while (it.hasNext()) {
            LocationListenerWrapper next = it.next();
            if (value > next.getOption().getInterval().getValue()) {
                value = next.getOption().getInterval().getValue();
            }
        }
        return value;
    }

    public int getLocListenersLength() {
        return this.f45855a.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m32902d() {
        Lock readLock = this.f45856b.readLock();
        try {
            readLock.lock();
            boolean z = false;
            if (this.f45855a != null && this.f45855a.size() > 0) {
                Iterator<LocationListenerWrapper> it = this.f45855a.iterator();
                while (it.hasNext()) {
                    if (it.next().getOption().isDirectNotify()) {
                        z = true;
                    }
                }
            }
            return z;
        } finally {
            readLock.unlock();
        }
    }
}
