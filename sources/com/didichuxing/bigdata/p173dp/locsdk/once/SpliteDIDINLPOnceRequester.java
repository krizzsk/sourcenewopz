package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.LocData;
import com.didichuxing.bigdata.p173dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p173dp.locsdk.once.ThreadDispatcher;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.SpliteDIDINLPOnceRequester */
public class SpliteDIDINLPOnceRequester extends DIDINLPRequester {

    /* renamed from: b */
    DIDINLPManager f46110b = null;

    /* renamed from: c */
    boolean f46111c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f46112d = new AtomicBoolean(false);

    public SpliteDIDINLPOnceRequester(Context context) {
        super(context);
        DIDINLPManager dIDINLPManager = new DIDINLPManager(context);
        this.f46110b = dIDINLPManager;
        dIDINLPManager.start();
        if (!ThreadDispatcher.getNetThread().isAlive()) {
            ThreadDispatcher.getNetThread().start();
        }
        if (!ThreadDispatcher.getExtraWorkThread().isAlive()) {
            ThreadDispatcher.getExtraWorkThread().start();
        }
        if (!NetUtils.isInited()) {
            NetUtils.init(context);
        }
    }

    public int request(final DIDILocationListener dIDILocationListener, final DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam) {
        if (!ApolloProxy.getInstance().supportRequestDIDINLPOnce() || dIDILocationListener == null) {
            return -1;
        }
        ThreadDispatcher.IThreadDispatcher iThreadDispatcher = null;
        if (TextUtils.isEmpty(dIDILocationUpdateOnceParam != null ? dIDILocationUpdateOnceParam.getModuleKey() : null)) {
            ThreadDispatcher.getMainThread().post(new Runnable() {
                public void run() {
                    ErrInfo errInfo = new ErrInfo(202);
                    errInfo.setErrMessage(ErrInfo.ERROR_MSG_MODULE_PERMISSION);
                    dIDILocationListener.onLocationError(errInfo.getErrNo(), errInfo);
                    SpliteDIDINLPOnceRequester.this.m33128b();
                }
            });
            return -1;
        }
        final ErrInfo errInfo = new ErrInfo();
        prepareNewRequestData();
        m33126a(dIDILocationUpdateOnceParam.getCallFrom());
        mo114679a(DIDILocationManager.getInstance(getContext()).getRecentLocation(10));
        if (getRequestData().valid_flag == ((long) ValidFlagEnum.invalid.ordinal())) {
            ThreadDispatcher.getMainThread().post(new Runnable() {
                public void run() {
                    errInfo.setErrNo(103);
                    errInfo.setErrMessage(ErrInfo.ERROR_MSG_NO_ELEMENT_FOR_LOCATION);
                    dIDILocationListener.onLocationError(errInfo.getErrNo(), errInfo);
                    SpliteDIDINLPOnceRequester.this.m33128b();
                }
            });
            return 0;
        }
        if (dIDILocationUpdateOnceParam.isNeedExpress()) {
            this.f46111c = true;
            iThreadDispatcher = ThreadDispatcher.getExtraWorkThread();
        }
        if (iThreadDispatcher == null) {
            iThreadDispatcher = ThreadDispatcher.getNetThread();
        }
        iThreadDispatcher.post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (dIDILocationUpdateOnceParam.getTimeOut() > 0) {
                    ThreadDispatcher.getMainThread().postDelayed(new Runnable() {
                        public void run() {
                            if (!SpliteDIDINLPOnceRequester.this.f46112d.get()) {
                                SystemUtils.log(6, "zjloc", "请求自建超时," + SpliteDIDINLPOnceRequester.this.f46111c, (Throwable) null, "com.didichuxing.bigdata.dp.locsdk.once.SpliteDIDINLPOnceRequester$3$1", 111);
                                SpliteDIDINLPOnceRequester.this.f46112d.set(true);
                                errInfo.setErrNo(303);
                                errInfo.setErrMessage("网络请求出现异常。");
                                dIDILocationListener.onLocationError(errInfo.getErrNo(), errInfo);
                                SpliteDIDINLPOnceRequester.this.m33128b();
                            }
                        }
                    }, (long) dIDILocationUpdateOnceParam.getTimeOut());
                }
                LocationServiceResponse requestNetworkLocationWrapper = SpliteDIDINLPOnceRequester.this.requestNetworkLocationWrapper(errInfo, dIDILocationUpdateOnceParam);
                if (!SpliteDIDINLPOnceRequester.this.f46112d.get()) {
                    ArrayList arrayList = new ArrayList();
                    if (!(requestNetworkLocationWrapper == null || requestNetworkLocationWrapper.locations == null || requestNetworkLocationWrapper.locations.size() <= 0)) {
                        for (location_info_t next : requestNetworkLocationWrapper.locations) {
                            LocData locData = r1;
                            ArrayList arrayList2 = arrayList;
                            LocData locData2 = new LocData(next.lon_gcj, next.lat_gcj, (int) next.accuracy, next.confidence, 0, currentTimeMillis, currentTimeMillis, elapsedRealtime, ETraceSource.didi.toString(), requestNetworkLocationWrapper.getCoordinateType());
                            arrayList2.add(locData);
                            arrayList = arrayList2;
                            requestNetworkLocationWrapper = requestNetworkLocationWrapper;
                        }
                    }
                    final ArrayList arrayList3 = arrayList;
                    ThreadDispatcher.getMainThread().post(new Runnable() {
                        public void run() {
                            if (!SpliteDIDINLPOnceRequester.this.f46112d.get()) {
                                SpliteDIDINLPOnceRequester.this.f46112d.set(true);
                                if (arrayList3.size() > 0) {
                                    dIDILocationListener.onLocationChanged(DIDILocation.loadFromLocData(Utils.getMaxConfiLoc(arrayList3), (LocData) null));
                                    SpliteDIDINLPOnceRequester.this.m33128b();
                                    return;
                                }
                                dIDILocationListener.onLocationError(errInfo.getErrNo(), errInfo);
                                SpliteDIDINLPOnceRequester.this.m33128b();
                            }
                        }
                    });
                }
            }
        });
        return 0;
    }

    /* renamed from: a */
    private void m33126a(String str) {
        if (Const.CALL_FROM_SUG_PAGE.equals(str) || Const.CALL_FROM_DEPARTURE_PAGE.equals(str)) {
            SystemUtils.log(6, "zjloc", "callfrom= " + str, (Throwable) null, "com.didichuxing.bigdata.dp.locsdk.once.SpliteDIDINLPOnceRequester", 178);
            getRequestData().call_from = str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.bigdata.p173dp.locsdk.once.LocationServiceResponse requestNetworkLocationWrapper(com.didichuxing.bigdata.p173dp.locsdk.ErrInfo r12, com.didichuxing.bigdata.p173dp.locsdk.once.DIDILocationUpdateOnceParam r13) {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.didichuxing.bigdata.dp.locsdk.once.LocationServiceResponse r2 = super.requestNetworkLocation(r12)
            java.lang.String r3 = ""
            if (r13 == 0) goto L_0x0017
            java.lang.String r4 = r13.getCallFrom()
            java.lang.String r13 = r13.getEntrance()
            r10 = r13
            r9 = r4
            goto L_0x0019
        L_0x0017:
            r9 = r3
            r10 = r9
        L_0x0019:
            if (r2 != 0) goto L_0x0028
            if (r12 == 0) goto L_0x0037
            int r13 = r12.getErrNo()
            java.lang.String r3 = r12.getErrMessage()
        L_0x0025:
            r7 = r13
            r8 = r3
            goto L_0x003a
        L_0x0028:
            int r13 = r2.ret_code
            if (r13 == 0) goto L_0x0037
            if (r12 == 0) goto L_0x0037
            int r13 = r12.getErrNo()
            java.lang.String r3 = r12.getErrMessage()
            goto L_0x0025
        L_0x0037:
            r12 = 0
            r8 = r3
            r7 = 0
        L_0x003a:
            com.didichuxing.bigdata.dp.locsdk.once.util.ApolloProxy r12 = com.didichuxing.bigdata.p173dp.locsdk.once.util.ApolloProxy.getInstance()
            boolean r12 = r12.pickUpPageEventTrackingSwitcher()
            if (r12 == 0) goto L_0x004d
            long r12 = java.lang.System.currentTimeMillis()
            long r5 = r12 - r0
            com.didichuxing.bigdata.p173dp.locsdk.OmegaUtils.trackNLPOnceRespTime(r5, r7, r8, r9, r10)
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.once.SpliteDIDINLPOnceRequester.requestNetworkLocationWrapper(com.didichuxing.bigdata.dp.locsdk.ErrInfo, com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOnceParam):com.didichuxing.bigdata.dp.locsdk.once.LocationServiceResponse");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33128b() {
        DIDINLPManager dIDINLPManager = this.f46110b;
        if (dIDINLPManager != null) {
            dIDINLPManager.stop();
        }
    }
}
