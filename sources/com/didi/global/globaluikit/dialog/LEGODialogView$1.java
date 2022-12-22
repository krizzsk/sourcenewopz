package com.didi.global.globaluikit.dialog;

import android.widget.CompoundButton;
import com.didi.autotracker.AutoTrackHelper;

class LEGODialogView$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ C8649a this$0;

    LEGODialogView$1(C8649a aVar) {
        this.this$0 = aVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AutoTrackHelper.trackViewOnClick(compoundButton, z);
        this.this$0.f22495a.mIsChecked = z;
        this.this$0.f22495a.mCheckListener.onCheckedChanged(z);
    }
}
