package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Rect;
import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.jni.DDMapPointArray;
import com.didi.hawaii.mapsdkv2.jni.DMapLine;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.outer.model.LatLng;
import java.util.List;

public class GLCollisionGroup extends GLOverlayGroup {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HWBSManager f24068a;

    /* renamed from: b */
    private int f24069b;

    /* renamed from: c */
    private int f24070c;

    /* renamed from: d */
    private final Rect f24071d;

    public GLCollisionGroup(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24071d = option.padding;
        HWBSManager hWBSManager = new HWBSManager();
        this.f24068a = hWBSManager;
        Rect rect = this.f24071d;
        if (rect != null) {
            hWBSManager.setPadding(rect.left, this.f24071d.right, this.f24071d.top, this.f24071d.bottom);
        }
        this.f24068a.setIsAreaBubbleEnable(true);
        this.f24068a.setMultiBubbleSelectPointEnable(true);
        this.f24068a.setAnimateEnable(ApolloHawaii.OPEN_ANIMATE, ApolloHawaii.OPEN_ANIMATE_HAS_DEL_ANIMATE);
        setIgnoreGroupAttrs(true);
        attachToFrame(true);
    }

    public void onFrameFinish(boolean z) {
        super.onFrameFinish(z);
        HWBSManager hWBSManager = this.f24068a;
        if (hWBSManager != null) {
            hWBSManager.drawAnimation();
        }
    }

    public void addView(GLOverlayView gLOverlayView) {
        if (gLOverlayView instanceof GLCollisionMarker) {
            ((GLCollisionMarker) gLOverlayView).attachCollisionEngine(this.f24068a);
        }
        if (gLOverlayView instanceof GLCollisionStub) {
            ((GLCollisionStub) gLOverlayView).attachCollisionEngine(this.f24068a);
        }
        super.addView(gLOverlayView);
    }

    public void addRoute4Collision(final List<LatLng> list) {
        set(new RenderTask() {
            public void run() {
                List list = list;
                if (list != null && list.size() >= 2) {
                    DMapLine dMapLine = new DMapLine();
                    DDMapPointArray dDMapPointArray = new DDMapPointArray(list.size());
                    for (int i = 0; i < list.size(); i++) {
                        dDMapPointArray.setitem(i, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(((LatLng) list.get(i)).longitude, ((LatLng) list.get(i)).latitude)));
                    }
                    dMapLine.setSize(list.size());
                    dMapLine.setPoints(dDMapPointArray.cast());
                    GLCollisionGroup.this.f24068a.addRoute4Collision(dMapLine);
                }
            }
        });
    }

    public void clearRoute4Collision() {
        set(new RenderTask() {
            public void run() {
                GLCollisionGroup.this.f24068a.clearRoute4Collision();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        HWBSManager.destroy(this.f24068a);
    }

    public void setPadding(final Rect rect) {
        set(new RenderTask() {
            public void run() {
                GLCollisionGroup.this.f24068a.setPadding(rect.left, rect.right, rect.top, rect.bottom);
            }
        });
    }

    public void checkCollision() {
        set(new RenderTask() {
            public void run() {
                GLCollisionGroup.this.f24068a.handleCollision();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mMapCanvas.attachMapEngine(this.f24068a);
    }

    /* access modifiers changed from: protected */
    public void onHostSizeChanged(int i, int i2) {
        super.onHostSizeChanged(i, i2);
        if (this.f24070c != i2 || this.f24069b != i) {
            this.f24070c = i2;
            this.f24069b = i;
            this.f24068a.initCollisionRect(0, 0, i, i2);
        }
    }

    public static class Option extends GLOverlayGroup.Option {
        /* access modifiers changed from: private */
        public Rect padding;

        public void setPadding(Rect rect) {
            this.padding = rect;
        }
    }
}
