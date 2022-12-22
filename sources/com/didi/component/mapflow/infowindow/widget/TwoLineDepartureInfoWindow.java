package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import com.taxis99.R;

public class TwoLineDepartureInfoWindow extends DepartureInfoWindow {
    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_map_left_two_line_with_loading;
    }

    public TwoLineDepartureInfoWindow(Context context) {
        super(context);
    }
}
