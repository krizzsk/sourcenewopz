package com.didi.unifiedPay.component.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class TotalPayAreaView extends RelativeLayout {

    /* renamed from: a */
    private TextView f44443a;

    /* renamed from: b */
    private TextView f44444b;

    /* renamed from: c */
    private TextView f44445c;

    public TotalPayAreaView(Context context) {
        super(context);
        m31562a();
    }

    public TotalPayAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31562a();
    }

    /* renamed from: a */
    private void m31562a() {
        LayoutInflater.from(getContext()).inflate(R.layout.total_pay_area, this);
        this.f44443a = (TextView) findViewById(R.id.total_pay_area_label);
        this.f44444b = (TextView) findViewById(R.id.total_pay_area_value);
        this.f44445c = (TextView) findViewById(R.id.total_pay_area_desc);
    }

    public void refresh(String str, String str2, String str3) {
        m31563a(this.f44443a, str);
        m31563a(this.f44444b, str2);
        m31563a(this.f44445c, str3);
    }

    /* renamed from: a */
    private void m31563a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }
}
