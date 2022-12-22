package com.didi.sdk.view.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;

public class CommonPopupTitleBar extends RelativeLayout {

    /* renamed from: a */
    private TextView f38311a;

    /* renamed from: b */
    private TextView f38312b;

    /* renamed from: c */
    private TextView f38313c;

    /* renamed from: d */
    private TextView f38314d;

    public CommonPopupTitleBar(Context context) {
        super(context);
        m27090a();
    }

    public CommonPopupTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27090a();
    }

    public CommonPopupTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27090a();
    }

    public CommonPopupTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m27090a();
    }

    public TextView getTvTitle() {
        return this.f38313c;
    }

    public void setLeft(String str, View.OnClickListener onClickListener) {
        this.f38311a.setVisibility(0);
        this.f38311a.setText(str);
        this.f38311a.setOnClickListener(onClickListener);
    }

    public void setLeftText(String str) {
        this.f38311a.setVisibility(0);
        this.f38311a.setText(str);
    }

    public void setRightText(String str) {
        this.f38312b.setVisibility(0);
        this.f38312b.setText(str);
    }

    public void setLeft(View.OnClickListener onClickListener) {
        this.f38311a.setVisibility(0);
        this.f38311a.setOnClickListener(onClickListener);
    }

    public void setRight(String str, View.OnClickListener onClickListener) {
        this.f38312b.setVisibility(0);
        this.f38312b.setText(str);
        this.f38312b.setOnClickListener(onClickListener);
    }

    public void setMessage(String str) {
        this.f38314d.setVisibility(0);
        this.f38314d.setText(str);
    }

    public void setRight(View.OnClickListener onClickListener) {
        this.f38312b.setVisibility(0);
        this.f38312b.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.f38313c.setVisibility(0);
        this.f38313c.setText(str);
    }

    /* renamed from: a */
    private void m27090a() {
        LayoutInflater.from(getContext()).inflate(R.layout.v_common_popup_title_bar, this, true);
        this.f38311a = (TextView) findViewById(R.id.tv_cancel);
        this.f38312b = (TextView) findViewById(R.id.tv_confirm);
        this.f38313c = (TextView) findViewById(R.id.tv_title);
        this.f38314d = (TextView) findViewById(R.id.tv_message);
        int productBasicColor = ProductControllerStyleManager.getInstance().getProductThemeStyle().getProductBasicColor();
        if (productBasicColor != 0) {
            this.f38312b.setTextColor(productBasicColor);
        }
    }
}
