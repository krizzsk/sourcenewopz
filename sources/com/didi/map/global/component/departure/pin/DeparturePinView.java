package com.didi.map.global.component.departure.pin;

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
import com.taxis99.R;

public class DeparturePinView extends RelativeLayout implements IDeparturePinView {

    /* renamed from: a */
    private static final String f25238a = "DeparturePinView";

    /* renamed from: b */
    private static final String f25239b = "lottie_departure_loading.json";

    /* renamed from: c */
    private static final String f25240c = "lottie_no_parking.json";

    /* renamed from: d */
    private PinView f25241d;

    /* renamed from: e */
    private RelativeLayout f25242e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LottieAnimationView f25243f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LottieAnimationView f25244g;

    /* renamed from: h */
    private View f25245h;

    /* renamed from: i */
    private int f25246i;

    /* renamed from: j */
    private int f25247j;

    /* renamed from: k */
    private boolean f25248k;

    /* renamed from: l */
    private AnimatorSet f25249l;

    /* renamed from: m */
    private AnimationSet f25250m;

    /* renamed from: n */
    private AnimationSet f25251n;

    /* renamed from: o */
    private Context f25252o;

    /* renamed from: p */
    private Map f25253p;

    /* renamed from: q */
    private PinStyle f25254q;

    public DeparturePinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DeparturePinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DeparturePinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25248k = false;
        m18069a(context);
    }

    /* renamed from: a */
    private void m18069a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_departure_pin_view, this);
        this.f25241d = (PinView) inflate.findViewById(R.id.pin);
        this.f25242e = (RelativeLayout) inflate.findViewById(R.id.container);
        this.f25243f = (LottieAnimationView) inflate.findViewById(R.id.loading_lottie);
        this.f25244g = (LottieAnimationView) inflate.findViewById(R.id.no_parking_lottie);
        this.f25243f.setAnimation(f25239b);
        this.f25243f.setRepeatCount(-1);
        this.f25244g.setAnimation(f25240c);
        this.f25244g.setRepeatCount(0);
        this.f25246i = this.f25241d.getBigCircleWidth();
        this.f25247j = this.f25241d.getBigCircleHeight();
        startDragging_Ex();
        this.f25252o = context;
    }

    public void startDragging_Ex() {
        startShowPin(200);
    }

    public void startDragging() {
        startShowPin(400);
    }

    public void startShowPin(long j) {
        PinView pinView = this.f25241d;
        if (pinView != null && !pinView.isDragging()) {
            setPinStartEndColor(false);
            m18076c();
            m18081f();
            this.f25242e.removeView(this.f25245h);
            this.f25245h = null;
            m18067a(this.f25241d.getDraggingWidth(), this.f25241d.getDraggingHeight(), false, j);
            this.f25241d.toDragging();
            this.f25248k = false;
        }
    }

    public void startLoading(boolean z) {
        PinView pinView = this.f25241d;
        if (pinView != null && !pinView.isLoading()) {
            setPinStartEndColor(z);
            m18073b();
            m18081f();
            this.f25242e.removeView(this.f25245h);
            this.f25245h = null;
            m18067a(this.f25241d.getLoadingWidth(), this.f25241d.getLoadingHeight(), true, 400);
            this.f25241d.toLoading();
            this.f25248k = false;
        }
    }

    public void showText(String str) {
        PinView pinView;
        if (TextUtils.isEmpty(str) || (pinView = this.f25241d) == null) {
            return;
        }
        if (!pinView.isNormal() || !str.equalsIgnoreCase(this.f25241d.getText())) {
            setPinStartEndColor(false);
            m18076c();
            m18081f();
            this.f25242e.removeView(this.f25245h);
            this.f25245h = null;
            this.f25241d.showText(str);
            m18067a(this.f25241d.getNormalWidth(), this.f25241d.getNormalHeight(), false, 400);
            this.f25248k = false;
        }
    }

    public void showView(View view, int i, int i2, int i3) {
        if (view != null && i > 0 && i2 > 0 && i3 > 0) {
            setPinStartEndColor(false);
            m18076c();
            m18081f();
            this.f25242e.removeView(this.f25245h);
            this.f25245h = view;
            if (this.f25242e.indexOfChild(view) < 0) {
                this.f25242e.addView(view);
            }
            m18067a(i, i2, true, 400);
            this.f25241d.animSetBigCircleWidthHeightAngle(i, i2, i3);
            this.f25248k = false;
        }
    }

    public void toNoParking() {
        if (!this.f25248k) {
            setPinStartEndColor(true);
            m18076c();
            m18080e();
            this.f25242e.removeView(this.f25245h);
            this.f25245h = null;
            int draggingWidth = this.f25241d.getDraggingWidth();
            int draggingHeight = this.f25241d.getDraggingHeight();
            m18067a(draggingWidth, draggingHeight, false, 400);
            this.f25241d.animSetBigCircleWidthHeightAngle(draggingWidth, draggingHeight, PinView.DRAGGING_BIG_CIRCLE_RADIUS_PX);
            this.f25248k = true;
        }
    }

    public Rect getWindowPosition() {
        return new Rect(getLeft(), getTop(), getRight(), getBottom() - DisplayUtils.dp2px(this.f25252o, 20.0f));
    }

    public void stopAnimation() {
        this.f25241d.stopAnimation();
        if (this.f25243f.isAnimating()) {
            this.f25243f.cancelAnimation();
        }
        if (this.f25244g.isAnimating()) {
            this.f25244g.cancelAnimation();
        }
        m18066a();
        m18079d();
        m18082g();
    }

    /* renamed from: a */
    private void m18067a(int i, int i2, boolean z, long j) {
        m18066a();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f25249l = animatorSet;
        animatorSet.setDuration(j);
        this.f25249l.playTogether(new Animator[]{m18063a(this.f25246i, i), m18070b(this.f25247j, i2), m18064a(z)});
        this.f25249l.start();
    }

    /* renamed from: a */
    private void m18066a() {
        AnimatorSet animatorSet = this.f25249l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f25249l = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m18063a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeparturePinView.this.m18078c(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18078c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f25246i = intValue;
        m18077c(intValue, this.f25247j);
    }

    /* renamed from: b */
    private ValueAnimator m18070b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeparturePinView.this.m18074b(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18074b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f25247j = intValue;
        m18077c(this.f25246i, intValue);
    }

    /* renamed from: a */
    private ValueAnimator m18064a(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeparturePinView.this.m18068a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18068a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f25242e.setAlpha(floatValue);
        View view = this.f25245h;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void setPinStartEndColor(boolean z) {
        PinView pinView = this.f25241d;
        pinView.setPinStartEndColor(this.f25248k ? pinView.getNoParkingColor() : pinView.getNormalColor(), z ? this.f25241d.getNoParkingColor() : this.f25241d.getNormalColor());
    }

    /* renamed from: c */
    private void m18077c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f25242e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f25242e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m18073b() {
        m18079d();
        AnimationSet animationSet = new AnimationSet(false);
        this.f25250m = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                DeparturePinView.this.f25243f.setProgress(0.0f);
                DeparturePinView.this.f25243f.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                DeparturePinView.this.f25243f.playAnimation();
            }
        });
        this.f25250m.addAnimation(m18075c(true));
        this.f25250m.addAnimation(m18071b(true));
        this.f25250m.setDuration(400);
        this.f25250m.setFillAfter(true);
        this.f25243f.startAnimation(this.f25250m);
    }

    /* renamed from: c */
    private void m18076c() {
        if (this.f25243f.getVisibility() == 0 || this.f25243f.isShown()) {
            m18079d();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25250m = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DeparturePinView.this.f25243f.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DeparturePinView.this.f25243f.setVisibility(4);
                    DeparturePinView.this.f25243f.setProgress(0.0f);
                }
            });
            this.f25250m.addAnimation(m18075c(false));
            this.f25250m.addAnimation(m18071b(false));
            this.f25250m.setDuration(400);
            this.f25250m.setFillAfter(true);
            this.f25243f.startAnimation(this.f25250m);
            return;
        }
        this.f25243f.setVisibility(4);
    }

    /* renamed from: d */
    private void m18079d() {
        AnimationSet animationSet = this.f25250m;
        if (animationSet != null) {
            animationSet.cancel();
            this.f25250m = null;
        }
    }

    /* renamed from: e */
    private void m18080e() {
        if (this.f25244g.getVisibility() != 0 || !this.f25244g.isShown()) {
            m18082g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25251n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DeparturePinView.this.f25244g.setProgress(0.0f);
                    DeparturePinView.this.f25244g.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    DeparturePinView.this.f25244g.playAnimation();
                }
            });
            this.f25251n.addAnimation(m18075c(true));
            this.f25251n.addAnimation(m18071b(true));
            this.f25251n.setDuration(400);
            this.f25251n.setFillAfter(true);
            this.f25244g.startAnimation(this.f25251n);
        }
    }

    /* renamed from: f */
    private void m18081f() {
        if (this.f25244g.getVisibility() == 0 || this.f25244g.isShown()) {
            m18082g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f25251n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DeparturePinView.this.f25244g.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DeparturePinView.this.f25244g.setVisibility(4);
                }
            });
            this.f25251n.addAnimation(m18075c(false));
            this.f25251n.addAnimation(m18071b(false));
            this.f25251n.setDuration(400);
            this.f25251n.setFillAfter(true);
            this.f25244g.startAnimation(this.f25251n);
            return;
        }
        this.f25244g.setVisibility(4);
    }

    /* renamed from: g */
    private void m18082g() {
        AnimationSet animationSet = this.f25251n;
        if (animationSet != null) {
            animationSet.setAnimationListener((Animation.AnimationListener) null);
            this.f25251n.cancel();
            this.f25251n = null;
        }
    }

    /* renamed from: b */
    private AlphaAnimation m18071b(boolean z) {
        AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        return alphaAnimation;
    }

    /* renamed from: c */
    private ScaleAnimation m18075c(boolean z) {
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
        this.f25253p = map;
        this.f25252o = context;
    }

    public void destroy() {
        stopAnimation();
        this.f25254q = null;
        Map map = this.f25253p;
        if (map != null) {
            map.removeTopView();
        }
        this.f25253p = null;
        this.f25241d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f25254q = pinStyle;
            if (this.f25241d != null) {
                this.f25241d.setPinColor(pinStyle.pinNormalColor != 0 ? pinStyle.pinNormalColor : PinView.DEFAULT_COLOR, pinStyle.pintNoParkingColor != 0 ? pinStyle.pintNoParkingColor : PinView.NO_PARKING_COLOR);
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
        Map map = this.f25253p;
        if (map != null && (pinStyle = this.f25254q) != null) {
            map.setTopViewToCenter(this, pinStyle.anchorX, this.f25254q.anchorY);
        }
    }

    public void remove() {
        Map map = this.f25253p;
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
