package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.floating.RFFloatingNavBarController;
import com.taxis99.R;

final class RFFloatingNavBarController {

    /* renamed from: a */
    private static final String f33553a = "RFFloatingNavBarControl";

    /* renamed from: b */
    private static final int f33554b = 100;

    /* renamed from: c */
    private static final int f33555c = 255;

    /* renamed from: d */
    private static C11559c f33556d = new C11559c((RFFloatingTextAttr) null, (RFFloatingIconAttr) null, (RFFloatingTextAttr) null, true, false, RFResUtils.getColor(R.color.rf_color_white_100_FFFFFF));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RFusionConfig.IRFusionLogger f33557e = RFLogger.getLogger();

    /* renamed from: f */
    private FloatingNavBar f33558f;

    /* renamed from: g */
    private View f33559g;

    /* renamed from: h */
    private SparseArray<C11559c> f33560h = new SparseArray<>();

    /* renamed from: i */
    private Integer f33561i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Integer f33562j;

    /* renamed from: k */
    private boolean f33563k = false;

    /* renamed from: l */
    private ValueAnimator f33564l;

    /* renamed from: m */
    private ValueAnimator f33565m;

    /* renamed from: n */
    private boolean f33566n = true;

    RFFloatingNavBarController() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87856a(View view) {
        this.f33558f = new FloatingNavBar((ViewGroup) view.findViewById(R.id.rf_fl_nav_bar_container));
        this.f33559g = view.findViewById(R.id.rf_nav_bar_shadow);
        this.f33563k = true;
        m23629c();
    }

