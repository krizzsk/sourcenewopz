package com.didi.map.outer.map;

import android.location.Location;

public interface LocationSource {

    public interface OnLocationChangedListener {
        void onAngleChanged(float f);

        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
