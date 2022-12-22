package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.hawaii.p118ar.DiARNavActivity;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.util.Map;

public class AREntranceManager {

    /* renamed from: a */
    private Context f26834a;
    public Map<String, String> arParams;

    /* renamed from: b */
    private ServingParam f26835b;

    /* renamed from: c */
    private DIDILocation f26836c;

    /* renamed from: d */
    private DiARNavActivity.NotifyStatusSubscriber f26837d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f26838e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f26839f;

    /* renamed from: g */
    private LatLng f26840g;

    /* renamed from: h */
    private boolean f26841h;

    /* renamed from: i */
    private OutdoorArDialog f26842i;

    /* renamed from: j */
    private ARCoreCheckerAndGenerator.CheckCallBack f26843j = new ARCoreCheckerAndGenerator.CheckCallBack() {
        public void onCheckSuccessOrNot(boolean z, int i, String str) {
            long unused = AREntranceManager.this.f26839f = System.currentTimeMillis() - AREntranceManager.this.f26838e;
            AREntranceManager.this.arParams = ARCoreCheckerAndGenerator.getARLogData();
            AREntranceManager.this.m18961a(z, i, str);
        }
    };

    public AREntranceManager(Context context, ServingParam servingParam, boolean z) {
        CommonMarkerParam markerParam;
        LatLng point;
        this.f26834a = context;
        this.f26835b = servingParam;
        this.f26841h = z;
        if (servingParam != null && (markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_START)) != null && (point = markerParam.getPoint()) != null) {
            this.f26840g = new LatLng(point.latitude, point.longitude);
        }
    }

    public void setOutdoor(boolean z) {
        this.f26841h = z;
    }

    public void setCurrentLocation(DIDILocation dIDILocation) {
        this.f26836c = dIDILocation;
    }

    public void showAR() {
        m18958a(this.f26843j);
    }

    public long getLoadTime() {
        return this.f26839f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18961a(boolean z, int i, String str) {
        Context context = this.f26834a;
        if (context != null) {
            if (z) {
                this.f26837d = DiARNavActivity.startARNavActivity(context);
            } else if (this.f26841h) {
                m18957a(i, str);
                ServingParam servingParam = this.f26835b;
                MapFlowOmegaUtil.trackOutArErrorDialogShow((servingParam == null || servingParam.getOrderParams() == null) ? "" : this.f26835b.getOrderParams().orderId, i);
            } else if (this.f26835b.getGuideEntranceCallback() != null) {
                this.f26835b.getGuideEntranceCallback().onShowARErrorDialog(this.f26835b.getOrderParams().stationWalkGuideLink, str);
                MapFlowOmegaUtil.trackArErrorDialogShow(i);
            }
        }
    }

    /* renamed from: a */
    private void m18957a(int i, String str) {
        ServingParam servingParam = this.f26835b;
        if (servingParam != null && servingParam.getContext() != null && (this.f26835b.getContext() instanceof Activity)) {
            Activity activity = (Activity) this.f26835b.getContext();
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                this.f26842i = new OutdoorArDialog(this.f26835b.getContext());
                this.f26842i.setTitle(this.f26834a.getResources().getString(R.string.GRider_new_Sorry_AR_FsvP));
                this.f26842i.setSubTitle(str);
                this.f26842i.setCanceledOnTouchOutside(true);
                SystemUtils.showDialog(this.f26842i);
            }
        }
    }

    /* renamed from: a */
    private void m18958a(ARCoreCheckerAndGenerator.CheckCallBack checkCallBack) {
        float f;
        ServingParam servingParam = this.f26835b;
        if (servingParam == null) {
            return;
        }
        if ((servingParam.getOrderParams() == null || !TextUtils.isEmpty(this.f26835b.getOrderParams().orderId)) && this.f26840g != null) {
            LatLng latLng = null;
            DIDILocation dIDILocation = this.f26836c;
            float f2 = 0.0f;
            if (dIDILocation != null) {
                latLng = new LatLng(dIDILocation.getLatitude(), this.f26836c.getLongitude());
                f2 = (float) this.f26836c.getAltitude();
                f = this.f26836c.getAccuracy();
            } else {
                f = 0.0f;
            }
            ARCoreCheckerAndGenerator.checkAvailabilityWithRequestData(this.f26834a, new ARCoreCheckerAndGenerator.CheckOption.CheckOptionBuilder().setUID(SystemUtil.getIMEI()).setOrderId(this.f26835b.getOrderParams().orderId).setCurAltitude(f2).setCurLocation(latLng).setHorizontalAccuracy(f).setVerticalAccuracy(f).setDestLocation(this.f26840g).build(), checkCallBack);
            this.f26838e = System.currentTimeMillis();
        }
    }

    public void onOrderStateChanged(int i) {
        Context context;
        if (i == 1) {
            String str = null;
            ServingParam servingParam = this.f26835b;
            if (!(servingParam == null || servingParam.getOrderParams() == null || TextUtils.isEmpty(this.f26835b.getOrderParams().licensePlateNumber))) {
                str = this.f26835b.getOrderParams().licensePlateNumber;
            }
            if (!TextUtils.isEmpty(str) && (context = this.f26834a) != null) {
                m18960a(context.getResources().getString(R.string.GRider_guide_The_driver_fAJr, new Object[]{str}));
            }
        } else if (i == 2) {
            m18962b();
        } else if (i == 3) {
            m18956a();
        } else if (i == 4) {
            m18963c();
        }
    }

    public void updateStartPosition(LatLng latLng) {
        this.f26840g = latLng;
    }

    /* renamed from: a */
    private void m18956a() {
        SystemUtils.log(3, "ARXXX", " order cancel ", (Throwable) null, "com.didi.map.global.flow.scene.order.serving.components.guideentrance.AREntranceManager", 215);
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f26837d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onStatusChange(1);
        }
    }

    /* renamed from: a */
    private void m18960a(String str) {
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f26837d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onDriverArrived(str);
        }
    }

    /* renamed from: b */
    private void m18962b() {
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f26837d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onStatusChange(2);
        }
    }

    /* renamed from: c */
    private void m18963c() {
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f26837d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onStatusChange(3);
        }
    }

    public void destroy() {
        this.f26837d = null;
        this.f26835b = null;
        this.f26834a = null;
    }
}
