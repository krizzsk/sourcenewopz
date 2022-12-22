package com.didi.soda.uiwidget.cardview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.didi.soda.uiwidget.cardview.SodaRoundRectDrawableWithShadow;

class SodaCardViewBaseImpl$1 implements SodaRoundRectDrawableWithShadow.RoundRectHelper {
    final /* synthetic */ C14226c this$0;

    SodaCardViewBaseImpl$1(C14226c cVar) {
        this.this$0 = cVar;
    }

    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        float f2 = 2.0f * f;
        float width = (rectF.width() - f2) - 1.0f;
        float height = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.this$0.f43850a.set(f4, f4, f3, f3);
            int save = canvas.save();
            canvas2.translate(rectF2.left + f3, rectF2.top + f3);
            Paint paint2 = paint;
            canvas.drawArc(this.this$0.f43850a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.this$0.f43850a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(height, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.this$0.f43850a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.this$0.f43850a, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(save);
            canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint2);
            canvas.drawRect((rectF2.left + f3) - 1.0f, (rectF2.bottom - f3) + 1.0f, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint2);
        }
        canvas.drawRect(rectF2.left, Math.max(0.0f, f - 1.0f) + rectF2.top, rectF2.right, (rectF2.bottom - f) + 1.0f, paint);
    }
}
