package com.didi.global.map.animation.transition;

import android.content.Context;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.anim.BoxAnim;
import com.didi.global.map.animation.transition.anim.FrameAnim;
import com.didi.global.map.animation.transition.anim.RippleAnimParam;
import com.didi.global.map.animation.transition.anim.TranslateAnim;
import com.didi.global.map.animation.transition.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.transition.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.transition.util.AngleManager;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.global.map.animation.transition.util.LogUtil;
import java.util.List;

public class SodaAnimEngine {
    public static final int AngleFramesMaxIndex = 16;
    public static final int AngleFramesMinIndex = 1;
    public static float DefaultAngle = 0.0f;
    public static int DefaultAngleFrame = 1;
    public static final long DefaultTranslateIntervalTime = 3000;
    public static double DistanceThreshold = 300.0d;
    public static final int IntervalTimeMillis = 100;
    public static final float TranslateIntervalTimeFraction = 1.2f;
    public static final int jumpIntervalTimeMillis = 45;

    /* renamed from: a */
    private Context f22748a;

    /* renamed from: b */
    private int f22749b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SodaAnimLatLng f22750c = null;

    /* renamed from: d */
    private boolean f22751d = false;

    /* renamed from: e */
    private boolean f22752e = false;

    /* renamed from: f */
    private boolean f22753f = false;

    /* renamed from: g */
    private Marker f22754g;

    /* renamed from: h */
    private FrameAnim f22755h;

    /* renamed from: i */
    private List<Circle> f22756i;

    /* renamed from: j */
    private RippleAnimParam f22757j;

    /* renamed from: k */
    private Marker f22758k;

    /* renamed from: l */
    private FrameAnim f22759l;

    /* renamed from: m */
    private List<Circle> f22760m;

    /* renamed from: n */
    private RippleAnimParam f22761n;

    /* renamed from: o */
    private Marker f22762o;

    /* renamed from: p */
    private TranslateAnim f22763p;

    /* renamed from: q */
    private long f22764q = 3600;

    /* renamed from: r */
    private BoxAnim f22765r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnTranslateAnimEndCallback f22766s;

    public SodaAnimEngine(Context context) {
        this.f22748a = context;
        if (context != null) {
            LogUtil.m16420i("SodaAnimEngine constructor");
            return;
        }
        throw new NullPointerException("MarkerAnimEngine context == null");
    }

    public SodaAnimEngine setBusinessMarker(Marker marker) {
        this.f22754g = marker;
        return this;
    }

    public void setOnTranslateAnimEndCallback(OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        this.f22766s = onTranslateAnimEndCallback;
    }

    public SodaAnimEngine setBusinessRippleCircles(List<Circle> list) {
        this.f22756i = list;
        return this;
    }

