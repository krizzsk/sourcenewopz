package com.didi.sdk.view.richtextview;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.ArrayList;

public class RichTextView extends TextView {

    /* renamed from: a */
    private static String f38178a = "red";

    /* renamed from: b */
    private SpannableString f38179b;

    public RichTextView(Context context) {
        super(context);
    }

    public RichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        boolean z;
        if (!TextUtils.isEmpty(charSequence)) {
            String charSequence2 = charSequence.toString();
            ArrayList<Span> spans = new BraceSpan().getSpans(charSequence2, (String) null);
            if (spans.size() > 0) {
                charSequence2 = spans.remove(0).source;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.f38179b = new SpannableString(charSequence2);
                m26990a(spans, 0);
                super.setText(this.f38179b, bufferType);
                return;
            }
            super.setText(charSequence, bufferType);
            return;
        }
        super.setText(charSequence, bufferType);
    }

    /* renamed from: a */
    private void m26990a(ArrayList<Span> arrayList, int i) {
        String str = f38178a.equals(getTag()) ? "#dd170c" : "#ff8903";
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.f38179b.setSpan(new NoLineClickSpan(str, arrayList.get(i2).key, arrayList.get(i2).link, arrayList.get(i2).title), arrayList.get(i2).spanStart, arrayList.get(i2).spanEnd, 33);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        SpannableString spannableString = new SpannableString(getText());
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - getTotalPaddingTop();
            int scrollX = x + getScrollX();
            int scrollY = y + getScrollY();
            Layout layout = getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableString.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    if (clickableSpanArr[0] instanceof NoLineClickSpan) {
                        ((NoLineClickSpan) clickableSpanArr[0]).onClick(this);
                        return true;
                    }
                    clickableSpanArr[0].onClick(this);
                }
                return true;
            }
        }
        return false;
    }
}
