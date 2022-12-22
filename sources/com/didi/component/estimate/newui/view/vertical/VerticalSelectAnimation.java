package com.didi.component.estimate.newui.view.vertical;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;

public class VerticalSelectAnimation {
    public static final int SEL_ITEM_HEIGHT = 100;
    public static final int SEL_ITEM_LOADING_HEIGHT = 100;
    public static final int SEL_ITEM_WITH_OPTIONS_HEIGHT = 135;
    public static final int SHADOW_MARGIN = 64;
    public static final int UN_SEL_ITEM_HEIGHT = 85;
    public static final int UN_SEL_ITEM_LOADING_HEIGHT = 85;

    /* renamed from: a */
    static final int f13189a = 22;

    /* renamed from: c */
    private static final int f13190c = 42;

    /* renamed from: d */
    private static final float f13191d = 1.0f;

    /* renamed from: e */
    private static final float f13192e = 1.5f;

    /* renamed from: b */
    private final Context f13193b;

    /* renamed from: f */
    private int f13194f;

    /* renamed from: g */
    private int f13195g = 0;

    /* renamed from: h */
    private int f13196h = 0;

    /* renamed from: i */
    private int f13197i = 0;

    /* renamed from: j */
    private int f13198j = 0;

    /* renamed from: k */
    private ValueAnimator f13199k;

    /* renamed from: l */
    private ValueAnimator f13200l;

    /* renamed from: m */
    private ValueAnimator f13201m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public EstimateItemModel f13202n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public EstimateItemModel f13203o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RecyclerView f13204p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public RecommendVerticalAdapter f13205q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f13206r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ViewGroup f13207s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f13208t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f13209u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public SelectAnimationEndCallBack f13210v;

    interface SelectAnimationEndCallBack {
        void selectAnimationEnd();
    }

