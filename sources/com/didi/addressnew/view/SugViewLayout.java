package com.didi.addressnew.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.didi.addressnew.framework.animator.EaseCubicInterpolator;
import com.didi.common.map.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didi.sdk.util.ToastUtil;
import com.taxis99.R;

public class SugViewLayout extends FrameLayout {
    public static final int ENTER_ANIMATION_INTERVAL = 500;

    /* renamed from: a */
    private View f7567a;

    /* renamed from: b */
    private FrameLayout f7568b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnSugViewDragListener f7569c;

    /* renamed from: d */
    private boolean f7570d = false;

    /* renamed from: e */
    private int f7571e;

    /* renamed from: f */
    private int f7572f = 0;

    /* renamed from: g */
    private PointF f7573g = new PointF();

    /* renamed from: h */
    private boolean f7574h = false;

    /* renamed from: i */
    private int f7575i = 0;

    /* renamed from: j */
    private View f7576j;

    /* renamed from: k */
    private boolean f7577k = false;

    /* renamed from: l */
    private int f7578l;

    /* renamed from: m */
    private float f7579m = 0.6f;

    /* renamed from: n */
    private long f7580n = System.currentTimeMillis();

    /* renamed from: o */
    private int f7581o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f7582p = false;

    public interface OnSugViewDragListener {
        void onSugViewIsClose();

        void onSugViewIsReset();

        void onSugViewIsStartMove();

        void onSugViewStartClose();
    }

