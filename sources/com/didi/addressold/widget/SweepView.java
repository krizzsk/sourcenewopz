package com.didi.addressold.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

public class SweepView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static String f8088l = "ignore_id_for_sweep_list_view";

    /* renamed from: o */
    private static final String f8089o = "com.sdk.address.didi.map.joey.SweepView.close_expand_list_view_action";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f8090a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f8091b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f8092c;

    /* renamed from: d */
    private ViewDragHelper f8093d;

    /* renamed from: e */
    private int f8094e;

    /* renamed from: f */
    private int f8095f;

    /* renamed from: g */
    private OnSwipeStatusListener f8096g;

    /* renamed from: h */
    private Status f8097h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f8098i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f8099j;

    /* renamed from: k */
    private boolean f8100k;

    /* renamed from: m */
    private ViewDragHelper.Callback f8101m;

    /* renamed from: n */
    private Status f8102n;

    /* renamed from: p */
    private CloseExpandReceiver f8103p;

    public interface OnSwipeStatusListener {
        void onStartCloseAnimation();

        void onStartOpenAnimation();

        void onStatusChanged(Status status);
    }

    public enum Status {
        Open,
        Close
    }

    public void setStatus(Status status, boolean z) {
        this.f8097h = status;
        if (status == Status.Open) {
            m5259b(z);
        } else {
            m5254a(z);
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5250a(Context context) {
        closeByObject(context, new int[]{hashCode()});
    }

    public static void closeByObject(Context context, int[] iArr) {
        Intent intent = new Intent();
        intent.setAction(f8089o);
        intent.putExtra(f8088l, iArr);
        context.sendBroadcast(intent);
    }

    private class CloseExpandReceiver extends BroadcastReceiver {
        private final int hashCode;

        public CloseExpandReceiver(int i) {
            this.hashCode = i;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = !belongToIgnore(this.hashCode, intent.getIntArrayExtra(SweepView.f8088l));
            if (SweepView.this.isOpen() && z) {
                SweepView sweepView = SweepView.this;
                sweepView.m5254a(sweepView.f8098i);
            }
        }

        private boolean belongToIgnore(int i, int[] iArr) {
            if (iArr != null && iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean isOpen() {
        return this.f8097h == Status.Open;
    }

    public void setOnSwipeStatusListener(OnSwipeStatusListener onSwipeStatusListener) {
        this.f8096g = onSwipeStatusListener;
    }

    public void setDragClickListener(View.OnClickListener onClickListener) {
        View view = this.f8091b;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSmooth(boolean z) {
        this.f8098i = z;
    }

    public SweepView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SweepView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8097h = Status.Close;
        this.f8098i = true;
        this.f8099j = false;
        this.f8100k = false;
        this.f8101m = new ViewDragHelper.Callback() {
            public boolean tryCaptureView(View view, int i) {
                SweepView sweepView = SweepView.this;
                sweepView.m5250a(sweepView.getContext());
                return view == SweepView.this.f8091b;
            }

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                if (view != SweepView.this.f8091b || i > 0) {
                    return 0;
                }
                return Math.max(i, -SweepView.this.f8092c);
            }

            public int getViewHorizontalDragRange(View view) {
                return SweepView.this.f8092c;
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                if (SweepView.this.f8099j && SweepView.this.f8091b == view) {
                    SweepView.this.f8090a.offsetLeftAndRight(i3);
                }
                SweepView.this.invalidate();
            }

            public void onViewReleased(View view, float f, float f2) {
                if (view != SweepView.this.f8091b) {
                    return;
                }
                if (f == 0.0f && ((float) Math.abs(SweepView.this.f8091b.getLeft())) > ((float) SweepView.this.f8092c) / 2.0f) {
                    SweepView sweepView = SweepView.this;
                    sweepView.m5259b(sweepView.f8098i);
                } else if (f < 0.0f) {
                    SweepView sweepView2 = SweepView.this;
                    sweepView2.m5259b(sweepView2.f8098i);
                } else {
                    SweepView sweepView3 = SweepView.this;
                    sweepView3.m5254a(sweepView3.f8098i);
                }
            }
        };
        this.f8102n = Status.Close;
        this.f8093d = ViewDragHelper.create(this, this.f8101m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5254a(boolean z) {
        if (this.f8100k) {
            this.f8102n = this.f8097h;
            Status status = Status.Close;
            this.f8097h = status;
            if (!z) {
                m5251a(status);
            } else if (this.f8093d.smoothSlideViewTo(this.f8091b, 0, 0)) {
                OnSwipeStatusListener onSwipeStatusListener = this.f8096g;
                if (onSwipeStatusListener != null) {
                    onSwipeStatusListener.onStartCloseAnimation();
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
            if (this.f8096g != null && this.f8102n == Status.Open) {
                this.f8096g.onStatusChanged(this.f8097h);
            }
        }
    }

    /* renamed from: a */
    private void m5251a(Status status) {
        if (status == Status.Close) {
            if (this.f8099j) {
                View view = this.f8090a;
                int i = this.f8094e;
                view.layout(i, 0, this.f8092c + i, this.f8095f);
            } else {
                View view2 = this.f8090a;
                int i2 = this.f8094e;
                view2.layout(i2 - this.f8092c, 0, i2, this.f8095f);
            }
            this.f8091b.layout(0, 0, this.f8094e, this.f8095f);
            return;
        }
        View view3 = this.f8090a;
        int i3 = this.f8094e;
        view3.layout(i3 - this.f8092c, 0, i3, this.f8095f);
        View view4 = this.f8091b;
        int i4 = this.f8092c;
        view4.layout(-i4, 0, this.f8094e - i4, this.f8095f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5259b(boolean z) {
        if (this.f8100k) {
            this.f8102n = this.f8097h;
            Status status = Status.Open;
            this.f8097h = status;
            if (!z) {
                m5251a(status);
            } else if (this.f8093d.smoothSlideViewTo(this.f8091b, -this.f8092c, 0)) {
                OnSwipeStatusListener onSwipeStatusListener = this.f8096g;
                if (onSwipeStatusListener != null) {
                    onSwipeStatusListener.onStartOpenAnimation();
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
            if (this.f8096g != null && this.f8102n == Status.Close) {
                this.f8096g.onStatusChanged(this.f8097h);
            }
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f8100k && this.f8093d.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 3) {
            return this.f8100k ? this.f8093d.shouldInterceptTouchEvent(motionEvent) : super.onInterceptTouchEvent(motionEvent);
        }
        this.f8093d.cancel();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (this.f8100k && (viewDragHelper = this.f8093d) != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandable(boolean z) {
        this.f8100k = z;
        m5257b();
        if (z) {
            IntentFilter intentFilter = new IntentFilter(f8089o);
            this.f8103p = new CloseExpandReceiver(hashCode());
            try {
                getContext().registerReceiver(this.f8103p, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8090a = getChildAt(0);
        this.f8091b = getChildAt(1);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m5257b();
    }

    /* renamed from: b */
    private void m5257b() {
        if (this.f8103p != null) {
            try {
                getContext().unregisterReceiver(this.f8103p);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f8103p = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8094e = this.f8091b.getMeasuredWidth();
        this.f8095f = this.f8091b.getMeasuredHeight();
        this.f8092c = this.f8090a.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m5251a(Status.Close);
    }
}
