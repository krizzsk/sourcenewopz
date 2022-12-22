package com.didi.common.map.model;

import android.content.Context;
import android.os.Bundle;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IMarkerDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.animation.Animation;
import com.didi.common.map.model.animation.AnimationListener;
import com.didi.common.map.model.infowindow.InfoWindowFactory;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public class Marker implements IMapElement {

    /* renamed from: a */
    MarkerSize f10859a = new MarkerSize();

    /* renamed from: b */
    private IMarkerDelegate f10860b;

    /* renamed from: c */
    private InfoWindow f10861c;

    /* renamed from: d */
    private boolean f10862d = false;

    /* renamed from: e */
    private float f10863e = 0.0f;

    /* renamed from: f */
    private Bundle f10864f;

    /* renamed from: g */
    private Object f10865g;

    public Marker(IMarkerDelegate iMarkerDelegate) {
        this.f10860b = iMarkerDelegate;
    }

    public void setEnableTopHeightInterval(boolean z) {
        this.f10862d = z;
    }

    public boolean getEnableTopHeightInterval() {
        return this.f10862d;
    }

    public void setTopHeightInterval(float f) {
        this.f10863e = f;
    }

    public float getTopHeightInterval() {
        return this.f10863e;
    }

    public boolean isDraggable() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isDraggable();
    }

    public void setDraggable(boolean z) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setDraggable(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setAnchor(f, f2);
            }
            if (this.f10861c != null) {
                this.f10861c.updateAnchor();
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean isFlat() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        return iMarkerDelegate != null && iMarkerDelegate.isFlat();
    }

    public void setFlat(boolean z) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setFlat(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public float getRotation() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return 0.0f;
        }
        return iMarkerDelegate.getRotation();
    }

    public void setRotation(float f) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setRotation(f);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public LatLng getPosition() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getPosition();
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            try {
                if (this.f10860b != null) {
                    this.f10860b.setPosition(latLng);
                    if (this.f10861c != null) {
                        this.f10861c.setPosition(latLng);
                    }
                }
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public String getSnippet() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        return iMarkerDelegate == null ? "" : iMarkerDelegate.getSnippet();
    }

    public void setSnippet(String str) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setSnippet(str);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public String getTitle() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        return iMarkerDelegate == null ? "" : iMarkerDelegate.getTitle();
    }

    public void setTitle(String str) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setTitle(str);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void hideInfoWindow() {
        try {
            if (this.f10861c != null) {
                this.f10861c.hideInfoWindow();
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            if (this.f10861c != null) {
                return this.f10861c.isInfoWindowShown();
            }
            return false;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return false;
        }
    }

    public BitmapDescriptor getIcon() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getIcon();
    }

    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setIcon(context, bitmapDescriptor);
            }
            if (this.f10861c != null) {
                this.f10861c.updateAnchor();
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public MarkerSize getMarkerSize() {
        BitmapDescriptor icon = getIcon();
        if (!(icon == null || icon.getBitmap() == null)) {
            this.f10859a.width = icon.getBitmap().getWidth();
            this.f10859a.height = icon.getBitmap().getHeight();
        }
        return this.f10859a;
    }

    public float getAlpha() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return 0.0f;
        }
        return iMarkerDelegate.getAlpha();
    }

    public void setAlpha(float f) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setAlpha(f);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        IMarkerDelegate iMarkerDelegate;
        if (iMapElementOptions != null && (iMarkerDelegate = this.f10860b) != null && (iMapElementOptions instanceof MarkerOptions)) {
            MarkerOptions markerOptions = (MarkerOptions) iMapElementOptions;
            try {
                iMarkerDelegate.setOptions(iMapElementOptions);
                if (this.f10861c != null && markerOptions.getPosition() != null) {
                    this.f10861c.setPosition(markerOptions.getPosition());
                }
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public MarkerOptions getOptions() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return (MarkerOptions) iMarkerDelegate.getOptions();
    }

    public String getId() {
        try {
            if (this.f10860b != null) {
                return this.f10860b.getId();
            }
            return null;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public void setZIndex(int i) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setZIndex(i);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public int getZIndex() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return 0;
        }
        return iMarkerDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setVisible(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean isVisible() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isVisible();
    }

    public boolean isClickable() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isClickable();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        try {
            if (this.f10860b != null) {
                this.f10860b.setAnimationListener(animationListener);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void startAnimation(Animation animation) {
        try {
            if (this.f10860b != null) {
                this.f10860b.startAnimation(animation);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Marker)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String id = getId();
        if (id == null) {
            return false;
        }
        return id.equals(((Marker) obj).getId());
    }

    public int hashCode() {
        String id = getId();
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    public String toString() {
        return "Marker [position[" + getPosition() + "]] ,id = " + getId();
    }

    public List<LatLng> getBounderPoints() {
        try {
            if (this.f10860b != null) {
                return this.f10860b.getBounderPoints();
            }
            return null;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public Object getElement() {
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getElement();
    }

    public void remove() {
        destroyInfoWindow();
        IMarkerDelegate iMarkerDelegate = this.f10860b;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.remove();
            this.f10860b = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f10864f = bundle;
    }

    public Bundle getBundle() {
        return this.f10864f;
    }

    public void setData(Object obj) {
        this.f10865g = obj;
    }

    public Object getData() {
        return this.f10865g;
    }

    public InfoWindow buildInfoWindow(Map map, Context context) {
        if (map == null || context == null) {
            return null;
        }
        if (this.f10861c == null) {
            this.f10861c = InfoWindowFactory.getInfowindow(map, context, this);
        }
        return this.f10861c;
    }

    public InfoWindow buildInfoWindow(Map map, Context context, InfoWindow.Position position) {
        if (map == null || context == null) {
            return null;
        }
        if (this.f10861c == null) {
            this.f10861c = InfoWindowFactory.getInfowindow(map, context, this);
        }
        return this.f10861c;
    }

    public InfoWindow getInfoWindow() {
        return this.f10861c;
    }

    public void destroyInfoWindow() {
        InfoWindow infoWindow = this.f10861c;
        if (infoWindow != null) {
            infoWindow.destroy();
            this.f10861c = null;
        }
    }

    public static class MarkerSize {
        public int height;
        public int width;

        public boolean isEmpty() {
            return this.width <= 0 || this.height <= 0;
        }
    }
}
