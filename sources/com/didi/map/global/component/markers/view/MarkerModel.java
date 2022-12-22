package com.didi.map.global.component.markers.view;

import android.graphics.Bitmap;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.collide.ICollideStrategy;

public class MarkerModel {

    /* renamed from: a */
    private String f26009a;

    /* renamed from: b */
    private LatLng f26010b;

    /* renamed from: c */
    private boolean f26011c = true;

    /* renamed from: d */
    private Bitmap f26012d;

    /* renamed from: e */
    private float f26013e;

    /* renamed from: f */
    private float f26014f;

    /* renamed from: g */
    private Padding f26015g;

    /* renamed from: h */
    private int f26016h;

    /* renamed from: i */
    private String f26017i;

    /* renamed from: j */
    private float f26018j;

    /* renamed from: k */
    private String f26019k;

    /* renamed from: l */
    private int f26020l;

    /* renamed from: m */
    private int f26021m;

    /* renamed from: n */
    private boolean f26022n;

    /* renamed from: o */
    private ILabelView f26023o;

    /* renamed from: p */
    private Padding f26024p;

    /* renamed from: q */
    private ICollideStrategy f26025q;

    public void setStrategy(ICollideStrategy iCollideStrategy) {
        this.f26025q = iCollideStrategy;
    }

    public ICollideStrategy getStrategy() {
        return this.f26025q;
    }

    public void setAnchorPadding(Padding padding) {
        this.f26015g = padding;
    }

    public Padding getAnchorPadding() {
        return this.f26015g;
    }

    public String getMarkerUrl() {
        return this.f26017i;
    }

    public void setMarkerUrl(String str) {
        this.f26017i = str;
    }

    public String getId() {
        return this.f26009a;
    }

    public void setId(String str) {
        this.f26009a = str;
    }

    public LatLng getPoint() {
        return this.f26010b;
    }

    public void setPoint(LatLng latLng) {
        this.f26010b = latLng;
    }

    public String getAddressName() {
        return this.f26019k;
    }

    public void setAddressName(String str) {
        this.f26019k = str;
    }

    public Bitmap getMarkerIcon() {
        return this.f26012d;
    }

    public void setMarkerIcon(Bitmap bitmap) {
        this.f26012d = bitmap;
    }

    public float getAnchorU() {
        return this.f26013e;
    }

    public void setAnchorU(float f) {
        this.f26013e = f;
    }

    public float getAnchorV() {
        return this.f26014f;
    }

    public void setAnchorV(float f) {
        this.f26014f = f;
    }

    public int getZOrder() {
        return this.f26016h;
    }

    public void setZOrder(int i) {
        this.f26016h = i;
    }

    public int getLabelZIndex() {
        return this.f26020l;
    }

    public void setLabelZIndex(int i) {
        this.f26020l = i;
    }

    public Padding getLabelAnchorPadding() {
        return this.f26024p;
    }

    public void setLabelAnchorPadding(Padding padding) {
        this.f26024p = padding;
    }

    public boolean isClickable() {
        return this.f26011c;
    }

    public void setClickable(boolean z) {
        this.f26011c = z;
    }

    public float getUrlIconScaleParam() {
        return this.f26018j;
    }

    public void setUrlIconScaleParam(float f) {
        this.f26018j = f;
    }

    public int getLabelDirection() {
        return this.f26021m;
    }

    public void setLabelDirection(int i) {
        this.f26021m = i;
    }

    public ILabelView getLabelView() {
        return this.f26023o;
    }

    public void setLabelView(ILabelView iLabelView) {
        this.f26023o = iLabelView;
    }

    public boolean isLabelSelected() {
        return this.f26022n;
    }

    public void setLabelSelected(boolean z) {
        this.f26022n = z;
    }

    public MarkerModel() {
    }

    public MarkerModel(String str, LatLng latLng, String str2, Bitmap bitmap, float f, float f2) {
        this.f26009a = str;
        this.f26010b = latLng;
        this.f26019k = str2;
        this.f26012d = bitmap;
        this.f26013e = f;
        this.f26014f = f2;
    }

    public MarkerModel(String str, LatLng latLng, String str2, Bitmap bitmap, float f, float f2, int i) {
        this.f26009a = str;
        this.f26010b = latLng;
        this.f26019k = str2;
        this.f26012d = bitmap;
        this.f26013e = f;
        this.f26014f = f2;
        this.f26016h = i;
    }

    public MarkerModel(String str, LatLng latLng, String str2, Bitmap bitmap, float f, float f2, int i, String str3, int i2) {
        this.f26009a = str;
        this.f26010b = latLng;
        this.f26019k = str2;
        this.f26012d = bitmap;
        this.f26013e = f;
        this.f26014f = f2;
        this.f26016h = i;
        this.f26017i = str3;
        this.f26020l = i2;
    }
}
