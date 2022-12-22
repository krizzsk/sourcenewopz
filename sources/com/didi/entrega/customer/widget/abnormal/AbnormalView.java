package com.didi.entrega.customer.widget.abnormal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.support.CustomerAppCompatImageView;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.taxis99.R;

public class AbnormalView extends ConstraintLayout {

    /* renamed from: a */
    private LinearLayout f20364a;

    /* renamed from: b */
    private ImageView f20365b;

    /* renamed from: c */
    private TextView f20366c;

    /* renamed from: d */
    private TextView f20367d;

    /* renamed from: e */
    private RFGhostButton f20368e;

    public AbnormalView(Context context) {
        super(context);
        m14924a();
    }

    public AbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14924a();
    }

    public AbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14924a();
    }

    public void show(AbnormalViewModel abnormalViewModel) {
        if (abnormalViewModel.resId > 0) {
            this.f20365b.setImageResource(abnormalViewModel.resId);
            this.f20365b.setVisibility(0);
        } else {
            this.f20365b.setVisibility(8);
        }
        if (TextUtils.isEmpty(abnormalViewModel.title)) {
            this.f20366c.setVisibility(8);
        } else {
            this.f20366c.setText(abnormalViewModel.title);
            this.f20366c.setVisibility(0);
        }
        if (TextUtils.isEmpty(abnormalViewModel.subTitle)) {
            this.f20367d.setVisibility(8);
        } else {
            this.f20367d.setText(abnormalViewModel.subTitle);
            this.f20367d.setVisibility(0);
        }
        if (TextUtils.isEmpty(abnormalViewModel.retryText)) {
            this.f20368e.setVisibility(8);
            return;
        }
        this.f20368e.setText(abnormalViewModel.retryText);
        this.f20368e.setVisibility(0);
        if (abnormalViewModel.clickListener != null) {
            this.f20368e.setOnClickListener(abnormalViewModel.clickListener);
        } else {
            this.f20368e.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: a */
    private void m14924a() {
        m14925b();
    }

    /* renamed from: b */
    private void m14925b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f20364a = linearLayout;
        linearLayout.setMinimumWidth(CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 32.0f));
        this.f20364a.setOrientation(1);
        this.f20365b = new CustomerAppCompatImageView(getContext());
        this.f20366c = new CustomerAppCompatTextView(getContext());
        this.f20367d = new CustomerAppCompatTextView(getContext());
        this.f20368e = new RFGhostButton(getContext());
        this.f20366c.setGravity(17);
        this.f20366c.setTextSize(1, 18.0f);
        this.f20366c.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f20366c, IToolsService.FontType.MEDIUM);
        this.f20367d.setGravity(17);
        this.f20367d.setTextSize(1, 12.5f);
        this.f20367d.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_2_40_666666));
        this.f20367d.setPadding(DisplayUtils.dip2px(getContext(), 39.0f), 0, DisplayUtils.dip2px(getContext(), 39.0f), 0);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f20367d, IToolsService.FontType.LIGHT);
        this.f20368e.setSpec(1);
        this.f20368e.setVisibility(8);
        int dip2px = DisplayUtils.dip2px(getContext(), 144.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.gravity = 17;
        this.f20365b.setScaleType(ImageView.ScaleType.CENTER);
        this.f20364a.addView(this.f20365b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = DisplayUtils.dip2px(getContext(), -4.0f);
        this.f20364a.addView(this.f20366c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = DisplayUtils.dip2px(getContext(), 3.0f);
        this.f20364a.addView(this.f20367d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = DisplayUtils.dip2px(getContext(), 23.5f);
        layoutParams4.gravity = 17;
        this.f20364a.addView(this.f20368e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams5.verticalBias = 0.18f;
        addView(this.f20364a, layoutParams5);
    }
}
