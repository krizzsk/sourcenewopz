package com.didi.bike.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.fintech.cashier.core.ktx.StringKtxKt;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighlightTextView extends AppCompatTextView {

    /* renamed from: a */
    private int f10672a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnClickHighlightTextListener f10673b;

    public interface OnClickHighlightTextListener {
        void onClick(int i);
    }

    public HighlightTextView(Context context) {
        super(context);
        m7284a(context, (AttributeSet) null);
    }

    public HighlightTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7284a(context, attributeSet);
    }

    public HighlightTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7284a(context, attributeSet);
    }

    /* renamed from: a */
    private void m7284a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.HighlightTextView);
            this.f10672a = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.ride_ammo_color_FF7F41));
            obtainStyledAttributes.recycle();
        }
        CharSequence text = getText();
        if (!TextUtils.isEmpty(text)) {
            setText(text);
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(m7283a(charSequence, this.f10672a), bufferType);
    }

    /* renamed from: a */
    private CharSequence m7283a(CharSequence charSequence, final int i) {
        if (isEmpty(charSequence)) {
            return "";
        }
        if (i == 0) {
            return charSequence;
        }
        Matcher matcher = Pattern.compile(StringKtxKt.REGULAR_EXPRESSION).matcher(charSequence);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        final int i2 = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            if (spannableStringBuilder.charAt(range.start + 1) != '#') {
                spannableStringBuilder.delete(range.start, range.start + 1);
                spannableStringBuilder.delete(range.end - 2, range.end - 1);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i), range.start, range.end - 2, 18);
            } else {
                spannableStringBuilder.delete(range.start, range.start + 2);
                spannableStringBuilder.delete(range.end - 3, range.end - 2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i), range.start, range.end - 3, 18);
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (HighlightTextView.this.f10673b != null) {
                            HighlightTextView.this.f10673b.onClick(i2);
                        }
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(i);
                        textPaint.setUnderlineText(false);
                    }
                }, range.start, range.end - 3, 18);
                i2++;
            }
        }
        return spannableStringBuilder;
    }

    public void setOnClickHighlightTextListener(OnClickHighlightTextListener onClickHighlightTextListener) {
        setMovementMethod(LinkMovementMethod.getInstance());
        this.f10673b = onClickHighlightTextListener;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        return m7285a(charSequence.toString());
    }

    /* renamed from: a */
    static boolean m7285a(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equals("null")) {
            return true;
        }
        return false;
    }

    static class Range {
        public final int end;
        public final int start;

        Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }
}
