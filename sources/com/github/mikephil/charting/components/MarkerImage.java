package com.github.mikephil.charting.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerImage implements IMarker {

    /* renamed from: a */
    private Context f52319a;

    /* renamed from: b */
    private Drawable f52320b;

    /* renamed from: c */
    private MPPointF f52321c = new MPPointF();

    /* renamed from: d */
    private MPPointF f52322d = new MPPointF();

    /* renamed from: e */
    private WeakReference<Chart> f52323e;

    /* renamed from: f */
    private FSize f52324f = new FSize();

    /* renamed from: g */
    private Rect f52325g = new Rect();

    public void refreshContent(Entry entry, Highlight highlight) {
    }

    public MarkerImage(Context context, int i) {
        this.f52319a = context;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f52320b = this.f52319a.getResources().getDrawable(i, (Resources.Theme) null);
        } else {
            this.f52320b = this.f52319a.getResources().getDrawable(i);
        }
    }

    public void setOffset(MPPointF mPPointF) {
        this.f52321c = mPPointF;
        if (mPPointF == null) {
            this.f52321c = new MPPointF();
        }
    }

    public void setOffset(float f, float f2) {
        this.f52321c.f52498x = f;
        this.f52321c.f52499y = f2;
    }

    public MPPointF getOffset() {
        return this.f52321c;
    }

    public void setSize(FSize fSize) {
        this.f52324f = fSize;
        if (fSize == null) {
            this.f52324f = new FSize();
        }
    }

    public FSize getSize() {
        return this.f52324f;
    }

    public void setChartView(Chart chart) {
        this.f52323e = new WeakReference<>(chart);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.f52323e;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        this.f52322d.f52498x = offset.f52498x;
        this.f52322d.f52499y = offset.f52499y;
        Chart chartView = getChartView();
        float f3 = this.f52324f.width;
        float f4 = this.f52324f.height;
        if (f3 == 0.0f && (drawable2 = this.f52320b) != null) {
            f3 = (float) drawable2.getIntrinsicWidth();
        }
        if (f4 == 0.0f && (drawable = this.f52320b) != null) {
            f4 = (float) drawable.getIntrinsicHeight();
        }
        if (this.f52322d.f52498x + f < 0.0f) {
            this.f52322d.f52498x = -f;
        } else if (chartView != null && f + f3 + this.f52322d.f52498x > ((float) chartView.getWidth())) {
            this.f52322d.f52498x = (((float) chartView.getWidth()) - f) - f3;
        }
        if (this.f52322d.f52499y + f2 < 0.0f) {
            this.f52322d.f52499y = -f2;
        } else if (chartView != null && f2 + f4 + this.f52322d.f52499y > ((float) chartView.getHeight())) {
            this.f52322d.f52499y = (((float) chartView.getHeight()) - f2) - f4;
        }
        return this.f52322d;
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.f52320b != null) {
            MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
            float f3 = this.f52324f.width;
            float f4 = this.f52324f.height;
            if (f3 == 0.0f) {
                f3 = (float) this.f52320b.getIntrinsicWidth();
            }
            if (f4 == 0.0f) {
                f4 = (float) this.f52320b.getIntrinsicHeight();
            }
            this.f52320b.copyBounds(this.f52325g);
            this.f52320b.setBounds(this.f52325g.left, this.f52325g.top, this.f52325g.left + ((int) f3), this.f52325g.top + ((int) f4));
            int save = canvas.save();
            canvas.translate(f + offsetForDrawingAtPoint.f52498x, f2 + offsetForDrawingAtPoint.f52499y);
            this.f52320b.draw(canvas);
            canvas.restoreToCount(save);
            this.f52320b.setBounds(this.f52325g);
        }
    }
}
