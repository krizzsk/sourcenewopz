package com.didiglobal.xbanner.template.yoga.view;

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
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.GlobalTypeFaceSpan;
import com.didiglobal.xbanner.template.yoga.IParser;
import com.didiglobal.xbanner.template.yoga.IView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XPanelTextView extends TextView implements IParser, IView {

    /* renamed from: a */
    private static final String f51568a = "XPanelTextView";

    /* renamed from: m */
    private static String f51569m = "\\{(.*?)\\}";

    /* renamed from: n */
    private static Pattern f51570n = Pattern.compile("\\{(.*?)\\}");

    /* renamed from: b */
    private Context f51571b;

    /* renamed from: c */
    private float[] f51572c;

    /* renamed from: d */
    private Path f51573d;

    /* renamed from: e */
    private Paint f51574e;

    /* renamed from: f */
    private RectF f51575f;

    /* renamed from: g */
    private float f51576g;

    /* renamed from: h */
    private boolean f51577h;

    /* renamed from: i */
    private String f51578i;

    /* renamed from: j */
    private String f51579j;

    /* renamed from: k */
    private String f51580k;

    /* renamed from: l */
    private String f51581l;

    /* renamed from: o */
    private String f51582o;

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
        this.f51572c = new float[8];
        this.f51571b = context;
        this.f51575f = new RectF();
        this.f51573d = new Path();
        Paint paint = new Paint();
        this.f51574e = paint;
        paint.setAntiAlias(true);
        this.f51574e.setColor(0);
        this.f51574e.setStyle(Paint.Style.STROKE);
    }

    public void generateRichText() {
        String str = this.f51578i.toString();
        Matcher matcher = f51570n.matcher(this.f51578i);
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
                if (!TextUtils.isEmpty(this.f51579j)) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.f51579j)), spanIndex2.start, spanIndex2.end, 18);
                }
                if (!TextUtils.isEmpty(this.f51580k)) {
                    spannableString.setSpan(new AbsoluteSizeSpan(Integer.parseInt(this.f51580k), true), spanIndex2.start, spanIndex2.end, 18);
                }
                if (!TextUtils.isEmpty(this.f51581l)) {
                    if ("striping".equals(this.f51581l)) {
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
                case -1063571914: goto L_0x005a;
                case -1048634236: goto L_0x0050;
                case -1003668786: goto L_0x0046;
                case -808924190: goto L_0x003c;
                case -793986512: goto L_0x0031;
                case 3556653: goto L_0x0027;
                case 390018978: goto L_0x001d;
                case 390232059: goto L_0x0013;
                case 2042756918: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0064
        L_0x0009:
            java.lang.String r4 = "textAlignment"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 5
            goto L_0x0065
        L_0x0013:
            java.lang.String r4 = "maxLines"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 4
            goto L_0x0065
        L_0x001d:
            java.lang.String r4 = "highlightTextSize"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 7
            goto L_0x0065
        L_0x0027:
            java.lang.String r4 = "text"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 0
            goto L_0x0065
        L_0x0031:
            java.lang.String r4 = "highlightTextStyle"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 8
            goto L_0x0065
        L_0x003c:
            java.lang.String r4 = "highlightTextColor"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 6
            goto L_0x0065
        L_0x0046:
            java.lang.String r4 = "textSize"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r4 = "textStyle"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 3
            goto L_0x0065
        L_0x005a:
            java.lang.String r4 = "textColor"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0064
            r4 = 1
            goto L_0x0065
        L_0x0064:
            r4 = -1
        L_0x0065:
            switch(r4) {
                case 0: goto L_0x00c2;
                case 1: goto L_0x00ba;
                case 2: goto L_0x00b2;
                case 3: goto L_0x0098;
                case 4: goto L_0x008b;
                case 5: goto L_0x0088;
                case 6: goto L_0x0085;
                case 7: goto L_0x0082;
                case 8: goto L_0x007f;
                default: goto L_0x0068;
            }
        L_0x0068:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unknown view param: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x007f:
            r1.f51581l = r3
            goto L_0x00c4
        L_0x0082:
            r1.f51580k = r3
            goto L_0x00c4
        L_0x0085:
            r1.f51579j = r3
            goto L_0x00c4
        L_0x0088:
            r1.f51582o = r3
            goto L_0x00c4
        L_0x008b:
            int r2 = java.lang.Integer.parseInt(r3)
            r1.setMaxLines(r2)
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.END
            r1.setEllipsize(r2)
            goto L_0x00c4
        L_0x0098:
            java.lang.String r2 = "striping"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00aa
            android.text.TextPaint r2 = r1.getPaint()
            r3 = 16
            r2.setFlags(r3)
            goto L_0x00c4
        L_0x00aa:
            android.graphics.Typeface r2 = android.graphics.Typeface.defaultFromStyle(r0)
            r1.setTypeface(r2)
            goto L_0x00c4
        L_0x00b2:
            float r2 = java.lang.Float.parseFloat(r3)
            r1.setTextSize(r2)
            goto L_0x00c4
        L_0x00ba:
            int r2 = android.graphics.Color.parseColor(r3)
            r1.setTextColor(r2)
            goto L_0x00c4
        L_0x00c2:
            r1.f51578i = r3
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelTextView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(DIDIFontUtils.Companion.getDidiTypeface(getContext(), typeface));
    }

    public void onParseEnd() {
        generateRichText();
        String str = this.f51582o;
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 3317767) {
                    if (hashCode == 108511772 && str.equals("right")) {
                        c = 1;
                    }
                } else if (str.equals("left")) {
                    c = 0;
                }
            } else if (str.equals("center")) {
                c = 2;
            }
            if (c == 0) {
                setGravity(3);
            } else if (c == 1) {
                setGravity(5);
            } else if (c == 2) {
                setGravity(17);
            }
        }
    }

    public void setBorder(Border border) {
        this.f51577h = border.getBorderWidth() > 0.0f;
        float borderWidth = border.getBorderWidth();
        this.f51576g = borderWidth;
        this.f51574e.setStrokeWidth(borderWidth);
        this.f51574e.setColor(border.getBorderColor());
    }

    public void setCorner(Corner corner) {
        float[] fArr = this.f51572c;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f51572c;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f51572c;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f51572c;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f51577h) {
            this.f51573d.reset();
            this.f51575f.left = this.f51576g / 2.0f;
            this.f51575f.top = this.f51576g / 2.0f;
            this.f51575f.right = ((float) getMeasuredWidth()) - (this.f51576g / 2.0f);
            this.f51575f.bottom = ((float) getMeasuredHeight()) - (this.f51576g / 2.0f);
            this.f51573d.addRoundRect(this.f51575f, this.f51572c, Path.Direction.CW);
            canvas.drawPath(this.f51573d, this.f51574e);
        }
    }
}
