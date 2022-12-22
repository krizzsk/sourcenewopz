package com.didi.component.common.widget.loading;

import android.content.Context;
import com.didi.global.globalgenerickit.drawer.GGKAbsDrawer;
import com.taxis99.R;

public class NewPopUpLoadingBar extends GGKAbsDrawer {
    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.loading_pop_up;
    }

    public NewPopUpLoadingBar(Context context) {
        super(context);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        setBackPressedEnabled(false);
        return true;
    }
}
