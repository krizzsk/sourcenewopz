package com.tunasashimi.tuna;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Property;
import com.didi.passenger.C10448R;

public class TunaRow extends TunaView {
    private static final TunaRowDirection[] tunaRowDirectionArray = {TunaRowDirection.TOP, TunaRowDirection.BOTTOM};
    private AnimatorSet tunaRowAnimatorSet;
    private int tunaRowBackgroundNormal;
    private TunaRowDirection tunaRowDirection;
    private int tunaRowDuraction;
    /* access modifiers changed from: private */
    public int tunaRowStopY;
    private Property<TunaRow, Integer> tunaRowStopYProperty = new Property<TunaRow, Integer>(Integer.class, "tunaRowStopYProperty") {
        public Integer get(TunaRow tunaRow) {
            return Integer.valueOf(tunaRow.tunaRowStopY);
        }

        public void set(TunaRow tunaRow, Integer num) {
            int unused = tunaRow.tunaRowStopY = num.intValue();
            TunaRow.this.invalidate();
        }
    };

    public enum TunaRowDirection {
        TOP(0),
        BOTTOM(1);
        
        final int nativeInt;

        private TunaRowDirection(int i) {
            this.nativeInt = i;
        }
    }

    public AnimatorSet getTunaRowAnimatorSet() {
        return this.tunaRowAnimatorSet;
    }

    public void setTunaRowAnimatorSet(AnimatorSet animatorSet) {
        this.tunaRowAnimatorSet = animatorSet;
    }

    public TunaRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tunaTag = TunaRow.class.getSimpleName();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TunaRow);
        this.tunaRowBackgroundNormal = obtainStyledAttributes.getColor(0, 0);
        this.tunaRowDuraction = obtainStyledAttributes.getInt(2, 1000);
        int i = obtainStyledAttributes.getInt(1, 0);
        if (i >= 0) {
            this.tunaRowDirection = tunaRowDirectionArray[i];
        }
        setLayerType(1, (Paint) null);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        initTunaPaint(Paint.Style.FILL, this.tunaRowBackgroundNormal, (float) this.tunaWidth);
        int i5 = C206002.$SwitchMap$com$tunasashimi$tuna$TunaRow$TunaRowDirection[this.tunaRowDirection.ordinal()];
        if (i5 == 1) {
            this.tunaRowStopY = 0;
        } else if (i5 == 2) {
            this.tunaRowStopY = this.tunaHeight;
        }
    }

    /* renamed from: com.tunasashimi.tuna.TunaRow$2 */
    static /* synthetic */ class C206002 {
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaRow$TunaRowDirection;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.tunasashimi.tuna.TunaRow$TunaRowDirection[] r0 = com.tunasashimi.tuna.TunaRow.TunaRowDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tunasashimi$tuna$TunaRow$TunaRowDirection = r0
                com.tunasashimi.tuna.TunaRow$TunaRowDirection r1 = com.tunasashimi.tuna.TunaRow.TunaRowDirection.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaRow$TunaRowDirection     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tunasashimi.tuna.TunaRow$TunaRowDirection r1 = com.tunasashimi.tuna.TunaRow.TunaRowDirection.BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaRow.C206002.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = C206002.$SwitchMap$com$tunasashimi$tuna$TunaRow$TunaRowDirection[this.tunaRowDirection.ordinal()];
        if (i == 1) {
            canvas.drawLine((float) (this.tunaWidth >> 1), 0.0f, (float) (this.tunaWidth >> 1), (float) this.tunaRowStopY, this.tunaPaint);
        } else if (i == 2) {
            canvas.drawLine((float) (this.tunaWidth >> 1), (float) this.tunaHeight, (float) (this.tunaWidth >> 1), (float) this.tunaRowStopY, this.tunaPaint);
        }
    }

    public void play() {
        ObjectAnimator objectAnimator;
        this.tunaRowAnimatorSet = new AnimatorSet();
        int i = C206002.$SwitchMap$com$tunasashimi$tuna$TunaRow$TunaRowDirection[this.tunaRowDirection.ordinal()];
        if (i == 1) {
            objectAnimator = ObjectAnimator.ofInt(this, this.tunaRowStopYProperty, new int[]{0, this.tunaHeight});
        } else if (i != 2) {
            objectAnimator = null;
        } else {
            objectAnimator = ObjectAnimator.ofInt(this, this.tunaRowStopYProperty, new int[]{this.tunaHeight, 0});
        }
        objectAnimator.setDuration((long) this.tunaRowDuraction);
        this.tunaRowAnimatorSet.playTogether(new Animator[]{objectAnimator});
        this.tunaRowAnimatorSet.start();
    }
}
