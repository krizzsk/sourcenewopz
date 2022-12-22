package com.didi.rfusion.widget.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

/* renamed from: com.didi.rfusion.widget.toast.a */
/* compiled from: RFNormalToast */
class C11590a extends Toast {

    /* renamed from: a */
    private Context f34004a;

    /* renamed from: b */
    private TextView f34005b;

    /* renamed from: c */
    private FrameLayout f34006c;

    public C11590a(Context context) {
        super(context);
        this.f34004a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rf_toast_layout, (ViewGroup) null);
        this.f34006c = (FrameLayout) inflate.findViewById(R.id.rf_fl_toast_container);
        this.f34005b = (TextView) inflate.findViewById(R.id.rf_tv_toast_msg);
        setView(inflate);
        setGravity(17, 0, 0);
        setDuration(0);
    }

    /* renamed from: a */
    public void mo88599a(String str) {
        this.f34005b.setText(str);
    }

    /* renamed from: a */
    public void mo88598a(int i) {
        int i2;
        int i3;
        if (i != 1) {
            i2 = R.drawable.rf_shape_bg_toast_light;
            i3 = R.color.rf_color_gery_1_0_000000;
        } else {
            i2 = R.drawable.rf_shape_bg_toast_dark;
            i3 = R.color.rf_color_white_100_FFFFFF;
        }
        this.f34006c.setBackground(RFResUtils.getDrawable(this.f34004a, i2));
        this.f34005b.setTextColor(RFResUtils.getColor(this.f34004a, i3));
    }
}
