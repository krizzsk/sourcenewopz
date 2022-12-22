package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

public class RFMainButton extends RFStyleButton {

    /* renamed from: a */
    private boolean f33354a;

    /* access modifiers changed from: protected */
    public int getLoadingRes() {
        return R.raw.rf_lottie_loading_white;
    }

    public RFMainButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFMainButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFMainButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        setTextColor(RFResUtils.getColorStateList(getContext(), R.color.rf_selector_btn_main_text));
        setContentBackground(RFResUtils.getDrawable(getContext(), R.drawable.rf_selector_bg_btn_main));
    }

    /* access modifiers changed from: protected */
    public void initLogic(AttributeSet attributeSet) {
        super.initLogic(attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(C10448R.styleable.RFMainButton);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        setEnableShadow(z);
    }

    public void setEnableShadow(boolean z) {
        boolean z2 = this.f33354a;
        if (z2 != z) {
            if (z2) {
                setShadow(RFResUtils.getColor(getContext(), R.color.rf_color_shadow_1_81), (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_10), (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_8), 0, (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_4));
            } else {
                setShadow(RFResUtils.getColor(getContext(), R.color.rf_color_shadow_1_81), 0, 0, 0, 0);
            }
            this.f33354a = z;
        }
    }
}
