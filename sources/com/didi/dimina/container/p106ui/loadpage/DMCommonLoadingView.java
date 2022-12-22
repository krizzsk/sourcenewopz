package com.didi.dimina.container.p106ui.loadpage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.io.Serializable;

/* renamed from: com.didi.dimina.container.ui.loadpage.DMCommonLoadingView */
public abstract class DMCommonLoadingView extends FrameLayout implements Serializable {
    protected String title;

    /* access modifiers changed from: protected */
    public abstract void init(String str);

    private DMCommonLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private DMCommonLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMCommonLoadingView(Context context, String str) {
        super(context);
        init(str);
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
