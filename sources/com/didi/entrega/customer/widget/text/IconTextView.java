package com.didi.entrega.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.entrega.customer.foundation.util.FontUtils;

public class IconTextView extends AppCompatTextView {
    public IconTextView(Context context) {
        super(context);
        m15073a();
    }

    public IconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15073a();
    }

    public IconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15073a();
    }

    /* renamed from: a */
    private void m15073a() {
        super.setTypeface(FontUtils.getIconTypeface());
    }
}
