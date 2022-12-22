package com.didi.map.global.component.departure.departure;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.canoe.CanoeDepartureView;

public class DepartureViewFactory {
    public static IDepartureView getView(int i, Map map, Context context, DepartureCompParams departureCompParams) {
        if (i == 3 || i == 4 || i == 5) {
            return new CanoeDepartureView(map, context, departureCompParams);
        }
        return new DepartureView(map, context, departureCompParams);
    }
}
