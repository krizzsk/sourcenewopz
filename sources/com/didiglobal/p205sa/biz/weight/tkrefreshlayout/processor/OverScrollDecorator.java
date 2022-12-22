package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.OverScrollDecorator */
public class OverScrollDecorator extends Decorator {

    /* renamed from: b */
    private static final int f51342b = 3000;

    /* renamed from: c */
    private static final int f51343c = 0;

    /* renamed from: d */
    private static final int f51344d = 1;

    /* renamed from: e */
    private static final int f51345e = 2;

    /* renamed from: g */
    private static final int f51346g = 60;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public float f51347a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f51348f = 0;

    /* renamed from: h */
    private boolean f51349h = false;

    /* renamed from: i */
    private boolean f51350i = false;

    /* renamed from: j */
    private boolean f51351j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f51352k = new Handler() {
        public void handleMessage(Message message) {
            int touchSlop = OverScrollDecorator.this.f51341cp.getTouchSlop();
            int i = message.what;
            if (i == 0) {
                int unused = OverScrollDecorator.this.f51348f = -1;
            } else if (i != 1) {
                if (i == 2) {
                    int unused2 = OverScrollDecorator.this.f51348f = 60;
                    return;
                }
                return;
            }
            OverScrollDecorator.m36768a(OverScrollDecorator.this);
            View targetView = OverScrollDecorator.this.f51341cp.getTargetView();
            if (OverScrollDecorator.this.f51341cp.allowOverScroll()) {
                if (OverScrollDecorator.this.f51347a >= 3000.0f) {
                    if (ScrollingUtil.isViewToTop(targetView, touchSlop)) {
                        OverScrollDecorator.this.f51341cp.getAnimProcessor().animOverScrollTop(OverScrollDecorator.this.f51347a, OverScrollDecorator.this.f51348f);
                        float unused3 = OverScrollDecorator.this.f51347a = 0.0f;
                        int unused4 = OverScrollDecorator.this.f51348f = 60;
                    }
                } else if (OverScrollDecorator.this.f51347a <= -3000.0f && ScrollingUtil.isViewToBottom(targetView, touchSlop)) {
                    OverScrollDecorator.this.f51341cp.getAnimProcessor().animOverScrollBottom(OverScrollDecorator.this.f51347a, OverScrollDecorator.this.f51348f);
                    float unused5 = OverScrollDecorator.this.f51347a = 0.0f;
                    int unused6 = OverScrollDecorator.this.f51348f = 60;
                }
            }
            if (OverScrollDecorator.this.f51348f < 60) {
                OverScrollDecorator.this.f51352k.sendEmptyMessageDelayed(1, 10);
            }
        }
    };

    /* renamed from: a */
    static /* synthetic */ int m36768a(OverScrollDecorator overScrollDecorator) {
        int i = overScrollDecorator.f51348f;
        overScrollDecorator.f51348f = i + 1;
        return i;
    }

    public OverScrollDecorator(TwinklingRefreshLayout.CoContext coContext, IDecorator iDecorator) {
        super(coContext, iDecorator);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.decorator != null && this.decorator.dispatchTouchEvent(motionEvent);
    }

    public boolean interceptTouchEvent(MotionEvent motionEvent) {
        return this.decorator != null && this.decorator.interceptTouchEvent(motionEvent);
    }

    public boolean dealTouchEvent(MotionEvent motionEvent) {
        return this.decorator != null && this.decorator.dealTouchEvent(motionEvent);
    }

    public void onFingerDown(MotionEvent motionEvent) {
        if (this.decorator != null) {
            this.decorator.onFingerDown(motionEvent);
        }
        this.f51349h = ScrollingUtil.isViewToTop(this.f51341cp.getTargetView(), this.f51341cp.getTouchSlop());
        this.f51350i = ScrollingUtil.isViewToBottom(this.f51341cp.getTargetView(), this.f51341cp.getTouchSlop());
    }

    public void onFingerUp(MotionEvent motionEvent, boolean z) {
        if (this.decorator != null) {
            this.decorator.onFingerUp(motionEvent, this.f51351j && z);
        }
        this.f51351j = false;
    }

    public void onFingerScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, float f3, float f4) {
        if (this.decorator != null) {
            this.decorator.onFingerScroll(motionEvent, motionEvent2, f, f2, f3, f4);
        }
    }

    public void onFingerFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.decorator != null) {
            this.decorator.onFingerFling(motionEvent, motionEvent2, f, f2);
        }
        if (this.f51341cp.enableOverScroll()) {
            int y = (int) (motionEvent2.getY() - motionEvent.getY());
            if (y < (-this.f51341cp.getTouchSlop()) && this.f51350i) {
                return;
            }
            if (y <= this.f51341cp.getTouchSlop() || !this.f51349h) {
                this.f51347a = f2;
                if (Math.abs(f2) >= 3000.0f) {
                    this.f51352k.sendEmptyMessage(0);
                    this.f51351j = true;
                    return;
                }
                this.f51347a = 0.0f;
                this.f51348f = 60;
            }
        }
    }
}
