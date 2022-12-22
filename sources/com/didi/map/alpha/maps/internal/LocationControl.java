package com.didi.map.alpha.maps.internal;

import android.location.Location;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.LocationSource;
import com.didi.map.outer.model.MyLocationOption;

public class LocationControl {
    ILocationDelegate locProvider;

    public LocationControl(ILocationDelegate iLocationDelegate) {
        this.locProvider = iLocationDelegate;
    }

    public void exit() {
        release();
        this.locProvider = null;
    }

    public final Location getMyLocation() {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            return iLocationDelegate.getMyLocation();
        }
        return null;
    }

    public final void setLocationSource(LocationSource locationSource) {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.setLocationSource(locationSource);
        }
    }

    public void release() {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.release();
        }
    }

    public void enableMylocation() {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.enableMylocation();
        }
    }

    public void enableMylocation(float f, float f2, float f3) {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.enableMylocation(f, f2, f3);
        }
    }

    public void disableMylocation() {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.disableMylocation();
        }
    }

    public boolean isProviderEnable() {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            return iLocationDelegate.isProviderEnable();
        }
        return false;
    }

    public void setOnMyLocationChangeListener(DidiMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.setOnMyLocationChangeListener(onMyLocationChangeListener);
        }
    }

    public void setMyLocationOption(MyLocationOption myLocationOption) {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.setMyLocationOption(myLocationOption);
        }
    }

    public void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3) {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            iLocationDelegate.setMyLocationOption(myLocationOption, f, f2, f3);
        }
    }

    public MyLocationOption getMyLocationOption() {
        ILocationDelegate iLocationDelegate = this.locProvider;
        if (iLocationDelegate != null) {
            return iLocationDelegate.getMyLocationOption();
        }
        return null;
    }
}
