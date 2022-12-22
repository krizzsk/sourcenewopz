package com.tunasashimi.tuna;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.publicservice.network.INonRpcInterceptor;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class TunaDownload extends TunaView {
    public static final int BOTTOM = 8;
    private static final int BUF_SIZE = 1024;
    public static final int CENTER = 5;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 4;
    private static final int DOWN_COMPLETE = 2;
    private static final int DOWN_ERROR = 4;
    private static final int DOWN_EXIST = 3;
    private static final int DOWN_START = 0;
    private static final int DOWN_UPDATE = 1;
    public static final int GRAVITY_MASK = 15;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    private static final int TIMEOUT = 10000;
    public static final int TOP = 0;
    private static final String TUNADOWN_LOADSUFFIX = ".tmp";
    private static final PorterDuff.Mode[] tunaDownloadPorterDuffXfermodeArray = {PorterDuff.Mode.SRC_IN, PorterDuff.Mode.SRC_OUT};
    private static final TunaDownloadType[] tunaDownloadTypeArray = {TunaDownloadType.TENSILE, TunaDownloadType.ORIGINAL, TunaDownloadType.FIT_X, TunaDownloadType.FIT_Y};
    /* access modifiers changed from: private */
    public String graphicsType;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public boolean tunaDownInterceptFlag;
    private int tunaDownloadBackgroundNormal;
    private boolean tunaDownloadCacheCheck;
    private String tunaDownloadCacheFolder;
    /* access modifiers changed from: private */
    public String tunaDownloadCacheFolderDirectory;
    protected TunaDownloadCompleteListener tunaDownloadCompleteListener;
    private float tunaDownloadContentFractionVertical;
    private int tunaDownloadContentMarkBackgroundNormal;
    private float tunaDownloadContentMarkFractionVertical;
    private float tunaDownloadContentMarkRadius;
    private float tunaDownloadContentMarkStrokeWidth;
    private int tunaDownloadContentMarkTextColorNormal;
    private float tunaDownloadContentMarkTextSize;
    private String tunaDownloadContentMarkTextValue;
    private int tunaDownloadContentTextColorNormal;
    private float tunaDownloadContentTextSize;
    private String tunaDownloadContentTextValue;
    /* access modifiers changed from: private */
    public boolean tunaDownloadError;
    private float tunaDownloadGraphicsScaleX;
    private float tunaDownloadGraphicsScaleY;
    private int tunaDownloadGraphicsSrcBackId;
    private int tunaDownloadGraphicsSrcDownloadHeight;
    private int tunaDownloadGraphicsSrcDownloadWidth;
    private float tunaDownloadGraphicsSrcFillFractionBottom;
    private float tunaDownloadGraphicsSrcFillFractionTop;
    private int tunaDownloadGraphicsSrcFillHeight;
    private int tunaDownloadGraphicsSrcFillId;
    private int tunaDownloadGraphicsSrcFillWidth;
    private float tunaDownloadGraphicsSrcFrontFractionBottom;
    private float tunaDownloadGraphicsSrcFrontFractionTop;
    private int tunaDownloadGraphicsSrcFrontHeight;
    private int tunaDownloadGraphicsSrcFrontId;
    private int tunaDownloadGraphicsSrcFrontWidth;
    /* access modifiers changed from: private */
    public String tunaDownloadGraphicsSrcURL;
    /* access modifiers changed from: private */
    public String tunaDownloadGraphicsSrcURLIndex;
    private int tunaDownloadGraphicsSrcURLRequestHeight;
    private int tunaDownloadGraphicsSrcURLRequestWidth;
    private boolean tunaDownloadMark;
    private int tunaDownloadMarkGraphicsId;
    private float tunaDownloadMarkGraphicsSrcWidth;
    private int tunaDownloadMarkGravity;
    /* access modifiers changed from: private */
    public float tunaDownloadPercent;
    protected PorterDuffXfermode tunaDownloadPorterDuffXfermode;
    private float tunaDownloadRadius;
    private float tunaDownloadRadiusLeftBottom;
    private float tunaDownloadRadiusLeftTop;
    private float tunaDownloadRadiusRightBottom;
    private float tunaDownloadRadiusRightTop;
    private float tunaDownloadTitleFractionVertical;
    private int tunaDownloadTitleTextColorNormal;
    private float tunaDownloadTitleTextSize;
    private String tunaDownloadTitleTextValue;
    private TunaDownloadType tunaDownloadType;
    /* access modifiers changed from: private */
    public File tunaDownloadfile;

    public interface TunaDownloadCompleteListener {
        void tunaDownloadComplete();
    }

    public float getTunaDownloadPercent() {
        return this.tunaDownloadPercent;
    }

    public void setTunaDownloadPercent(float f) {
        this.tunaDownloadPercent = f;
        if (this.tunaDownloadGraphicsSrcFrontId != -1) {
            invalidate();
        }
    }

    public String getTunaDownloadCacheFolder() {
        return this.tunaDownloadCacheFolder;
    }

    public void setTunaDownloadCacheFolder(String str) {
        this.tunaDownloadCacheFolder = str;
    }

    public boolean isTunaDownloadCacheCheck() {
        return this.tunaDownloadCacheCheck;
    }

    public void setTunaDownloadCacheCheck(boolean z) {
        this.tunaDownloadCacheCheck = z;
    }

    public float getTunaDownloadRadius() {
        return this.tunaDownloadRadius;
    }

    public void setTunaDownloadRadius(float f) {
        setTunaDownloadRadius(1, f);
    }

    public void setTunaDownloadRadius(int i, float f) {
        setTunaDownloadRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaDownloadRadiusRaw(float f) {
        if (this.tunaDownloadRadius != f) {
            this.tunaDownloadRadius = f;
            invalidate();
        }
    }

    public float getTunaDownloadRadiusLeftTop() {
        return this.tunaDownloadRadiusLeftTop;
    }

    public void setTunaDownloadRadiusLeftTop(float f) {
        setTunaDownloadRadiusLeftTop(1, f);
    }

    public void setTunaDownloadRadiusLeftTop(int i, float f) {
        setTunaDownloadRadiusLeftTopRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaDownloadRadiusLeftTopRaw(float f) {
        if (this.tunaDownloadRadiusLeftTop != f) {
            this.tunaDownloadRadiusLeftTop = f;
            invalidate();
        }
    }

    public float getTunaDownloadRadiusLeftBottom() {
        return this.tunaDownloadRadiusLeftBottom;
    }

    public void setTunaRadiusLeftBottom(float f) {
        setTunaDownloadRadiusLeftBottom(1, f);
    }

    public void setTunaDownloadRadiusLeftBottom(int i, float f) {
        setTunaDownloadRadiusLeftBottomRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaDownloadRadiusLeftBottomRaw(float f) {
        if (this.tunaDownloadRadiusLeftBottom != f) {
            this.tunaDownloadRadiusLeftBottom = f;
            invalidate();
        }
    }

    public float getTunaDownloadRadiusRightTop() {
        return this.tunaDownloadRadiusRightTop;
    }

    public void setDownloadRadiusRightTop(float f) {
        setTunaDownloadRadiusRightTop(1, f);
    }

    public void setTunaDownloadRadiusRightTop(int i, float f) {
        setTunaDownloadRadiusRightTopRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaDownloadRadiusRightTopRaw(float f) {
        if (this.tunaDownloadRadiusRightTop != f) {
            this.tunaDownloadRadiusRightTop = f;
            invalidate();
        }
    }

    public float getTunaDownloadRadiusRightBottom() {
        return this.tunaDownloadRadiusRightBottom;
    }

    public void setTunaDownloadRadiusRightBottom(float f) {
        setTunaDownloadRadiusRightBottom(1, f);
    }

    public void setTunaDownloadRadiusRightBottom(int i, float f) {
        setTunaDownloadRadiusRightBottomRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaDownloadRadiusRightBottomRaw(float f) {
        if (this.tunaDownloadRadiusRightBottom != f) {
            this.tunaDownloadRadiusRightBottom = f;
            invalidate();
        }
    }

    public boolean isTunaDownloadError() {
        return this.tunaDownloadError;
    }

    public void setTunaDownloadError(boolean z) {
        this.tunaDownloadError = z;
        invalidate();
    }

    public boolean isTunaDownInterceptFlag() {
        return this.tunaDownInterceptFlag;
    }

    public void setTunaDownInterceptFlag(boolean z) {
        this.tunaDownInterceptFlag = z;
    }

    public float getTunaDownloadGraphicsSrcFillFractionTop() {
        return this.tunaDownloadGraphicsSrcFillFractionTop;
    }

    public void setTunaDownloadGraphicsSrcFillFractionTop(float f) {
        this.tunaDownloadGraphicsSrcFillFractionTop = f;
        invalidate();
    }

    public float getTunaDownloadGraphicsSrcFillFractionBottom() {
        return this.tunaDownloadGraphicsSrcFillFractionBottom;
    }

    public void setTunaDownloadGraphicsSrcFillFractionBottom(float f) {
        this.tunaDownloadGraphicsSrcFillFractionBottom = f;
        invalidate();
    }

    public boolean isTunaDownloadMark() {
        return this.tunaDownloadMark;
    }

    public void setTunaDownloadMark(boolean z) {
        this.tunaDownloadMark = z;
        invalidate();
    }

    public int getTunaDownloadMarkGravity() {
        return this.tunaDownloadMarkGravity;
    }

    public void setSrcAnchorGravity(int i) {
        this.tunaDownloadMarkGravity = i;
        invalidate();
    }

    public float getTunaDownloadGraphicsSrcFrontFractionTop() {
        return this.tunaDownloadGraphicsSrcFrontFractionTop;
    }

    public void setTunaDownloadGraphicsSrcFrontFractionTop(float f) {
        this.tunaDownloadGraphicsSrcFrontFractionTop = f;
        invalidate();
    }

    public float getTunaDownloadGraphicsSrcFrontFractionBottom() {
        return this.tunaDownloadGraphicsSrcFrontFractionBottom;
    }

    public void setTunaDownloadGraphicsSrcFrontFractionBottom(float f) {
        this.tunaDownloadGraphicsSrcFrontFractionBottom = f;
        invalidate();
    }

    public float getTunaDownloadTitleFractionVertical() {
        return this.tunaDownloadTitleFractionVertical;
    }

    public void setTunaDownloadTitleFractionVertical(float f) {
        this.tunaDownloadTitleFractionVertical = f;
        invalidate();
    }

    public float getTunaDownloadContentFractionVertical() {
        return this.tunaDownloadContentFractionVertical;
    }

    public void setTunaDownloadContentFractionVertical(float f) {
        this.tunaDownloadContentFractionVertical = f;
        invalidate();
    }

    public String getTunaDownloadContentMarkTextValue() {
        return this.tunaDownloadContentMarkTextValue;
    }

    public void setTunaDownloadContentMarkTextValue(String str) {
        this.tunaDownloadContentMarkTextValue = str;
        invalidate();
    }

    public float getTunaDownloadContentMarkFractionVertical() {
        return this.tunaDownloadContentMarkFractionVertical;
    }

    public void setTunaDownloadContentMarkFractionVertical(float f) {
        this.tunaDownloadContentMarkFractionVertical = f;
        invalidate();
    }

    public int getTunaDownloadGraphicsSrcURLRequestWidth() {
        return this.tunaDownloadGraphicsSrcURLRequestWidth;
    }

    public void setTunaDownloadGraphicsSrcURLRequestWidth(int i) {
        this.tunaDownloadGraphicsSrcURLRequestWidth = i;
        requestLayout();
    }

    public int getTunaDownloadGraphicsSrcURLRequestHeight() {
        return this.tunaDownloadGraphicsSrcURLRequestHeight;
    }

    public void setTunaDownloadGraphicsSrcURLRequestHeight(int i) {
        this.tunaDownloadGraphicsSrcURLRequestHeight = i;
        requestLayout();
    }

    public void setTunaDownloadGraphicsSrcURLRequestWidthHeight(int i, int i2) {
        this.tunaDownloadGraphicsSrcURLRequestWidth = i;
        this.tunaDownloadGraphicsSrcURLRequestHeight = i2;
        requestLayout();
    }

    public enum TunaDownloadType {
        TENSILE(0),
        ORIGINAL(1),
        FIT_X(2),
        FIT_Y(3);
        
        final int nativeInt;

        private TunaDownloadType(int i) {
            this.nativeInt = i;
        }
    }

    public enum TunaDownloadPorterDuffXfermode {
        SRC_IN(0),
        SRC_OUT(1);
        
        final int nativeInt;

        private TunaDownloadPorterDuffXfermode(int i) {
            this.nativeInt = i;
        }
    }

    public PorterDuffXfermode getTunaDownloadPorterDuffXfermode() {
        return this.tunaPorterDuffXfermode;
    }

    public void setTunaDownloadPorterDuffXfermode(TunaDownloadPorterDuffXfermode tunaDownloadPorterDuffXfermode2) {
        this.tunaDownloadPorterDuffXfermode = new PorterDuffXfermode(tunaDownloadPorterDuffXfermodeArray[tunaDownloadPorterDuffXfermode2.nativeInt]);
    }

    public TunaDownloadCompleteListener getTunaDownloadCompleteListener() {
        return this.tunaDownloadCompleteListener;
    }

    public void setTunaDownloadCompleteListener(TunaDownloadCompleteListener tunaDownloadCompleteListener2) {
        this.tunaDownloadCompleteListener = tunaDownloadCompleteListener2;
    }

    public TunaDownload(Context context) {
        this(context, (AttributeSet) null);
    }

    public TunaDownload(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TunaDownload(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler() {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    boolean unused = TunaDownload.this.tunaDownloadError = false;
                    TunaDownload.this.getTunaDownloadGraphicsSrc();
                } else if (i == 1) {
                    TunaDownload tunaDownload = TunaDownload.this;
                    tunaDownload.setTunaDownloadPercent(tunaDownload.tunaDownloadPercent);
                } else if (i == 2) {
                    if (TunaDownload.this.tunaDownloadCompleteListener != null) {
                        TunaDownload.this.tunaDownloadCompleteListener.tunaDownloadComplete();
                    }
                    TunaDownload.this.invalidate();
                } else if (i != 3) {
                    if (i == 4) {
                        TunaDownload.this.setTunaDownloadError(true);
                    }
                } else if (TunaDownload.this.tunaDownloadCompleteListener != null) {
                    TunaDownload.this.tunaDownloadCompleteListener.tunaDownloadComplete();
                }
            }
        };
        this.tunaTag = TunaDownload.class.getSimpleName();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TunaDownload);
        this.tunaDownloadCacheFolder = obtainStyledAttributes.getString(2);
        this.tunaDownloadCacheCheck = obtainStyledAttributes.getBoolean(1, false);
        int i2 = obtainStyledAttributes.getInt(37, 0);
        if (i2 >= 0) {
            this.tunaDownloadType = tunaDownloadTypeArray[i2];
        }
        this.tunaDownloadBackgroundNormal = obtainStyledAttributes.getColor(0, 0);
        this.tunaDownloadGraphicsSrcFillId = obtainStyledAttributes.getResourceId(15, -1);
        this.tunaDownloadGraphicsSrcFillFractionTop = obtainStyledAttributes.getFraction(17, 1, 1, 0.0f);
        float fraction = obtainStyledAttributes.getFraction(16, 1, 1, 1.0f);
        this.tunaDownloadGraphicsSrcFillFractionBottom = fraction;
        if (fraction - this.tunaDownloadGraphicsSrcFillFractionTop > 0.0f) {
            int resourceId = obtainStyledAttributes.getResourceId(24, -1);
            if (resourceId != -1) {
                this.tunaDownloadMarkGraphicsId = resourceId;
                this.tunaDownloadMark = obtainStyledAttributes.getBoolean(23, false);
                this.tunaDownloadMarkGraphicsSrcWidth = obtainStyledAttributes.getDimension(25, 0.0f);
                this.tunaDownloadMarkGravity = obtainStyledAttributes.getInt(26, 0);
            }
            this.tunaDownloadGraphicsSrcFrontId = obtainStyledAttributes.getResourceId(18, -1);
            this.tunaDownloadGraphicsSrcBackId = obtainStyledAttributes.getResourceId(14, -1);
            this.tunaDownloadGraphicsSrcFrontFractionTop = obtainStyledAttributes.getFraction(20, 1, 1, 0.0f);
            float fraction2 = obtainStyledAttributes.getFraction(19, 1, 1, 1.0f);
            this.tunaDownloadGraphicsSrcFrontFractionBottom = fraction2;
            if (fraction2 - this.tunaDownloadGraphicsSrcFrontFractionTop > 0.0f) {
                this.tunaDownloadTitleTextValue = obtainStyledAttributes.getString(36);
                this.tunaDownloadTitleTextSize = obtainStyledAttributes.getDimension(35, 0.0f);
                this.tunaDownloadTitleTextColorNormal = obtainStyledAttributes.getColor(34, 0);
                this.tunaDownloadTitleFractionVertical = obtainStyledAttributes.getFraction(33, 1, 1, 0.0f);
                this.tunaDownloadContentTextValue = obtainStyledAttributes.getString(13);
                this.tunaDownloadContentTextSize = obtainStyledAttributes.getDimension(12, 0.0f);
                this.tunaDownloadContentTextColorNormal = obtainStyledAttributes.getColor(11, 0);
                this.tunaDownloadContentFractionVertical = obtainStyledAttributes.getFraction(3, 1, 1, 0.0f);
                this.tunaDownloadContentMarkTextValue = obtainStyledAttributes.getString(10);
                this.tunaDownloadContentMarkTextSize = obtainStyledAttributes.getDimension(9, 0.0f);
                this.tunaDownloadContentMarkTextColorNormal = obtainStyledAttributes.getColor(8, 0);
                this.tunaDownloadContentMarkFractionVertical = obtainStyledAttributes.getFraction(5, 1, 1, 0.0f);
                this.tunaDownloadContentMarkBackgroundNormal = obtainStyledAttributes.getColor(4, 0);
                this.tunaDownloadContentMarkStrokeWidth = obtainStyledAttributes.getDimension(7, 0.0f);
                this.tunaDownloadContentMarkRadius = obtainStyledAttributes.getDimension(6, 0.0f);
                this.tunaDownloadGraphicsSrcURLRequestWidth = obtainStyledAttributes.getInt(22, 0);
                this.tunaDownloadGraphicsSrcURLRequestHeight = obtainStyledAttributes.getInt(21, 0);
                this.tunaDownloadRadius = obtainStyledAttributes.getDimension(28, 0.0f);
                this.tunaDownloadRadiusLeftTop = obtainStyledAttributes.getDimension(30, 0.0f);
                this.tunaDownloadRadiusLeftBottom = obtainStyledAttributes.getDimension(29, 0.0f);
                this.tunaDownloadRadiusRightTop = obtainStyledAttributes.getDimension(32, 0.0f);
                float dimension = obtainStyledAttributes.getDimension(31, 0.0f);
                this.tunaDownloadRadiusRightBottom = dimension;
                if (this.tunaDownloadRadius > 0.0f || this.tunaDownloadRadiusLeftTop > 0.0f || this.tunaDownloadRadiusLeftBottom > 0.0f || this.tunaDownloadRadiusRightTop > 0.0f || dimension > 0.0f) {
                    this.tunaDownloadPorterDuffXfermode = new PorterDuffXfermode(tunaDownloadPorterDuffXfermodeArray[obtainStyledAttributes.getInt(27, 0)]);
                }
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalArgumentException("The content attribute tunaDownloadGraphicsSrcFrontFractionBottom must be greater than tunaDownloadGraphicsSrcFrontFractionTop");
        }
        throw new IllegalArgumentException("The content attribute tunaDownloadGraphicsSrcFillFractionBottom must be greater than tunaDownloadGraphicsSrcFillFractionTop");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        float f3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            if (!(this.tunaDownloadGraphicsSrcURLRequestWidth == 0 && this.tunaDownloadGraphicsSrcURLRequestHeight == 0)) {
                f = ((float) size) / ((((float) this.tunaDownloadGraphicsSrcURLRequestWidth) * 1.0f) / ((float) this.tunaDownloadGraphicsSrcURLRequestHeight));
                f2 = this.tunaDownloadGraphicsSrcFillFractionBottom;
                f3 = this.tunaDownloadGraphicsSrcFillFractionTop;
            }
            size2 = size;
            setMeasuredDimension(size, size2);
        }
        if (mode != 1073741824) {
            if (mode == 0 && !(this.tunaDownloadGraphicsSrcURLRequestWidth == 0 && this.tunaDownloadGraphicsSrcURLRequestHeight == 0)) {
                f = ((float) size) / ((((float) this.tunaDownloadGraphicsSrcURLRequestWidth) * 1.0f) / ((float) this.tunaDownloadGraphicsSrcURLRequestHeight));
                f2 = this.tunaDownloadGraphicsSrcFillFractionBottom;
                f3 = this.tunaDownloadGraphicsSrcFillFractionTop;
            }
            size2 = size;
        }
        setMeasuredDimension(size, size2);
        size2 = (int) (f / (f2 - f3));
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setScaleType(TunaDownloadType tunaDownloadType2) {
        this.tunaDownloadType = tunaDownloadType2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x037e, code lost:
        r6 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03af, code lost:
        r6 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03b0, code lost:
        r7 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b1, code lost:
        r10.translate(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03b9, code lost:
        if (r9.tunaDownloadRadius <= 0.0f) goto L_0x03d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x03bb, code lost:
        r10.drawBitmap(getCustomRoundBitmap(getScaleBitmap(r0, r3), r2[0], r2[1], r2[2], r2[3]), 0.0f, 0.0f, (android.graphics.Paint) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03d1, code lost:
        r10.drawBitmap(r0, initTunaMatrix(r3, r3), new android.graphics.Paint(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03de, code lost:
        r10.translate(-r6, -r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x036c, code lost:
        r6 = r7;
        r7 = r8 - (r5 * r12);
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r9 = r16
            r10 = r17
            java.lang.String r0 = r9.graphicsType
            java.lang.String r1 = "GIF"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            goto L_0x049f
        L_0x0010:
            float r0 = r9.tunaDownloadRadius
            r11 = 0
            r12 = 1
            r13 = 0
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0034
            float r0 = r9.tunaDownloadRadiusLeftTop
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0034
            float r0 = r9.tunaDownloadRadiusLeftBottom
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0034
            float r0 = r9.tunaDownloadRadiusRightTop
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0034
            float r0 = r9.tunaDownloadRadiusRightBottom
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r14 = 0
            goto L_0x0035
        L_0x0034:
            r14 = 1
        L_0x0035:
            r15 = -1
            if (r14 == 0) goto L_0x009c
            r1 = 0
            r2 = 0
            int r0 = r9.tunaWidth
            float r3 = (float) r0
            int r0 = r9.tunaHeight
            float r4 = (float) r0
            r5 = 0
            r6 = 31
            r0 = r17
            int r0 = r0.saveLayer(r1, r2, r3, r4, r5, r6)
            r9.tunaLayer = r0
            int r0 = r9.tunaDownloadBackgroundNormal
            if (r0 != 0) goto L_0x0051
            r9.tunaDownloadBackgroundNormal = r15
        L_0x0051:
            float r0 = r9.tunaDownloadRadius
            float r1 = r9.tunaDownloadRadiusLeftTop
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x006d
            float r0 = r9.tunaDownloadRadiusLeftBottom
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x006d
            float r1 = r9.tunaDownloadRadiusRightTop
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x006d
            float r0 = r9.tunaDownloadRadiusRightBottom
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x006d
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            r9.tunaClassic = r0
            boolean r0 = r9.tunaClassic
            if (r0 == 0) goto L_0x0086
            int r0 = r9.tunaWidth
            float r2 = (float) r0
            int r0 = r9.tunaHeight
            float r3 = (float) r0
            int r4 = r9.tunaDownloadBackgroundNormal
            float r5 = r9.tunaDownloadRadius
            r0 = r16
            r1 = r17
            r0.drawTunaRectClassic(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x0086:
            int r2 = r9.tunaWidth
            int r3 = r9.tunaHeight
            int r4 = r9.tunaDownloadBackgroundNormal
            float r5 = r9.tunaDownloadRadiusLeftTop
            float r6 = r9.tunaDownloadRadiusLeftBottom
            float r7 = r9.tunaDownloadRadiusRightTop
            float r8 = r9.tunaDownloadRadiusRightBottom
            r0 = r16
            r1 = r17
            r0.drawTunaRectCustom(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00a3
        L_0x009c:
            int r0 = r9.tunaDownloadBackgroundNormal
            if (r0 == 0) goto L_0x00a3
            r10.drawColor(r0)
        L_0x00a3:
            if (r14 == 0) goto L_0x00ac
            android.graphics.Paint r0 = r9.tunaPaint
            android.graphics.PorterDuffXfermode r1 = r9.tunaDownloadPorterDuffXfermode
            r0.setXfermode(r1)
        L_0x00ac:
            java.lang.String r0 = r9.graphicsType
            java.lang.String r1 = "PNG"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0103
            java.lang.String r0 = r9.graphicsType
            java.lang.String r2 = "JPG"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c2
            goto L_0x0103
        L_0x00c2:
            java.lang.String r0 = r9.tunaDownloadGraphicsSrcURLIndex
            if (r0 == 0) goto L_0x0101
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r9.tunaDownloadCacheFolderDirectory
            r0.append(r2)
            java.lang.String r2 = r9.tunaDownloadGraphicsSrcURLIndex
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            int r2 = r9.tunaDownloadGraphicsSrcURLRequestWidth
            int r3 = r9.tunaDownloadGraphicsSrcURLRequestHeight
            android.graphics.Bitmap r0 = r9.decodeBitmapFile(r0, r2, r3)
            if (r0 != 0) goto L_0x013d
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.tunaDownloadCacheFolderDirectory
            r3.append(r4)
            java.lang.String r4 = r9.tunaDownloadGraphicsSrcURLIndex
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r2.delete()
            r9.graphicsType = r1
            goto L_0x013d
        L_0x0101:
            r0 = r1
            goto L_0x013d
        L_0x0103:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r9.tunaDownloadCacheFolderDirectory
            r0.append(r2)
            java.lang.String r2 = r9.tunaDownloadGraphicsSrcURLIndex
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            int r2 = r9.tunaDownloadGraphicsSrcURLRequestWidth
            int r3 = r9.tunaDownloadGraphicsSrcURLRequestHeight
            android.graphics.Bitmap r0 = r9.decodeBitmapFile(r0, r2, r3)
            if (r0 != 0) goto L_0x013d
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.tunaDownloadCacheFolderDirectory
            r3.append(r4)
            java.lang.String r4 = r9.tunaDownloadGraphicsSrcURLIndex
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r2.delete()
            r9.graphicsType = r1
        L_0x013d:
            r2 = 4
            r3 = 2
            r4 = 3
            r5 = 1065353216(0x3f800000, float:1.0)
            r14 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x0205
            android.os.Handler r6 = r9.mHandler
            r6.sendEmptyMessage(r4)
            int r6 = r0.getWidth()
            r9.tunaDownloadGraphicsSrcDownloadWidth = r6
            int r6 = r0.getHeight()
            r9.tunaDownloadGraphicsSrcDownloadHeight = r6
            int r6 = r9.tunaHeight
            float r6 = (float) r6
            float r7 = r9.tunaDownloadGraphicsSrcFillFractionBottom
            float r8 = r9.tunaDownloadGraphicsSrcFillFractionTop
            float r7 = r7 - r8
            float r6 = r6 * r7
            int r7 = r9.tunaDownloadGraphicsSrcDownloadHeight
            float r7 = (float) r7
            float r6 = r6 / r7
            r9.tunaDownloadGraphicsScaleY = r6
            int r6 = r9.tunaHeight
            float r6 = (float) r6
            float r7 = r9.tunaDownloadGraphicsSrcFillFractionTop
            float r6 = r6 * r7
            int[] r7 = com.tunasashimi.tuna.TunaDownload.C205935.$SwitchMap$com$tunasashimi$tuna$TunaDownload$TunaDownloadType
            com.tunasashimi.tuna.TunaDownload$TunaDownloadType r8 = r9.tunaDownloadType
            int r8 = r8.ordinal()
            r7 = r7[r8]
            if (r7 == r12) goto L_0x01e4
            if (r7 == r3) goto L_0x01c2
            if (r7 == r4) goto L_0x01a3
            if (r7 == r2) goto L_0x0182
            goto L_0x02e4
        L_0x0182:
            int r5 = r9.tunaWidth
            float r5 = (float) r5
            int r6 = r9.tunaDownloadGraphicsSrcDownloadWidth
            float r6 = (float) r6
            float r7 = r9.tunaDownloadGraphicsScaleY
            float r6 = r6 * r7
            float r5 = r5 - r6
            float r5 = r5 * r14
            r10.translate(r5, r13)
            float r6 = r9.tunaDownloadGraphicsScaleY
            android.graphics.Matrix r6 = r9.initTunaMatrix(r6, r6)
            android.graphics.Paint r7 = r9.tunaPaint
            r10.drawBitmap(r0, r6, r7)
            float r0 = -r5
            r10.translate(r0, r13)
            goto L_0x02e4
        L_0x01a3:
            int r7 = r9.tunaWidth
            float r7 = (float) r7
            float r7 = r7 * r5
            int r5 = r9.tunaDownloadGraphicsSrcDownloadWidth
            float r5 = (float) r5
            float r7 = r7 / r5
            r9.tunaDownloadGraphicsScaleX = r7
            r10.translate(r13, r6)
            float r5 = r9.tunaDownloadGraphicsScaleX
            android.graphics.Matrix r5 = r9.initTunaMatrix(r5, r5)
            android.graphics.Paint r7 = r9.tunaPaint
            r10.drawBitmap(r0, r5, r7)
            float r0 = -r6
            r10.translate(r13, r0)
            goto L_0x02e4
        L_0x01c2:
            int r5 = r9.tunaWidth
            float r5 = (float) r5
            int r7 = r9.tunaDownloadGraphicsSrcDownloadWidth
            float r7 = (float) r7
            float r8 = r9.tunaDownloadGraphicsScaleY
            float r7 = r7 * r8
            float r5 = r5 - r7
            float r5 = r5 * r14
            r10.translate(r5, r6)
            float r7 = r9.tunaDownloadGraphicsScaleY
            android.graphics.Matrix r7 = r9.initTunaMatrix(r7, r7)
            android.graphics.Paint r8 = r9.tunaPaint
            r10.drawBitmap(r0, r7, r8)
            float r0 = -r5
            float r5 = -r6
            r10.translate(r0, r5)
            goto L_0x02e4
        L_0x01e4:
            int r7 = r9.tunaWidth
            float r7 = (float) r7
            float r7 = r7 * r5
            int r5 = r9.tunaDownloadGraphicsSrcDownloadWidth
            float r5 = (float) r5
            float r7 = r7 / r5
            r9.tunaDownloadGraphicsScaleX = r7
            r10.translate(r13, r6)
            float r5 = r9.tunaDownloadGraphicsScaleX
            float r7 = r9.tunaDownloadGraphicsScaleY
            android.graphics.Matrix r5 = r9.initTunaMatrix(r5, r7)
            android.graphics.Paint r7 = r9.tunaPaint
            r10.drawBitmap(r0, r5, r7)
            float r0 = -r6
            r10.translate(r13, r0)
            goto L_0x02e4
        L_0x0205:
            int r0 = r9.tunaDownloadGraphicsSrcFillId
            if (r0 == r15) goto L_0x020e
            android.graphics.Bitmap r0 = r9.decodeBitmapResource(r0)
            goto L_0x020f
        L_0x020e:
            r0 = r1
        L_0x020f:
            if (r0 == 0) goto L_0x024d
            int r6 = r0.getWidth()
            r9.tunaDownloadGraphicsSrcFillWidth = r6
            int r6 = r0.getHeight()
            r9.tunaDownloadGraphicsSrcFillHeight = r6
            int r6 = r9.tunaWidth
            float r6 = (float) r6
            float r6 = r6 * r5
            int r7 = r9.tunaDownloadGraphicsSrcFillWidth
            float r7 = (float) r7
            float r6 = r6 / r7
            int r7 = r9.tunaHeight
            float r7 = (float) r7
            float r8 = r9.tunaDownloadGraphicsSrcFillFractionBottom
            float r3 = r9.tunaDownloadGraphicsSrcFillFractionTop
            float r8 = r8 - r3
            float r7 = r7 * r8
            int r3 = r9.tunaDownloadGraphicsSrcFillHeight
            float r3 = (float) r3
            float r7 = r7 / r3
            int r3 = r9.tunaHeight
            float r3 = (float) r3
            float r8 = r9.tunaDownloadGraphicsSrcFillFractionTop
            float r3 = r3 * r8
            r17.save()
            r10.translate(r13, r3)
            android.graphics.Matrix r3 = r9.initTunaMatrix(r6, r7)
            android.graphics.Paint r6 = r9.tunaPaint
            r10.drawBitmap(r0, r3, r6)
            r17.restore()
        L_0x024d:
            int r0 = r9.tunaDownloadGraphicsSrcFrontId
            if (r0 == r15) goto L_0x0256
            android.graphics.Bitmap r0 = r9.decodeBitmapResource(r0)
            goto L_0x0257
        L_0x0256:
            r0 = r1
        L_0x0257:
            int r3 = r9.tunaDownloadGraphicsSrcBackId
            if (r3 == r15) goto L_0x0260
            android.graphics.Bitmap r3 = r9.decodeBitmapResource(r3)
            goto L_0x0261
        L_0x0260:
            r3 = r1
        L_0x0261:
            if (r0 == 0) goto L_0x02e4
            if (r3 == 0) goto L_0x02e4
            int r6 = r0.getWidth()
            r9.tunaDownloadGraphicsSrcFrontWidth = r6
            int r6 = r0.getHeight()
            r9.tunaDownloadGraphicsSrcFrontHeight = r6
            int r6 = r9.tunaHeight
            float r6 = (float) r6
            float r7 = r9.tunaDownloadGraphicsSrcFrontFractionBottom
            float r8 = r9.tunaDownloadGraphicsSrcFrontFractionTop
            float r7 = r7 - r8
            float r6 = r6 * r7
            int r7 = r9.tunaDownloadGraphicsSrcFrontHeight
            float r7 = (float) r7
            float r6 = r6 / r7
            int r7 = r9.tunaWidth
            float r7 = (float) r7
            int r8 = r9.tunaDownloadGraphicsSrcFrontWidth
            float r8 = (float) r8
            float r8 = r8 * r6
            float r7 = r7 - r8
            float r7 = r7 * r14
            int r8 = r9.tunaHeight
            float r8 = (float) r8
            float r13 = r9.tunaDownloadGraphicsSrcFrontFractionTop
            float r8 = r8 * r13
            r17.save()
            r10.translate(r7, r8)
            int r13 = r9.tunaDownloadGraphicsSrcFrontWidth
            float r13 = (float) r13
            float r13 = r13 * r6
            int r13 = (int) r13
            int r14 = r9.tunaDownloadGraphicsSrcFrontHeight
            float r14 = (float) r14
            float r14 = r14 * r6
            float r12 = r9.tunaDownloadPercent
            float r12 = r5 - r12
            float r14 = r14 * r12
            int r12 = (int) r14
            android.graphics.Rect r12 = r9.initTunaRect(r11, r11, r13, r12)
            r10.clipRect(r12)
            android.graphics.Matrix r12 = r9.initTunaMatrix(r6, r6)
            r10.drawBitmap(r3, r12, r1)
            r17.restore()
            r17.save()
            r10.translate(r7, r8)
            int r3 = r9.tunaDownloadGraphicsSrcFrontHeight
            float r7 = (float) r3
            float r7 = r7 * r6
            float r8 = r9.tunaDownloadPercent
            float r5 = r5 - r8
            float r7 = r7 * r5
            int r5 = (int) r7
            int r7 = r9.tunaDownloadGraphicsSrcFrontWidth
            float r7 = (float) r7
            float r7 = r7 * r6
            int r7 = (int) r7
            float r3 = (float) r3
            float r3 = r3 * r6
            int r3 = (int) r3
            android.graphics.Rect r3 = r9.initTunaRect(r11, r5, r7, r3)
            r10.clipRect(r3)
            android.graphics.Matrix r3 = r9.tunaMatrix
            r10.drawBitmap(r0, r3, r1)
            r17.restore()
        L_0x02e4:
            boolean r0 = r9.tunaDownloadMark
            if (r0 == 0) goto L_0x03e3
            int r0 = r9.tunaDownloadMarkGraphicsId
            if (r0 == r15) goto L_0x02f1
            android.graphics.Bitmap r0 = r9.decodeBitmapResource(r0)
            goto L_0x02f2
        L_0x02f1:
            r0 = r1
        L_0x02f2:
            if (r0 == 0) goto L_0x03e3
            float r3 = r9.tunaDownloadMarkGraphicsSrcWidth
            int r5 = r0.getWidth()
            float r5 = (float) r5
            float r3 = r3 / r5
            int r5 = r0.getWidth()
            float r5 = (float) r5
            float r5 = r5 * r3
            float[] r2 = new float[r2]
            r2 = {0, 0, 0, 0} // fill-array
            int r6 = r9.tunaDownloadMarkGravity
            r6 = r6 & 15
            switch(r6) {
                case 0: goto L_0x03a3;
                case 1: goto L_0x0395;
                case 2: goto L_0x0380;
                case 3: goto L_0x030f;
                case 4: goto L_0x0373;
                case 5: goto L_0x035c;
                case 6: goto L_0x034e;
                case 7: goto L_0x030f;
                case 8: goto L_0x033b;
                case 9: goto L_0x0329;
                case 10: goto L_0x0311;
                default: goto L_0x030f;
            }
        L_0x030f:
            goto L_0x03af
        L_0x0311:
            int r6 = r9.tunaWidth
            float r6 = (float) r6
            float r7 = r9.tunaDownloadMarkGraphicsSrcWidth
            float r6 = r6 - r7
            int r7 = r9.tunaHeight
            float r7 = (float) r7
            float r7 = r7 - r5
            float r5 = r9.tunaDownloadRadius
            float r8 = r9.tunaDownloadRadiusRightBottom
            int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r12 < 0) goto L_0x0324
            goto L_0x0325
        L_0x0324:
            r5 = r8
        L_0x0325:
            r2[r4] = r5
            goto L_0x03b1
        L_0x0329:
            int r6 = r9.tunaWidth
            r7 = 1
            int r6 = r6 >> r7
            float r6 = (float) r6
            float r7 = r9.tunaDownloadMarkGraphicsSrcWidth
            r8 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 * r8
            float r6 = r6 - r7
            int r7 = r9.tunaHeight
            float r7 = (float) r7
            float r7 = r7 - r5
            goto L_0x03b1
        L_0x033b:
            int r6 = r9.tunaHeight
            float r6 = (float) r6
            float r7 = r6 - r5
            float r5 = r9.tunaDownloadRadius
            float r6 = r9.tunaDownloadRadiusLeftBottom
            int r8 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0349
            goto L_0x034a
        L_0x0349:
            r5 = r6
        L_0x034a:
            r6 = 1
            r2[r6] = r5
            goto L_0x037e
        L_0x034e:
            r6 = 1
            int r7 = r9.tunaWidth
            float r7 = (float) r7
            float r8 = r9.tunaDownloadMarkGraphicsSrcWidth
            float r7 = r7 - r8
            int r8 = r9.tunaHeight
            int r8 = r8 >> r6
            float r8 = (float) r8
            r12 = 1056964608(0x3f000000, float:0.5)
            goto L_0x036c
        L_0x035c:
            r6 = 1
            r12 = 1056964608(0x3f000000, float:0.5)
            int r7 = r9.tunaWidth
            int r7 = r7 >> r6
            float r7 = (float) r7
            float r8 = r9.tunaDownloadMarkGraphicsSrcWidth
            float r8 = r8 * r12
            float r7 = r7 - r8
            int r8 = r9.tunaHeight
            int r8 = r8 >> r6
            float r8 = (float) r8
        L_0x036c:
            float r5 = r5 * r12
            float r5 = r8 - r5
            r6 = r7
            r7 = r5
            goto L_0x03b1
        L_0x0373:
            r6 = 1
            r12 = 1056964608(0x3f000000, float:0.5)
            int r7 = r9.tunaHeight
            int r7 = r7 >> r6
            float r6 = (float) r7
            float r5 = r5 * r12
            float r7 = r6 - r5
        L_0x037e:
            r6 = 0
            goto L_0x03b1
        L_0x0380:
            int r5 = r9.tunaWidth
            float r5 = (float) r5
            float r6 = r9.tunaDownloadMarkGraphicsSrcWidth
            float r6 = r5 - r6
            float r5 = r9.tunaDownloadRadius
            float r7 = r9.tunaDownloadRadiusRightTop
            int r8 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x0390
            goto L_0x0391
        L_0x0390:
            r5 = r7
        L_0x0391:
            r7 = 2
            r2[r7] = r5
            goto L_0x03b0
        L_0x0395:
            int r5 = r9.tunaWidth
            r6 = 1
            int r5 = r5 >> r6
            float r5 = (float) r5
            float r6 = r9.tunaDownloadMarkGraphicsSrcWidth
            r7 = 1056964608(0x3f000000, float:0.5)
            float r6 = r6 * r7
            float r6 = r5 - r6
            goto L_0x03b0
        L_0x03a3:
            float r5 = r9.tunaDownloadRadius
            float r6 = r9.tunaDownloadRadiusLeftTop
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 < 0) goto L_0x03ac
            goto L_0x03ad
        L_0x03ac:
            r5 = r6
        L_0x03ad:
            r2[r11] = r5
        L_0x03af:
            r6 = 0
        L_0x03b0:
            r7 = 0
        L_0x03b1:
            r10.translate(r6, r7)
            float r5 = r9.tunaDownloadRadius
            r8 = 0
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x03d1
            android.graphics.Bitmap r0 = getScaleBitmap(r0, r3)
            r3 = r2[r11]
            r5 = 1
            r11 = r2[r5]
            r12 = 2
            r12 = r2[r12]
            r2 = r2[r4]
            android.graphics.Bitmap r0 = getCustomRoundBitmap(r0, r3, r11, r12, r2)
            r10.drawBitmap(r0, r8, r8, r1)
            goto L_0x03de
        L_0x03d1:
            r5 = 1
            android.graphics.Matrix r1 = r9.initTunaMatrix(r3, r3)
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>(r5)
            r10.drawBitmap(r0, r1, r2)
        L_0x03de:
            float r0 = -r6
            float r1 = -r7
            r10.translate(r0, r1)
        L_0x03e3:
            java.lang.String r2 = r9.tunaDownloadTitleTextValue
            if (r2 == 0) goto L_0x040b
            int r0 = r9.tunaWidth
            float r3 = (float) r0
            int r0 = r9.tunaWidth
            r1 = 1
            int r0 = r0 >> r1
            float r4 = (float) r0
            int r0 = r9.tunaHeight
            float r0 = (float) r0
            float r1 = r9.tunaDownloadTitleFractionVertical
            float r5 = r0 * r1
            r6 = 0
            r7 = 0
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            int r1 = r9.tunaDownloadTitleTextColorNormal
            float r8 = r9.tunaDownloadTitleTextSize
            android.graphics.Paint$Align r11 = android.graphics.Paint.Align.CENTER
            android.graphics.Paint r8 = r9.initTunaTextPaint(r0, r1, r8, r11)
            r0 = r16
            r1 = r17
            r0.drawTunaText(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x040b:
            java.lang.String r2 = r9.tunaDownloadContentTextValue
            if (r2 == 0) goto L_0x0433
            int r0 = r9.tunaWidth
            float r3 = (float) r0
            int r0 = r9.tunaWidth
            r1 = 1
            int r0 = r0 >> r1
            float r4 = (float) r0
            int r0 = r9.tunaHeight
            float r0 = (float) r0
            float r1 = r9.tunaDownloadContentFractionVertical
            float r5 = r0 * r1
            r6 = 0
            r7 = 0
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            int r1 = r9.tunaDownloadContentTextColorNormal
            float r8 = r9.tunaDownloadContentTextSize
            android.graphics.Paint$Align r11 = android.graphics.Paint.Align.CENTER
            android.graphics.Paint r8 = r9.initTunaTextPaint(r0, r1, r8, r11)
            r0 = r16
            r1 = r17
            r0.drawTunaText(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0433:
            java.lang.String r0 = r9.tunaDownloadContentMarkTextValue
            if (r0 == 0) goto L_0x049f
            int r0 = r9.tunaHeight
            float r0 = (float) r0
            float r1 = r9.tunaDownloadContentMarkFractionVertical
            float r5 = r0 * r1
            int r0 = r9.tunaWidth
            r1 = 1
            int r0 = r0 >> r1
            float r0 = (float) r0
            float r1 = r9.tunaDownloadContentTextSize
            android.graphics.Paint r1 = r9.initTunaTextPaint(r1)
            java.lang.String r2 = r9.tunaDownloadContentTextValue
            float r1 = r1.measureText(r2)
            float r4 = r0 - r1
            float r0 = r9.tunaDownloadContentMarkTextSize
            android.graphics.Paint r0 = r9.initTunaTextPaint(r0)
            java.lang.String r1 = r9.tunaDownloadContentMarkTextValue
            float r0 = r0.measureText(r1)
            float r0 = r0 + r4
            float r1 = r9.tunaDownloadContentMarkStrokeWidth
            float r2 = r4 - r1
            float r3 = r9.tunaDownloadContentMarkTextSize
            r6 = 1056964608(0x3f000000, float:0.5)
            float r14 = r3 * r6
            float r7 = r5 - r14
            float r7 = r7 - r1
            float r0 = r0 + r1
            float r3 = r3 * r6
            float r3 = r3 + r5
            float r3 = r3 + r1
            android.graphics.RectF r0 = r9.initTunaRectF(r2, r7, r0, r3)
            float r1 = r9.tunaDownloadContentMarkRadius
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL
            int r3 = r9.tunaDownloadContentMarkBackgroundNormal
            float r6 = r9.tunaDownloadContentMarkTextSize
            android.graphics.Paint$Align r7 = android.graphics.Paint.Align.LEFT
            android.graphics.Paint r2 = r9.initTunaTextPaint(r2, r3, r6, r7)
            r10.drawRoundRect(r0, r1, r1, r2)
            java.lang.String r2 = r9.tunaDownloadContentMarkTextValue
            int r0 = r9.tunaWidth
            float r3 = (float) r0
            r6 = 0
            r7 = 0
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            int r1 = r9.tunaDownloadContentMarkTextColorNormal
            float r8 = r9.tunaDownloadContentMarkTextSize
            android.graphics.Paint$Align r11 = android.graphics.Paint.Align.LEFT
            android.graphics.Paint r8 = r9.initTunaTextPaint(r0, r1, r8, r11)
            r0 = r16
            r1 = r17
            r0.drawTunaText(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x049f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaDownload.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: com.tunasashimi.tuna.TunaDownload$5 */
    static /* synthetic */ class C205935 {
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaDownload$TunaDownloadType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tunasashimi.tuna.TunaDownload$TunaDownloadType[] r0 = com.tunasashimi.tuna.TunaDownload.TunaDownloadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tunasashimi$tuna$TunaDownload$TunaDownloadType = r0
                com.tunasashimi.tuna.TunaDownload$TunaDownloadType r1 = com.tunasashimi.tuna.TunaDownload.TunaDownloadType.TENSILE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaDownload$TunaDownloadType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tunasashimi.tuna.TunaDownload$TunaDownloadType r1 = com.tunasashimi.tuna.TunaDownload.TunaDownloadType.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaDownload$TunaDownloadType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tunasashimi.tuna.TunaDownload$TunaDownloadType r1 = com.tunasashimi.tuna.TunaDownload.TunaDownloadType.FIT_X     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaDownload$TunaDownloadType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tunasashimi.tuna.TunaDownload$TunaDownloadType r1 = com.tunasashimi.tuna.TunaDownload.TunaDownloadType.FIT_Y     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaDownload.C205935.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void init(HashMap<String, Object> hashMap, String str) {
        init(hashMap, str, false, (String) null, (String) null, (String) null);
    }

    public void init(HashMap<String, Object> hashMap, String str, boolean z) {
        init(hashMap, str, z, (String) null, (String) null, (String) null);
    }

    public void init(HashMap<String, Object> hashMap, String str, String str2) {
        init(hashMap, str, false, str2, (String) null, (String) null);
    }

    public void init(HashMap<String, Object> hashMap, String str, String str2, String str3) {
        init(hashMap, str, false, str2, (String) null, str3);
    }

    public void init(HashMap<String, Object> hashMap, String str, String str2, String str3, String str4) {
        init(hashMap, str, false, str2, str3, str4);
    }

    public void init(HashMap<String, Object> hashMap, String str, boolean z, String str2, String str3, String str4) {
        this.tunaGraphicsMap = hashMap;
        if (this.tunaDownloadCacheFolder != null) {
            this.tunaDownloadCacheFolderDirectory = getContext().getCacheDir().getAbsolutePath() + "/" + this.tunaDownloadCacheFolder + "/";
            if (this.tunaWidth == 0 || this.tunaHeight == 0) {
                this.tunaDownloadGraphicsSrcURL = str;
                this.tunaDownloadMark = z;
                this.tunaDownloadTitleTextValue = str2;
                this.tunaDownloadContentTextValue = str4;
                this.tunaDownloadContentMarkTextValue = str3;
                this.mHandler.sendEmptyMessageDelayed(0, 0);
            } else if (this.graphicsType == null || !this.tunaDownloadGraphicsSrcURL.equals(str)) {
                this.tunaDownloadGraphicsSrcURL = str;
                this.tunaDownloadMark = z;
                this.tunaDownloadTitleTextValue = str2;
                this.tunaDownloadContentTextValue = str4;
                this.tunaDownloadContentMarkTextValue = str3;
                this.mHandler.sendEmptyMessage(0);
            }
        } else {
            throw new IllegalArgumentException("The content attribute tunaDownloadCacheFolder type must be given");
        }
    }

    /* access modifiers changed from: private */
    public static URL interceptor(URL url) {
        INonRpcInterceptor iNonRpcInterceptor = (INonRpcInterceptor) ServiceLoader.load(INonRpcInterceptor.class).get();
        return (iNonRpcInterceptor == null || iNonRpcInterceptor.intercept(url) == null) ? url : iNonRpcInterceptor.intercept(url);
    }

    /* access modifiers changed from: private */
    public void getTunaDownloadGraphicsSrc() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(this.tunaDownloadCacheFolderDirectory);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        createNoMediaFile();
        String str = this.tunaDownloadGraphicsSrcURL;
        if (str != null) {
            this.tunaDownloadGraphicsSrcURLIndex = str.replaceAll("/", "").replaceAll(":", "");
        }
        this.tunaDownloadfile = new File(this.tunaDownloadCacheFolderDirectory + this.tunaDownloadGraphicsSrcURLIndex);
        if (this.tunaDownloadCacheCheck) {
            new Thread() {
                /* JADX WARNING: Removed duplicated region for block: B:38:0x0152 A[SYNTHETIC, Splitter:B:38:0x0152] */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x015a A[Catch:{ IOException -> 0x0156 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r16 = this;
                        r1 = r16
                        r2 = 4
                        r3 = 0
                        java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r4 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.String r4 = r4.tunaDownloadGraphicsSrcURL     // Catch:{ Exception -> 0x014b }
                        r0.<init>(r4)     // Catch:{ Exception -> 0x014b }
                        java.net.URL r0 = com.tunasashimi.tuna.TunaDownload.interceptor(r0)     // Catch:{ Exception -> 0x014b }
                        java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x014b }
                        java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x014b }
                        r4 = 10000(0x2710, float:1.4013E-41)
                        r0.setConnectTimeout(r4)     // Catch:{ Exception -> 0x014b }
                        r0.setReadTimeout(r4)     // Catch:{ Exception -> 0x014b }
                        java.lang.String r4 = "Accept-Encoding"
                        java.lang.String r5 = "identity"
                        r0.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x014b }
                        int r4 = r0.getContentLength()     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r5 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.io.File r5 = r5.tunaDownloadfile     // Catch:{ Exception -> 0x014b }
                        boolean r5 = r5.exists()     // Catch:{ Exception -> 0x014b }
                        r6 = 2
                        java.lang.String r7 = "GIF"
                        if (r5 == 0) goto L_0x0087
                        com.tunasashimi.tuna.TunaDownload r5 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.io.File r5 = r5.tunaDownloadfile     // Catch:{ Exception -> 0x014b }
                        long r8 = r5.length()     // Catch:{ Exception -> 0x014b }
                        long r10 = (long) r4     // Catch:{ Exception -> 0x014b }
                        int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                        if (r5 != 0) goto L_0x0087
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014b }
                        r4.<init>()     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r5 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.String r5 = r5.tunaDownloadCacheFolderDirectory     // Catch:{ Exception -> 0x014b }
                        r4.append(r5)     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r5 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.String r5 = r5.tunaDownloadGraphicsSrcURLIndex     // Catch:{ Exception -> 0x014b }
                        r4.append(r5)     // Catch:{ Exception -> 0x014b }
                        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x014b }
                        java.lang.String r4 = com.tunasashimi.tuna.TunaView.getGraphicsType((java.lang.String) r4)     // Catch:{ Exception -> 0x014b }
                        java.lang.String unused = r0.graphicsType = r4     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.String r0 = r0.graphicsType     // Catch:{ Exception -> 0x014b }
                        boolean r0 = r7.equals(r0)     // Catch:{ Exception -> 0x014b }
                        if (r0 == 0) goto L_0x007c
                        goto L_0x016a
                    L_0x007c:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x014b }
                        r0.sendEmptyMessage(r6)     // Catch:{ Exception -> 0x014b }
                        goto L_0x016a
                    L_0x0087:
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014b }
                        r5.<init>()     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r8 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.String r8 = r8.tunaDownloadCacheFolderDirectory     // Catch:{ Exception -> 0x014b }
                        r5.append(r8)     // Catch:{ Exception -> 0x014b }
                        com.tunasashimi.tuna.TunaDownload r8 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x014b }
                        java.lang.String r8 = r8.tunaDownloadGraphicsSrcURLIndex     // Catch:{ Exception -> 0x014b }
                        r5.append(r8)     // Catch:{ Exception -> 0x014b }
                        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x014b }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014b }
                        r8.<init>()     // Catch:{ Exception -> 0x014b }
                        r8.append(r5)     // Catch:{ Exception -> 0x014b }
                        java.lang.String r9 = ".tmp"
                        r8.append(r9)     // Catch:{ Exception -> 0x014b }
                        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x014b }
                        java.io.InputStream r9 = r0.getInputStream()     // Catch:{ Exception -> 0x014b }
                        java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0147 }
                        r10.<init>(r8)     // Catch:{ Exception -> 0x0147 }
                        r0 = 1024(0x400, float:1.435E-42)
                        byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0145 }
                        r3 = 0
                        r11 = 0
                    L_0x00c2:
                        int r12 = r9.read(r0)     // Catch:{ Exception -> 0x0145 }
                        int r11 = r11 + r12
                        com.tunasashimi.tuna.TunaDownload r13 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        float r14 = (float) r11     // Catch:{ Exception -> 0x0145 }
                        r15 = 1065353216(0x3f800000, float:1.0)
                        float r14 = r14 * r15
                        float r15 = (float) r4     // Catch:{ Exception -> 0x0145 }
                        float r14 = r14 / r15
                        float unused = r13.tunaDownloadPercent = r14     // Catch:{ Exception -> 0x0145 }
                        com.tunasashimi.tuna.TunaDownload r13 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        android.os.Handler r13 = r13.mHandler     // Catch:{ Exception -> 0x0145 }
                        r14 = 1
                        r13.sendEmptyMessage(r14)     // Catch:{ Exception -> 0x0145 }
                        if (r12 > 0) goto L_0x0133
                        java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0145 }
                        r0.<init>(r8)     // Catch:{ Exception -> 0x0145 }
                        java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0145 }
                        r3.<init>(r5)     // Catch:{ Exception -> 0x0145 }
                        boolean r0 = r0.renameTo(r3)     // Catch:{ Exception -> 0x0145 }
                        if (r0 != 0) goto L_0x00f8
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x0145 }
                        r0.sendEmptyMessage(r2)     // Catch:{ Exception -> 0x0145 }
                    L_0x00f8:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0145 }
                        r3.<init>()     // Catch:{ Exception -> 0x0145 }
                        com.tunasashimi.tuna.TunaDownload r4 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        java.lang.String r4 = r4.tunaDownloadCacheFolderDirectory     // Catch:{ Exception -> 0x0145 }
                        r3.append(r4)     // Catch:{ Exception -> 0x0145 }
                        com.tunasashimi.tuna.TunaDownload r4 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        java.lang.String r4 = r4.tunaDownloadGraphicsSrcURLIndex     // Catch:{ Exception -> 0x0145 }
                        r3.append(r4)     // Catch:{ Exception -> 0x0145 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0145 }
                        java.lang.String r3 = com.tunasashimi.tuna.TunaView.getGraphicsType((java.lang.String) r3)     // Catch:{ Exception -> 0x0145 }
                        java.lang.String unused = r0.graphicsType = r3     // Catch:{ Exception -> 0x0145 }
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        java.lang.String r0 = r0.graphicsType     // Catch:{ Exception -> 0x0145 }
                        boolean r0 = r7.equals(r0)     // Catch:{ Exception -> 0x0145 }
                        if (r0 == 0) goto L_0x0129
                        goto L_0x013e
                    L_0x0129:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x0145 }
                        r0.sendEmptyMessage(r6)     // Catch:{ Exception -> 0x0145 }
                        goto L_0x013e
                    L_0x0133:
                        r10.write(r0, r3, r12)     // Catch:{ Exception -> 0x0145 }
                        com.tunasashimi.tuna.TunaDownload r12 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0145 }
                        boolean r12 = r12.tunaDownInterceptFlag     // Catch:{ Exception -> 0x0145 }
                        if (r12 == 0) goto L_0x00c2
                    L_0x013e:
                        r10.close()     // Catch:{ Exception -> 0x0145 }
                        r9.close()     // Catch:{ Exception -> 0x0145 }
                        goto L_0x016a
                    L_0x0145:
                        r0 = move-exception
                        goto L_0x0149
                    L_0x0147:
                        r0 = move-exception
                        r10 = r3
                    L_0x0149:
                        r3 = r9
                        goto L_0x014d
                    L_0x014b:
                        r0 = move-exception
                        r10 = r3
                    L_0x014d:
                        r0.printStackTrace()
                        if (r3 == 0) goto L_0x0158
                        r3.close()     // Catch:{ IOException -> 0x0156 }
                        goto L_0x0158
                    L_0x0156:
                        r0 = move-exception
                        goto L_0x015e
                    L_0x0158:
                        if (r10 == 0) goto L_0x0161
                        r10.close()     // Catch:{ IOException -> 0x0156 }
                        goto L_0x0161
                    L_0x015e:
                        r0.printStackTrace()
                    L_0x0161:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this
                        android.os.Handler r0 = r0.mHandler
                        r0.sendEmptyMessage(r2)
                    L_0x016a:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaDownload.C205902.run():void");
                }
            }.start();
        } else {
            new Thread() {
                /* JADX WARNING: Removed duplicated region for block: B:36:0x0143 A[SYNTHETIC, Splitter:B:36:0x0143] */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x014b A[Catch:{ IOException -> 0x0147 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r16 = this;
                        r1 = r16
                        r2 = 4
                        r3 = 0
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.io.File r0 = r0.tunaDownloadfile     // Catch:{ Exception -> 0x013c }
                        boolean r0 = r0.exists()     // Catch:{ Exception -> 0x013c }
                        r4 = 2
                        java.lang.String r5 = "GIF"
                        if (r0 == 0) goto L_0x0050
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
                        r6.<init>()     // Catch:{ Exception -> 0x013c }
                        com.tunasashimi.tuna.TunaDownload r7 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.String r7 = r7.tunaDownloadCacheFolderDirectory     // Catch:{ Exception -> 0x013c }
                        r6.append(r7)     // Catch:{ Exception -> 0x013c }
                        com.tunasashimi.tuna.TunaDownload r7 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.String r7 = r7.tunaDownloadGraphicsSrcURLIndex     // Catch:{ Exception -> 0x013c }
                        r6.append(r7)     // Catch:{ Exception -> 0x013c }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x013c }
                        java.lang.String r6 = com.tunasashimi.tuna.TunaView.getGraphicsType((java.lang.String) r6)     // Catch:{ Exception -> 0x013c }
                        java.lang.String unused = r0.graphicsType = r6     // Catch:{ Exception -> 0x013c }
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.String r0 = r0.graphicsType     // Catch:{ Exception -> 0x013c }
                        boolean r0 = r5.equals(r0)     // Catch:{ Exception -> 0x013c }
                        if (r0 == 0) goto L_0x0045
                        goto L_0x015b
                    L_0x0045:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x013c }
                        r0.sendEmptyMessage(r4)     // Catch:{ Exception -> 0x013c }
                        goto L_0x015b
                    L_0x0050:
                        java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x013c }
                        com.tunasashimi.tuna.TunaDownload r6 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.String r6 = r6.tunaDownloadGraphicsSrcURL     // Catch:{ Exception -> 0x013c }
                        r0.<init>(r6)     // Catch:{ Exception -> 0x013c }
                        java.net.URL r0 = com.tunasashimi.tuna.TunaDownload.interceptor(r0)     // Catch:{ Exception -> 0x013c }
                        java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x013c }
                        java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x013c }
                        r6 = 10000(0x2710, float:1.4013E-41)
                        r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x013c }
                        r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x013c }
                        java.lang.String r6 = "Accept-Encoding"
                        java.lang.String r7 = "identity"
                        r0.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x013c }
                        int r6 = r0.getContentLength()     // Catch:{ Exception -> 0x013c }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
                        r7.<init>()     // Catch:{ Exception -> 0x013c }
                        com.tunasashimi.tuna.TunaDownload r8 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.String r8 = r8.tunaDownloadCacheFolderDirectory     // Catch:{ Exception -> 0x013c }
                        r7.append(r8)     // Catch:{ Exception -> 0x013c }
                        com.tunasashimi.tuna.TunaDownload r8 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x013c }
                        java.lang.String r8 = r8.tunaDownloadGraphicsSrcURLIndex     // Catch:{ Exception -> 0x013c }
                        r7.append(r8)     // Catch:{ Exception -> 0x013c }
                        java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x013c }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
                        r8.<init>()     // Catch:{ Exception -> 0x013c }
                        r8.append(r7)     // Catch:{ Exception -> 0x013c }
                        java.lang.String r9 = ".tmp"
                        r8.append(r9)     // Catch:{ Exception -> 0x013c }
                        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x013c }
                        java.io.InputStream r9 = r0.getInputStream()     // Catch:{ Exception -> 0x013c }
                        java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0138 }
                        r10.<init>(r8)     // Catch:{ Exception -> 0x0138 }
                        r0 = 1024(0x400, float:1.435E-42)
                        byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0136 }
                        r3 = 0
                        r11 = 0
                    L_0x00b3:
                        int r12 = r9.read(r0)     // Catch:{ Exception -> 0x0136 }
                        int r11 = r11 + r12
                        com.tunasashimi.tuna.TunaDownload r13 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        float r14 = (float) r11     // Catch:{ Exception -> 0x0136 }
                        r15 = 1065353216(0x3f800000, float:1.0)
                        float r14 = r14 * r15
                        float r15 = (float) r6     // Catch:{ Exception -> 0x0136 }
                        float r14 = r14 / r15
                        float unused = r13.tunaDownloadPercent = r14     // Catch:{ Exception -> 0x0136 }
                        com.tunasashimi.tuna.TunaDownload r13 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        android.os.Handler r13 = r13.mHandler     // Catch:{ Exception -> 0x0136 }
                        r14 = 1
                        r13.sendEmptyMessage(r14)     // Catch:{ Exception -> 0x0136 }
                        if (r12 > 0) goto L_0x0124
                        java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0136 }
                        r0.<init>(r8)     // Catch:{ Exception -> 0x0136 }
                        java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0136 }
                        r3.<init>(r7)     // Catch:{ Exception -> 0x0136 }
                        boolean r0 = r0.renameTo(r3)     // Catch:{ Exception -> 0x0136 }
                        if (r0 != 0) goto L_0x00e9
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x0136 }
                        r0.sendEmptyMessage(r2)     // Catch:{ Exception -> 0x0136 }
                    L_0x00e9:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0136 }
                        r3.<init>()     // Catch:{ Exception -> 0x0136 }
                        com.tunasashimi.tuna.TunaDownload r6 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r6 = r6.tunaDownloadCacheFolderDirectory     // Catch:{ Exception -> 0x0136 }
                        r3.append(r6)     // Catch:{ Exception -> 0x0136 }
                        com.tunasashimi.tuna.TunaDownload r6 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r6 = r6.tunaDownloadGraphicsSrcURLIndex     // Catch:{ Exception -> 0x0136 }
                        r3.append(r6)     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r3 = com.tunasashimi.tuna.TunaView.getGraphicsType((java.lang.String) r3)     // Catch:{ Exception -> 0x0136 }
                        java.lang.String unused = r0.graphicsType = r3     // Catch:{ Exception -> 0x0136 }
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r0 = r0.graphicsType     // Catch:{ Exception -> 0x0136 }
                        boolean r0 = r5.equals(r0)     // Catch:{ Exception -> 0x0136 }
                        if (r0 == 0) goto L_0x011a
                        goto L_0x012f
                    L_0x011a:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x0136 }
                        r0.sendEmptyMessage(r4)     // Catch:{ Exception -> 0x0136 }
                        goto L_0x012f
                    L_0x0124:
                        r10.write(r0, r3, r12)     // Catch:{ Exception -> 0x0136 }
                        com.tunasashimi.tuna.TunaDownload r12 = com.tunasashimi.tuna.TunaDownload.this     // Catch:{ Exception -> 0x0136 }
                        boolean r12 = r12.tunaDownInterceptFlag     // Catch:{ Exception -> 0x0136 }
                        if (r12 == 0) goto L_0x00b3
                    L_0x012f:
                        r10.close()     // Catch:{ Exception -> 0x0136 }
                        r9.close()     // Catch:{ Exception -> 0x0136 }
                        goto L_0x015b
                    L_0x0136:
                        r0 = move-exception
                        goto L_0x013a
                    L_0x0138:
                        r0 = move-exception
                        r10 = r3
                    L_0x013a:
                        r3 = r9
                        goto L_0x013e
                    L_0x013c:
                        r0 = move-exception
                        r10 = r3
                    L_0x013e:
                        r0.printStackTrace()
                        if (r3 == 0) goto L_0x0149
                        r3.close()     // Catch:{ IOException -> 0x0147 }
                        goto L_0x0149
                    L_0x0147:
                        r0 = move-exception
                        goto L_0x014f
                    L_0x0149:
                        if (r10 == 0) goto L_0x0152
                        r10.close()     // Catch:{ IOException -> 0x0147 }
                        goto L_0x0152
                    L_0x014f:
                        r0.printStackTrace()
                    L_0x0152:
                        com.tunasashimi.tuna.TunaDownload r0 = com.tunasashimi.tuna.TunaDownload.this
                        android.os.Handler r0 = r0.mHandler
                        r0.sendEmptyMessage(r2)
                    L_0x015b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaDownload.C205913.run():void");
                }
            }.start();
        }
    }

    public static void cache(Context context, String str, String str2) {
        cache(context, str, str2, false);
    }

    public static void cache(Context context, String str, final String str2, boolean z) {
        final String str3 = context.getCacheDir().getAbsolutePath() + "/" + str + "/";
        final String replaceAll = str2.replaceAll("/", "").replaceAll(":", "");
        final File file = new File(str3 + replaceAll);
        if (z) {
            cleanCache(str3, replaceAll);
        }
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0088 A[SYNTHETIC, Splitter:B:21:0x0088] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0090 A[Catch:{ IOException -> 0x008c }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    r0 = 0
                    java.io.File r1 = r0     // Catch:{ Exception -> 0x007f }
                    boolean r1 = r1.exists()     // Catch:{ Exception -> 0x007f }
                    if (r1 != 0) goto L_0x0097
                    java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x007f }
                    java.lang.String r2 = r4     // Catch:{ Exception -> 0x007f }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x007f }
                    java.net.URL r1 = com.tunasashimi.tuna.TunaDownload.interceptor(r1)     // Catch:{ Exception -> 0x007f }
                    java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x007f }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x007f }
                    r2 = 10000(0x2710, float:1.4013E-41)
                    r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x007f }
                    r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x007f }
                    java.lang.String r2 = "Accept-Encoding"
                    java.lang.String r3 = "identity"
                    r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x007f }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f }
                    r2.<init>()     // Catch:{ Exception -> 0x007f }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x007f }
                    r2.append(r3)     // Catch:{ Exception -> 0x007f }
                    java.lang.String r3 = r2     // Catch:{ Exception -> 0x007f }
                    r2.append(r3)     // Catch:{ Exception -> 0x007f }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x007f }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f }
                    r3.<init>()     // Catch:{ Exception -> 0x007f }
                    r3.append(r2)     // Catch:{ Exception -> 0x007f }
                    java.lang.String r4 = ".tmp"
                    r3.append(r4)     // Catch:{ Exception -> 0x007f }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007f }
                    java.io.InputStream r1 = r1.getInputStream()     // Catch:{ Exception -> 0x007f }
                    java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x007b }
                    r4.<init>(r3)     // Catch:{ Exception -> 0x007b }
                    r0 = 1024(0x400, float:1.435E-42)
                    byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0079 }
                L_0x005a:
                    int r5 = r1.read(r0)     // Catch:{ Exception -> 0x0079 }
                    if (r5 > 0) goto L_0x0074
                    java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0079 }
                    r0.<init>(r3)     // Catch:{ Exception -> 0x0079 }
                    java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0079 }
                    r3.<init>(r2)     // Catch:{ Exception -> 0x0079 }
                    r0.renameTo(r3)     // Catch:{ Exception -> 0x0079 }
                    r4.close()     // Catch:{ Exception -> 0x0079 }
                    r1.close()     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0097
                L_0x0074:
                    r6 = 0
                    r4.write(r0, r6, r5)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x005a
                L_0x0079:
                    r0 = move-exception
                    goto L_0x0083
                L_0x007b:
                    r2 = move-exception
                    r4 = r0
                    r0 = r2
                    goto L_0x0083
                L_0x007f:
                    r1 = move-exception
                    r4 = r0
                    r0 = r1
                    r1 = r4
                L_0x0083:
                    r0.printStackTrace()
                    if (r1 == 0) goto L_0x008e
                    r1.close()     // Catch:{ IOException -> 0x008c }
                    goto L_0x008e
                L_0x008c:
                    r0 = move-exception
                    goto L_0x0094
                L_0x008e:
                    if (r4 == 0) goto L_0x0097
                    r4.close()     // Catch:{ IOException -> 0x008c }
                    goto L_0x0097
                L_0x0094:
                    r0.printStackTrace()
                L_0x0097:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaDownload.C205924.run():void");
            }
        }.start();
    }

    private void createNoMediaFile() {
        File file = new File(getTunaDownloadCacheFolder());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(getContext().getCacheDir().getAbsolutePath() + "/" + file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception unused) {
            }
        }
    }

    public static void cleanCache(String str, String str2) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && !file.getName().equals(str2)) {
                    deleteFile(file.getAbsolutePath());
                }
            }
        }
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return file.delete();
    }
}
