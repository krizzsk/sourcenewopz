package com.didi.map.global.component.dropoff.core;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.dropoff.DropOffCompParam;
import com.didi.map.global.component.dropoff.core.DropOffContract;
import com.didi.map.global.component.dropoff.data.DropOffDataTask;
import com.didi.map.global.component.dropoff.data.DropOffDataTaskParam;
import com.didi.map.global.component.dropoff.data.IDropOffDataTask;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffAddressExtendInfo;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.DropOffAddressUtils;
import com.didi.map.global.component.dropoff.util.DropOffOmegaTracker;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DropOffPresenter implements DropOffContract.Presenter, IDropOffDataTask.TaskCallback {

    /* renamed from: a */
    private Context f25465a;

    /* renamed from: b */
    private Map f25466b;

    /* renamed from: c */
    private DropOffContract.View f25467c;

    /* renamed from: d */
    private DropOffCompParam f25468d;

    /* renamed from: e */
    private IDropOffDataTask f25469e;

    /* renamed from: f */
    private int f25470f;

    /* renamed from: g */
    private DropOffDataTaskParam f25471g;

    /* renamed from: h */
    private DropOffLocationInfo f25472h;

    /* renamed from: i */
    private DestPoiReverseInfo f25473i;

    /* renamed from: j */
    private List<RpcPoi> f25474j;

    /* renamed from: k */
    private RpcPoi f25475k;

    /* renamed from: l */
    private DropOffAddress f25476l;

    /* renamed from: m */
    private boolean f25477m = true;

    /* renamed from: n */
    private int f25478n;

    /* renamed from: o */
    private final int f25479o = 1;

    public DropOffPresenter(DropOffContract.View view, DropOffCompParam dropOffCompParam) {
        this.f25467c = view;
        this.f25468d = dropOffCompParam;
        DropOffLocationInfo locationInfo = dropOffCompParam.getLocationInfo();
        this.f25472h = locationInfo;
        if (locationInfo.sugPoi != null) {
            this.f25478n = this.f25472h.sugPoi.operationType;
        }
    }

    public void setContext(Context context, Map map) {
        this.f25465a = context;
        this.f25466b = map;
    }

    public void getDiscountData() {
        DropOffAddress dropOffAddress = new DropOffAddress();
        dropOffAddress.setAddress(this.f25472h.sugPoi);
        if (this.f25472h.extendInfo != null) {
            DropOffAddressExtendInfo dropOffAddressExtendInfo = new DropOffAddressExtendInfo();
            dropOffAddressExtendInfo.setBubbleText(this.f25472h.extendInfo.title_tip);
            dropOffAddressExtendInfo.setMainTitle(this.f25472h.extendInfo.mainTitleDesc);
            dropOffAddressExtendInfo.setSubTitle(this.f25472h.extendInfo.subTitleDesc);
            dropOffAddress.setExtendInfo(dropOffAddressExtendInfo);
        }
        this.f25476l = dropOffAddress;
        this.f25467c.showCardView(dropOffAddress);
        this.f25467c.refreshPinView(this.f25476l);
        this.f25467c.onAddressFetchResult(true, this.f25476l);
    }

    public void startDataTask(DropOffLocationInfo dropOffLocationInfo, boolean z) {
        int i;
        m18205b();
        this.f25472h = dropOffLocationInfo;
        if (z) {
            i = 1;
        } else {
            i = this.f25478n;
        }
        this.f25478n = i;
        int i2 = this.f25470f + 1;
        this.f25470f = i2;
        DropOffDataTaskParam build = new DropOffDataTaskParam.Builder(i2, this).mapType(m18203a()).userOperationType(String.valueOf(this.f25478n)).locationInfo(dropOffLocationInfo).reqCallerId(this.f25468d.getReqCallerId()).build();
        this.f25471g = build;
        DropOffDataTask dropOffDataTask = new DropOffDataTask(this.f25465a, build);
        this.f25469e = dropOffDataTask;
        dropOffDataTask.start();
    }

    public RpcPoi getAdsorptionPoi() {
        return this.f25475k;
    }

    public List<RpcPoi> getReconmmendRpcPois() {
        return this.f25474j;
    }

    /* renamed from: a */
    private String m18203a() {
        Map map = this.f25466b;
        return (map == null || map.getMapVendor() == null) ? "gmap" : this.f25466b.getMapVendor().toString();
    }

    /* renamed from: b */
    private void m18205b() {
        IDropOffDataTask iDropOffDataTask = this.f25469e;
        if (iDropOffDataTask != null) {
            iDropOffDataTask.stop();
        }
    }

    public void onDataStart() {
        DropOffContract.View view;
        if (this.f25470f == this.f25469e.getId() && (view = this.f25467c) != null) {
            view.onDataLoading();
        }
    }

    public void onDataFailed() {
        if (this.f25470f == this.f25469e.getId() && this.f25467c != null) {
            this.f25475k = null;
            this.f25474j = null;
            if (this.f25476l == null) {
                DropOffAddress dropOffAddress = new DropOffAddress();
                dropOffAddress.setAddress(this.f25472h.sugPoi);
                this.f25476l = dropOffAddress;
                DropOffUtils.LOGD(" first request failed ");
            } else {
                DropOffAddress dropOffAddress2 = new DropOffAddress();
                Address clone = this.f25476l.getAddress().clone();
                LatLng mapCenterPoint = DropOffUtils.getMapCenterPoint(this.f25466b);
                clone.latitude = mapCenterPoint.latitude;
                clone.longitude = mapCenterPoint.longitude;
                clone.displayName = this.f25465a.getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                dropOffAddress2.setAddress(clone);
                this.f25476l = dropOffAddress2;
                DropOffUtils.LOGD(" map drag request failed ");
            }
            this.f25467c.showCardView(this.f25476l);
            this.f25467c.refreshPinView(this.f25476l);
            this.f25467c.onAddressFetchResult(false, this.f25476l);
        }
    }

    public void onDataSuccess(DestPoiReverseInfo destPoiReverseInfo) {
        if (this.f25470f == this.f25469e.getId() && this.f25467c != null) {
            m18204a(destPoiReverseInfo);
        }
    }

    /* renamed from: a */
    private void m18204a(DestPoiReverseInfo destPoiReverseInfo) {
        if (destPoiReverseInfo == null) {
            onDataFailed();
            return;
        }
        DropOffUtils.LOGD(" request successful ");
        this.f25473i = destPoiReverseInfo;
        ArrayList<RpcPoi> arrayList = destPoiReverseInfo.recEndPoints;
        this.f25474j = arrayList;
        this.f25475k = DropOffAddressUtils.findRecAbsorbPoi(arrayList);
        DropOffUtils.LOGD(" adsorption poi = " + this.f25475k);
        RecPoint recPoint = null;
        RpcPoi rpcPoi = this.f25475k;
        if (rpcPoi != null) {
            recPoint = DropOffAddressUtils.getRecPointList(Arrays.asList(new RpcPoi[]{rpcPoi})).get(0);
        }
        this.f25467c.showReconmmnedMarkers(DropOffAddressUtils.getRecPointList(this.f25474j), recPoint);
        DropOffAddress a = m18202a(this.f25475k);
        this.f25476l = a;
        if (a != null) {
            this.f25467c.showCardView(a);
        }
        this.f25467c.refreshPinView(this.f25476l);
        this.f25467c.onAddressFetchResult(true, this.f25476l);
        if (this.f25477m) {
            DropOffOmegaTracker.trackPageShow(this.f25472h, this.f25474j, this.f25475k, this.f25478n, this.f25473i.searchId);
            this.f25477m = false;
        }
    }

    /* renamed from: a */
    private DropOffAddress m18202a(RpcPoi rpcPoi) {
        int i = 0;
        boolean z = rpcPoi != null;
        if (this.f25473i != null && (rpcPoi == null || !LatLngUtils.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng))) {
            ArrayList<RpcPoi> arrayList = this.f25473i.result;
            if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                rpcPoi = arrayList.get(0);
                z = false;
            }
        }
        if (rpcPoi == null) {
            return null;
        }
        if (this.f25473i.recEndPoints != null) {
            i = this.f25473i.recEndPoints.size();
        }
        DestPoiReverseInfo destPoiReverseInfo = this.f25473i;
        return DropOffAddressUtils.createDropOffAddress(rpcPoi, z, i, destPoiReverseInfo != null ? destPoiReverseInfo.language : "", this.f25478n);
    }

    public RpcPoi getNeareatReconmmendPoi(LatLng latLng) {
        RpcPoi findNearestPoi = DropOffAddressUtils.findNearestPoi(latLng, this.f25474j);
        this.f25475k = findNearestPoi;
        return findNearestPoi;
    }

    public DropOffAddress getDropOffAddress(RpcPoi rpcPoi) {
        DropOffAddress a = m18202a(rpcPoi);
        this.f25476l = a;
        return a;
    }

    public void destroy() {
        m18205b();
        this.f25469e = null;
        this.f25473i = null;
        this.f25476l = null;
        this.f25474j = null;
        this.f25475k = null;
    }
}
