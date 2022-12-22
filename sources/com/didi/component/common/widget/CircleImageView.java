package com.didi.component.common.widget;

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

public class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f11939a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f11940b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f11941c = 2;

    /* renamed from: d */
    private static final int f11942d = 0;

    /* renamed from: e */
    private static final int f11943e = -16777216;

    /* renamed from: f */
    private static final int f11944f = 0;

    /* renamed from: g */
    private static final boolean f11945g = false;

    /* renamed from: h */
    private final RectF f11946h = new RectF();

    /* renamed from: i */
    private final RectF f11947i = new RectF();

    /* renamed from: j */
    private final Matrix f11948j = new Matrix();

    /* renamed from: k */
    private final Paint f11949k = new Paint();

    /* renamed from: l */
    private final Paint f11950l = new Paint();

    /* renamed from: m */
    private final Paint f11951m = new Paint();

    /* renamed from: n */
    private int f11952n = -16777216;

    /* renamed from: o */
    private int f11953o = 0;

    /* renamed from: p */
    private int f11954p = 0;

    /* renamed from: q */
    private Bitmap f11955q;

    /* renamed from: r */
    private BitmapShader f11956r;

    /* renamed from: s */
    private int f11957s;

    /* renamed from: t */
    private int f11958t;

    /* renamed from: u */
    private float f11959u;

    /* renamed from: v */
    private float f11960v;

    /* renamed from: w */
    private ColorFilter f11961w;

    /* renamed from: x */
    private boolean f11962x;

    /* renamed from: y */
    private boolean f11963y;

    /* renamed from: z */
    private boolean f11964z;

    public CircleImageView(Context context) {
        super(context);
        m8062a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CircleImageView, 0, 0);
        this.f11953o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f11952n = obtainStyledAttributes.getColor(0, -16777216);
        this.f11964z = obtainStyledAttributes.getBoolean(1, false);
        this.f11954p = obtainStyledAttributes.getColor(4, 0);
        obtainStyledAttributes.recycle();
        m8062a();
    }

    /* renamed from: a */
    private void m8062a() {
        super.setScaleType(f11939a);
        this.f11962x = true;
        if (this.f11963y) {
            m8063b();
            this.f11963y = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f11939a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f11939a) {
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
        if (this.f11955q != null) {
            if (this.f11954p != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f11959u, this.f11951m);
            }
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f11959u, this.f11949k);
            if (this.f11953o != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f11960v, this.f11950l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m8063b();
    }

    public int getBorderColor() {
        return this.f11952n;
    }

    public void setBorderColor(int i) {
        if (i != this.f11952n) {
            this.f11952n = i;
            this.f11950l.setColor(i);
            invalidate();
        }
    }

    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public int getFillColor() {
        return this.f11954p;
    }

    public void setFillColor(int i) {
        if (i != this.f11954p) {
            this.f11954p = i;
            this.f11951m.setColor(i);
            invalidate();
        }
    }

    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f11953o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f11953o) {
            this.f11953o = i;
            m8063b();
        }
    }

    public boolean isBorderOverlay() {
        return this.f11964z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f11964z) {
            this.f11964z = z;
            m8063b();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f11955q = bitmap;
        m8063b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f11955q = m8061a(drawable);
        m8063b();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f11955q = m8061a(getDrawable());
        m8063b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f11955q = uri != null ? m8061a(getDrawable()) : null;
        m8063b();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f11961w) {
            this.f11961w = colorFilter;
            this.f11949k.setColorFilter(colorFilter);
            invalidate();
        }
    }

    /* renamed from: a */
    private Bitmap m8061a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f11940b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f11940b);
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

    /* renamed from: b */
    private void m8063b() {
        if (!this.f11962x) {
            this.f11963y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f11955q == null) {
                invalidate();
                return;
            }
            this.f11956r = new BitmapShader(this.f11955q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f11949k.setAntiAlias(true);
            this.f11949k.setShader(this.f11956r);
            this.f11950l.setStyle(Paint.Style.STROKE);
            this.f11950l.setAntiAlias(true);
            this.f11950l.setColor(this.f11952n);
            this.f11950l.setStrokeWidth((float) this.f11953o);
            this.f11951m.setStyle(Paint.Style.FILL);
            this.f11951m.setAntiAlias(true);
            this.f11951m.setColor(this.f11954p);
            this.f11958t = this.f11955q.getHeight();
            this.f11957s = this.f11955q.getWidth();
            this.f11947i.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f11960v = Math.min((this.f11947i.height() - ((float) this.f11953o)) / 2.0f, (this.f11947i.width() - ((float) this.f11953o)) / 2.0f);
            this.f11946h.set(this.f11947i);
            if (!this.f11964z) {
                RectF rectF = this.f11946h;
                int i = this.f11953o;
                rectF.inset((float) i, (float) i);
            }
            this.f11959u = Math.min(this.f11946h.height() / 2.0f, this.f11946h.width() / 2.0f);
            m8064c();
            invalidate();
        }
    }

    /* renamed from: c */
    private void m8064c() {
        float f;
        float f2;
        this.f11948j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f11957s) * this.f11946h.height() > this.f11946h.width() * ((float) this.f11958t)) {
            f2 = this.f11946h.height() / ((float) this.f11958t);
            f3 = (this.f11946h.width() - (((float) this.f11957s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f11946h.width() / ((float) this.f11957s);
            f = (this.f11946h.height() - (((float) this.f11958t) * f2)) * 0.5f;
        }
        this.f11948j.setScale(f2, f2);
        this.f11948j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f11946h.left, ((float) ((int) (f + 0.5f))) + this.f11946h.top);
        this.f11956r.setLocalMatrix(this.f11948j);
    }
}
