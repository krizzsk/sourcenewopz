package com.didi.common.map.adapter.googlemapadapter;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.IGroundOverlayDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.List;

public class GroundOverlayDelegate implements IGroundOverlayDelegate {

    /* renamed from: a */
    private GroundOverlay f10763a;

    /* renamed from: b */
    private GroundOverlayOptions f10764b;

    public GroundOverlayDelegate(GroundOverlay groundOverlay, GroundOverlayOptions groundOverlayOptions) {
        this.f10763a = groundOverlay;
        this.f10764b = groundOverlayOptions;
    }

    public void remove() {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay != null) {
            groundOverlay.remove();
            this.f10763a = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay != null) {
            groundOverlay.setZIndex((float) i);
            GroundOverlayOptions groundOverlayOptions = this.f10764b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay == null) {
            return 0;
        }
        return (int) groundOverlay.getZIndex();
    }

    public void setVisible(boolean z) {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay != null) {
            groundOverlay.setVisible(z);
            GroundOverlayOptions groundOverlayOptions = this.f10764b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay == null) {
            return false;
        }
        return groundOverlay.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay == null) {
            return false;
        }
        return groundOverlay.isClickable();
    }

    public Object getElement() {
        return this.f10763a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay != null && iMapElementOptions != null && (iMapElementOptions instanceof GroundOverlayOptions)) {
            GroundOverlayOptions groundOverlayOptions = (GroundOverlayOptions) iMapElementOptions;
            groundOverlay.setBearing(groundOverlayOptions.getBearing());
            this.f10763a.setClickable(groundOverlayOptions.isClickable());
            BitmapDescriptor convertToGoogleBitmapDescriptor = Converter.convertToGoogleBitmapDescriptor(groundOverlayOptions.getImage());
            if (convertToGoogleBitmapDescriptor != null) {
                this.f10763a.setImage(convertToGoogleBitmapDescriptor);
            }
            if (groundOverlayOptions.getPosition() != null) {
                this.f10763a.setPosition(Converter.convertToGoogleLatLng(groundOverlayOptions.getPosition()));
            }
            if (groundOverlayOptions.getBounds() != null) {
                this.f10763a.setPositionFromBounds(Converter.convertToGoogleLatLngBounds(groundOverlayOptions.getBounds()));
            }
            this.f10763a.setTransparency(groundOverlayOptions.getAlpha());
            this.f10763a.setVisible(groundOverlayOptions.isVisible());
            GroundOverlayOptions groundOverlayOptions2 = this.f10764b;
            if (groundOverlayOptions2 == null) {
                this.f10763a.setZIndex((float) groundOverlayOptions.getZIndex());
            } else if (groundOverlayOptions2.getZIndex() != groundOverlayOptions.getZIndex()) {
                this.f10763a.setZIndex((float) groundOverlayOptions.getZIndex());
            }
            this.f10764b = groundOverlayOptions;
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10764b;
    }

    public void setClickable(boolean z) {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay != null) {
            groundOverlay.setClickable(z);
            GroundOverlayOptions groundOverlayOptions = this.f10764b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.clickable(z);
            }
        }
    }

    public void position(LatLng latLng) {
        GroundOverlay groundOverlay;
        if (latLng != null && (groundOverlay = this.f10763a) != null) {
            groundOverlay.setPosition(Converter.convertToGoogleLatLng(latLng));
            GroundOverlayOptions groundOverlayOptions = this.f10764b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.position(latLng, groundOverlayOptions.getWidth(), this.f10764b.getHeight());
            }
        }
    }

    public void position(LatLngBounds latLngBounds) {
        GroundOverlay groundOverlay;
        if (latLngBounds != null && (groundOverlay = this.f10763a) != null) {
            groundOverlay.setPositionFromBounds(Converter.convertToGoogleLatLngBounds(latLngBounds));
            GroundOverlayOptions groundOverlayOptions = this.f10764b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.position(latLngBounds);
            }
        }
    }

    public String getId() {
        GroundOverlay groundOverlay = this.f10763a;
        return groundOverlay == null ? "" : groundOverlay.getId();
    }

    public List<LatLng> getBounderPoints() {
        GroundOverlay groundOverlay = this.f10763a;
        if (groundOverlay == null || groundOverlay.getBounds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Converter.convertFromGoogleLatLng(this.f10763a.getBounds().northeast));
        arrayList.add(Converter.convertFromGoogleLatLng(this.f10763a.getBounds().southwest));
        arrayList.add(Converter.convertFromGoogleLatLng(this.f10763a.getBounds().getCenter()));
        return arrayList;
    }
}
