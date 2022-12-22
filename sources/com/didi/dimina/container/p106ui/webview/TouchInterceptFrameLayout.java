package com.didi.dimina.container.p106ui.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.didi.dimina.container.util.SnapShotUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.dimina.container.ui.webview.TouchInterceptFrameLayout */
public class TouchInterceptFrameLayout extends FrameLayout {

    /* renamed from: a */
    private boolean f17869a;

    /* renamed from: b */
    private CopyOnWriteArrayList<TouchInterceptFrame> f17870b;

    /* renamed from: c */
    private boolean f17871c;

    public TouchInterceptFrameLayout(Context context) {
        super(context);
        m13371a();
    }

    public TouchInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13371a();
    }

    public TouchInterceptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13371a();
    }

    public void setInterceptEnabled(boolean z) {
        this.f17869a = z;
    }

    /* renamed from: a */
    private void m13371a() {
        this.f17869a = false;
        this.f17871c = false;
        this.f17870b = new CopyOnWriteArrayList<>();
    }

    public void updateInterceptFrame(Map<String, List<TouchInterceptFrame>> map) {
        this.f17870b = new CopyOnWriteArrayList<>();
        for (List<TouchInterceptFrame> addAll : map.values()) {
            this.f17870b.addAll(addAll);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (SnapShotUtil.getInstance().isNeedInterceptSnapshot()) {
            SnapShotUtil.getInstance().stopTimingSaveSnapshot();
        }
        if (!this.f17869a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0 && motionEvent.getPointerId(motionEvent.getActionIndex()) == 0) {
            this.f17871c = true;
            Iterator<TouchInterceptFrame> it = this.f17870b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TouchInterceptFrame next = it.next();
                if (next != null && ((float) next.f17867x) < motionEvent.getX() && motionEvent.getX() < ((float) (next.f17867x + next.width)) && ((float) next.f17868y) < motionEvent.getY() && motionEvent.getY() < ((float) (next.f17868y + next.height))) {
                    this.f17871c = false;
                    break;
                }
            }
        }
        if (!this.f17871c) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
