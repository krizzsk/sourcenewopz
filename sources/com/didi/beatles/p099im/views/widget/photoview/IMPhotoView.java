package com.didi.beatles.p099im.views.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

/* renamed from: com.didi.beatles.im.views.widget.photoview.IMPhotoView */
public class IMPhotoView extends ImageView {

    /* renamed from: a */
    private PhotoViewAttacher f10610a;

    /* renamed from: b */
    private ImageView.ScaleType f10611b;

    public IMPhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7223a();
    }

    public IMPhotoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m7223a();
    }

    /* renamed from: a */
    private void m7223a() {
        this.f10610a = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f10611b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f10611b = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        return this.f10610a;
    }

    public ImageView.ScaleType getScaleType() {
        return this.f10610a.getScaleType();
    }

    public Matrix getImageMatrix() {
        return this.f10610a.getImageMatrix();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10610a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10610a.setOnClickListener(onClickListener);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f10610a;
        if (photoViewAttacher == null) {
            this.f10611b = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f10610a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.f10610a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f10610a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f10610a.update();
        }
        return frame;
    }

    public void setRotationTo(float f) {
        this.f10610a.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.f10610a.setRotationBy(f);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.f10610a.isZoomEnabled();
    }

    public boolean isZoomable() {
        return this.f10610a.isZoomable();
    }

    public void setZoomable(boolean z) {
        this.f10610a.setZoomable(z);
    }

    public RectF getDisplayRect() {
        return this.f10610a.getDisplayRect();
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.f10610a.getDisplayMatrix(matrix);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f10610a.setDisplayMatrix(matrix);
    }

    public void getSuppMatrix(Matrix matrix) {
        this.f10610a.getSuppMatrix(matrix);
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.f10610a.setDisplayMatrix(matrix);
    }

    public float getMinimumScale() {
        return this.f10610a.getMinimumScale();
    }

    public float getMediumScale() {
        return this.f10610a.getMediumScale();
    }

    public float getMaximumScale() {
        return this.f10610a.getMaximumScale();
    }

    public float getScale() {
        return this.f10610a.getScale();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f10610a.setAllowParentInterceptOnEdge(z);
    }

    public void setMinimumScale(float f) {
        this.f10610a.setMinimumScale(f);
    }

    public void setMediumScale(float f) {
        this.f10610a.setMediumScale(f);
    }

    public void setMaximumScale(float f) {
        this.f10610a.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.f10610a.setScaleLevels(f, f2, f3);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f10610a.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f10610a.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f10610a.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f10610a.setOnViewTapListener(onViewTapListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f10610a.setOnViewDragListener(onViewDragListener);
    }

    public void setScale(float f) {
        this.f10610a.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.f10610a.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.f10610a.setScale(f, f2, f3, z);
    }

    public void setZoomTransitionDuration(int i) {
        this.f10610a.setZoomTransitionDuration(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f10610a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f10610a.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f10610a.setOnSingleFlingListener(onSingleFlingListener);
    }
}
