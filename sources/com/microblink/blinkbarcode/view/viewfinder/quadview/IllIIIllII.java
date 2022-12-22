package com.microblink.blinkbarcode.view.viewfinder.quadview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import com.microblink.blinkbarcode.geometry.Point;
import com.microblink.blinkbarcode.geometry.Quadrilateral;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.secured.IllIIIIllI;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.OnSizeChangedListener;
import com.microblink.blinkbarcode.view.recognition.DetectionStatus;

/* compiled from: line */
public class IllIIIllII extends View implements ValueAnimator.AnimatorUpdateListener {
    private int IIlIIIllIl = -1;
    /* access modifiers changed from: private */
    public Animator.AnimatorListener IlIIlIIIII = new llIIlIlIIl();
    private int IlIIlllIIl = 1;
    private double IlIllIlIIl = 0.11d;
    /* access modifiers changed from: private */
    public Quadrilateral IlIllIlllI = new Quadrilateral();
    private IllIIIIllI IlIlllllII = null;
    private int IllIIIIllI = -1;
    private int IllIIIllII = -1;
    private int IllIIlIIII;
    private boolean lIIIIIlIlI;
    /* access modifiers changed from: private */
    public long lIIIIIllll = 500;
    private int lIlIIIIlIl = -1;
    private OnSizeChangedListener lIllIIlIIl;
    private boolean lIlllIlIlI = true;
    private int llIIIlllll = -1;
    /* access modifiers changed from: private */
    public ValueAnimator llIIlIIIll = null;
    private int llIIlIIlll = -1;
    private double llIIlIlIIl = 0.11d;
    private boolean llIllIIlll = false;
    /* access modifiers changed from: private */
    public Quadrilateral lllIIIlIlI = new Quadrilateral();
    /* access modifiers changed from: private */
    public QuadViewAnimationListener lllIIlIIlI;
    private int lllIlIlIIl;
    private final Handler lllllIlIll = new Handler();

    /* compiled from: line */
    public class llIIlIlIIl implements Animator.AnimatorListener {
        public llIIlIlIIl() {
        }

        public void onAnimationCancel(Animator animator) {
            if (IllIIIllII.this.lllIIlIIlI != null) {
                IllIIIllII.this.lllIIlIIlI.onAnimationEnd();
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (IllIIIllII.this.lllIIlIIlI != null) {
                IllIIIllII.this.lllIIlIIlI.onAnimationEnd();
            }
        }

        public void onAnimationRepeat(Animator animator) {
            if (IllIIIllII.this.lllIIlIIlI != null) {
                IllIIIllII.this.lllIIlIIlI.onAnimationEnd();
                IllIIIllII.this.lllIIlIIlI.onAnimationStart();
            }
        }

        public void onAnimationStart(Animator animator) {
            if (IllIIIllII.this.lllIIlIIlI != null) {
                IllIIIllII.this.lllIIlIIlI.onAnimationStart();
            }
        }
    }

    public IllIIIllII(Context context, IllIIIIllI illIIIIllI, double d, double d2, int i) {
        super(context);
        llIIlIlIIl(illIIIIllI, d, d2, i);
    }

