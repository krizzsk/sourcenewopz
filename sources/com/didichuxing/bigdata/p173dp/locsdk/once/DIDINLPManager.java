package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.LocData;
import com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p173dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p173dp.locsdk.once.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.ApolloProxy;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPManager */
public class DIDINLPManager {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final int f46075j = NetworkLocTask.class.hashCode();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f46076a;

    /* renamed from: b */
    private boolean f46077b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDINetworkLocateProxy f46078c;

    /* renamed from: d */
    private WifiManagerWrapper f46079d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f46080e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile DIDILocation f46081f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile long f46082g = 0;

    /* renamed from: h */
    private CellManager f46083h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LocData f46084i = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile long f46085k = DIDILocationUpdateOption.IntervalMode.NORMAL.getValue();

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPManager$DIDINLPLocationCallback */
    interface DIDINLPLocationCallback {
        void onDIDINLPLocationFail(ErrInfo errInfo);

        void onDIDINLPLocationSucc(DIDILocation dIDILocation);
    }

    public DIDINLPManager(Context context) {
        this.f46076a = context;
        this.f46078c = new DIDINetworkLocateProxy(context);
    }

    public synchronized void start() {
        if (!this.f46077b) {
            m33094b();
            m33103f();
            this.f46078c.cleanHistory(false);
            m33093a(true);
        }
    }

    public synchronized void stop() {
        if (this.f46077b) {
            m33099d();
            m33097c();
            m33093a(false);
        }
    }

    /* renamed from: b */
    private void m33094b() {
        if (this.f46083h == null) {
            CellManager instance = CellManager.getInstance();
            this.f46083h = instance;
            instance.init(this.f46076a);
            this.f46083h.getCellLocation();
        }
    }

