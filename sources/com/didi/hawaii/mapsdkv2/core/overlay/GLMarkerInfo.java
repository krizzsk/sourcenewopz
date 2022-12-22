package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.RectF;
import com.didi.hawaii.mapsdkv2.common.Tranform2Piex20Utils;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarker;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;

@GLViewDebug.ExportClass(name = "Marker&InfoWindow")
public class GLMarkerInfo extends GLMarker implements IGLInfoWindow.Host {

    /* renamed from: a */
    private int f24099a = 100000;

    /* renamed from: b */
    private boolean f24100b = true;

    /* renamed from: c */
    private boolean f24101c = false;
    protected final IGLInfoWindow.Holder infoWindowHolder;

    public GLMarkerInfo(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24099a = option.infoWindowZindex;
        this.f24100b = option.bestViewInclude;
        this.infoWindowHolder = new IGLInfoWindow.Holder(gLViewManager, this);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.infoWindowHolder.onHostRemove();
        this.f24101c = false;
    }

    public float getInfoWindowZindex() {
        return (float) this.f24099a;
    }

    public RectF getPiexBound(float f) {
        RectF piexBound = super.getPiexBound(f);
        if (isInfoWindowShow() && this.f24100b) {
            float anchorX = this.infoWindowHolder.get().getAnchorX();
            float anchorY = this.infoWindowHolder.get().getAnchorY();
            this.infoWindowHolder.get().getPosition();
            DoublePoint latlng2PixelStandardScaleLevel = Tranform2Piex20Utils.latlng2PixelStandardScaleLevel(getPosition(), (DoublePoint) null);
            int[] textureWH = this.infoWindowHolder.get().getTextureWH();
            RectF rectF = new RectF();
            int i = textureWH[0];
            int i2 = textureWH[1];
            float f2 = ((float) latlng2PixelStandardScaleLevel.f24753x) * f;
            float f3 = ((float) latlng2PixelStandardScaleLevel.f24754y) * f;
            rectF.left = f2;
            float f4 = (float) i;
            rectF.right = f2 + f4;
            float f5 = (float) i2;
            rectF.top = f3 - f5;
            rectF.bottom = f3;
            float f6 = (float) ((int) (anchorX * f4));
            rectF.left -= f6;
            rectF.right -= f6;
            float f7 = (float) ((int) (anchorY * f5));
            rectF.top += f7;
            rectF.bottom += f7;
            float offsetX = getOffsetX();
            float offsetY = getOffsetY();
            rectF.left += offsetX;
            rectF.right += offsetX;
            rectF.top -= offsetY;
            rectF.bottom -= offsetY;
            if (piexBound != null) {
                if (piexBound.left > rectF.left) {
                    piexBound.left = rectF.left;
                }
                if (piexBound.top > rectF.top) {
                    piexBound.top = rectF.top;
                }
                if (piexBound.right < rectF.right) {
                    piexBound.right = rectF.right;
                }
                if (piexBound.bottom < rectF.bottom) {
                    piexBound.bottom = rectF.bottom;
                }
            }
        }
        return piexBound;
    }

    public void updateOption(Option option) {
        showInfoWindow(this.f24101c && option.isVisible());
        setPosition(new LatLng(option.latitude, option.longitude));
        super.onUpdateOption(option);
    }

    public void showInfoWindow(boolean z) {
        this.f24101c = z;
        this.infoWindowHolder.show(z);
    }

    public IGLInfoWindow getInfoWindowView() {
        return this.infoWindowHolder.get();
    }

    public void setInfoWindowView(IGLInfoWindow iGLInfoWindow) {
        this.infoWindowHolder.set(iGLInfoWindow);
    }

    public void removeInfoWindow() {
        this.f24101c = false;
        this.infoWindowHolder.remove();
    }

    public boolean isInfoWindowShow() {
        return this.infoWindowHolder.isShow();
    }

    public LatLngBounds getInfoWindowGeoBound() {
        return this.infoWindowHolder.getInfoWindowGeoBound();
    }

    public RectF getInfoWindowScreenRect() {
        return this.infoWindowHolder.getInfoWindowScreenBound();
    }

    public static class Option extends GLMarker.Option {
        /* access modifiers changed from: private */
        public boolean bestViewInclude = true;
        /* access modifiers changed from: private */
        public int infoWindowZindex = 100000;

        public void setInfoWindowZindex(int i) {
            this.infoWindowZindex = i;
        }

        public void setBestViewInclude(boolean z) {
            this.bestViewInclude = z;
        }
    }

    public void setInfoWindowZindex(int i) {
        this.infoWindowHolder.setZindex(i);
        this.f24099a = i;
    }

    public void setBestViewInclude(boolean z) {
        this.f24100b = z;
    }

    public void setPosition(LatLng latLng) {
        super.setPosition(latLng);
        this.infoWindowHolder.setPosition(latLng);
    }
}
