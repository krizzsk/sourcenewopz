package p065me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.taxis99.R;

/* renamed from: me.dm7.barcodescanner.core.ViewFinderView */
public class ViewFinderView extends View implements IViewFinder {

    /* renamed from: a */
    private static final String f4748a = "ViewFinderView";

    /* renamed from: c */
    private static final float f4749c = 0.75f;

    /* renamed from: d */
    private static final float f4750d = 0.75f;

    /* renamed from: e */
    private static final float f4751e = 0.625f;

    /* renamed from: f */
    private static final float f4752f = 1.4f;

    /* renamed from: g */
    private static final int f4753g = 50;

    /* renamed from: h */
    private static final float f4754h = 0.625f;

    /* renamed from: i */
    private static final int[] f4755i = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: k */
    private static final int f4756k = 10;

    /* renamed from: l */
    private static final long f4757l = 80;

    /* renamed from: b */
    private Rect f4758b;

    /* renamed from: j */
    private int f4759j;

    /* renamed from: m */
    private final int f4760m = getResources().getColor(R.color.viewfinder_laser);
    protected int mBorderLineLength;
    protected Paint mBorderPaint;
    protected Paint mFinderMaskPaint;
    protected Paint mLaserPaint;
    protected boolean mSquareViewFinder;

    /* renamed from: n */
    private final int f4761n = getResources().getColor(R.color.viewfinder_mask);

    /* renamed from: o */
    private final int f4762o = getResources().getColor(R.color.viewfinder_border);

    /* renamed from: p */
    private final int f4763p = getResources().getInteger(R.integer.viewfinder_border_width);

    /* renamed from: q */
    private final int f4764q = getResources().getInteger(R.integer.viewfinder_border_length);

    /* renamed from: r */
    private boolean f4765r;

    /* renamed from: s */
    private float f4766s;

    /* renamed from: t */
    private int f4767t = 0;

    public ViewFinderView(Context context) {
        super(context);
        m3037a();
    }

