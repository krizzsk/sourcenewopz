package jumio.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/* renamed from: jumio.core.n0 */
/* compiled from: ScaleableImageView */
public class C21370n0 extends View {

    /* renamed from: a */
    public int f59653a = 0;

    /* renamed from: b */
    public int f59654b = 0;

    /* renamed from: c */
    public BitmapShader f59655c;

    /* renamed from: d */
    public Paint f59656d;

    /* renamed from: e */
    public Matrix f59657e;

    /* renamed from: f */
    public RectF f59658f;

    /* renamed from: g */
    public float f59659g;

    public C21370n0(Context context) {
        super(context);
        mo175846a();
    }

    /* renamed from: a */
    public final void mo175846a() {
        Paint paint = new Paint();
        this.f59656d = paint;
        paint.setAntiAlias(true);
    }

    /* renamed from: b */
    public final void mo175848b() {
        this.f59657e = new Matrix();
        this.f59658f = new RectF(0.0f, 0.0f, (float) this.f59653a, (float) this.f59654b);
        this.f59657e.setRectToRect(this.f59658f, new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), Matrix.ScaleToFit.CENTER);
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f59657e);
        RectF rectF = this.f59658f;
        float f = this.f59659g;
        canvas.drawRoundRect(rectF, f, f, this.f59656d);
        canvas.restore();
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = false;
        boolean z2 = mode == Integer.MIN_VALUE || mode == 0;
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            z = true;
        }
        float f = ((float) this.f59653a) / ((float) this.f59654b);
        if (size != 0 && z && f != 1.0f) {
            size2 = (int) (((float) size) / f);
        } else if (!(!z2 || size2 == 0 || f == 1.0f)) {
            size = (int) (((float) size2) * f);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        mo175848b();
    }

    public void setImageBitmap(Bitmap bitmap) {
        mo175847a(bitmap, 0.0f);
    }

    /* renamed from: a */
    public void mo175847a(Bitmap bitmap, float f) {
        this.f59653a = bitmap.getWidth();
        this.f59654b = bitmap.getHeight();
        this.f59659g = f;
        mo175848b();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f59655c = bitmapShader;
        this.f59656d.setShader(bitmapShader);
        requestLayout();
        invalidate();
    }
}
