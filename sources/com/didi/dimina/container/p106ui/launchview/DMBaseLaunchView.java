package com.didi.dimina.container.p106ui.launchview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.dimina.container.DMMina;
import java.io.Serializable;

/* renamed from: com.didi.dimina.container.ui.launchview.DMBaseLaunchView */
public class DMBaseLaunchView extends FrameLayout implements Serializable {
    private void init() {
    }

    private DMBaseLaunchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private DMBaseLaunchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMBaseLaunchView(Context context, DMMina dMMina) {
        super(context);
        init();
    }
}
