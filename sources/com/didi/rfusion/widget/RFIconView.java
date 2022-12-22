package com.didi.rfusion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.rfusion.utils.RFFontUtils;

public class RFIconView extends AppCompatTextView {
    public RFIconView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23440a(context);
    }

    /* renamed from: a */
    private void m23440a(Context context) {
        if (!isInEditMode()) {
            setTypeface(RFFontUtils.getIconTypeface(context));
        }
        setIncludeFontPadding(false);
        setGravity(17);
    }
}