    /* renamed from: c */
    private void m33097c() {
        WifiManagerWrapper wifiManagerWrapper = this.f46079d;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.destroy();
            this.f46079d = null;
        }
    }

    /* renamed from: d */
    private void m33099d() {
        CellManager cellManager = this.f46083h;
        if (cellManager != null) {
            cellManager.destroy();
            this.f46083h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized boolean m33101e() {
        return this.f46077b;
    }

    /* renamed from: a */
    private synchronized void m33093a(boolean z) {
        this.f46077b = z;
    }

    public void updateNlpLocation(final DIDILocation dIDILocation) {
        if (this.f46078c != null) {
            ThreadDispatcher.getNetThread().post(new Runnable() {
                public void run() {
                    if (DIDINLPManager.this.f46078c != null) {
                        DIDINLPManager.this.f46078c.setNlpLoc(dIDILocation);
                    }
                }
            });
        }
    }

    public void setLastLoc4Filter(final DIDILocation dIDILocation) {
        if (ThreadDispatcher.getWorkThread().isAlive() && dIDILocation != null) {
            ThreadDispatcher.getWorkThread().post(new Runnable() {
                public void run() {
                    if (DIDINLPManager.this.m33101e()) {
                        DIDINLPManager.this.mo114662a(dIDILocation);
                        ThreadDispatcher.getNetThread().post(new Runnable() {
                            public void run() {
                                if (DIDINLPManager.this.f46078c != null) {
                                    if (TextUtils.equals("gps", dIDILocation.getProvider())) {
                                        DIDINLPManager.this.f46078c.cleanHistoryWithGps(dIDILocation);
                                        DLog.m32737d("loop:gps valid->lastLocData.");
                                        return;
                                    }
                                    DIDINLPManager.this.f46078c.setLastLoc(dIDILocation);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114663a(DIDINLPLocationCallback dIDINLPLocationCallback) {
        if (ThreadDispatcher.getNetThread().isAlive() && dIDINLPLocationCallback != null) {
            ThreadDispatcher.getNetThread().postDelayed(f46075j, new NetworkLocTask(dIDINLPLocationCallback), 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114661a(long j) {
        this.f46085k = j;
        WifiManagerWrapper wifiManagerWrapper = this.f46079d;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.updateWifiScanInterval(j);
        }
    }

    /* renamed from: f */
    private void m33103f() {
        if (this.f46076a != null) {
            WifiManagerWrapper instance = WifiManagerWrapper.getInstance();
            this.f46079d = instance;
            instance.init(this.f46076a);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPManager$NetworkLocTask */
    private class NetworkLocTask implements Runnable {
        /* access modifiers changed from: private */
        public DIDINLPLocationCallback mCallback;

        NetworkLocTask(DIDINLPLocationCallback dIDINLPLocationCallback) {
            this.mCallback = dIDINLPLocationCallback;
        }

        public void run() {
            if (DIDINLPManager.this.m33101e()) {
                ErrInfo errInfo = new ErrInfo();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < DIDINLPManager.this.f46080e || (elapsedRealtime - DIDINLPManager.this.f46080e) + DIDINLPManager.this.f46085k > 8000 || DIDINLPManager.this.f46084i == null) {
                    Handler handler = ThreadDispatcher.getNetThread().getHandler();
                    if (handler == null || !handler.hasMessages(DIDINLPManager.f46075j) || !ApolloProxy.getInstance().isDidiNlpRequestQueueOptmEnabled()) {
                        long unused = DIDINLPManager.this.f46080e = elapsedRealtime;
                        DIDINLPRequester dIDINLPRequester = new DIDINLPRequester(DIDINLPManager.this.f46076a);
                        if (DIDINLPManager.this.f46081f != null && DIDINLPManager.this.f46082g > 0) {
                            dIDINLPRequester.updatePreLocationInfo(DIDINLPManager.this.f46081f, DIDINLPManager.this.f46082g);
                        }
                        dIDINLPRequester.prepareNewRequestData();
                        errInfo.setSource("didi");
                        LocData manage = DIDINLPManager.this.f46078c.manage(dIDINLPRequester, errInfo);
                        if (manage != null) {
                            LocNTPHelper.adjustDIDINLPTimestamp(manage);
                            DIDILocation loadFromLocData = DIDILocation.loadFromLocData(manage, (LocData) null);
                            if ("gps".equals(loadFromLocData.getProvider())) {
                                DLog.m32737d(String.format("loop[network]:use last gps locData: %s", new Object[]{String.valueOf(loadFromLocData)}));
                            }
                            notifyLocationSucc(loadFromLocData);
                        } else {
                            notifyLocationFail(DIDINLPManager.this.m33089a(errInfo, dIDINLPRequester.getRequestData()));
                        }
                        LocData unused2 = DIDINLPManager.this.f46084i = manage;
                        return;
                    }
                    DLog.m32737d("requestQueueOptmEnabled notifyLocationFail");
                    errInfo.setErrNo(306);
                    errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_QUEUE_FULL);
                    notifyLocationFail(errInfo);
                    return;
                }
                DIDILocation loadFromLocData2 = DIDILocation.loadFromLocData(DIDINLPManager.this.f46084i, (LocData) null);
                if (loadFromLocData2 != null && "gps".equals(loadFromLocData2.getProvider())) {
                    DLog.m32737d(String.format("loop[last:%s][now:%s][cache:%s]", new Object[]{Long.valueOf(DIDINLPManager.this.f46080e), Long.valueOf(elapsedRealtime), String.valueOf(loadFromLocData2)}));
                }
                notifyLocationSucc(loadFromLocData2);
            }
        }

        private synchronized void notifyLocationSucc(final DIDILocation dIDILocation) {
            if (this.mCallback != null) {
                ThreadDispatcher.getWorkThread().post(new Runnable() {
                    public void run() {
                        NetworkLocTask.this.mCallback.onDIDINLPLocationSucc(dIDILocation);
                        DIDINLPLocationCallback unused = NetworkLocTask.this.mCallback = null;
                    }
                });
            }
        }

        private synchronized void notifyLocationFail(final ErrInfo errInfo) {
            if (this.mCallback != null) {
                ThreadDispatcher.getWorkThread().post(new Runnable() {
                    public void run() {
                        NetworkLocTask.this.mCallback.onDIDINLPLocationFail(errInfo);
                        DIDINLPLocationCallback unused = NetworkLocTask.this.mCallback = null;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ErrInfo m33089a(ErrInfo errInfo, LocationServiceRequest locationServiceRequest) {
        if (errInfo == null) {
            return null;
        }
        if (!Utils.isLocationPermissionGranted(this.f46076a) || !SensorMonitor.getInstance(this.f46076a).isGpsEnabled()) {
            errInfo.setErrNo(101);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_LOCATION_PERMISSION);
        } else if (locationServiceRequest != null && locationServiceRequest.wifis.size() == 0 && locationServiceRequest.cell.cellid_bsid == 0 && locationServiceRequest.cell.neighcells.size() == 0) {
            errInfo.setErrNo(103);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_NO_ELEMENT_FOR_LOCATION);
        } else if (!NetUtils.isNetWorkConnected(this.f46076a)) {
            errInfo.setErrNo(301);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_NETWORK_CONNECTION);
        } else if (errInfo.getErrNo() == 0) {
            errInfo.setErrNo(1000);
            errInfo.setErrMessage("其他原因引起的定位失败。");
        }
        return errInfo;
    }

    public void cleanLastLocCache() {
        this.f46084i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114662a(DIDILocation dIDILocation) {
        if (TextUtils.equals("gps", dIDILocation.getProvider())) {
            this.f46081f = dIDILocation;
            this.f46082g = dIDILocation.getLocalTime() / 1000;
        }
    }
}
