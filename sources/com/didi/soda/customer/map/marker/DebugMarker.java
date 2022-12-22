package com.didi.soda.customer.map.marker;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.foundation.sdk.map.IMapView;

public class DebugMarker extends AbsMarker {
    public static final String TAG_DEBUG_MARKER = "tag_debug_marker";

    /* renamed from: a */
    private MarkerOptions f41374a;

    public String getTag() {
        return TAG_DEBUG_MARKER;
    }

    public void show(LatLng latLng) {
    }

    public DebugMarker(Context context, IMapView iMapView) {
        super(context, iMapView);
    }
}
