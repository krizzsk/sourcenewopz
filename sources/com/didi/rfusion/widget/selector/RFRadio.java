package com.didi.rfusion.widget.selector;

import android.content.Context;
import android.util.AttributeSet;
import com.taxis99.R;

public class RFRadio extends RFSelectorButton {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo88125a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getCheckedIcon() {
        return R.string.rf_icon_radio;
    }

    /* access modifiers changed from: protected */
    public int getUnCheckedIcon() {
        return R.string.rf_icon_radio_line;
    }

    public RFRadio(Context context) {
        super(context);
    }

    public RFRadio(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFRadio(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void toggle() {
        if (!isChecked()) {
            super.toggle();
        }
    }
}
