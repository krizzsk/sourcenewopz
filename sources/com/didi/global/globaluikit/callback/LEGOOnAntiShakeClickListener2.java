package com.didi.global.globaluikit.callback;

import android.view.View;
import com.didi.global.globaluikit.drawer.LEGODrawer;

public abstract class LEGOOnAntiShakeClickListener2 extends LEGOOnAntiShakeClickListener {
    public final void onAntiShakeClick(View view) {
    }

    public abstract void onClickInDrawer(LEGODrawer lEGODrawer);

    public void onClick(LEGODrawer lEGODrawer) {
        if (!isFastDoubleClick()) {
            onClickInDrawer(lEGODrawer);
        }
    }
}
