package com.didi.soda.customer.widget.loading.render;

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
    public static final String K_BODY_IMAGE_RESOURCE_ID = "Loading::Gradient::Body::Image::ID";
    public static final String K_HEAD_IMAGE_RESOURCE_ID = "Loading::Gradient::Head::Image::ID";

    /* renamed from: b */
    private static final int f42097b = 0;

    /* renamed from: c */
    private static final int f42098c = 1;

    /* renamed from: d */
    private static final int f42099d = 2;

    /* renamed from: e */
    private int f42100e = 0;

    /* renamed from: f */
    private Bitmap f42101f;

    /* renamed from: g */
    private Bitmap f42102g;

    /* renamed from: h */
    private Rect f42103h;

    /* renamed from: i */
    private Rect f42104i;

    /* renamed from: j */
    private RectF f42105j;

    /* renamed from: k */
    private RectF f42106k;

    /* renamed from: l */
    private int f42107l;

    /* renamed from: m */
    private int f42108m;

    /* renamed from: n */
    private int f42109n;

    /* renamed from: o */
    private int f42110o;

    /* renamed from: p */
    private int f42111p;

    /* renamed from: q */
    private int f42112q;

    public void computeRender(float f) {
        int i = this.f42111p;
        int i2 = this.f42107l;
        float f2 = ((float) (i + i2)) * f;
        int i3 = this.f42100e;
        if (i3 == 1) {
            this.f42105j.offsetTo(((float) (-i2)) + f2, 0.0f);
            this.f42106k.offsetTo(((float) (-(this.f42111p + this.f42107l))) + f2, 0.0f);
        } else if (i3 == 2) {
            this.f42105j.offsetTo(((float) (-i2)) + f2, 0.0f);
        }
    }

    public void draw(Canvas canvas, Rect rect) {
        if (this.f42102g != null && this.f42101f != null) {
            canvas.save();
            canvas.drawBitmap(this.f42102g, this.f42104i, this.f42106k, (Paint) null);
            canvas.drawBitmap(this.f42101f, this.f42103h, this.f42105j, (Paint) null);
            canvas.restore();
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f42111p, this.f42112q);
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        m29696a(0);
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        m29696a(2);
    }

    public View onCreateView(Context context, Bundle bundle) {
        View onCreateView = super.onCreateView(context, bundle);
        this.f42101f = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head));
        this.f42102g = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body));
        Bitmap bitmap = this.f42101f;
        if (bitmap != null) {
            this.f42107l = bitmap.getWidth();
            this.f42108m = this.f42101f.getHeight();
            this.f42103h = new Rect(0, 0, this.f42107l, this.f42108m);
            this.f42105j = new RectF(this.f42103h);
            Bitmap bitmap2 = this.f42102g;
            if (bitmap2 != null) {
                this.f42109n = bitmap2.getWidth();
                this.f42110o = this.f42102g.getHeight();
                this.f42104i = new Rect(0, 0, this.f42109n, this.f42110o);
                this.f42106k = new RectF(this.f42104i);
            }
        }
        return onCreateView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        super.onLayoutView(view, viewGroup, viewGroup2);
        this.f42111p = view.getMeasuredWidth();
        this.f42112q = Math.max(this.f42110o, this.f42108m);
    }

    public void onStartLoading() {
        m29696a(1);
        super.onStartLoading();
    }

    public void onStopLoading() {
        m29696a(0);
        super.onStopLoading();
    }

    /* renamed from: a */
    private void m29696a(int i) {
        if (i == 0) {
            this.f42105j.left = (float) (-this.f42107l);
            this.f42105j.right = 0.0f;
            this.f42106k.left = (float) (-this.f42109n);
            this.f42106k.right = 0.0f;
        } else if (i == 1) {
            this.f42105j.left = (float) (-this.f42107l);
            this.f42105j.right = 0.0f;
            this.f42106k.left = (float) (-(this.f42111p + this.f42107l));
            this.f42106k.right = (float) (-this.f42107l);
        } else if (i == 2) {
            this.f42105j.left = (float) (-this.f42107l);
            this.f42105j.right = 0.0f;
            this.f42106k.left = 0.0f;
            this.f42106k.right = (float) this.f42111p;
        }
        this.f42105j.top = 0.0f;
        this.f42105j.bottom = (float) this.f42112q;
        this.f42106k.top = 0.0f;
        this.f42106k.bottom = (float) this.f42112q;
        this.f42100e = i;
    }
}
