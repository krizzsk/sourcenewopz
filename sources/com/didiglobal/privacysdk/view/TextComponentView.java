package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.taxis99.R;

public class TextComponentView extends LinearLayout {

    /* renamed from: a */
    private ViewGroup f50707a;

    /* renamed from: b */
    private TextView f50708b;

    /* renamed from: c */
    private TextView f50709c;

    /* renamed from: d */
    private View f50710d;

    /* renamed from: e */
    private TextView f50711e;

    /* renamed from: f */
    private ImageView f50712f;

    /* renamed from: g */
    private View f50713g;

    /* renamed from: h */
    private TextView f50714h;

    /* renamed from: i */
    private TextView f50715i;

    public TextComponentView(Context context) {
        super(context);
    }

    public TextComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f50707a = (ViewGroup) findViewById(R.id.title_container);
        this.f50708b = (TextView) findViewById(R.id.sidebar_nav_item_name);
        this.f50709c = (TextView) findViewById(R.id.sidebar_nav_item_right_des);
        this.f50710d = findViewById(R.id.setting_list_item_arrow);
        this.f50712f = (ImageView) findViewById(R.id.item_icon);
        this.f50711e = (TextView) findViewById(R.id.item_tip);
        this.f50713g = findViewById(R.id.divider);
        this.f50714h = (TextView) findViewById(R.id.item_right_des_tip);
        this.f50715i = (TextView) findViewById(R.id.description);
        if (GlobalPrivacySDK.isItemTitleBold()) {
            this.f50708b.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    public void hideDivider() {
        this.f50713g.setVisibility(8);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f50707a.setOnClickListener(onClickListener);
    }

    public void setName(int i) {
        setName(getContext().getResources().getString(i));
    }

    public void setName(String str) {
        this.f50708b.setText(str);
    }

    public void setRightDes(int i) {
        setRightDes(getContext().getResources().getString(i));
    }

    public void setRightDes(String str) {
        this.f50709c.setVisibility(0);
        this.f50709c.setText(str);
    }

    public void setRightDesColor(int i) {
        this.f50709c.setTextColor(i);
    }

    public void setRightDesTipVisible() {
        this.f50714h.setVisibility(0);
    }

    public void setTip(String str) {
        this.f50711e.setVisibility(0);
        this.f50711e.setText(str);
    }

    public void setIcon(Bitmap bitmap) {
        this.f50712f.setVisibility(0);
        this.f50712f.setImageBitmap(bitmap);
    }

    public void setRightArrowVisible(int i) {
        this.f50710d.setVisibility(i);
    }

    public void setDescText(int i) {
        setDescText((CharSequence) getContext().getResources().getString(i));
    }

    public void setDescText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f50715i.setText(charSequence);
            this.f50715i.setVisibility(0);
        }
    }

    public void setDescTextColor(int i) {
        this.f50715i.setTextColor(i);
    }

    public void setDescVisibility(int i) {
        this.f50715i.setVisibility(i);
    }
}
