package com.didi.map.global.component.dropoff.recmarker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.common.map.util.DisplayUtils;

public class StrokeTextView extends AppCompatTextView {

    /* renamed from: a */
    TextPaint f25574a = new TextPaint();

    /* renamed from: b */
    private final int f25575b;

    /* renamed from: c */
    private final float f25576c;

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25576c = (float) DisplayUtils.dp2px(context, 2.0f);
        this.f25575b = -1;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        ColorStateList textColors = getTextColors();
        TextPaint paint = getPaint();
        this.f25574a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f25574a.setStrokeJoin(Paint.Join.ROUND);
        this.f25574a.setStrokeMiter(10.0f);
        setTextColor(this.f25575b);
        this.f25574a.setStrokeWidth(this.f25576c);
        super.onDraw(canvas);
        this.f25574a.setStyle(Paint.Style.FILL);
        setTextColor(textColors);
        super.onDraw(canvas);
    }
}
