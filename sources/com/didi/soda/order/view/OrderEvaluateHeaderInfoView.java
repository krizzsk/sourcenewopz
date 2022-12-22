package com.didi.soda.order.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.CircleImageView;
import com.taxis99.R;

public class OrderEvaluateHeaderInfoView extends FrameLayout {

    /* renamed from: a */
    private TextView f43600a;

    /* renamed from: b */
    private CircleImageView f43601b;

    /* renamed from: c */
    private TextView f43602c;

    /* renamed from: d */
    private TextView f43603d;

    public OrderEvaluateHeaderInfoView(Context context) {
        super(context);
        m30900a();
    }

    public OrderEvaluateHeaderInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30900a();
    }

    public OrderEvaluateHeaderInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30900a();
    }

    public void setHeaderTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f43600a.setText(str);
            this.f43600a.setVisibility(0);
            return;
        }
        this.f43600a.setVisibility(8);
    }

    public void setEvaluateHeaderImage(String str, int i) {
        FlyImageLoader.loadImageUnspecified(getContext(), str).placeholder(i).error(i).into((ImageView) this.f43601b);
    }

    public void setNameImage(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f43602c.setText(str);
            this.f43602c.setVisibility(0);
        } else {
            this.f43602c.setVisibility(8);
        }
        this.f43602c.setMaxLines(i);
    }

    public void setContentText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f43603d.setText(str);
            this.f43603d.setVisibility(0);
            return;
        }
        this.f43603d.setVisibility(8);
    }

    /* renamed from: a */
    private void m30900a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_header_info, this, true);
        this.f43600a = (TextView) inflate.findViewById(R.id.customer_tv_title);
        this.f43601b = (CircleImageView) inflate.findViewById(R.id.customer_iv_header_image);
        this.f43602c = (TextView) inflate.findViewById(R.id.customer_tv_name);
        this.f43603d = (TextView) inflate.findViewById(R.id.customer_tv_content);
    }
}
