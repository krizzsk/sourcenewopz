package com.didi.global.map.animation.anim;

import android.content.Context;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.util.AngleManager;
import com.didi.global.map.animation.util.FramesUtil;
import com.didi.global.map.animation.util.LogUtil;

public class BoxAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f22700a;

    /* renamed from: b */
    private Marker f22701b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f22702c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f22703d;

    /* renamed from: e */
    private FrameAnim f22704e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameAnim f22705f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f22706g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnBoxAnimEndCallback f22707h;

    public BoxAnim(Context context, Marker marker) {
        this.f22700a = context;
        this.f22701b = marker;
    }

    public boolean isRunning() {
        return this.f22706g;
    }

    public void setOnBoxAnimEndCallback(OnBoxAnimEndCallback onBoxAnimEndCallback) {
        this.f22707h = onBoxAnimEndCallback;
    }

    public void doBoxAnim() {
        if (this.f22701b == null) {
            LogUtil.m16428e("doBoxAnim() mMarker = null");
            return;
        }
        this.f22706g = true;
        int toIndex = AngleManager.getInstant().getToIndex();
        this.f22702c = toIndex;
        this.f22703d = 11;
        if (toIndex >= 1 && toIndex <= 9) {
            this.f22703d = 7;
        }
        if (this.f22704e == null) {
            FrameAnim frameAnim = new FrameAnim(this.f22700a, this.f22701b);
            this.f22704e = frameAnim;
            frameAnim.setInfinite(false);
            this.f22704e.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim.this.f22705f.setFrames(FramesUtil.getBoxFrames(BoxAnim.this.f22700a, BoxAnim.this.f22703d));
                    BoxAnim.this.f22705f.doFrameAnim(true);
                }
            });
        }
        if (this.f22705f == null) {
            FrameAnim frameAnim2 = new FrameAnim(this.f22700a, this.f22701b);
            this.f22705f = frameAnim2;
            frameAnim2.setInfinite(false);
            this.f22705f.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim boxAnim = BoxAnim.this;
                    int unused = boxAnim.f22702c = boxAnim.f22703d;
                    AngleManager.getInstant().setFromIndex(BoxAnim.this.f22703d);
                    AngleManager.getInstant().setToIndex(BoxAnim.this.f22703d);
                    boolean unused2 = BoxAnim.this.f22706g = false;
                    if (BoxAnim.this.f22707h != null) {
                        BoxAnim.this.f22707h.onBoxAnimEnd();
                    }
                }
            });
        }
        int[] rotateFrames = FramesUtil.getRotateFrames(this.f22700a, this.f22702c, this.f22703d);
        if (rotateFrames == null || rotateFrames.length <= 0) {
            this.f22705f.setFrames(FramesUtil.getBoxFrames(this.f22700a, this.f22703d));
            this.f22705f.doFrameAnim(true);
            return;
        }
        this.f22704e.setFrames(rotateFrames);
        this.f22704e.doFrameAnim(true);
    }

    public void destory() {
        this.f22706g = false;
        this.f22707h = null;
        FrameAnim frameAnim = this.f22704e;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f22704e = null;
        }
        FrameAnim frameAnim2 = this.f22705f;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f22705f = null;
        }
    }
}
