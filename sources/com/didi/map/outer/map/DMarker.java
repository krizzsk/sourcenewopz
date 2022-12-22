package com.didi.map.outer.map;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.map.alpha.maps.internal.IMarkerDelegate;
import com.didi.map.outer.map.DiMapInterface;
import com.didi.map.outer.map.DiMapInterface.IOnInfoWindowClickListener;
import com.didi.map.outer.map.DiMapInterface.IOnMarkerClickListener;
import com.didi.map.outer.map.DiMapInterface.IWindowAdapter;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.BaseMarkerOption;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;

public abstract class DMarker<T extends DiMapInterface.IWindowAdapter, V extends DiMapInterface.IOnMarkerClickListener, U extends DiMapInterface.IOnInfoWindowClickListener> implements IMapElement {
    public static final int INFO_WINDOW_TYPE_ANDROID_VIEW = 2;
    public static final int INFO_WINDOW_TYPE_MARKER = 1;
    protected static Handler sMainHandler = new Handler(Looper.getMainLooper());
    private boolean boShowInfo = false;
    private int mInfoWindowType = 1;
    private DidiMap.OnInfoWindowVisibleChangeListener mOnInfoWindowVisibleChangeListener;
    private String mTouchableContent = "";
    protected final IMarkerDelegate markerControl;
    private final BaseMarkerOption option;
    protected String strId = "";

    public abstract float getAnchorU();

    public abstract float getAnchorV();

    public abstract int getHeight(Context context);

    public abstract T getInfoWindowAdapter();

    public DidiMap.OnMarkerClickListener getOnClickListener() {
        return null;
    }

    public abstract U getOnInfoWindowClickListener();

    public abstract BaseMarkerOption getOptions();

    public abstract int getWidth(Context context);

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setInfoWindowAdapter(T t);

    public abstract void setOnClickListener(V v);

    public abstract void setOnInfoWindowClickListener(U u);

    public abstract void setPosition(LatLng latLng);

    public void setPositionNotUpdate(LatLng latLng) {
    }

    public abstract void setVisible(boolean z);

    public DMarker(BaseMarkerOption baseMarkerOption, IMarkerDelegate iMarkerDelegate, String str) {
        this.strId = str;
        this.option = baseMarkerOption;
        this.markerControl = iMarkerDelegate;
        this.mInfoWindowType = baseMarkerOption.getInfoWindowType();
    }

    public String getTouchableContent() {
        return this.mTouchableContent;
    }

    public void setTouchableContent(String str) {
        this.mTouchableContent = str;
        if (!TextUtils.isEmpty(str)) {
            this.markerControl.onSetTouchableContent(this);
        }
    }

    public String getId() {
        return this.strId;
    }

    public void setInfoWindowEnable(boolean z) {
        BaseMarkerOption baseMarkerOption;
        if (this.markerControl != null && (baseMarkerOption = this.option) != null) {
            baseMarkerOption.infoWindowEnable(z);
        }
    }

    public boolean isInfoWindowEnable() {
        BaseMarkerOption baseMarkerOption = this.option;
        if (baseMarkerOption == null) {
            return false;
        }
        return baseMarkerOption.isInfoWindowEnable();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r2.option;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.map.outer.model.LatLng getPosition() {
        /*
            r2 = this;
            com.didi.map.alpha.maps.internal.IMarkerDelegate r0 = r2.markerControl
            java.lang.String r1 = r2.strId
            com.didi.map.outer.model.LatLng r0 = r0.getPosition(r1)
            if (r0 != 0) goto L_0x0012
            com.didi.map.outer.model.BaseMarkerOption r1 = r2.option
            if (r1 == 0) goto L_0x0012
            com.didi.map.outer.model.LatLng r0 = r1.getPosition()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.outer.map.DMarker.getPosition():com.didi.map.outer.model.LatLng");
    }

    public float getAlpha() {
        BaseMarkerOption baseMarkerOption = this.option;
        if (baseMarkerOption == null) {
            return 0.0f;
        }
        return baseMarkerOption.getAlpha();
    }

    public void showInfoWindow() {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate != null && iMarkerDelegate.showInfoWindow(this.strId) && !this.boShowInfo) {
            this.boShowInfo = true;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.mOnInfoWindowVisibleChangeListener;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(true);
            }
        }
    }

    public void hideInfoWindow() {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate != null && iMarkerDelegate.hideInfoWindow(this.strId) && this.boShowInfo) {
            this.boShowInfo = false;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.mOnInfoWindowVisibleChangeListener;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(false);
            }
        }
    }

    public boolean isInfoWindowShown() {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isInfoWindowShown(this.strId);
    }

    public void setAlpha(float f) {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate != null && this.option != null) {
            iMarkerDelegate.setAlpha(this.strId, f);
            this.option.alpha(f);
        }
    }

    public void setClickable(boolean z) {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setClickable(this.strId, z);
        }
    }

    public boolean isClickable() {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isClickable(this.strId);
    }

    public void setZIndex(float f) {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate != null && this.option != null) {
            iMarkerDelegate.setZIndex(this.strId, f);
            this.option.zIndex(f);
        }
    }

    public void setOnInfoWindowVisibleChangeListener(DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener) {
        this.mOnInfoWindowVisibleChangeListener = onInfoWindowVisibleChangeListener;
    }

    public Rect getScreenRect() {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getScreenRect(this.strId);
    }

    public Rect getBound() {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate == null) {
            return new Rect();
        }
        return iMarkerDelegate.getBound(this.strId);
    }

    public RectF getPixel20Bound(float f) {
        IMarkerDelegate iMarkerDelegate = this.markerControl;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getPixel20Bound(this.strId, f);
    }

    public int getInfoWindowType() {
        return this.mInfoWindowType;
    }

    public String getTitle() {
        BaseMarkerOption baseMarkerOption = this.option;
        if (baseMarkerOption == null) {
            return "";
        }
        return baseMarkerOption.getTitle();
    }

    public String getSnippet() {
        BaseMarkerOption baseMarkerOption = this.option;
        if (baseMarkerOption == null) {
            return "";
        }
        return baseMarkerOption.getSnippet();
    }
}
