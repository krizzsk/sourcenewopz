package com.didi.soda.customer.widget.goodsV2.stepper;

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
import com.didi.soda.customer.widget.goodsV2.EnlargeClickAreaContainer;
import com.taxis99.R;

public class GoodsQuantityAnimStepper extends RelativeLayout {

    /* renamed from: a */
    private static final int f41957a = 300;

    /* renamed from: b */
    private ImageView f41958b;

    /* renamed from: c */
    private ImageView f41959c;

    /* renamed from: d */
    private TextView f41960d;

    /* renamed from: e */
    private ObjectAnimator f41961e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GoodsStepperListener f41962f;

    /* renamed from: g */
    private EnlargeClickAreaContainer f41963g;

    /* renamed from: h */
    private EnlargeClickAreaContainer f41964h;

    /* renamed from: i */
    private int f41965i;

    /* renamed from: j */
    private int f41966j;

    /* renamed from: k */
    private int f41967k;

    /* renamed from: l */
    private int f41968l;

    /* renamed from: m */
    private ViewGroup.LayoutParams f41969m;

    public GoodsQuantityAnimStepper(Context context) {
        super(context);
        m29584a(context, (AttributeSet) null);
    }

    public GoodsQuantityAnimStepper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29584a(context, attributeSet);
    }

    public void setGoodsStepperListener(GoodsStepperListener goodsStepperListener) {
        this.f41962f = goodsStepperListener;
    }

    public void initState(GoodsStepperModel goodsStepperModel) {
        if (goodsStepperModel != null) {
            setAddEnabled(goodsStepperModel.mIsAddEnabled);
            m29581a(goodsStepperModel.mCurQuantityNumber);
            goodsStepperModel.syncLastQuantityNumber();
        }
    }

    public void updateState(GoodsStepperModel goodsStepperModel) {
        if (goodsStepperModel != null) {
            setAddEnabled(goodsStepperModel.mIsAddEnabled);
            m29587a(goodsStepperModel);
            goodsStepperModel.syncLastQuantityNumber();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(getDefaultSize(this.f41965i, i), i2);
    }

    private void setAddEnabled(boolean z) {
        this.f41958b.setImageResource(z ? this.f41967k : this.f41968l);
    }

    /* renamed from: a */
    private void m29581a(int i) {
        ObjectAnimator objectAnimator = this.f41961e;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f41961e.cancel();
        }
        if (i <= 0) {
            m29582a(this.f41965i, 0.0f);
            return;
        }
        m29582a(this.f41966j, 1.0f);
        this.f41960d.setText(String.valueOf(i));
    }

    /* renamed from: a */
    private void m29587a(GoodsStepperModel goodsStepperModel) {
        int i = goodsStepperModel.mCurQuantityNumber;
        if (i >= 0) {
            if (i > 0) {
                this.f41960d.setText(String.valueOf(i));
            }
            if (goodsStepperModel.needExpand()) {
                m29590c();
            } else if (goodsStepperModel.needCollapse()) {
                m29591d();
            }
        }
    }

    /* renamed from: a */
    private void m29584a(Context context, AttributeSet attributeSet) {
        int dip2px = DisplayUtils.dip2px(getContext(), 18.0f);
        int color = ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666);
        this.f41967k = R.drawable.customer_stepper_add_icon_v2;
        this.f41968l = R.drawable.customer_stepper_add_icon_disable_v2;
        this.f41965i = DisplayUtils.dip2px(getContext(), 22.0f);
        this.f41966j = DisplayUtils.dip2px(getContext(), 110.0f);
        int i = R.drawable.customer_stepper_sub_icon_v2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.GoodsQuantityAnimStepper);
            dip2px = obtainStyledAttributes.getDimensionPixelSize(6, dip2px);
            color = obtainStyledAttributes.getColor(5, color);
            i = obtainStyledAttributes.getResourceId(4, R.drawable.customer_stepper_sub_icon_v2);
            this.f41967k = obtainStyledAttributes.getResourceId(0, this.f41967k);
            this.f41968l = obtainStyledAttributes.getResourceId(1, this.f41968l);
            this.f41965i = obtainStyledAttributes.getDimensionPixelSize(3, this.f41965i);
            this.f41966j = obtainStyledAttributes.getDimensionPixelSize(2, this.f41966j);
            obtainStyledAttributes.recycle();
        }
        m29583a(context);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 26.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams.addRule(9);
        EnlargeClickAreaContainer newInstance = EnlargeClickAreaContainer.newInstance(getContext());
        this.f41963g = newInstance;
        newInstance.setTarget(this.f41959c).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsQuantityAnimStepper.this.m29589b(view);
            }
        }).setRootLayoutParams(layoutParams).build(dip2px2);
        this.f41959c.setImageResource(i);
        this.f41960d.setTextSize(0, (float) dip2px);
        this.f41960d.setTextColor(color);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f41960d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams3.addRule(11);
        EnlargeClickAreaContainer newInstance2 = EnlargeClickAreaContainer.newInstance(getContext());
        this.f41964h = newInstance2;
        newInstance2.setTarget(this.f41958b).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsQuantityAnimStepper.this.m29585a(view);
            }
        }).setRootLayoutParams(layoutParams3).build(dip2px2);
        this.f41958b.setBackgroundColor(-1);
        setAddEnabled(true);
        addView(this.f41963g);
        addView(this.f41960d);
        addView(this.f41964h);
        this.f41959c.setAlpha(0.0f);
        this.f41960d.setAlpha(0.0f);
        m29580a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29589b(View view) {
        GoodsStepperListener goodsStepperListener = this.f41962f;
        if (goodsStepperListener != null) {
            goodsStepperListener.onSubtractClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29585a(View view) {
        GoodsStepperListener goodsStepperListener = this.f41962f;
        if (goodsStepperListener != null) {
            goodsStepperListener.onAddClick();
        }
    }

    /* renamed from: a */
    private void m29580a() {
        this.f41958b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GoodsQuantityAnimStepper.this.f41962f != null) {
                    GoodsQuantityAnimStepper.this.f41962f.onAddClick();
                }
            }
        });
        this.f41959c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GoodsQuantityAnimStepper.this.f41962f != null) {
                    GoodsQuantityAnimStepper.this.f41962f.onSubtractClick();
                }
            }
        });
    }

    /* renamed from: a */
    private void m29583a(Context context) {
        this.f41958b = new ImageView(context);
        this.f41959c = new ImageView(context);
        this.f41960d = new TextView(context);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41960d, IToolsService.FontType.BOLD);
        setGravity(16);
    }

    /* renamed from: b */
    private void m29588b() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "", new int[]{this.f41965i, this.f41966j});
        this.f41961e = ofInt;
        ofInt.setInterpolator(CustomerInterpolator.newInstance());
        this.f41961e.setDuration(300);
        this.f41961e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoodsQuantityAnimStepper.this.m29582a(((Integer) valueAnimator.getAnimatedValue()).intValue(), valueAnimator.getAnimatedFraction());
            }
        });
        this.f41961e.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29582a(int i, float f) {
        if (this.f41969m == null) {
            this.f41969m = getLayoutParams();
        }
        this.f41969m.width = i;
        setLayoutParams(this.f41969m);
        this.f41959c.setAlpha(f);
        this.f41960d.setAlpha(f);
    }

    /* renamed from: c */
    private void m29590c() {
        if (this.f41961e == null) {
            m29588b();
        }
        this.f41961e.start();
    }

    /* renamed from: d */
    private void m29591d() {
        if (this.f41961e == null) {
            m29588b();
        }
        this.f41961e.reverse();
    }
}