    /* renamed from: c */
    private void m23629c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        this.f33564l = ofInt;
        ofInt.setDuration(100);
        this.f33564l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFFloatingNavBarController.this.m23628b(valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{255, 0});
        this.f33565m = ofInt2;
        ofInt2.setDuration(100);
        this.f33565m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFFloatingNavBarController.this.m23623a(valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23628b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue == 0) {
            this.f33559g.setVisibility(0);
        }
        this.f33559g.getBackground().setAlpha(intValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23623a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f33559g.getBackground().setAlpha(intValue);
        if (intValue == 255) {
            this.f33559g.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87854a(int i, C11559c cVar) {
        if (!m23633d(i)) {
            Integer num = this.f33561i;
            if (num != null) {
                this.f33560h.remove(num.intValue());
            }
            this.f33560h.put(i, cVar.clone());
            Integer valueOf = Integer.valueOf(i);
            this.f33561i = valueOf;
            if (this.f33562j == null) {
                mo87855a(valueOf.intValue(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87850a(int i) {
        if (!m23633d(i)) {
            this.f33560h.put(i, m23631d());
        }
    }

    /* renamed from: d */
    private C11559c m23631d() {
        C11559c cVar;
        Integer num = this.f33562j;
        if (num != null) {
            cVar = this.f33560h.get(num.intValue()).clone();
        } else {
            cVar = f33556d.clone();
            this.f33557e.info(f33553a, "createNavBarModel: curNavBarId is not exist");
        }
        cVar.f33585e = false;
        return cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo87857b(int i) {
        Integer num = this.f33561i;
        if (num == null || i != num.intValue()) {
            this.f33560h.remove(i);
            Integer num2 = this.f33562j;
            if (num2 != null && num2.intValue() == i) {
                this.f33562j = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87855a(int i, boolean z) {
        C11559c f = m23637f(i);
        if (f != null) {
            Integer num = this.f33562j;
            if (num == null || num.intValue() != i) {
                Integer valueOf = Integer.valueOf(i);
                this.f33562j = valueOf;
                if (valueOf.equals(this.f33561i)) {
                    m23622a(i, true, f);
                } else if (this.f33566n) {
                    m23622a(i, true, f);
                    this.f33566n = false;
                } else {
                    m23622a(i, false, f);
                    this.f33558f.changeNavBar(z);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87849a() {
        this.f33558f.clear();
    }

    /* renamed from: a */
    private void m23622a(int i, boolean z, C11559c cVar) {
        m23627b(i, z, cVar);
        m23630c(i, z, cVar);
        m23632d(i, z, cVar);
        m23638f(i, z, cVar);
        m23635e(i, z, cVar);
        m23626b(i, cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo87860b() {
        return this.f33561i != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87853a(int i, RFFloatingTextAttr rFFloatingTextAttr) {
        C11559c f = m23637f(i);
        if (f != null) {
            m23634e();
            f.f33581a = rFFloatingTextAttr;
            m23627b(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87852a(int i, RFFloatingIconAttr rFFloatingIconAttr) {
        C11559c f = m23637f(i);
        if (f != null) {
            m23634e();
            f.f33582b = rFFloatingIconAttr;
            m23630c(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo87858b(int i, RFFloatingTextAttr rFFloatingTextAttr) {
        C11559c f = m23637f(i);
        if (f != null) {
            m23634e();
            f.f33583c = rFFloatingTextAttr;
            m23632d(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo87859b(int i, boolean z) {
        C11559c f = m23637f(i);
        if (f != null) {
            m23634e();
            f.f33585e = z;
            m23626b(i, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87851a(int i, int i2) {
        C11559c f = m23637f(i);
        if (f != null) {
            m23634e();
            f.f33586f = i2;
            m23638f(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo87861c(int i, boolean z) {
        C11559c f = m23637f(i);
        if (f != null) {
            m23634e();
            f.f33584d = z;
            m23635e(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo87862c(int i) {
        C11559c f = m23637f(i);
        if (f == null) {
            return false;
        }
        m23634e();
        return f.f33584d;
    }

    /* renamed from: b */
    private void m23627b(int i, boolean z, C11559c cVar) {
        if (m23636e(i)) {
            m23624a(this.f33558f.getTitleView(z), (Object) cVar.f33581a);
        }
    }

    /* renamed from: c */
    private void m23630c(int i, boolean z, C11559c cVar) {
        if (m23636e(i)) {
            m23624a(this.f33558f.getLeftButton(z), (Object) cVar.f33582b);
        }
    }

    /* renamed from: d */
    private void m23632d(int i, boolean z, C11559c cVar) {
        if (m23636e(i)) {
            m23624a(this.f33558f.getRightButton(z), (Object) cVar.f33583c);
            this.f33558f.calculateNavBar(z);
        }
    }

    /* renamed from: a */
    private void m23624a(TextView textView, Object obj) {
        View.OnClickListener onClickListener;
        int i;
        String str;
        int i2 = 4;
        if (obj == null) {
            textView.setVisibility(4);
            textView.setOnClickListener((View.OnClickListener) null);
            textView.setText("");
            textView.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
            return;
        }
        if (obj instanceof RFFloatingTextAttr) {
            RFFloatingTextAttr rFFloatingTextAttr = (RFFloatingTextAttr) obj;
            str = rFFloatingTextAttr.f33567a;
            i = rFFloatingTextAttr.f33568b;
            onClickListener = rFFloatingTextAttr.f33569c;
        } else if (obj instanceof RFFloatingIconAttr) {
            RFFloatingIconAttr rFFloatingIconAttr = (RFFloatingIconAttr) obj;
            str = rFFloatingIconAttr.getIcon();
            i = rFFloatingIconAttr.f33551b;
            onClickListener = rFFloatingIconAttr.f33552c;
        } else {
            onClickListener = null;
            str = null;
            i = -1;
        }
        if (!TextUtils.isEmpty(str)) {
            i2 = 0;
        }
        textView.setVisibility(i2);
        textView.setText(str);
        if (i > 0) {
            textView.setTextColor(i);
        } else {
            textView.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
        }
        if (onClickListener == null) {
            textView.setOnClickListener((View.OnClickListener) null);
        } else {
            textView.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: b */
    private void m23626b(int i, C11559c cVar) {
        if (m23636e(i)) {
            if (cVar.f33585e != (this.f33559g.getVisibility() == 0) && cVar.f33584d) {
                this.f33564l.cancel();
                this.f33565m.cancel();
                if (cVar.f33585e) {
                    this.f33564l.start();
                } else {
                    this.f33565m.start();
                }
            }
        }
    }

    /* renamed from: e */
    private void m23635e(int i, boolean z, C11559c cVar) {
        if (m23636e(i)) {
            int i2 = 0;
            this.f33558f.getNavBar(z).setVisibility(cVar.f33584d ? 0 : 8);
            if (cVar.f33585e) {
                View view = this.f33559g;
                if (!cVar.f33584d) {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
        }
    }

    /* renamed from: f */
    private void m23638f(int i, boolean z, C11559c cVar) {
        if (m23636e(i)) {
            this.f33558f.getNavBar(z).setBackgroundColor(cVar.f33586f);
        }
    }

    /* renamed from: e */
    private void m23634e() {
        if (!this.f33563k) {
            throw new RuntimeException("Please use RFFloatingNavBar between onCreate() and onDestroy ()");
        }
    }

    /* renamed from: d */
    private boolean m23633d(int i) {
        return this.f33560h.indexOfKey(i) >= 0;
    }

    /* renamed from: e */
    private boolean m23636e(int i) {
        Integer num = this.f33562j;
        if (num != null && num.intValue() == i) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private C11559c m23637f(int i) {
        return this.f33560h.get(i);
    }

    private class FloatingNavBar {
        private static final String TAG_NAV_BAR = "tag_nav_bar";
        private static final int WHAT_ANIM_START = 1000;
        /* access modifiers changed from: private */
        public AnimatorSet mAnimatorSet;
        private ViewGroup mFromNavBar;
        private Handler mHandler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1000 && FloatingNavBar.this.mAnimatorSet != null) {
                    FloatingNavBar.this.mAnimatorSet.start();
                }
            }
        };
        /* access modifiers changed from: private */
        public ViewGroup mParent;
        private ViewGroup mToNavBar;

        public FloatingNavBar(ViewGroup viewGroup) {
            this.mParent = viewGroup;
            this.mFromNavBar = createNavBarView(viewGroup);
            this.mToNavBar = createNavBarView(viewGroup);
            viewGroup.addView(this.mFromNavBar);
        }

        private ViewGroup createNavBarView(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rf_floating_nav_bar, viewGroup, false);
            viewGroup2.setTag(TAG_NAV_BAR);
            viewGroup2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RFFloatingNavBarController.FloatingNavBar.this.mo87869x9e3266ea(view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
            return viewGroup2;
        }

        /* renamed from: lambda$createNavBarView$0$RFFloatingNavBarController$FloatingNavBar */
        public /* synthetic */ void mo87869x9e3266ea(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            calculateNavBar(view);
        }

        /* access modifiers changed from: private */
        public ViewGroup getNavBar(boolean z) {
            return z ? this.mFromNavBar : this.mToNavBar;
        }

        public TextView getTitleView(boolean z) {
            return getTitleView((View) getNavBar(z));
        }

        private TextView getTitleView(View view) {
            return (TextView) view.findViewById(R.id.rf_tv_title);
        }

        public TextView getLeftButton(boolean z) {
            return getLeftButton((View) getNavBar(z));
        }

        private TextView getLeftButton(View view) {
            return (TextView) view.findViewById(R.id.rf_tv_left_btn);
        }

        public TextView getRightButton(boolean z) {
            return getRightButton((View) getNavBar(z));
        }

        private TextView getRightButton(View view) {
            return (TextView) view.findViewById(R.id.rf_tv_right_btn);
        }

        public void changeNavBar(boolean z) {
            RFusionConfig.IRFusionLogger b = RFFloatingNavBarController.this.f33557e;
            b.info("changeNavBar", "change:" + RFFloatingNavBarController.this.f33562j);
            startChangeAnim(z);
            changeNavBarInternal();
        }

        private void startChangeAnim(final boolean z) {
            final ViewGroup navBar = getNavBar(true);
            final ViewGroup navBar2 = getNavBar(false);
            if (this.mHandler.hasMessages(1000)) {
                this.mHandler.removeMessages(1000);
                if (!isAnimRunning()) {
                    this.mAnimatorSet.start();
                    this.mAnimatorSet.end();
                }
            }
            if (isAnimRunning()) {
                this.mAnimatorSet.end();
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimatorSet = animatorSet;
            if (z) {
                animatorSet.play(ObjectAnimator.ofFloat(navBar, View.TRANSLATION_X, new float[]{(float) (-this.mParent.getMeasuredWidth())}));
                this.mAnimatorSet.play(ObjectAnimator.ofFloat(navBar2, View.TRANSLATION_X, new float[]{(float) this.mParent.getMeasuredWidth(), 0.0f}));
            } else {
                animatorSet.play(ObjectAnimator.ofFloat(navBar, View.TRANSLATION_X, new float[]{(float) this.mParent.getMeasuredWidth()}));
                this.mAnimatorSet.play(ObjectAnimator.ofFloat(navBar2, View.TRANSLATION_X, new float[]{(float) (-this.mParent.getMeasuredWidth()), 0.0f}));
            }
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    FloatingNavBar.this.mParent.addView(navBar2);
                    RFFloatingNavBarController.this.f33557e.info(RFFloatingNavBarController.f33553a, "onAnimationStart");
                }

                public void onAnimationEnd(Animator animator) {
                    RFFloatingNavBarController.this.f33557e.info(RFFloatingNavBarController.f33553a, "onAnimationEnd");
                    navBar2.setTranslationX(0.0f);
                    navBar.setTranslationX((float) (z ? -FloatingNavBar.this.mParent.getMeasuredWidth() : FloatingNavBar.this.mParent.getMeasuredWidth()));
                    FloatingNavBar.this.mParent.removeView(navBar);
                }
            });
            this.mHandler.sendEmptyMessage(1000);
        }

        /* access modifiers changed from: protected */
        public void calculateNavBar(boolean z) {
            calculateNavBar((View) getNavBar(z));
        }

        private void calculateNavBar(View view) {
            Object tag = view.getTag();
            if (view.getParent() != null && (tag instanceof String) && TextUtils.equals((String) tag, TAG_NAV_BAR)) {
                TextView titleView = getTitleView(view);
                TextView leftButton = getLeftButton(view);
                TextView rightButton = getRightButton(view);
                int measuredWidth = leftButton.getMeasuredWidth() + ((int) RFResUtils.getDimens(R.dimen.rf_dimen_48));
                int measuredWidth2 = view.getMeasuredWidth() - (view.getPaddingLeft() + view.getPaddingRight());
                int max = rightButton.getVisibility() == 0 ? measuredWidth2 - (Math.max(measuredWidth, rightButton.getMeasuredWidth() + ((int) RFResUtils.getDimens(R.dimen.rf_dimen_48))) * 2) : measuredWidth2 - (measuredWidth * 2);
                ViewGroup.LayoutParams layoutParams = titleView.getLayoutParams();
                if (layoutParams.width != max) {
                    layoutParams.width = max;
                    titleView.setLayoutParams(layoutParams);
                    RFusionConfig.IRFusionLogger b = RFFloatingNavBarController.this.f33557e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("calculateNavBar: rightButton visible = ");
                    sb.append(rightButton.getVisibility() == 0);
                    sb.append(" resultTitleSpace = ");
                    sb.append(max);
                    b.info(RFFloatingNavBarController.f33553a, sb.toString());
                }
            }
        }

        private void changeNavBarInternal() {
            ViewGroup viewGroup = this.mFromNavBar;
            this.mFromNavBar = this.mToNavBar;
            this.mToNavBar = viewGroup;
        }

        private boolean isAnimRunning() {
            AnimatorSet animatorSet = this.mAnimatorSet;
            return animatorSet != null && animatorSet.isRunning();
        }

        public void clear() {
            this.mHandler.removeCallbacksAndMessages((Object) null);
        }
    }
}
