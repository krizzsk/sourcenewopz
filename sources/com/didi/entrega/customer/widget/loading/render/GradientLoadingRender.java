package com.didi.entrega.customer.widget.loading.render;

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
    private static final int f20561b = 0;

    /* renamed from: c */
    private static final int f20562c = 1;

    /* renamed from: d */
    private static final int f20563d = 2;

    /* renamed from: e */
    private int f20564e = 0;

    /* renamed from: f */
    private Bitmap f20565f;

    /* renamed from: g */
    private Bitmap f20566g;

    /* renamed from: h */
    private Rect f20567h;

    /* renamed from: i */
    private Rect f20568i;

    /* renamed from: j */
    private RectF f20569j;

    /* renamed from: k */
    private RectF f20570k;

    /* renamed from: l */
    private int f20571l;

    /* renamed from: m */
    private int f20572m;

    /* renamed from: n */
    private int f20573n;

    /* renamed from: o */
    private int f20574o;

    /* renamed from: p */
    private int f20575p;

    /* renamed from: q */
    private int f20576q;

    public void computeRender(float f) {
        int i = this.f20575p;
        int i2 = this.f20571l;
        float f2 = ((float) (i + i2)) * f;
        int i3 = this.f20564e;
        if (i3 == 1) {
            this.f20569j.offsetTo(((float) (-i2)) + f2, 0.0f);
            this.f20570k.offsetTo(((float) (-(this.f20575p + this.f20571l))) + f2, 0.0f);
        } else if (i3 == 2) {
            this.f20569j.offsetTo(((float) (-i2)) + f2, 0.0f);
        }
    }

    public void draw(Canvas canvas, Rect rect) {
        if (this.f20566g != null && this.f20565f != null) {
            canvas.save();
            canvas.drawBitmap(this.f20566g, this.f20568i, this.f20570k, (Paint) null);
            canvas.drawBitmap(this.f20565f, this.f20567h, this.f20569j, (Paint) null);
            canvas.restore();
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f20575p, this.f20576q);
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        m15050a(0);
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        m15050a(2);
    }

    public View onCreateView(Context context, Bundle bundle) {
        View onCreateView = super.onCreateView(context, bundle);
        this.f20565f = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head));
        this.f20566g = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body));
        Bitmap bitmap = this.f20565f;
        if (bitmap != null) {
            this.f20571l = bitmap.getWidth();
            this.f20572m = this.f20565f.getHeight();
            this.f20567h = new Rect(0, 0, this.f20571l, this.f20572m);
            this.f20569j = new RectF(this.f20567h);
            Bitmap bitmap2 = this.f20566g;
            if (bitmap2 != null) {
                this.f20573n = bitmap2.getWidth();
                this.f20574o = this.f20566g.getHeight();
                this.f20568i = new Rect(0, 0, this.f20573n, this.f20574o);
                this.f20570k = new RectF(this.f20568i);
            }
        }
        return onCreateView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        super.onLayoutView(view, viewGroup, viewGroup2);
        this.f20575p = view.getMeasuredWidth();
        this.f20576q = Math.max(this.f20574o, this.f20572m);
    }

    public void onStartLoading() {
        m15050a(1);
        super.onStartLoading();
    }

    public void onStopLoading() {
        m15050a(0);
        super.onStopLoading();
    }

    /* renamed from: a */
    private void m15050a(int i) {
        if (i == 0) {
            this.f20569j.left = (float) (-this.f20571l);
            this.f20569j.right = 0.0f;
            this.f20570k.left = (float) (-this.f20573n);
            this.f20570k.right = 0.0f;
        } else if (i == 1) {
            this.f20569j.left = (float) (-this.f20571l);
            this.f20569j.right = 0.0f;
            this.f20570k.left = (float) (-(this.f20575p + this.f20571l));
            this.f20570k.right = (float) (-this.f20571l);
        } else if (i == 2) {
            this.f20569j.left = (float) (-this.f20571l);
            this.f20569j.right = 0.0f;
            this.f20570k.left = 0.0f;
            this.f20570k.right = (float) this.f20575p;
        }
        this.f20569j.top = 0.0f;
        this.f20569j.bottom = (float) this.f20576q;
        this.f20570k.top = 0.0f;
        this.f20570k.bottom = (float) this.f20576q;
        this.f20564e = i;
    }
}
