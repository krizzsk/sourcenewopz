package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFTextButton extends RFButton {

    /* renamed from: a */
    private RFTextView f33397a;

    /* renamed from: b */
    private int f33398b;

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.rf_btn_text;
    }

    public RFTextButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f33397a = (RFTextView) findViewById(R.id.rf_tv_text);
    }

    /* access modifiers changed from: protected */
    public void initLogic(AttributeSet attributeSet) {
        super.initLogic(attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFTextButton);
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        setType(i);
    }

    /* access modifiers changed from: protected */
    public void updateText(CharSequence charSequence) {
        this.f33397a.setText(charSequence);
    }

    public void setType(int i) {
        int i2;
        this.f33398b = i;
        if (i != 0) {
            i2 = RFResUtils.getColor(getContext(), R.color.rf_color_gery_2_40_666666);
        } else {
            i2 = RFResUtils.getColor(getContext(), R.color.rf_color_brands_1_100);
        }
        this.f33397a.setTextColor(i2);
    }

    public int getType() {
        return this.f33398b;
    }
}
