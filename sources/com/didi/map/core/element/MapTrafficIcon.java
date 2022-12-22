package com.didi.map.core.element;

import com.didi.map.outer.model.LatLng;

public class MapTrafficIcon {
    public static final int BUBBLE_STATUS_BLOCK = 0;
    public static final int BUBBLE_STATUS_BLOCK_ACCIDENT = 1;
    public static final int BUBBLE_STATUS_BLOCK_HOSPITAL = 4;
    public static final int BUBBLE_STATUS_BLOCK_IMAGE = 5;
    public static final int BUBBLE_STATUS_BLOCK_MULTI = 2;
    public static final int BUBBLE_STATUS_BLOCK_SCHOOL = 3;
    public static final int BUBBLE_TYPE_ACCIDENT = 0;
    public static final int BUBBLE_TYPE_BLOCK_ACCIDENT = 1;

    /* renamed from: a */
    private long f24741a;

    /* renamed from: b */
    private int f24742b;

    /* renamed from: c */
    private int f24743c;

    /* renamed from: d */
    private boolean f24744d;

    /* renamed from: e */
    private int f24745e;

    /* renamed from: f */
    private int f24746f;

    /* renamed from: g */
    private LatLng f24747g;

    /* renamed from: h */
    private boolean f24748h = false;

    /* renamed from: i */
    private int f24749i = 0;

    /* renamed from: j */
    private String f24750j = "";

    /* renamed from: k */
    private int f24751k = 0;

    /* renamed from: l */
    private String f24752l = "";

    public MapTrafficIcon() {
    }

    public MapTrafficIcon(long j, int i, int i2, boolean z, LatLng latLng) {
        this.f24741a = j;
        this.f24742b = i;
        this.f24743c = i2;
        this.f24744d = z;
        this.f24747g = latLng;
    }

    public String getVideoImgUrl() {
        return this.f24752l;
    }

    public void setVideoImgUrl(String str) {
        this.f24752l = str;
    }

    public int getShapeOffset() {
        return this.f24746f;
    }

    public void setShapeOffset(int i) {
        this.f24746f = i;
    }

    public int getCoorIndex() {
        return this.f24745e;
    }

    public void setCoorIndex(int i) {
        this.f24745e = i;
    }

    public boolean isFromBubble() {
        return this.f24748h;
    }

    public void setFromBubble(boolean z) {
        this.f24748h = z;
    }

    public long getId() {
        return this.f24741a;
    }

    public void setId(long j) {
        this.f24741a = j;
    }

    public int getSubId() {
        return this.f24742b;
    }

    public void setSubId(int i) {
        this.f24742b = i;
    }

    public int getType() {
        return this.f24743c;
    }

    public void setType(int i) {
        this.f24743c = i;
    }

    public LatLng getLatLng() {
        return this.f24747g;
    }

    public void setLatLng(LatLng latLng) {
        this.f24747g = latLng;
    }

    public boolean getState() {
        return this.f24744d;
    }

    public void setState(boolean z) {
        this.f24744d = z;
    }

    public int getBlockType() {
        return this.f24749i;
    }

    public void setBlockType(int i) {
        this.f24749i = i;
    }

    public int getBlockBubbleStatus() {
        return this.f24751k;
    }

    public void setBlockBubbleStatus(int i) {
        this.f24751k = i;
    }

    public String getImgUrl() {
        return this.f24750j;
    }

    public void setImgUrl(String str) {
        this.f24750j = str;
    }

    public String toString() {
        return "MapTrafficIcon{mId=" + this.f24741a + ", mSubId=" + this.f24742b + ", mType=" + this.f24743c + ", mState=" + this.f24744d + ", mLatLng=" + this.f24747g + ", fromBubble=" + this.f24748h + ", bubbleType=" + this.f24749i + ", imgUrl='" + this.f24750j + '\'' + ", blockBubbleStatus=" + this.f24751k + '}';
    }
}
