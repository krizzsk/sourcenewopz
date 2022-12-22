package com.didi.map.global.component.departure.model;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.SpecialPoiGuidance;
import java.util.ArrayList;
import java.util.List;

public class DepartureAddress {

    /* renamed from: a */
    private Address f25174a;

    /* renamed from: b */
    private Address f25175b;

    /* renamed from: c */
    private boolean f25176c;

    /* renamed from: d */
    private String f25177d;

    /* renamed from: e */
    private SpecialPoiGuidance f25178e;

    /* renamed from: f */
    private int f25179f = 2;

    /* renamed from: g */
    private FenceInfo f25180g;

    /* renamed from: h */
    private List<Address> f25181h;

    /* renamed from: i */
    private SpecialPois f25182i;

    /* renamed from: j */
    private String f25183j;

    /* renamed from: k */
    private ArrayList<String> f25184k;

    /* renamed from: l */
    private int f25185l;

    /* renamed from: m */
    private boolean f25186m = false;

    /* renamed from: n */
    private boolean f25187n = false;

    /* renamed from: o */
    private int f25188o;

    /* renamed from: p */
    private LatLng f25189p;

    /* renamed from: q */
    private String f25190q;

    /* renamed from: r */
    private String f25191r;

    /* renamed from: s */
    private String f25192s;
    public ArrayList<String> specialLocations;

    /* renamed from: t */
    private String f25193t;

    /* renamed from: u */
    private int f25194u;

    /* renamed from: v */
    private String f25195v;

    /* renamed from: w */
    private AddressExtendInfo f25196w;

    public String getPickIconUrl() {
        return this.f25191r;
    }

    public void setPickIconUrl(String str) {
        this.f25191r = str;
    }

    public String getNavigationText() {
        return this.f25192s;
    }

    public void setNavigationText(String str) {
        this.f25192s = str;
    }

    public int getCountryId() {
        return this.f25194u;
    }

    public void setCountryId(int i) {
        this.f25194u = i;
    }

    public String getCountryCode() {
        return this.f25195v;
    }

    public void setCountryCode(String str) {
        this.f25195v = str;
    }

    public String getEta() {
        return this.f25193t;
    }

    public void setEta(String str) {
        this.f25193t = str;
    }

    public int getIsAirPortPickUpPoint() {
        return this.f25188o;
    }

    public void setIsAirPortPickUpPoint(int i) {
        this.f25188o = i;
    }

    public Address getAddress() {
        return this.f25174a;
    }

    public LatLng getPosition() {
        Address address = this.f25174a;
        if (address == null || this.f25189p != null) {
            DLog.m7384d("departure position", "position！=null", new Object[0]);
        } else {
            this.f25189p = new LatLng(address.latitude, this.f25174a.longitude);
        }
        return this.f25189p;
    }

    public void setAddress(Address address) {
        this.f25174a = address;
    }

    public boolean isRecommendPoi() {
        return this.f25176c;
    }

    public String getDepartureDisplayName() {
        return this.f25177d;
    }

    public void setDepartureDisplayName(String str) {
        this.f25177d = str;
    }

    public SpecialPoiGuidance getSpecialPoiGuidance() {
        return this.f25178e;
    }

    public void setSpecialPoiGuidance(SpecialPoiGuidance specialPoiGuidance) {
        this.f25178e = specialPoiGuidance;
    }

    public void setRecommendPoi(boolean z) {
        this.f25176c = z;
    }

    public int getZoneType() {
        return this.f25179f;
    }

    public void setZoneType(int i) {
        this.f25179f = i;
    }

    public FenceInfo getFenceInfo() {
        return this.f25180g;
    }

    public void setFenceInfo(FenceInfo fenceInfo) {
        this.f25180g = fenceInfo;
    }

    public List<Address> getRecDestinations() {
        return this.f25181h;
    }

    public void setRecDestinations(List<Address> list) {
        this.f25181h = list;
    }

    public SpecialPois getSpecialPois() {
        return this.f25182i;
    }

    public void setSpecialPois(SpecialPois specialPois) {
        this.f25182i = specialPois;
    }

    public boolean hasSpecialPois() {
        SpecialPois specialPois = this.f25182i;
        return (specialPois == null || specialPois.pois == null || this.f25182i.pois.isEmpty()) ? false : true;
    }

    public ArrayList<String> getSpecialLocations() {
        return this.specialLocations;
    }

    public void setSpecialLocations(ArrayList<String> arrayList) {
        this.specialLocations = arrayList;
    }

    public String getLanguage() {
        return this.f25183j;
    }

    public void setLanguage(String str) {
        this.f25183j = str;
    }

    public ArrayList<String> getGeofenceTags() {
        return this.f25184k;
    }

    public void setGeofenceTags(ArrayList<String> arrayList) {
        this.f25184k = arrayList;
    }

    public int getPickUpPointSize() {
        return this.f25185l;
    }

    public void setPickUpPointSize(int i) {
        this.f25185l = i;
    }

    public boolean isShowSpecialNotifacation() {
        return this.f25186m;
    }

    public void setShowSpecialNotifacation(boolean z) {
        this.f25186m = z;
    }

    public boolean isShowRealPicInXpanel() {
        return this.f25187n;
    }

    public void setShowRealPicInXpanel(boolean z) {
        this.f25187n = z;
    }

    public String getStartParkingProperty() {
        return this.f25190q;
    }

    public void setStartParkingProperty(String str) {
        this.f25190q = str;
    }

    public AddressExtendInfo getExtendInfo() {
        return this.f25196w;
    }

    public void setExtendInfo(AddressExtendInfo addressExtendInfo) {
        this.f25196w = addressExtendInfo;
    }

    public Address getRgeoResult() {
        return this.f25175b;
    }

    public void setRgeoResult(Address address) {
        this.f25175b = address;
    }
}