    public IllIIIIllI getQuadDrawer() {
        return this.IlIlllllII;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.lllIIIlIlI = (Quadrilateral) valueAnimator.getAnimatedValue();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        boolean z = this.IIlIIIllIl <= 0;
        if (this.IllIIIllII == -1) {
            this.IllIIIllII = getWidth();
        }
        if (this.llIIIlllll == -1) {
            this.llIIIlllll = getHeight();
        }
        int i = this.IllIIIllII;
        int i2 = this.llIIIlllll;
        int i3 = (i2 - ((int) (((double) i2) * (1.0d - this.IlIllIlIIl)))) / 2;
        this.IllIIIIllI = i3;
        int i4 = (i - ((int) (((double) i) * (1.0d - this.llIIlIlIIl)))) / 2;
        this.lIlIIIIlIl = i4;
        int i5 = i - i4;
        this.llIIlIIlll = i5;
        int i6 = i2 - i3;
        this.IIlIIIllIl = i6;
        int i7 = this.IlIIlllIIl;
        if (i7 == 8 || i7 == 9) {
            this.IllIIIIllI = i6;
            this.IIlIIIllIl = i3;
            this.lIlIIIIlIl = i5;
            this.llIIlIIlll = i4;
        }
        if (z) {
            this.lllIIIlIlI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, i7);
            this.lllIIIlIlI.setColor(this.lllIlIlIIl);
            this.lllIIIlIlI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.lllIIIlIlI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            this.IlIllIlllI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.IlIllIlllI.setColor(this.lllIlIlIIl);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
        } else if (this.lllIIIlIlI.isDefaultQuad() && !this.lllIIIlIlI.matchesMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl)) {
            this.lllIIIlIlI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.lllIIIlIlI.setColor(this.lllIlIlIIl);
            this.lllIIIlIlI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.lllIIIlIlI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            this.IlIllIlllI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.IlIllIlllI.setColor(this.lllIlIlIIl);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
        }
        this.IlIlllllII.llIIlIlIIl(this.lllIIIlIlI, canvas);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IllIIIllII = getWidth();
        this.llIIIlllll = getHeight();
        Log.m40227d(this, "QuadView layouting to size: {}x{}", Integer.valueOf(this.IllIIIllII), Integer.valueOf(this.llIIIlllll));
        OnSizeChangedListener onSizeChangedListener = this.lIllIIlIIl;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.onSizeChanged(this.IllIIIllII, this.llIIIlllll);
        }
    }

    public void setAnimationDuration(long j) {
        this.lIIIIIllll = j;
    }

    public void setAnimationListener(QuadViewAnimationListener quadViewAnimationListener) {
        this.lllIIlIIlI = quadViewAnimationListener;
    }

    public void setDefaultQuadColor(int i) {
        this.lllIlIlIIl = i;
    }

    public void setDetectedQuadColor(int i) {
        this.IllIIlIIII = i;
    }

    public void setHostActivityOrientation(int i) {
        int i2 = this.IlIIlllIIl;
        boolean z = true;
        if (!(((i2 == 1 || i2 == 9) && (i == 0 || i == 8)) || ((i2 == 0 || i2 == 8) && (i == 1 || i == 9)))) {
            z = false;
        }
        this.IlIIlllIIl = i;
        if (z) {
            double d = this.IlIllIlIIl;
            this.IlIllIlIIl = this.llIIlIlIIl;
            this.llIIlIlIIl = d;
        }
    }

    public void setMirrored(boolean z) {
        this.llIllIIlll = z;
    }

    public void setMovable(boolean z) {
        this.lIlllIlIlI = z;
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.lIllIIlIIl = onSizeChangedListener;
    }

    private void IlIllIlIIl(DetectionStatus detectionStatus) {
        if (detectionStatus == DetectionStatus.SUCCESS || (detectionStatus != DetectionStatus.FAIL && this.lIIIIIlIlI)) {
            this.IlIllIlllI.setColor(this.IllIIlIIII);
        } else {
            this.IlIllIlllI.setColor(this.lllIlIlIIl);
        }
        if (this.IllIIIIllI != this.IIlIIIllIl) {
            this.lllllIlIll.post(new IlIllIlIIl(this));
        }
    }

    private void llIIlIlIIl(IllIIIIllI illIIIIllI, double d, double d2, int i) {
        this.IlIlllllII = illIIIIllI;
        this.IlIllIlIIl = d2;
        this.llIIlIlIIl = d;
        this.lllIlIlIIl = getResources().getColor(R.color.mb_default_frame);
        this.IllIIlIIII = getResources().getColor(R.color.mb_recognized_frame);
        setBackgroundColor(0);
        getResources();
        this.IlIIlllIIl = i;
        if (!isInEditMode()) {
            setLayerType(2, illIIIIllI.llIIlIlIIl());
        }
    }

    public void llIIlIlIIl(boolean z) {
        this.lIIIIIlIlI = z;
    }

    public boolean llIIlIlIIl() {
        ValueAnimator valueAnimator = this.llIIlIIIll;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public void llIIlIlIIl(Quadrilateral quadrilateral, DetectionStatus detectionStatus) {
        Quadrilateral quadrilateral2;
        if (this.lIlllIlIlI) {
            Quadrilateral sortedQuad = quadrilateral.getSortedQuad();
            Log.m40231i(QuadViewManager.class, "Building quad from unit quad {} and view size ({}x{}) in host activity orientation {}.", sortedQuad, Integer.valueOf(this.IllIIIllII), Integer.valueOf(this.llIIIlllll), Integer.valueOf(this.IlIIlllIIl));
            Point upperLeft = sortedQuad.getUpperLeft();
            Point upperRight = sortedQuad.getUpperRight();
            Point lowerLeft = sortedQuad.getLowerLeft();
            Point lowerRight = sortedQuad.getLowerRight();
            int i = this.IlIIlllIIl;
            if (i == 9 || i == 8) {
                upperLeft = upperLeft.mirrorXY(1.0f, 1.0f);
                upperRight = upperRight.mirrorXY(1.0f, 1.0f);
                lowerLeft = lowerLeft.mirrorXY(1.0f, 1.0f);
                lowerRight = lowerRight.mirrorXY(1.0f, 1.0f);
            }
            int i2 = this.IlIIlllIIl;
            if (i2 == 1 || i2 == 9) {
                quadrilateral2 = new Quadrilateral(new Point((1.0f - upperLeft.getY()) * ((float) this.IllIIIllII), upperLeft.getX() * ((float) this.llIIIlllll)), new Point((1.0f - upperRight.getY()) * ((float) this.IllIIIllII), upperRight.getX() * ((float) this.llIIIlllll)), new Point((1.0f - lowerLeft.getY()) * ((float) this.IllIIIllII), lowerLeft.getX() * ((float) this.llIIIlllll)), new Point((1.0f - lowerRight.getY()) * ((float) this.IllIIIllII), lowerRight.getX() * ((float) this.llIIIlllll)));
            } else {
                quadrilateral2 = new Quadrilateral(new Point(upperLeft.getX() * ((float) this.IllIIIllII), upperLeft.getY() * ((float) this.llIIIlllll)), new Point(upperRight.getX() * ((float) this.IllIIIllII), upperRight.getY() * ((float) this.llIIIlllll)), new Point(lowerLeft.getX() * ((float) this.IllIIIllII), lowerLeft.getY() * ((float) this.llIIIlllll)), new Point(lowerRight.getX() * ((float) this.IllIIIllII), lowerRight.getY() * ((float) this.llIIIlllll)));
            }
            this.IlIllIlllI = quadrilateral2;
            IlIllIlIIl(detectionStatus);
        }
    }

    public void llIIlIlIIl(DetectionStatus detectionStatus) {
        Quadrilateral quadrilateral;
        if (this.lIlllIlIlI && (quadrilateral = this.IlIllIlllI) != null) {
            quadrilateral.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            IlIllIlIIl(detectionStatus);
        }
    }

    public void llIIlIlIIl(double d, double d2) {
        this.llIIlIlIIl = d;
        this.IlIllIlIIl = d2;
        if (this.IllIIIIllI != this.IIlIIIllIl) {
            int i = this.IllIIIllII;
            int i2 = this.llIIIlllll;
            int i3 = (i2 - ((int) (((double) i2) * (1.0d - d2)))) / 2;
            this.IllIIIIllI = i3;
            int i4 = (i - ((int) (((double) i) * (1.0d - d)))) / 2;
            this.lIlIIIIlIl = i4;
            int i5 = i - i4;
            this.llIIlIIlll = i5;
            int i6 = i2 - i3;
            this.IIlIIIllIl = i6;
            int i7 = this.IlIIlllIIl;
            if (i7 == 8 || i7 == 9) {
                this.IllIIIIllI = i6;
                this.IIlIIIllIl = i3;
                this.lIlIIIIlIl = i5;
                this.llIIlIIlll = i4;
            }
            this.IlIllIlllI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, i7);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            this.lllIIIlIlI.setIsDefaultQuad(false);
            this.lllllIlIll.post(new IlIllIlIIl(this));
        }
    }
}
