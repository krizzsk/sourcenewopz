package com.didi.map.global.component.departure.model;

public class AddressExtendInfo {

    /* renamed from: a */
    private int f25164a;

    /* renamed from: b */
    private String f25165b;

    /* renamed from: c */
    private String f25166c;

    /* renamed from: d */
    private String f25167d;

    /* renamed from: e */
    private AddressWalkGuide f25168e;

    /* renamed from: f */
    private String f25169f;

    /* renamed from: g */
    private String f25170g;

    public int getZoneType() {
        return this.f25164a;
    }

    public void setZoneType(int i) {
        this.f25164a = i;
    }

    public String getMainNoticeTitle() {
        return this.f25165b;
    }

    public void setMainNoticeTitle(String str) {
        this.f25165b = str;
    }

    public String getSubNoticeTitle() {
        return this.f25166c;
    }

    public void setSubNoticeTitle(String str) {
        this.f25166c = str;
    }

    public String getXpanelDesc() {
        return this.f25169f;
    }

    public void setXpanelDesc(String str) {
        this.f25169f = str;
    }

    public String getBubbleText() {
        return this.f25167d;
    }

    public void setBubbleText(String str) {
        this.f25167d = str;
    }

    public AddressWalkGuide getWalkGuide() {
        return this.f25168e;
    }

    public void setWalkGuide(AddressWalkGuide addressWalkGuide) {
        this.f25168e = addressWalkGuide;
    }

    public String getNavigationText() {
        return this.f25170g;
    }

    public void setNavigationText(String str) {
        this.f25170g = str;
    }

    public String toString() {
        return "AddressExtendInfo{zoneType=" + this.f25164a + ", mainNoticeTitle='" + this.f25165b + '\'' + ", subNoticeTitle='" + this.f25166c + '\'' + ", bubbleText='" + this.f25167d + '\'' + ", walkGuide=" + this.f25168e + '}';
    }
}
