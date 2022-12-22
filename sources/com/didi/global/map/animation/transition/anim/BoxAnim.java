package com.didi.global.map.animation.transition.anim;

import android.content.Context;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.transition.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.transition.util.AngleManager;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.global.map.animation.transition.util.LogUtil;

public class BoxAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f22767a;

    /* renamed from: b */
    private Marker f22768b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f22769c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f22770d;

    /* renamed from: e */
    private FrameAnim f22771e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameAnim f22772f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f22773g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnBoxAnimEndCallback f22774h;

    public BoxAnim(Context context, Marker marker) {
        this.f22767a = context;
        this.f22768b = marker;
    }

    public boolean isRunning() {
        return this.f22773g;
    }

    public void setOnBoxAnimEndCallback(OnBoxAnimEndCallback onBoxAnimEndCallback) {
        this.f22774h = onBoxAnimEndCallback;
    }

    public void doBoxAnim() {
        if (this.f22768b == null) {
            LogUtil.m16419e("doBoxAnim() mMarker = null");
            return;
        }
        this.f22773g = true;
        int toIndex = AngleManager.getInstant().getToIndex();
        this.f22769c = toIndex;
        this.f22770d = 11;
        if (toIndex >= 1 && toIndex <= 9) {
            this.f22770d = 7;
        }
        if (this.f22771e == null) {
            FrameAnim frameAnim = new FrameAnim(this.f22767a, this.f22768b);
            this.f22771e = frameAnim;
            frameAnim.setInfinite(false);
            this.f22771e.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim.this.f22772f.setFrames(FramesUtil.getBoxFrames(BoxAnim.this.f22767a, BoxAnim.this.f22770d));
                    BoxAnim.this.f22772f.doFrameAnim(true);
                }
            });
        }
        if (this.f22772f == null) {
            FrameAnim frameAnim2 = new FrameAnim(this.f22767a, this.f22768b);
            this.f22772f = frameAnim2;
            frameAnim2.setInfinite(false);
            this.f22772f.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim boxAnim = BoxAnim.this;
                    int unused = boxAnim.f22769c = boxAnim.f22770d;
                    AngleManager.getInstant().setFromIndex(BoxAnim.this.f22770d);
                    AngleManager.getInstant().setToIndex(BoxAnim.this.f22770d);
                    boolean unused2 = BoxAnim.this.f22773g = false;
                    if (BoxAnim.this.f22774h != null) {
                        BoxAnim.this.f22774h.onBoxAnimEnd();
                    }
                }
            });
        }
        int[] rotateFrames = FramesUtil.getRotateFrames(this.f22767a, this.f22769c, this.f22770d);
        if (rotateFrames == null || rotateFrames.length <= 0) {
            this.f22772f.setFrames(FramesUtil.getBoxFrames(this.f22767a, this.f22770d));
            this.f22772f.doFrameAnim(true);
            return;
        }
        this.f22771e.setFrames(rotateFrames);
        this.f22771e.doFrameAnim(true);
    }

    public void destory() {
        this.f22773g = false;
        this.f22774h = null;
        FrameAnim frameAnim = this.f22771e;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f22771e = null;
        }
        FrameAnim frameAnim2 = this.f22772f;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f22772f = null;
        }
    }
}
