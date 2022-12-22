package com.didi.payment.base.widget;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class FastCheckOnClickListener implements View.OnClickListener {
    long lastClickTime;
    long waitTime;

    public abstract void doClick(View view);

    public FastCheckOnClickListener() {
        this(300);
    }

    public FastCheckOnClickListener(int i) {
        this.waitTime = 300;
        this.lastClickTime = -1;
        if (i > 0) {
            this.waitTime = (long) i;
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (System.currentTimeMillis() - this.lastClickTime >= this.waitTime) {
            this.lastClickTime = System.currentTimeMillis();
            doClick(view);
        }
    }
}
