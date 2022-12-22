package com.didi.map.sdk.nav.car;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.MapUtils;
import com.didi.map.sdk.nav.inertia.ApolloCache;
import com.map.sdk.nav.libc.common.ApolloUtil;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AnimationNewPart implements AnimationPartInterface {

    /* renamed from: a */
    private static final String f28327a = "AnimationNewPart";

    /* renamed from: b */
    private static final float f28328b = 1.1f;

    /* renamed from: r */
    private static final int f28329r = 2;

    /* renamed from: A */
    private AnimateNode f28330A;

    /* renamed from: B */
    private double f28331B = 15.0d;

    /* renamed from: C */
    private double f28332C;

    /* renamed from: D */
    private ApolloCache f28333D = new ApolloCache();

    /* renamed from: E */
    private boolean f28334E = true;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public float f28335F = -1.0f;

    /* renamed from: G */
    private AnimationPartCallback f28336G = new AnimationPartCallback() {
        public void onFinish() {
            boolean unused = AnimationNewPart.this.f28353o = false;
            if (AnimationNewPart.this.f28351m != null && AnimationNewPart.this.f28352n) {
                AnimationNewPart.this.f28351m.onCancel();
                onCarAnimationCancelListener unused2 = AnimationNewPart.this.f28351m = null;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: H */
    public ValueAnimator f28337H = null;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public float f28338I = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public LatLng f28339J = null;

    /* renamed from: K */
    private int f28340K = 0;

    /* renamed from: c */
    private CameraMode f28341c = CameraMode.NORTH_UP;

    /* renamed from: d */
    private Map f28342d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CarMarker f28343e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<LatLng> f28344f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public onCarAnimationListener f28345g;

    /* renamed from: h */
    private NavOverlay f28346h;

    /* renamed from: i */
    private List<AnimationPartNode> f28347i = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AnimateNode f28348j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AnimatorSet f28349k;

    /* renamed from: l */
    private int f28350l = 3000;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public onCarAnimationCancelListener f28351m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f28352n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f28353o = false;

    /* renamed from: p */
    private List<LatLng> f28354p = Collections.synchronizedList(new ArrayList());

    /* renamed from: q */
    private int f28355q = 0;

    /* renamed from: s */
    private boolean f28356s = false;

    /* renamed from: t */
    private AnimateNode f28357t;

    /* renamed from: u */
    private boolean f28358u = false;

    /* renamed from: v */
    private int f28359v = -1;

    /* renamed from: w */
    private int f28360w = -1;

    /* renamed from: x */
    private Handler f28361x = new Handler();

    /* renamed from: y */
    private Runnable f28362y;

    /* renamed from: z */
    private int f28363z;

    /* renamed from: a */
    private int m20071a(float f) {
        if (f >= 0.0f && f < 90.0f) {
            return 1;
        }
        if (f >= 90.0f && f < 180.0f) {
            return 2;
        }
        if (f < 180.0f || f >= 270.0f) {
            return (f < 270.0f || f >= 360.0f) ? 1 : 4;
        }
        return 3;
    }

    public AnimationNewPart(Map map, CarMarker carMarker) {
        this.f28342d = map;
        this.f28331B = ZoomLevelAdapter.getCarHeadMinZoom(map);
        this.f28332C = ZoomLevelAdapter.getCarHeadMaxZoom(map);
        if (DriverCarNewAnimApollo.getInstance().enable()) {
            this.f28332C = (double) DriverCarNewAnimApollo.getInstance().getMaxZoomLevel();
        }
        this.f28363z = map.getHeight() / 3;
        this.f28343e = carMarker;
        if (this.f28342d == null) {
            DLog.m7384d(f28327a, "AnimationPart, mMap is null", new Object[0]);
        } else if (carMarker == null) {
            DLog.m7384d(f28327a, "AnimationPart, mCarMarker == null", new Object[0]);
        } else if (carMarker.getMarker() == null) {
            DLog.m7384d(f28327a, "AnimationPart, getMarker == null", new Object[0]);
        } else if (this.f28343e.getPosition() == null) {
            DLog.m7384d(f28327a, "AnimationPart, getPosition == null", new Object[0]);
        } else {
            this.f28348j = new AnimateNode(this.f28343e.getPosition(), -1, 0, false);
        }
    }

    public void setRoutePoints(List<LatLng> list) {
        if (list == null || !list.equals(this.f28344f)) {
            this.f28344f = list;
            this.f28357t = null;
            CarMarker carMarker = this.f28343e;
            if (carMarker != null) {
                this.f28348j = new AnimateNode(carMarker.getPosition(), -1, 0, false);
            }
            this.f28355q = 0;
            List<AnimationPartNode> list2 = this.f28347i;
            if (list2 != null) {
                list2.clear();
            }
            if (this.f28341c == CameraMode.CAR_HEAD_UP && this.f28344f != null) {
                Runnable runnable = this.f28362y;
                if (runnable != null) {
                    this.f28361x.removeCallbacks(runnable);
                }
                $$Lambda$AnimationNewPart$SoZksn9vdUvNtjNLf6TR9EZsXU0 r4 = new Runnable() {
                    public final void run() {
                        AnimationNewPart.this.m20106f();
                    }
                };
                this.f28362y = r4;
                this.f28361x.postDelayed(r4, (long) (((float) this.f28350l) * f28328b));
                return;
            }
            return;
        }
        DLog.m7384d(f28327a, "setRoutePoints, the same !", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m20106f() {
        List<LatLng> list = this.f28344f;
        if (list != null && list.size() > 0 && !this.f28356s) {
            start(new AnimateNode(this.f28344f.get(0), 0, 0, false));
        }
    }

    public void setOnCarAnimationListener(onCarAnimationListener oncaranimationlistener) {
        this.f28345g = oncaranimationlistener;
    }

    public void start(AnimateNode animateNode) {
        start(animateNode, (DMKEventPoint) null);
    }

    public void start(AnimateNode animateNode, DMKEventPoint dMKEventPoint) {
        if (animateNode == null || animateNode.latLng == null) {
            DLog.m7384d(f28327a, "start fail node=null", new Object[0]);
            return;
        }
        if (!this.f28356s) {
            this.f28357t = null;
        }
        if (dMKEventPoint != null) {
            this.f28360w = dMKEventPoint.geoIndex;
        }
        if (!animateNode.compare(this.f28348j) || this.f28341c == CameraMode.CAR_HEAD_UP) {
            this.f28330A = animateNode;
            stop(new onCarAnimationCancelListener(animateNode) {
                public final /* synthetic */ AnimateNode f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCancel() {
                    AnimationNewPart.this.m20100c(this.f$1);
                }
            }, false);
            return;
        }
        this.f28348j = animateNode;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m20100c(AnimateNode animateNode) {
        this.f28352n = false;
        m20086a(animateNode);
    }

    public void stop(onCarAnimationCancelListener oncaranimationcancellistener, boolean z) {
        ValueAnimator valueAnimator;
        this.f28352n = true;
        this.f28351m = oncaranimationcancellistener;
        AnimatorSet animatorSet = this.f28349k;
        if (animatorSet == null || !animatorSet.isRunning()) {
            ValueAnimator valueAnimator2 = this.f28337H;
            if (valueAnimator2 != null && valueAnimator2.isRunning() && z) {
                this.f28337H.cancel();
            }
            onCarAnimationCancelListener oncaranimationcancellistener2 = this.f28351m;
            if (oncaranimationcancellistener2 != null) {
                oncaranimationcancellistener2.onCancel();
                this.f28351m = null;
                return;
            }
            return;
        }
        if (z && (valueAnimator = this.f28337H) != null && valueAnimator.isRunning()) {
            this.f28337H.cancel();
        }
        this.f28349k.cancel();
    }

    public void setAnimationInterval(int i) {
        DLog.m7384d(f28327a, "setAnimationInterval =" + i, new Object[0]);
        this.f28350l = i;
    }

    public void setIsBackground(boolean z) {
        AnimateNode animateNode;
        this.f28356s = z;
        if (!z && (animateNode = this.f28357t) != null) {
            start(animateNode);
        }
    }

    public void destroy() {
        stop((onCarAnimationCancelListener) null, true);
        List<AnimationPartNode> list = this.f28347i;
        if (list != null) {
            list.clear();
            this.f28347i = null;
        }
        List<LatLng> list2 = this.f28354p;
        if (list2 != null) {
            list2.clear();
            this.f28354p = null;
        }
        this.f28333D = null;
        this.f28343e = null;
        this.f28344f = null;
        this.f28349k = null;
        this.f28351m = null;
        Runnable runnable = this.f28362y;
        if (runnable != null) {
            this.f28361x.removeCallbacks(runnable);
        }
        this.f28361x = null;
        DLog.m7384d(f28327a, "destroy ok", new Object[0]);
    }

    /* renamed from: a */
    private void m20082a() {
        List<AnimationPartNode> list = this.f28347i;
        if (list == null || list.size() <= 0) {
            AnimationPartCallback animationPartCallback = this.f28336G;
            if (animationPartCallback != null) {
                animationPartCallback.onFinish();
                return;
            }
            return;
        }
        m20096b();
        m20087a((AnimationPartCallback) new AnimationPartCallback() {
            public final void onFinish() {
                AnimationNewPart.this.m20104e();
            }
        }, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m20104e() {
        List<AnimationPartNode> list = this.f28347i;
        if (list != null && list.size() > 0) {
            this.f28347i.remove(0);
        }
        m20082a();
    }

    /* renamed from: a */
    private void m20087a(final AnimationPartCallback animationPartCallback, boolean z) {
        List<AnimationPartNode> list = this.f28347i;
        if (list != null && list.size() != 0 && this.f28343e != null && !this.f28352n && this.f28342d != null) {
            AnimationPartNode animationPartNode = this.f28347i.get(0);
            ValueAnimator b = m20094b(animationPartNode);
            ValueAnimator a = m20075a(animationPartNode);
            ValueAnimator a2 = m20076a((AnimationPartNode) (this.f28347i.size() > 1 ? this.f28347i.get(1) : this.f28347i.get(0)), z);
            LinkedList linkedList = new LinkedList();
            if (a != null) {
                linkedList.add(a);
            }
            if (b != null) {
                linkedList.add(b);
            }
            if (linkedList.size() != 0 || a2 != null) {
                if (linkedList.size() != 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f28349k = animatorSet;
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            AnimatorSet unused = AnimationNewPart.this.f28349k = null;
                            AnimationPartCallback animationPartCallback = animationPartCallback;
                            if (animationPartCallback != null) {
                                animationPartCallback.onFinish();
                            }
                        }
                    });
                    this.f28349k.playTogether(linkedList);
                    this.f28349k.setDuration((long) (((float) animationPartNode.totalDuration) * f28328b));
                    if (!this.f28352n) {
                        this.f28349k.start();
                    } else if (animationPartCallback != null) {
                        animationPartCallback.onFinish();
                        return;
                    } else {
                        return;
                    }
                }
                if (a2 != null) {
                    a2.start();
                }
                this.f28348j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, animationPartNode.isEraseEnd);
                if (linkedList.size() == 0) {
                    DLog.m7384d(f28327a, "doAnimationSet: animatorList.size() == 0", new Object[0]);
                    if (animationPartCallback != null) {
                        animationPartCallback.onFinish();
                    }
                }
            } else if (animationPartCallback != null) {
                animationPartCallback.onFinish();
            }
        } else if (animationPartCallback != null) {
            animationPartCallback.onFinish();
        }
    }

    /* renamed from: a */
    private ValueAnimator m20076a(AnimationPartNode animationPartNode, boolean z) {
        RotateStatus a;
        CarMarker carMarker = this.f28343e;
        if (!(carMarker == null || this.f28352n || this.f28342d == null)) {
            HeadingStatus headingOfAnimate = C10010utils.getHeadingOfAnimate(this.f28344f, carMarker.getPosition(), animationPartNode, false);
            if (!headingOfAnimate.success) {
                return null;
            }
            float rotation = this.f28343e.getRotation();
            if (this.f28341c == CameraMode.CAR_HEAD_UP && z && this.f28358u) {
                rotation = this.f28342d.getCameraPosition().bearing;
            }
            float reviseRotate = C10010utils.getReviseRotate(rotation, (float) headingOfAnimate.heading);
            float f = rotation % 360.0f;
            if (f < 0.0f) {
                f += 360.0f;
            }
            float f2 = reviseRotate % 360.0f;
            if (f2 < 0.0f) {
                f2 += 360.0f;
            }
            if (this.f28341c == CameraMode.CAR_HEAD_UP && this.f28358u && ((a = m20079a(f, f2)) == null || a.offsetRotate < 10.0f)) {
                return null;
            }
            RotateStatus a2 = m20079a(f, f2);
            if (a2 != null && a2.offsetRotate >= 1.0f) {
                ValueAnimator valueAnimator = this.f28337H;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    if (Math.abs(f2 - this.f28338I) < 10.0f) {
                        return null;
                    }
                    this.f28337H.cancel();
                }
                long max = Math.max((long) (((float) animationPartNode.totalDuration) * f28328b), 500);
                this.f28338I = f2;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f28337H = ofFloat;
                ofFloat.setDuration(max);
                this.f28337H.setInterpolator(new LinearInterpolator());
                this.f28337H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(a2, f, z) {
                    public final /* synthetic */ RotateStatus f$1;
                    public final /* synthetic */ float f$2;
                    public final /* synthetic */ boolean f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AnimationNewPart.this.m20089a(this.f$1, this.f$2, this.f$3, valueAnimator);
                    }
                });
                this.f28337H.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ValueAnimator unused = AnimationNewPart.this.f28337H = null;
                        float unused2 = AnimationNewPart.this.f28338I = 0.0f;
                    }
                });
                return this.f28337H;
            } else if (this.f28337H == null) {
                m20083a(f2, true);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20089a(RotateStatus rotateStatus, float f, boolean z, ValueAnimator valueAnimator) {
        float f2;
        Float f3 = (Float) valueAnimator.getAnimatedValue();
        if (this.f28343e != null && f3 != null) {
            if (rotateStatus.isClockise) {
                f2 = f + (rotateStatus.offsetRotate * f3.floatValue());
            } else {
                f2 = f - (rotateStatus.offsetRotate * f3.floatValue());
            }
            m20083a(f2, z);
        }
    }

    /* renamed from: a */
    private ValueAnimator m20075a(AnimationPartNode animationPartNode) {
        if (this.f28343e == null || this.f28352n || this.f28335F < 0.0f) {
            return null;
        }
        long max = Math.max((long) (((float) animationPartNode.totalDuration) * f28328b), 100);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.f28342d.getCameraPosition().zoom, this.f28335F});
        ofFloat.setDuration(max);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationNewPart.this.m20084a(valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                float unused = AnimationNewPart.this.f28335F = -1.0f;
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20084a(ValueAnimator valueAnimator) {
        this.f28335F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* renamed from: b */
    private ValueAnimator m20094b(final AnimationPartNode animationPartNode) {
        if (this.f28343e == null || this.f28352n) {
            return null;
        }
        if (this.f28345g != null && animationPartNode.isEraseRunning) {
            updateLines(this.f28344f, this.f28343e.getPosition(), animationPartNode);
        }
        LatLng position = this.f28343e.getPosition();
        final LatLng latLng = animationPartNode.latLng;
        if (DDSphericalUtil.computeDistanceBetween(position, latLng) < 0.1d) {
            if (this.f28343e != null) {
                m20085a(latLng);
                if (this.f28345g != null && animationPartNode.isEraseEnd) {
                    updateLines(this.f28344f, this.f28343e.getPosition(), animationPartNode);
                }
            }
            return null;
        }
        long max = Math.max((long) (((float) animationPartNode.totalDuration) * f28328b), 100);
        ValueAnimator ofObject = ValueAnimator.ofObject(new LatLngTypeEvaluator(), new Object[]{position, latLng});
        ofObject.setDuration(max);
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(animationPartNode) {
            public final /* synthetic */ AnimationPartNode f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationNewPart.this.m20088a(this.f$1, valueAnimator);
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LatLng unused = AnimationNewPart.this.f28339J = null;
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (AnimationNewPart.this.f28343e != null && AnimationNewPart.this.f28344f != null && AnimationNewPart.this.f28344f.size() > animationPartNode.index) {
                    if (AnimationNewPart.this.f28339J == null || !AnimationNewPart.this.f28339J.equals(latLng)) {
                        int i = 0;
                        if (animationPartNode.type != AnimateNodeStatus.ON_ROAD) {
                            AnimationNewPart animationNewPart = AnimationNewPart.this;
                            AnimateNode unused = animationNewPart.f28348j = new AnimateNode(animationNewPart.f28343e.getPosition(), -1, 0, true);
                        } else if (animationPartNode.offset > 0) {
                            AnimationNewPart animationNewPart2 = AnimationNewPart.this;
                            AnimateNode unused2 = animationNewPart2.f28348j = new AnimateNode(animationNewPart2.f28343e.getPosition(), animationPartNode.index, (int) DDSphericalUtil.computeDistanceBetween((LatLng) AnimationNewPart.this.f28344f.get(animationPartNode.index), AnimationNewPart.this.f28343e.getPosition()), true);
                        } else {
                            int i2 = animationPartNode.index - 1;
                            if (i2 >= 0) {
                                i = i2;
                            }
                            AnimationNewPart animationNewPart3 = AnimationNewPart.this;
                            AnimateNode unused3 = animationNewPart3.f28348j = new AnimateNode(animationNewPart3.f28343e.getPosition(), i, (int) DDSphericalUtil.computeDistanceBetween((LatLng) AnimationNewPart.this.f28344f.get(i), AnimationNewPart.this.f28343e.getPosition()), true);
                        }
                    } else {
                        AnimateNode unused4 = AnimationNewPart.this.f28348j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, animationPartNode.isEraseEnd);
                        if (AnimationNewPart.this.f28345g != null && animationPartNode.isEraseEnd) {
                            AnimationNewPart animationNewPart4 = AnimationNewPart.this;
                            animationNewPart4.updateLines(animationNewPart4.f28344f, AnimationNewPart.this.f28343e.getPosition(), animationPartNode);
                        }
                    }
                }
            }
        });
        return ofObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20088a(AnimationPartNode animationPartNode, ValueAnimator valueAnimator) {
        LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
        this.f28339J = latLng;
        if (this.f28343e != null) {
            m20085a(latLng);
            if (this.f28345g != null && animationPartNode.isEraseRunning) {
                updateLines(this.f28344f, this.f28343e.getPosition(), animationPartNode);
            }
        }
    }

    /* renamed from: a */
    private void m20086a(AnimateNode animateNode) {
        CarMarker carMarker;
        HeadingStatus headingOfAnimate;
        if (!this.f28353o && this.f28343e != null) {
            List<AnimationPartNode> b = m20095b(animateNode);
            this.f28347i = b;
            if (b != null && b.size() != 0) {
                boolean z = true;
                this.f28353o = true;
                AnimationPartNode animationPartNode = this.f28347i.get(0);
                int i = C100066.$SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus[animationPartNode.type.ordinal()];
                if (i == 1) {
                    if (animationPartNode.jump) {
                        HeadingStatus headingOfAnimate2 = C10010utils.getHeadingOfAnimate(this.f28344f, this.f28343e.getPosition(), animationPartNode, false);
                        if (headingOfAnimate2 == null || !headingOfAnimate2.success) {
                            this.f28353o = false;
                            return;
                        }
                        this.f28348j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, true);
                        m20085a(animationPartNode.latLng);
                        m20083a((float) headingOfAnimate2.heading, false);
                        if (this.f28345g != null && animationPartNode.isEraseEnd) {
                            updateLines(this.f28344f, this.f28343e.getPosition(), animationPartNode);
                        }
                        this.f28353o = false;
                    } else {
                        m20082a();
                    }
                    Runnable runnable = this.f28362y;
                    if (runnable != null) {
                        this.f28361x.removeCallbacks(runnable);
                        this.f28362y = null;
                    }
                } else if (i == 2 || i == 3) {
                    if (animationPartNode.jump) {
                        HeadingStatus headingOfAnimate3 = C10010utils.getHeadingOfAnimate(this.f28344f, this.f28343e.getPosition(), animationPartNode, false);
                        if (headingOfAnimate3 == null || !headingOfAnimate3.success) {
                            this.f28353o = false;
                            return;
                        }
                        this.f28348j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, false);
                        m20085a(animationPartNode.latLng);
                        m20083a((float) headingOfAnimate3.heading, false);
                        this.f28353o = false;
                        return;
                    }
                    if (this.f28341c != CameraMode.CAR_HEAD_UP || (carMarker = this.f28343e) == null) {
                        z = false;
                    } else {
                        HeadingStatus headingOfAnimate4 = C10010utils.getHeadingOfAnimate(this.f28344f, carMarker.getPosition(), animationPartNode, false);
                        if (headingOfAnimate4 == null || !headingOfAnimate4.success) {
                            this.f28353o = false;
                        }
                    }
                    m20087a(this.f28336G, z);
                } else if (i == 4) {
                    Runnable runnable2 = this.f28362y;
                    if (runnable2 != null) {
                        this.f28361x.removeCallbacks(runnable2);
                        this.f28361x.postDelayed(this.f28362y, (long) (((float) this.f28350l) * f28328b));
                    }
                    if (animationPartNode.jump) {
                        HeadingStatus headingOfAnimate5 = C10010utils.getHeadingOfAnimate(this.f28344f, this.f28343e.getPosition(), animationPartNode, true);
                        if (headingOfAnimate5 == null || !headingOfAnimate5.success) {
                            this.f28353o = false;
                            return;
                        }
                        this.f28348j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, false);
                        m20085a(animationPartNode.latLng);
                        m20083a((float) headingOfAnimate5.heading, false);
                        this.f28353o = false;
                        if (this.f28345g != null && animationPartNode.isEraseEnd) {
                            updateLines(this.f28344f, this.f28343e.getPosition(), animationPartNode);
                            return;
                        }
                        return;
                    }
                    CarMarker carMarker2 = this.f28343e;
                    if (carMarker2 != null && ((headingOfAnimate = C10010utils.getHeadingOfAnimate(this.f28344f, carMarker2.getPosition(), animationPartNode, false)) == null || !headingOfAnimate.success)) {
                        this.f28353o = false;
                    }
                    m20087a((AnimationPartCallback) new AnimationPartCallback() {
                        public final void onFinish() {
                            AnimationNewPart.this.m20102d();
                        }
                    }, true);
                }
            }
        }
    }

    /* renamed from: com.didi.map.sdk.nav.car.AnimationNewPart$6 */
    static /* synthetic */ class C100066 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.map.sdk.nav.car.AnimateNodeStatus[] r0 = com.didi.map.sdk.nav.car.AnimateNodeStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus = r0
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.ON_ROAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.OUT_ROAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.ON_BUILDING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.TO_ROAD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimationNewPart.C100066.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m20102d() {
        List<AnimationPartNode> list = this.f28347i;
        if (list != null && list.size() > 1) {
            this.f28347i.remove(0);
        }
        AnimationPartCallback animationPartCallback = this.f28336G;
        if (animationPartCallback != null) {
            animationPartCallback.onFinish();
        }
    }

    /* renamed from: b */
    private List<AnimationPartNode> m20095b(AnimateNode animateNode) {
        boolean z;
        int i;
        AnimateNode animateNode2 = animateNode;
        if (animateNode2 == null) {
            return null;
        }
        if (this.f28344f != null && animateNode2.index >= this.f28344f.size()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (animateNode2.index < 0 || this.f28348j.index < 0 || this.f28344f == null) {
            if (animateNode2.index != -1 || this.f28348j.index < 0) {
                if (animateNode2.index < 0 || this.f28348j.index != -1) {
                    if (DDSphericalUtil.computeDistanceBetween(this.f28348j.latLng, animateNode2.latLng) > ((double) this.f28333D.getCatch_dis())) {
                        arrayList.add(new AnimationPartNode((long) this.f28350l, animateNode2.latLng, animateNode2.index, 0, false, false, true, AnimateNodeStatus.ON_BUILDING));
                        return arrayList;
                    }
                    LatLng latLng = animateNode2.latLng;
                    int i2 = animateNode2.index;
                    arrayList.add(new AnimationPartNode((long) this.f28350l, latLng, i2, 0, false, false, false, AnimateNodeStatus.ON_BUILDING));
                } else if (this.f28341c != CameraMode.CAR_HEAD_UP) {
                    arrayList.add(new AnimationPartNode((long) this.f28350l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, true, true, AnimateNodeStatus.TO_ROAD));
                } else if (DDSphericalUtil.computeDistanceBetween(this.f28348j.latLng, animateNode2.latLng) > ((double) this.f28333D.getCatch_dis())) {
                    arrayList.add(new AnimationPartNode((long) this.f28350l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, true, true, AnimateNodeStatus.TO_ROAD));
                } else {
                    AnimationPartNode animationPartNode = new AnimationPartNode((long) this.f28350l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, true, false, AnimateNodeStatus.TO_ROAD);
                    if (this.f28344f == null || animateNode2.index + 1 >= this.f28344f.size()) {
                        arrayList.add(animationPartNode);
                    } else {
                        animationPartNode.totalDuration = (long) (this.f28350l / 2);
                        AnimationPartNode animationPartNode2 = new AnimationPartNode((long) (this.f28350l / 2), this.f28344f.get(animateNode2.index + 1), animateNode2.index + 1, 0, true, true, false, AnimateNodeStatus.ON_ROAD);
                        arrayList.add(animationPartNode);
                        arrayList.add(animationPartNode2);
                    }
                }
            } else if (DDSphericalUtil.computeDistanceBetween(this.f28348j.latLng, animateNode2.latLng) > ((double) this.f28333D.getCatch_dis())) {
                arrayList.add(new AnimationPartNode((long) this.f28350l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, false, true, AnimateNodeStatus.OUT_ROAD));
                return arrayList;
            } else {
                LatLng latLng2 = animateNode2.latLng;
                int i3 = animateNode2.index;
                int i4 = animateNode2.offSet;
                arrayList.add(new AnimationPartNode((long) this.f28350l, latLng2, i3, i4, false, false, false, AnimateNodeStatus.OUT_ROAD));
            }
        } else if (animateNode2.index < this.f28348j.index) {
            DLog.m7384d(f28327a, "makeReadyNodes index error", new Object[0]);
            return null;
        } else if (animateNode2.index != this.f28348j.index || animateNode2.offSet > this.f28348j.offSet) {
            double onRoadDistance = C10010utils.getOnRoadDistance(this.f28344f, this.f28348j, animateNode2);
            if (onRoadDistance > ((double) this.f28333D.getCatch_dis())) {
                arrayList.add(new AnimationPartNode(10, animateNode2.latLng, animateNode2.index, animateNode2.offSet, true, true, true, AnimateNodeStatus.ON_ROAD));
                return arrayList;
            } else if (animateNode2.index > this.f28348j.index) {
                double d = 1.0d;
                arrayList.add(new AnimationPartNode((long) (((double) this.f28350l) * Math.min(DDSphericalUtil.computeDistanceBetween(this.f28348j.latLng, this.f28344f.get(this.f28348j.index + 1)) / onRoadDistance, 1.0d)), this.f28344f.get(this.f28348j.index + 1), this.f28348j.index + 1, 0, true, true, false, AnimateNodeStatus.ON_ROAD));
                int i5 = this.f28348j.index + 1;
                int i6 = 0;
                while (true) {
                    if (i5 >= animateNode2.index || (i = i5 + 1) >= this.f28344f.size()) {
                        z = false;
                    } else {
                        long min = (long) (((double) this.f28350l) * Math.min(DDSphericalUtil.computeDistanceBetween(this.f28344f.get(i5), this.f28344f.get(i)) / onRoadDistance, d));
                        if (i6 > 10) {
                            if (animateNode2.offSet <= 0) {
                                LatLng latLng3 = animateNode2.latLng;
                                arrayList.add(new AnimationPartNode(min, latLng3, animateNode2.index, 0, true, true, true, AnimateNodeStatus.ON_ROAD));
                            } else {
                                arrayList.add(new AnimationPartNode(min, this.f28344f.get(i), i, 0, true, true, false, AnimateNodeStatus.ON_ROAD));
                            }
                            z = true;
                        } else {
                            arrayList.add(new AnimationPartNode(min, this.f28344f.get(i), i, 0, true, true, false, AnimateNodeStatus.ON_ROAD));
                            i6++;
                            i5 = i;
                            d = 1.0d;
                        }
                    }
                }
                z = false;
                if (animateNode2.offSet > 0) {
                    arrayList.add(new AnimationPartNode((long) (((double) this.f28350l) * Math.min(DDSphericalUtil.computeDistanceBetween(this.f28344f.get(animateNode2.index), animateNode2.latLng) / onRoadDistance, 1.0d)), animateNode2.latLng, animateNode2.index, animateNode2.offSet, true, true, z, AnimateNodeStatus.ON_ROAD));
                }
            } else if (animateNode2.index == this.f28348j.index && animateNode2.offSet > this.f28348j.offSet) {
                arrayList.add(new AnimationPartNode((long) this.f28350l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, true, true, false, AnimateNodeStatus.ON_ROAD));
            }
        } else {
            DLog.m7384d(f28327a, " makeReadyNodes offSet error", new Object[0]);
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    private RotateStatus m20079a(float f, float f2) {
        int i = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        if (i == 0) {
            return null;
        }
        RotateStatus rotateStatus = new RotateStatus();
        int a = m20071a(f);
        int a2 = m20071a(f2);
        if (a == 1) {
            if (a2 == 2) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            } else if (a2 == 4) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = (f + 360.0f) - f2;
                return rotateStatus;
            } else if (a2 == 3) {
                if (180.0f + f > f2) {
                    rotateStatus.isClockise = true;
                    rotateStatus.offsetRotate = f2 - f;
                    return rotateStatus;
                }
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = (f + 360.0f) - f2;
                return rotateStatus;
            } else if (i > 0) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            }
        } else if (a == 2) {
            if (a2 == 3) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            } else if (a2 == 1) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else if (a2 == 4) {
                if (180.0f + f > f2) {
                    rotateStatus.isClockise = true;
                    rotateStatus.offsetRotate = f2 - f;
                    return rotateStatus;
                }
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = (f + 360.0f) - f2;
                return rotateStatus;
            } else if (i > 0) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            }
        } else if (a == 3) {
            if (a2 == 4) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            } else if (a2 == 2) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else if (a2 == 1) {
                if (180.0f + f > f2) {
                    rotateStatus.isClockise = true;
                    rotateStatus.offsetRotate = (360.0f - f) + f2;
                    return rotateStatus;
                }
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else if (i > 0) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            }
        } else if (a2 == 1) {
            rotateStatus.isClockise = true;
            rotateStatus.offsetRotate = (f2 + 360.0f) - f;
            return rotateStatus;
        } else if (a2 == 3) {
            rotateStatus.isClockise = false;
            rotateStatus.offsetRotate = f - f2;
            return rotateStatus;
        } else if (a2 == 2) {
            if (f - 180.0f > f2) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = (360.0f - f) + f2;
                return rotateStatus;
            }
            rotateStatus.isClockise = false;
            rotateStatus.offsetRotate = f - f2;
            return rotateStatus;
        } else if (i > 0) {
            rotateStatus.isClockise = false;
            rotateStatus.offsetRotate = f - f2;
            return rotateStatus;
        } else {
            rotateStatus.isClockise = true;
            rotateStatus.offsetRotate = f2 - f;
            return rotateStatus;
        }
    }

    /* renamed from: b */
    private void m20096b() {
        List<LatLng> list;
        List<AnimationPartNode> list2 = this.f28347i;
        if (list2 != null && list2.size() != 0 && this.f28343e != null && !this.f28352n && this.f28342d != null && this.f28341c == CameraMode.CAR_HEAD_UP) {
            int i = this.f28359v;
            int i2 = this.f28360w;
            if (i <= i2 || (list = this.f28344f) == null || i2 >= list.size()) {
                float f = (float) this.f28342d.getCameraPosition().zoom;
                float a = m20069a(this.f28360w);
                if (f == a || Math.abs(f - a) < 0.2f) {
                    this.f28359v = this.f28360w;
                    return;
                }
                this.f28335F = a;
                this.f28359v = this.f28360w;
            }
        }
    }

    private class LatLngTypeEvaluator implements TypeEvaluator<LatLng> {
        private LatLngTypeEvaluator() {
        }

        public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
            double d = (double) f;
            return new LatLng(((latLng2.latitude - latLng.latitude) * d) + latLng.latitude, ((latLng2.longitude - latLng.longitude) * d) + latLng.longitude);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0130, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0135, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateLines(java.util.List<com.didi.common.map.model.LatLng> r8, com.didi.common.map.model.LatLng r9, com.didi.map.sdk.nav.car.AnimationPartNode r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r9 == 0) goto L_0x0134
            if (r8 == 0) goto L_0x0134
            int r0 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0134
            if (r10 == 0) goto L_0x0134
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            r1 = -1
            if (r0 != r1) goto L_0x0014
            goto L_0x0134
        L_0x0014:
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f28354p     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x001a
            monitor-exit(r7)
            return
        L_0x001a:
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f28354p     // Catch:{ all -> 0x0131 }
            r0.clear()     // Catch:{ all -> 0x0131 }
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f28354p     // Catch:{ all -> 0x0131 }
            r0.add(r9)     // Catch:{ all -> 0x0131 }
            int r0 = r7.f28355q     // Catch:{ all -> 0x0131 }
            int r1 = r10.index     // Catch:{ all -> 0x0131 }
            if (r0 <= r1) goto L_0x0097
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x0031
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            goto L_0x0035
        L_0x0031:
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r0 + 1
        L_0x0035:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r0 < r1) goto L_0x003d
            monitor-exit(r7)
            return
        L_0x003d:
            java.lang.Object r1 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1     // Catch:{ all -> 0x0131 }
            double r2 = r9.latitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.latitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0053
            double r2 = r9.longitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.longitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0058
        L_0x0053:
            java.util.List<com.didi.common.map.model.LatLng> r2 = r7.f28354p     // Catch:{ all -> 0x0131 }
            r2.add(r1)     // Catch:{ all -> 0x0131 }
        L_0x0058:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            int r2 = r7.f28355q     // Catch:{ all -> 0x0131 }
            int r2 = r2 + 1
            if (r1 < r2) goto L_0x0079
            int r1 = r7.f28355q     // Catch:{ all -> 0x0131 }
            if (r0 > r1) goto L_0x0079
            goto L_0x0076
        L_0x0067:
            int r1 = r7.f28355q     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            if (r0 >= r1) goto L_0x0079
            java.util.List<com.didi.common.map.model.LatLng> r1 = r7.f28354p     // Catch:{ all -> 0x0131 }
            java.lang.Object r2 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            r1.add(r2)     // Catch:{ all -> 0x0131 }
        L_0x0076:
            int r0 = r0 + 1
            goto L_0x0067
        L_0x0079:
            com.didi.map.sdk.nav.car.onCarAnimationListener r8 = r7.f28345g     // Catch:{ all -> 0x0131 }
            if (r8 == 0) goto L_0x012f
            com.didi.map.sdk.nav.car.onCarAnimationListener r8 = r7.f28345g     // Catch:{ all -> 0x0131 }
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f28354p     // Catch:{ all -> 0x0131 }
            r8.onErase(r0)     // Catch:{ all -> 0x0131 }
            int r8 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x008c
            int r8 = r8 + -1
        L_0x008c:
            if (r8 < 0) goto L_0x012f
            com.didi.map.sdk.nav.car.onCarAnimationListener r0 = r7.f28345g     // Catch:{ all -> 0x0131 }
            int r10 = r10.offset     // Catch:{ all -> 0x0131 }
            r0.onErase(r8, r10, r9)     // Catch:{ all -> 0x0131 }
            goto L_0x012f
        L_0x0097:
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r0 + 2
            r7.f28355q = r0     // Catch:{ all -> 0x0131 }
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            int r1 = r1 + -1
            if (r0 <= r1) goto L_0x00ad
            int r0 = r8.size()     // Catch:{ all -> 0x0131 }
            int r0 = r0 + -1
            r7.f28355q = r0     // Catch:{ all -> 0x0131 }
        L_0x00ad:
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x00b4
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            goto L_0x00b8
        L_0x00b4:
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r0 + 1
        L_0x00b8:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r0 < r1) goto L_0x00c0
            monitor-exit(r7)
            return
        L_0x00c0:
            java.lang.Object r1 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1     // Catch:{ all -> 0x0131 }
            double r2 = r9.latitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.latitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x00d6
            double r2 = r9.longitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.longitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00db
        L_0x00d6:
            java.util.List<com.didi.common.map.model.LatLng> r2 = r7.f28354p     // Catch:{ all -> 0x0131 }
            r2.add(r1)     // Catch:{ all -> 0x0131 }
        L_0x00db:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            int r2 = r7.f28355q     // Catch:{ all -> 0x0131 }
            int r2 = r2 + 1
            if (r1 < r2) goto L_0x00fc
            int r1 = r7.f28355q     // Catch:{ all -> 0x0131 }
            if (r0 > r1) goto L_0x00fc
            goto L_0x00f9
        L_0x00ea:
            int r1 = r7.f28355q     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            if (r0 >= r1) goto L_0x00fc
            java.util.List<com.didi.common.map.model.LatLng> r1 = r7.f28354p     // Catch:{ all -> 0x0131 }
            java.lang.Object r2 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            r1.add(r2)     // Catch:{ all -> 0x0131 }
        L_0x00f9:
            int r0 = r0 + 1
            goto L_0x00ea
        L_0x00fc:
            com.didi.map.sdk.nav.car.onCarAnimationListener r0 = r7.f28345g     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x012f
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0131 }
            r0.<init>()     // Catch:{ all -> 0x0131 }
            int r1 = r7.f28355q     // Catch:{ all -> 0x0131 }
        L_0x0107:
            int r2 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r1 >= r2) goto L_0x0117
            java.lang.Object r2 = r8.get(r1)     // Catch:{ all -> 0x0131 }
            r0.add(r2)     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            goto L_0x0107
        L_0x0117:
            com.didi.map.sdk.nav.car.onCarAnimationListener r8 = r7.f28345g     // Catch:{ all -> 0x0131 }
            java.util.List<com.didi.common.map.model.LatLng> r1 = r7.f28354p     // Catch:{ all -> 0x0131 }
            r8.onUpdateAllLine(r1, r0)     // Catch:{ all -> 0x0131 }
            int r8 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x0126
            int r8 = r8 + -1
        L_0x0126:
            if (r8 < 0) goto L_0x012f
            com.didi.map.sdk.nav.car.onCarAnimationListener r0 = r7.f28345g     // Catch:{ all -> 0x0131 }
            int r10 = r10.offset     // Catch:{ all -> 0x0131 }
            r0.onErase(r8, r10, r9)     // Catch:{ all -> 0x0131 }
        L_0x012f:
            monitor-exit(r7)
            return
        L_0x0131:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0134:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimationNewPart.updateLines(java.util.List, com.didi.common.map.model.LatLng, com.didi.map.sdk.nav.car.AnimationPartNode):void");
    }

    /* renamed from: a */
    private void m20085a(LatLng latLng) {
        if (latLng != null) {
            CarMarker carMarker = this.f28343e;
            if (carMarker != null) {
                carMarker.setPosition(latLng);
            }
            if (this.f28342d != null && this.f28358u) {
                CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                cameraUpdateParams.latLng = latLng;
                cameraUpdateParams.bearing = this.f28342d.getCameraPosition().bearing;
                float f = this.f28335F;
                if (f >= 0.0f) {
                    cameraUpdateParams.level = (double) f;
                } else {
                    cameraUpdateParams.level = this.f28342d.getCameraPosition().zoom;
                }
                cameraUpdateParams.tilt = (float) m20072a(this.f28341c);
                this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams));
            }
        }
    }

    /* renamed from: a */
    private void m20083a(float f, boolean z) {
        CarMarker carMarker = this.f28343e;
        if (carMarker != null) {
            if (carMarker != null && (this.f28341c != CameraMode.CAR_HEAD_UP || this.f28358u || z)) {
                this.f28343e.setRotation(f);
            }
            if (this.f28341c == CameraMode.NORTH_UP) {
                Map map = this.f28342d;
                if (map != null && map.getCameraPosition().bearing != 0.0f) {
                    CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                    cameraUpdateParams.latLng = this.f28343e.getPosition();
                    cameraUpdateParams.level = this.f28342d.getCameraPosition().zoom;
                    cameraUpdateParams.bearing = 0.0f;
                    this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams));
                }
            } else if (this.f28358u) {
                if (z && this.f28342d != null) {
                    CameraUpdate.CameraUpdateParams cameraUpdateParams2 = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                    cameraUpdateParams2.latLng = this.f28343e.getPosition();
                    cameraUpdateParams2.level = this.f28342d.getCameraPosition().zoom;
                    cameraUpdateParams2.bearing = f;
                    cameraUpdateParams2.tilt = (float) m20072a(this.f28341c);
                    this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams2));
                }
                m20090a(z);
            }
        }
    }

    /* renamed from: a */
    private void m20090a(boolean z) {
        NavOverlay navOverlay;
        CarMarker carMarker;
        CarMarker carMarker2;
        if (this.f28342d == null || !ApolloUtil.shouldRemoveCarImage()) {
            if (!this.f28358u || !z || this.f28341c != CameraMode.CAR_HEAD_UP) {
                if (this.f28343e != null && (navOverlay = this.f28346h) != null) {
                    navOverlay.setVisible(false);
                    this.f28343e.setVisible(true);
                }
            } else if (this.f28346h != null && (carMarker = this.f28343e) != null) {
                carMarker.setVisible(false);
                this.f28346h.setVisible(true);
            }
        } else if (this.f28346h != null && (carMarker2 = this.f28343e) != null) {
            carMarker2.setVisible(true);
            this.f28346h.setVisible(false);
        }
    }

    public void setCameraMode(CameraMode cameraMode, boolean z) {
        if (this.f28341c != cameraMode || z) {
            if (!(this.f28343e == null || this.f28342d == null)) {
                if (this.f28341c == CameraMode.CAR_HEAD_UP) {
                    this.f28343e.restoreMarkerIcon();
                    CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                    cameraUpdateParams.latLng = this.f28342d.getCameraPosition().target;
                    cameraUpdateParams.level = this.f28342d.getCameraPosition().zoom;
                    cameraUpdateParams.bearing = 0.0f;
                    this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams));
                } else {
                    this.f28343e.enlargeMarkerIcon();
                    if (z) {
                        CameraUpdate.CameraUpdateParams cameraUpdateParams2 = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                        cameraUpdateParams2.latLng = this.f28343e.getPosition();
                        int i = this.f28360w;
                        if (i > 0) {
                            cameraUpdateParams2.level = (double) m20069a(i);
                        } else {
                            cameraUpdateParams2.level = this.f28332C;
                        }
                        cameraUpdateParams2.bearing = (float) m20098c();
                        cameraUpdateParams2.tilt = (float) m20072a(CameraMode.CAR_HEAD_UP);
                        this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams2));
                        m20085a(this.f28343e.getPosition());
                    }
                }
            }
            this.f28358u = false;
            this.f28341c = cameraMode;
            if (cameraMode == CameraMode.CAR_HEAD_UP) {
                this.f28343e.setFlat(true);
            } else {
                this.f28343e.setFlat(false);
            }
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        setCameraMode(cameraMode, true);
    }

    public void setCarImageView(NavOverlay navOverlay) {
        this.f28346h = navOverlay;
    }

    public void followMyLocation(boolean z) {
        this.f28358u = z;
        m20090a(false);
    }

    public void zoomToNav() {
        this.f28358u = true;
        this.f28341c = CameraMode.CAR_HEAD_UP;
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
        int i = this.f28360w;
        if (i > 0) {
            cameraUpdateParams.level = (double) m20069a(i);
        } else {
            cameraUpdateParams.level = (this.f28331B + this.f28332C) / 2.0d;
        }
        cameraUpdateParams.bearing = (float) m20098c();
        CarMarker carMarker = this.f28343e;
        if (carMarker != null) {
            carMarker.setRotation(cameraUpdateParams.bearing);
            cameraUpdateParams.latLng = this.f28343e.getPosition();
        } else {
            cameraUpdateParams.latLng = this.f28342d.getCameraPosition().target;
        }
        cameraUpdateParams.tilt = (float) m20072a(this.f28341c);
        this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams));
        CarMarker carMarker2 = this.f28343e;
        if (carMarker2 != null) {
            m20085a(carMarker2.getPosition());
        }
    }

    public void setCarHeadParams(int i, int i2) {
        this.f28363z = i;
        this.f28340K = i2;
    }

    public double distanceLeft() {
        List<LatLng> list = this.f28344f;
        if (list == null || list.isEmpty()) {
            return -1.0d;
        }
        List<LatLng> list2 = this.f28344f;
        AnimateNode animateNode = new AnimateNode(list2.get(list2.size() - 1), this.f28344f.size() - 1, 0, false);
        AnimateNode animateNode2 = this.f28348j;
        if (animateNode2 != null && animateNode2.index >= 0) {
            return C10010utils.getOnRoadDistance(this.f28344f, this.f28348j, animateNode);
        }
        CarMarker carMarker = this.f28343e;
        if (carMarker == null || carMarker.getPosition() == null) {
            return -1.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(this.f28343e.getPosition(), animateNode.latLng);
    }

    public void setCarMarkerOrImageEnable(boolean z) {
        this.f28334E = z;
    }

    public void setCarHeadMaxMapLevel(double d) {
        Map map = this.f28342d;
        if (map != null && map.getMapVendor() == MapVendor.GOOGLE) {
            this.f28332C = d;
            DLog.m7384d(f28327a, "AutoBackController setCarHeadMaxMapLevel = " + d, new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        if (r0 < r2) goto L_0x0077;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float m20069a(int r5) {
        /*
            r4 = this;
            double r0 = r4.f28331B
            java.util.List<com.didi.common.map.model.LatLng> r2 = r4.f28344f
            if (r2 == 0) goto L_0x0071
            int r2 = r2.size()
            if (r5 >= r2) goto L_0x0071
            if (r5 <= 0) goto L_0x0071
            com.didi.map.sdk.nav.car.CarMarker r2 = r4.f28343e
            if (r2 == 0) goto L_0x0071
            com.didi.common.map.Map r2 = r4.f28342d
            if (r2 == 0) goto L_0x0071
            java.util.List<com.didi.common.map.model.LatLng> r0 = r4.f28344f
            java.lang.Object r5 = r0.get(r5)
            com.didi.common.map.model.LatLng r5 = (com.didi.common.map.model.LatLng) r5
            com.didi.map.sdk.nav.car.CarMarker r0 = r4.f28343e
            com.didi.common.map.model.LatLng r0 = r0.getPosition()
            double r0 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r5, r0)
            com.didi.map.sdk.nav.car.DriverCarNewAnimApollo r5 = com.didi.map.sdk.nav.car.DriverCarNewAnimApollo.getInstance()
            boolean r5 = r5.enable()
            if (r5 == 0) goto L_0x0044
            com.didi.map.sdk.nav.car.DriverCarNewAnimApollo r5 = com.didi.map.sdk.nav.car.DriverCarNewAnimApollo.getInstance()
            int r5 = r5.getMapTiltValue()
            double r2 = (double) r5
            double r2 = com.didi.map.sdk.nav.car.C10010utils.angle2Rad(r2)
            double r2 = java.lang.Math.cos(r2)
            double r0 = r0 / r2
        L_0x0044:
            r2 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r0 = r0 * r2
            int r5 = r4.f28363z
            float r5 = (float) r5
            r2 = 1116733440(0x42900000, float:72.0)
            float r5 = r5 * r2
            com.didi.common.map.Map r2 = r4.f28342d
            android.content.Context r2 = r2.getContext()
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.ydpi
            float r5 = r5 / r2
            double r2 = (double) r5
            double r0 = r0 / r2
            com.didi.map.sdk.nav.car.CarMarker r5 = r4.f28343e
            com.didi.common.map.model.LatLng r5 = r5.getPosition()
            double r2 = r5.latitude
            double r0 = com.didi.map.sdk.nav.util.VisibleUtil.getBestZoomByMetersPerPonit(r2, r0)
        L_0x0071:
            double r2 = r4.f28332C
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0079
        L_0x0077:
            r0 = r2
            goto L_0x0080
        L_0x0079:
            double r2 = r4.f28331B
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0080
            goto L_0x0077
        L_0x0080:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "AutoBackController getNavZoomLevel level = "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "AnimationNewPart"
            com.didi.common.map.util.DLog.m7384d(r3, r5, r2)
            float r5 = (float) r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimationNewPart.m20069a(int):float");
    }

    /* renamed from: b */
    private double m20092b(int i) {
        List<LatLng> list;
        if (this.f28342d == null || (list = this.f28344f) == null || list.isEmpty() || this.f28343e == null) {
            return 0.0d;
        }
        double d = this.f28332C;
        float width = (float) this.f28342d.getWidth();
        float f = (float) this.f28363z;
        if (width <= 0.0f) {
            width = 1.0f;
        }
        if (f <= 0.0f) {
            f = 1.0f;
        }
        MapUtils.getSymmetry(this.f28343e.getPosition(), this.f28344f.get(i));
        LatLngBounds.Builder builder = LatLngBounds.builder();
        builder.include(this.f28344f.get(i));
        builder.include(this.f28343e.getPosition());
        LatLngBounds build = builder.build();
        float f2 = (float) d;
        float lng2Pixel = lng2Pixel(this.f28342d.getContext(), build.northeast.longitude, f2);
        float lat2Pixel = lat2Pixel(this.f28342d.getContext(), build.northeast.latitude, f2);
        float lng2Pixel2 = lng2Pixel(this.f28342d.getContext(), build.southwest.longitude, f2);
        float abs = Math.abs(lat2Pixel - lat2Pixel(this.f28342d.getContext(), build.southwest.latitude, f2));
        float abs2 = Math.abs(lng2Pixel - lng2Pixel2);
        if (abs / abs2 > f / width) {
            width = f;
        } else {
            abs = abs2;
        }
        Map map = this.f28342d;
        if (map == null || map.getCameraPosition() == null) {
            DLog.m7384d(f28327a, "map == null or getCameraPosition == null", new Object[0]);
            return 2.0d;
        }
        float log10 = (float) (Math.log10((double) ((width / (abs / ((float) (((double) TypedValue.applyDimension(1, 256.0f, this.f28342d.getContext().getResources().getDisplayMetrics())) * Math.pow(2.0d, d))))) / TypedValue.applyDimension(1, 256.0f, this.f28342d.getContext().getResources().getDisplayMetrics()))) / Math.log10(2.0d));
        if (Float.isNaN(log10)) {
            return this.f28342d.getMaxZoomLevel();
        }
        double d2 = (double) log10;
        if (d2 > this.f28342d.getMaxZoomLevel()) {
            return this.f28342d.getMaxZoomLevel();
        }
        if (d2 < this.f28342d.getMinZoomLevel()) {
            return this.f28342d.getMinZoomLevel();
        }
        DLog.m7384d(f28327a, "The bestLevel = " + log10 + ", from Level = " + this.f28342d.getCameraPosition().zoom, new Object[0]);
        return d2;
    }

    public static float lng2Pixel(Context context, double d, float f) {
        return (float) (((d + 180.0d) * (((double) TypedValue.applyDimension(1, 256.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f))) / 360.0d);
    }

    public static float lat2Pixel(Context context, double d, float f) {
        double sin = Math.sin((d * 3.141592653589793d) / 180.0d);
        return (float) (((double) TypedValue.applyDimension(1, 128.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f) * (1.0d - (Math.log((sin + 1.0d) / (1.0d - sin)) / 6.283185307179586d)));
    }

    /* renamed from: c */
    private double m20098c() {
        LatLng latLng;
        Map map = this.f28342d;
        double d = map != null ? (double) map.getCameraPosition().bearing : 0.0d;
        int i = 0;
        List<LatLng> list = this.f28344f;
        LatLng latLng2 = null;
        if (list == null || list.size() <= 0) {
            CarMarker carMarker = this.f28343e;
            if (carMarker != null && ((double) carMarker.getRotation()) != 0.0d) {
                return (((double) this.f28343e.getRotation()) + 360.0d) % 360.0d;
            }
            latLng = null;
        } else {
            AnimateNode animateNode = this.f28348j;
            if (animateNode != null) {
                if (-1 == animateNode.index) {
                    AnimateNode animateNode2 = this.f28330A;
                    if (animateNode2 == null || animateNode2.index == -1) {
                        i = this.f28340K;
                    } else {
                        i = this.f28330A.index;
                    }
                } else {
                    i = this.f28348j.index;
                }
            }
            LatLng latLng3 = this.f28344f.size() > i ? this.f28344f.get(i) : null;
            int i2 = i + 1;
            if (this.f28344f.size() > i2) {
                latLng2 = this.f28344f.get(i2);
            }
            latLng = latLng2;
            latLng2 = latLng3;
        }
        return (latLng2 == null || latLng == null) ? d : (DDSphericalUtil.computeHeading(latLng2, latLng) + 360.0d) % 360.0d;
    }

    public AnimateNode getCurrentAnimNode() {
        return this.f28348j;
    }

    public void resetMapTilt() {
        Map map;
        if (DriverCarNewAnimApollo.getInstance().enable() && (map = this.f28342d) != null && map.getCameraPosition() != null) {
            CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
            cameraUpdateParams.latLng = this.f28342d.getCameraPosition().target;
            cameraUpdateParams.level = this.f28342d.getCameraPosition().zoom;
            cameraUpdateParams.bearing = this.f28342d.getCameraPosition().bearing;
            cameraUpdateParams.tilt = 0.0f;
            this.f28342d.moveCamera(new CameraUpdate(cameraUpdateParams));
        }
    }

    /* renamed from: a */
    private int m20072a(CameraMode cameraMode) {
        if (DriverCarNewAnimApollo.getInstance().enable() && cameraMode == CameraMode.CAR_HEAD_UP) {
            return DriverCarNewAnimApollo.getInstance().getMapTiltValue();
        }
        return 0;
    }
}
