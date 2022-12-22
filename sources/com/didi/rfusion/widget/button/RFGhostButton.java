package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

public class RFGhostButton extends RFStyleButton {

    /* renamed from: a */
    private static final int f33352a = -1;

    /* renamed from: b */
    private int f33353b;

    /* access modifiers changed from: protected */
    public int getLoadingRes() {
        return R.raw.rf_lottie_loading_brand;
    }

    public RFGhostButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFGhostButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFGhostButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33353b = -1;
        init(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
    }

    /* access modifiers changed from: protected */
    public void initLogic(AttributeSet attributeSet) {
        super.initLogic(attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFGhostButton);
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        setType(i);
    }

    public void setType(int i) {
        if (this.f33353b != i) {
            this.f33353b = i;
            if (i == 0) {
                setTextColor(RFResUtils.getColorStateList(getContext(), R.color.rf_selector_btn_ghost_text));
                setContentBackground(RFResUtils.getDrawable(getContext(), R.drawable.rf_selector_bg_btn_ghost));
                setLoadingRes(R.raw.rf_lottie_loading_brand);
            } else if (i == 1) {
                setTextColor(RFResUtils.getColorStateList(getContext(), R.color.rf_selector_btn_ghost_text_dark));
                setContentBackground(RFResUtils.getDrawable(getContext(), R.drawable.rf_selector_bg_btn_ghost_dark));
                setLoadingRes(R.raw.rf_lottie_loading_dark);
            }
        }
    }

    public int getType() {
        return this.f33353b;
    }
}