    public float calculateCarIconScale(float f, boolean z) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return z ? (f * 0.5f) + 1.0f : 1.5f - (f * 0.5f);
    }

    public int calculateShadow(float f, int i, int i2) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (int) (((float) i) + (((float) (i2 - i)) * f));
    }

    public void setAnimationEndCallBack(SelectAnimationEndCallBack selectAnimationEndCallBack) {
        this.f13210v = selectAnimationEndCallBack;
    }

    public VerticalSelectAnimation(Context context) {
        this.f13193b = context;
        m8980a();
    }

    /* renamed from: a */
    private void m8980a() {
        this.f13194f = UiUtils.dip2px(this.f13193b, 85.0f);
        this.f13195g = UiUtils.dip2px(this.f13193b, 90.0f);
        this.f13196h = UiUtils.dip2px(this.f13193b, 100.0f);
        this.f13197i = UiUtils.dip2px(this.f13193b, 60.0f);
        this.f13198j = UiUtils.dip2px(this.f13193b, 100.0f);
        ValueAnimator valueAnimator = GlobalUIKitAnimationFactory.getValueAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, 400, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerticalCarViewHolder verticalCarViewHolder = (VerticalCarViewHolder) VerticalSelectAnimation.this.f13204p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f13205q.getDataList().indexOf(VerticalSelectAnimation.this.f13202n));
                if (valueAnimator != null && verticalCarViewHolder != null && verticalCarViewHolder.itemView.isAttachedToWindow() && verticalCarViewHolder.estimateItemModel == VerticalSelectAnimation.this.f13202n) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewGroup.LayoutParams layoutParams = verticalCarViewHolder.carInfoContainer.getLayoutParams();
                    layoutParams.height = VerticalSelectAnimation.this.calculateCardHeight(floatValue, true, verticalCarViewHolder.selectedInfoHeight);
                    verticalCarViewHolder.carInfoContainer.setLayoutParams(layoutParams);
                    float calculateCarIconScale = VerticalSelectAnimation.this.calculateCarIconScale(floatValue, true);
                    verticalCarViewHolder.carIcon.setScaleX(calculateCarIconScale);
                    verticalCarViewHolder.carIcon.setScaleY(calculateCarIconScale);
                }
            }
        });
        this.f13199k = valueAnimator;
        valueAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (VerticalSelectAnimation.this.f13210v != null) {
                    VerticalSelectAnimation.this.f13210v.selectAnimationEnd();
                }
            }
        });
        this.f13200l = GlobalUIKitAnimationFactory.getValueAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, 400, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerticalCarViewHolder verticalCarViewHolder = (VerticalCarViewHolder) VerticalSelectAnimation.this.f13204p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f13205q.getDataList().indexOf(VerticalSelectAnimation.this.f13203o));
                if (valueAnimator != null && verticalCarViewHolder != null && verticalCarViewHolder.itemView.isAttachedToWindow() && verticalCarViewHolder.estimateItemModel == VerticalSelectAnimation.this.f13203o) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewGroup.LayoutParams layoutParams = verticalCarViewHolder.carInfoContainer.getLayoutParams();
                    layoutParams.height = VerticalSelectAnimation.this.calculateCardHeight(floatValue, false, verticalCarViewHolder.selectedInfoHeight);
                    verticalCarViewHolder.carInfoContainer.setLayoutParams(layoutParams);
                    float calculateCarIconScale = VerticalSelectAnimation.this.calculateCarIconScale(floatValue, false);
                    verticalCarViewHolder.carIcon.setScaleX(calculateCarIconScale);
                    verticalCarViewHolder.carIcon.setScaleY(calculateCarIconScale);
                }
            }
        });
        this.f13201m = GlobalUIKitAnimationFactory.getValueAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, 400, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerticalCarViewHolder verticalCarViewHolder;
                if (valueAnimator != null && (verticalCarViewHolder = (VerticalCarViewHolder) VerticalSelectAnimation.this.f13204p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f13205q.getDataList().indexOf(VerticalSelectAnimation.this.f13202n))) != null && verticalCarViewHolder.itemView.isAttachedToWindow() && verticalCarViewHolder.estimateItemModel == VerticalSelectAnimation.this.f13202n) {
                    VerticalCarViewHolder verticalCarViewHolder2 = (VerticalCarViewHolder) VerticalSelectAnimation.this.f13204p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f13205q.getDataList().indexOf(VerticalSelectAnimation.this.f13203o));
                    if (verticalCarViewHolder2 == null || !verticalCarViewHolder2.itemView.isAttachedToWindow() || verticalCarViewHolder2.estimateItemModel != VerticalSelectAnimation.this.f13203o) {
                        verticalCarViewHolder2 = verticalCarViewHolder;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int calculateShadow = VerticalSelectAnimation.this.calculateShadow(floatValue, verticalCarViewHolder2.selectedCardHeight, verticalCarViewHolder.selectedCardHeight);
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    verticalCarViewHolder2.itemView.getLocationOnScreen(iArr);
                    verticalCarViewHolder.itemView.getLocationOnScreen(iArr2);
                    VerticalSelectAnimation.this.f13207s.getLocationOnScreen(iArr3);
                    int calculateShadow2 = VerticalSelectAnimation.this.calculateShadow(floatValue, iArr[1] - iArr3[1], iArr2[1] - iArr3[1]);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VerticalSelectAnimation.this.f13206r.getLayoutParams();
                    layoutParams.height = calculateShadow;
                    layoutParams.topMargin = calculateShadow2 + VerticalSelectAnimation.this.f13208t;
                    int unused = VerticalSelectAnimation.this.f13209u = layoutParams.topMargin;
                    VerticalSelectAnimation.this.f13206r.setLayoutParams(layoutParams);
                }
            }
        });
    }

    public void setRecyclerView(RecyclerView recyclerView, RecommendVerticalAdapter recommendVerticalAdapter, View view, ViewGroup viewGroup) {
        this.f13204p = recyclerView;
        this.f13205q = recommendVerticalAdapter;
        this.f13206r = view;
        this.f13207s = viewGroup;
    }

    public void setItemModel(EstimateItemModel estimateItemModel, EstimateItemModel estimateItemModel2) {
        this.f13202n = estimateItemModel;
        this.f13203o = estimateItemModel2;
    }

    public void startAnimation() {
        if (m8982b()) {
            m8984c();
        }
        this.f13199k.start();
        this.f13200l.start();
        this.f13201m.start();
    }

    public void resetShadow() {
        this.f13206r.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13206r.getLayoutParams();
        layoutParams.height = UIUtils.dip2pxInt(this.f13193b, 164.0f);
        layoutParams.topMargin = 0;
        this.f13206r.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private boolean m8982b() {
        return this.f13199k.isRunning();
    }

    /* renamed from: c */
    private void m8984c() {
        this.f13199k.end();
        this.f13200l.end();
        this.f13201m.end();
    }

    public void updateViewHolder(VerticalCarViewHolder verticalCarViewHolder, EstimateItemModel estimateItemModel) {
        if (verticalCarViewHolder != null && estimateItemModel != null) {
            float carIconScale = getCarIconScale(estimateItemModel);
            if (verticalCarViewHolder.carIcon != null) {
                verticalCarViewHolder.carIcon.setScaleX(carIconScale);
                verticalCarViewHolder.carIcon.setScaleY(carIconScale);
            }
        }
    }

    public int calculateCardHeight(float f, boolean z, int i) {
        int i2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (z) {
            int i3 = this.f13194f;
            i2 = (int) (((float) i3) + (((float) (i - i3)) * f));
        } else {
            i2 = (int) (((float) i) - (((float) (i - this.f13194f)) * f));
        }
        int i4 = this.f13194f;
        return i2 < i4 ? i4 : i2;
    }

    public int calculateCarIconWidth(float f, boolean z) {
        float f2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (z) {
            int i = this.f13195g;
            f2 = ((float) i) + (((float) (this.f13196h - i)) * f);
        } else {
            int i2 = this.f13196h;
            f2 = ((float) i2) - (((float) (i2 - this.f13195g)) * f);
        }
        return (int) f2;
    }

    public int calculateCarIconHeight(float f, boolean z) {
        float f2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (z) {
            int i = this.f13197i;
            f2 = ((float) i) + (((float) (this.f13198j - i)) * f);
        } else {
            int i2 = this.f13198j;
            f2 = ((float) i2) - (((float) (i2 - this.f13197i)) * f);
        }
        return (int) f2;
    }

    public float getCarIconScale(EstimateItemModel estimateItemModel) {
        float f = 1.0f;
        if (estimateItemModel != null && estimateItemModel.isSelected) {
            float floatValue = ((Float) this.f13199k.getAnimatedValue()).floatValue();
            if (estimateItemModel == this.f13202n && this.f13199k.isRunning()) {
                f = floatValue;
            }
            return calculateCarIconScale(f, true);
        }
        float floatValue2 = ((Float) this.f13200l.getAnimatedValue()).floatValue();
        if (estimateItemModel == this.f13203o && this.f13200l.isRunning()) {
            f = floatValue2;
        }
        return calculateCarIconScale(f, false);
    }

    public int getCarIconWidth(EstimateItemModel estimateItemModel) {
        float f = 1.0f;
        if (estimateItemModel != null && estimateItemModel.isSelected) {
            float floatValue = ((Float) this.f13199k.getAnimatedValue()).floatValue();
            if (estimateItemModel == this.f13202n && this.f13199k.isRunning()) {
                f = floatValue;
            }
            return calculateCarIconWidth(f, true);
        }
        float floatValue2 = ((Float) this.f13200l.getAnimatedValue()).floatValue();
        if (estimateItemModel == this.f13203o && this.f13200l.isRunning()) {
            f = floatValue2;
        }
        return calculateCarIconWidth(f, false);
    }

    public int getCarIconHeight(EstimateItemModel estimateItemModel) {
        float f = 1.0f;
        if (estimateItemModel != null && estimateItemModel.isSelected) {
            float floatValue = ((Float) this.f13199k.getAnimatedValue()).floatValue();
            if (estimateItemModel == this.f13202n && this.f13199k.isRunning()) {
                f = floatValue;
            }
            return calculateCarIconHeight(f, true);
        }
        float floatValue2 = ((Float) this.f13200l.getAnimatedValue()).floatValue();
        if (estimateItemModel == this.f13203o && this.f13200l.isRunning()) {
            f = floatValue2;
        }
        return calculateCarIconHeight(f, false);
    }

    public int getmMagnifierViewTopMargin() {
        return this.f13209u;
    }

    public void setMoveMargin(int i) {
        this.f13208t = i;
    }
}
