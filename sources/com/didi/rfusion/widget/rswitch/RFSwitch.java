package com.didi.rfusion.widget.rswitch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import com.taxis99.R;

public class RFSwitch extends SwitchCompat {
    public RFSwitch(Context context) {
        super(new ContextThemeWrapper(context, R.style.rf_switch));
        m23720a();
    }

    public RFSwitch(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.rf_switch), attributeSet);
        m23720a();
    }

    public RFSwitch(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.rf_switch), attributeSet, i);
        m23720a();
    }

    /* renamed from: a */
    private void m23720a() {
        setThumbResource(R.drawable.rf_selector_switch_thumb);
        setTrackResource(R.drawable.rf_layer_switch_track);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.5f);
    }
}
