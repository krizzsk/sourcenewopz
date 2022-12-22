package com.didi.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class NewSwitchBar extends View {

    /* renamed from: a */
    private boolean f34915a;

    public void init() {
    }

    public boolean isChecked() {
        return this.f34915a;
    }

    public void setChecked(boolean z) {
        this.f34915a = z;
    }

    public NewSwitchBar(Context context) {
        super(context);
        init();
    }

    public NewSwitchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
