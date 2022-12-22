package com.didi.beatles.p099im.common.widget;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.common.util.IMUtils;

/* renamed from: com.didi.beatles.im.common.widget.IMOnAntiShakeClickListener */
public abstract class IMOnAntiShakeClickListener implements View.OnClickListener {
    public abstract void onAntiShakeClick(View view);

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!IMUtils.isFastDoubleClick()) {
            onAntiShakeClick(view);
        }
    }
}
