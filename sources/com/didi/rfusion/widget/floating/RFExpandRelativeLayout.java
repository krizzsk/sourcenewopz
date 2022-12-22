package com.didi.rfusion.widget.floating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class RFExpandRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private OnGestureListener f33524a;

    public interface OnGestureListener {
        boolean dispatchTouchEvent(MotionEvent motionEvent);

        boolean onInterceptTouchEvent(MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m23595a(View view) {
    }

    public RFExpandRelativeLayout(Context context) {
        super(context);
    }

    public RFExpandRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFExpandRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnGestureListener onGestureListener = this.f33524a;
        if (onGestureListener == null || !onGestureListener.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnGestureListener onGestureListener = this.f33524a;
        if (onGestureListener == null || !onGestureListener.onInterceptTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnGestureListener onGestureListener = this.f33524a;
        if (onGestureListener == null || !onGestureListener.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        OnGestureListener onGestureListener = this.f33524a;
        if (onGestureListener != null) {
            onGestureListener.onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setGestureListener(OnGestureListener onGestureListener) {
        this.f33524a = onGestureListener;
        setOnClickListener($$Lambda$RFExpandRelativeLayout$3AGSti3J6euryE279kor4DtZzqY.INSTANCE);
    }
}
