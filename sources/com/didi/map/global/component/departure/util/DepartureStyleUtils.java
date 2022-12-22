package com.didi.map.global.component.departure.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.pin.PinView;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.taxis99.R;

public class DepartureStyleUtils {
    public static RecPointStyle getPinRecStyle(Context context, DepartureCompParams departureCompParams) {
        if (departureCompParams.getRecStyle() == null) {
            return m18105a(context);
        }
        RecPointStyle recStyle = departureCompParams.getRecStyle();
        if (departureCompParams.getRecStyle().icon == null) {
            if (departureCompParams.getRecStyle().defaultStyle != 2) {
                recStyle.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_icon_rec);
                recStyle.selectedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_icon_rec);
            } else {
                recStyle.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_input_icon_destination);
                recStyle.selectedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_input_icon_destination);
            }
        }
        if (recStyle.selectedIcon == null) {
            recStyle.selectedIcon = recStyle.icon;
        }
        return recStyle;
    }

    /* renamed from: a */
    private static RecPointStyle m18105a(Context context) {
        RecPointStyle recPointStyle = new RecPointStyle();
        recPointStyle.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_icon_rec);
        recPointStyle.selectedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_icon_rec);
        return recPointStyle;
    }

    public static PinStyle getPinStyle(DepartureCompParams departureCompParams) {
        PinStyle pinStyle;
        if (departureCompParams.getPinStyle() == null) {
            pinStyle = new PinStyle();
        } else {
            pinStyle = departureCompParams.getPinStyle();
        }
        if (pinStyle.pinNormalColor == 0) {
            pinStyle.pinNormalColor = PinView.DEFAULT_COLOR;
            pinStyle.pintNoParkingColor = PinView.NO_PARKING_COLOR;
            pinStyle.rectVisible = false;
        }
        return pinStyle;
    }
}
