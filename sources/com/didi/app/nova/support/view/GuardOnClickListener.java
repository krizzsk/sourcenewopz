package com.didi.app.nova.support.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class GuardOnClickListener implements View.OnClickListener {

    /* renamed from: a */
    static boolean f8547a = true;

    /* renamed from: b */
    private static final Runnable f8548b = new Runnable() {
        public void run() {
            GuardOnClickListener.f8547a = true;
        }
    };

    public abstract void doClick(View view);

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (f8547a) {
            f8547a = false;
            view.post(f8548b);
            doClick(view);
        }
    }
}
