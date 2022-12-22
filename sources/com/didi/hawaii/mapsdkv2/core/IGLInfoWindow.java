package com.didi.hawaii.mapsdkv2.core;

import android.graphics.RectF;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarkerInfoWindow;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;

public interface IGLInfoWindow {

    public interface Host {
        LatLngBounds getInfoWindowGeoBound();

        RectF getInfoWindowScreenRect();

        IGLInfoWindow getInfoWindowView();

        LatLng getPosition();

        boolean isInfoWindowShow();

        void removeInfoWindow();

        void setInfoWindowView(IGLInfoWindow iGLInfoWindow);

        void showInfoWindow(boolean z);
    }

    void attachCollisionEngine(HWBSManager hWBSManager, MapOverlay mapOverlay);

    float getAnchorX();

    float getAnchorY();

    LatLngBounds getGeoBound();

    LatLng getPosition();

    int[] getTextureWH();

    boolean isVisible();

    void setCollisionOption(MapOverlay mapOverlay);

    void setPosition(LatLng latLng);

    public static final class Holder {
        private final Host host;
        /* access modifiers changed from: private */
        public GLOverlayView infoWindow;
        /* access modifiers changed from: private */
        public final GLViewManager viewManager;

        public Holder(GLViewManager gLViewManager, Host host2) {
            this.viewManager = gLViewManager;
            this.host = host2;
        }

        public void show(boolean z) {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView != null) {
                gLOverlayView.setVisible(z);
            }
        }

        public IGLInfoWindow get() {
            return (IGLInfoWindow) this.infoWindow;
        }

        public void onHostRemove() {
            this.viewManager.getMainHandler().post(new Runnable() {
                public void run() {
                    if (Holder.this.infoWindow != null && Holder.this.infoWindow.isAdded()) {
                        Holder.this.viewManager.removeView(Holder.this.infoWindow);
                        GLOverlayView unused = Holder.this.infoWindow = null;
                    }
                }
            });
        }

        public void remove() {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView != null && gLOverlayView.isAdded()) {
                this.viewManager.removeView(this.infoWindow);
                this.infoWindow = null;
            }
        }

        public void set(IGLInfoWindow iGLInfoWindow) {
            GLOverlayView castOrNull = castOrNull(iGLInfoWindow);
            if (castOrNull != null) {
                GLOverlayView gLOverlayView = this.infoWindow;
                if (!(gLOverlayView == null || gLOverlayView == castOrNull)) {
                    this.viewManager.removeView(gLOverlayView);
                }
                this.infoWindow = castOrNull;
                this.viewManager.addView(castOrNull);
                return;
            }
            GLOverlayView gLOverlayView2 = this.infoWindow;
            if (gLOverlayView2 != null) {
                this.viewManager.removeView(gLOverlayView2);
                this.infoWindow = null;
            }
        }

        public boolean isShow() {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView != null) {
                return gLOverlayView.isVisible();
            }
            return false;
        }

        public void setZindex(int i) {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView != null) {
                gLOverlayView.setZIndex(i);
            }
        }

        public LatLngBounds getInfoWindowGeoBound() {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView == null || !gLOverlayView.visible) {
                return null;
            }
            GLOverlayView gLOverlayView2 = this.infoWindow;
            if (gLOverlayView2 instanceof GLMarkerInfoWindow) {
                return ((GLMarkerInfoWindow) gLOverlayView2).getGeoBound();
            }
            return null;
        }

        public RectF getInfoWindowScreenBound() {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView == null || !gLOverlayView.visible) {
                return null;
            }
            GLOverlayView gLOverlayView2 = this.infoWindow;
            if (gLOverlayView2 instanceof GLMarkerInfoWindow) {
                return ((GLMarkerInfoWindow) gLOverlayView2).getScreenBound();
            }
            return null;
        }

        public void setPosition(LatLng latLng) {
            GLOverlayView gLOverlayView = this.infoWindow;
            if (gLOverlayView != null) {
                ((IGLInfoWindow) gLOverlayView).setPosition(latLng);
            }
        }

        private static GLOverlayView castOrNull(IGLInfoWindow iGLInfoWindow) {
            if (iGLInfoWindow instanceof GLOverlayView) {
                return (GLOverlayView) iGLInfoWindow;
            }
            return null;
        }
    }
}
