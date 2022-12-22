package com.didi.map.global.component.departure.canoe.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.common.map.Map;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.pin.IDeparturePinView;
import com.didi.map.global.component.departure.pin.PinView;
import com.taxis99.R;

public class CanoeDeparturePinView extends RelativeLayout implements IDeparturePinView {

    /* renamed from: a */
    private static final String f24989a = "CanoeDeparturePinView";

    /* renamed from: b */
    private static final String f24990b = "lottie_departure_loading.json";

    /* renamed from: c */
    private static final String f24991c = "lottie_no_parking.json";

    /* renamed from: d */
    private PinView f24992d;

    /* renamed from: e */
    private RelativeLayout f24993e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LottieAnimationView f24994f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LottieAnimationView f24995g;

    /* renamed from: h */
    private View f24996h;

    /* renamed from: i */
    private int f24997i;

    /* renamed from: j */
    private int f24998j;

    /* renamed from: k */
    private boolean f24999k;

    /* renamed from: l */
    private AnimatorSet f25000l;

    /* renamed from: m */
    private AnimationSet f25001m;

    /* renamed from: n */
    private AnimationSet f25002n;

    /* renamed from: o */
    private Map f25003o;

    /* renamed from: p */
    private PinStyle f25004p;

    public CanoeDeparturePinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CanoeDeparturePinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanoeDeparturePinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24999k = false;
        m17862a(context);
    }

    /* renamed from: a */
    private void m17862a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_canoe_departure_pin_view, this);
        this.f24992d = (PinView) inflate.findViewById(R.id.pin);
        this.f24993e = (RelativeLayout) inflate.findViewById(R.id.container);
        this.f24994f = (LottieAnimationView) inflate.findViewById(R.id.loading_lottie);
        this.f24995g = (LottieAnimationView) inflate.findViewById(R.id.no_parking_lottie);
        this.f24994f.setAnimation(f24990b);
        this.f24994f.setRepeatCount(-1);
        this.f24995g.setAnimation(f24991c);
        this.f24995g.setRepeatCount(0);
        this.f24997i = this.f24992d.getBigCircleWidth();
        this.f24998j = this.f24992d.getBigCircleHeight();
        startDragging_Ex();
    }

    public void startDragging_Ex() {
        startShowPin(200);
    }

    public void startDragging() {
        startShowPin(400);
    }

    public void startShowPin(long j) {
        PinView pinView = this.f24992d;
        if (pinView != null && !pinView.isDragging()) {
            setPinStartEndColor(false);
            m17869c();
            m17874f();
            this.f24993e.removeView(this.f24996h);
            this.f24996h = null;
            m17860a(this.f24992d.getDraggingWidth(), this.f24992d.getDraggingHeight(), false, j);
            this.f24992d.toDragging();
            this.f24999k = false;
        }
    }

    public void startLoading(boolean z) {
        PinView pinView = this.f24992d;
        if (pinView != null && !pinView.isLoading()) {
            setPinStartEndColor(z);
            m17866b();
            m17874f();
            this.f24993e.removeView(this.f24996h);
            this.f24996h = null;
            m17860a(this.f24992d.getLoadingWidth(), this.f24992d.getLoadingHeight(), true, 400);
            this.f24992d.toLoading();
            this.f24999k = false;
        }
    }

    public void showText(String str) {
        PinView pinView;
        if (TextUtils.isEmpty(str) || (pinView = this.f24992d) == null) {
            return;
        }
        if (!pinView.isNormal() || !str.equalsIgnoreCase(this.f24992d.getText())) {
            setPinStartEndColor(false);
            m17869c();
            m17874f();
            this.f24993e.removeView(this.f24996h);
            this.f24996h = null;
            this.f24992d.showText(str);
            m17860a(this.f24992d.getNormalWidth(), this.f24992d.getNormalHeight(), false, 400);
            this.f24999k = false;
        }
    }

    public void showView(View view, int i, int i2, int i3) {
        if (view != null && i > 0 && i2 > 0 && i3 > 0 && this.f24996h != view) {
            setPinStartEndColor(false);
            m17869c();
            m17874f();
            this.f24993e.removeView(this.f24996h);
            this.f24996h = view;
            if (this.f24993e.indexOfChild(view) < 0) {
                this.f24993e.addView(view);
            }
            m17860a(i, i2, true, 400);
            this.f24992d.animSetBigCircleWidthHeightAngle(i, i2, i3);
            this.f24999k = false;
        }
    }

    public void toNoParking() {
        if (!this.f24999k) {
            setPinStartEndColor(true);
            m17869c();
            m17873e();
            this.f24993e.removeView(this.f24996h);
            this.f24996h = null;
            int draggingWidth = this.f24992d.getDraggingWidth();
            int draggingHeight = this.f24992d.getDraggingHeight();
            m17860a(draggingWidth, draggingHeight, false, 400);
            this.f24992d.animSetBigCircleWidthHeightAngle(draggingWidth, draggingHeight, PinView.DRAGGING_BIG_CIRCLE_RADIUS_PX);
            this.f24999k = true;
        }
    }

    public void stopAnimation() {
        this.f24992d.stopAnimation();
        if (this.f24994f.isAnimating()) {
            this.f24994f.cancelAnimation();
        }
        if (this.f24995g.isAnimating()) {
            this.f24995g.cancelAnimation();
        }
        m17859a();
        m17872d();
        m17875g();
    }

    /* renamed from: a */
    private void m17860a(int i, int i2, boolean z, long j) {
        m17859a();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f25000l = animatorSet;
        animatorSet.setDuration(j);
        this.f25000l.playTogether(new Animator[]{m17856a(this.f24997i, i), m17863b(this.f24998j, i2), m17857a(z)});
        this.f25000l.start();
    }

    /* renamed from: a */
    private void m17859a() {
        AnimatorSet animatorSet = this.f25000l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f25000l = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m17856a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CanoeDeparturePinView.this.m17871c(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m17871c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f24997i = intValue;
        m17870c(intValue, this.f24998j);
    }

    /* renamed from: b */
    private ValueAnimator m17863b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CanoeDeparturePinView.this.m17867b(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m17867b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f24998j = intValue;
        m17870c(this.f24997i, intValue);
    }

    /* renamed from: a */
    private ValueAnimator m17857a(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CanoeDeparturePinView.this.m17861a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17861a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f24993e.setAlpha(floatValue);
        View view = this.f24996h;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void setPinStartEndColor(boolean z) {
        PinView pinView = this.f24992d;
        pinView.setPinStartEndColor(this.f24999k ? pinView.getNoParkingColor() : pinView.getNormalColor(), z ? this.f24992d.getNoParkingColor() : this.f24992d.getNormalColor());
    }

    /* renamed from: c */
    private void m17870c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f24993e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f24993e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m17866b() {
        m17872d();
        AnimationSet animationSet = new AnimationSet(false);
        this.f25001m = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                CanoeDeparturePinView.this.f24994f.setProgress(0.0f);
                CanoeDeparturePinView.this.f24994f.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                CanoeDeparturePinView.this.f24994f.playAnimation();
            }
        });
        this.f25001m.addAnimation(m17868c(true));
        this.f25001m.addAnimation(m17864b(true));
        this.f25001m.setDuration(400);
        this.f25001m.setFillAfter(true);
        this.f24994f.startAnimation(this.f25001m);
    }

    /* renamed from: c */
    private void m17869c() {
        if (this.f24994f.getVisibility() == 0 || this.f24994f.isShown()) {
            m17872d();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25001m = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CanoeDeparturePinView.this.f24994f.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    CanoeDeparturePinView.this.f24994f.setVisibility(4);
                    CanoeDeparturePinView.this.f24994f.setProgress(0.0f);
                }
            });
            this.f25001m.addAnimation(m17868c(false));
            this.f25001m.addAnimation(m17864b(false));
            this.f25001m.setDuration(400);
            this.f25001m.setFillAfter(true);
            this.f24994f.startAnimation(this.f25001m);
            return;
        }
        this.f24994f.setVisibility(4);
    }

    /* renamed from: d */
    private void m17872d() {
        AnimationSet animationSet = this.f25001m;
        if (animationSet != null) {
            animationSet.cancel();
            this.f25001m = null;
        }
    }

    /* renamed from: e */
    private void m17873e() {
        if (this.f24995g.getVisibility() != 0 || !this.f24995g.isShown()) {
            m17875g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25002n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CanoeDeparturePinView.this.f24995g.setProgress(0.0f);
                    CanoeDeparturePinView.this.f24995g.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    CanoeDeparturePinView.this.f24995g.playAnimation();
                }
            });
            this.f25002n.addAnimation(m17868c(true));
            this.f25002n.addAnimation(m17864b(true));
            this.f25002n.setDuration(400);
            this.f25002n.setFillAfter(true);
            this.f24995g.startAnimation(this.f25002n);
        }
    }

    /* renamed from: f */
    private void m17874f() {
        if (this.f24995g.getVisibility() == 0 || this.f24995g.isShown()) {
            m17875g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25002n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CanoeDeparturePinView.this.f24995g.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    CanoeDeparturePinView.this.f24995g.setVisibility(4);
                }
            });
            this.f25002n.addAnimation(m17868c(false));
            this.f25002n.addAnimation(m17864b(false));
            this.f25002n.setDuration(400);
            this.f25002n.setFillAfter(true);
            this.f24995g.startAnimation(this.f25002n);
            return;
        }
        this.f24995g.setVisibility(4);
    }

    /* renamed from: g */
    private void m17875g() {
        AnimationSet animationSet = this.f25002n;
        if (animationSet != null) {
            animationSet.cancel();
            this.f25002n = null;
        }
    }

    /* renamed from: b */
    private AlphaAnimation m17864b(boolean z) {
        AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        return alphaAnimation;
    }

    /* renamed from: c */
    private ScaleAnimation m17868c(boolean z) {
        ScaleAnimation scaleAnimation;
        if (z) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        } else {
            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        }
        scaleAnimation.setDuration(400);
        return scaleAnimation;
    }

    public void create(Context context, Map map) {
        this.f25003o = map;
    }

    public void destroy() {
        stopAnimation();
        this.f25004p = null;
        Map map = this.f25003o;
        if (map != null) {
            map.removeTopView();
        }
        this.f25003o = null;
        this.f24992d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f25004p = pinStyle;
            if (this.f24992d != null) {
                this.f24992d.setPinColor(pinStyle.pinNormalColor != 0 ? pinStyle.pinNormalColor : PinView.DEFAULT_COLOR, pinStyle.pintNoParkingColor != 0 ? pinStyle.pintNoParkingColor : PinView.NO_PARKING_COLOR);
            }
        }
    }

    public void onMapVisible(boolean z) {
        if (!z) {
            stopAnimation();
        }
    }

    public void add() {
        PinStyle pinStyle;
        Map map = this.f25003o;
        if (map != null && (pinStyle = this.f25004p) != null) {
            map.setTopViewToCenter(this, pinStyle.anchorX, this.f25004p.anchorY);
        }
    }

    public void remove() {
        Map map = this.f25003o;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void visible(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    public boolean isVisible() {
        return isShown();
    }

    public Rect getWindowPosition() {
        return new Rect(getLeft(), getTop(), getRight(), getBottom() - DisplayUtils.dp2px(getContext(), 20.0f));
    }
}