    public ViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3037a();
    }

    /* renamed from: a */
    private void m3037a() {
        Paint paint = new Paint();
        this.mLaserPaint = paint;
        paint.setColor(this.f4760m);
        this.mLaserPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.mFinderMaskPaint = paint2;
        paint2.setColor(this.f4761n);
        Paint paint3 = new Paint();
        this.mBorderPaint = paint3;
        paint3.setColor(this.f4762o);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth((float) this.f4763p);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderLineLength = this.f4764q;
    }

    public void setLaserColor(int i) {
        this.mLaserPaint.setColor(i);
    }

    public void setMaskColor(int i) {
        this.mFinderMaskPaint.setColor(i);
    }

    public void setBorderColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public void setBorderStrokeWidth(int i) {
        this.mBorderPaint.setStrokeWidth((float) i);
    }

    public void setBorderLineLength(int i) {
        this.mBorderLineLength = i;
    }

    public void setLaserEnabled(boolean z) {
        this.f4765r = z;
    }

    public void setBorderCornerRounded(boolean z) {
        if (z) {
            this.mBorderPaint.setStrokeJoin(Paint.Join.ROUND);
        } else {
            this.mBorderPaint.setStrokeJoin(Paint.Join.BEVEL);
        }
    }

    public void setBorderAlpha(float f) {
        this.f4766s = f;
        this.mBorderPaint.setAlpha((int) (255.0f * f));
    }

    public void setBorderCornerRadius(int i) {
        this.mBorderPaint.setPathEffect(new CornerPathEffect((float) i));
    }

    public void setViewFinderOffset(int i) {
        this.f4767t = i;
    }

    public void setSquareViewFinder(boolean z) {
        this.mSquareViewFinder = z;
    }

    public void setupViewFinder() {
        updateFramingRect();
        invalidate();
    }

    public Rect getFramingRect() {
        return this.f4758b;
    }

    public void onDraw(Canvas canvas) {
        if (getFramingRect() != null) {
            drawViewFinderMask(canvas);
            drawViewFinderBorder(canvas);
            if (this.f4765r) {
                drawLaser(canvas);
            }
        }
    }

    public void drawViewFinderMask(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        float f = (float) width;
        canvas.drawRect(0.0f, 0.0f, f, (float) framingRect.top, this.mFinderMaskPaint);
        canvas.drawRect(0.0f, (float) framingRect.top, (float) framingRect.left, (float) (framingRect.bottom + 1), this.mFinderMaskPaint);
        Canvas canvas2 = canvas;
        float f2 = f;
        canvas2.drawRect((float) (framingRect.right + 1), (float) framingRect.top, f2, (float) (framingRect.bottom + 1), this.mFinderMaskPaint);
        canvas2.drawRect(0.0f, (float) (framingRect.bottom + 1), f2, (float) height, this.mFinderMaskPaint);
    }

    public void drawViewFinderBorder(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Path path = new Path();
        path.moveTo((float) framingRect.left, (float) (framingRect.top + this.mBorderLineLength));
        path.lineTo((float) framingRect.left, (float) framingRect.top);
        path.lineTo((float) (framingRect.left + this.mBorderLineLength), (float) framingRect.top);
        canvas.drawPath(path, this.mBorderPaint);
        path.moveTo((float) framingRect.right, (float) (framingRect.top + this.mBorderLineLength));
        path.lineTo((float) framingRect.right, (float) framingRect.top);
        path.lineTo((float) (framingRect.right - this.mBorderLineLength), (float) framingRect.top);
        canvas.drawPath(path, this.mBorderPaint);
        path.moveTo((float) framingRect.right, (float) (framingRect.bottom - this.mBorderLineLength));
        path.lineTo((float) framingRect.right, (float) framingRect.bottom);
        path.lineTo((float) (framingRect.right - this.mBorderLineLength), (float) framingRect.bottom);
        canvas.drawPath(path, this.mBorderPaint);
        path.moveTo((float) framingRect.left, (float) (framingRect.bottom - this.mBorderLineLength));
        path.lineTo((float) framingRect.left, (float) framingRect.bottom);
        path.lineTo((float) (framingRect.left + this.mBorderLineLength), (float) framingRect.bottom);
        canvas.drawPath(path, this.mBorderPaint);
    }

    public void drawLaser(Canvas canvas) {
        Rect framingRect = getFramingRect();
        this.mLaserPaint.setAlpha(f4755i[this.f4759j]);
        this.f4759j = (this.f4759j + 1) % f4755i.length;
        int height = (framingRect.height() / 2) + framingRect.top;
        canvas.drawRect((float) (framingRect.left + 2), (float) (height - 1), (float) (framingRect.right - 1), (float) (height + 2), this.mLaserPaint);
        postInvalidateDelayed(f4757l, framingRect.left - 10, framingRect.top - 10, framingRect.right + 10, framingRect.bottom + 10);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateFramingRect();
    }

    public synchronized void updateFramingRect() {
        int i;
        int i2;
        int i3;
        Point point = new Point(getWidth(), getHeight());
        int screenOrientation = DisplayUtils.getScreenOrientation(getContext());
        if (this.mSquareViewFinder) {
            if (screenOrientation != 1) {
                i3 = getHeight();
            } else {
                i3 = getWidth();
            }
            i2 = (int) (((float) i3) * 0.625f);
            i = i2;
        } else if (screenOrientation != 1) {
            int height = (int) (((float) getHeight()) * 0.625f);
            i = height;
            i2 = (int) (((float) height) * f4752f);
        } else {
            i2 = (int) (((float) getWidth()) * 0.75f);
            i = (int) (((float) i2) * 0.75f);
        }
        if (i2 > getWidth()) {
            i2 = getWidth() - 50;
        }
        if (i > getHeight()) {
            i = getHeight() - 50;
        }
        int i4 = (point.x - i2) / 2;
        int i5 = (point.y - i) / 2;
        this.f4758b = new Rect(this.f4767t + i4, this.f4767t + i5, (i4 + i2) - this.f4767t, (i5 + i) - this.f4767t);
    }
}
