package com.didi.global.globaluikit.popup;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

class LEGOPopup$1 implements View.OnClickListener {
    final /* synthetic */ C8665a this$0;

    LEGOPopup$1(C8665a aVar) {
        this.this$0 = aVar;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.dismiss();
    }
}
