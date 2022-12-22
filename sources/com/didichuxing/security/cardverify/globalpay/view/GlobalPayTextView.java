package com.didichuxing.security.cardverify.globalpay.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C10448R;

public class GlobalPayTextView extends AppCompatTextView {

    /* renamed from: a */
    private final int f48933a = 1;

    /* renamed from: b */
    private final int f48934b = 2;

    /* renamed from: c */
    private final int f48935c = 3;

    /* renamed from: d */
    private final int f48936d = 4;

    /* renamed from: e */
    private final int f48937e = 5;

    public GlobalPayTextView(Context context) {
        super(context);
    }

    public GlobalPayTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35132a(context, attributeSet, 0);
    }

    public GlobalPayTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35132a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m35132a(Context context, AttributeSet attributeSet, int i) {
        int i2 = context.obtainStyledAttributes(attributeSet, C10448R.styleable.GlobalPayTextView, i, 0).getInt(0, 1);
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? null : "fonts/Aspira-Thin.otf" : "fonts/Aspira-Demi.otf" : "fonts/Aspira-Medium.otf" : "fonts/Aspira-Light.otf" : "fonts/Aspira-Regular.otf";
        if (!TextUtils.isEmpty(str)) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
        }
    }
}
