package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class OutdoorArDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f26876a;

    /* renamed from: b */
    private TextView f26877b;

    public OutdoorArDialog(Context context) {
        this(context, -1);
    }

    public OutdoorArDialog(Context context, int i) {
        super(context, i);
        m18985a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.addFlags(2);
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
    }

    /* renamed from: a */
    private void m18985a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.outdoor_ar_bottom_dialog_layout, (ViewGroup) null);
        this.f26876a = (TextView) inflate.findViewById(R.id.dialog_title);
        this.f26877b = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_close);
        try {
            int resIdByTheme = DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector);
            textView.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
            textView.setTextColor(ContextCompat.getColorStateList(getContext(), resIdByTheme));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        inflate.findViewById(R.id.dialog_close).setOnClickListener(this);
        setContentView(inflate);
    }

    public void setTitle(String str) {
        if (this.f26876a != null && !TextUtils.isEmpty(str)) {
            this.f26876a.setText(str);
        }
    }

    public void setSubTitle(String str) {
        if (this.f26877b != null && !TextUtils.isEmpty(str)) {
            this.f26877b.setText(str);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.dialog_close) {
            dismiss();
        }
    }
}
