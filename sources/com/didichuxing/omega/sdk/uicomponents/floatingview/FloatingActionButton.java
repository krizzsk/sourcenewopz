package com.didichuxing.omega.sdk.uicomponents.floatingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.taxis99.R;

public class FloatingActionButton extends ImageButton {
    private static final int BAR_MAX_LENGTH = 270;
    private static final double BAR_SPIN_CYCLE_TIME = 500.0d;
    private static final long PAUSE_GROWING_TIME = 200;
    /* access modifiers changed from: private */
    public static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private boolean mAnimateProgress;
    private Drawable mBackgroundDrawable;
    private Paint mBackgroundPaint;
    private float mBarExtraLength;
    private boolean mBarGrowingFromFront;
    private int mBarLength;
    private boolean mButtonPositionSaved;
    private View.OnClickListener mClickListener;
    private int mColorDisabled;
    /* access modifiers changed from: private */
    public int mColorNormal;
    private int mColorPressed;
    private int mColorRipple;
    private Context mContext;
    private float mCurrentProgress;
    int mFabSize;
    private Drawable mIcon;
    private int mIconSize;
    private long mLastTimeAnimated;
    private float mOriginalX;
    private float mOriginalY;
    private long mPausedTimeWithoutGrowing;
    private int mProgress;
    private int mProgressBackgroundColor;
    /* access modifiers changed from: private */
    public boolean mProgressBarEnabled;
    private RectF mProgressCircleBounds;
    private int mProgressColor;
    private boolean mProgressIndeterminate;
    private int mProgressMax;
    private Paint mProgressPaint;
    /* access modifiers changed from: private */
    public int mProgressWidth;
    int mShadowColor;
    int mShadowRadius;
    int mShadowXOffset;
    int mShadowYOffset;
    private boolean mShouldProgressIndeterminate;
    private boolean mShouldSetProgress;
    private boolean mShouldUpdateButtonPosition;
    /* access modifiers changed from: private */
    public boolean mShowProgressBackground;
    boolean mShowShadow;
    private float mSpinSpeed;
    private float mTargetProgress;
    private double mTimeStartGrowing;
    private boolean mUsingElevation;
    private boolean mUsingElevationCompat;

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShadowRadius = C16159Util.dpToPx(getContext(), 4.0f);
        this.mShadowXOffset = C16159Util.dpToPx(getContext(), 1.0f);
        this.mShadowYOffset = C16159Util.dpToPx(getContext(), 3.0f);
        this.mIconSize = C16159Util.dpToPx(getContext(), 24.0f);
        this.mProgressWidth = C16159Util.dpToPx(getContext(), 6.0f);
        this.mOriginalX = -1.0f;
        this.mOriginalY = -1.0f;
        this.mProgressCircleBounds = new RectF();
        this.mBackgroundPaint = new Paint(1);
        this.mProgressPaint = new Paint(1);
        this.mSpinSpeed = 195.0f;
        this.mPausedTimeWithoutGrowing = 0;
        this.mBarGrowingFromFront = true;
        this.mBarLength = 16;
        this.mProgressMax = 100;
        init(context);
    }

    private void init(Context context) {
        setClickable(true);
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public int getCircleSize() {
        return C16159Util.dpToPx(getContext(), 46.0f);
    }

    /* access modifiers changed from: private */
    public int calculateMeasuredWidth() {
        int circleSize = getCircleSize() + calculateShadowWidth();
        return this.mProgressBarEnabled ? circleSize + (this.mProgressWidth * 2) : circleSize;
    }

    /* access modifiers changed from: private */
    public int calculateMeasuredHeight() {
        int circleSize = getCircleSize() + calculateShadowHeight();
        return this.mProgressBarEnabled ? circleSize + (this.mProgressWidth * 2) : circleSize;
    }

    /* access modifiers changed from: package-private */
    public int calculateShadowWidth() {
        if (hasShadow()) {
            return getShadowX() * 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int calculateShadowHeight() {
        if (hasShadow()) {
            return getShadowY() * 2;
        }
        return 0;
    }

    private int getShadowX() {
        return this.mShadowRadius + Math.abs(this.mShadowXOffset);
    }

    private int getShadowY() {
        return this.mShadowRadius + Math.abs(this.mShadowYOffset);
    }

    /* access modifiers changed from: private */
    public float calculateCenterX() {
        return (float) (getMeasuredWidth() / 2);
    }

    /* access modifiers changed from: private */
    public float calculateCenterY() {
        return (float) (getMeasuredHeight() / 2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.mProgressBarEnabled) {
            if (this.mShowProgressBackground) {
                canvas.drawArc(this.mProgressCircleBounds, 360.0f, 360.0f, false, this.mBackgroundPaint);
            }
            boolean z = false;
            boolean z2 = true;
            if (this.mProgressIndeterminate) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.mLastTimeAnimated;
                updateProgressLength(uptimeMillis);
                float f3 = this.mCurrentProgress + ((((float) uptimeMillis) * this.mSpinSpeed) / 1000.0f);
                this.mCurrentProgress = f3;
                if (f3 > 360.0f) {
                    this.mCurrentProgress = f3 - 360.0f;
                }
                this.mLastTimeAnimated = SystemClock.uptimeMillis();
                float f4 = this.mCurrentProgress - 90.0f;
                float f5 = ((float) this.mBarLength) + this.mBarExtraLength;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                } else {
                    f2 = f4;
                    f = f5;
                }
                canvas.drawArc(this.mProgressCircleBounds, f2, f, false, this.mProgressPaint);
            } else {
                if (this.mCurrentProgress != this.mTargetProgress) {
                    float uptimeMillis2 = (((float) (SystemClock.uptimeMillis() - this.mLastTimeAnimated)) / 1000.0f) * this.mSpinSpeed;
                    float f6 = this.mCurrentProgress;
                    float f7 = this.mTargetProgress;
                    if (f6 > f7) {
                        this.mCurrentProgress = Math.max(f6 - uptimeMillis2, f7);
                    } else {
                        this.mCurrentProgress = Math.min(f6 + uptimeMillis2, f7);
                    }
                    this.mLastTimeAnimated = SystemClock.uptimeMillis();
                    z = true;
                }
                canvas.drawArc(this.mProgressCircleBounds, -90.0f, this.mCurrentProgress, false, this.mProgressPaint);
                z2 = z;
            }
            if (z2) {
                invalidate();
            }
        }
    }

    private void updateProgressLength(long j) {
        long j2 = this.mPausedTimeWithoutGrowing;
        if (j2 >= 200) {
            double d = this.mTimeStartGrowing + ((double) j);
            this.mTimeStartGrowing = d;
            if (d > BAR_SPIN_CYCLE_TIME) {
                this.mTimeStartGrowing = d - BAR_SPIN_CYCLE_TIME;
                this.mPausedTimeWithoutGrowing = 0;
                this.mBarGrowingFromFront = !this.mBarGrowingFromFront;
            }
            float cos = (((float) Math.cos(((this.mTimeStartGrowing / BAR_SPIN_CYCLE_TIME) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            float f = (float) (270 - this.mBarLength);
            if (this.mBarGrowingFromFront) {
                this.mBarExtraLength = cos * f;
                return;
            }
            float f2 = f * (1.0f - cos);
            this.mCurrentProgress += this.mBarExtraLength - f2;
            this.mBarExtraLength = f2;
            return;
        }
        this.mPausedTimeWithoutGrowing = j2 + j;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        saveButtonOriginalPosition();
        if (this.mShouldProgressIndeterminate) {
            setIndeterminate(true);
            this.mShouldProgressIndeterminate = false;
        } else if (this.mShouldSetProgress) {
            setProgress(this.mProgress, this.mAnimateProgress);
            this.mShouldSetProgress = false;
        } else if (this.mShouldUpdateButtonPosition) {
            updateButtonPosition();
            this.mShouldUpdateButtonPosition = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        setupProgressBounds();
        setupProgressBarPaints();
        updateBackground();
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.mUsingElevationCompat) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin += getShadowX();
            marginLayoutParams.topMargin += getShadowY();
            marginLayoutParams.rightMargin += getShadowX();
            marginLayoutParams.bottomMargin += getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void updateBackground() {
        LayerDrawable layerDrawable;
        int i = 0;
        if (hasShadow()) {
            layerDrawable = new LayerDrawable(new Drawable[]{new Shadow(), createFillDrawable(), getIconDrawable()});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{createFillDrawable(), getIconDrawable()});
        }
        int i2 = -1;
        if (getIconDrawable() != null) {
            i2 = Math.max(getIconDrawable().getIntrinsicWidth(), getIconDrawable().getIntrinsicHeight());
        }
        int circleSize = getCircleSize();
        if (i2 <= 0) {
            i2 = this.mIconSize;
        }
        int i3 = (circleSize - i2) / 2;
        int abs = hasShadow() ? this.mShadowRadius + Math.abs(this.mShadowXOffset) : 0;
        if (hasShadow()) {
            i = this.mShadowRadius + Math.abs(this.mShadowYOffset);
        }
        if (this.mProgressBarEnabled) {
            int i4 = this.mProgressWidth;
            abs += i4;
            i += i4;
        }
        int i5 = abs + i3;
        int i6 = i + i3;
        layerDrawable.setLayerInset(hasShadow() ? 2 : 1, i5, i6, i5, i6);
        setBackgroundCompat(layerDrawable);
    }

    /* access modifiers changed from: protected */
    public Drawable getIconDrawable() {
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            return drawable;
        }
        return new ColorDrawable(0);
    }

    private Drawable createFillDrawable() {
        return this.mContext.getResources().getDrawable(R.drawable.omega_floatingview_touch);
    }

    private void setBackgroundCompat(Drawable drawable) {
        if (C16159Util.hasJellyBean()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void saveButtonOriginalPosition() {
        if (!this.mButtonPositionSaved) {
            if (this.mOriginalX == -1.0f) {
                this.mOriginalX = getX();
            }
            if (this.mOriginalY == -1.0f) {
                this.mOriginalY = getY();
            }
            this.mButtonPositionSaved = true;
        }
    }

    private void updateButtonPosition() {
        float f;
        float f2;
        if (this.mProgressBarEnabled) {
            f2 = this.mOriginalX > getX() ? getX() + ((float) this.mProgressWidth) : getX() - ((float) this.mProgressWidth);
            f = this.mOriginalY > getY() ? getY() + ((float) this.mProgressWidth) : getY() - ((float) this.mProgressWidth);
        } else {
            f2 = this.mOriginalX;
            f = this.mOriginalY;
        }
        setX(f2);
        setY(f);
    }

    private void setupProgressBarPaints() {
        this.mBackgroundPaint.setColor(this.mProgressBackgroundColor);
        this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
        this.mBackgroundPaint.setStrokeWidth((float) this.mProgressWidth);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth((float) this.mProgressWidth);
    }

    private void setupProgressBounds() {
        int i = 0;
        int shadowX = hasShadow() ? getShadowX() : 0;
        if (hasShadow()) {
            i = getShadowY();
        }
        int i2 = this.mProgressWidth;
        this.mProgressCircleBounds = new RectF((float) ((i2 / 2) + shadowX), (float) ((i2 / 2) + i), (float) ((calculateMeasuredWidth() - shadowX) - (this.mProgressWidth / 2)), (float) ((calculateMeasuredHeight() - i) - (this.mProgressWidth / 2)));
    }

    public Parcelable onSaveInstanceState() {
        ProgressSavedState progressSavedState = new ProgressSavedState(super.onSaveInstanceState());
        progressSavedState.mCurrentProgress = this.mCurrentProgress;
        progressSavedState.mTargetProgress = this.mTargetProgress;
        progressSavedState.mSpinSpeed = this.mSpinSpeed;
        progressSavedState.mProgressWidth = this.mProgressWidth;
        progressSavedState.mProgressColor = this.mProgressColor;
        progressSavedState.mProgressBackgroundColor = this.mProgressBackgroundColor;
        progressSavedState.mShouldProgressIndeterminate = this.mProgressIndeterminate;
        progressSavedState.mShouldSetProgress = this.mProgressBarEnabled && this.mProgress > 0 && !this.mProgressIndeterminate;
        progressSavedState.mProgress = this.mProgress;
        progressSavedState.mAnimateProgress = this.mAnimateProgress;
        progressSavedState.mShowProgressBackground = this.mShowProgressBackground;
        return progressSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ProgressSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ProgressSavedState progressSavedState = (ProgressSavedState) parcelable;
        super.onRestoreInstanceState(progressSavedState.getSuperState());
        this.mCurrentProgress = progressSavedState.mCurrentProgress;
        this.mTargetProgress = progressSavedState.mTargetProgress;
        this.mSpinSpeed = progressSavedState.mSpinSpeed;
        this.mProgressWidth = progressSavedState.mProgressWidth;
        this.mProgressColor = progressSavedState.mProgressColor;
        this.mProgressBackgroundColor = progressSavedState.mProgressBackgroundColor;
        this.mShouldProgressIndeterminate = progressSavedState.mShouldProgressIndeterminate;
        this.mShouldSetProgress = progressSavedState.mShouldSetProgress;
        this.mProgress = progressSavedState.mProgress;
        this.mAnimateProgress = progressSavedState.mAnimateProgress;
        this.mShowProgressBackground = progressSavedState.mShowProgressBackground;
        this.mLastTimeAnimated = SystemClock.uptimeMillis();
    }

    private class CircleDrawable extends ShapeDrawable {
        private int circleInsetHorizontal;
        private int circleInsetVertical;

        private CircleDrawable() {
        }

        private CircleDrawable(Shape shape) {
            super(shape);
            int i = 0;
            this.circleInsetHorizontal = FloatingActionButton.this.hasShadow() ? FloatingActionButton.this.mShadowRadius + Math.abs(FloatingActionButton.this.mShadowXOffset) : 0;
            this.circleInsetVertical = FloatingActionButton.this.hasShadow() ? Math.abs(FloatingActionButton.this.mShadowYOffset) + FloatingActionButton.this.mShadowRadius : i;
            if (FloatingActionButton.this.mProgressBarEnabled) {
                this.circleInsetHorizontal += FloatingActionButton.this.mProgressWidth;
                this.circleInsetVertical += FloatingActionButton.this.mProgressWidth;
            }
        }

        public void draw(Canvas canvas) {
            setBounds(this.circleInsetHorizontal, this.circleInsetVertical, FloatingActionButton.this.calculateMeasuredWidth() - this.circleInsetHorizontal, FloatingActionButton.this.calculateMeasuredHeight() - this.circleInsetVertical);
            super.draw(canvas);
        }
    }

    private class Shadow extends Drawable {
        private Paint mErase;
        private Paint mPaint;
        private float mRadius;

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private Shadow() {
            this.mPaint = new Paint(1);
            this.mErase = new Paint(1);
            init();
        }

        private void init() {
            FloatingActionButton.this.setLayerType(1, (Paint) null);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(FloatingActionButton.this.mColorNormal);
            this.mErase.setXfermode(FloatingActionButton.PORTER_DUFF_CLEAR);
            if (!FloatingActionButton.this.isInEditMode()) {
                this.mPaint.setShadowLayer((float) FloatingActionButton.this.mShadowRadius, (float) FloatingActionButton.this.mShadowXOffset, (float) FloatingActionButton.this.mShadowYOffset, FloatingActionButton.this.mShadowColor);
            }
            this.mRadius = (float) (FloatingActionButton.this.getCircleSize() / 2);
            if (FloatingActionButton.this.mProgressBarEnabled && FloatingActionButton.this.mShowProgressBackground) {
                this.mRadius += (float) FloatingActionButton.this.mProgressWidth;
            }
        }

        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.calculateCenterX(), FloatingActionButton.this.calculateCenterY(), this.mRadius, this.mPaint);
            canvas.drawCircle(FloatingActionButton.this.calculateCenterX(), FloatingActionButton.this.calculateCenterY(), this.mRadius, this.mErase);
        }
    }

    static class ProgressSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<ProgressSavedState> CREATOR = new Parcelable.Creator<ProgressSavedState>() {
            public ProgressSavedState createFromParcel(Parcel parcel) {
                return new ProgressSavedState(parcel);
            }

            public ProgressSavedState[] newArray(int i) {
                return new ProgressSavedState[i];
            }
        };
        boolean mAnimateProgress;
        float mCurrentProgress;
        int mProgress;
        int mProgressBackgroundColor;
        boolean mProgressBarEnabled;
        boolean mProgressBarVisibilityChanged;
        int mProgressColor;
        boolean mProgressIndeterminate;
        int mProgressWidth;
        boolean mShouldProgressIndeterminate;
        boolean mShouldSetProgress;
        boolean mShowProgressBackground;
        float mSpinSpeed;
        float mTargetProgress;

        ProgressSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private ProgressSavedState(Parcel parcel) {
            super(parcel);
            this.mCurrentProgress = parcel.readFloat();
            this.mTargetProgress = parcel.readFloat();
            boolean z = true;
            this.mProgressBarEnabled = parcel.readInt() != 0;
            this.mSpinSpeed = parcel.readFloat();
            this.mProgress = parcel.readInt();
            this.mProgressWidth = parcel.readInt();
            this.mProgressColor = parcel.readInt();
            this.mProgressBackgroundColor = parcel.readInt();
            this.mProgressBarVisibilityChanged = parcel.readInt() != 0;
            this.mProgressIndeterminate = parcel.readInt() != 0;
            this.mShouldProgressIndeterminate = parcel.readInt() != 0;
            this.mShouldSetProgress = parcel.readInt() != 0;
            this.mAnimateProgress = parcel.readInt() != 0;
            this.mShowProgressBackground = parcel.readInt() == 0 ? false : z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.mCurrentProgress);
            parcel.writeFloat(this.mTargetProgress);
            parcel.writeInt(this.mProgressBarEnabled ? 1 : 0);
            parcel.writeFloat(this.mSpinSpeed);
            parcel.writeInt(this.mProgress);
            parcel.writeInt(this.mProgressWidth);
            parcel.writeInt(this.mProgressColor);
            parcel.writeInt(this.mProgressBackgroundColor);
            parcel.writeInt(this.mProgressBarVisibilityChanged ? 1 : 0);
            parcel.writeInt(this.mProgressIndeterminate ? 1 : 0);
            parcel.writeInt(this.mShouldProgressIndeterminate ? 1 : 0);
            parcel.writeInt(this.mShouldSetProgress ? 1 : 0);
            parcel.writeInt(this.mAnimateProgress ? 1 : 0);
            parcel.writeInt(this.mShowProgressBackground ? 1 : 0);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            updateBackground();
        }
    }

    public void setImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            updateBackground();
        }
    }

    public void setButtonSize(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        } else if (this.mFabSize != i) {
            this.mFabSize = i;
            updateBackground();
        }
    }

    public boolean hasShadow() {
        return !this.mUsingElevation && this.mShowShadow;
    }

    public boolean isHidden() {
        return getVisibility() == 4;
    }

    public void setElevation(float f) {
        if (C16159Util.hasLollipop() && f > 0.0f) {
            super.setElevation(f);
            if (!isInEditMode()) {
                this.mUsingElevation = true;
                this.mShowShadow = false;
            }
            updateBackground();
        }
    }

    public synchronized void setIndeterminate(boolean z) {
        if (!z) {
            this.mCurrentProgress = 0.0f;
        }
        this.mProgressBarEnabled = z;
        this.mShouldUpdateButtonPosition = true;
        this.mProgressIndeterminate = z;
        this.mLastTimeAnimated = SystemClock.uptimeMillis();
        setupProgressBounds();
        saveButtonOriginalPosition();
        updateBackground();
    }

    public synchronized void setProgress(int i, boolean z) {
        if (!this.mProgressIndeterminate) {
            this.mProgress = i;
            this.mAnimateProgress = z;
            if (!this.mButtonPositionSaved) {
                this.mShouldSetProgress = true;
                return;
            }
            this.mProgressBarEnabled = true;
            this.mShouldUpdateButtonPosition = true;
            setupProgressBounds();
            saveButtonOriginalPosition();
            updateBackground();
            if (i < 0) {
                i = 0;
            } else if (i > this.mProgressMax) {
                i = this.mProgressMax;
            }
            float f = (float) i;
            if (f != this.mTargetProgress) {
                this.mTargetProgress = this.mProgressMax > 0 ? (f / ((float) this.mProgressMax)) * 360.0f : 0.0f;
                this.mLastTimeAnimated = SystemClock.uptimeMillis();
                if (!z) {
                    this.mCurrentProgress = this.mTargetProgress;
                }
                invalidate();
            }
        }
    }
}
