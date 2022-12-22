package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.taxis99.R;

public class GoodsQuantityOperateBar extends LinearLayout implements GoodsQuantityActionHandler {

    /* renamed from: a */
    private static final int f41926a = 2;

    /* renamed from: b */
    private String f41927b;

    /* renamed from: c */
    private GoodsQuantityListener f41928c;

    /* renamed from: d */
    private Bundle f41929d;

    /* renamed from: e */
    private boolean f41930e = false;

    /* renamed from: f */
    private TextView f41931f;

    /* renamed from: g */
    private View f41932g;

    /* renamed from: h */
    private View f41933h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f41934i;

    /* renamed from: j */
    private FrameLayout f41935j;

    /* renamed from: k */
    private TextView f41936k;

    /* renamed from: l */
    private GoodsAmountModel f41937l;

    /* renamed from: m */
    private Context f41938m;

    /* renamed from: n */
    private Drawable f41939n = null;

    /* renamed from: o */
    private Drawable f41940o = null;

    public GoodsQuantityOperateBar(Context context) {
        super(context);
        m29560a(context, (AttributeSet) null);
    }

    public GoodsQuantityOperateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29560a(context, attributeSet);
    }

    public void onHandleAddGoodsAction() {
        m29561a((View) this.f41934i);
    }

    public void onHandleSubtractGoodsAction() {
        m29566c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f41932g.setEnabled(z);
        this.f41934i.setEnabled(z);
        this.f41933h.setEnabled(z);
        this.f41935j.setEnabled(z);
        this.f41936k.setEnabled(z);
        if (this.f41930e) {
            this.f41931f.setEnabled(z);
            if (z) {
                this.f41931f.setTextColor(this.f41938m.getResources().getColor(R.color.rf_color_jianbian_2));
            } else {
                this.f41931f.setTextColor(this.f41938m.getResources().getColor(R.color.rf_color_gery_3_60_999999));
            }
        } else {
            this.f41931f.setEnabled(z);
        }
    }

    public void setGoodsQuantityListener(GoodsQuantityListener goodsQuantityListener) {
        this.f41928c = goodsQuantityListener;
    }

    public void setSubtractBgDisabled() {
        this.f41933h.setBackground(getContext().getResources().getDrawable(R.drawable.customer_img_goods_subtract_disabled));
    }

    public void setSubtractEnabled(boolean z) {
        super.setEnabled(z);
        this.f41933h.setBackground(this.f41940o);
        this.f41933h.setEnabled(z);
        this.f41935j.setEnabled(z);
    }

    public void updateGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        this.f41937l = goodsAmountModel;
        int currentAmount = goodsAmountModel.getCurrentAmount();
        this.f41927b = goodsAmountModel.mGoodsId;
        m29558a(currentAmount);
        m29564b(currentAmount);
        m29567c(currentAmount);
        m29568d(currentAmount);
    }

    /* access modifiers changed from: package-private */
    public void setExtra(Bundle bundle) {
        this.f41929d = bundle;
    }

    /* renamed from: a */
    private void m29560a(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        ColorStateList colorStateList;
        int i3;
        this.f41938m = context;
        float f = 0.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.GoodsQuantityOperateBar);
            i3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            colorStateList = obtainStyledAttributes.getColorStateList(3);
            i2 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            this.f41940o = obtainStyledAttributes.getDrawable(2);
            this.f41939n = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            i = (int) obtainStyledAttributes.getDimension(4, 0.0f);
            f = (float) obtainStyledAttributes.getDimensionPixelSize(5, 0);
        } else {
            colorStateList = null;
            i = 0;
            i3 = 0;
            i2 = 0;
        }
        m29563b();
        m29559a(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.leftMargin = i2;
        this.f41934i.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.rightMargin = i2;
        this.f41935j.setLayoutParams(layoutParams2);
        this.f41933h.setBackground(this.f41940o);
        this.f41932g.setBackground(this.f41939n);
        this.f41936k.setTextSize(0, f);
        this.f41936k.setMinWidth(i);
        if (colorStateList != null) {
            this.f41936k.setTextColor(colorStateList);
        }
        this.f41936k.setGravity(17);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41936k, IToolsService.FontType.BOLD);
        setOrientation(0);
        setGravity(16);
        this.f41934i.addView(this.f41932g, new FrameLayout.LayoutParams(i3, i3));
        this.f41935j.addView(this.f41933h, new FrameLayout.LayoutParams(i3, i3));
        addView(this.f41931f);
        addView(this.f41935j);
        addView(this.f41936k);
        addView(this.f41934i);
        this.f41935j.setVisibility(8);
        this.f41936k.setVisibility(8);
        this.f41934i.setVisibility(8);
        this.f41936k.setMaxEms(2);
        m29557a();
        setEnabled(true);
    }

    /* renamed from: a */
    private void m29557a() {
        this.f41931f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar goodsQuantityOperateBar = GoodsQuantityOperateBar.this;
                    goodsQuantityOperateBar.m29561a((View) goodsQuantityOperateBar.f41934i);
                }
            }
        });
        this.f41934i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar.this.m29561a(view);
                }
            }
        });
        this.f41935j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar.this.m29566c();
                }
            }
        });
    }

    /* renamed from: a */
    private void m29559a(Context context) {
        this.f41932g = new View(context);
        this.f41933h = new View(context);
        this.f41934i = new FrameLayout(context);
        this.f41935j = new FrameLayout(context);
        this.f41936k = new TextView(context);
        if (this.f41930e) {
            TextView textView = new TextView(context);
            this.f41931f = textView;
            textView.setText(context.getResources().getString(R.string.customer_global_add));
            this.f41931f.setTextColor(context.getResources().getColor(R.color.rf_color_jianbian_2));
            this.f41931f.setBackground(this.f41938m.getResources().getDrawable(R.drawable.customer_selector_goods_operator_initial_view));
        } else {
            TextView textView2 = new TextView(context);
            this.f41931f = textView2;
            textView2.setBackground(this.f41939n);
        }
        this.f41931f.setEnabled(true);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41931f, IToolsService.FontType.BOLD);
    }

    /* renamed from: b */
    private void m29563b() {
        boolean z = true;
        if (((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().showStyle != 1) {
            z = false;
        }
        this.f41930e = z;
    }

    /* renamed from: a */
    private void m29558a(int i) {
        if (i > 0) {
            this.f41936k.setText(String.valueOf(i));
            this.f41936k.setVisibility(0);
            return;
        }
        this.f41936k.setVisibility(8);
    }

    /* renamed from: b */
    private void m29564b(int i) {
        this.f41931f.setVisibility(i == 0 ? 0 : 8);
    }

    /* renamed from: c */
    private void m29567c(int i) {
        this.f41934i.setVisibility(i > 0 ? 0 : 8);
    }

    /* renamed from: d */
    private void m29568d(int i) {
        this.f41935j.setVisibility(i > 0 ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29561a(View view) {
        GoodsQuantityListener goodsQuantityListener = this.f41928c;
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onAddGoodsClick(this.f41927b, view, this.f41929d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29566c() {
        GoodsQuantityListener goodsQuantityListener = this.f41928c;
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onSubtractGoodsClick(this.f41927b, this.f41929d);
        }
    }
}
