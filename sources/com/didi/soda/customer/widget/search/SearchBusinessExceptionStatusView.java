package com.didi.soda.customer.widget.search;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class SearchBusinessExceptionStatusView extends ConstraintLayout {

    /* renamed from: a */
    private static String f42173a;

    /* renamed from: b */
    private static String f42174b;

    /* renamed from: c */
    private static String f42175c;

    /* renamed from: d */
    private TextView f42176d;

    /* renamed from: e */
    private TextView f42177e;

    public SearchBusinessExceptionStatusView(Context context) {
        super(context);
        m29731d();
    }

    public SearchBusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29731d();
    }

    public SearchBusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29731d();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m29730c();
        } else if (businessExceptionShowStyle != 2) {
            m29729b();
        } else {
            m29728a(str);
        }
    }

    /* renamed from: a */
    private void m29727a() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f42176d.setLetterSpacing(0.1f);
            f42173a = getContext().getString(R.string.customer_business_status_closed_no_gap);
        } else {
            f42173a = getContext().getString(R.string.customer_business_status_closed);
        }
        f42174b = getContext().getString(R.string.customer_business_status_open_soon_no_folding);
        f42175c = getContext().getString(R.string.customer_business_status_out_of_delivery_no_folding);
    }

    /* renamed from: b */
    private void m29729b() {
        this.f42177e.setText(f42174b);
        this.f42177e.setBackgroundResource(R.drawable.customer_shape_bg_search_business_exception_tip);
        this.f42176d.setText(f42173a);
        this.f42176d.setVisibility(0);
    }

    /* renamed from: c */
    private void m29730c() {
        this.f42176d.setVisibility(8);
        this.f42177e.setText(f42175c);
        this.f42177e.setBackgroundResource(R.drawable.customer_shape_bg_search_business_exception_out_delivery);
    }

    /* renamed from: a */
    private void m29728a(String str) {
        this.f42177e.setText(getContext().getString(R.string.customer_business_status_next_open_time_no_folding, new Object[]{str}));
        this.f42177e.setBackgroundResource(R.drawable.customer_shape_bg_search_business_exception_tip);
        this.f42176d.setText(f42173a);
        this.f42176d.setVisibility(0);
    }

    /* renamed from: d */
    private void m29731d() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_search_business_exception_status_view, this);
        this.f42176d = (TextView) findViewById(R.id.customer_tv_status);
        this.f42177e = (TextView) findViewById(R.id.customer_tv_tips);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f42176d, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f42177e, IToolsService.FontType.BOLD);
        m29727a();
    }
}
