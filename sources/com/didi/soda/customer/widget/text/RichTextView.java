package com.didi.soda.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;

public class RichTextView extends CustomerAppCompatTextView {
    public RichTextView(Context context) {
        super(context);
    }

    public RichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(RichTextParser.parseText(charSequence), bufferType);
    }
}
