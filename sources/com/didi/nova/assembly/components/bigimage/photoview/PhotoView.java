package com.didi.nova.assembly.components.bigimage.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

public class PhotoView extends ImageView {

    /* renamed from: a */
    private PhotoViewAttacher f29097a;

    /* renamed from: b */
    private ImageView.ScaleType f29098b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20513a();
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20513a();
    }

    /* renamed from: a */
    private void m20513a() {
        this.f29097a = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f29098b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f29098b = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        return this.f29097a;
    }

    public ImageView.ScaleType getScaleType() {
        return this.f29097a.getScaleType();
    }

    public Matrix getImageMatrix() {
        return this.f29097a.getImageMatrix();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f29097a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f29097a.setOnClickListener(onClickListener);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f29097a;
        if (photoViewAttacher == null) {
            this.f29098b = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f29097a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.f29097a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f29097a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f29097a.update();
        }
        return frame;
    }

    public void setRotationTo(float f) {
        this.f29097a.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.f29097a.setRotationBy(f);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.f29097a.isZoomEnabled();
    }

    public boolean isZoomable() {
        return this.f29097a.isZoomable();
    }

    public void setZoomable(boolean z) {
        this.f29097a.setZoomable(z);
    }

    public RectF getDisplayRect() {
        return this.f29097a.getDisplayRect();
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.f29097a.getDisplayMatrix(matrix);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f29097a.setDisplayMatrix(matrix);
    }

    public void getSuppMatrix(Matrix matrix) {
        this.f29097a.getSuppMatrix(matrix);
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.f29097a.setDisplayMatrix(matrix);
    }

    public float getMinimumScale() {
        return this.f29097a.getMinimumScale();
    }

    public float getMediumScale() {
        return this.f29097a.getMediumScale();
    }

    public float getMaximumScale() {
        return this.f29097a.getMaximumScale();
    }

    public float getScale() {
        return this.f29097a.getScale();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f29097a.setAllowParentInterceptOnEdge(z);
    }

    public void setMinimumScale(float f) {
        this.f29097a.setMinimumScale(f);
    }

    public void setMediumScale(float f) {
        this.f29097a.setMediumScale(f);
    }

    public void setMaximumScale(float f) {
        this.f29097a.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.f29097a.setScaleLevels(f, f2, f3);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f29097a.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f29097a.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f29097a.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f29097a.setOnViewTapListener(onViewTapListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f29097a.setOnViewDragListener(onViewDragListener);
    }

    public void setScale(float f) {
        this.f29097a.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.f29097a.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.f29097a.setScale(f, f2, f3, z);
    }

    public void setZoomTransitionDuration(int i) {
        this.f29097a.setZoomTransitionDuration(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f29097a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f29097a.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f29097a.setOnSingleFlingListener(onSingleFlingListener);
    }
}
