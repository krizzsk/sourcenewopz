package com.didi.sdk.log.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class FloatingView extends LinearLayout {

    /* renamed from: a */
    private TextView f36468a;

    public FloatingView(Context context) {
        super(context);
        m25848a();
    }

    /* renamed from: a */
    private void m25848a() {
        TextView textView = new TextView(getContext());
        this.f36468a = textView;
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f36468a.setText("Dchat connection message");
        this.f36468a.setTextColor(getResources().getColor(R.color.white));
        this.f36468a.setHeight((int) getResources().getDimension(R.dimen.top_bar_tab_more_item_img_width));
        this.f36468a.setWidth((getResources().getDisplayMetrics().widthPixels * 2) / 3);
        this.f36468a.setGravity(16);
        setBackgroundColor(getResources().getColor(R.color.bg_half_transparent));
        setPadding(20, 0, 0, 0);
        addView(this.f36468a);
    }

    public void setMsg(String str) {
        if (this.f36468a != null && !TextUtils.isEmpty(str)) {
            this.f36468a.setText(str);
        }
    }
}
