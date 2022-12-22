package com.didi.beatles.p099im.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.widget.WaterMarkBg */
public class WaterMarkBg extends Drawable {

    /* renamed from: a */
    private Paint f10511a = new Paint();

    /* renamed from: b */
    private List<String> f10512b;

    /* renamed from: c */
    private Context f10513c;

    /* renamed from: d */
    private int f10514d;

    /* renamed from: e */
    private int f10515e;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public WaterMarkBg(Context context, List<String> list, int i, int i2) {
        this.f10512b = list;
        this.f10513c = context;
        this.f10514d = i;
        this.f10515e = i2;
    }

    public void draw(Canvas canvas) {
        int i = getBounds().right;
        int i2 = getBounds().bottom;
        this.f10511a.setColor(this.f10513c.getResources().getColor(R.color.im_color_water_mark_color));
        this.f10511a.setAntiAlias(true);
        this.f10511a.setTextSize((float) sp2px(this.f10513c, (float) this.f10515e));
        canvas.save();
        canvas.rotate((float) this.f10514d);
        float measureText = this.f10511a.measureText(this.f10512b.get(0));
        int i3 = i2 / 10;
        int i4 = i3;
        int i5 = 0;
        while (i4 <= i2) {
            float f = (float) (-i);
            int i6 = i5 + 1;
            float f2 = (float) (i5 % 2);
            while (true) {
                f += f2 * measureText;
                if (f >= ((float) i)) {
                    break;
                }
                int i7 = 0;
                for (String drawText : this.f10512b) {
                    canvas.drawText(drawText, f, (float) (i4 + i7), this.f10511a);
                    i7 += 50;
                }
                f2 = 2.0f;
            }
            i4 += i3 + 80;
            i5 = i6;
        }
        canvas.restore();
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
