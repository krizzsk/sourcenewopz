package com.didiglobal.dittoview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.dittoview.IParser;
import com.didiglobal.dittoview.IView;
import com.didiglobal.dittoview.util.DittoUtil;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.GlobalTypeFaceSpan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DittoTextView extends TextView implements IParser, IView {

    /* renamed from: a */
    private static final String f49947a = "XPanelTextView";

    /* renamed from: m */
    private static String f49948m = "\\{(.*?)\\}";

    /* renamed from: n */
    private static Pattern f49949n = Pattern.compile("\\{(.*?)\\}");

    /* renamed from: b */
    private Context f49950b;

    /* renamed from: c */
    private float[] f49951c;

    /* renamed from: d */
    private Path f49952d;

    /* renamed from: e */
    private Paint f49953e;

    /* renamed from: f */
    private RectF f49954f;

    /* renamed from: g */
    private float f49955g;

    /* renamed from: h */
    private boolean f49956h;

    /* renamed from: i */
    private String f49957i;

    /* renamed from: j */
    private String f49958j;

    /* renamed from: k */
    private String f49959k;

    /* renamed from: l */
    private String f49960l;

    /* renamed from: o */
    private String f49961o;

    /* renamed from: p */
    private boolean f49962p;

    public View getView() {
        return this;
    }

    public void setShadow(DittoShadow dittoShadow) {
    }

    private class SpanIndex {
        public int end;
        public int start;

        private SpanIndex() {
        }
    }

    public DittoTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DittoTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DittoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49951c = new float[8];
        this.f49962p = false;
        this.f49950b = context;
        this.f49954f = new RectF();
        this.f49952d = new Path();
        Paint paint = new Paint();
        this.f49953e = paint;
        paint.setAntiAlias(true);
        this.f49953e.setColor(0);
        this.f49953e.setStyle(Paint.Style.STROKE);
    }

    public void generateRichText() {
        String str = this.f49957i;
        if (this.f49962p) {
            LEGORichInfo lEGORichInfo = new LEGORichInfo();
            lEGORichInfo.setInfo(str);
            lEGORichInfo.bindTextView(this);
            return;
        }
        Matcher matcher = f49949n.matcher(str);
        ArrayList<SpanIndex> arrayList = new ArrayList<>();
        boolean z = false;
        int i = 0;
        while (matcher.find()) {
            i++;
            SpanIndex spanIndex = new SpanIndex();
            int i2 = (i - 1) * 2;
            spanIndex.start = (matcher.start(1) - i2) - 1;
            spanIndex.end = (matcher.end(1) - i2) - 1;
            str = str.replace(matcher.group(0), matcher.group(1));
            arrayList.add(spanIndex);
            z = true;
        }
        if (z) {
            SpannableString spannableString = new SpannableString(str);
            for (SpanIndex spanIndex2 : arrayList) {
                if (!TextUtils.isEmpty(this.f49958j)) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f49958j)), spanIndex2.start, spanIndex2.end, 18);
                }
                if (!TextUtils.isEmpty(this.f49959k)) {
                    spannableString.setSpan(new AbsoluteSizeSpan(Integer.parseInt(this.f49959k), true), spanIndex2.start, spanIndex2.end, 18);
                }
                if (!TextUtils.isEmpty(this.f49960l)) {
                    if ("striping".equals(this.f49960l)) {
                        spannableString.setSpan(new StrikethroughSpan(), spanIndex2.start, spanIndex2.end, 18);
                    } else {
                        spannableString.setSpan(new GlobalTypeFaceSpan(DIDIFontUtils.Companion.getDidiTypeface(getContext(), Typeface.defaultFromStyle(1))), spanIndex2.start, spanIndex2.end, 18);
                    }
                }
                super.setText(spannableString);
            }
            return;
        }
        super.setText(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r7, java.lang.String r8, com.facebook.yoga.YogaNode r9) {
        /*
            r6 = this;
            int r9 = r7.hashCode()
            r0 = 0
            r1 = 1
            switch(r9) {
                case -1063571914: goto L_0x0067;
                case -1048634236: goto L_0x005d;
                case -1003668786: goto L_0x0053;
                case -808924190: goto L_0x0049;
                case -793986512: goto L_0x003e;
                case 3556653: goto L_0x0034;
                case 109780401: goto L_0x002a;
                case 390018978: goto L_0x001f;
                case 390232059: goto L_0x0015;
                case 2042756918: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0071
        L_0x000b:
            java.lang.String r9 = "textAlignment"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 6
            goto L_0x0072
        L_0x0015:
            java.lang.String r9 = "maxLines"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 5
            goto L_0x0072
        L_0x001f:
            java.lang.String r9 = "highlightTextSize"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 8
            goto L_0x0072
        L_0x002a:
            java.lang.String r9 = "style"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 0
            goto L_0x0072
        L_0x0034:
            java.lang.String r9 = "text"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 1
            goto L_0x0072
        L_0x003e:
            java.lang.String r9 = "highlightTextStyle"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 9
            goto L_0x0072
        L_0x0049:
            java.lang.String r9 = "highlightTextColor"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 7
            goto L_0x0072
        L_0x0053:
            java.lang.String r9 = "textSize"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 3
            goto L_0x0072
        L_0x005d:
            java.lang.String r9 = "textStyle"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 4
            goto L_0x0072
        L_0x0067:
            java.lang.String r9 = "textColor"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0071
            r9 = 2
            goto L_0x0072
        L_0x0071:
            r9 = -1
        L_0x0072:
            switch(r9) {
                case 0: goto L_0x00d8;
                case 1: goto L_0x00d5;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00ab;
                case 5: goto L_0x009e;
                case 6: goto L_0x009b;
                case 7: goto L_0x0098;
                case 8: goto L_0x0095;
                case 9: goto L_0x0092;
                default: goto L_0x0075;
            }
        L_0x0075:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "parse exception, Unknown view param: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r2 = r8.toString()
            r0 = 6
            r3 = 0
            r5 = 175(0xaf, float:2.45E-43)
            java.lang.String r1 = "Ditto"
            java.lang.String r4 = "com.didiglobal.dittoview.view.DittoTextView"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            goto L_0x00e5
        L_0x0092:
            r6.f49960l = r8
            goto L_0x00e5
        L_0x0095:
            r6.f49959k = r8
            goto L_0x00e5
        L_0x0098:
            r6.f49958j = r8
            goto L_0x00e5
        L_0x009b:
            r6.f49961o = r8
            goto L_0x00e5
        L_0x009e:
            int r7 = java.lang.Integer.parseInt(r8)
            r6.setMaxLines(r7)
            android.text.TextUtils$TruncateAt r7 = android.text.TextUtils.TruncateAt.END
            r6.setEllipsize(r7)
            goto L_0x00e5
        L_0x00ab:
            java.lang.String r7 = "striping"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00bd
            android.text.TextPaint r7 = r6.getPaint()
            r8 = 16
            r7.setFlags(r8)
            goto L_0x00e5
        L_0x00bd:
            android.graphics.Typeface r7 = android.graphics.Typeface.defaultFromStyle(r1)
            r6.setTypeface(r7)
            goto L_0x00e5
        L_0x00c5:
            float r7 = java.lang.Float.parseFloat(r8)
            r6.setTextSize(r7)
            goto L_0x00e5
        L_0x00cd:
            int r7 = android.graphics.Color.parseColor(r8)
            r6.setTextColor(r7)
            goto L_0x00e5
        L_0x00d5:
            r6.f49957i = r8
            goto L_0x00e5
        L_0x00d8:
            java.lang.String r7 = "rich_text"
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00e3
            r6.f49962p = r1
            goto L_0x00e5
        L_0x00e3:
            r6.f49962p = r0
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoTextView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(DIDIFontUtils.Companion.getDidiTypeface(getContext(), typeface));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r1.equals("left") != false) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onParseEnd() {
        /*
            r7 = this;
            r7.generateRichText()
            r0 = 0
            r7.setIncludeFontPadding(r0)
            java.lang.String r1 = r7.f49961o
            if (r1 == 0) goto L_0x0056
            r2 = -1
            int r3 = r1.hashCode()
            r4 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x0035
            r4 = 3317767(0x32a007, float:4.649182E-39)
            if (r3 == r4) goto L_0x002c
            r0 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r3 == r0) goto L_0x0022
            goto L_0x003f
        L_0x0022:
            java.lang.String r0 = "right"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x002c:
            java.lang.String r3 = "left"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x003f
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "center"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 2
            goto L_0x0040
        L_0x003f:
            r0 = -1
        L_0x0040:
            if (r0 == 0) goto L_0x0052
            if (r0 == r6) goto L_0x004d
            if (r0 == r5) goto L_0x0047
            goto L_0x0056
        L_0x0047:
            r0 = 17
            r7.setGravity(r0)
            goto L_0x0056
        L_0x004d:
            r0 = 5
            r7.setGravity(r0)
            goto L_0x0056
        L_0x0052:
            r0 = 3
            r7.setGravity(r0)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoTextView.onParseEnd():void");
    }

    public void setBorder(DittoBorder dittoBorder) {
        this.f49956h = dittoBorder.getBorderWidth() > 0.0f;
        float borderWidth = dittoBorder.getBorderWidth();
        this.f49955g = borderWidth;
        this.f49953e.setStrokeWidth((float) DittoUtil.dip2px(this.f49950b, borderWidth));
        this.f49953e.setColor(dittoBorder.getBorderColor());
    }

    public void setCorner(DittoCorner dittoCorner) {
        float[] fArr = this.f49951c;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f49951c;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f49951c;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f49951c;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f49956h) {
            this.f49952d.reset();
            this.f49954f.left = ((float) DittoUtil.dip2px(this.f49950b, this.f49955g)) / 2.0f;
            this.f49954f.top = ((float) DittoUtil.dip2px(this.f49950b, this.f49955g)) / 2.0f;
            this.f49954f.right = ((float) getMeasuredWidth()) - (((float) DittoUtil.dip2px(this.f49950b, this.f49955g)) / 2.0f);
            this.f49954f.bottom = ((float) getMeasuredHeight()) - (((float) DittoUtil.dip2px(this.f49950b, this.f49955g)) / 2.0f);
            this.f49952d.addRoundRect(this.f49954f, this.f49951c, Path.Direction.CW);
            canvas.drawPath(this.f49952d, this.f49953e);
        }
    }
}
