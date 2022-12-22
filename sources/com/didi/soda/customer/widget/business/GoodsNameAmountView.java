package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class GoodsNameAmountView extends FrameLayout {

    /* renamed from: a */
    private TextView f41639a;

    /* renamed from: b */
    private TextView f41640b;

    /* renamed from: c */
    private int f41641c;

    /* renamed from: d */
    private String f41642d;

    public GoodsNameAmountView(Context context) {
        super(context);
        m29424b();
    }

    public GoodsNameAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29424b();
    }

    public GoodsNameAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29424b();
    }

    public void setNameTextColor(int i) {
        this.f41640b.setTextColor(i);
    }

    public void updateGoodsNameWithAmount(String str, int i) {
        this.f41642d = str;
        this.f41641c = i;
        m29423a(i);
        m29422a();
    }

    /* renamed from: a */
    private void m29422a() {
        this.f41640b.setText(getSpannableName());
    }

    /* renamed from: a */
    private void m29423a(int i) {
        if (i <= 0) {
            this.f41639a.setVisibility(8);
            return;
        }
        this.f41639a.setText(String.valueOf(i));
        this.f41639a.setVisibility(0);
    }

    private CharSequence getSpannableName() {
        if (this.f41641c <= 0) {
            return this.f41642d;
        }
        SpannableString spannableString = new SpannableString(this.f41642d);
        spannableString.setSpan(new LeadingMarginSpan.Standard(getAmountWidth(), 0), 0, spannableString.length(), 17);
        return spannableString;
    }

    private int getAmountWidth() {
        int i = this.f41641c;
        if (i < 10) {
            return DisplayUtils.dip2px(getContext(), 24.0f);
        }
        if (i < 100) {
            return DisplayUtils.dip2px(getContext(), 30.0f);
        }
        return DisplayUtils.dip2px(getContext(), 36.0f);
    }

    /* renamed from: b */
    private void m29424b() {
        this.f41639a = new TextView(getContext());
        this.f41640b = new TextView(getContext());
        m29426d();
        m29425c();
        addView(this.f41639a, new FrameLayout.LayoutParams(-2, -2));
        addView(this.f41640b, new FrameLayout.LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m29425c() {
        this.f41640b.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f41640b.setTextSize(1, 18.0f);
        this.f41640b.setMaxLines(2);
        this.f41640b.setLineSpacing(0.0f, 1.2f);
        this.f41640b.setEllipsize(TextUtils.TruncateAt.END);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41640b, IToolsService.FontType.MEDIUM);
    }

    /* renamed from: d */
    private void m29426d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) DisplayUtils.dip2px(getContext(), 3.0f));
        gradientDrawable.setColor(SkinUtil.getBrandPrimaryColor());
        this.f41639a.setBackground(gradientDrawable);
        int dip2px = DisplayUtils.dip2px(getContext(), 1.5f);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 5.0f);
        this.f41639a.setPadding(dip2px2, dip2px, dip2px2, dip2px);
        this.f41639a.setTextColor(getContext().getResources().getColor(R.color.rf_color_white_100_FFFFFF));
        this.f41639a.setTextSize(1, 13.0f);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41639a, IToolsService.FontType.BOLD);
    }
}
