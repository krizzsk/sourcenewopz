package com.microblink.blinkbarcode.view.viewfinder.points;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.microblink.blinkbarcode.geometry.Point;
import com.microblink.blinkbarcode.geometry.PointSet;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.blinkbarcode.util.Log;
import java.util.List;

/* compiled from: line */
public class PointSetView extends View implements ValueAnimator.AnimatorUpdateListener, IDisplayablePointsView {
    private final Handler IIlIIIllIl;
    private int IlIllIlIIl;
    private llIIlIlIIl IlIllIlllI;
    private PointSet IllIIIIllI;
    private int IllIIIllII;
    /* access modifiers changed from: private */
    public int lIIIIIllll;
    private PointSet lIlIIIIlIl;
    private int llIIIlllll;
    /* access modifiers changed from: private */
    public ValueAnimator llIIlIIlll;
    private Paint llIIlIlIIl;
    /* access modifiers changed from: private */
    public int lllIIIlIlI;
    private int lllIlIlIIl;

    /* compiled from: line */
    public class llIIlIlIIl {
        public int IlIllIlIIl;
        public int llIIlIlIIl;

        public llIIlIlIIl(PointSetView pointSetView, int i, int i2) {
            this.llIIlIlIIl = i;
            this.IlIllIlIIl = i2;
        }
    }

    public PointSetView(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        super(context, attributeSet);
        this.IlIllIlIIl = -1;
        this.IllIIIllII = -1;
        this.llIIIlllll = 15;
        this.IllIIIIllI = null;
        this.lIlIIIIlIl = null;
        this.llIIlIIlll = null;
        this.IIlIIIllIl = new Handler();
        this.lIIIIIllll = -1;
        this.lllIIIlIlI = -1;
        this.lllIlIlIIl = 1;
        setBackgroundColor(0);
        this.lllIlIlIIl = i;
        this.llIIlIlIIl = new Paint(1);
        this.llIIlIlIIl.setStrokeWidth((float) ((context.getResources().getDisplayMetrics().densityDpi + 49) / 50));
        this.llIIlIlIIl.setStrokeCap(Paint.Cap.ROUND);
        this.llIIlIlIIl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.lIIIIIllll = i3;
        this.llIIIlllll = i2;
        this.lllIIIlIlI = 16777215 & i3;
        this.IlIllIlllI = new llIIlIlIIl(this, 0, i3);
        setLayerType(1, (Paint) null);
    }

    public void addDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        setDisplayablePointsDetection(displayablePointsDetection);
    }

    public void clearDisplayedContent() {
        addDisplayablePointsDetection((DisplayablePointsDetection) null);
    }

    public View getView() {
        return this;
    }

    public boolean isAnimationInProgress() {
        ValueAnimator valueAnimator = this.llIIlIIlll;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.IlIllIlllI = (llIIlIlIIl) valueAnimator.getAnimatedValue();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        if (this.IlIllIlIIl == -1) {
            this.IlIllIlIIl = getWidth();
        }
        if (this.IllIIIllII == -1) {
            this.IllIIIllII = getHeight();
        }
        PointSet pointSet = this.IllIIIIllI;
        PointSet pointSet2 = this.lIlIIIIlIl;
        if (pointSet != null) {
            this.llIIlIlIIl.setColor(this.IlIllIlllI.llIIlIlIIl);
            pointSet.draw(canvas, this.llIIlIlIIl, this.llIIIlllll);
        }
        if (pointSet2 != null) {
            this.llIIlIlIIl.setColor(this.IlIllIlllI.IlIllIlIIl);
            pointSet2.draw(canvas, this.llIIlIlIIl, this.llIIIlllll);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IlIllIlIIl = getWidth();
        this.IllIIIllII = getHeight();
        Log.m40233v(this, "PointSetView layouting to size: {}x{}", Integer.valueOf(this.IlIllIlIIl), Integer.valueOf(this.IllIIIllII));
    }

    public void setDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        this.lIlIIIIlIl = this.IllIIIIllI;
        if (displayablePointsDetection != null) {
            List<Point> points = displayablePointsDetection.getTransformedPointSet().getPoints();
            for (Point next : points) {
                int i = this.lllIlIlIIl;
                if (i == 8 || i == 9) {
                    next.mirrorXYInPlace(1.0f, 1.0f);
                }
                float x = next.getX();
                float y = next.getY();
                int i2 = this.lllIlIlIIl;
                if (i2 == 1 || i2 == 9) {
                    next.setX((1.0f - y) * ((float) this.IlIllIlIIl));
                    next.setY(x * ((float) this.IllIIIllII));
                } else {
                    next.setX(x * ((float) this.IlIllIlIIl));
                    next.setY(y * ((float) this.IllIIIllII));
                }
            }
            this.IllIIIIllI = new PointSet(points);
        } else {
            this.IllIIIIllI = null;
        }
        this.IIlIIIllIl.post(new llIIlIlIIl(this));
    }

    public void setHostActivityOrientation(int i) {
        this.lllIlIlIIl = i;
    }

    /* compiled from: line */
    public class IlIllIlIIl implements TypeEvaluator<llIIlIlIIl> {
        private ArgbEvaluator llIIlIlIIl;

        private IlIllIlIIl() {
            this.llIIlIlIIl = new ArgbEvaluator();
        }

        public Object evaluate(float f, Object obj, Object obj2) {
            llIIlIlIIl lliililiil = (llIIlIlIIl) obj;
            llIIlIlIIl lliililiil2 = (llIIlIlIIl) obj2;
            return new llIIlIlIIl(PointSetView.this, ((Integer) this.llIIlIlIIl.evaluate(f, Integer.valueOf(lliililiil.llIIlIlIIl), Integer.valueOf(lliililiil2.llIIlIlIIl))).intValue(), ((Integer) this.llIIlIlIIl.evaluate(f, Integer.valueOf(lliililiil.IlIllIlIIl), Integer.valueOf(lliililiil2.IlIllIlIIl))).intValue());
        }

        public /* synthetic */ IlIllIlIIl(PointSetView pointSetView, llIIlIlIIl lliililiil) {
            this();
        }
    }

    public PointSetView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 15, context.getResources().getColor(R.color.mb_recognized_frame));
    }
}
