package com.didi.soda.customer.widget.goods.stepper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CircleImageView;
import com.didi.soda.customer.widget.goods.EnlargeClickAreaContainer;
import com.taxis99.R;

public class GoodsQuantityAnimStepper extends RelativeLayout {

    /* renamed from: a */
    private static final int f41882a = 300;

    /* renamed from: b */
    private CircleImageView f41883b;

    /* renamed from: c */
    private ImageView f41884c;

    /* renamed from: d */
    private TextView f41885d;

    /* renamed from: e */
    private ObjectAnimator f41886e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GoodsStepperListener f41887f;

    /* renamed from: g */
    private EnlargeClickAreaContainer f41888g;

    /* renamed from: h */
    private EnlargeClickAreaContainer f41889h;

    /* renamed from: i */
    private int f41890i;

    /* renamed from: j */
    private int f41891j;

    /* renamed from: k */
    private int f41892k;

    /* renamed from: l */
    private int f41893l;

    /* renamed from: m */
    private ViewGroup.LayoutParams f41894m;

    public GoodsQuantityAnimStepper(Context context) {
        super(context);
        m29540a(context, (AttributeSet) null);
    }

    public GoodsQuantityAnimStepper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29540a(context, attributeSet);
    }

    public void setGoodsStepperListener(GoodsStepperListener goodsStepperListener) {
        this.f41887f = goodsStepperListener;
    }

    public void initState(GoodsStepperModel goodsStepperModel) {
        if (goodsStepperModel != null) {
            setAddEnabled(goodsStepperModel.mIsAddEnabled);
            m29537a(goodsStepperModel.mCurQuantityNumber);
            goodsStepperModel.syncLastQuantityNumber();
        }
    }

    public void updateState(GoodsStepperModel goodsStepperModel) {
        if (goodsStepperModel != null) {
            setAddEnabled(goodsStepperModel.mIsAddEnabled);
            m29543a(goodsStepperModel);
            goodsStepperModel.syncLastQuantityNumber();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(getDefaultSize(this.f41890i, i), i2);
    }

    private void setAddEnabled(boolean z) {
        this.f41883b.setImageResource(z ? this.f41892k : this.f41893l);
    }

    /* renamed from: a */
    private void m29537a(int i) {
        ObjectAnimator objectAnimator = this.f41886e;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f41886e.cancel();
        }
        if (i <= 0) {
            m29538a(this.f41890i, 0.0f);
            return;
        }
        m29538a(this.f41891j, 1.0f);
        this.f41885d.setText(String.valueOf(i));
    }

    /* renamed from: a */
    private void m29543a(GoodsStepperModel goodsStepperModel) {
        int i = goodsStepperModel.mCurQuantityNumber;
        if (i >= 0) {
            if (i > 0) {
                this.f41885d.setText(String.valueOf(i));
            }
            if (goodsStepperModel.needExpand()) {
                m29546c();
            } else if (goodsStepperModel.needCollapse()) {
                m29547d();
            }
        }
    }

    /* renamed from: a */
    private void m29540a(Context context, AttributeSet attributeSet) {
        int dip2px = DisplayUtils.dip2px(getContext(), 18.0f);
        int color = ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666);
        this.f41892k = R.drawable.customer_stepper_add_icon;
        this.f41893l = R.drawable.customer_stepper_add_icon_disable;
        this.f41890i = DisplayUtils.dip2px(getContext(), 22.0f);
        this.f41891j = DisplayUtils.dip2px(getContext(), 110.0f);
        int i = R.drawable.customer_stepper_sub_icon;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.GoodsQuantityAnimStepper);
            dip2px = obtainStyledAttributes.getDimensionPixelSize(6, dip2px);
            color = obtainStyledAttributes.getColor(5, color);
            i = obtainStyledAttributes.getResourceId(4, R.drawable.customer_stepper_sub_icon);
            this.f41892k = obtainStyledAttributes.getResourceId(0, this.f41892k);
            this.f41893l = obtainStyledAttributes.getResourceId(1, this.f41893l);
            this.f41890i = obtainStyledAttributes.getDimensionPixelSize(3, this.f41890i);
            this.f41891j = obtainStyledAttributes.getDimensionPixelSize(2, this.f41891j);
            obtainStyledAttributes.recycle();
        }
        m29539a(context);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 22.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams.addRule(9);
        EnlargeClickAreaContainer newInstance = EnlargeClickAreaContainer.newInstance(getContext());
        this.f41888g = newInstance;
        newInstance.setTarget(this.f41884c).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsQuantityAnimStepper.this.m29545b(view);
            }
        }).setRootLayoutParams(layoutParams).build(dip2px2);
        this.f41884c.setImageResource(i);
        this.f41885d.setTextSize(0, (float) dip2px);
        this.f41885d.setTextColor(color);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f41885d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams3.addRule(11);
        EnlargeClickAreaContainer newInstance2 = EnlargeClickAreaContainer.newInstance(getContext());
        this.f41889h = newInstance2;
        newInstance2.setTarget(this.f41883b).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsQuantityAnimStepper.this.m29541a(view);
            }
        }).setRootLayoutParams(layoutParams3).build(dip2px2);
        this.f41883b.setCircleBackgroundColor(-1);
        setAddEnabled(true);
        addView(this.f41888g);
        addView(this.f41885d);
        addView(this.f41889h);
        this.f41884c.setAlpha(0.0f);
        this.f41885d.setAlpha(0.0f);
        m29536a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29545b(View view) {
        GoodsStepperListener goodsStepperListener = this.f41887f;
        if (goodsStepperListener != null) {
            goodsStepperListener.onSubtractClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29541a(View view) {
        GoodsStepperListener goodsStepperListener = this.f41887f;
        if (goodsStepperListener != null) {
            goodsStepperListener.onAddClick();
        }
    }

    /* renamed from: a */
    private void m29536a() {
        this.f41883b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GoodsQuantityAnimStepper.this.f41887f != null) {
                    GoodsQuantityAnimStepper.this.f41887f.onAddClick();
                }
            }
        });
        this.f41884c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GoodsQuantityAnimStepper.this.f41887f != null) {
                    GoodsQuantityAnimStepper.this.f41887f.onSubtractClick();
                }
            }
        });
    }

    /* renamed from: a */
    private void m29539a(Context context) {
        this.f41883b = new CircleImageView(context);
        this.f41884c = new ImageView(context);
        this.f41885d = new TextView(context);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41885d, IToolsService.FontType.NORMAL);
        setGravity(16);
    }

    /* renamed from: b */
    private void m29544b() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "", new int[]{this.f41890i, this.f41891j});
        this.f41886e = ofInt;
        ofInt.setInterpolator(CustomerInterpolator.newInstance());
        this.f41886e.setDuration(300);
        this.f41886e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoodsQuantityAnimStepper.this.m29538a(((Integer) valueAnimator.getAnimatedValue()).intValue(), valueAnimator.getAnimatedFraction());
            }
        });
        this.f41886e.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29538a(int i, float f) {
        if (this.f41894m == null) {
            this.f41894m = getLayoutParams();
        }
        this.f41894m.width = i;
        setLayoutParams(this.f41894m);
        this.f41884c.setAlpha(f);
        this.f41885d.setAlpha(f);
    }

    /* renamed from: c */
    private void m29546c() {
        if (this.f41886e == null) {
            m29544b();
        }
        this.f41886e.start();
    }

    /* renamed from: d */
    private void m29547d() {
        if (this.f41886e == null) {
            m29544b();
        }
        this.f41886e.reverse();
    }
}
