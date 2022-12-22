package com.didi.payment.creditcard.global.widget;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import java.util.Calendar;

public abstract class NoDoubleClickListener implements View.OnClickListener {
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    public abstract void onNoDoubleClick(View view);

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.lastClickTime > 1000) {
            this.lastClickTime = timeInMillis;
            onNoDoubleClick(view);
        }
    }
}
