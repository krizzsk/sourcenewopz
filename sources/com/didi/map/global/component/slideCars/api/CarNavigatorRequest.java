package com.didi.map.global.component.slideCars.api;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class CarNavigatorRequest {

    /* renamed from: a */
    private String f26140a;

    /* renamed from: b */
    private String f26141b;

    /* renamed from: c */
    private LatLng f26142c;

    /* renamed from: d */
    private LatLng f26143d;

    /* renamed from: e */
    private int f26144e;

    /* renamed from: f */
    private int f26145f;

    /* renamed from: g */
    private ClientConfigParam f26146g;

    /* renamed from: h */
    private String f26147h;

    /* renamed from: i */
    private String f26148i;

    /* renamed from: j */
    private String f26149j;

    /* renamed from: k */
    private int f26150k;

    /* renamed from: l */
    private String f26151l;

    /* renamed from: m */
    private int f26152m;

    /* renamed from: n */
    private String f26153n;

    /* renamed from: o */
    private int f26154o = -1;

    /* renamed from: p */
    private List<AnyCarInfo> f26155p;

    /* renamed from: q */
    private int f26156q = -1;

    public CarNavigatorRequest(String str, String str2, ClientConfigParam clientConfigParam, LatLng latLng, int i, int i2) {
        this.f26140a = str;
        this.f26141b = str2;
        this.f26146g = clientConfigParam;
        this.f26142c = latLng;
        this.f26144e = i;
        this.f26145f = i2;
    }

    public String getProductId() {
        return this.f26140a;
    }

    public String getSdkMapType() {
        return this.f26141b;
    }

    public ClientConfigParam getClientConfigParam() {
        return this.f26146g;
    }

    public LatLng getStartPosition() {
        return this.f26142c;
    }

    public LatLng getEndPosition() {
        return this.f26143d;
    }

    public int getType() {
        return this.f26144e;
    }

    public int getOrderState() {
        return this.f26145f;
    }

    public String getXtags() {
        return this.f26147h;
    }

    public String getExtra() {
        return this.f26148i;
    }

    public String getPid() {
        return this.f26149j;
    }

    public int getCarLevel() {
        return this.f26150k;
    }

    public String getBubbleId() {
        return this.f26151l;
    }

    public String getDriverId() {
        return this.f26153n;
    }

    public void setProductId(String str) {
        this.f26140a = str;
    }

    public void setSdkMapType(String str) {
        this.f26141b = str;
    }

    public void setClientConfigParam(ClientConfigParam clientConfigParam) {
        this.f26146g = clientConfigParam;
    }

    public void setStartPosition(LatLng latLng) {
        this.f26142c = latLng;
    }

    public void setEndPosition(LatLng latLng) {
        this.f26143d = latLng;
    }

    public void setType(int i) {
        this.f26144e = i;
    }

    public void setOrderState(int i) {
        this.f26145f = i;
    }

    public void setXtags(String str) {
        this.f26147h = str;
    }

    public void setExtra(String str) {
        this.f26148i = str;
    }

    public void setPid(String str) {
        this.f26149j = str;
    }

    public void setCarLevel(int i) {
        this.f26150k = i;
    }

    public void setBubbleId(String str) {
        this.f26151l = str;
    }

    public void setDriverId(String str) {
        this.f26153n = str;
    }

    public int getOrderTab() {
        return this.f26152m;
    }

    public void setOrderTab(int i) {
        this.f26152m = i;
    }

    public List<AnyCarInfo> getAnyCarInfo() {
        return this.f26155p;
    }

    public int getAnyCarPriority() {
        return this.f26156q;
    }

    public int getIsAnyCarIntl() {
        return this.f26154o;
    }

    public void setAnyCarInfo(List<AnyCarInfo> list) {
        this.f26155p = list;
    }

    public void setAnyCarPriority(int i) {
        this.f26156q = i;
    }

    public void setIsAnyCarIntl(int i) {
        this.f26154o = i;
    }
}
