package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;

public class CircleImageView extends CustomerAppCompatImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f41416a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f41417b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f41418c = 2;

    /* renamed from: d */
    private static final int f41419d = 0;

    /* renamed from: e */
    private static final int f41420e = -16777216;

    /* renamed from: f */
    private static final int f41421f = 0;

    /* renamed from: g */
    private static final boolean f41422g = false;

    /* renamed from: A */
    private boolean f41423A;

    /* renamed from: h */
    private final RectF f41424h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final RectF f41425i;

    /* renamed from: j */
    private final Matrix f41426j;

    /* renamed from: k */
    private final Paint f41427k;

    /* renamed from: l */
    private final Paint f41428l;

    /* renamed from: m */
    private final Paint f41429m;

    /* renamed from: n */
    private int f41430n;

    /* renamed from: o */
    private int f41431o;

    /* renamed from: p */
    private int f41432p;

    /* renamed from: q */
    private Bitmap f41433q;

    /* renamed from: r */
    private BitmapShader f41434r;

    /* renamed from: s */
    private int f41435s;

    /* renamed from: t */
    private int f41436t;

    /* renamed from: u */
    private float f41437u;

    /* renamed from: v */
    private float f41438v;

    /* renamed from: w */
    private ColorFilter f41439w;

    /* renamed from: x */
    private boolean f41440x;

    /* renamed from: y */
    private boolean f41441y;

    /* renamed from: z */
    private boolean f41442z;

    public CircleImageView(Context context) {
        super(context);
        this.f41424h = new RectF();
        this.f41425i = new RectF();
        this.f41426j = new Matrix();
        this.f41427k = new Paint();
        this.f41428l = new Paint();
        this.f41429m = new Paint();
        this.f41430n = -16777216;
        this.f41431o = 0;
        this.f41432p = 0;
        m29326a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41424h = new RectF();
        this.f41425i = new RectF();
        this.f41426j = new Matrix();
        this.f41427k = new Paint();
        this.f41428l = new Paint();
        this.f41429m = new Paint();
        this.f41430n = -16777216;
        this.f41431o = 0;
        this.f41432p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CircleImageView, i, 0);
        this.f41431o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f41430n = obtainStyledAttributes.getColor(0, -16777216);
        this.f41442z = obtainStyledAttributes.getBoolean(1, false);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f41432p = obtainStyledAttributes.getColor(3, 0);
        }
        obtainStyledAttributes.recycle();
        m29326a();
    }

    public int getBorderColor() {
        return this.f41430n;
    }

    public void setBorderColor(int i) {
        if (i != this.f41430n) {
            this.f41430n = i;
            this.f41428l.setColor(i);
            invalidate();
        }
    }

    public int getBorderWidth() {
        return this.f41431o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f41431o) {
            this.f41431o = i;
            m29329d();
        }
    }

    public int getCircleBackgroundColor() {
        return this.f41432p;
    }

    public void setCircleBackgroundColor(int i) {
        if (i != this.f41432p) {
            this.f41432p = i;
            this.f41429m.setColor(i);
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f41439w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f41439w) {
            this.f41439w = colorFilter;
            m29327b();
            invalidate();
        }
    }

    @Deprecated
    public int getFillColor() {
        return getCircleBackgroundColor();
    }

    @Deprecated
    public void setFillColor(int i) {
        setCircleBackgroundColor(i);
    }

    public ImageView.ScaleType getScaleType() {
        return f41416a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f41416a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public boolean isBorderOverlay() {
        return this.f41442z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f41442z) {
            this.f41442z = z;
            m29329d();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.f41423A;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f41423A != z) {
            this.f41423A = z;
            m29328c();
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setCircleBackgroundColorResource(i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m29328c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m29328c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m29328c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m29328c();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m29329d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m29329d();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f41423A) {
            super.onDraw(canvas);
        } else if (this.f41433q != null) {
            if (this.f41432p != 0) {
                canvas.drawCircle(this.f41424h.centerX(), this.f41424h.centerY(), this.f41437u, this.f41429m);
            }
            canvas.drawCircle(this.f41424h.centerX(), this.f41424h.centerY(), this.f41437u, this.f41427k);
            if (this.f41431o > 0) {
                canvas.drawCircle(this.f41425i.centerX(), this.f41425i.centerY(), this.f41438v, this.f41428l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m29329d();
    }

    /* renamed from: a */
    private void m29326a() {
        super.setScaleType(f41416a);
        this.f41440x = true;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
        if (this.f41441y) {
            m29329d();
            this.f41441y = false;
        }
    }

    /* renamed from: b */
    private void m29327b() {
        Paint paint = this.f41427k;
        if (paint != null) {
            paint.setColorFilter(this.f41439w);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r1 = (android.graphics.drawable.TransitionDrawable) r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m29324a(android.graphics.drawable.Drawable r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof android.graphics.drawable.TransitionDrawable
            if (r1 == 0) goto L_0x001a
            r1 = r7
            android.graphics.drawable.TransitionDrawable r1 = (android.graphics.drawable.TransitionDrawable) r1
            int r2 = r1.getNumberOfLayers()
            if (r2 <= 0) goto L_0x001a
            int r2 = r2 + -1
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            if (r1 == 0) goto L_0x001a
            r7 = r1
        L_0x001a:
            boolean r1 = r7 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L_0x0026
            android.graphics.drawable.BitmapDrawable r7 = (android.graphics.drawable.BitmapDrawable) r7
            android.graphics.Bitmap r7 = r7.getBitmap()
            return r7
        L_0x0026:
            boolean r1 = r7 instanceof android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0032
            android.graphics.Bitmap$Config r1 = f41417b     // Catch:{ Exception -> 0x0055 }
            r2 = 2
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r2, r2, r1)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0040
        L_0x0032:
            int r1 = r7.getIntrinsicWidth()     // Catch:{ Exception -> 0x0055 }
            int r2 = r7.getIntrinsicHeight()     // Catch:{ Exception -> 0x0055 }
            android.graphics.Bitmap$Config r3 = f41417b     // Catch:{ Exception -> 0x0055 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3)     // Catch:{ Exception -> 0x0055 }
        L_0x0040:
            android.graphics.Canvas r2 = new android.graphics.Canvas     // Catch:{ Exception -> 0x0055 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0055 }
            int r3 = r2.getWidth()     // Catch:{ Exception -> 0x0055 }
            int r4 = r2.getHeight()     // Catch:{ Exception -> 0x0055 }
            r5 = 0
            r7.setBounds(r5, r5, r3, r4)     // Catch:{ Exception -> 0x0055 }
            r7.draw(r2)     // Catch:{ Exception -> 0x0055 }
            return r1
        L_0x0055:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.CircleImageView.m29324a(android.graphics.drawable.Drawable):android.graphics.Bitmap");
    }

    /* renamed from: c */
    private void m29328c() {
        if (this.f41423A) {
            this.f41433q = null;
        } else {
            this.f41433q = m29324a(getDrawable());
        }
        m29329d();
    }

    /* renamed from: d */
    private void m29329d() {
        int i;
        if (!this.f41440x) {
            this.f41441y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f41433q == null) {
                invalidate();
                return;
            }
            this.f41434r = new BitmapShader(this.f41433q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f41427k.setAntiAlias(true);
            this.f41427k.setShader(this.f41434r);
            this.f41428l.setStyle(Paint.Style.STROKE);
            this.f41428l.setAntiAlias(true);
            this.f41428l.setColor(this.f41430n);
            this.f41428l.setStrokeWidth((float) this.f41431o);
            this.f41429m.setStyle(Paint.Style.FILL);
            this.f41429m.setAntiAlias(true);
            this.f41429m.setColor(this.f41432p);
            this.f41436t = this.f41433q.getHeight();
            this.f41435s = this.f41433q.getWidth();
            this.f41425i.set(m29330e());
            this.f41438v = Math.min((this.f41425i.height() - ((float) this.f41431o)) / 2.0f, (this.f41425i.width() - ((float) this.f41431o)) / 2.0f);
            this.f41424h.set(this.f41425i);
            if (!this.f41442z && (i = this.f41431o) > 0) {
                this.f41424h.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
            }
            this.f41437u = Math.min(this.f41424h.height() / 2.0f, this.f41424h.width() / 2.0f);
            m29327b();
            m29331f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m29330e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m29331f() {
        float f;
        float f2;
        this.f41426j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f41435s) * this.f41424h.height() > this.f41424h.width() * ((float) this.f41436t)) {
            f2 = this.f41424h.height() / ((float) this.f41436t);
            f3 = (this.f41424h.width() - (((float) this.f41435s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f41424h.width() / ((float) this.f41435s);
            f = (this.f41424h.height() - (((float) this.f41436t) * f2)) * 0.5f;
        }
        this.f41426j.setScale(f2, f2);
        this.f41426j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f41424h.left, ((float) ((int) (f + 0.5f))) + this.f41424h.top);
        this.f41434r.setLocalMatrix(this.f41426j);
    }

    private class OutlineProvider extends ViewOutlineProvider {
        private OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f41425i.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }
}
