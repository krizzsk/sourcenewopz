package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.taxis99.R;

public class GlobalPrivacyTitleBar extends FrameLayout {

    /* renamed from: a */
    private ViewGroup f50697a;

    /* renamed from: b */
    private ImageView f50698b;

    /* renamed from: c */
    private ImageView f50699c;

    /* renamed from: d */
    private TextView f50700d;

    /* renamed from: e */
    private TextView f50701e;

    public GlobalPrivacyTitleBar(Context context) {
        super(context);
        m36393a(context);
    }

    public GlobalPrivacyTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36393a(context);
    }

    public GlobalPrivacyTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36393a(context);
    }

    /* renamed from: a */
    private void m36393a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_privacy_title_bar, this);
        this.f50697a = (ViewGroup) inflate.findViewById(R.id.img_left_small_container);
        this.f50698b = (ImageView) inflate.findViewById(R.id.img_left_small);
        this.f50699c = (ImageView) inflate.findViewById(R.id.img_left_large);
        this.f50700d = (TextView) inflate.findViewById(R.id.txt_title_mid);
        this.f50701e = (TextView) inflate.findViewById(R.id.txt_title_left);
    }

    public void setLeftImgRes(int i) {
        this.f50699c.setImageResource(i);
        this.f50699c.setVisibility(0);
        this.f50697a.setVisibility(8);
    }

    public void setLeftSmallImgRes(int i) {
        this.f50698b.setBackgroundResource(i);
        this.f50699c.setVisibility(8);
        this.f50697a.setVisibility(0);
    }

    public void setOnLeftImgClickListener(View.OnClickListener onClickListener) {
        this.f50697a.setOnClickListener(onClickListener);
        this.f50699c.setOnClickListener(onClickListener);
    }

    public void setLeftTitle(int i) {
        this.f50701e.setText(i);
        this.f50701e.setVisibility(0);
        this.f50700d.setVisibility(8);
    }

    public void setMidTitle(int i) {
        this.f50700d.setText(i);
        this.f50700d.setVisibility(0);
        this.f50701e.setVisibility(8);
    }

    public void setTitleColor(int i) {
        this.f50700d.setTextColor(i);
        this.f50701e.setTextColor(i);
    }
}
