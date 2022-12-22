package com.didi.dimina.starbox.module.jsbridge.performance.view;

import android.content.Context;
import com.didi.dimina.container.util.LogUtil;
import java.util.Locale;

public class PerfTextView<T> extends AbsTextView<T> {
    private final String format;
    private final String title;
    private final String unit;

    public PerfTextView(Context context) {
        this(context, (String) null, (String) null, (String) null);
    }

    public PerfTextView(Context context, String str, String str2, String str3) {
        super(context);
        this.title = str;
        this.format = str2;
        this.unit = str3;
    }

    public void onProvide(T t) {
        if (this.format != null && this.unit != null) {
            Locale locale = Locale.US;
            setText(String.format(locale, this.title + ": " + this.format, new Object[]{t, this.unit}));
            LogUtil.m13410e("ComPerfTextView", this.title + ": " + getText());
        }
    }
}
