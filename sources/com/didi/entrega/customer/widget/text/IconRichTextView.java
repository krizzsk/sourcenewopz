package com.didi.entrega.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.rfusion.widget.RFIconView;

public class IconRichTextView extends RFIconView {
    public IconRichTextView(Context context) {
        super(context);
    }

    public IconRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IconRichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(RichTextParser.parseIconText(charSequence), bufferType);
    }
}
