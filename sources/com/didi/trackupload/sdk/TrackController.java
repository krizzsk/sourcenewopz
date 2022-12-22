package com.didi.trackupload.sdk;

import android.content.Context;
import android.os.SystemClock;
import com.didi.mapbizinterface.common.AppStateMonitor;
import com.didi.mapbizinterface.track.MapTrackExtraDataProvider;
import com.didi.trackupload.sdk.core.CleanUpController;
import com.didi.trackupload.sdk.core.CoreThread;
import com.didi.trackupload.sdk.core.CrashRecoveryController;
import com.didi.trackupload.sdk.core.GatherController;
import com.didi.trackupload.sdk.core.NetworkConnectMonitor;
import com.didi.trackupload.sdk.core.UploadController;
import com.didi.trackupload.sdk.datachannel.DataChannel;
import com.didi.trackupload.sdk.datachannel.IDataChannel;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TrackController implements AppStateMonitor.OnAppStateChangedListener {

    /* renamed from: a */
    private static final String f36982a = "TrackController";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f36983b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GatherController f36984c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public UploadController f36985d;

    /* renamed from: e */
    private TrackInitParams f36986e;

    /* renamed from: f */
    private Map<String, TrackClient> f36987f;

    /* renamed from: g */
    private boolean f36988g;

    private TrackController() {
        this.f36984c = new GatherController();
        this.f36985d = new UploadController();
        this.f36986e = new TrackInitParams((IDataChannel) null, (ICommonInfoDelegate) null, false, (File) null);
        this.f36987f = new HashMap();
        this.f36988g = false;
    }

    private static class SingletonHolder {
        static final TrackController INSTANCE = new TrackController();

        private SingletonHolder() {
        }
    }

    public static TrackController getIntance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo95129a(Context context, TrackInitParams trackInitParams) {
        if (m26196f() == 0) {
            this.f36983b = context.getApplicationContext();
            this.f36986e = trackInitParams;
        }
    }

    public synchronized TrackInitParams getInitParams() {
        return this.f36986e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo95125a() {
        int f = m26196f();
        if (f != 0) {
            return f;
        }
        int g = m26198g();
        if (g != 0) {
            return g;
        }
        CoreThread.create();
        CoreThread.post(new Runnable() {
            public void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TrackLog.m31343d(TrackController.f36982a, "initService first runnable begin");
                MapTrackExtraDataProvider.getInstance().init(TrackController.this.f36983b);
                LocationCenter.getIntance().init(TrackController.this.f36983b);
                TrackDataStorage.getInstance().init(TrackController.this.f36983b);
                DataChannel.getIntance().init(TrackController.this.f36983b);
                CleanUpController.getIntance().cleanUpBizNodes();
                NetworkConnectMonitor.getInstance().init(TrackController.this.f36983b);
                CrashRecoveryController.getInstance().init();
                AppStateMonitor.getInstance().addOnAppStateChangedListener(TrackController.this);
                TrackLog.m31343d(TrackController.f36982a, "initService first runnable done timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            }
        });
        this.f36988g = true;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized int mo95130b() {
        int e = m26193e();
        if (e != 0) {
            return e;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26190c() {
        TrackLog.m31343d(f36982a, "onServiceStart");
        NetworkConnectMonitor.getInstance().start();
        HeartBeatTask.getInstance().start();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m26192d() {
        TrackLog.m31343d(f36982a, "onServiceStop");
        NetworkConnectMonitor.getInstance().stop();
        HeartBeatTask.getInstance().stop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized TrackClient mo95128a(TrackClientType trackClientType, String str) {
        return new TrackClient(trackClientType, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo95126a(TrackClient trackClient) {
        int e = m26193e();
        if (e != 0) {
            return e;
        }
        int e2 = m26194e(trackClient);
        if (e2 != 0) {
            return e2;
        }
        int g = m26199g(trackClient);
        if (g != 0) {
            return g;
        }
        if (this.f36987f.size() == 0) {
            CoreThread.post(new Runnable() {
                public void run() {
                    TrackController.this.m26190c();
                }
            });
        }
        final TrackClient a = trackClient.mo95109a();
        this.f36987f.put(a.getTrackTag(), a);
        TrackLog.m31343d(f36982a, "startTrackClient client=" + trackClient.toSimpleString() + " activeClientSize=" + this.f36987f.size());
        CoreThread.post(new Runnable() {
            public void run() {
                TrackController.this.f36984c.addClient(a);
                TrackController.this.f36985d.addClient(a);
            }
        });
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized int mo95131b(TrackClient trackClient) {
        int e = m26193e();
        if (e != 0) {
            return e;
        }
        int f = m26197f(trackClient);
        if (f != 0) {
            return f;
        }
        final TrackClient a = trackClient.mo95109a();
        this.f36987f.remove(a.getTrackTag());
        TrackLog.m31343d(f36982a, "stopTrackClient client=" + trackClient.toSimpleString() + " activeClientSize=" + this.f36987f.size());
        this.f36985d.removeClient(a);
        CoreThread.post(new Runnable() {
            public void run() {
                TrackController.this.f36984c.removeClient(a);
            }
        });
        if (this.f36987f.size() == 0) {
            CoreThread.post(new Runnable() {
                public void run() {
                    TrackController.this.m26192d();
                }
            });
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized int mo95132c(TrackClient trackClient) {
        int e = m26193e();
        if (e != 0) {
            return e;
        }
        if (m26197f(trackClient) == 0) {
            int e2 = m26194e(trackClient);
            if (e2 != 0) {
                return e2;
            }
            final TrackClient a = trackClient.mo95109a();
            this.f36987f.put(a.getTrackTag(), a);
            TrackLog.m31343d(f36982a, "updateTrackClient client=" + trackClient.toSimpleString() + " activeClientSize=" + this.f36987f.size());
            CoreThread.post(new Runnable() {
                public void run() {
                    TrackController.this.f36984c.updateClient(a);
                    TrackController.this.f36985d.updateClient(a);
                }
            });
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized boolean mo95133d(TrackClient trackClient) {
        return m26197f(trackClient) == 0;
    }

    public synchronized int getRunningClientSize() {
        return this.f36987f.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo95127a(final TrackOnceClient trackOnceClient) {
        int e = m26193e();
        if (e != 0) {
            return e;
        }
        int b = m26187b(trackOnceClient);
        if (b != 0) {
            return b;
        }
        TrackLog.m31343d(f36982a, "startTrackOnceClient client=" + trackOnceClient.toSimpleString());
        CoreThread.post(new Runnable() {
            public void run() {
                TrackController.this.f36985d.startOnceClient(trackOnceClient);
            }
        });
        return 0;
    }

    /* renamed from: e */
    private int m26193e() {
        return this.f36988g ? 0 : 101;
    }

    /* renamed from: f */
    private int m26196f() {
        return !this.f36988g ? 0 : 102;
    }

    /* renamed from: g */
    private int m26198g() {
        if (this.f36983b == null) {
            return 104;
        }
        if (getInitParams().getDataChannel() == null) {
            return 105;
        }
        return getInitParams().getCommonInfoDelegate() == null ? 106 : 0;
    }

    /* renamed from: e */
    private int m26194e(TrackClient trackClient) {
        if (trackClient.getClientType() == null) {
            return 204;
        }
        if (trackClient.getTrackId() == null) {
            return 205;
        }
        if (trackClient.getTrackOptions() == null || !trackClient.getTrackOptions().checkVaild()) {
            return 206;
        }
        return trackClient.getTrackDataDelegate() == null ? 207 : 0;
    }

    /* renamed from: b */
    private int m26187b(TrackOnceClient trackOnceClient) {
        if (trackOnceClient.getClientType() == null) {
            return 204;
        }
        if (trackOnceClient.mo95162b() == null) {
            return 205;
        }
        return trackOnceClient.getTrackDataDelegate() == null ? 207 : 0;
    }

    /* renamed from: f */
    private int m26197f(TrackClient trackClient) {
        return this.f36987f.get(trackClient.getTrackTag()) != null ? 0 : 203;
    }

    /* renamed from: g */
    private int m26199g(TrackClient trackClient) {
        return this.f36987f.get(trackClient.getTrackTag()) == null ? 0 : 202;
    }

    public void onAppStateChanged(AppStateMonitor.AppState appState, String str) {
        TrackLog.m31343d(f36982a, "onAppStateChanged state=" + appState + " page=" + str);
    }

    private static class HeartBeatTask implements Runnable {
        private static final long INTERVAL_MILLIS = 60000;

        private HeartBeatTask() {
        }

        private static class SingletonHolder {
            /* access modifiers changed from: private */
            public static final HeartBeatTask INSTANCE = new HeartBeatTask();

            private SingletonHolder() {
            }
        }

        static HeartBeatTask getInstance() {
            return SingletonHolder.INSTANCE;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            TrackLog.m31343d("TrackHeartBeat", "start");
            CoreThread.post(this);
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            TrackLog.m31343d("TrackHeartBeat", "stop");
            CoreThread.cancel(this);
        }

        public void run() {
            TrackLog.m31343d("TrackHeartBeat", "onHeartBeat");
            CoreThread.postDelayed(this, 60000);
        }
    }
}
