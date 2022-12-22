package com.didi.global.map.animation;

import android.content.Context;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.anim.BoxAnim;
import com.didi.global.map.animation.anim.FrameAnim;
import com.didi.global.map.animation.anim.RippleAnimParam;
import com.didi.global.map.animation.anim.TranslateAnim;
import com.didi.global.map.animation.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.util.AngleManager;
import com.didi.global.map.animation.util.FramesUtil;
import com.didi.global.map.animation.util.LogUtil;
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
    private Context f22682a;

    /* renamed from: b */
    private int f22683b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SodaAnimLatLng f22684c = null;

    /* renamed from: d */
    private boolean f22685d = false;

    /* renamed from: e */
    private boolean f22686e = false;

    /* renamed from: f */
    private boolean f22687f = false;

    /* renamed from: g */
    private Marker f22688g;

    /* renamed from: h */
    private FrameAnim f22689h;

    /* renamed from: i */
    private List<Circle> f22690i;

    /* renamed from: j */
    private RippleAnimParam f22691j;

    /* renamed from: k */
    private Marker f22692k;

    /* renamed from: l */
    private FrameAnim f22693l;

    /* renamed from: m */
    private List<Circle> f22694m;

    /* renamed from: n */
    private RippleAnimParam f22695n;

    /* renamed from: o */
    private Marker f22696o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TranslateAnim f22697p;

    /* renamed from: q */
    private long f22698q = 3600;

    /* renamed from: r */
    private BoxAnim f22699r;

    public SodaAnimEngine(Context context) {
        this.f22682a = context;
        if (context != null) {
            LogUtil.m16429i("SodaAnimEngine constructor");
            return;
        }
        throw new NullPointerException("MarkerAnimEngine context == null");
    }

    public SodaAnimEngine setBusinessMarker(Marker marker) {
        this.f22688g = marker;
        return this;
    }

    public SodaAnimEngine setBusinessRippleCircles(List<Circle> list) {
        this.f22690i = list;
        return this;
    }

    public SodaAnimEngine setBusinessRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f22691j = rippleAnimParam;
        return this;
    }

    public void doBusinessAnim(boolean z) {
        Marker marker = this.f22688g;
        if (marker == null) {
            LogUtil.m16428e("doBusinessAnim() mBusinessMarker = null");
        } else if (z) {
            if (this.f22689h == null) {
                FrameAnim frameAnim = new FrameAnim(this.f22682a, marker, this.f22690i, this.f22691j);
                this.f22689h = frameAnim;
                frameAnim.setFrames(FramesUtil.getBusinessFrames(this.f22682a));
                this.f22689h.setInfinite(false);
                this.f22689h.setFrameIntervalTimeMillis(45);
            }
            this.f22689h.doFrameAnim(z);
        } else if (isBusinessAnimRunning()) {
            this.f22689h.doFrameAnim(false);
        }
    }

    public void doBusinessRippleAnim(boolean z) {
        if (this.f22688g == null) {
            LogUtil.m16428e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f22689h;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isBusinessAnimRunning() {
        FrameAnim frameAnim = this.f22689h;
        return frameAnim != null && frameAnim.isRunning();
    }

    public SodaAnimEngine setCustomerMarker(Marker marker) {
        this.f22692k = marker;
        return this;
    }

    public SodaAnimEngine setCustomerRippleCircles(List<Circle> list) {
        this.f22694m = list;
        return this;
    }

    public SodaAnimEngine setCustomerRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f22695n = rippleAnimParam;
        return this;
    }

    public void doCustomerAnim(boolean z) {
        Marker marker = this.f22692k;
        if (marker == null) {
            LogUtil.m16428e("doCustomerAnim() mCustomerMarker = null");
        } else if (z) {
            if (this.f22693l == null) {
                FrameAnim frameAnim = new FrameAnim(this.f22682a, marker, this.f22694m, this.f22695n);
                this.f22693l = frameAnim;
                frameAnim.setFrames(FramesUtil.customer_frames);
                this.f22693l.setInfinite(false);
                this.f22693l.setFrameIntervalTimeMillis(45);
            }
            this.f22693l.doFrameAnim(z);
        } else if (isCustomerAnimRunning()) {
            this.f22693l.doFrameAnim(false);
        }
    }

    public void doCustomerRippleAnim(boolean z) {
        if (this.f22692k == null) {
            LogUtil.m16428e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f22693l;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isCustomerAnimRunning() {
        FrameAnim frameAnim = this.f22693l;
        return frameAnim != null && frameAnim.isRunning();
    }

    public SodaAnimEngine setDeliveryMarker(Marker marker) {
        this.f22696o = marker;
        return this;
    }

    public SodaAnimEngine setTranslateIntervalTime(long j) {
        long j2 = (long) (((float) j) * 1.2f);
        this.f22698q = j2;
        TranslateAnim translateAnim = this.f22697p;
        if (translateAnim != null) {
            translateAnim.setTranslateIntervalTime(j2);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16335a(LatLng latLng) {
        Marker marker = this.f22696o;
        if (marker == null) {
            LogUtil.m16428e("doDeliveryTranslateAnim() mDeliveryMarker = null");
            return;
        }
        if (this.f22697p == null) {
            TranslateAnim translateAnim = new TranslateAnim(this.f22682a, marker);
            this.f22697p = translateAnim;
            translateAnim.setTranslateIntervalTime(this.f22698q);
        }
        this.f22697p.doTranslateAnim(latLng);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16334a() {
        Marker marker = this.f22696o;
        if (marker == null) {
            LogUtil.m16428e("doBoxAnimInternal() mDeliveryMarker = null");
            return;
        }
        if (this.f22699r == null) {
            this.f22699r = new BoxAnim(this.f22682a, marker);
        }
        this.f22699r.doBoxAnim();
    }

    public boolean doBoxAnim() {
        if (!this.f22685d) {
            LogUtil.m16428e("doBoxAnim() isForeground == false");
            return false;
        } else if (this.f22683b == 2 && !this.f22686e) {
            this.f22686e = true;
            m16339a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m16334a();
                }
            });
            return true;
        } else if (this.f22683b != 4 || this.f22687f) {
            return false;
        } else {
            this.f22687f = true;
            m16339a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m16334a();
                }
            });
            return true;
        }
    }

    public SodaAnimEngine setAnimState(int i) {
        this.f22683b = i;
        LogUtil.m16429i("setAnimState() mAnimState: " + this.f22683b);
        return this;
    }

    /* renamed from: a */
    private void m16339a(final OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        TranslateAnim translateAnim = this.f22697p;
        if (translateAnim != null && translateAnim.isRunning()) {
            this.f22697p.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    OnTranslateAnimEndCallback onTranslateAnimEndCallback = onTranslateAnimEndCallback;
                    if (onTranslateAnimEndCallback != null) {
                        onTranslateAnimEndCallback.onTranslateAnimEnd();
                    }
                    SodaAnimEngine.this.f22697p.setOnTranslateAnimEndCallback((OnTranslateAnimEndCallback) null);
                }
            });
        } else if (onTranslateAnimEndCallback != null) {
            onTranslateAnimEndCallback.onTranslateAnimEnd();
        }
    }

    /* renamed from: a */
    private void m16338a(final OnBoxAnimEndCallback onBoxAnimEndCallback) {
        BoxAnim boxAnim = this.f22699r;
        if (boxAnim != null && boxAnim.isRunning()) {
            this.f22699r.setOnBoxAnimEndCallback(new OnBoxAnimEndCallback() {
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
        if (!this.f22685d) {
            LogUtil.m16428e("onLocationChanged() isForeground == false");
        } else if (this.f22683b == 0) {
            LogUtil.m16428e("onLocationChanged() mAnimState == SodaAnimState.UNKNOWN");
        } else if (sodaAnimLatLng == null || sodaAnimLatLng.latLng == null) {
            LogUtil.m16428e("onLocationChanged() sodaLatLng == null || sodaLatLng.latLng == null");
        } else {
            SodaAnimLatLng sodaAnimLatLng2 = this.f22684c;
            if (sodaAnimLatLng2 == null || !sodaAnimLatLng2.equals(sodaAnimLatLng)) {
                this.f22684c = sodaAnimLatLng;
                int i = this.f22683b;
                if (i == 1) {
                    this.f22686e = false;
                    this.f22687f = false;
                    m16335a(sodaAnimLatLng.latLng);
                } else if (i == 2) {
                    doBoxAnim();
                } else if (i == 3) {
                    this.f22687f = false;
                    m16338a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m16335a(sodaAnimEngine.f22684c.latLng);
                        }
                    });
                } else if (i != 4) {
                    LogUtil.m16428e("onLocationChanged() switch to default");
                } else {
                    doBoxAnim();
                    m16338a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m16335a(sodaAnimEngine.f22684c.latLng);
                        }
                    });
                }
            } else {
                LogUtil.m16428e("onLocationChanged() mLastSodaLatLng.equals(sodaLatLng)");
            }
        }
    }

    public void setForeground(boolean z) {
        this.f22685d = z;
    }

    public void onResume() {
        this.f22685d = true;
    }

    public void onPause() {
        this.f22685d = false;
    }

    public void onStop() {
        this.f22685d = false;
    }

    public void onDestroy() {
        this.f22683b = 0;
        this.f22684c = null;
        this.f22685d = false;
        this.f22686e = false;
        this.f22687f = false;
        AngleManager.getInstant().destroy();
        FrameAnim frameAnim = this.f22689h;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f22689h = null;
        }
        FrameAnim frameAnim2 = this.f22693l;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f22693l = null;
        }
        TranslateAnim translateAnim = this.f22697p;
        if (translateAnim != null) {
            translateAnim.destory();
            this.f22697p = null;
        }
        BoxAnim boxAnim = this.f22699r;
        if (boxAnim != null) {
            boxAnim.destory();
            this.f22699r = null;
        }
    }
}
