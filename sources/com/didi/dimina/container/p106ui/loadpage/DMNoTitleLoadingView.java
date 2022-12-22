package com.didi.dimina.container.p106ui.loadpage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.io.Serializable;

/* renamed from: com.didi.dimina.container.ui.loadpage.DMNoTitleLoadingView */
public abstract class DMNoTitleLoadingView extends FrameLayout implements Serializable {
    private DMNoTitleLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private DMNoTitleLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMNoTitleLoadingView(Context context) {
        super(context);
    }
}
