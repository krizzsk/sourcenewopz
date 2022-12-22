package com.didi.component.mapflow.infowindow.model;

public class DepartureModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private String f14213a;

    /* renamed from: b */
    private String f14214b;

    /* renamed from: c */
    private String f14215c;

    /* renamed from: d */
    private boolean f14216d;

    /* renamed from: e */
    private boolean f14217e;

    /* renamed from: f */
    private boolean f14218f;

    /* renamed from: g */
    private boolean f14219g;

    /* renamed from: h */
    private boolean f14220h;

    /* renamed from: i */
    private String f14221i;

    /* renamed from: j */
    private String f14222j;

    public void setShowNearbyHint(boolean z) {
        this.f14220h = z;
    }

    public boolean isShowNearbyHint() {
        return this.f14220h;
    }

    public boolean isShowLoading() {
        return this.f14216d;
    }

    public void setShowLoading(boolean z) {
        this.f14216d = z;
    }

    public String getEtaValue() {
        return this.f14213a;
    }

    public void setEtaValue(String str) {
        this.f14213a = str;
    }

    public String getEtaUnit() {
        return this.f14214b;
    }

    public void setEtaUnit(String str) {
        this.f14214b = str;
    }

    public String getMessage() {
        return this.f14215c;
    }

    public void setMessage(String str) {
        this.f14215c = str;
    }

    public void setArrow(boolean z) {
        this.f14217e = z;
    }

    public boolean isArrow() {
        return this.f14217e;
    }

    public boolean isMessageOnly() {
        return this.f14218f;
    }

    public void setMessageOnly(boolean z) {
        this.f14218f = z;
    }

    public boolean isLeftTwoLine() {
        return this.f14219g;
    }

    public void setLeftTwoLine(boolean z) {
        this.f14219g = z;
    }

    public String getEtd() {
        return this.f14221i;
    }

    public void setEtd(String str) {
        this.f14221i = str;
    }

    public String getMapStartPointText() {
        return this.f14222j;
    }

    public void setMapStartPointText(String str) {
        this.f14222j = str;
    }
}
