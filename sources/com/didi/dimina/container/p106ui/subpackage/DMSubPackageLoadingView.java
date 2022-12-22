package com.didi.dimina.container.p106ui.subpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.io.Serializable;

/* renamed from: com.didi.dimina.container.ui.subpackage.DMSubPackageLoadingView */
public abstract class DMSubPackageLoadingView extends FrameLayout implements Serializable {
    /* access modifiers changed from: protected */
    public abstract void init();

    private DMSubPackageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private DMSubPackageLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DMSubPackageLoadingView(Context context) {
        super(context);
        init();
    }
}
