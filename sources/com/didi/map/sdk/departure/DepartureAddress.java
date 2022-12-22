package com.didi.map.sdk.departure;

import com.didi.map.sdk.departure.internal.special.SpecialPois;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.SpecialPoiGuidance;
import java.util.ArrayList;

public class DepartureAddress {

    /* renamed from: a */
    private RpcPoi f28092a;

    /* renamed from: b */
    private boolean f28093b;

    /* renamed from: c */
    private String f28094c;

    /* renamed from: d */
    private SpecialPoiGuidance f28095d;

    /* renamed from: e */
    private int f28096e;

    /* renamed from: f */
    private FenceInfo f28097f;

    /* renamed from: g */
    private ArrayList<RpcPoi> f28098g;

    /* renamed from: h */
    private SpecialPois f28099h;

    /* renamed from: i */
    private String f28100i;

    /* renamed from: j */
    private ArrayList<String> f28101j;

    /* renamed from: k */
    private int f28102k;

    /* renamed from: l */
    private RpcPoi f28103l;

    /* renamed from: m */
    private int f28104m;

    public int getOperationType() {
        return this.f28104m;
    }

    public void setOperationType(int i) {
        this.f28104m = i;
    }

    public RpcPoi getAddress() {
        return this.f28092a;
    }

    public void setAddress(RpcPoi rpcPoi) {
        this.f28092a = rpcPoi;
    }

    public boolean isRecommendPoi() {
        return this.f28093b;
    }

    public String getDepartureDisplayName() {
        return this.f28094c;
    }

    public void setDepartureDisplayName(String str) {
        this.f28094c = str;
    }

    public SpecialPoiGuidance getSpecialPoiGuidance() {
        return this.f28095d;
    }

    public void setSpecialPoiGuidance(SpecialPoiGuidance specialPoiGuidance) {
        this.f28095d = specialPoiGuidance;
    }

    public void setRecommendPoi(boolean z) {
        this.f28093b = z;
    }

    public int getZoneStatus() {
        return this.f28096e;
    }

    public void setZoneStatus(int i) {
        this.f28096e = i;
    }

    public FenceInfo getFenceInfo() {
        return this.f28097f;
    }

    public void setFenceInfo(FenceInfo fenceInfo) {
        this.f28097f = fenceInfo;
    }

    public ArrayList<RpcPoi> getRecommendDestinations() {
        return this.f28098g;
    }

    public void setRecommendDestinations(ArrayList<RpcPoi> arrayList) {
        this.f28098g = arrayList;
    }

    public SpecialPois getSpecialPois() {
        return this.f28099h;
    }

    public void setSpecialPois(SpecialPois specialPois) {
        this.f28099h = specialPois;
    }

    public boolean hasSpecialPois() {
        SpecialPois specialPois = this.f28099h;
        return (specialPois == null || specialPois.pois == null || this.f28099h.pois.isEmpty()) ? false : true;
    }

    public String getLanguage() {
        return this.f28100i;
    }

    public void setLanguage(String str) {
        this.f28100i = str;
    }

    public ArrayList<String> getGeofenceTags() {
        return this.f28101j;
    }

    public void setGeofenceTags(ArrayList<String> arrayList) {
        this.f28101j = arrayList;
    }

    public int getPickUpPointSize() {
        return this.f28102k;
    }

    public void setPickUpPointSize(int i) {
        this.f28102k = i;
    }

    public RpcPoi getRgeoResult() {
        return this.f28103l;
    }

    public void setRgeoResult(RpcPoi rpcPoi) {
        this.f28103l = rpcPoi;
    }
}
