package com.didi.soda.uiwidget.cardview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.didi.soda.uiwidget.cardview.SodaRoundRectDrawableWithShadow;

class SodaCardView17Impl$1 implements SodaRoundRectDrawableWithShadow.RoundRectHelper {
    final /* synthetic */ C14224a this$0;

    SodaCardView17Impl$1(C14224a aVar) {
        this.this$0 = aVar;
    }

    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
