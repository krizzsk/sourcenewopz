package com.didi.payment.base.widget;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class DoubleCheckOnClickListener implements View.OnClickListener {
    long lastClickTimestamp;
    private int waitTime;

    public abstract void doClick(View view);

    public DoubleCheckOnClickListener() {
        this(300);
    }

    public DoubleCheckOnClickListener(int i) {
        this.waitTime = 300;
        this.lastClickTimestamp = 0;
        if (i > 0) {
            this.waitTime = i;
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTimestamp >= ((long) this.waitTime)) {
            doClick(view);
            this.lastClickTimestamp = currentTimeMillis;
        }
    }
}
