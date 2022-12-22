package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLPolygon;
import com.didi.map.outer.model.LatLng;
import java.util.List;

@GLViewDebug.ExportClass(name = "Polygon&Border")
public class GLBorderPolygon extends C9243a {

    /* renamed from: a */
    private final GLPolygon f24059a;

    /* renamed from: b */
    private LatLng[] f24060b;

    public /* bridge */ /* synthetic */ int getBorderColor() {
        return super.getBorderColor();
    }

    public /* bridge */ /* synthetic */ float getBorderWidth() {
        return super.getBorderWidth();
    }

    public /* bridge */ /* synthetic */ void setBorderBellowRoute(boolean z) {
        super.setBorderBellowRoute(z);
    }

    public /* bridge */ /* synthetic */ void setBorderColor(int i) {
        super.setBorderColor(i);
    }

    public /* bridge */ /* synthetic */ void setBorderWidth(float f) {
        super.setBorderWidth(f);
    }

    public /* bridge */ /* synthetic */ void updatePoints(LatLng[] latLngArr) {
        super.updatePoints(latLngArr);
    }

    public GLBorderPolygon(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option, option.pts, option.borderColor, option.borderWidth, option.bellowRoute, option.isForceLoad);
        this.f24060b = option.pts;
        GLPolygon.Option option2 = new GLPolygon.Option();
        option2.setColor(option.color);
        option2.setForceLoad(option.isForceLoad);
        option2.setPts(option.pts);
        option2.setBellowRoute(option.bellowRoute);
        option2.setClickable(option.clickable);
        option.copyTo(option2);
        GLPolygon gLPolygon = new GLPolygon(gLViewManager, option2);
        this.f24059a = gLPolygon;
        gLPolygon.setClickable(option.clickable);
        addView(this.f24059a);
    }

    public int getColor() {
        return this.f24059a.getColor();
    }

    public void setColor(int i) {
        this.f24059a.setColor(i);
    }

    public void setBellowRoute(boolean z) {
        setBorderBellowRoute(z);
        this.f24059a.setBellowRoute(z);
    }

    public void updatePolygonPoints(List<LatLng> list) {
        LatLng[] latLng2array = DataUtil.latLng2array(list);
        beginSetTransaction();
        this.f24059a.updatePoints(latLng2array);
        super.updatePoints(latLng2array);
        commitSetTransaction();
    }

    public LatLng[] getPts() {
        return this.f24060b;
    }

    public void setOnClickListener(GLView.OnClickListener onClickListener) {
        this.f24059a.setOnClickListener(onClickListener);
    }

    public void setClickable(boolean z) {
        this.f24059a.setClickable(z);
    }

    public static class Option extends GLOverlayGroup.Option {
        /* access modifiers changed from: private */
        public boolean bellowRoute;
        /* access modifiers changed from: private */
        public int borderColor;
        /* access modifiers changed from: private */
        public float borderWidth;
        /* access modifiers changed from: private */
        public boolean clickable;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isForceLoad;
        /* access modifiers changed from: private */
        public LatLng[] pts = new LatLng[0];

        public void setBellowRoute(boolean z) {
            this.bellowRoute = z;
        }

        public void setForceLoad(boolean z) {
            this.isForceLoad = z;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public void setPts(LatLng[] latLngArr) {
            this.pts = latLngArr;
        }

        public void setBorderWidth(float f) {
            this.borderWidth = f;
        }

        public void setBorderColor(int i) {
            this.borderColor = i;
        }

        public void setClickable(boolean z) {
            this.clickable = z;
        }
    }
}
