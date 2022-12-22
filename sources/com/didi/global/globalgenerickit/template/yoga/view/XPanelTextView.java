package com.didi.global.globalgenerickit.template.yoga.view;

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
import com.didi.global.globalgenerickit.template.yoga.IParser;
import com.didi.global.globalgenerickit.template.yoga.IView;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.GlobalTypeFaceSpan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XPanelTextView extends TextView implements IParser, IView {

    /* renamed from: a */
    private static final String f22277a = "XPanelTextView";

    /* renamed from: m */
    private static String f22278m = "\\{(.*?)\\}";

    /* renamed from: n */
    private static Pattern f22279n = Pattern.compile("\\{(.*?)\\}");

    /* renamed from: b */
    private Context f22280b;

    /* renamed from: c */
    private float[] f22281c;

    /* renamed from: d */
    private Path f22282d;

    /* renamed from: e */
    private Paint f22283e;

    /* renamed from: f */
    private RectF f22284f;

    /* renamed from: g */
    private float f22285g;

    /* renamed from: h */
    private boolean f22286h;

    /* renamed from: i */
    private String f22287i;

    /* renamed from: j */
    private String f22288j;

    /* renamed from: k */
    private String f22289k;

    /* renamed from: l */
    private String f22290l;

    /* renamed from: o */
    private String f22291o;

    public View getView() {
        return this;
    }

    private class SpanIndex {
        public int end;
        public int start;

        private SpanIndex() {
        }
    }

    public XPanelTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22281c = new float[8];
        this.f22280b = context;
        this.f22284f = new RectF();
        this.f22282d = new Path();
        Paint paint = new Paint();
        this.f22283e = paint;
        paint.setAntiAlias(true);
        this.f22283e.setColor(0);
        this.f22283e.setStyle(Paint.Style.STROKE);
    }

    public void generateRichText() {
        String str = this.f22287i.toString();
        Matcher matcher = f22279n.matcher(this.f22287i);
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
                if (!TextUtils.isEmpty(this.f22288j)) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f22288j)), spanIndex2.start, spanIndex2.end, 18);
                }
                if (!TextUtils.isEmpty(this.f22289k)) {
                    spannableString.setSpan(new AbsoluteSizeSpan(Integer.parseInt(this.f22289k), true), spanIndex2.start, spanIndex2.end, 18);
                }
                if (!TextUtils.isEmpty(this.f22290l)) {
                    if ("striping".equals(this.f22290l)) {
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
    public void parse(java.lang.String r2, java.lang.String r3, com.facebook.yoga.YogaNode r4) {
        /*
            r1 = this;
            int r4 = r2.hashCode()
            r0 = 1
            switch(r4) {
                case -1063571914: goto L_0x005e;
                case -1048634236: goto L_0x0053;
                case -1003668786: goto L_0x0048;
                case -808924190: goto L_0x003e;
                case -793986512: goto L_0x0033;
                case 3556653: goto L_0x0028;
                case 390018978: goto L_0x001e;
                case 390232059: goto L_0x0014;
                case 2042756918: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0069
        L_0x0009:
            java.lang.String r4 = "textAlignment"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 5
            goto L_0x006a
        L_0x0014:
            java.lang.String r4 = "maxLines"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 4
            goto L_0x006a
        L_0x001e:
            java.lang.String r4 = "highlightTextSize"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 7
            goto L_0x006a
        L_0x0028:
            java.lang.String r4 = "text"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 0
            goto L_0x006a
        L_0x0033:
            java.lang.String r4 = "highlightTextStyle"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 8
            goto L_0x006a
        L_0x003e:
            java.lang.String r4 = "highlightTextColor"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 6
            goto L_0x006a
        L_0x0048:
            java.lang.String r4 = "textSize"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 2
            goto L_0x006a
        L_0x0053:
            java.lang.String r4 = "textStyle"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 3
            goto L_0x006a
        L_0x005e:
            java.lang.String r4 = "textColor"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0069
            r4 = 1
            goto L_0x006a
        L_0x0069:
            r4 = -1
        L_0x006a:
            switch(r4) {
                case 0: goto L_0x00c8;
                case 1: goto L_0x00c0;
                case 2: goto L_0x00b8;
                case 3: goto L_0x009d;
                case 4: goto L_0x0090;
                case 5: goto L_0x008d;
                case 6: goto L_0x008a;
                case 7: goto L_0x0087;
                case 8: goto L_0x0084;
                default: goto L_0x006d;
            }
        L_0x006d:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unknown view param: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x0084:
            r1.f22290l = r3
            goto L_0x00ca
        L_0x0087:
            r1.f22289k = r3
            goto L_0x00ca
        L_0x008a:
            r1.f22288j = r3
            goto L_0x00ca
        L_0x008d:
            r1.f22291o = r3
            goto L_0x00ca
        L_0x0090:
            int r2 = java.lang.Integer.parseInt(r3)
            r1.setMaxLines(r2)
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.END
            r1.setEllipsize(r2)
            goto L_0x00ca
        L_0x009d:
            java.lang.String r2 = "striping"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00b0
            android.text.TextPaint r2 = r1.getPaint()
            r3 = 16
            r2.setFlags(r3)
            goto L_0x00ca
        L_0x00b0:
            android.graphics.Typeface r2 = android.graphics.Typeface.defaultFromStyle(r0)
            r1.setTypeface(r2)
            goto L_0x00ca
        L_0x00b8:
            float r2 = java.lang.Float.parseFloat(r3)
            r1.setTextSize(r2)
            goto L_0x00ca
        L_0x00c0:
            int r2 = android.graphics.Color.parseColor(r3)
            r1.setTextColor(r2)
            goto L_0x00ca
        L_0x00c8:
            r1.f22287i = r3
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.view.XPanelTextView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(DIDIFontUtils.Companion.getDidiTypeface(getContext(), typeface));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r1.equals("left") != false) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onParseEnd() {
        /*
            r7 = this;
            r7.generateRichText()
            r0 = 0
            r7.setIncludeFontPadding(r0)
            java.lang.String r1 = r7.f22291o
            if (r1 == 0) goto L_0x0057
            r2 = -1
            int r3 = r1.hashCode()
            r4 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x0036
            r4 = 3317767(0x32a007, float:4.649182E-39)
            if (r3 == r4) goto L_0x002d
            r0 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r3 == r0) goto L_0x0022
            goto L_0x0040
        L_0x0022:
            java.lang.String r0 = "right"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0040
            r0 = 1
            goto L_0x0041
        L_0x002d:
            java.lang.String r3 = "left"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0036:
            java.lang.String r0 = "center"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0040
            r0 = 2
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            if (r0 == 0) goto L_0x0053
            if (r0 == r6) goto L_0x004e
            if (r0 == r5) goto L_0x0048
            goto L_0x0057
        L_0x0048:
            r0 = 17
            r7.setGravity(r0)
            goto L_0x0057
        L_0x004e:
            r0 = 5
            r7.setGravity(r0)
            goto L_0x0057
        L_0x0053:
            r0 = 3
            r7.setGravity(r0)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.view.XPanelTextView.onParseEnd():void");
    }

    public void setBorder(Border border) {
        this.f22286h = border.getBorderWidth() > 0.0f;
        float borderWidth = border.getBorderWidth();
        this.f22285g = borderWidth;
        this.f22283e.setStrokeWidth((float) UiUtils.dip2px(this.f22280b, borderWidth));
        this.f22283e.setColor(border.getBorderColor());
    }

    public void setCorner(Corner corner) {
        float[] fArr = this.f22281c;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f22281c;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f22281c;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f22281c;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f22286h) {
            this.f22282d.reset();
            this.f22284f.left = ((float) UiUtils.dip2px(this.f22280b, this.f22285g)) / 2.0f;
            this.f22284f.top = ((float) UiUtils.dip2px(this.f22280b, this.f22285g)) / 2.0f;
            this.f22284f.right = ((float) getMeasuredWidth()) - (((float) UiUtils.dip2px(this.f22280b, this.f22285g)) / 2.0f);
            this.f22284f.bottom = ((float) getMeasuredHeight()) - (((float) UiUtils.dip2px(this.f22280b, this.f22285g)) / 2.0f);
            this.f22282d.addRoundRect(this.f22284f, this.f22281c, Path.Direction.CW);
            canvas.drawPath(this.f22282d, this.f22283e);
        }
    }
}
