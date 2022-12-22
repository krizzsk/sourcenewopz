package com.didi.beatles.p099im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* renamed from: com.didi.beatles.im.views.IMInterceptEventLinearLayout */
public class IMInterceptEventLinearLayout extends LinearLayout {

    /* renamed from: b */
    private static final int f9884b = 8;

    /* renamed from: f */
    private static final int f9885f = 90;

    /* renamed from: g */
    private static final int f9886g = 120;

    /* renamed from: a */
    private float f9887a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SlideListener f9888c;

    /* renamed from: d */
    private GestureDetector f9889d;

    /* renamed from: e */
    private Context f9890e;

    /* renamed from: h */
    private InterceptCallback f9891h;

    /* renamed from: i */
    private long f9892i;

    /* renamed from: com.didi.beatles.im.views.IMInterceptEventLinearLayout$InterceptCallback */
    public interface InterceptCallback {
        boolean shouldIntercept();
    }

    /* renamed from: com.didi.beatles.im.views.IMInterceptEventLinearLayout$SlideListener */
    public interface SlideListener {
        void onSlideDown();

        void onSlideUp();
    }

    public IMInterceptEventLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMInterceptEventLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMInterceptEventLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9890e = context;
        m6686a();
    }

    public void setSlideListener(SlideListener slideListener) {
        this.f9888c = slideListener;
    }

    /* renamed from: a */
    private void m6686a() {
        this.f9889d = new GestureDetector(this.f9890e, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (motionEvent.getY() - motionEvent2.getY() <= 90.0f || Math.abs(f2) <= 120.0f || IMInterceptEventLinearLayout.this.f9888c == null) {
                    return true;
                }
                IMInterceptEventLinearLayout.this.f9888c.onSlideUp();
                return true;
            }
        });
    }

    public void registerInterceptListener(InterceptCallback interceptCallback) {
        this.f9891h = interceptCallback;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9887a = motionEvent.getY();
            this.f9889d.onTouchEvent(motionEvent);
        } else if (action == 2 && motionEvent.getDownTime() != this.f9892i) {
            InterceptCallback interceptCallback = this.f9891h;
            if (interceptCallback != null && !interceptCallback.shouldIntercept()) {
                this.f9892i = motionEvent.getDownTime();
            } else if (this.f9887a - motionEvent.getY() > 8.0f) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f9889d.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
