package com.didi.map.global.component.dropoff.card;

import android.content.Context;
import com.didi.map.global.component.dropoff.model.DropOffAddress;

public interface IDropOffCard {

    public interface DropOffCardCallback {
        void onCardItemClick(int i);
    }

    void init(Context context);

    void onDataLoading();

    void updateCard(DropOffAddress dropOffAddress);
}
