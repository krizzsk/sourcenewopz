package com.didi.beatles.p099im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMChoiceTitleBar */
public class IMChoiceTitleBar extends RelativeLayout {

    /* renamed from: a */
    private TextView f9864a;

    /* renamed from: b */
    private TextView f9865b;

    /* renamed from: c */
    private TextView f9866c;

    public IMChoiceTitleBar(Context context) {
        super(context);
        m6671a();
    }

    public IMChoiceTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6671a();
    }

    public IMChoiceTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6671a();
    }

    public IMChoiceTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m6671a();
    }

    /* renamed from: a */
    private void m6671a() {
        LayoutInflater.from(getContext()).inflate(R.layout.im_choice_title_bar, this, true);
        this.f9864a = (TextView) findViewById(R.id.left_tv);
        this.f9865b = (TextView) findViewById(R.id.middle_tv);
        this.f9866c = (TextView) findViewById(R.id.right_tv);
    }

    public TextView getLeftImgView() {
        return this.f9864a;
    }

    public TextView getRightTextView() {
        return this.f9866c;
    }

    public void setChoiceCount(int i) {
        setVisibility(0);
        if (i > 0) {
            if (i > 1) {
                this.f9865b.setText(String.format(IMResource.getString(R.string.im_have_choices), new Object[]{Integer.valueOf(i)}));
            } else {
                this.f9865b.setText(String.format(IMResource.getString(R.string.im_have_choice), new Object[]{Integer.valueOf(i)}));
            }
            this.f9866c.setClickable(true);
            this.f9866c.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            return;
        }
        this.f9865b.setText(IMResource.getString(R.string.im_choose_msg));
        this.f9866c.setClickable(false);
        this.f9866c.setTextColor(IMResource.getColor(R.color.bts_im_color_light_gray_s));
    }

    public void showChoiceBar() {
        setVisibility(0);
    }

    public void hideChoiceBar() {
        setVisibility(8);
    }
}
