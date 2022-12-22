package com.didi.map.global.flow.scene.order.serving.param;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.order.serving.IEventCallback;
import com.didi.map.global.flow.scene.order.serving.IGuideEntranceCallback;
import com.didi.map.global.flow.scene.order.serving.IOraOrderStageCallback;
import com.didi.map.global.flow.scene.order.serving.IPassBTMStatusCallback;
import com.didi.map.global.flow.scene.order.serving.IPassPointStatusCallback;
import com.didi.map.global.flow.scene.order.serving.ISctxStateCallback;
import com.didi.map.global.flow.scene.order.serving.ISecRouteInfoCallback;
import com.didi.map.global.flow.scene.order.serving.scene.IOdPointsExpiredCallback;
import com.didi.map.global.flow.scene.order.serving.scene.ITripStateCallback;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import java.util.HashMap;
import java.util.List;

public class ServingParam extends PageSceneParam {

    /* renamed from: a */
    private Builder f26907a;

    /* renamed from: b */
    private HashMap<MapElementId, CommonMarkerParam> f26908b;

    /* renamed from: c */
    private boolean f26909c;

    /* renamed from: d */
    private ICarBitmapDescriptor f26910d;

    /* renamed from: e */
    private List<String> f26911e;

    /* renamed from: f */
    private OrderParams f26912f;

    /* renamed from: g */
    private ClientParams f26913g;

    /* renamed from: h */
    private boolean f26914h = false;

    /* renamed from: i */
    private boolean f26915i;

    /* renamed from: j */
    private IGuideEntranceCallback f26916j;

    /* renamed from: k */
    private IEtaEdaCallback f26917k;

    /* renamed from: l */
    private ISctxStateCallback f26918l;

    /* renamed from: m */
    private IOraOrderStageCallback f26919m;

    /* renamed from: n */
    private ISecRouteInfoCallback f26920n;

    /* renamed from: o */
    private IEventCallback f26921o;

    /* renamed from: p */
    private IOdPointsExpiredCallback f26922p;

    /* renamed from: q */
    private IPassPointStatusCallback f26923q;

    /* renamed from: r */
    private IPassBTMStatusCallback f26924r;

    /* renamed from: s */
    private ITripStateCallback f26925s;

    public Builder getBuilder() {
        return this.f26907a;
    }

    public OrderParams getOrderParams() {
        return this.f26912f;
    }

    public void setOrderParams(OrderParams orderParams) {
        this.f26912f = orderParams;
    }

    public HashMap<MapElementId, CommonMarkerParam> getMarkerParams() {
        return this.f26908b;
    }

    public CommonMarkerParam getMarkerParam(MapElementId mapElementId) {
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26908b;
        if (hashMap == null || !hashMap.containsKey(mapElementId)) {
            return null;
        }
        return this.f26908b.get(mapElementId);
    }

    public boolean isNewVersion() {
        return this.f26909c;
    }

    public List<String> getCar3DIcons() {
        return this.f26911e;
    }

    public boolean bReadOnly() {
        return this.f26914h;
    }

    public boolean showGuideEntrance() {
        return this.f26915i;
    }

    public ICarBitmapDescriptor getCarBitmapDescriptor() {
        return this.f26910d;
    }

    public ClientParams getClientParams() {
        return this.f26913g;
    }

    public IGuideEntranceCallback getGuideEntranceCallback() {
        return this.f26916j;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f26917k;
    }

    public ISctxStateCallback getSctxStateCallback() {
        return this.f26918l;
    }

    public IOraOrderStageCallback getOraOrderStageCallback() {
        return this.f26919m;
    }

    public ISecRouteInfoCallback getSecRouteInfoCallback() {
        return this.f26920n;
    }

    public IEventCallback getEventCallback() {
        return this.f26921o;
    }

    public IOdPointsExpiredCallback getOdPointsExpiredCallback() {
        return this.f26922p;
    }

    public IPassPointStatusCallback getPassPointStatusCallback() {
        return this.f26923q;
    }

    public IPassBTMStatusCallback getPassBTMStatusCallback() {
        return this.f26924r;
    }

    public ITripStateCallback getTripStateCallback() {
        return this.f26925s;
    }

    public ServingParam(Builder builder) {
        super(builder);
        m18991a(builder);
    }

    public void reset(Builder builder) {
        super.reset(builder);
        m18991a(builder);
    }

