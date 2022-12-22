package com.didi.soda.bill.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class CustomerHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a */
    private static final int f39291a = 1;

    /* renamed from: b */
    private static final int f39292b = 80;

    /* renamed from: c */
    private final Handler f39293c = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        private int mLastY = Integer.MIN_VALUE;

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            int scrollY = CustomerHorizontalScrollView.this.getScrollY();
            if (CustomerHorizontalScrollView.this.f39295e || this.mLastY != scrollY) {
                this.mLastY = scrollY;
                CustomerHorizontalScrollView.this.m27838a();
            } else {
                this.mLastY = Integer.MIN_VALUE;
                CustomerHorizontalScrollView.this.setScrollState(0);
            }
            return true;
        }
    });

    /* renamed from: d */
    private OnScrollChangeListener f39294d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f39295e = false;

    /* renamed from: f */
    private int f39296f = 0;

    public interface OnScrollChangeListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollChanged(int i, int i2, int i3, int i4);

        void onScrollStateChanged(HorizontalScrollView horizontalScrollView, int i);
    }

    public CustomerHorizontalScrollView(Context context) {
        super(context);
    }

    public CustomerHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void recycle() {
        this.f39293c.removeMessages(1);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.f39294d = onScrollChangeListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m27839a(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m27842b(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f39295e) {
            setScrollState(1);
        } else {
            setScrollState(2);
            m27838a();
        }
        OnScrollChangeListener onScrollChangeListener = this.f39294d;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    private void m27839a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f39295e = true;
        }
    }

    /* renamed from: b */
    private void m27842b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.f39295e = false;
            m27838a();
        }
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f39296f != i) {
            this.f39296f = i;
            OnScrollChangeListener onScrollChangeListener = this.f39294d;
            if (onScrollChangeListener != null) {
                onScrollChangeListener.onScrollStateChanged(this, i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27838a() {
        this.f39293c.removeMessages(1);
        this.f39293c.sendEmptyMessageDelayed(1, 80);
    }
}
