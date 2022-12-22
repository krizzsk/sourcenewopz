package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C10448R;

public class FontTextView extends AppCompatTextView {

    /* renamed from: a */
    private final int f47313a;

    /* renamed from: b */
    private final int f47314b;

    public FontTextView(Context context) {
        super(context);
        this.f47313a = 1;
        this.f47314b = 2;
    }

    public FontTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f47313a = 1;
        this.f47314b = 2;
        int i2 = context.obtainStyledAttributes(attributeSet, C10448R.styleable.FontTextView, i, 0).getInt(0, 1);
        String str = i2 != 1 ? i2 != 2 ? null : "otf/DiDiSans-Bold.otf" : "otf/DiDiSans-Regular.otf";
        if (!TextUtils.isEmpty(str)) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
        }
    }
}
