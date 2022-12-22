package com.didi.global.loading.render;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.taxis99.R;

public class GradientLoadingRender extends AnimationLoadingRender {

    /* renamed from: b */
    private static final int f22660b = 0;

    /* renamed from: c */
    private static final int f22661c = 1;

    /* renamed from: d */
    private static final int f22662d = 2;
    public static final String kBodyImageResourceId = "Loading::Gradient::Body::Image::ID";
    public static final String kHeadImageResourceId = "Loading::Gradient::Head::Image::ID";

    /* renamed from: e */
    private int f22663e = 0;

    /* renamed from: f */
    private Bitmap f22664f;

    /* renamed from: g */
    private Bitmap f22665g;

    /* renamed from: h */
    private Rect f22666h;

    /* renamed from: i */
    private Rect f22667i;

    /* renamed from: j */
    private RectF f22668j;

    /* renamed from: k */
    private RectF f22669k;

    /* renamed from: l */
    private int f22670l;

    /* renamed from: m */
    private int f22671m;

    /* renamed from: n */
    private int f22672n;

    /* renamed from: o */
    private int f22673o;

    /* renamed from: p */
    private int f22674p;

    /* renamed from: q */
    private int f22675q;

    public View onCreateView(Context context, Bundle bundle) {
        View onCreateView = super.onCreateView(context, bundle);
        this.f22664f = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head));
        this.f22665g = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body));
        Bitmap bitmap = this.f22664f;
        if (bitmap != null) {
            this.f22670l = bitmap.getWidth();
            this.f22671m = this.f22664f.getHeight();
            this.f22666h = new Rect(0, 0, this.f22670l, this.f22671m);
            this.f22668j = new RectF(this.f22666h);
            Bitmap bitmap2 = this.f22665g;
            if (bitmap2 != null) {
                this.f22672n = bitmap2.getWidth();
                this.f22673o = this.f22665g.getHeight();
                this.f22667i = new Rect(0, 0, this.f22672n, this.f22673o);
                this.f22669k = new RectF(this.f22667i);
            }
        }
        return onCreateView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.f22674p = view.getMeasuredWidth();
        this.f22675q = Math.max(this.f22673o, this.f22671m);
        super.onLayoutView(view, viewGroup, viewGroup2);
    }

    public void computeRender(float f) {
        int i = this.f22674p;
        int i2 = this.f22670l;
        float f2 = ((float) (i + i2)) * f;
        int i3 = this.f22663e;
        if (i3 == 1) {
            this.f22668j.offsetTo(((float) (-i2)) + f2, 0.0f);
            this.f22669k.offsetTo(((float) (-(this.f22674p + this.f22670l))) + f2, 0.0f);
        } else if (i3 == 2) {
            this.f22668j.offsetTo(((float) (-i2)) + f2, 0.0f);
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f22674p, this.f22675q);
    }

    public void draw(Canvas canvas, Rect rect) {
        if (this.f22665g != null && this.f22664f != null) {
            canvas.save();
            canvas.drawBitmap(this.f22665g, this.f22667i, this.f22669k, (Paint) null);
            canvas.drawBitmap(this.f22664f, this.f22666h, this.f22668j, (Paint) null);
            canvas.restore();
        }
    }

    public void onStartLoading() {
        m16327a(1);
        super.onStartLoading();
    }

    public void onStopLoading() {
        m16327a(0);
        super.onStopLoading();
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        m16327a(2);
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        m16327a(0);
    }

    /* renamed from: a */
    private void m16327a(int i) {
        if (i == 0) {
            this.f22668j.left = (float) (-this.f22670l);
            this.f22668j.right = 0.0f;
            this.f22669k.left = (float) (-this.f22672n);
            this.f22669k.right = 0.0f;
        } else if (i == 1) {
            this.f22668j.left = (float) (-this.f22670l);
            this.f22668j.right = 0.0f;
            this.f22669k.left = (float) (-(this.f22674p + this.f22670l));
            this.f22669k.right = (float) (-this.f22670l);
        } else if (i == 2) {
            this.f22668j.left = (float) (-this.f22670l);
            this.f22668j.right = 0.0f;
            this.f22669k.left = 0.0f;
            this.f22669k.right = (float) this.f22674p;
        }
        this.f22668j.top = 0.0f;
        this.f22668j.bottom = (float) this.f22675q;
        this.f22669k.top = 0.0f;
        this.f22669k.bottom = (float) this.f22675q;
        this.f22663e = i;
    }
}
