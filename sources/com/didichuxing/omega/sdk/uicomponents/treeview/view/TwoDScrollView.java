package com.didichuxing.omega.sdk.uicomponents.treeview.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Scroller;
import java.util.ArrayList;

public class TwoDScrollView extends FrameLayout {
    static final int ANIMATED_SCROLL_GAP = 250;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private View mChildToScrollTo = null;
    private boolean mIsBeingDragged = false;
    private boolean mIsLayoutDirty = true;
    private float mLastMotionX;
    private float mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private Scroller mScroller;
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;
    private boolean mTwoDScrollViewMovedFocus;
    private VelocityTracker mVelocityTracker;

    private int clamp(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    public TwoDScrollView(Context context) {
        super(context);
        initTwoDScrollView();
    }

    public TwoDScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initTwoDScrollView();
    }

    public TwoDScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initTwoDScrollView();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (getScrollY() < verticalFadingEdgeLength) {
            return ((float) getScrollY()) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (getScrollX() < horizontalFadingEdgeLength) {
            return ((float) getScrollX()) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int right = (getChildAt(0).getRight() - getScrollX()) - (getWidth() - getPaddingRight());
        if (right < horizontalFadingEdgeLength) {
            return ((float) right) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmountVertical() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getMaxScrollAmountHorizontal() {
        return (int) (((float) getWidth()) * 0.5f);
    }

    private void initTwoDScrollView() {
        this.mScroller = new Scroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    private boolean canScroll() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        int height = childAt.getHeight();
        int width = childAt.getWidth();
        if (getHeight() < height + getPaddingTop() + getPaddingBottom() || getWidth() < width + getPaddingLeft() + getPaddingRight()) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        if (!canScroll()) {
            if (!isFocused()) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(33, false);
                    }
                    return fullScroll(33, false);
                case 20:
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(130, false);
                    }
                    return fullScroll(130, false);
                case 21:
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(17, true);
                    }
                    return fullScroll(17, true);
                case 22:
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(66, true);
                    }
                    return fullScroll(66, true);
                default:
                    return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r0 != 3) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x000d
            boolean r3 = r5.mIsBeingDragged
            if (r3 == 0) goto L_0x000d
            return r2
        L_0x000d:
            boolean r3 = r5.canScroll()
            r4 = 0
            if (r3 != 0) goto L_0x0017
            r5.mIsBeingDragged = r4
            return r4
        L_0x0017:
            float r3 = r6.getY()
            float r6 = r6.getX()
            if (r0 == 0) goto L_0x0045
            if (r0 == r2) goto L_0x0042
            if (r0 == r1) goto L_0x0029
            r6 = 3
            if (r0 == r6) goto L_0x0042
            goto L_0x0052
        L_0x0029:
            float r0 = r5.mLastMotionY
            float r3 = r3 - r0
            float r0 = java.lang.Math.abs(r3)
            int r0 = (int) r0
            float r1 = r5.mLastMotionX
            float r6 = r6 - r1
            float r6 = java.lang.Math.abs(r6)
            int r6 = (int) r6
            int r1 = r5.mTouchSlop
            if (r0 > r1) goto L_0x003f
            if (r6 <= r1) goto L_0x0052
        L_0x003f:
            r5.mIsBeingDragged = r2
            goto L_0x0052
        L_0x0042:
            r5.mIsBeingDragged = r4
            goto L_0x0052
        L_0x0045:
            r5.mLastMotionY = r3
            r5.mLastMotionX = r6
            android.widget.Scroller r6 = r5.mScroller
            boolean r6 = r6.isFinished()
            r6 = r6 ^ r2
            r5.mIsBeingDragged = r6
        L_0x0052:
            boolean r6 = r5.mIsBeingDragged
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.uicomponents.treeview.view.TwoDScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (getScrollX() < 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (getScrollY() < 0) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r0 = r7.getEdgeFlags()
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r0 = r6.canScroll()
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x001f
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x001f:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r7)
            int r0 = r7.getAction()
            float r2 = r7.getY()
            float r7 = r7.getX()
            r3 = 1
            if (r0 == 0) goto L_0x00d8
            if (r0 == r3) goto L_0x00a1
            r4 = 2
            if (r0 == r4) goto L_0x003a
            goto L_0x00e9
        L_0x003a:
            float r0 = r6.mLastMotionX
            float r0 = r0 - r7
            int r0 = (int) r0
            float r4 = r6.mLastMotionY
            float r4 = r4 - r2
            int r4 = (int) r4
            r6.mLastMotionX = r7
            r6.mLastMotionY = r2
            if (r0 >= 0) goto L_0x0050
            int r7 = r6.getScrollX()
            if (r7 >= 0) goto L_0x006f
        L_0x004e:
            r0 = 0
            goto L_0x006f
        L_0x0050:
            if (r0 <= 0) goto L_0x006f
            int r7 = r6.getWidth()
            int r2 = r6.getPaddingRight()
            int r7 = r7 - r2
            android.view.View r2 = r6.getChildAt(r1)
            int r2 = r2.getRight()
            int r5 = r6.getScrollX()
            int r2 = r2 - r5
            int r2 = r2 - r7
            if (r2 <= 0) goto L_0x004e
            int r0 = java.lang.Math.min(r2, r0)
        L_0x006f:
            if (r4 >= 0) goto L_0x0078
            int r7 = r6.getScrollY()
            if (r7 >= 0) goto L_0x0098
            goto L_0x0099
        L_0x0078:
            if (r4 <= 0) goto L_0x0098
            int r7 = r6.getHeight()
            int r2 = r6.getPaddingBottom()
            int r7 = r7 - r2
            android.view.View r2 = r6.getChildAt(r1)
            int r2 = r2.getBottom()
            int r5 = r6.getScrollY()
            int r2 = r2 - r5
            int r2 = r2 - r7
            if (r2 <= 0) goto L_0x0099
            int r1 = java.lang.Math.min(r2, r4)
            goto L_0x0099
        L_0x0098:
            r1 = r4
        L_0x0099:
            if (r1 != 0) goto L_0x009d
            if (r0 == 0) goto L_0x00e9
        L_0x009d:
            r6.scrollBy(r0, r1)
            goto L_0x00e9
        L_0x00a1:
            android.view.VelocityTracker r7 = r6.mVelocityTracker
            r0 = 1000(0x3e8, float:1.401E-42)
            int r1 = r6.mMaximumVelocity
            float r1 = (float) r1
            r7.computeCurrentVelocity(r0, r1)
            float r0 = r7.getXVelocity()
            int r0 = (int) r0
            float r7 = r7.getYVelocity()
            int r7 = (int) r7
            int r1 = java.lang.Math.abs(r0)
            int r2 = java.lang.Math.abs(r7)
            int r1 = r1 + r2
            int r2 = r6.mMinimumVelocity
            if (r1 <= r2) goto L_0x00cd
            int r1 = r6.getChildCount()
            if (r1 <= 0) goto L_0x00cd
            int r0 = -r0
            int r7 = -r7
            r6.fling(r0, r7)
        L_0x00cd:
            android.view.VelocityTracker r7 = r6.mVelocityTracker
            if (r7 == 0) goto L_0x00e9
            r7.recycle()
            r7 = 0
            r6.mVelocityTracker = r7
            goto L_0x00e9
        L_0x00d8:
            android.widget.Scroller r0 = r6.mScroller
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00e5
            android.widget.Scroller r0 = r6.mScroller
            r0.abortAnimation()
        L_0x00e5:
            r6.mLastMotionY = r2
            r6.mLastMotionX = r7
        L_0x00e9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.uicomponents.treeview.view.TwoDScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private View findFocusableViewInMyBounds(boolean z, int i, boolean z2, int i2, View view) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        int i3 = i + verticalFadingEdgeLength;
        int height = (i + getHeight()) - verticalFadingEdgeLength;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int i4 = i2 + horizontalFadingEdgeLength;
        int width = (i2 + getWidth()) - horizontalFadingEdgeLength;
        if (view == null || view.getTop() >= height || view.getBottom() <= i3 || view.getLeft() >= width || view.getRight() <= i4) {
            return findFocusableViewInBounds(z, i3, height, z2, i4, width);
        }
        return view;
    }

    private View findFocusableViewInBounds(boolean z, int i, int i2, boolean z2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view2 = (View) focusables.get(i9);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            int left = view2.getLeft();
            int right = view2.getRight();
            if (i5 < bottom && top < i6 && i7 < right && left < i8) {
                boolean z4 = i5 < top && bottom < i6 && i7 < left && right < i8;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    boolean z6 = (z2 && left < view.getLeft()) || (!z2 && right > view.getRight());
                    if (z3) {
                        if (z4) {
                            if (z5) {
                                if (!z6) {
                                }
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        if (!z6) {
                        }
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    public boolean fullScroll(int i, boolean z) {
        int childCount;
        int childCount2;
        if (!z) {
            boolean z2 = i == 130;
            int height = getHeight();
            this.mTempRect.top = 0;
            this.mTempRect.bottom = height;
            if (z2 && (childCount2 = getChildCount()) > 0) {
                this.mTempRect.bottom = getChildAt(childCount2 - 1).getBottom();
                Rect rect = this.mTempRect;
                rect.top = rect.bottom - height;
            }
            return scrollAndFocus(i, this.mTempRect.top, this.mTempRect.bottom, 0, 0, 0);
        }
        boolean z3 = i == 130;
        int width = getWidth();
        this.mTempRect.left = 0;
        this.mTempRect.right = width;
        if (z3 && (childCount = getChildCount()) > 0) {
            this.mTempRect.right = getChildAt(childCount - 1).getBottom();
            Rect rect2 = this.mTempRect;
            rect2.left = rect2.right - width;
        }
        return scrollAndFocus(0, 0, 0, i, this.mTempRect.top, this.mTempRect.bottom);
    }

    private boolean scrollAndFocus(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i5;
        int i11 = i6;
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = scrollY + height;
        boolean z2 = i7 == 33;
        int width = getWidth();
        int scrollX = getScrollX();
        int i13 = scrollX + width;
        boolean z3 = i4 == 33;
        int i14 = i13;
        int i15 = scrollX;
        View findFocusableViewInBounds = findFocusableViewInBounds(z2, i2, i3, z3, i5, i6);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if ((i8 < scrollY || i9 > i12) && (i10 < i15 || i11 > i14)) {
            doScroll(z3 ? i10 - i15 : i11 - i14, z2 ? i8 - scrollY : i9 - i12);
            z = true;
        } else {
            z = false;
        }
        if (findFocusableViewInBounds != findFocus() && findFocusableViewInBounds.requestFocus(i)) {
            this.mTwoDScrollViewMovedFocus = true;
            this.mTwoDScrollViewMovedFocus = false;
        }
        return z;
    }

    public boolean arrowScroll(int i, boolean z) {
        int bottom;
        int bottom2;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmountHorizontal = z ? getMaxScrollAmountHorizontal() : getMaxScrollAmountVertical();
        if (!z) {
            if (findNextFocus != null) {
                findNextFocus.getDrawingRect(this.mTempRect);
                offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
                doScroll(0, computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
                findNextFocus.requestFocus(i);
                return true;
            }
            if (i == 33 && getScrollY() < maxScrollAmountHorizontal) {
                maxScrollAmountHorizontal = getScrollY();
            } else if (i == 130 && getChildCount() > 0 && (bottom2 = getChildAt(0).getBottom() - (getScrollY() + getHeight())) < maxScrollAmountHorizontal) {
                maxScrollAmountHorizontal = bottom2;
            }
            if (maxScrollAmountHorizontal == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmountHorizontal = -maxScrollAmountHorizontal;
            }
            doScroll(0, maxScrollAmountHorizontal);
            return true;
        } else if (findNextFocus != null) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScroll(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0);
            findNextFocus.requestFocus(i);
            return true;
        } else {
            if (i == 33 && getScrollY() < maxScrollAmountHorizontal) {
                maxScrollAmountHorizontal = getScrollY();
            } else if (i == 130 && getChildCount() > 0 && (bottom = getChildAt(0).getBottom() - (getScrollY() + getHeight())) < maxScrollAmountHorizontal) {
                maxScrollAmountHorizontal = bottom;
            }
            if (maxScrollAmountHorizontal == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmountHorizontal = -maxScrollAmountHorizontal;
            }
            doScroll(maxScrollAmountHorizontal, 0);
            return true;
        }
    }

    private void doScroll(int i, int i2) {
        if (i != 0 || i2 != 0) {
            smoothScrollBy(i, i2);
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            this.mScroller.startScroll(getScrollX(), getScrollY(), i, i2);
            awakenScrollBars(this.mScroller.getDuration());
            invalidate();
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            scrollBy(i, i2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        return getChildCount() == 0 ? getHeight() : getChildAt(0).getBottom();
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return getChildCount() == 0 ? getWidth() : getChildAt(0).getRight();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, 0), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                scrollTo(clamp(currX, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth()), clamp(currY, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight()));
            } else {
                scrollTo(currX, currY);
            }
            if (!(scrollX == getScrollX() && scrollY == getScrollY())) {
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
            }
            postInvalidate();
        }
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i3 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i3 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i3;
            }
            return Math.min(i2 + 0, getChildAt(0).getBottom() - i3);
        } else if (rect.top >= scrollY || rect.bottom >= i3) {
            return 0;
        } else {
            if (rect.height() > height) {
                i = 0 - (i3 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            return Math.max(i, -getScrollY());
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mTwoDScrollViewMovedFocus) {
            if (!this.mIsLayoutDirty) {
                scrollToChild(view2);
            } else {
                this.mChildToScrollTo = view2;
            }
        }
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View view;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (view == null) {
            return false;
        }
        return view.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        scrollTo(getScrollX(), getScrollY());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScroll(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    private boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !isViewDescendantOf((View) parent, view2)) {
            return false;
        }
        return true;
    }

    public void fling(int i, int i2) {
        if (getChildCount() > 0) {
            int i3 = i;
            int i4 = i2;
            this.mScroller.fling(getScrollX(), getScrollY(), i3, i4, 0, getChildAt(0).getWidth() - ((getWidth() - getPaddingRight()) - getPaddingLeft()), 0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            boolean z = i2 > 0;
            View findFocusableViewInMyBounds = findFocusableViewInMyBounds(i > 0, this.mScroller.getFinalX(), z, this.mScroller.getFinalY(), findFocus());
            if (findFocusableViewInMyBounds == null) {
                findFocusableViewInMyBounds = this;
            }
            if (findFocusableViewInMyBounds != findFocus()) {
                if (findFocusableViewInMyBounds.requestFocus(z ? 130 : 33)) {
                    this.mTwoDScrollViewMovedFocus = true;
                    this.mTwoDScrollViewMovedFocus = false;
                }
            }
            awakenScrollBars(this.mScroller.getDuration());
            invalidate();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }
}
