package com.didi.beatles.p099im.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.didi.beatles.p099im.views.imageView.IMNetworkImageView;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.beatles.im.views.IMBezelImageView */
public class IMBezelImageView extends IMNetworkImageView {

    /* renamed from: a */
    private Paint f9846a;

    /* renamed from: b */
    private Paint f9847b;

    /* renamed from: c */
    private Rect f9848c;

    /* renamed from: d */
    private RectF f9849d;

    /* renamed from: e */
    private Drawable f9850e;

    /* renamed from: f */
    private Drawable f9851f;

    /* renamed from: g */
    private ColorMatrixColorFilter f9852g;

    /* renamed from: h */
    private boolean f9853h;

    /* renamed from: i */
    private boolean f9854i;

    /* renamed from: j */
    private Bitmap f9855j;

    /* renamed from: k */
    private int f9856k;

    /* renamed from: l */
    private int f9857l;

    public IMBezelImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBezelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9853h = false;
        this.f9854i = false;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(2, (Paint) null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.IMBezelImageView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        this.f9851f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        this.f9850e = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.f9853h = obtainStyledAttributes.getBoolean(1, this.f9853h);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f9846a = paint;
        paint.setColor(-16777216);
        Paint paint2 = new Paint();
        this.f9847b = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f9855j = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        if (this.f9853h) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            this.f9852g = new ColorMatrixColorFilter(colorMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void setMaskDrawable(Drawable drawable) {
        this.f9851f = drawable;
        drawable.setCallback(this);
    }

    /* access modifiers changed from: protected */
    public void setBorderDrawable(Drawable drawable) {
        this.f9850e = drawable;
        drawable.setCallback(this);
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.f9848c = new Rect(0, 0, i3 - i, i4 - i2);
        this.f9849d = new RectF(this.f9848c);
        Drawable drawable = this.f9850e;
        if (drawable != null) {
            drawable.setBounds(this.f9848c);
        }
        Drawable drawable2 = this.f9851f;
        if (drawable2 != null) {
            drawable2.setBounds(this.f9848c);
        }
        if (frame) {
            this.f9854i = false;
        }
        return frame;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect = this.f9848c;
        if (rect != null) {
            int width = rect.width();
            int height = this.f9848c.height();
            if (width != 0 && height != 0 && this.f9855j != null) {
                if (!(this.f9854i && width == this.f9856k && height == this.f9857l)) {
                    if (width == this.f9856k && height == this.f9857l) {
                        this.f9855j.eraseColor(0);
                    } else {
                        Bitmap bitmap = this.f9855j;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        try {
                            this.f9855j = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            this.f9856k = width;
                            this.f9857l = height;
                        } catch (OutOfMemoryError unused) {
                            return;
                        }
                    }
                    if (this.f9855j != null) {
                        Canvas canvas2 = new Canvas(this.f9855j);
                        if (this.f9851f != null) {
                            int save = canvas2.save();
                            this.f9851f.draw(canvas2);
                            this.f9847b.setColorFilter((!this.f9853h || !isPressed()) ? null : this.f9852g);
                            SystemUtils.saveLayer(canvas2, this.f9849d, this.f9847b, 31);
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(save);
                        } else if (!this.f9853h || !isPressed()) {
                            super.onDraw(canvas2);
                        } else {
                            int save2 = canvas2.save();
                            canvas2.drawRect(0.0f, 0.0f, (float) this.f9856k, (float) this.f9857l, this.f9846a);
                            this.f9847b.setColorFilter(this.f9852g);
                            SystemUtils.saveLayer(canvas2, this.f9849d, this.f9847b, 31);
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(save2);
                        }
                        Drawable drawable = this.f9850e;
                        if (drawable != null) {
                            drawable.draw(canvas2);
                        }
                    } else {
                        return;
                    }
                }
                canvas.drawBitmap(this.f9855j, (float) this.f9848c.left, (float) this.f9848c.top, (Paint) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f9850e;
        if (drawable != null && drawable.isStateful()) {
            this.f9850e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f9851f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f9851f.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f9850e || drawable == this.f9851f) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f9850e || drawable == this.f9851f || super.verifyDrawable(drawable);
    }
}
