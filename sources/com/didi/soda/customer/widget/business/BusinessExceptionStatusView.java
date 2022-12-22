package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class BusinessExceptionStatusView extends ConstraintLayout {

    /* renamed from: a */
    private static String f41633a;

    /* renamed from: b */
    private static String f41634b;

    /* renamed from: c */
    private static String f41635c;

    /* renamed from: d */
    private TextView f41636d;

    /* renamed from: e */
    private TextView f41637e;

    /* renamed from: f */
    private ConstraintLayout f41638f;

    public BusinessExceptionStatusView(Context context) {
        super(context);
        m29421d();
    }

    public BusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29421d();
    }

    public BusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29421d();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m29420c();
        } else if (businessExceptionShowStyle != 2) {
            m29419b();
        } else {
            m29418a(str);
        }
    }

    /* renamed from: a */
    private void m29417a() {
        f41633a = getContext().getString(R.string.customer_business_status_closed);
        f41634b = getContext().getString(R.string.customer_business_status_open_soon);
        f41635c = getContext().getString(R.string.customer_business_status_out_of_delivery);
    }

    /* renamed from: b */
    private void m29419b() {
        this.f41636d.setText(f41633a);
        this.f41637e.setText(f41634b);
        this.f41637e.setMaxLines(2);
        this.f41638f.setBackgroundResource(R.drawable.customer_bg_business_exception_status_container);
        this.f41636d.setVisibility(0);
    }

    /* renamed from: c */
    private void m29420c() {
        this.f41636d.setVisibility(8);
        this.f41637e.setMaxLines(3);
        this.f41637e.setText(f41635c);
        this.f41638f.setBackgroundResource(R.drawable.customer_shape_bg_business_out_delivery_tips);
    }

    /* renamed from: a */
    private void m29418a(String str) {
        this.f41636d.setText(f41633a);
        this.f41637e.setMaxLines(2);
        this.f41637e.setText(getContext().getString(R.string.customer_business_status_next_open_time, new Object[]{str}));
        this.f41638f.setBackgroundResource(R.drawable.customer_bg_business_exception_status_container);
        this.f41636d.setVisibility(0);
    }

    /* renamed from: d */
    private void m29421d() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_business_exception_status_view, this);
        this.f41636d = (TextView) findViewById(R.id.customer_tv_status);
        this.f41637e = (TextView) findViewById(R.id.customer_tv_tips);
        this.f41638f = (ConstraintLayout) findViewById(R.id.customer_cl_container);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41636d, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41637e, IToolsService.FontType.BOLD);
        m29417a();
    }
}
