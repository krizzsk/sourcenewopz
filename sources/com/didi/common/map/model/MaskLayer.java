package com.didi.common.map.model;

import android.os.Bundle;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IMaskLayerDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.model.throwable.MapRuntimeException;
import java.util.List;

@Deprecated
public final class MaskLayer implements IMapElement {

    /* renamed from: a */
    private IMaskLayerDelegate f10881a;

    /* renamed from: b */
    private MaskLayerOptions f10882b;

    /* renamed from: c */
    private Bundle f10883c;

    /* renamed from: d */
    private Object f10884d;

    public List<LatLng> getBounderPoints() {
        return null;
    }

    public MaskLayer(IMaskLayerDelegate iMaskLayerDelegate) {
        this.f10881a = iMaskLayerDelegate;
    }

    public void remove(long j) {
        IMaskLayerDelegate iMaskLayerDelegate = this.f10881a;
        if (iMaskLayerDelegate != null) {
            try {
                iMaskLayerDelegate.remove(j);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        if (iMapElementOptions instanceof MaskLayerOptions) {
            try {
                if (this.f10881a != null) {
                    this.f10881a.setMaskLayerOptions((MaskLayerOptions) iMapElementOptions);
                }
                this.f10882b = (MaskLayerOptions) iMapElementOptions;
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public MaskLayerOptions getOptions() {
        return this.f10882b;
    }

    public String getId() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f10881a;
        if (iMaskLayerDelegate == null) {
            return "";
        }
        try {
            return iMaskLayerDelegate.getId();
        } catch (MapNotExistApiException e) {
            throw new MapRuntimeException((Exception) e);
        }
    }

    public void setZIndex(int i) {
        try {
            if (this.f10881a != null) {
                this.f10881a.setZIndex(i);
            }
            if (this.f10882b != null) {
                this.f10882b.zIndex(i);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
        }
    }

    public int getZIndex() {
        MaskLayerOptions maskLayerOptions = this.f10882b;
        if (maskLayerOptions == null) {
            return 0;
        }
        return maskLayerOptions.getZIndex();
    }

    public void setVisible(boolean z) {
        try {
            if (this.f10881a != null) {
                this.f10881a.setVisible(z);
            }
            if (this.f10882b != null) {
                this.f10882b.visible(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
        }
    }

    public boolean isVisible() {
        MaskLayerOptions maskLayerOptions = this.f10882b;
        if (maskLayerOptions == null) {
            return false;
        }
        return maskLayerOptions.isVisible();
    }

    public boolean isClickable() {
        MaskLayerOptions maskLayerOptions = this.f10882b;
        if (maskLayerOptions == null) {
            return false;
        }
        return maskLayerOptions.isClickable();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MaskLayer)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String id = getId();
        if (id == null) {
            return false;
        }
        return id.equals(((MaskLayer) obj).getId());
    }

    public int hashCode() {
        String id = getId();
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    public Object getElement() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f10881a;
        if (iMaskLayerDelegate == null) {
            return null;
        }
        return iMaskLayerDelegate.getElement();
    }

    public void remove() {
        IMaskLayerDelegate iMaskLayerDelegate = this.f10881a;
        if (iMaskLayerDelegate != null) {
            iMaskLayerDelegate.remove();
            this.f10881a = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f10883c = bundle;
    }

    public Bundle getBundle() {
        return this.f10883c;
    }

    public void setData(Object obj) {
        this.f10884d = obj;
    }

    public Object getData() {
        return this.f10884d;
    }
}
