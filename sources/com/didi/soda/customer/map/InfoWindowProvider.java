package com.didi.soda.customer.map;

import android.content.Context;
import com.didi.soda.customer.widget.map.BusinessMarkerView;

public final class InfoWindowProvider {
    private InfoWindowProvider() {
    }

    public static BusinessMarkerView createBusinessInfoWindow(Context context) {
        return new BusinessMarkerView(context);
    }
}
