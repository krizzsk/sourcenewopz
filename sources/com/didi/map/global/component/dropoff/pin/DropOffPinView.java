package com.didi.map.global.component.dropoff.pin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
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
import com.taxis99.R;

public class DropOffPinView extends RelativeLayout implements IDropOffPinView {

    /* renamed from: a */
    private static final String f25521a = "DeparturePinView";

    /* renamed from: b */
    private static final String f25522b = "lottie_departure_loading.json";

    /* renamed from: c */
    private static final String f25523c = "lottie_no_parking.json";

    /* renamed from: d */
    private PinView f25524d;

    /* renamed from: e */
    private RelativeLayout f25525e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LottieAnimationView f25526f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LottieAnimationView f25527g;

    /* renamed from: h */
    private View f25528h;

    /* renamed from: i */
    private int f25529i;

    /* renamed from: j */
    private int f25530j;

    /* renamed from: k */
    private boolean f25531k;

    /* renamed from: l */
    private AnimatorSet f25532l;

    /* renamed from: m */
    private AnimationSet f25533m;

    /* renamed from: n */
    private AnimationSet f25534n;

    /* renamed from: o */
    private Map f25535o;

    /* renamed from: p */
    private PinStyle f25536p;

    public DropOffPinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DropOffPinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropOffPinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25531k = false;
        m18248a(context);
    }

    /* renamed from: a */
    private void m18248a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dropoff_pin_view, this);
        this.f25524d = (PinView) inflate.findViewById(R.id.pin);
        this.f25525e = (RelativeLayout) inflate.findViewById(R.id.container);
        this.f25526f = (LottieAnimationView) inflate.findViewById(R.id.loading_lottie);
        this.f25527g = (LottieAnimationView) inflate.findViewById(R.id.no_parking_lottie);
        this.f25526f.setAnimation(f25522b);
        this.f25526f.setRepeatCount(-1);
        this.f25527g.setAnimation(f25523c);
        this.f25527g.setRepeatCount(0);
        this.f25529i = this.f25524d.getBigCircleWidth();
        this.f25530j = this.f25524d.getBigCircleHeight();
        startDragging_Ex();
    }

    public void startDragging_Ex() {
        startShowPin(200);
    }

    public void startDragging() {
        startShowPin(400);
    }

    public void startShowPin(long j) {
        PinView pinView = this.f25524d;
        if (pinView != null && !pinView.isDragging()) {
            setPinStartEndColor(false);
            m18255c();
            m18260f();
            this.f25525e.removeView(this.f25528h);
            this.f25528h = null;
            m18246a(this.f25524d.getDraggingWidth(), this.f25524d.getDraggingHeight(), false, j);
            this.f25524d.toDragging();
            this.f25531k = false;
        }
    }

    public void startLoading(boolean z) {
        PinView pinView = this.f25524d;
        if (pinView != null && !pinView.isLoading()) {
            setPinStartEndColor(z);
            m18252b();
            m18260f();
            this.f25525e.removeView(this.f25528h);
            this.f25528h = null;
            m18246a(this.f25524d.getLoadingWidth(), this.f25524d.getLoadingHeight(), true, 400);
            this.f25524d.toLoading();
            this.f25531k = false;
        }
    }

    public void showText(String str) {
        PinView pinView;
        if (TextUtils.isEmpty(str) || (pinView = this.f25524d) == null) {
            return;
        }
        if (!pinView.isNormal() || !str.equalsIgnoreCase(this.f25524d.getText())) {
            setPinStartEndColor(false);
            m18255c();
            m18260f();
            this.f25525e.removeView(this.f25528h);
            this.f25528h = null;
            this.f25524d.showText(str);
            m18246a(this.f25524d.getNormalWidth(), this.f25524d.getNormalHeight(), false, 400);
            this.f25531k = false;
        }
    }

    public void showView(View view, int i, int i2, int i3) {
        if (view != null && i > 0 && i2 > 0 && i3 > 0 && this.f25528h != view) {
            setPinStartEndColor(false);
            m18255c();
            m18260f();
            this.f25525e.removeView(this.f25528h);
            this.f25528h = view;
            if (this.f25525e.indexOfChild(view) < 0) {
                this.f25525e.addView(view);
            }
            m18246a(i, i2, true, 400);
            this.f25524d.animSetBigCircleWidthHeightAngle(i, i2, i3);
            this.f25531k = false;
        }
    }

    public void toNoParking() {
        if (!this.f25531k) {
            setPinStartEndColor(true);
            m18255c();
            m18259e();
            this.f25525e.removeView(this.f25528h);
            this.f25528h = null;
            int draggingWidth = this.f25524d.getDraggingWidth();
            int draggingHeight = this.f25524d.getDraggingHeight();
            m18246a(draggingWidth, draggingHeight, false, 400);
            this.f25524d.animSetBigCircleWidthHeightAngle(draggingWidth, draggingHeight, PinView.DRAGGING_BIG_CIRCLE_RADIUS_PX);
            this.f25531k = true;
        }
    }

    public void stopAnimation() {
        this.f25524d.stopAnimation();
        if (this.f25526f.isAnimating()) {
            this.f25526f.cancelAnimation();
        }
        if (this.f25527g.isAnimating()) {
            this.f25527g.cancelAnimation();
        }
        m18245a();
        m18258d();
        m18261g();
    }

    /* renamed from: a */
    private void m18246a(int i, int i2, boolean z, long j) {
        m18245a();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f25532l = animatorSet;
        animatorSet.setDuration(j);
        this.f25532l.playTogether(new Animator[]{m18242a(this.f25529i, i), m18249b(this.f25530j, i2), m18243a(z)});
        this.f25532l.start();
    }

    /* renamed from: a */
    private void m18245a() {
        AnimatorSet animatorSet = this.f25532l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f25532l = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m18242a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropOffPinView.this.m18257c(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18257c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f25529i = intValue;
        m18256c(intValue, this.f25530j);
    }

    /* renamed from: b */
    private ValueAnimator m18249b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropOffPinView.this.m18253b(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18253b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f25530j = intValue;
        m18256c(this.f25529i, intValue);
    }

    /* renamed from: a */
    private ValueAnimator m18243a(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropOffPinView.this.m18247a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18247a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f25525e.setAlpha(floatValue);
        View view = this.f25528h;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void setPinStartEndColor(boolean z) {
        PinView pinView = this.f25524d;
        pinView.setPinStartEndColor(this.f25531k ? pinView.getNoParkingColor() : pinView.getNormalColor(), z ? this.f25524d.getNoParkingColor() : this.f25524d.getNormalColor());
    }

    /* renamed from: c */
    private void m18256c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f25525e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f25525e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m18252b() {
        m18258d();
        AnimationSet animationSet = new AnimationSet(false);
        this.f25533m = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                DropOffPinView.this.f25526f.setProgress(0.0f);
                DropOffPinView.this.f25526f.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                DropOffPinView.this.f25526f.playAnimation();
            }
        });
        this.f25533m.addAnimation(m18254c(true));
        this.f25533m.addAnimation(m18250b(true));
        this.f25533m.setDuration(400);
        this.f25533m.setFillAfter(true);
        this.f25526f.startAnimation(this.f25533m);
    }

    /* renamed from: c */
    private void m18255c() {
        if (this.f25526f.getVisibility() == 0 || this.f25526f.isShown()) {
            m18258d();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25533m = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DropOffPinView.this.f25526f.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DropOffPinView.this.f25526f.setVisibility(4);
                    DropOffPinView.this.f25526f.setProgress(0.0f);
                }
            });
            this.f25533m.addAnimation(m18254c(false));
            this.f25533m.addAnimation(m18250b(false));
            this.f25533m.setDuration(400);
            this.f25533m.setFillAfter(true);
            this.f25526f.startAnimation(this.f25533m);
            return;
        }
        this.f25526f.setVisibility(4);
    }

    /* renamed from: d */
    private void m18258d() {
        AnimationSet animationSet = this.f25533m;
        if (animationSet != null) {
            animationSet.cancel();
            this.f25533m = null;
        }
    }

    /* renamed from: e */
    private void m18259e() {
        if (this.f25527g.getVisibility() != 0 || !this.f25527g.isShown()) {
            m18261g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25534n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DropOffPinView.this.f25527g.setProgress(0.0f);
                    DropOffPinView.this.f25527g.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    DropOffPinView.this.f25527g.playAnimation();
                }
            });
            this.f25534n.addAnimation(m18254c(true));
            this.f25534n.addAnimation(m18250b(true));
            this.f25534n.setDuration(400);
            this.f25534n.setFillAfter(true);
            this.f25527g.startAnimation(this.f25534n);
        }
    }

    /* renamed from: f */
    private void m18260f() {
        if (this.f25527g.getVisibility() == 0 || this.f25527g.isShown()) {
            m18261g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25534n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DropOffPinView.this.f25527g.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DropOffPinView.this.f25527g.setVisibility(4);
                }
            });
            this.f25534n.addAnimation(m18254c(false));
            this.f25534n.addAnimation(m18250b(false));
            this.f25534n.setDuration(400);
            this.f25534n.setFillAfter(true);
            this.f25527g.startAnimation(this.f25534n);
            return;
        }
        this.f25527g.setVisibility(4);
    }

    /* renamed from: g */
    private void m18261g() {
        AnimationSet animationSet = this.f25534n;
        if (animationSet != null) {
            animationSet.cancel();
            this.f25534n = null;
        }
    }

    /* renamed from: b */
    private AlphaAnimation m18250b(boolean z) {
        AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        return alphaAnimation;
    }

    /* renamed from: c */
    private ScaleAnimation m18254c(boolean z) {
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
        this.f25535o = map;
    }

    public void destroy() {
        stopAnimation();
        this.f25536p = null;
        Map map = this.f25535o;
        if (map != null) {
            map.removeTopView();
        }
        this.f25535o = null;
        this.f25524d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f25536p = pinStyle;
            if (this.f25524d != null) {
                this.f25524d.setPinColor(pinStyle.pinNormalColor != 0 ? pinStyle.pinNormalColor : PinView.DEFAULT_COLOR, pinStyle.pintNoParkingColor != 0 ? pinStyle.pintNoParkingColor : PinView.NO_PARKING_COLOR);
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
        Map map = this.f25535o;
        if (map != null && (pinStyle = this.f25536p) != null) {
            map.setTopViewToCenter(this, pinStyle.anchorX, this.f25536p.anchorY);
        }
    }

    public void remove() {
        Map map = this.f25535o;
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
}
