package com.didi.component.payentrance.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.passenger.C10448R;

public class DriverIconImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f14968a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f14969b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f14970c = 2;

    /* renamed from: d */
    private static final int f14971d = 0;

    /* renamed from: e */
    private static final int f14972e = -16777216;

    /* renamed from: f */
    private static final int f14973f = 0;

    /* renamed from: g */
    private static final boolean f14974g = false;

    /* renamed from: A */
    private boolean f14975A;

    /* renamed from: h */
    private final RectF f14976h;

    /* renamed from: i */
    private final RectF f14977i;

    /* renamed from: j */
    private final Matrix f14978j;

    /* renamed from: k */
    private final Paint f14979k;

    /* renamed from: l */
    private final Paint f14980l;

    /* renamed from: m */
    private final Paint f14981m;

    /* renamed from: n */
    private int f14982n;

    /* renamed from: o */
    private int f14983o;

    /* renamed from: p */
    private int f14984p;

    /* renamed from: q */
    private Bitmap f14985q;

    /* renamed from: r */
    private BitmapShader f14986r;

    /* renamed from: s */
    private int f14987s;

    /* renamed from: t */
    private int f14988t;

    /* renamed from: u */
    private float f14989u;

    /* renamed from: v */
    private float f14990v;

    /* renamed from: w */
    private ColorFilter f14991w;

    /* renamed from: x */
    private boolean f14992x;

    /* renamed from: y */
    private boolean f14993y;

    /* renamed from: z */
    private boolean f14994z;

    public DriverIconImageView(Context context) {
        super(context);
        this.f14976h = new RectF();
        this.f14977i = new RectF();
        this.f14978j = new Matrix();
        this.f14979k = new Paint();
        this.f14980l = new Paint();
        this.f14981m = new Paint();
        this.f14982n = -16777216;
        this.f14983o = 0;
        this.f14984p = 0;
        m10762a();
    }

    public DriverIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DriverIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14976h = new RectF();
        this.f14977i = new RectF();
        this.f14978j = new Matrix();
        this.f14979k = new Paint();
        this.f14980l = new Paint();
        this.f14981m = new Paint();
        this.f14982n = -16777216;
        this.f14983o = 0;
        this.f14984p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.DriverIconImageView, i, 0);
        this.f14983o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f14982n = obtainStyledAttributes.getColor(0, -16777216);
        this.f14994z = obtainStyledAttributes.getBoolean(1, false);
        this.f14984p = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        m10762a();
    }

    /* renamed from: a */
    private void m10762a() {
        super.setScaleType(f14968a);
        this.f14992x = true;
        if (this.f14993y) {
            m10765d();
            this.f14993y = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f14968a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f14968a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f14975A) {
            super.onDraw(canvas);
        } else if (this.f14985q != null) {
            if (this.f14984p != 0) {
                canvas.drawCircle(this.f14976h.centerX(), this.f14976h.centerY(), this.f14989u, this.f14981m);
            }
            canvas.drawCircle(this.f14976h.centerX(), this.f14976h.centerY(), this.f14989u, this.f14979k);
            if (this.f14983o > 0) {
                canvas.drawCircle(this.f14977i.centerX(), this.f14977i.centerY(), this.f14990v, this.f14980l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m10765d();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m10765d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m10765d();
    }

    public int getBorderColor() {
        return this.f14982n;
    }

    public void setBorderColor(int i) {
        if (i != this.f14982n) {
            this.f14982n = i;
            this.f14980l.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public int getFillColor() {
        return this.f14984p;
    }

    @Deprecated
    public void setFillColor(int i) {
        if (i != this.f14984p) {
            this.f14984p = i;
            this.f14981m.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f14983o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f14983o) {
            this.f14983o = i;
            m10765d();
        }
    }

    public boolean isBorderOverlay() {
        return this.f14994z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f14994z) {
            this.f14994z = z;
            m10765d();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.f14975A;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f14975A != z) {
            this.f14975A = z;
            m10764c();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m10764c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m10764c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m10764c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m10764c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f14991w) {
            this.f14991w = colorFilter;
            m10763b();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f14991w;
    }

    /* renamed from: b */
    private void m10763b() {
        Paint paint = this.f14979k;
        if (paint != null) {
            paint.setColorFilter(this.f14991w);
        }
    }

    /* renamed from: a */
    private Bitmap m10761a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f14969b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f14969b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private void m10764c() {
        if (this.f14975A) {
            this.f14985q = null;
        } else {
            this.f14985q = m10761a(getDrawable());
        }
        m10765d();
    }

    /* renamed from: d */
    private void m10765d() {
        int i;
        if (!this.f14992x) {
            this.f14993y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f14985q == null) {
                invalidate();
                return;
            }
            this.f14986r = new BitmapShader(this.f14985q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f14979k.setAntiAlias(true);
            this.f14979k.setShader(this.f14986r);
            this.f14980l.setStyle(Paint.Style.STROKE);
            this.f14980l.setAntiAlias(true);
            this.f14980l.setColor(this.f14982n);
            this.f14980l.setStrokeWidth((float) this.f14983o);
            this.f14981m.setStyle(Paint.Style.FILL);
            this.f14981m.setAntiAlias(true);
            this.f14981m.setColor(this.f14984p);
            this.f14988t = this.f14985q.getHeight();
            this.f14987s = this.f14985q.getWidth();
            this.f14977i.set(m10766e());
            this.f14990v = Math.min((this.f14977i.height() - ((float) this.f14983o)) / 2.0f, (this.f14977i.width() - ((float) this.f14983o)) / 2.0f);
            this.f14976h.set(this.f14977i);
            if (!this.f14994z && (i = this.f14983o) > 0) {
                this.f14976h.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
            }
            this.f14989u = Math.min(this.f14976h.height() / 2.0f, this.f14976h.width() / 2.0f);
            m10763b();
            m10767f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m10766e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m10767f() {
        float f;
        float f2;
        this.f14978j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f14987s) * this.f14976h.height() > this.f14976h.width() * ((float) this.f14988t)) {
            f2 = this.f14976h.height() / ((float) this.f14988t);
            f3 = (this.f14976h.width() - (((float) this.f14987s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f14976h.width() / ((float) this.f14987s);
            f = (this.f14976h.height() - (((float) this.f14988t) * f2)) * 0.5f;
        }
        this.f14978j.setScale(f2, f2);
        this.f14978j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f14976h.left, ((float) ((int) (f + 0.5f))) + this.f14976h.top);
        this.f14986r.setLocalMatrix(this.f14978j);
    }
}
