package com.android.didi.safetoolkit.widget.progressbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.taxis99.R;

public class CustomColorProgressBar extends ProgressBar {
    public CustomColorProgressBar(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public CustomColorProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CustomColorProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public CustomColorProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setColor(context.getResources().getColor(R.color.colorAccent));
    }

    public void setColor(int i) {
        getIndeterminateDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        postInvalidate();
    }
}
