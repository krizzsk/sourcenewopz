package com.didi.common.map.adapter.didiadapter;

import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.IGroundOverlayDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.Marker;
import java.util.List;

public class GroundOverlayDelegate implements IGroundOverlayDelegate {

    /* renamed from: a */
    private Marker f10705a;

    /* renamed from: b */
    private GroundOverlayOptions f10706b;

    public List<LatLng> getBounderPoints() {
        return null;
    }

    public GroundOverlayDelegate(Marker marker, GroundOverlayOptions groundOverlayOptions) {
        this.f10705a = marker;
        this.f10706b = groundOverlayOptions;
    }

    public void position(LatLng latLng) {
        Marker marker;
        if (latLng != null && (marker = this.f10705a) != null) {
            marker.setPosition(Converter.convertToDidiLatLng(latLng));
            GroundOverlayOptions groundOverlayOptions = this.f10706b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.position(latLng, groundOverlayOptions.getWidth(), this.f10706b.getHeight());
            }
        }
    }

    public void position(LatLngBounds latLngBounds) {
        Marker marker;
        if (latLngBounds != null && (marker = this.f10705a) != null) {
            marker.setPosition(Converter.convertToDidiLatLng(latLngBounds.getCenter()));
            GroundOverlayOptions groundOverlayOptions = this.f10706b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.position(latLngBounds.getCenter(), this.f10706b.getWidth(), this.f10706b.getHeight());
            }
        }
    }

    public String getId() throws MapNotExistApiException {
        Marker marker = this.f10705a;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public void remove() throws MapNotExistApiException {
        Marker marker = this.f10705a;
        if (marker != null) {
            marker.remove();
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Marker marker = this.f10705a;
        if (marker != null) {
            marker.setZIndex((float) i);
        }
        GroundOverlayOptions groundOverlayOptions = this.f10706b;
        if (groundOverlayOptions != null) {
            groundOverlayOptions.zIndex(i);
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        GroundOverlayOptions groundOverlayOptions = this.f10706b;
        if (groundOverlayOptions != null) {
            return groundOverlayOptions.getZIndex();
        }
        return 0;
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Marker marker = this.f10705a;
        if (marker != null) {
            marker.setVisible(z);
        }
        GroundOverlayOptions groundOverlayOptions = this.f10706b;
        if (groundOverlayOptions != null) {
            groundOverlayOptions.visible(z);
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Marker marker = this.f10705a;
        if (marker != null) {
            return marker.isVisible();
        }
        return false;
    }

    public boolean isClickable() throws MapNotExistApiException {
        Marker marker = this.f10705a;
        if (marker != null) {
            return marker.isClickable();
        }
        return false;
    }

    public void setClickable(boolean z) {
        Marker marker = this.f10705a;
        if (marker != null) {
            marker.setClickable(z);
        }
        GroundOverlayOptions groundOverlayOptions = this.f10706b;
        if (groundOverlayOptions != null) {
            groundOverlayOptions.clickable(z);
        }
    }

    public Object getElement() {
        return this.f10705a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Marker marker = this.f10705a;
        if (marker != null && iMapElementOptions != null && (iMapElementOptions instanceof GroundOverlayOptions)) {
            GroundOverlayOptions groundOverlayOptions = (GroundOverlayOptions) iMapElementOptions;
            marker.setDirection((int) groundOverlayOptions.getBearing());
            this.f10705a.setClickable(groundOverlayOptions.isClickable());
            BitmapDescriptor convertToDidiBitmapDescriptor = Converter.convertToDidiBitmapDescriptor(groundOverlayOptions.getImage());
            if (convertToDidiBitmapDescriptor != null) {
                this.f10705a.setIcon(convertToDidiBitmapDescriptor);
            }
            if (groundOverlayOptions.getPosition() != null) {
                this.f10705a.setPosition(Converter.convertToDidiLatLng(groundOverlayOptions.getPosition()));
            }
            if (groundOverlayOptions.getBounds() != null) {
                this.f10705a.setPosition(Converter.convertToDidiLatLng(groundOverlayOptions.getBounds().getCenter()));
            }
            this.f10705a.setAlpha(groundOverlayOptions.getAlpha());
            this.f10705a.setVisible(groundOverlayOptions.isVisible());
            this.f10705a.setZIndex((float) groundOverlayOptions.getZIndex());
            this.f10706b = groundOverlayOptions;
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10706b;
    }
}
