package com.didiglobal.xbanner.template.yoga.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didiglobal.xbanner.template.yoga.IParser;
import com.didiglobal.xbanner.template.yoga.IView;
import rui.config.RConfigConstants;

public class XPanelProgressBar extends View implements IParser, IView {

    /* renamed from: a */
    private float f51545a;

    /* renamed from: b */
    private Context f51546b;

    /* renamed from: c */
    private LinearGradient f51547c;

    /* renamed from: d */
    private int f51548d;

    /* renamed from: e */
    private int f51549e;
    protected Paint mBorderPaint;
    protected Paint mContentPaint;
    protected Path mPath;
    protected RectF mRectF;
    protected float[] radii;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public void setBorder(Border border) {
    }

    public XPanelProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radii = new float[8];
        this.f51546b = context;
        this.mRectF = new RectF();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mContentPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        boolean z = getBackground() instanceof XPanelRoundColorDrawable;
        this.f51547c = new LinearGradient(0.0f, 0.0f, (float) getMeasuredWidth(), 0.0f, this.f51549e, this.f51548d, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mRectF.left = 0.0f;
        this.mRectF.top = 0.0f;
        this.mRectF.right = ((float) getMeasuredWidth()) * this.f51545a;
        this.mRectF.bottom = (float) getMeasuredHeight();
        this.mPath.reset();
        LinearGradient linearGradient = this.f51547c;
        if (linearGradient != null) {
            this.mContentPaint.setShader(linearGradient);
        }
        this.mPath.addRoundRect(this.mRectF, this.radii, Path.Direction.CW);
        canvas.drawPath(this.mPath, this.mContentPaint);
    }

    public void setProgress(float f) {
        this.f51545a = f;
    }

    public void setProgressColor(int i) {
        this.f51548d = i;
        this.mContentPaint.setColor(i);
    }

    public void setStartColor(int i) {
        this.f51549e = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r4, java.lang.String r5, com.facebook.yoga.YogaNode r6) {
        /*
            r3 = this;
            int r6 = r4.hashCode()
            r0 = -1001078227(0xffffffffc454c22d, float:-851.034)
            r1 = 2
            r2 = 1
            if (r6 == r0) goto L_0x002a
            r0 = -25267666(0xfffffffffe7e722e, float:-8.455419E37)
            if (r6 == r0) goto L_0x0020
            r0 = 755159350(0x2d02d136, float:7.436099E-12)
            if (r6 == r0) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r6 = "progressColor"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0034
            r6 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r6 = "progressStartColor"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0034
            r6 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r6 = "progress"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0034
            r6 = 0
            goto L_0x0035
        L_0x0034:
            r6 = -1
        L_0x0035:
            if (r6 == 0) goto L_0x0066
            if (r6 == r2) goto L_0x005a
            if (r6 != r1) goto L_0x0043
            int r4 = android.graphics.Color.parseColor(r5)
            r3.setProgressColor(r4)
            goto L_0x0075
        L_0x0043:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Unknown view param: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        L_0x005a:
            java.lang.String r4 = getFullColorString(r5)     // Catch:{ Exception -> 0x0075 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x0075 }
            r3.setStartColor(r4)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0075
        L_0x0066:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L_0x006e
            r4 = 0
            goto L_0x0072
        L_0x006e:
            float r4 = java.lang.Float.parseFloat(r5)
        L_0x0072:
            r3.setProgress(r4)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelProgressBar.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    public void setCorner(Corner corner) {
        float[] fArr = this.radii;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.radii;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.radii;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.radii;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
    }

    public static String getFullColorString(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            return "0";
        }
        if (str.length() >= 9) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9 - str.length(); i++) {
            sb.append("0");
        }
        return RConfigConstants.KEYWORD_COLOR_SIGN + sb.toString() + str.replace(RConfigConstants.KEYWORD_COLOR_SIGN, "");
    }
}
