package com.tunasashimi.tuna;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;
import com.tunasashimi.tuna.TunaView;

public class TunaRepeat extends TunaView {
    private static final TunaRepeatSelectType[] tunaRepeatSelectTypeArray = {TunaRepeatSelectType.CONNECT, TunaRepeatSelectType.CURRENT};
    private static final TunaRepeatShapeType[] tunaRepeatShapeTypeArray = {TunaRepeatShapeType.CUSTOM};
    private Bitmap tunaRepeatBitmapSrcNormal;
    private Bitmap tunaRepeatBitmapSrcSelect;
    private int tunaRepeatCurrentIndex;
    private float tunaRepeatCurrentX;
    private float tunaRepeatItemFractionBottom;
    private float tunaRepeatItemFractionTop;
    private int tunaRepeatItemTextColorNormal;
    private int tunaRepeatItemTextColorSelect;
    private float tunaRepeatItemTextFractionBottom;
    private float tunaRepeatItemTextFractionTop;
    private float tunaRepeatItemTextSize;
    private TunaRepeatSelectType tunaRepeatSelectType;
    private TunaRepeatShapeType tunaRepeatShapeType;

    public enum TunaRepeatSelectType {
        CONNECT(0),
        CURRENT(1);
        
        final int nativeInt;

        private TunaRepeatSelectType(int i) {
            this.nativeInt = i;
        }
    }

    public enum TunaRepeatShapeType {
        CUSTOM(0),
        CIRCLE(1);
        
        final int nativeInt;

        private TunaRepeatShapeType(int i) {
            this.nativeInt = i;
        }
    }

