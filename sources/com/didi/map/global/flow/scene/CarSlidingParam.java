package com.didi.map.global.flow.scene;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.slideCars.api.AnyCarInfo;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import java.util.List;

public class CarSlidingParam {

    /* renamed from: a */
    private ICarBitmapDescriptor f26281a;

    /* renamed from: b */
    private String f26282b;

    /* renamed from: c */
    private String f26283c;

    /* renamed from: d */
    private int f26284d;

    /* renamed from: e */
    private int f26285e;

    /* renamed from: f */
    private int f26286f;

    /* renamed from: g */
    private String f26287g;

    /* renamed from: h */
    private String f26288h;

    /* renamed from: i */
    private int f26289i;

    /* renamed from: j */
    private String f26290j;

    /* renamed from: k */
    private String f26291k;

    /* renamed from: l */
    private int f26292l;

    /* renamed from: m */
    private String f26293m;

    /* renamed from: n */
    private int f26294n = -1;

    /* renamed from: o */
    private List<AnyCarInfo> f26295o;

    /* renamed from: p */
    private int f26296p = -1;

    /* renamed from: q */
    private LatLng f26297q;

    /* renamed from: r */
    private String f26298r;

    /* renamed from: s */
    private String f26299s;

    /* renamed from: t */
    private String f26300t;

    /* renamed from: u */
    private String f26301u;

    /* renamed from: v */
    private Long f26302v;

    public CarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, int i3, String str7) {
        this.f26281a = iCarBitmapDescriptor;
        this.f26282b = str;
        this.f26283c = str2;
        this.f26284d = i;
        this.f26285e = i2;
        this.f26287g = str3;
        this.f26288h = str4;
        this.f26290j = str5;
        this.f26291k = str6;
        this.f26292l = i3;
        this.f26293m = str7;
    }

    public CarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, int i, int i2, String str, String str2, int i3, String str3) {
        this.f26281a = iCarBitmapDescriptor;
        this.f26284d = i;
        this.f26285e = i2;
        this.f26290j = str;
        this.f26291k = str2;
        this.f26292l = i3;
        this.f26293m = str3;
    }

    public ICarBitmapDescriptor getBitmap() {
        return this.f26281a;
    }

    public String getProductId() {
        return this.f26282b;
    }

    public String getSdkMapType() {
        return this.f26283c;
    }

    public int getType() {
        return this.f26284d;
    }

    public void setBitmap(ICarBitmapDescriptor iCarBitmapDescriptor) {
        this.f26281a = iCarBitmapDescriptor;
    }

    public void setProductId(String str) {
        this.f26282b = str;
    }

    public void setSdkMapType(String str) {
        this.f26283c = str;
    }

    public void setType(int i) {
        this.f26284d = i;
    }

    public void setOrderState(int i) {
        this.f26285e = i;
    }

    public void setLocale(String str) {
        this.f26287g = str;
    }

    public void setMapType(String str) {
        this.f26288h = str;
    }

    public void setIdfa(String str) {
        this.f26290j = str;
    }

    public void setOriginId(String str) {
        this.f26291k = str;
    }

    public void setMixFlag(int i) {
        this.f26292l = i;
    }

    public void setA3Token(String str) {
        this.f26293m = str;
    }

    public int getOrderState() {
        return this.f26285e;
    }

    public int getCarLevel() {
        return this.f26286f;
    }

    public void setCarLevel(int i) {
        this.f26286f = i;
    }

    public String getLocale() {
        return this.f26287g;
    }

    public String getMapType() {
        return this.f26288h;
    }

    public String getIdfa() {
        return this.f26290j;
    }

    public String getOriginId() {
        return this.f26291k;
    }

    public int getMixFlag() {
        return this.f26292l;
    }

    public String getA3Token() {
        return this.f26293m;
    }

    public LatLng getEndLatLng() {
        return this.f26297q;
    }

    public void setEndLatLng(LatLng latLng) {
        this.f26297q = latLng;
    }

    public String getXtags() {
        return this.f26298r;
    }

    public void setXtags(String str) {
        this.f26298r = str;
    }

    public String getExtra() {
        return this.f26299s;
    }

    public void setExtra(String str) {
        this.f26299s = str;
    }

    public String getPid() {
        return this.f26300t;
    }

    public void setPid(String str) {
        this.f26300t = str;
    }

    public String getBubbleId() {
        return this.f26301u;
    }

    public void setBubbleId(String str) {
        this.f26301u = str;
    }

    public Long getDriverId() {
        return this.f26302v;
    }

    public void setDriverId(Long l) {
        this.f26302v = l;
    }

    public int getOrderTab() {
        return this.f26289i;
    }

    public void setOrderTab(int i) {
        this.f26289i = i;
    }

    public List<AnyCarInfo> getAnyCarInfo() {
        return this.f26295o;
    }

    public int getIsAnyCarIntl() {
        return this.f26294n;
    }

    public int getAnyCarPriority() {
        return this.f26296p;
    }

    public void setIsAnyCarIntl(int i) {
        this.f26294n = i;
    }

    public void setAnyCarPriority(int i) {
        this.f26296p = i;
    }

    public void setAnyCarInfo(List<AnyCarInfo> list) {
        this.f26295o = list;
    }

    public String toString() {
        return "CarSlidingParam{bitmap=" + this.f26281a + ", productId='" + this.f26282b + '\'' + ", sdkMapType='" + this.f26283c + '\'' + ", type=" + this.f26284d + ", orderState=" + this.f26285e + ", carLevel=" + this.f26286f + ", locale='" + this.f26287g + '\'' + ", mapType='" + this.f26288h + '\'' + ", orderTab=" + this.f26289i + ", idfa='" + this.f26290j + '\'' + ", originId='" + this.f26291k + '\'' + ", mixFlag=" + this.f26292l + ", a3Token='" + this.f26293m + '\'' + ", isAnyCarIntl=" + this.f26294n + ", anyCarInfo=" + this.f26295o + ", anyCarPriority=" + this.f26296p + ", endLatLng=" + this.f26297q + ", xtags='" + this.f26298r + '\'' + ", extra='" + this.f26299s + '\'' + ", pid='" + this.f26300t + '\'' + ", bubbleId='" + this.f26301u + '\'' + ", driverId=" + this.f26302v + '}';
    }
}
