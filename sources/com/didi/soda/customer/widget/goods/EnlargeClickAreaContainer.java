package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;

public class EnlargeClickAreaContainer extends FrameLayout {

    /* renamed from: a */
    private View f41849a;

    public EnlargeClickAreaContainer(Context context) {
        super(context);
    }

    public EnlargeClickAreaContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnlargeClickAreaContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static EnlargeClickAreaContainer newInstance(Context context) {
        return new EnlargeClickAreaContainer(context);
    }

    public EnlargeClickAreaContainer setTarget(View view) {
        if (view != null) {
            this.f41849a = view;
        }
        return this;
    }

    public EnlargeClickAreaContainer setRootLayoutParams(ViewGroup.LayoutParams layoutParams) {
        setLayoutParams(layoutParams);
        return this;
    }

    public EnlargeClickAreaContainer setClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
        return this;
    }

    public void build(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        ViewSafeHelper.safeAddView(this, this.f41849a, layoutParams);
    }
}
