package com.didi.entrega.customer.widget;

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
import com.didi.entrega.customer.widget.support.CustomerAppCompatImageView;
import com.didi.passenger.C10448R;

public class CircleImageView extends CustomerAppCompatImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f20250a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f20251b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f20252c = 2;

    /* renamed from: d */
    private static final int f20253d = 0;

    /* renamed from: e */
    private static final int f20254e = -16777216;

    /* renamed from: f */
    private static final int f20255f = 0;

    /* renamed from: g */
    private static final boolean f20256g = false;

    /* renamed from: A */
    private boolean f20257A;

    /* renamed from: h */
    private final RectF f20258h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final RectF f20259i;

    /* renamed from: j */
    private final Matrix f20260j;

    /* renamed from: k */
    private final Paint f20261k;

    /* renamed from: l */
    private final Paint f20262l;

    /* renamed from: m */
    private final Paint f20263m;

    /* renamed from: n */
    private int f20264n;

    /* renamed from: o */
    private int f20265o;

    /* renamed from: p */
    private int f20266p;

    /* renamed from: q */
    private Bitmap f20267q;

    /* renamed from: r */
    private BitmapShader f20268r;

    /* renamed from: s */
    private int f20269s;

    /* renamed from: t */
    private int f20270t;

    /* renamed from: u */
    private float f20271u;

    /* renamed from: v */
    private float f20272v;

    /* renamed from: w */
    private ColorFilter f20273w;

    /* renamed from: x */
    private boolean f20274x;

    /* renamed from: y */
    private boolean f20275y;

    /* renamed from: z */
    private boolean f20276z;

    public CircleImageView(Context context) {
        super(context);
        this.f20258h = new RectF();
        this.f20259i = new RectF();
        this.f20260j = new Matrix();
        this.f20261k = new Paint();
        this.f20262l = new Paint();
        this.f20263m = new Paint();
        this.f20264n = -16777216;
        this.f20265o = 0;
        this.f20266p = 0;
        m14887a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20258h = new RectF();
        this.f20259i = new RectF();
        this.f20260j = new Matrix();
        this.f20261k = new Paint();
        this.f20262l = new Paint();
        this.f20263m = new Paint();
        this.f20264n = -16777216;
        this.f20265o = 0;
        this.f20266p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaCircleImageView, i, 0);
        this.f20265o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f20264n = obtainStyledAttributes.getColor(0, -16777216);
        this.f20276z = obtainStyledAttributes.getBoolean(1, false);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f20266p = obtainStyledAttributes.getColor(3, 0);
        }
        obtainStyledAttributes.recycle();
        m14887a();
    }

    public int getBorderColor() {
        return this.f20264n;
    }

    public void setBorderColor(int i) {
        if (i != this.f20264n) {
            this.f20264n = i;
            this.f20262l.setColor(i);
            invalidate();
        }
    }

    public int getBorderWidth() {
        return this.f20265o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f20265o) {
            this.f20265o = i;
            m14890d();
        }
    }

    public int getCircleBackgroundColor() {
        return this.f20266p;
    }

    public void setCircleBackgroundColor(int i) {
        if (i != this.f20266p) {
            this.f20266p = i;
            this.f20263m.setColor(i);
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f20273w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f20273w) {
            this.f20273w = colorFilter;
            m14888b();
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
        return f20250a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f20250a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public boolean isBorderOverlay() {
        return this.f20276z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f20276z) {
            this.f20276z = z;
            m14890d();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.f20257A;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f20257A != z) {
            this.f20257A = z;
            m14889c();
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
        m14889c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m14889c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m14889c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m14889c();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m14890d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m14890d();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f20257A) {
            super.onDraw(canvas);
        } else if (this.f20267q != null) {
            if (this.f20266p != 0) {
                canvas.drawCircle(this.f20258h.centerX(), this.f20258h.centerY(), this.f20271u, this.f20263m);
            }
            canvas.drawCircle(this.f20258h.centerX(), this.f20258h.centerY(), this.f20271u, this.f20261k);
            if (this.f20265o > 0) {
                canvas.drawCircle(this.f20259i.centerX(), this.f20259i.centerY(), this.f20272v, this.f20262l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m14890d();
    }

    /* renamed from: a */
    private void m14887a() {
        super.setScaleType(f20250a);
        this.f20274x = true;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
        if (this.f20275y) {
            m14890d();
            this.f20275y = false;
        }
    }

    /* renamed from: b */
    private void m14888b() {
        Paint paint = this.f20261k;
        if (paint != null) {
            paint.setColorFilter(this.f20273w);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r1 = (android.graphics.drawable.TransitionDrawable) r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m14885a(android.graphics.drawable.Drawable r7) {
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
            android.graphics.Bitmap$Config r1 = f20251b     // Catch:{ Exception -> 0x0055 }
            r2 = 2
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r2, r2, r1)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0040
        L_0x0032:
            int r1 = r7.getIntrinsicWidth()     // Catch:{ Exception -> 0x0055 }
            int r2 = r7.getIntrinsicHeight()     // Catch:{ Exception -> 0x0055 }
            android.graphics.Bitmap$Config r3 = f20251b     // Catch:{ Exception -> 0x0055 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.widget.CircleImageView.m14885a(android.graphics.drawable.Drawable):android.graphics.Bitmap");
    }

    /* renamed from: c */
    private void m14889c() {
        if (this.f20257A) {
            this.f20267q = null;
        } else {
            this.f20267q = m14885a(getDrawable());
        }
        m14890d();
    }

    /* renamed from: d */
    private void m14890d() {
        int i;
        if (!this.f20274x) {
            this.f20275y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f20267q == null) {
                invalidate();
                return;
            }
            this.f20268r = new BitmapShader(this.f20267q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f20261k.setAntiAlias(true);
            this.f20261k.setShader(this.f20268r);
            this.f20262l.setStyle(Paint.Style.STROKE);
            this.f20262l.setAntiAlias(true);
            this.f20262l.setColor(this.f20264n);
            this.f20262l.setStrokeWidth((float) this.f20265o);
            this.f20263m.setStyle(Paint.Style.FILL);
            this.f20263m.setAntiAlias(true);
            this.f20263m.setColor(this.f20266p);
            this.f20270t = this.f20267q.getHeight();
            this.f20269s = this.f20267q.getWidth();
            this.f20259i.set(m14891e());
            this.f20272v = Math.min((this.f20259i.height() - ((float) this.f20265o)) / 2.0f, (this.f20259i.width() - ((float) this.f20265o)) / 2.0f);
            this.f20258h.set(this.f20259i);
            if (!this.f20276z && (i = this.f20265o) > 0) {
                this.f20258h.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
            }
            this.f20271u = Math.min(this.f20258h.height() / 2.0f, this.f20258h.width() / 2.0f);
            m14888b();
            m14892f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m14891e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m14892f() {
        float f;
        float f2;
        this.f20260j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f20269s) * this.f20258h.height() > this.f20258h.width() * ((float) this.f20270t)) {
            f2 = this.f20258h.height() / ((float) this.f20270t);
            f3 = (this.f20258h.width() - (((float) this.f20269s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f20258h.width() / ((float) this.f20269s);
            f = (this.f20258h.height() - (((float) this.f20270t) * f2)) * 0.5f;
        }
        this.f20260j.setScale(f2, f2);
        this.f20260j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f20258h.left, ((float) ((int) (f + 0.5f))) + this.f20258h.top);
        this.f20268r.setLocalMatrix(this.f20260j);
    }

    private class OutlineProvider extends ViewOutlineProvider {
        private OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f20259i.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }
}
