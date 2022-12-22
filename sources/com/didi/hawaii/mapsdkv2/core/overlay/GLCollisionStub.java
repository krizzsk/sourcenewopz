package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Rect;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRect;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRectArray;

public class GLCollisionStub extends GLPrimaryShape {

    /* renamed from: a */
    private Rect f24085a;

    /* renamed from: b */
    private int f24086b;

    /* renamed from: c */
    private int f24087c = Integer.MAX_VALUE;
    protected int collisionType;

    /* renamed from: d */
    private HWBSManager f24088d;

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public void setZIndex(int i) {
    }

    public GLCollisionStub(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.collisionType = option.collisionType;
        this.f24087c = option.priority;
        this.f24086b = option.type;
        this.f24085a = new Rect(option.virtualPosition);
    }

    public void attachCollisionEngine(HWBSManager hWBSManager) {
        this.f24088d = hWBSManager;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        HWBSManager hWBSManager = this.f24088d;
        if (hWBSManager != null && this.f24085a != null) {
            hWBSManager.addOverlay(m17135a());
            this.f24088d.handleCollision();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        if (this.f24088d != null && this.mDisplayId != -2) {
            this.f24088d.removeOverlay(Long.valueOf(getId()).longValue());
            this.f24088d.handleCollision();
            this.f24088d = null;
            this.mDisplayId = -2;
        }
    }

    public static class Option extends GLOverlayView.Option {
        protected int collisionType;
        /* access modifiers changed from: private */
        public int priority = Integer.MAX_VALUE;
        protected int type;
        /* access modifiers changed from: private */
        public Rect virtualPosition;

        public void setCollisionType(int i) {
            this.collisionType = i;
        }

        public void setPriority(int i) {
            this.priority = i;
        }

        public void setVirtualPosition(Rect rect) {
            this.virtualPosition = rect;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    /* renamed from: a */
    private MapOverlay m17135a() {
        MapOverlay mapOverlay = new MapOverlay();
        mapOverlay.setOverlayId(Long.valueOf(getId()).longValue());
        mapOverlay.setType(this.f24086b);
        mapOverlay.setGroupId(-1);
        mapOverlay.setCollisionType(this.collisionType);
        mapOverlay.setLongitude((double) this.f24085a.right);
        mapOverlay.setLatitude((double) this.f24085a.bottom);
        mapOverlay.setScaleX(1.0f);
        mapOverlay.setScaleY(1.0f);
        mapOverlay.setFixPosX(0);
        mapOverlay.setFixPosY(0);
        mapOverlay.setAngle(0.0f);
        mapOverlay.setIsClockwise(false);
        mapOverlay.setIsFastLoad(false);
        mapOverlay.setIsAvoidAnno(false);
        mapOverlay.setIsVirtualScreenOverlay(true);
        mapOverlay.setIsOrthographicProject(false);
        mapOverlay.setZIndex(calculateTrueZIndex(this.mLayer, this.zIndex));
        mapOverlay.setAlpha(this.alpha);
        mapOverlay.setVisible(this.visible);
        mapOverlay.setPriority(this.f24087c);
        mapOverlay.setShowInfo("virtual");
        mapOverlay.setRectCnt(1);
        MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
        MapOverlayRect mapOverlayRect = new MapOverlayRect();
        mapOverlayRect.setAnchorX(1.0f);
        mapOverlayRect.setAnchorY(1.0f);
        int abs = Math.abs(this.f24085a.right - this.f24085a.left);
        int abs2 = Math.abs(this.f24085a.bottom - this.f24085a.top);
        mapOverlayRect.setWidth(abs);
        mapOverlayRect.setHeight(abs2);
        mapOverlayRect.setName("virtual");
        mapOverlayRectArray.setitem(0, mapOverlayRect);
        mapOverlay.setRects(mapOverlayRectArray.cast());
        return mapOverlay;
    }
}