    public TunaRepeat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tunaTag = TunaRepeat.class.getSimpleName();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TunaRepeat);
        this.tunaTotal = obtainStyledAttributes.getInt(18, 0);
        int resourceId = obtainStyledAttributes.getResourceId(15, -1);
        if (resourceId != -1) {
            this.tunaStringArray = obtainStyledAttributes.getResources().getStringArray(resourceId);
            if (this.tunaTotal != this.tunaStringArray.length) {
                throw new IndexOutOfBoundsException("These two properties of tunaTotal and tunaRepeatItemTextValueArray must be the same length");
            }
        }
        this.tunaRepeatItemTextSize = obtainStyledAttributes.getDimension(14, 0.0f);
        int color = obtainStyledAttributes.getColor(10, 0);
        this.tunaRepeatItemTextColorNormal = color;
        this.tunaRepeatItemTextColorSelect = obtainStyledAttributes.getColor(11, color);
        this.tunaRepeatItemTextFractionTop = obtainStyledAttributes.getFraction(13, 1, 1, 0.0f);
        float fraction = obtainStyledAttributes.getFraction(12, 1, 1, 1.0f);
        this.tunaRepeatItemTextFractionBottom = fraction;
        if (fraction >= this.tunaRepeatItemTextFractionTop) {
            this.tunaRepeatItemFractionTop = obtainStyledAttributes.getFraction(6, 1, 1, 0.0f);
            float fraction2 = obtainStyledAttributes.getFraction(5, 1, 1, 1.0f);
            this.tunaRepeatItemFractionBottom = fraction2;
            if (fraction2 > this.tunaRepeatItemFractionTop) {
                obtainStyledAttributes.getColor(3, 0);
                obtainStyledAttributes.getColor(4, 0);
                int i = obtainStyledAttributes.getInt(17, -1);
                if (i >= 0) {
                    this.tunaRepeatShapeType = tunaRepeatShapeTypeArray[i];
                    if (TunaRepeatShapeType.CUSTOM == this.tunaRepeatShapeType) {
                        int resourceId2 = obtainStyledAttributes.getResourceId(0, 0);
                        if (resourceId2 != 0) {
                            this.tunaRepeatBitmapSrcNormal = BitmapFactory.decodeResource(getResources(), resourceId2);
                        }
                        int resourceId3 = obtainStyledAttributes.getResourceId(1, -1);
                        if (resourceId3 != -1) {
                            this.tunaRepeatBitmapSrcSelect = BitmapFactory.decodeResource(getResources(), resourceId3);
                        }
                    }
                    int i2 = obtainStyledAttributes.getInt(16, -1);
                    if (i2 >= 0) {
                        this.tunaRepeatSelectType = tunaRepeatSelectTypeArray[i2];
                        this.tunaRepeatCurrentIndex = obtainStyledAttributes.getInt(2, -1);
                        obtainStyledAttributes.recycle();
                        return;
                    }
                    throw new IllegalArgumentException("The content attribute require a property named tunaRepeatSelectType");
                }
                throw new IllegalArgumentException("The content attribute require a property named tunaRepeatShapeType");
            }
            throw new IndexOutOfBoundsException("The content attribute tunaRepeatItemFractionBottom must be greater than tunaRepeatItemFractionTop");
        }
        throw new IndexOutOfBoundsException("The content attribute tunaRepeatItemTextFractionBottom must be Equal to or greater than tunaRepeatItemTextFractionTop");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.tunaTotal >= 1) {
            this.tunaFloatArray = new float[this.tunaTotal];
        } else if (isInEditMode()) {
            this.tunaTotal = 5;
            this.tunaFloatArray = new float[this.tunaTotal];
        } else {
            throw new IndexOutOfBoundsException("The content attribute tunaRepeatTotal must be greater than or equal 1");
        }
        int i5 = this.tunaRepeatCurrentIndex;
        if (i5 < -1 || i5 > this.tunaTotal - 1) {
            throw new IndexOutOfBoundsException("The content attribute tunaRepeatCurrentIndex length must be not less than -1 and smaller than the tunaTotal length -1");
        }
        int width = this.tunaRepeatBitmapSrcNormal.getWidth();
        int height = this.tunaRepeatBitmapSrcNormal.getHeight();
        int width2 = this.tunaRepeatBitmapSrcSelect.getWidth();
        int height2 = this.tunaRepeatBitmapSrcSelect.getHeight();
        if (width == width2 && height == height2) {
            this.tunaSrcHeightScale = ((float) this.tunaHeight) * (this.tunaRepeatItemFractionBottom - this.tunaRepeatItemFractionTop);
            float f = (float) width;
            this.tunaSrcWidthScale = (this.tunaSrcHeightScale * f) / ((float) height);
            this.tunaScale = this.tunaSrcHeightScale / f;
            initTunaMatrix(this.tunaScale, this.tunaScale);
            this.tunaDx = ((float) this.tunaHeight) * this.tunaRepeatItemFractionTop;
            this.tunaSurplus = ((float) this.tunaWidth) - (this.tunaSrcWidthScale * ((float) this.tunaTotal));
            this.tunaShare = this.tunaSurplus / ((float) (this.tunaTotal + 1));
            for (int i6 = 0; i6 < this.tunaTotal; i6++) {
                this.tunaFloatArray[i6] = this.tunaShare + (this.tunaSrcWidthScale * 0.5f) + ((this.tunaShare + this.tunaSrcWidthScale) * ((float) i6));
            }
            if (this.tunaSubLayoutListener != null) {
                this.tunaSubLayoutListener.tunaSubLayout(this);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException("Both the width and height of the attribute tunaRepeatCustomBitmapSrcNormal and tunaRepeatCustomBitmapSrcSelect needed equal");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (C205974.$SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatShapeType[this.tunaRepeatShapeType.ordinal()] == 1) {
            for (int i = 0; i < this.tunaTotal; i++) {
                if (i == 0) {
                    canvas2.translate(this.tunaShare, this.tunaDx);
                } else {
                    canvas2.translate(this.tunaShare + this.tunaSrcWidthScale, 0.0f);
                }
                canvas2.drawBitmap(this.tunaRepeatBitmapSrcNormal, this.tunaMatrix, (Paint) null);
            }
            canvas2.translate(((this.tunaShare + this.tunaSrcWidthScale) * ((float) (1 - this.tunaTotal))) - this.tunaShare, -this.tunaDx);
            float f = 0.5f;
            if (this.tunaStringArray != null) {
                int i2 = 0;
                while (i2 < this.tunaStringArray.length) {
                    drawTunaText(canvas, this.tunaStringArray[i2], (float) this.tunaWidth, this.tunaFloatArray[i2], ((((float) this.tunaHeight) * this.tunaRepeatItemTextFractionTop) + (((float) this.tunaHeight) * this.tunaRepeatItemTextFractionBottom)) * f, 0.0f, 0.0f, initTunaTextPaint(Paint.Style.FILL, this.tunaRepeatItemTextColorNormal, this.tunaRepeatItemTextSize, Paint.Align.CENTER));
                    i2++;
                    f = 0.5f;
                }
            }
            if (this.tunaPress) {
                canvas.save();
                int i3 = C205974.$SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatSelectType[this.tunaRepeatSelectType.ordinal()];
                if (i3 == 1) {
                    canvas2.clipRect(0.0f, 0.0f, this.tunaRepeatCurrentX, (float) this.tunaHeight);
                } else if (i3 == 2) {
                    canvas2.clipRect(this.tunaRepeatCurrentX - this.tunaSrcWidthScale, 0.0f, this.tunaRepeatCurrentX, (float) this.tunaHeight);
                }
                for (int i4 = 0; i4 < this.tunaTotal; i4++) {
                    if (i4 == 0) {
                        canvas2.translate(this.tunaShare, this.tunaDx);
                    } else {
                        canvas2.translate(this.tunaShare + this.tunaSrcWidthScale, 0.0f);
                    }
                    canvas2.drawBitmap(this.tunaRepeatBitmapSrcSelect, this.tunaMatrix, (Paint) null);
                }
                canvas2.translate(((this.tunaShare + this.tunaSrcWidthScale) * ((float) (1 - this.tunaTotal))) - this.tunaShare, -this.tunaDx);
                if (this.tunaStringArray != null) {
                    for (int i5 = 0; i5 < this.tunaStringArray.length; i5++) {
                        drawTunaText(canvas, this.tunaStringArray[i5], (float) this.tunaWidth, this.tunaFloatArray[i5], ((((float) this.tunaHeight) * this.tunaRepeatItemTextFractionTop) + (((float) this.tunaHeight) * this.tunaRepeatItemTextFractionBottom)) * 0.5f, 0.0f, 0.0f, initTunaTextPaint(Paint.Style.FILL, this.tunaRepeatItemTextColorSelect, this.tunaRepeatItemTextSize, Paint.Align.CENTER));
                    }
                }
                canvas.restore();
                return;
            }
            int i6 = 0;
            while (i6 < this.tunaTotal) {
                if (i6 == 0) {
                    canvas2.translate(this.tunaShare, this.tunaDx);
                } else {
                    canvas2.translate(this.tunaShare + this.tunaSrcWidthScale, 0.0f);
                }
                canvas2.drawBitmap((this.tunaRepeatSelectType != TunaRepeatSelectType.CONNECT ? i6 != this.tunaRepeatCurrentIndex : i6 > this.tunaRepeatCurrentIndex) ? this.tunaRepeatBitmapSrcNormal : this.tunaRepeatBitmapSrcSelect, this.tunaMatrix, (Paint) null);
                i6++;
            }
            canvas2.translate(((this.tunaShare + this.tunaSrcWidthScale) * ((float) (1 - this.tunaTotal))) - this.tunaShare, -this.tunaDx);
            if (this.tunaStringArray != null) {
                int i7 = 0;
                while (i7 < this.tunaStringArray.length) {
                    drawTunaText(canvas, this.tunaStringArray[i7], (float) this.tunaWidth, this.tunaFloatArray[i7], ((((float) this.tunaHeight) * this.tunaRepeatItemTextFractionTop) + (((float) this.tunaHeight) * this.tunaRepeatItemTextFractionBottom)) * 0.5f, 0.0f, 0.0f, initTunaTextPaint(Paint.Style.FILL, (this.tunaRepeatSelectType != TunaRepeatSelectType.CONNECT ? i7 != this.tunaRepeatCurrentIndex : i7 > this.tunaRepeatCurrentIndex) ? this.tunaRepeatItemTextColorNormal : this.tunaRepeatItemTextColorSelect, this.tunaRepeatItemTextSize, Paint.Align.CENTER));
                    i7++;
                }
            }
        }
    }

    /* renamed from: com.tunasashimi.tuna.TunaRepeat$4 */
    static /* synthetic */ class C205974 {
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatSelectType;
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatShapeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        static {
            /*
                com.tunasashimi.tuna.TunaRepeat$TunaRepeatShapeType[] r0 = com.tunasashimi.tuna.TunaRepeat.TunaRepeatShapeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatShapeType = r0
                r1 = 1
                com.tunasashimi.tuna.TunaRepeat$TunaRepeatShapeType r2 = com.tunasashimi.tuna.TunaRepeat.TunaRepeatShapeType.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.tunasashimi.tuna.TunaRepeat$TunaRepeatSelectType[] r0 = com.tunasashimi.tuna.TunaRepeat.TunaRepeatSelectType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatSelectType = r0
                com.tunasashimi.tuna.TunaRepeat$TunaRepeatSelectType r2 = com.tunasashimi.tuna.TunaRepeat.TunaRepeatSelectType.CONNECT     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaRepeat$TunaRepeatSelectType     // Catch:{ NoSuchFieldError -> 0x002e }
                com.tunasashimi.tuna.TunaRepeat$TunaRepeatSelectType r1 = com.tunasashimi.tuna.TunaRepeat.TunaRepeatSelectType.CURRENT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaRepeat.C205974.<clinit>():void");
        }
    }

    public float getTunaRepeatCurrentX() {
        return this.tunaFloatArray[this.tunaRepeatCurrentIndex];
    }

    public void setTunaRepeatCurrentX(float f) {
        setTunaRepeatCurrentX(f, false);
    }

    public void setTunaRepeatCurrentX(int i, float f) {
        setTunaRepeatCurrentX(i, f, false);
    }

    public void setTunaRepeatCurrentX(float f, boolean z) {
        setTunaRepeatCurrentX(1, f, z);
    }

    public void setTunaRepeatCurrentX(int i, float f, boolean z) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setTunaRepeatCurrentXRaw(applyDimension(i, f, resources.getDisplayMetrics()), z);
    }

    private void setTunaRepeatCurrentXRaw(float f, boolean z) {
        this.tunaRepeatCurrentX = f;
        float f2 = (float) this.tunaWidth;
        int i = 0;
        while (i < this.tunaTotal) {
            float abs = Math.abs(f - this.tunaFloatArray[i]);
            if (abs >= f2) {
                break;
            }
            this.tunaRepeatCurrentIndex = i;
            i++;
            f2 = abs;
        }
        if (z) {
            invalidate();
        }
    }

    public int getTunaRepeatCurrentIndex() {
        return this.tunaRepeatCurrentIndex;
    }

    public void setTunaRepeatCurrentIndex(int i) {
        if (i < -1 || i > this.tunaTotal - 1) {
            throw new IndexOutOfBoundsException("The content attribute tunaRepeatCurrentIndex length must be not less than -1 and smaller than the tunaTotal length -1");
        }
        this.tunaRepeatCurrentIndex = i;
        invalidate();
    }

    public float[] getTunaRepeatCentreXArray() {
        return this.tunaFloatArray;
    }

    public void setTunaRepeatCentreXArray(float[] fArr) {
        this.tunaFloatArray = fArr;
    }

    public int getTunaRepeatTotal() {
        return this.tunaTotal;
    }

    public void setTunaRepeatTotal(int i) {
        this.tunaTotal = i;
        invalidate();
    }

    public String[] getTunaRepeatItemTextValueArray() {
        return this.tunaStringArray;
    }

    public void setTunaRepeatItemTextValueArray(String[] strArr) {
        this.tunaStringArray = strArr;
    }

    public void tunaSlide(TunaView.TunaTouchListener tunaTouchListener, final TunaView.TunaTouchDownListener tunaTouchDownListener, final TunaView.TunaTouchUpListener tunaTouchUpListener) {
        setTunaTouchListener(tunaTouchListener);
        setTunaTouchDownListener(tunaTouchDownListener);
        setTunaTouchUpListener(tunaTouchUpListener);
        setTunaTouchCancelListener(new TunaView.TunaTouchCancelListener() {
            public void tunaTouchCancel(View view) {
                TunaView.TunaTouchUpListener tunaTouchUpListener = tunaTouchUpListener;
                if (tunaTouchUpListener != null) {
                    tunaTouchUpListener.tunaTouchUp(TunaRepeat.this);
                }
            }
        });
        setTunaTouchOutListener(new TunaView.TunaTouchOutListener() {
            public void tunaTouchOut(View view) {
                TunaView.TunaTouchUpListener tunaTouchUpListener = tunaTouchUpListener;
                if (tunaTouchUpListener != null) {
                    tunaTouchUpListener.tunaTouchUp(TunaRepeat.this);
                }
            }
        });
        setTunaTouchInListener(new TunaView.TunaTouchInListener() {
            public void tunaTouchIn(View view) {
                TunaView.TunaTouchDownListener tunaTouchDownListener = tunaTouchDownListener;
                if (tunaTouchDownListener != null) {
                    tunaTouchDownListener.tunaTouchDown(TunaRepeat.this);
                }
            }
        });
    }
}
