package com.didi.dimina.starbox.module.jsbridge.performance.view;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IView;

public abstract class AbsTextView<T> extends AppCompatTextView implements IView<T> {
    public View view() {
        return this;
    }

    public AbsTextView(Context context) {
        super(context);
        setTextColor(-1);
        setTextSize(1, 14.0f);
        int dip2px = PixUtil.dip2px(context, 1.0f);
        setPadding(dip2px, dip2px, dip2px, dip2px);
    }
}
