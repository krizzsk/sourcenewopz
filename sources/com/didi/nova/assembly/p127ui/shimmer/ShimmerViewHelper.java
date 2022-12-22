package com.didi.nova.assembly.p127ui.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerViewHelper */
public class ShimmerViewHelper {

    /* renamed from: a */
    private static final int f29308a = -1;

    /* renamed from: b */
    private View f29309b;

    /* renamed from: c */
    private Paint f29310c;

    /* renamed from: d */
    private float f29311d;

    /* renamed from: e */
    private LinearGradient f29312e;

    /* renamed from: f */
    private Matrix f29313f;

    /* renamed from: g */
    private int f29314g;

    /* renamed from: h */
    private int f29315h;

    /* renamed from: i */
    private boolean f29316i;

    /* renamed from: j */
    private boolean f29317j;

    /* renamed from: k */
    private AnimationSetupCallback f29318k;

    /* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerViewHelper$AnimationSetupCallback */
    public interface AnimationSetupCallback {
        void onSetupAnimation(View view);
    }

    public ShimmerViewHelper(View view, Paint paint, AttributeSet attributeSet) {
        this.f29309b = view;
        this.f29310c = paint;
        m20666a(attributeSet);
    }

    public float getGradientX() {
        return this.f29311d;
    }

    public void setGradientX(float f) {
        this.f29311d = f;
        this.f29309b.invalidate();
    }

    public boolean isShimmering() {
        return this.f29316i;
    }

    public void setShimmering(boolean z) {
        this.f29316i = z;
    }

    public boolean isSetUp() {
        return this.f29317j;
    }

    public void setAnimationSetupCallback(AnimationSetupCallback animationSetupCallback) {
        this.f29318k = animationSetupCallback;
    }

    public int getPrimaryColor() {
        return this.f29314g;
    }

    public void setPrimaryColor(int i) {
        this.f29314g = i;
        if (this.f29317j) {
            m20665a();
        }
    }

    public int getReflectionColor() {
        return this.f29315h;
    }

    public void setReflectionColor(int i) {
        this.f29315h = i;
        if (this.f29317j) {
            m20665a();
        }
    }

    /* renamed from: a */
    private void m20666a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f29315h = -1;
        if (!(attributeSet == null || (obtainStyledAttributes = this.f29309b.getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.ShimmerView, 0, 0)) == null)) {
            try {
                this.f29315h = obtainStyledAttributes.getColor(0, -1);
            } catch (Exception e) {
                SystemUtils.log(6, "ShimmerTextView", "Error while creating the view:", e, "com.didi.nova.assembly.ui.shimmer.ShimmerViewHelper", 118);
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        this.f29313f = new Matrix();
    }

    /* renamed from: a */
    private void m20665a() {
        int i = this.f29314g;
        LinearGradient linearGradient = new LinearGradient((float) (-this.f29309b.getWidth()), 0.0f, 0.0f, 0.0f, new int[]{i, this.f29315h, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f29312e = linearGradient;
        this.f29310c.setShader(linearGradient);
    }

    public void onSizeChanged() {
        m20665a();
        if (!this.f29317j) {
            this.f29317j = true;
            AnimationSetupCallback animationSetupCallback = this.f29318k;
            if (animationSetupCallback != null) {
                animationSetupCallback.onSetupAnimation(this.f29309b);
            }
        }
    }

    public void onDraw() {
        if (this.f29316i) {
            if (this.f29310c.getShader() == null) {
                this.f29310c.setShader(this.f29312e);
            }
            this.f29313f.setTranslate(this.f29311d * 2.0f, 0.0f);
            this.f29312e.setLocalMatrix(this.f29313f);
            return;
        }
        this.f29310c.setShader((Shader) null);
    }
}
