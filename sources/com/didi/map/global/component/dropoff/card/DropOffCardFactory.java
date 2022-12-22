package com.didi.map.global.component.dropoff.card;

import android.content.Context;

public class DropOffCardFactory {
    public static IDropOffCard getCardView(Context context, int i) {
        return new DropOffConfirmCardView(context);
    }
}
