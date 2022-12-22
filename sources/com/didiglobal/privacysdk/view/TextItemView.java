package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.taxis99.R;

public class TextItemView extends FrameLayout {

    /* renamed from: a */
    private TextView f50716a;

    /* renamed from: b */
    private TextView f50717b;

    /* renamed from: c */
    private View f50718c;

    /* renamed from: d */
    private View f50719d;

    public TextItemView(Context context) {
        super(context);
        m36397a(context);
    }

    public TextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36397a(context);
    }

    public TextItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36397a(context);
    }

    /* renamed from: a */
    private void m36397a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.global_privacy_text_item, this, true);
        this.f50716a = (TextView) findViewById(R.id.title);
        if (GlobalPrivacySDK.isItemTitleBold()) {
            this.f50716a.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.f50717b = (TextView) findViewById(R.id.description);
        this.f50718c = findViewById(R.id.bottom);
        this.f50719d = findViewById(R.id.divider);
    }

    public void setDividerVisibility(int i) {
        this.f50719d.setVisibility(i);
    }

    public void setTitle(int i) {
        setTitle(getContext().getResources().getString(i));
    }

    public void setTitle(String str) {
        this.f50716a.setText(str);
    }

    public void setDescText(int i) {
        setDescText((CharSequence) getContext().getResources().getString(i));
    }

    public void setDescText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f50717b.setText(charSequence);
            this.f50717b.setVisibility(0);
            this.f50718c.setVisibility(8);
        }
    }

    public void setDescTextColor(int i) {
        this.f50717b.setTextColor(i);
    }

    public void setDescVisibility(int i) {
        this.f50717b.setVisibility(i);
    }
}
