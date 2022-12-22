package com.didi.addressnew.framework.widget.toast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.taxis99.R;

public class AddressToast extends LinearLayout {

    /* renamed from: a */
    private ImageView f7444a;

    /* renamed from: b */
    private View f7445b;

    public void showSuccess(View view) {
    }

    public AddressToast(Context context) {
        super(context);
    }

    public AddressToast(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddressToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AddressToast(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m4684a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customize_toast_layout, this);
        this.f7444a = (ImageView) inflate.findViewById(R.id.toast_icon);
        this.f7445b = inflate.findViewById(R.id.et_end);
    }
}
