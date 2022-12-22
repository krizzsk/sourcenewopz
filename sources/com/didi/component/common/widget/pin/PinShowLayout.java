package com.didi.component.common.widget.pin;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.taxis99.R;

public class PinShowLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f12074a = 3;

    /* renamed from: b */
    private Context f12075b;

    /* renamed from: c */
    private TextView f12076c;

    /* renamed from: d */
    private TextView f12077d;

    /* renamed from: e */
    private TextView f12078e;

    /* renamed from: f */
    private String f12079f;

    public PinShowLayout(Context context) {
        super(context);
        m8134a(context);
    }

    public PinShowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8134a(context);
    }

    public PinShowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8134a(context);
    }

    /* renamed from: a */
    private void m8134a(Context context) {
        this.f12075b = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f12075b, R.layout.global_pin_show_layout, this);
        this.f12076c = (TextView) findViewById(R.id.pin_show_digit_text_view_1);
        this.f12077d = (TextView) findViewById(R.id.pin_show_digit_text_view_2);
        this.f12078e = (TextView) findViewById(R.id.pin_show_digit_text_view_3);
    }

    public boolean showPin(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 3) {
            return false;
        }
        this.f12079f = str;
        this.f12076c.setText(str.substring(0, 1));
        this.f12077d.setText(str.substring(1, 2));
        this.f12078e.setText(str.substring(2, 3));
        return true;
    }
}
