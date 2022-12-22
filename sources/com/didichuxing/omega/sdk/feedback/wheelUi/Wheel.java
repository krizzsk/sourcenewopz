package com.didichuxing.omega.sdk.feedback.wheelUi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class Wheel extends View implements GestureDetector.OnGestureListener {
    private static final int DURATION = 200;
    private float mCenterItemY;
    private List<String> mData;
    private final GestureDetector mDetector;
    private boolean mIsFirt = true;
    private int mItemHeight;
    private List<WheelItem> mItemList;
    private int mLeftMargin;
    private final int mMargin = 20;
    private int mMaxTextHeight;
    /* access modifiers changed from: private */
    public OnItemChangedListener mOnItemSelectedListener;
    private Paint mPaint;
    private int mRightMargin;
    private FlingRunnable mRunnable;
    /* access modifiers changed from: private */
    public int mSelectedIndex;
    private float mTextBaselineY;
    private int mTextColor;
    private int mTextSize;

    public interface OnItemChangedListener {
        void onItemChanged(int i);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public Wheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.afwheel);
        this.mTextColor = obtainStyledAttributes.getColor(0, -16777216);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelOffset(1, 48);
        setBackgroundColor(getResources().getColor(R.color.afanty_white));
        this.mDetector = new GestureDetector(getContext(), this);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize((float) this.mTextSize);
        this.mPaint.setColor(this.mTextColor);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        Rect rect = new Rect();
        this.mPaint.getTextBounds("秦", 0, 1, rect);
        int height = rect.height();
        this.mMaxTextHeight = height;
        int i = height + 40;
        this.mItemHeight = i;
        this.mTextBaselineY = (((float) (i / 2)) - fontMetrics.descent) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.afanty_afwheel_margin);
        this.mLeftMargin = dimensionPixelOffset;
        this.mRightMargin = dimensionPixelOffset;
    }

    public void setOnItemSelectedListener(OnItemChangedListener onItemChangedListener) {
        this.mOnItemSelectedListener = onItemChangedListener;
    }

    private float getMaxTextHeight() {
        return (float) this.mMaxTextHeight;
    }

    public int getSelectedIndex() {
        return this.mSelectedIndex;
    }

    public void setData(List<String> list) {
        this.mIsFirt = true;
        this.mData = list;
        this.mSelectedIndex = 0;
        FlingRunnable flingRunnable = this.mRunnable;
        if (flingRunnable != null) {
            removeCallbacks(flingRunnable);
        }
        invalidate();
    }

    private void initEachItemToP() {
        int i;
        List<String> list = this.mData;
        if (list != null && !list.isEmpty() && getMeasuredWidth() != 0 && this.mSelectedIndex < this.mData.size()) {
            this.mItemList = new ArrayList(this.mData.size());
            int measuredWidth = getMeasuredWidth();
            float f = ((float) measuredWidth) / 2.0f;
            int size = this.mData.size();
            int i2 = this.mLeftMargin + this.mRightMargin;
            int i3 = 0;
            while (true) {
                i = this.mSelectedIndex;
                if (i3 > i - 1) {
                    break;
                }
                WheelItem wheelItem = new WheelItem(measuredWidth, this.mItemHeight, i2);
                wheelItem.setTop(this.mCenterItemY - ((float) ((this.mSelectedIndex - i3) * this.mItemHeight)));
                wheelItem.setTitle(this.mData.get(i3) + "");
                wheelItem.setTextCenterX(f);
                wheelItem.setPaint(this.mPaint);
                wheelItem.setTextBaselineY(this.mTextBaselineY);
                this.mItemList.add(wheelItem);
                i3++;
            }
            while (i < size) {
                WheelItem wheelItem2 = new WheelItem(measuredWidth, this.mItemHeight, i2);
                wheelItem2.setTop(this.mCenterItemY + ((float) ((i - this.mSelectedIndex) * this.mItemHeight)));
                wheelItem2.setTitle(this.mData.get(i) + "");
                wheelItem2.setTextCenterX(f);
                wheelItem2.setPaint(this.mPaint);
                wheelItem2.setTextBaselineY(this.mTextBaselineY);
                this.mItemList.add(wheelItem2);
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsFirt) {
            this.mIsFirt = false;
            initEachItemToP();
        }
        if (this.mItemList != null) {
            for (int i = 0; i < this.mItemList.size(); i++) {
                this.mItemList.get(i).draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        float maxTextHeight = getMaxTextHeight();
        float f = (((float) measuredHeight) - maxTextHeight) / 2.0f;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.afanty_wheelview_shadow));
        float f2 = (float) ((int) (getResources().getDisplayMetrics().density * 10.0f));
        float f3 = f - f2;
        Paint paint2 = paint;
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), f3, paint2);
        float f4 = f2 + f + maxTextHeight;
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, f4, (float) getMeasuredWidth(), (f * 2.0f) + maxTextHeight, paint2);
        paint.setColor(getResources().getColor(R.color.afanty_light_gray_s));
        canvas2.drawLine(0.0f, f3, (float) getMeasuredWidth(), f3, paint2);
        canvas2.drawLine(0.0f, f4, (float) getMeasuredWidth(), f4, paint2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean onTouchEvent = this.mDetector.onTouchEvent(motionEvent);
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    return true;
                }
                if (action != 3) {
                    return super.onTouchEvent(motionEvent);
                }
            }
            if (!onTouchEvent) {
                snapToDestination();
            }
        }
        return true;
    }

    private void snapToDestination() {
        List<WheelItem> list = this.mItemList;
        if (list != null && !list.isEmpty()) {
            int size = this.mItemList.size();
            int measuredHeight = getMeasuredHeight() >> 1;
            int i = 0;
            float f = 0.0f;
            float f2 = 0.0f;
            while (true) {
                if (i >= size) {
                    break;
                }
                WheelItem wheelItem = this.mItemList.get(i);
                float top = wheelItem.getTop();
                if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                    float f3 = (float) measuredHeight;
                    if (top <= f3 && ((float) this.mItemHeight) + top >= f3) {
                        this.mSelectedIndex = i;
                        f2 = top - this.mCenterItemY;
                        break;
                    } else if (top > f3 && f < f3) {
                        if (Math.abs(top - f3) > Math.abs(f - f3)) {
                            float f4 = (f - ((float) this.mItemHeight)) - this.mCenterItemY;
                            this.mSelectedIndex = i - 1;
                            f2 = f4;
                        } else {
                            this.mSelectedIndex = i;
                            f2 = top - this.mCenterItemY;
                        }
                        this.mSelectedIndex = i;
                    } else if (i != size - 1 || ((float) this.mItemHeight) + top > f3) {
                        f = ((float) this.mItemHeight) + top;
                    } else {
                        f2 = top - this.mCenterItemY;
                        this.mSelectedIndex = i;
                    }
                }
                i++;
            }
            scrollToDestination(f2);
        }
    }

    private void scrollToDestination(float f) {
        FlingRunnable flingRunnable = new FlingRunnable();
        this.mRunnable = flingRunnable;
        flingRunnable.flingUp((int) (-f), 200);
    }

    /* access modifiers changed from: private */
    public void scrollEacheItem(float f) {
        for (int i = 0; i < this.mItemList.size(); i++) {
            WheelItem wheelItem = this.mItemList.get(i);
            wheelItem.setTop(wheelItem.getTop() + f);
        }
        if (f < 0.0f) {
            List<WheelItem> list = this.mItemList;
            if (list.get(list.size() - 1).getTop() + ((float) this.mItemHeight) < ((float) ((getMeasuredHeight() - this.mMaxTextHeight) >> 1))) {
                restTop();
                removeCallbacks(this.mRunnable);
                return;
            }
        }
        if (f > 0.0f) {
            if (this.mItemList.get(0).getTop() > ((float) ((getMeasuredHeight() + this.mMaxTextHeight) >> 1))) {
                restBottom();
                removeCallbacks(this.mRunnable);
            }
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        handleScroll(f2);
        return true;
    }

    private void restTop() {
        if (this.mItemList != null) {
            float measuredHeight = ((float) ((getMeasuredHeight() - this.mMaxTextHeight) >> 1)) - ((float) this.mItemHeight);
            for (int size = this.mItemList.size() - 1; size >= 0; size--) {
                this.mItemList.get(size).setTop(measuredHeight);
                measuredHeight -= (float) this.mItemHeight;
            }
            invalidate();
        }
    }

    private void restBottom() {
        if (this.mItemList != null) {
            float measuredHeight = (float) ((getMeasuredHeight() + this.mMaxTextHeight) >> 1);
            int size = this.mItemList.size();
            for (int i = 0; i < size; i++) {
                this.mItemList.get(i).setTop(measuredHeight);
                measuredHeight += (float) this.mItemHeight;
            }
            invalidate();
        }
    }

    private void handleScroll(float f) {
        int size = this.mItemList.size();
        if (f > 0.0f) {
            if (this.mItemList.get(size - 1).getTop() + ((float) this.mItemHeight) <= ((float) ((getMeasuredHeight() - this.mMaxTextHeight) >> 1))) {
                restTop();
                return;
            }
        } else {
            if (this.mItemList.get(0).getTop() >= ((float) ((getMeasuredHeight() + this.mMaxTextHeight) >> 1))) {
                restBottom();
                return;
            }
        }
        for (int i = 0; i < size; i++) {
            WheelItem wheelItem = this.mItemList.get(i);
            wheelItem.setTop(wheelItem.getTop() - f);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
        }
        float f = ((float) this.mItemHeight) * 5.5f;
        setMeasuredDimension(size, (int) f);
        this.mCenterItemY = (f - ((float) this.mItemHeight)) / 2.0f;
    }

    public class FlingRunnable implements Runnable {
        private int mLastFingY;
        private Scroller mScroller;

        public FlingRunnable() {
            this.mScroller = new Scroller(Wheel.this.getContext());
        }

        public void run() {
            if (this.mScroller.computeScrollOffset()) {
                Wheel.this.scrollEacheItem((float) (this.mScroller.getCurrY() - this.mLastFingY));
                Wheel.this.invalidate();
                this.mLastFingY = this.mScroller.getCurrY();
                Wheel.this.post(this);
                return;
            }
            Wheel.this.removeCallbacks(this);
            if (Wheel.this.mOnItemSelectedListener != null) {
                Wheel.this.mOnItemSelectedListener.onItemChanged(Wheel.this.mSelectedIndex);
            }
        }

        /* access modifiers changed from: private */
        public void flingUp(int i, int i2) {
            Wheel.this.removeCallbacks(this);
            this.mLastFingY = 0;
            this.mScroller.startScroll(0, 0, 0, i, i2);
            Wheel.this.post(this);
        }
    }
}
