package com.didi.soda.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.soda.customer.foundation.util.FontUtils;

public class IconTextView extends AppCompatTextView {
    public IconTextView(Context context) {
        super(context);
        m29775a();
    }

    public IconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29775a();
    }

    public IconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29775a();
    }

    /* renamed from: a */
    private void m29775a() {
        super.setTypeface(FontUtils.getIconTypeface());
    }
}
