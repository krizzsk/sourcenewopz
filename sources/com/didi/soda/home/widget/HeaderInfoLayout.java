package com.didi.soda.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.home.topgun.manager.HomeUpdateHeaderInfoHelper;
import com.taxis99.R;

public class HeaderInfoLayout extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f43273a;

    /* renamed from: b */
    private TextView f43274b;

    /* renamed from: c */
    private View f43275c;

    public HeaderInfoLayout(Context context) {
        super(context);
        m30592a();
    }

    public HeaderInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30592a();
    }

    public HeaderInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30592a();
    }

    public void updateHeaderInfo(ScopeContext scopeContext) {
        HomeUpdateHeaderInfoHelper.updateAddressInfo(this.f43274b, scopeContext, 0);
    }

    /* renamed from: a */
    private void m30592a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_home_head_info, this);
        this.f43273a = (ImageView) findViewById(R.id.customer_iv_feed_header);
        this.f43275c = findViewById(R.id.customer_vm_red_dot);
        this.f43274b = (TextView) findViewById(R.id.customer_tv_home_address);
    }
}
