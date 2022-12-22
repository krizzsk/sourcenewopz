package com.didi.soda.customer.widget.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CartBusinessExceptionStatusView extends LinearLayout {

    /* renamed from: a */
    private static String f41644a;

    /* renamed from: b */
    private static String f41645b;

    /* renamed from: c */
    private static String f41646c;

    /* renamed from: d */
    private static String f41647d;

    /* renamed from: e */
    private TextView f41648e;

    /* renamed from: f */
    private TextView f41649f;

    /* renamed from: g */
    private TextView f41650g;

    /* renamed from: h */
    private ViewGroup f41651h;

    public CartBusinessExceptionStatusView(Context context) {
        super(context);
        m29432e();
    }

    public CartBusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29432e();
    }

    public CartBusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29432e();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m29429b();
        } else if (businessExceptionShowStyle == 2) {
            m29428a(str);
        } else if (businessExceptionShowStyle != 3) {
            m29427a();
        } else {
            m29430c();
        }
    }

    /* renamed from: a */
    private void m29427a() {
        this.f41648e.setText(f41644a);
        this.f41649f.setText(f41645b);
        this.f41648e.setVisibility(0);
        this.f41649f.setVisibility(0);
        this.f41650g.setVisibility(8);
    }

    /* renamed from: b */
    private void m29429b() {
        this.f41648e.setVisibility(8);
        this.f41649f.setVisibility(8);
        this.f41650g.setVisibility(0);
        this.f41650g.setText(f41646c);
    }

    /* renamed from: a */
    private void m29428a(String str) {
        this.f41648e.setText(f41644a);
        this.f41649f.setText(getContext().getString(R.string.customer_business_status_next_open_time_no_folding, new Object[]{str}));
        this.f41648e.setVisibility(0);
        this.f41649f.setVisibility(0);
        this.f41650g.setVisibility(8);
    }

    /* renamed from: c */
    private void m29430c() {
        this.f41648e.setVisibility(8);
        this.f41649f.setVisibility(8);
        this.f41650g.setVisibility(0);
        this.f41650g.setText(f41647d);
    }

    /* renamed from: d */
    private void m29431d() {
        f41644a = getContext().getString(R.string.customer_business_status_closed);
        f41645b = getContext().getString(R.string.customer_business_status_open_soon_no_folding);
        f41646c = getContext().getString(R.string.customer_business_status_out_of_delivery_no_folding);
        f41647d = getContext().getString(R.string.customer_business_detail_temporarily_unavailable);
    }

    /* renamed from: e */
    private void m29432e() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_cart_business_exception_status_view, this);
        this.f41648e = (TextView) findViewById(R.id.customer_tv_status);
        this.f41649f = (TextView) findViewById(R.id.customer_tv_tips);
        this.f41651h = (ViewGroup) findViewById(R.id.customer_ll_status_container);
        this.f41650g = (TextView) findViewById(R.id.customer_tv_out_of_delivery);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41648e, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41649f, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41650g, IToolsService.FontType.MEDIUM);
        m29431d();
    }
}
