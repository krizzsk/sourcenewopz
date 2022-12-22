package com.didi.soda.customer.widget.abnormal.topgun;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class TopGunAbnormalView extends ConstraintLayout {

    /* renamed from: a */
    private LinearLayout f41627a;

    /* renamed from: b */
    private ImageView f41628b;

    /* renamed from: c */
    private TextView f41629c;

    /* renamed from: d */
    private TextView f41630d;

    /* renamed from: e */
    private CustomerAppCompatTextView f41631e;

    public TopGunAbnormalView(Context context) {
        super(context);
        m29413a();
    }

    public TopGunAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29413a();
    }

    public TopGunAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29413a();
    }

    public void show(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        if (topGunAbnormalViewModel.resId > 0) {
            this.f41628b.setImageResource(topGunAbnormalViewModel.resId);
            this.f41628b.setVisibility(0);
        } else {
            this.f41628b.setVisibility(8);
        }
        if (TextUtils.isEmpty(topGunAbnormalViewModel.title)) {
            this.f41629c.setVisibility(8);
        } else {
            this.f41629c.setText(topGunAbnormalViewModel.title);
            this.f41629c.setVisibility(0);
        }
        if (TextUtils.isEmpty(topGunAbnormalViewModel.subTitle)) {
            this.f41630d.setVisibility(8);
        } else {
            this.f41630d.setText(topGunAbnormalViewModel.subTitle);
            this.f41630d.setVisibility(0);
        }
        if (TextUtils.isEmpty(topGunAbnormalViewModel.retryText)) {
            this.f41631e.setVisibility(8);
            return;
        }
        this.f41631e.setText(topGunAbnormalViewModel.retryText);
        this.f41631e.setVisibility(0);
        if (topGunAbnormalViewModel.clickListener != null) {
            this.f41631e.setOnClickListener(topGunAbnormalViewModel.clickListener);
        } else {
            this.f41631e.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: a */
    private void m29413a() {
        m29414b();
    }

    /* renamed from: b */
    private void m29414b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f41627a = linearLayout;
        linearLayout.setMinimumWidth(CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 32.0f));
        this.f41627a.setOrientation(1);
        this.f41628b = new CustomerAppCompatImageView(getContext());
        this.f41629c = new CustomerAppCompatTextView(getContext());
        this.f41630d = new CustomerAppCompatTextView(getContext());
        this.f41631e = new CustomerAppCompatTextView(getContext());
        this.f41629c.setGravity(17);
        this.f41629c.setTextSize(1, 16.0f);
        this.f41629c.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41629c, IToolsService.FontType.BOLD);
        this.f41630d.setGravity(17);
        this.f41630d.setTextSize(1, 12.0f);
        this.f41630d.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f41630d.setPadding(DisplayUtils.dip2px(getContext(), 39.0f), 0, DisplayUtils.dip2px(getContext(), 39.0f), 0);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41630d, IToolsService.FontType.NORMAL);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41631e, IToolsService.FontType.BOLD);
        this.f41631e.setVisibility(8);
        this.f41631e.setBackgroundResource(R.drawable.customer_abnormal_retry_bg);
        this.f41631e.setTextSize(1, 12.0f);
        this.f41631e.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brands_1_100));
        int dip2px = DisplayUtils.dip2px(getContext(), 144.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.gravity = 17;
        this.f41628b.setScaleType(ImageView.ScaleType.CENTER);
        this.f41627a.addView(this.f41628b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = DisplayUtils.dip2px(getContext(), -4.0f);
        this.f41627a.addView(this.f41629c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = DisplayUtils.dip2px(getContext(), 3.0f);
        this.f41627a.addView(this.f41630d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32);
        layoutParams4.gravity = 17;
        this.f41631e.setPadding(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_15), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_15));
        this.f41627a.addView(this.f41631e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams5.verticalBias = 0.18f;
        addView(this.f41627a, layoutParams5);
    }
}
