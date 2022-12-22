package com.didi.global.xbanner.view.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.global.xbanner.utils.DisplayUtils;

public class RoundFrameLayout extends FrameLayout {
    public RoundFrameLayout(Context context) {
        super(context);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT <= 19) {
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight()), (float) DisplayUtils.dip2px(getContext(), 15.0f), (float) DisplayUtils.dip2px(getContext(), 15.0f), Path.Direction.CW);
            canvas.clipPath(path, Region.Op.REPLACE);
        }
        super.dispatchDraw(canvas);
    }
}
