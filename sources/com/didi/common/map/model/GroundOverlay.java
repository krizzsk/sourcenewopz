package com.didi.common.map.model;

import android.os.Bundle;
import com.didi.common.map.internal.IGroundOverlayDelegate;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public class GroundOverlay implements IMapElement {

    /* renamed from: a */
    private IGroundOverlayDelegate f10814a;

    /* renamed from: b */
    private Bundle f10815b;

    /* renamed from: c */
    private Object f10816c;

    public GroundOverlay(IGroundOverlayDelegate iGroundOverlayDelegate) {
        this.f10814a = iGroundOverlayDelegate;
    }

    public void remove() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.remove();
            this.f10814a = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f10815b = bundle;
    }

    public Bundle getBundle() {
        return this.f10815b;
    }

    public void setData(Object obj) {
        this.f10816c = obj;
    }

    public Object getData() {
        return this.f10816c;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        try {
            if (this.f10814a != null) {
                this.f10814a.setOptions(iMapElementOptions);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
        }
    }

    public IMapElementOptions getOptions() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getOptions();
    }

    public String getId() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getId();
    }

    public void setZIndex(int i) {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.setZIndex(i);
        }
    }

    public int getZIndex() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return 0;
        }
        return iGroundOverlayDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.setVisible(z);
        }
    }

    public void setClickable(boolean z) {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.setClickable(z);
        }
    }

    public boolean isVisible() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return false;
        }
        return iGroundOverlayDelegate.isVisible();
    }

    public boolean isClickable() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return false;
        }
        return iGroundOverlayDelegate.isClickable();
    }

    public List<LatLng> getBounderPoints() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getBounderPoints();
    }

    public Object getElement() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f10814a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getElement();
    }
}
