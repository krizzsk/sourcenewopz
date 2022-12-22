package com.didi.soda.home.topgun.widget;

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

public class HomeBusinessExceptionStatusView extends ConstraintLayout {

    /* renamed from: a */
    private static String f43079a;

    /* renamed from: b */
    private static String f43080b;

    /* renamed from: c */
    private static String f43081c;

    /* renamed from: d */
    private static String f43082d;

    /* renamed from: e */
    private TextView f43083e;

    /* renamed from: f */
    private TextView f43084f;

    public HomeBusinessExceptionStatusView(Context context) {
        super(context);
        m30488e();
    }

    public HomeBusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30488e();
    }

    public HomeBusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30488e();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m30486c();
        } else if (businessExceptionShowStyle == 2) {
            m30484a(str);
        } else if (businessExceptionShowStyle != 3) {
            m30485b();
        } else {
            m30487d();
        }
    }

    /* renamed from: a */
    private void m30483a() {
        f43079a = getContext().getString(R.string.customer_business_status_closed);
        f43080b = getContext().getString(R.string.customer_business_status_closed_no_gap);
        f43081c = getContext().getString(R.string.customer_business_status_out_of_delivery);
        f43082d = getContext().getString(R.string.customer_business_detail_temporarily_unavailable);
    }

    /* renamed from: b */
    private void m30485b() {
        this.f43083e.setTextSize(1, 14.0f);
        this.f43083e.setMaxLines(1);
        m30489f();
        this.f43084f.setVisibility(8);
    }

    /* renamed from: c */
    private void m30486c() {
        m30490g();
        this.f43083e.setTextSize(1, 14.0f);
        this.f43084f.setVisibility(8);
        this.f43083e.setMaxLines(3);
        this.f43083e.setText(f43081c);
    }

    /* renamed from: a */
    private void m30484a(String str) {
        this.f43083e.setTextSize(1, 14.0f);
        this.f43083e.setMaxLines(1);
        m30489f();
        this.f43084f.setVisibility(0);
        this.f43084f.setText(getContext().getString(R.string.customer_business_status_next_open_time, new Object[]{str}));
    }

    /* renamed from: d */
    private void m30487d() {
        m30490g();
        this.f43083e.setTextSize(1, 14.0f);
        this.f43084f.setVisibility(8);
        this.f43083e.setMaxLines(2);
        this.f43083e.setText(f43082d);
    }

    /* renamed from: e */
    private void m30488e() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_home_business_exception_status_view, this);
        this.f43083e = (TextView) findViewById(R.id.customer_tv_status);
        this.f43084f = (TextView) findViewById(R.id.customer_tv_tips);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43083e, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43084f, IToolsService.FontType.MEDIUM);
        m30483a();
    }

    /* renamed from: f */
    private void m30489f() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f43083e.setLetterSpacing(0.15f);
            this.f43083e.setText(f43080b);
            return;
        }
        this.f43083e.setText(f43079a);
    }

    /* renamed from: g */
    private void m30490g() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f43083e.setLetterSpacing(0.0f);
        }
    }
}