    /* renamed from: a */
    private void m18991a(Builder builder) {
        this.f26907a = builder;
        this.f26909c = builder.isNewVersion;
        this.f26908b = builder.markerParams;
        this.f26911e = builder.car3DIcons;
        this.f26910d = builder.carBitmapDescriptor;
        this.f26912f = builder.orderParams;
        this.f26913g = builder.clientParams;
        this.f26914h = builder.bReadOnly;
        this.f26915i = builder.showGuideEntrance;
        this.f26916j = builder.guideEntranceCallback;
        this.f26917k = builder.etaEdaCallback;
        this.f26918l = builder.sctxStateCallback;
        this.f26919m = builder.oraOrderStageCallback;
        this.f26920n = builder.secRouteInfoCallback;
        this.f26921o = builder.eventCallback;
        this.f26922p = builder.odPointsExpiredCallback;
        this.f26923q = builder.passPointStatusCallback;
        this.f26924r = builder.passBTMStatusCallback;
        this.f26925s = builder.tripStateCallback;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public boolean bReadOnly;
        /* access modifiers changed from: private */
        public List<String> car3DIcons;
        /* access modifiers changed from: private */
        public ICarBitmapDescriptor carBitmapDescriptor;
        /* access modifiers changed from: private */
        public ClientParams clientParams;
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public IEventCallback eventCallback;
        /* access modifiers changed from: private */
        public IGuideEntranceCallback guideEntranceCallback;
        /* access modifiers changed from: private */
        public boolean isNewVersion;
        /* access modifiers changed from: private */
        public HashMap<MapElementId, CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public IOdPointsExpiredCallback odPointsExpiredCallback;
        /* access modifiers changed from: private */
        public IOraOrderStageCallback oraOrderStageCallback;
        /* access modifiers changed from: private */
        public OrderParams orderParams;
        /* access modifiers changed from: private */
        public IPassBTMStatusCallback passBTMStatusCallback;
        /* access modifiers changed from: private */
        public IPassPointStatusCallback passPointStatusCallback;
        /* access modifiers changed from: private */
        public ISctxStateCallback sctxStateCallback;
        /* access modifiers changed from: private */
        public ISecRouteInfoCallback secRouteInfoCallback;
        public boolean showGuideEntrance;
        /* access modifiers changed from: private */
        public ITripStateCallback tripStateCallback;

        public Builder context(Context context) {
            super.context(context);
            return this;
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            super.mapChangeListener(iMapChangeListener);
            return this;
        }

        public Builder isNewVersion(boolean z) {
            this.isNewVersion = z;
            return this;
        }

        public Builder markerParams(HashMap<MapElementId, CommonMarkerParam> hashMap) {
            this.markerParams = hashMap;
            return this;
        }

        public Builder carBitmapDescriptor(ICarBitmapDescriptor iCarBitmapDescriptor) {
            this.carBitmapDescriptor = iCarBitmapDescriptor;
            return this;
        }

        public Builder orderParams(OrderParams orderParams2) {
            this.orderParams = orderParams2;
            return this;
        }

        public Builder clientParams(ClientParams clientParams2) {
            this.clientParams = clientParams2;
            return this;
        }

        public Builder car3DIcons(List<String> list) {
            this.car3DIcons = list;
            return this;
        }

        public Builder bReadOnly(boolean z) {
            this.bReadOnly = z;
            return this;
        }

        public Builder showGuideEntrance(boolean z) {
            this.showGuideEntrance = z;
            return this;
        }

        public Builder guideEntranceCallback(IGuideEntranceCallback iGuideEntranceCallback) {
            this.guideEntranceCallback = iGuideEntranceCallback;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public Builder sctxStateCallback(ISctxStateCallback iSctxStateCallback) {
            this.sctxStateCallback = iSctxStateCallback;
            return this;
        }

        public Builder oraOrderStageCallback(IOraOrderStageCallback iOraOrderStageCallback) {
            this.oraOrderStageCallback = iOraOrderStageCallback;
            return this;
        }

        public Builder secRouteInfoCallback(ISecRouteInfoCallback iSecRouteInfoCallback) {
            this.secRouteInfoCallback = iSecRouteInfoCallback;
            return this;
        }

        public Builder eventCallback(IEventCallback iEventCallback) {
            this.eventCallback = iEventCallback;
            return this;
        }

        public Builder odPointsExpiredCallback(IOdPointsExpiredCallback iOdPointsExpiredCallback) {
            this.odPointsExpiredCallback = iOdPointsExpiredCallback;
            return this;
        }

        public Builder passPointStatusCallback(IPassPointStatusCallback iPassPointStatusCallback) {
            this.passPointStatusCallback = iPassPointStatusCallback;
            return this;
        }

        public Builder passBTMStatusCallback(IPassBTMStatusCallback iPassBTMStatusCallback) {
            this.passBTMStatusCallback = iPassBTMStatusCallback;
            return this;
        }

        public Builder tripStateCallback(ITripStateCallback iTripStateCallback) {
            this.tripStateCallback = iTripStateCallback;
            return this;
        }
    }

    public void dump() {
        Object[] objArr = new Object[2];
        ClientParams clientParams = this.f26913g;
        String str = "";
        objArr[0] = clientParams == null ? str : clientParams.clientVersion;
        ClientParams clientParams2 = this.f26913g;
        if (clientParams2 != null) {
            str = clientParams2.imei;
        }
        objArr[1] = str;
        DLog.m7384d("ServingParam", "[ServingParam] start:%s, end:%s, padding:%s, clientVersion:%s, imei:%s", objArr);
    }
}
