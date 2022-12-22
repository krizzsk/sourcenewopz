package com.didi.component.common.util;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.Utils;

public abstract class OnAntiShakeClickListener implements View.OnClickListener {
    public abstract void onAntiShakeClick(View view);

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            onAntiShakeClick(view);
        }
    }
}
