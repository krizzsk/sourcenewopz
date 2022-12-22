package com.microblink.blinkbarcode.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.hardware.orientation.OrientationChangeListener;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.BaseCameraView;
import com.microblink.blinkbarcode.view.viewfinder.IlIllIlIIl;
import com.microblink.blinkbarcode.view.viewfinder.llIIlIlIIl;
import java.util.Iterator;

/* compiled from: line */
public abstract class CameraViewGroup extends BaseCameraView {
    private boolean IIIIlIllIl = false;
    private llIIlIlIIl IIlIlIIlll;
    private boolean IIllllllll = false;
    private int IlIIIlIIIl = 250;
    /* access modifiers changed from: private */
    public IlIllIlIIl IlIlIIllll;

    /* compiled from: line */
    public class CameraViewGroupOrientationChangeListener extends BaseCameraView.BaseOrientationChangeListener {
        public CameraViewGroupOrientationChangeListener() {
            super();
        }

        public void onOrientationChange(Orientation orientation) {
            super.onOrientationChange(orientation);
            if (CameraViewGroup.this.llIIlIlIIl(orientation)) {
                if (CameraViewGroup.this.IlIlIIllll != null) {
                    CameraViewGroup.this.IlIlIIllll.setOrientation(orientation);
                }
                Iterator<OrientationChangeListener> it = CameraViewGroup.this.IlIlllllII.iterator();
                while (it.hasNext()) {
                    it.next().onOrientationChange(orientation);
                }
            }
        }
    }

    public CameraViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            this.IIllllllll = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "mb_animateRotation", false);
            this.IlIIIlIIIl = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "mb_animationDuration", this.IlIIIlIIIl);
        }
        llIIlIlIIl(context);
    }

    public OrientationChangeListener IllIIIIllI() {
        return new BaseCameraView.BaseOrientationChangeListener();
    }

    public void addChildView(View view, boolean z) {
        if (z) {
            this.IlIlIIllll.addView(view);
        } else {
            this.IIlIlIIlll.addView(view);
        }
    }

    public void addView(View view) {
        if (this.IIIIlIllIl) {
            addView(view, (ViewGroup.LayoutParams) null);
        } else {
            super.addView(view);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void create() {
        this.IIIIlIllIl = false;
        super.create();
        this.IIIIlIllIl = true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = this.IlIlIIllll.dispatchTouchEvent(motionEvent);
        Log.m40233v(this, "Rotatable view responded: {}", Boolean.valueOf(dispatchTouchEvent));
        if (dispatchTouchEvent) {
            return true;
        }
        boolean dispatchTouchEvent2 = this.IIlIlIIlll.dispatchTouchEvent(motionEvent);
        Log.m40233v(this, "Fixed view responded: {}", Boolean.valueOf(dispatchTouchEvent2));
        if (dispatchTouchEvent2 || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final int getRotationAnimationDuration() {
        return this.IlIIIlIIIl;
    }

    public final void setAnimateRotation(boolean z) {
        this.IIllllllll = z;
        this.IlIlIIllll.setAnimateRotation(z);
    }

    public final void setInitialOrientation(Orientation orientation) {
        super.setInitialOrientation(orientation);
        this.IlIlIIllll.setInitialOrientation(getInitialOrientation());
    }

    public final void setRotationAnimationDuration(int i) {
        this.IlIIIlIIIl = i;
        this.IlIlIIllll.setAnimationDuration(i);
    }

    public final boolean shouldAnimateRotation() {
        return this.IIllllllll;
    }

    private void llIIlIlIIl(Context context) {
        setBackgroundColor(0);
        llIIlIlIIl lliililiil = new llIIlIlIIl(context);
        this.IIlIlIIlll = lliililiil;
        lliililiil.setBackgroundColor(0);
        this.IIlIlIIlll.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.IIlIlIIlll.setVisibility(0);
        if (getInitialOrientation() == null) {
            this.lIIIIIlIlI = Orientation.fromActivityInfoCode(this.IIlIIIllIl);
        }
        IlIllIlIIl ilIllIlIIl = new IlIllIlIIl(context, this.IIlIIIllIl, getInitialOrientation(), this.IIllllllll, this.IlIIIlIIIl);
        this.IlIlIIllll = ilIllIlIIl;
        ilIllIlIIl.setBackgroundColor(0);
        this.IlIlIIllll.setVisibility(0);
        addView(this.IIlIlIIlll);
        addView(this.IlIlIIllll);
        this.IIIIlIllIl = true;
    }

    public void addChildView(View view, boolean z, int i) {
        if (z) {
            this.IlIlIIllll.addView(view, i);
        } else {
            this.IIlIlIIlll.addView(view, i);
        }
    }

    public void addView(View view, int i) {
        if (this.IIIIlIllIl) {
            addView(view, i, (ViewGroup.LayoutParams) null);
        } else {
            super.addView(view, i);
        }
    }

    /* compiled from: line */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        private boolean llIIlIlIIl = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            if (attributeSet != null) {
                this.llIIlIlIIl = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "mb_rotatable", false);
            }
        }

        public boolean isRotatable() {
            return this.llIIlIlIIl;
        }

        public void setRotatable(boolean z) {
            this.llIIlIlIIl = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof LayoutParams) {
                this.llIIlIlIIl = ((LayoutParams) layoutParams).llIIlIlIIl;
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.IIIIlIllIl) {
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            if (!(layoutParams instanceof LayoutParams)) {
                throw new RuntimeException("BaseCameraView.LayoutParams are only allowed type of params");
            } else if (((LayoutParams) layoutParams).isRotatable()) {
                this.IlIlIIllll.addView(view, i);
            } else {
                this.IIlIlIIlll.addView(view, i);
            }
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    public void llIIlIlIIl(Configuration configuration) {
        super.llIIlIlIIl(configuration);
        this.IlIlIIllll.setHostActivityOrientation(this.IIlIIIllIl);
        this.IlIlIIllll.dispatchConfigurationChanged(configuration);
        this.IIlIlIIlll.dispatchConfigurationChanged(configuration);
        if (llIIlIIlll()) {
            this.lllIlIlIIl.onOrientationChange(Orientation.fromActivityInfoCode(this.IIlIIIllIl));
        }
    }

    public CameraViewGroup(Context context) {
        super(context);
        llIIlIlIIl(context);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.IIIIlIllIl) {
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            if (!(layoutParams instanceof LayoutParams)) {
                throw new RuntimeException("BaseCameraView.LayoutParams are only allowed type of params");
            } else if (((LayoutParams) layoutParams).isRotatable()) {
                this.IlIlIIllll.addView(view);
            } else {
                this.IIlIlIIlll.addView(view);
            }
        } else {
            super.addView(view, layoutParams);
        }
    }

    public void addView(View view, int i, int i2) {
        if (!this.IIIIlIllIl) {
            super.addView(view, i, i2);
            return;
        }
        throw new RuntimeException("addView method has been disabled in CameraView. Please use addChildView(View, boolean).");
    }
}
