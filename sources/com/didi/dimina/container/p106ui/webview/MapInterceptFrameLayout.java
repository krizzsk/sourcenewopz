package com.didi.dimina.container.p106ui.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* renamed from: com.didi.dimina.container.ui.webview.MapInterceptFrameLayout */
public class MapInterceptFrameLayout extends FrameLayout {

    /* renamed from: a */
    private boolean f17865a;

    public MapInterceptFrameLayout(Context context) {
        super(context);
    }

    public MapInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MapInterceptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setInterceptEnabled(boolean z) {
        this.f17865a = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f17865a) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
