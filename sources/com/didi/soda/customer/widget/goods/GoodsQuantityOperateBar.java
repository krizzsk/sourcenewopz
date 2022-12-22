package com.didi.soda.customer.widget.goods;

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
    private static final int f41850a = 2;

    /* renamed from: b */
    private String f41851b;

    /* renamed from: c */
    private GoodsQuantityListener f41852c;

    /* renamed from: d */
    private Bundle f41853d;

    /* renamed from: e */
    private boolean f41854e = false;

    /* renamed from: f */
    private TextView f41855f;

    /* renamed from: g */
    private View f41856g;

    /* renamed from: h */
    private View f41857h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f41858i;

    /* renamed from: j */
    private FrameLayout f41859j;

    /* renamed from: k */
    private TextView f41860k;

    /* renamed from: l */
    private GoodsAmountModel f41861l;

    /* renamed from: m */
    private Context f41862m;

    /* renamed from: n */
    private Drawable f41863n = null;

    /* renamed from: o */
    private Drawable f41864o = null;

    public GoodsQuantityOperateBar(Context context) {
        super(context);
        m29518a(context, (AttributeSet) null);
    }

    public GoodsQuantityOperateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29518a(context, attributeSet);
    }

    public void onHandleAddGoodsAction() {
        m29519a((View) this.f41858i);
    }

    public void onHandleSubtractGoodsAction() {
        m29524c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f41856g.setEnabled(z);
        this.f41858i.setEnabled(z);
        this.f41857h.setEnabled(z);
        this.f41859j.setEnabled(z);
        this.f41860k.setEnabled(z);
        if (this.f41854e) {
            this.f41855f.setEnabled(z);
            if (z) {
                this.f41855f.setTextColor(this.f41862m.getResources().getColor(R.color.rf_color_jianbian_2));
            } else {
                this.f41855f.setTextColor(this.f41862m.getResources().getColor(R.color.rf_color_gery_3_60_999999));
            }
        } else {
            this.f41855f.setEnabled(z);
        }
    }

    public void setGoodsQuantityListener(GoodsQuantityListener goodsQuantityListener) {
        this.f41852c = goodsQuantityListener;
    }

    public void setSubtractBgDisabled() {
        this.f41857h.setBackground(getContext().getResources().getDrawable(R.drawable.customer_img_goods_subtract_disabled));
    }

    public void setSubtractEnabled(boolean z) {
        super.setEnabled(z);
        this.f41857h.setBackground(this.f41864o);
        this.f41857h.setEnabled(z);
        this.f41859j.setEnabled(z);
    }

    public void updateGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        this.f41861l = goodsAmountModel;
        int currentAmount = goodsAmountModel.getCurrentAmount();
        this.f41851b = goodsAmountModel.mGoodsId;
        m29516a(currentAmount);
        m29522b(currentAmount);
        m29525c(currentAmount);
        m29526d(currentAmount);
    }

    /* access modifiers changed from: package-private */
    public void setExtra(Bundle bundle) {
        this.f41853d = bundle;
    }

    /* renamed from: a */
    private void m29518a(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        ColorStateList colorStateList;
        int i3;
        this.f41862m = context;
        float f = 0.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.GoodsQuantityOperateBar);
            i3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            colorStateList = obtainStyledAttributes.getColorStateList(3);
            i2 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            this.f41864o = obtainStyledAttributes.getDrawable(2);
            this.f41863n = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            i = (int) obtainStyledAttributes.getDimension(4, 0.0f);
            f = (float) obtainStyledAttributes.getDimensionPixelSize(5, 0);
        } else {
            colorStateList = null;
            i = 0;
            i3 = 0;
            i2 = 0;
        }
        m29521b();
        m29517a(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.leftMargin = i2;
        this.f41858i.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.rightMargin = i2;
        this.f41859j.setLayoutParams(layoutParams2);
        this.f41857h.setBackground(this.f41864o);
        this.f41856g.setBackground(this.f41863n);
        this.f41860k.setTextSize(0, f);
        this.f41860k.setMinWidth(i);
        if (colorStateList != null) {
            this.f41860k.setTextColor(colorStateList);
        }
        this.f41860k.setGravity(17);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41860k, IToolsService.FontType.BOLD);
        setOrientation(0);
        setGravity(16);
        this.f41858i.addView(this.f41856g, new FrameLayout.LayoutParams(i3, i3));
        this.f41859j.addView(this.f41857h, new FrameLayout.LayoutParams(i3, i3));
        addView(this.f41855f);
        addView(this.f41859j);
        addView(this.f41860k);
        addView(this.f41858i);
        this.f41859j.setVisibility(8);
        this.f41860k.setVisibility(8);
        this.f41858i.setVisibility(8);
        this.f41860k.setMaxEms(2);
        m29515a();
        setEnabled(true);
    }

    /* renamed from: a */
    private void m29515a() {
        this.f41855f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar goodsQuantityOperateBar = GoodsQuantityOperateBar.this;
                    goodsQuantityOperateBar.m29519a((View) goodsQuantityOperateBar.f41858i);
                }
            }
        });
        this.f41858i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar.this.m29519a(view);
                }
            }
        });
        this.f41859j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar.this.m29524c();
                }
            }
        });
    }

    /* renamed from: a */
    private void m29517a(Context context) {
        this.f41856g = new View(context);
        this.f41857h = new View(context);
        this.f41858i = new FrameLayout(context);
        this.f41859j = new FrameLayout(context);
        this.f41860k = new TextView(context);
        if (this.f41854e) {
            TextView textView = new TextView(context);
            this.f41855f = textView;
            textView.setText(context.getResources().getString(R.string.customer_global_add));
            this.f41855f.setTextColor(context.getResources().getColor(R.color.rf_color_jianbian_2));
            this.f41855f.setBackground(this.f41862m.getResources().getDrawable(R.drawable.customer_selector_goods_operator_initial_view));
        } else {
            TextView textView2 = new TextView(context);
            this.f41855f = textView2;
            textView2.setBackground(this.f41863n);
        }
        this.f41855f.setEnabled(true);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41855f, IToolsService.FontType.BOLD);
    }

    /* renamed from: b */
    private void m29521b() {
        boolean z = true;
        if (((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().showStyle != 1) {
            z = false;
        }
        this.f41854e = z;
    }

    /* renamed from: a */
    private void m29516a(int i) {
        if (i > 0) {
            this.f41860k.setText(String.valueOf(i));
            this.f41860k.setVisibility(0);
            return;
        }
        this.f41860k.setVisibility(8);
    }

    /* renamed from: b */
    private void m29522b(int i) {
        this.f41855f.setVisibility(i == 0 ? 0 : 8);
    }

    /* renamed from: c */
    private void m29525c(int i) {
        this.f41858i.setVisibility(i > 0 ? 0 : 8);
    }

    /* renamed from: d */
    private void m29526d(int i) {
        this.f41859j.setVisibility(i > 0 ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29519a(View view) {
        GoodsQuantityListener goodsQuantityListener = this.f41852c;
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onAddGoodsClick(this.f41851b, view, this.f41853d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29524c() {
        GoodsQuantityListener goodsQuantityListener = this.f41852c;
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onSubtractGoodsClick(this.f41851b, this.f41853d);
        }
    }
}