    public SugViewLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public SugViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SugViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public int getScreenHeight(Context context) {
        if (context != null) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public void setContentTopMargin(int i) {
        if (i != 0) {
            this.f7571e = i;
        }
        m4800b();
    }

    public void setContentTopMargin(int i, int i2) {
        if (i != 0) {
            this.f7571e = i;
        }
        this.f7575i = i2;
        m4800b();
    }

    /* renamed from: a */
    private void m4791a() {
        View view = this.f7567a;
        if (view instanceof CardView) {
            this.f7581o = (int) ((CardView) view).getRadius();
        }
        this.f7578l += this.f7581o;
    }

    /* renamed from: b */
    private void m4800b() {
        this.f7578l = this.f7575i - this.f7571e;
        m4791a();
    }

    public void setMaxAlpha(float f) {
        this.f7579m = this.f7579m;
    }

    public void init(Context context, AttributeSet attributeSet) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.sugView);
        this.f7571e = (int) obtainStyledAttributes.getDimension(0, (float) DisplayUtils.dp2px(getContext(), 40.0f));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f7568b = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#666666"));
        this.f7568b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f7568b);
        this.f7568b.setAlpha(0.0f);
        this.f7568b.setContentDescription(getContext().getString(R.string.GRider_0111_Return_rDEY));
        this.f7568b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugViewLayout.this.m4802b(view);
            }
        });
        this.f7567a = View.inflate(context, obtainStyledAttributes.getResourceId(1, R.layout.view_sug_content), (ViewGroup) null);
        addView(this.f7567a, new FrameLayout.LayoutParams(-1, -2));
        View findViewById = this.f7567a.findViewById(R.id.sugPageDragHandle);
        this.f7576j = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugViewLayout.this.m4793a(view);
            }
        });
        obtainStyledAttributes.recycle();
        this.f7575i = getScreenHeight(getContext());
        m4800b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m4802b(View view) {
        if (this.f7570d && this.f7582p && System.currentTimeMillis() - this.f7580n > 500) {
            startPullAnim();
            this.f7580n = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4793a(View view) {
        if (System.currentTimeMillis() - this.f7580n > 500) {
            startPullAnim();
            this.f7580n = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        try {
            if (getChildCount() == 0) {
                ToastUtil.show(getContext(), (CharSequence) "当前控件必须添加一个contentView 才能使用");
                throw new Exception("当前控件必须添加一个contentView 才能使用");
            } else if (getChildCount() > 3) {
                ToastUtil.show(getContext(), (CharSequence) "当前控件只支持添加一个contentView");
                throw new Exception("当前控件只支持添加一个contentView");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7570d) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int i = 0;
        if (action == 0) {
            this.f7577k = false;
            this.f7573g.x = motionEvent.getX();
            this.f7573g.y = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.f7573g.y;
                motionEvent.getX();
                float f = this.f7573g.x;
                this.f7577k = true;
                OnSugViewDragListener onSugViewDragListener = this.f7569c;
                if (onSugViewDragListener != null) {
                    onSugViewDragListener.onSugViewIsStartMove();
                }
                float f2 = 0.0f;
                if (y > 0.0f) {
                    i = 1;
                }
                this.f7572f = i;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f7567a.getLayoutParams();
                int i2 = layoutParams.topMargin;
                int i3 = layoutParams.bottomMargin;
                int i4 = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
                int i5 = (int) (((float) i2) + ((i4 >= 0 || i2 > this.f7571e) ? y : 0.0f));
                float f3 = (float) i3;
                if (i4 >= 0 || i5 > this.f7571e) {
                    f2 = y;
                }
                int i6 = (int) (f3 - f2);
                int i7 = this.f7571e;
                if (i5 < i7) {
                    i5 = i7;
                }
                int i8 = this.f7581o;
                if (i6 > (-i8)) {
                    i6 = -i8;
                }
                layoutParams.setMargins(layoutParams.leftMargin, i5, layoutParams.rightMargin, i6);
                this.f7567a.setLayoutParams(layoutParams);
                FrameLayout frameLayout = this.f7568b;
                frameLayout.setAlpha(frameLayout.getAlpha() - ((y / ((float) this.f7578l)) / 1.0f));
                this.f7573g.x = motionEvent.getX();
                this.f7573g.y = motionEvent.getY();
            }
        } else if (!this.f7577k) {
            return false;
        } else {
            if (this.f7572f != 1) {
                m4803c();
            } else if (((FrameLayout.LayoutParams) this.f7567a.getLayoutParams()).bottomMargin < (-this.f7575i) / 5) {
                startPullAnim();
            } else {
                m4803c();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f7567a.getLayoutParams();
        layoutParams.gravity = 80;
        layoutParams.height = this.f7578l;
        layoutParams.width = -1;
        layoutParams.setMargins(layoutParams.leftMargin, this.f7578l, layoutParams.rightMargin, -this.f7578l);
        this.f7567a.setLayoutParams(layoutParams);
        startEnterAnimation();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f7573g.x = motionEvent.getX();
            this.f7573g.y = motionEvent.getY();
            this.f7574h = false;
        } else if (action == 1) {
            this.f7574h = false;
        } else if (action == 2) {
            float y = motionEvent.getY() - this.f7573g.y;
            if (Math.abs(motionEvent.getX() - this.f7573g.x) > 20.0f || Math.abs(y) > 20.0f) {
                this.f7574h = m4797a(motionEvent);
            } else {
                this.f7574h = false;
            }
        }
        if (!this.f7574h || !this.f7570d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m4797a(MotionEvent motionEvent) {
        View view = this.f7567a;
        if (view == null) {
            return false;
        }
        return m4798a(view, motionEvent);
    }

    /* renamed from: a */
    private boolean m4798a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getX() < ((float) i) || motionEvent.getX() > ((float) (i + view.getWidth())) || motionEvent.getY() < ((float) i2) || motionEvent.getY() > ((float) (i2 + (this.f7578l / 4)))) {
            return false;
        }
        return true;
    }

    public void startPullAnim() {
        this.f7568b.setAlpha(0.0f);
        OnSugViewDragListener onSugViewDragListener = this.f7569c;
        if (onSugViewDragListener != null) {
            onSugViewDragListener.onSugViewIsStartMove();
        }
        this.f7568b.setFocusable(true);
        this.f7568b.setFocusableInTouchMode(true);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7567a.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{marginLayoutParams.bottomMargin, -this.f7578l});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(marginLayoutParams) {
            public final /* synthetic */ ViewGroup.MarginLayoutParams f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m4795a(this.f$1, valueAnimator);
            }
        });
        ofInt.setInterpolator(new EaseCubicInterpolator(0.28f, 0.96f, 0.3f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt});
        animatorSet.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (SugViewLayout.this.f7569c != null) {
                    SugViewLayout.this.f7569c.onSugViewIsClose();
                }
            }

            public void onAnimationStart(Animator animator) {
                if (SugViewLayout.this.f7569c != null) {
                    SugViewLayout.this.f7569c.onSugViewStartClose();
                }
                boolean unused = SugViewLayout.this.f7582p = false;
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4795a(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, this.f7578l + intValue, marginLayoutParams.rightMargin, intValue);
        this.f7567a.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: c */
    private void m4803c() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7567a.getLayoutParams();
        int i = marginLayoutParams.topMargin;
        int i2 = marginLayoutParams.bottomMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, -this.f7581o});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(marginLayoutParams, i, i2) {
            public final /* synthetic */ ViewGroup.MarginLayoutParams f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m4794a(this.f$1, this.f$2, this.f$3, valueAnimator);
            }
        });
        ofInt.setInterpolator(new EaseCubicInterpolator(0.28f, 0.96f, 0.3f, 1.0f));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f7568b.getAlpha(), this.f7579m});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m4801b(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new EaseCubicInterpolator(0.3f, 0.2f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (SugViewLayout.this.f7569c != null) {
                    SugViewLayout.this.f7569c.onSugViewIsReset();
                }
            }
        });
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SugViewLayout.this.f7582p = true;
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4794a(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (i - i2) + intValue, marginLayoutParams.rightMargin, intValue);
        this.f7567a.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m4801b(ValueAnimator valueAnimator) {
        this.f7568b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void startEnterAnimation() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f7567a.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{layoutParams.bottomMargin, -this.f7581o});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams) {
            public final /* synthetic */ FrameLayout.LayoutParams f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m4796a(this.f$1, valueAnimator);
            }
        });
        ofInt.setInterpolator(new EaseCubicInterpolator(0.28f, 0.96f, 0.3f, 1.0f));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.f7579m});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m4792a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new EaseCubicInterpolator(0.3f, 0.2f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SugViewLayout.this.f7582p = true;
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4796a(FrameLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        layoutParams.setMargins(layoutParams.leftMargin, this.f7578l + intValue, layoutParams.rightMargin, intValue);
        this.f7567a.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4792a(ValueAnimator valueAnimator) {
        this.f7568b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void setOnDragCompleteListener(OnSugViewDragListener onSugViewDragListener) {
        this.f7569c = onSugViewDragListener;
    }

    public void setDragEnable(boolean z) {
        this.f7570d = z;
        this.f7576j.setVisibility(z ? 0 : 8);
    }
}
