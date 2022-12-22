package com.scwang.smart.refresh.horizontal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smart.refresh.layout.api.RefreshFooter;

public class HorizontalFooter extends HorizontalComponent implements RefreshFooter {
    public HorizontalFooter(View view) {
        this(view.getContext());
        addView(view);
    }

    public HorizontalFooter(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizontalFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }
}
