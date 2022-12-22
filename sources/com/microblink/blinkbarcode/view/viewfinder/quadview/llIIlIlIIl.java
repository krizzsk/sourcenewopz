package com.microblink.blinkbarcode.view.viewfinder.quadview;

import android.content.Context;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.hardware.orientation.OrientationChangeListener;
import com.microblink.blinkbarcode.secured.IIlIIIllIl;
import com.microblink.blinkbarcode.secured.IlIllIlIIl;
import com.microblink.blinkbarcode.secured.llIllIIlll;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.OnSizeChangedListener;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;

/* compiled from: line */
public class llIIlIlIIl extends QuadViewManager implements OrientationChangeListener {
    /* access modifiers changed from: private */
    public double IlIllIlIIl = 1.0d;
    /* access modifiers changed from: private */
    public Context IllIIIIllI;
    /* access modifiers changed from: private */
    public double[] IllIIIllII;
    /* access modifiers changed from: private */
    public double[] llIIIlllll;

    /* renamed from: com.microblink.blinkbarcode.view.viewfinder.quadview.llIIlIlIIl$llIIlIlIIl  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22040llIIlIlIIl implements OnSizeChangedListener {
        public C22040llIIlIlIIl() {
        }

        public void onSizeChanged(int i, int i2) {
            if (!llIllIIlll.llIIlIlIIl(llIIlIlIIl.this.IllIIIIllI)) {
                double unused = llIIlIlIIl.this.IlIllIlIIl = ((double) i) / ((double) i2);
            } else {
                double unused2 = llIIlIlIIl.this.IlIllIlIIl = ((double) i2) / ((double) i);
            }
            llIIlIlIIl lliililiil = llIIlIlIIl.this;
            Log.m40231i(lliililiil, "Card quad view aspect ratio: {}", Double.valueOf(lliililiil.IlIllIlIIl));
            llIIlIlIIl.this.llIIIlllll[1] = 1.0d - (((1.0d - llIIlIlIIl.this.llIIIlllll[0]) * llIIlIlIIl.this.getClass()) / llIIlIlIIl.this.IlIllIlIIl);
            llIIlIlIIl.this.IllIIIllII[0] = 1.0d - (((1.0d - llIIlIlIIl.this.IllIIIllII[1]) * llIIlIlIIl.this.IlIllIlIIl) * llIIlIlIIl.this.getClass());
            llIIlIlIIl.this.llIIlIlIIl();
        }
    }

    public llIIlIlIIl(double d, double d2, double d3, RecognizerRunnerView recognizerRunnerView) {
        this.IllIIIllII = new double[]{d2, d2};
        this.llIIIlllll = new double[]{d3, d3};
        this.IllIIIIllI = recognizerRunnerView.getContext();
        int hostScreenOrientation = recognizerRunnerView.getHostScreenOrientation();
        Context context = this.IllIIIIllI;
        IlIllIlIIl ilIllIlIIl = new IlIllIlIIl(new IIlIIIllIl(0.0f, llIIlIlIIl(hostScreenOrientation)), this.IllIIIIllI);
        double[] dArr = this.llIIIlllll;
        IllIIIllII illIIIllII = new IllIIIllII(context, ilIllIlIIl, dArr[0], dArr[1], hostScreenOrientation);
        this.llIIlIlIIl = illIIIllII;
        illIIIllII.setMovable(true);
        this.llIIlIlIIl.setOnSizeChangedListener(new C22040llIIlIlIIl());
        recognizerRunnerView.addOrientationChangeListener(this);
    }

    public void onOrientationChange(Orientation orientation) {
        ((IIlIIIllIl) ((IlIllIlIIl) this.llIIlIlIIl.getQuadDrawer()).IlIllIlIIl()).llIIlIlIIl(orientation);
        llIIlIlIIl();
    }

    public void setInitialHostActivityOrientation(int i) {
        super.setInitialHostActivityOrientation(i);
        ((IIlIIIllIl) ((IlIllIlIIl) this.llIIlIlIIl.getQuadDrawer()).IlIllIlIIl()).llIIlIlIIl(llIIlIlIIl(i));
    }

    private Orientation llIIlIlIIl(int i) {
        if (i == 0) {
            return Orientation.ORIENTATION_LANDSCAPE_RIGHT;
        }
        if (i == 1) {
            return Orientation.ORIENTATION_PORTRAIT;
        }
        if (i == 8) {
            return Orientation.ORIENTATION_LANDSCAPE_LEFT;
        }
        if (i != 9) {
            return Orientation.ORIENTATION_UNKNOWN;
        }
        return Orientation.ORIENTATION_PORTRAIT_UPSIDE;
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl() {
        Orientation llIIlIlIIl = ((IIlIIIllIl) ((IlIllIlIIl) this.llIIlIlIIl.getQuadDrawer()).IlIllIlIIl()).llIIlIlIIl();
        if (!llIllIIlll.llIIlIlIIl(this.IllIIIIllI)) {
            if (llIIlIlIIl.isVertical()) {
                IllIIIllII illIIIllII = this.llIIlIlIIl;
                double[] dArr = this.llIIIlllll;
                illIIIllII.llIIlIlIIl(dArr[1], dArr[0]);
                return;
            }
            IllIIIllII illIIIllII2 = this.llIIlIlIIl;
            double[] dArr2 = this.IllIIIllII;
            illIIIllII2.llIIlIlIIl(dArr2[1], dArr2[0]);
        } else if (llIIlIlIIl.isVertical()) {
            IllIIIllII illIIIllII3 = this.llIIlIlIIl;
            double[] dArr3 = this.llIIIlllll;
            illIIIllII3.llIIlIlIIl(dArr3[0], dArr3[1]);
        } else {
            IllIIIllII illIIIllII4 = this.llIIlIlIIl;
            double[] dArr4 = this.IllIIIllII;
            illIIIllII4.llIIlIlIIl(dArr4[0], dArr4[1]);
        }
    }
}