    public SodaAnimEngine setBusinessRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f22757j = rippleAnimParam;
        return this;
    }

    public void doBusinessAnim(boolean z) {
        Marker marker = this.f22754g;
        if (marker == null) {
            LogUtil.m16419e("doBusinessAnim() mBusinessMarker = null");
        } else if (z) {
            if (this.f22755h == null) {
                FrameAnim frameAnim = new FrameAnim(this.f22748a, marker, this.f22756i, this.f22757j);
                this.f22755h = frameAnim;
                frameAnim.setFrames(FramesUtil.getBusinessFrames(this.f22748a));
                this.f22755h.setInfinite(false);
                this.f22755h.setFrameIntervalTimeMillis(45);
            }
            this.f22755h.doFrameAnim(z);
        } else if (isBusinessAnimRunning()) {
            this.f22755h.doFrameAnim(false);
        }
    }

    public void doBusinessRippleAnim(boolean z) {
        if (this.f22754g == null) {
            LogUtil.m16419e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f22755h;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isBusinessAnimRunning() {
        FrameAnim frameAnim = this.f22755h;
        return frameAnim != null && frameAnim.isRunning();
    }

    public SodaAnimEngine setCustomerMarker(Marker marker) {
        this.f22758k = marker;
        return this;
    }

    public SodaAnimEngine setCustomerRippleCircles(List<Circle> list) {
        this.f22760m = list;
        return this;
    }

    public SodaAnimEngine setCustomerRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f22761n = rippleAnimParam;
        return this;
    }

    public void doCustomerAnim(boolean z) {
        Marker marker = this.f22758k;
        if (marker == null) {
            LogUtil.m16419e("doCustomerAnim() mCustomerMarker = null");
        } else if (z) {
            if (this.f22759l == null) {
                FrameAnim frameAnim = new FrameAnim(this.f22748a, marker, this.f22760m, this.f22761n);
                this.f22759l = frameAnim;
                frameAnim.setFrames(FramesUtil.customer_frames);
                this.f22759l.setInfinite(false);
                this.f22759l.setFrameIntervalTimeMillis(45);
            }
            this.f22759l.doFrameAnim(z);
        } else if (isCustomerAnimRunning()) {
            this.f22759l.doFrameAnim(false);
        }
    }

    public void doCustomerRippleAnim(boolean z) {
        if (this.f22758k == null) {
            LogUtil.m16419e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f22759l;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isCustomerAnimRunning() {
        FrameAnim frameAnim = this.f22759l;
        return frameAnim != null && frameAnim.isRunning();
    }

    public boolean isDeliverTranslateAnimRunning() {
        TranslateAnim translateAnim = this.f22763p;
        return translateAnim != null && translateAnim.isRunning();
    }

    public SodaAnimEngine setDeliveryMarker(Marker marker) {
        this.f22762o = marker;
        return this;
    }

    public SodaAnimEngine setTranslateIntervalTime(long j) {
        long j2 = (long) (((float) j) * 1.2f);
        this.f22764q = j2;
        TranslateAnim translateAnim = this.f22763p;
        if (translateAnim != null) {
            translateAnim.setTranslateIntervalTime(j2);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16378a(LatLng latLng) {
        Marker marker = this.f22762o;
        if (marker == null) {
            LogUtil.m16419e("doDeliveryTranslateAnim() mDeliveryMarker = null");
            return;
        }
        TranslateAnim translateAnim = new TranslateAnim(this.f22748a, marker);
        this.f22763p = translateAnim;
        translateAnim.setTranslateIntervalTime(this.f22764q);
        this.f22763p.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
            public void onTranslateAnimEnd() {
                if (SodaAnimEngine.this.f22766s != null) {
                    SodaAnimEngine.this.f22766s.onTranslateAnimEnd();
                }
            }
        });
        this.f22763p.doTranslateAnim(latLng);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16377a() {
        Marker marker = this.f22762o;
        if (marker == null) {
            LogUtil.m16419e("doBoxAnimInternal() mDeliveryMarker = null");
            return;
        }
        if (this.f22765r == null) {
            this.f22765r = new BoxAnim(this.f22748a, marker);
        }
        this.f22765r.doBoxAnim();
    }

    public boolean doBoxAnim() {
        if (!this.f22751d) {
            LogUtil.m16419e("doBoxAnim() isForeground == false");
            return false;
        } else if (this.f22749b == 2 && !this.f22752e) {
            this.f22752e = true;
            m16381a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m16377a();
                }
            });
            return true;
        } else if (this.f22749b != 4 || this.f22753f) {
            return false;
        } else {
            this.f22753f = true;
            m16381a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m16377a();
                }
            });
            return true;
        }
    }

    public SodaAnimEngine setAnimState(int i) {
        this.f22749b = i;
        LogUtil.m16420i("setAnimState() mAnimState: " + this.f22749b);
        return this;
    }

    /* renamed from: a */
    private void m16381a(final OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        TranslateAnim translateAnim = this.f22763p;
        if (translateAnim != null && translateAnim.isRunning()) {
            this.f22763p.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    OnTranslateAnimEndCallback onTranslateAnimEndCallback = onTranslateAnimEndCallback;
                    if (onTranslateAnimEndCallback != null) {
                        onTranslateAnimEndCallback.onTranslateAnimEnd();
                    }
                }
            });
        } else if (onTranslateAnimEndCallback != null) {
            onTranslateAnimEndCallback.onTranslateAnimEnd();
        }
    }

    /* renamed from: a */
    private void m16380a(final OnBoxAnimEndCallback onBoxAnimEndCallback) {
        BoxAnim boxAnim = this.f22765r;
        if (boxAnim != null && boxAnim.isRunning()) {
            this.f22765r.setOnBoxAnimEndCallback(new OnBoxAnimEndCallback() {
                public void onBoxAnimEnd() {
                    OnBoxAnimEndCallback onBoxAnimEndCallback = onBoxAnimEndCallback;
                    if (onBoxAnimEndCallback != null) {
                        onBoxAnimEndCallback.onBoxAnimEnd();
                    }
                }
            });
        } else if (onBoxAnimEndCallback != null) {
            onBoxAnimEndCallback.onBoxAnimEnd();
        }
    }

    public void onLocationChanged(SodaAnimLatLng sodaAnimLatLng) {
        if (!this.f22751d) {
            LogUtil.m16419e("onLocationChanged() isForeground == false");
        } else if (this.f22749b == 0) {
            LogUtil.m16419e("onLocationChanged() mAnimState == SodaAnimState.UNKNOWN");
        } else if (sodaAnimLatLng == null || sodaAnimLatLng.latLng == null) {
            LogUtil.m16419e("onLocationChanged() sodaLatLng == null || sodaLatLng.latLng == null");
        } else {
            SodaAnimLatLng sodaAnimLatLng2 = this.f22750c;
            if (sodaAnimLatLng2 == null || !sodaAnimLatLng2.equals(sodaAnimLatLng)) {
                this.f22750c = sodaAnimLatLng;
                int i = this.f22749b;
                if (i == 1) {
                    this.f22752e = false;
                    this.f22753f = false;
                    m16378a(sodaAnimLatLng.latLng);
                } else if (i == 2) {
                    doBoxAnim();
                } else if (i == 3) {
                    this.f22753f = false;
                    m16380a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m16378a(sodaAnimEngine.f22750c.latLng);
                        }
                    });
                } else if (i != 4) {
                    LogUtil.m16419e("onLocationChanged() switch to default");
                } else {
                    doBoxAnim();
                    m16380a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m16378a(sodaAnimEngine.f22750c.latLng);
                        }
                    });
                }
            } else {
                LogUtil.m16419e("onLocationChanged() mLastSodaLatLng.equals(sodaLatLng)");
            }
        }
    }

    public void setForeground(boolean z) {
        this.f22751d = z;
    }

    public void onResume() {
        this.f22751d = true;
    }

    public void onPause() {
        this.f22751d = false;
    }

    public void onStop() {
        this.f22751d = false;
    }

    public void onDestroy() {
        this.f22749b = 0;
        this.f22750c = null;
        this.f22751d = false;
        this.f22752e = false;
        this.f22753f = false;
        AngleManager.getInstant().destroy();
        FrameAnim frameAnim = this.f22755h;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f22755h = null;
        }
        FrameAnim frameAnim2 = this.f22759l;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f22759l = null;
        }
        TranslateAnim translateAnim = this.f22763p;
        if (translateAnim != null) {
            translateAnim.destory();
            this.f22763p = null;
        }
        BoxAnim boxAnim = this.f22765r;
        if (boxAnim != null) {
            boxAnim.destory();
            this.f22765r = null;
        }
    }
}
