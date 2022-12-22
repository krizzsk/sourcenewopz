package com.microblink.blinkbarcode.view.viewfinder;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class IlIllIlIIl extends ViewGroup {
    private Orientation IlIllIlIIl;
    private int IllIIIIllI;
    private Orientation IllIIIllII;
    private int lIlIIIIlIl;
    private boolean llIIIlllll;
    private Matrix llIIlIlIIl = new Matrix();

    /* compiled from: line */
    public class llIIlIlIIl extends Animation {
        private float IlIllIlIIl;
        private float IllIIIIllI;
        private float IllIIIllII;
        private float lIlIIIIlIl;
        private float llIIIlllll;
        private float llIIlIlIIl;

        public llIIlIlIIl(IlIllIlIIl ilIllIlIIl, float f, float f2, float f3, float f4, boolean z) {
            this.llIIlIlIIl = f;
            this.IlIllIlIIl = f2;
            if (z) {
                this.IllIIIllII = (f3 - f4) * 0.5f;
                this.llIIIlllll = (f4 - f3) * 0.5f;
            } else {
                this.IllIIIllII = 0.0f;
                this.llIIIlllll = 0.0f;
            }
            if (z) {
                this.IllIIIIllI = f4 * 0.5f;
                this.lIlIIIIlIl = f3 * 0.5f;
                return;
            }
            this.IllIIIIllI = f3 * 0.5f;
            this.lIlIIIIlIl = f4 * 0.5f;
        }

        public void applyTransformation(float f, Transformation transformation) {
            transformation.getMatrix().preTranslate(this.IllIIIllII, this.llIIIlllll);
            Matrix matrix = transformation.getMatrix();
            float f2 = this.llIIlIlIIl;
            matrix.preRotate(f2 + (f * (this.IlIllIlIIl - f2)), this.IllIIIIllI, this.lIlIIIIlIl);
        }
    }

    public IlIllIlIIl(Context context, int i, Orientation orientation, boolean z, int i2) {
        super(context);
        Orientation orientation2 = Orientation.ORIENTATION_PORTRAIT;
        this.IlIllIlIIl = orientation2;
        this.IllIIIllII = orientation2;
        this.llIIIlllll = true;
        this.IllIIIIllI = 500;
        this.lIlIIIIlIl = 1;
        setClipChildren(false);
        this.lIlIIIIlIl = i;
        this.IllIIIllII = orientation;
        this.IlIllIlIIl = llIIlIlIIl(orientation);
        this.llIIIlllll = z;
        this.IllIIIIllI = i2;
        if (!isInEditMode()) {
            setLayerType(2, (Paint) null);
        }
    }

    private Orientation llIIlIlIIl(Orientation orientation) {
        int ordinal = orientation.ordinal();
        int i = this.lIlIIIIlIl;
        Orientation orientation2 = Orientation.values()[(ordinal + (i != 0 ? i != 8 ? i != 9 ? 0 : 2 : 1 : 3)) % 4];
        Log.m40227d(this, "Normalized orientation {} to {}", orientation, orientation2);
        return orientation2;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        float[] fArr = {obtain.getRawX(), obtain.getRawY()};
        Log.m40227d(this, "Tap coordinate: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Log.m40227d(this, "Location on screen: ({}, {})", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        fArr[0] = fArr[0] - ((float) iArr[0]);
        fArr[1] = fArr[1] - ((float) iArr[1]);
        Log.m40227d(this, "View-normalized tap coordinate: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        this.llIIlIlIIl.mapPoints(fArr);
        Log.m40227d(this, "Mapped tap coordinate: ({} {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        obtain.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(obtain);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Log.m40227d(this, "Rotatable view group ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", Integer.valueOf(childCount), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
        int width = getWidth();
        int height = getHeight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(getChildDrawingOrder(childCount, i5));
            if (this.IlIllIlIIl.isHorizontal()) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(height, 1073741824), View.MeasureSpec.makeMeasureSpec(width, 1073741824));
                Log.m40231i(this, "Horizontal layouting child {} to: top: {} bottom: {}, left: {}, right: {}", Integer.valueOf(i5), 0, Integer.valueOf(width), 0, Integer.valueOf(height));
                childAt.layout(0, 0, height, width);
            } else {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                Log.m40231i(this, "Vertical layouting child {} to: top: {} bottom: {}, left: {}, right: {}", Integer.valueOf(i5), 0, Integer.valueOf(height), 0, Integer.valueOf(width));
                childAt.layout(0, 0, width, height);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int resolveSize = ViewGroup.resolveSize(getSuggestedMinimumWidth(), i);
        int resolveSize2 = ViewGroup.resolveSize(getSuggestedMinimumHeight(), i2);
        if (!this.IlIllIlIIl.isHorizontal()) {
            int i3 = resolveSize2;
            resolveSize2 = resolveSize;
            resolveSize = i3;
        }
        Log.m40227d(this, "Measured dimension: {}x{}", Integer.valueOf(resolveSize2), Integer.valueOf(resolveSize));
        setMeasuredDimension(resolveSize2, resolveSize);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m40227d(this, "[RotatableViewGroup] size changed from {}x{} to {}x{}", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        if (i != i3 || i2 != i4) {
            Animation llIIlIlIIl2 = llIIlIlIIl(Orientation.ORIENTATION_PORTRAIT, this.IlIllIlIIl);
            if (llIIlIlIIl2 != null) {
                llIIlIlIIl2.setFillEnabled(true);
                llIIlIlIIl2.setDuration(0);
                llIIlIlIIl2.setFillAfter(true);
                llIIlIlIIl2.setFillBefore(true);
                setLayoutAnimation(new LayoutAnimationController(llIIlIlIIl2));
                startLayoutAnimation();
            }
            llIIlIlIIl();
        }
    }

    public void setAnimateRotation(boolean z) {
        this.llIIIlllll = z;
    }

    public void setAnimationDuration(int i) {
        this.IllIIIIllI = i;
    }

    public void setHostActivityOrientation(int i) {
        this.lIlIIIIlIl = i;
        setOrientation(this.IllIIIllII);
    }

    public void setInitialOrientation(Orientation orientation) {
        this.IllIIIllII = orientation;
        this.IlIllIlIIl = llIIlIlIIl(orientation);
    }

    public void setOrientation(Orientation orientation) {
        invalidate();
        this.IllIIIllII = orientation;
        Orientation llIIlIlIIl2 = llIIlIlIIl(orientation);
        Animation llIIlIlIIl3 = llIIlIlIIl(this.IlIllIlIIl, llIIlIlIIl2);
        if (llIIlIlIIl3 != null) {
            llIIlIlIIl3.setFillAfter(true);
            if (this.llIIIlllll) {
                llIIlIlIIl3.setDuration((long) this.IllIIIIllI);
            } else {
                llIIlIlIIl3.setDuration(0);
            }
            setLayoutAnimation(new LayoutAnimationController(llIIlIlIIl3));
            startLayoutAnimation();
        } else {
            requestLayout();
        }
        this.IlIllIlIIl = llIIlIlIIl2;
        llIIlIlIIl();
        Log.m40227d(this, "Set orientation: " + this.IlIllIlIIl, new Object[0]);
    }

    private Animation llIIlIlIIl(Orientation orientation, Orientation orientation2) {
        Log.m40227d(this, "Creating animation from {} to {}", orientation, orientation2);
        Log.m40227d(this, "Width: {},  heigth: {}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        Orientation orientation3 = Orientation.ORIENTATION_PORTRAIT;
        if (orientation != orientation3) {
            Orientation orientation4 = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
            if (orientation != orientation4) {
                Orientation orientation5 = Orientation.ORIENTATION_PORTRAIT_UPSIDE;
                if (orientation != orientation5) {
                    if (orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                        if (orientation2 == orientation3) {
                            return new llIIlIlIIl(this, -90.0f, 0.0f, (float) getWidth(), (float) getHeight(), false);
                        } else if (orientation2 == orientation5) {
                            return new llIIlIlIIl(this, 270.0f, 180.0f, (float) getWidth(), (float) getHeight(), false);
                        } else if (orientation2 == orientation4) {
                            return new llIIlIlIIl(this, -90.0f, 90.0f, (float) getWidth(), (float) getHeight(), true);
                        }
                    }
                    return null;
                } else if (orientation2 == orientation4) {
                    return new llIIlIlIIl(this, 180.0f, 90.0f, (float) getWidth(), (float) getHeight(), true);
                } else if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                    return new llIIlIlIIl(this, 180.0f, 270.0f, (float) getWidth(), (float) getHeight(), true);
                } else if (orientation2 != orientation3) {
                    return null;
                } else {
                    return new llIIlIlIIl(this, 180.0f, 0.0f, (float) getWidth(), (float) getHeight(), false);
                }
            } else if (orientation2 == orientation3) {
                return new llIIlIlIIl(this, 90.0f, 0.0f, (float) getWidth(), (float) getHeight(), false);
            } else if (orientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                return new llIIlIlIIl(this, 90.0f, 180.0f, (float) getWidth(), (float) getHeight(), false);
            } else if (orientation2 != Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return null;
            } else {
                return new llIIlIlIIl(this, 90.0f, -90.0f, (float) getWidth(), (float) getHeight(), true);
            }
        } else if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
            return new llIIlIlIIl(this, 0.0f, 90.0f, (float) getWidth(), (float) getHeight(), true);
        } else if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
            return new llIIlIlIIl(this, 0.0f, -90.0f, (float) getWidth(), (float) getHeight(), true);
        } else if (orientation2 != Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
            return null;
        } else {
            return new llIIlIlIIl(this, 0.0f, 180.0f, (float) getWidth(), (float) getHeight(), false);
        }
    }

    private void llIIlIlIIl() {
        int width = getWidth();
        int height = getHeight();
        Matrix matrix = new Matrix();
        Orientation orientation = this.IlIllIlIIl;
        if (orientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
            matrix.preTranslate((float) width, 0.0f);
            matrix.preRotate(90.0f);
        } else if (orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
            matrix.preTranslate(0.0f, (float) height);
            matrix.preRotate(-90.0f);
        } else if (orientation != Orientation.ORIENTATION_PORTRAIT && orientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
            matrix.preTranslate((float) width, (float) height);
            matrix.preRotate(180.0f);
        }
        matrix.invert(this.llIIlIlIIl);
    }
}
