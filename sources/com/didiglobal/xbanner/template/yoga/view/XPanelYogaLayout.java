package com.didiglobal.xbanner.template.yoga.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didiglobal.xbanner.template.yoga.IParser;
import com.didiglobal.xbanner.template.yoga.IView;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import org.xmlpull.v1.XmlPullParser;

public class XPanelYogaLayout extends YogaLayout implements IParser, IView {

    /* renamed from: a */
    private Context f51583a;

    /* renamed from: b */
    private YogaNode f51584b;

    /* renamed from: c */
    private boolean f51585c;

    /* renamed from: d */
    private Path f51586d;

    /* renamed from: e */
    private Paint f51587e;

    /* renamed from: f */
    private RectF f51588f;

    /* renamed from: g */
    private float f51589g;

    /* renamed from: h */
    private float[] f51590h;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public XPanelYogaLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelYogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelYogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f51590h = new float[8];
        this.f51583a = context;
        this.f51584b = getYogaNode();
        this.f51588f = new RectF();
        this.f51586d = new Path();
        Paint paint = new Paint();
        this.f51587e = paint;
        paint.setAntiAlias(true);
        this.f51587e.setColor(0);
        this.f51587e.setStyle(Paint.Style.STROKE);
    }

    public void parse(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "flex-direction");
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "flex-wrap");
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "justify-content");
        String attributeValue4 = xmlPullParser.getAttributeValue((String) null, "align-items");
        String attributeValue5 = xmlPullParser.getAttributeValue((String) null, "align-content");
        if (!TextUtils.isEmpty(attributeValue)) {
            this.f51584b.setFlexDirection(getFlexDirection(attributeValue));
        }
        if (!TextUtils.isEmpty(attributeValue2)) {
            this.f51584b.setWrap(getFlexWrap(attributeValue2));
        }
        if (!TextUtils.isEmpty(attributeValue3)) {
            this.f51584b.setJustifyContent(getJustifyContent(attributeValue3));
        }
        if (!TextUtils.isEmpty(attributeValue4)) {
            this.f51584b.setAlignItems(getAlignItems(attributeValue4));
        }
        if (!TextUtils.isEmpty(attributeValue5)) {
            this.f51584b.setAlignContent(getAlignContent(attributeValue5));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r2, java.lang.String r3, com.facebook.yoga.YogaNode r4) {
        /*
            r1 = this;
            int r4 = r2.hashCode()
            switch(r4) {
                case -1802500706: goto L_0x0044;
                case -903579360: goto L_0x003a;
                case 109780401: goto L_0x0030;
                case 122090044: goto L_0x0026;
                case 587430648: goto L_0x001c;
                case 695731883: goto L_0x0012;
                case 715446705: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r4 = "align-content"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 4
            goto L_0x004f
        L_0x0012:
            java.lang.String r4 = "flex-direction"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 0
            goto L_0x004f
        L_0x001c:
            java.lang.String r4 = "align-items"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r4 = "justify-content"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 2
            goto L_0x004f
        L_0x0030:
            java.lang.String r4 = "style"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r4 = "shadow"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 5
            goto L_0x004f
        L_0x0044:
            java.lang.String r4 = "flex-wrap"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x004e
            r4 = 1
            goto L_0x004f
        L_0x004e:
            r4 = -1
        L_0x004f:
            switch(r4) {
                case 0: goto L_0x0091;
                case 1: goto L_0x0087;
                case 2: goto L_0x007d;
                case 3: goto L_0x0073;
                case 4: goto L_0x0069;
                case 5: goto L_0x009a;
                case 6: goto L_0x009a;
                default: goto L_0x0052;
            }
        L_0x0052:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unknown view param: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x0069:
            com.facebook.yoga.YogaNode r2 = r1.f51584b
            com.facebook.yoga.YogaAlign r3 = r1.getAlignContent(r3)
            r2.setAlignContent(r3)
            goto L_0x009a
        L_0x0073:
            com.facebook.yoga.YogaNode r2 = r1.f51584b
            com.facebook.yoga.YogaAlign r3 = r1.getAlignItems(r3)
            r2.setAlignItems(r3)
            goto L_0x009a
        L_0x007d:
            com.facebook.yoga.YogaNode r2 = r1.f51584b
            com.facebook.yoga.YogaJustify r3 = r1.getJustifyContent(r3)
            r2.setJustifyContent(r3)
            goto L_0x009a
        L_0x0087:
            com.facebook.yoga.YogaNode r2 = r1.f51584b
            com.facebook.yoga.YogaWrap r3 = r1.getFlexWrap(r3)
            r2.setWrap(r3)
            goto L_0x009a
        L_0x0091:
            com.facebook.yoga.YogaNode r2 = r1.f51584b
            com.facebook.yoga.YogaFlexDirection r3 = r1.getFlexDirection(r3)
            r2.setFlexDirection(r3)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelYogaLayout.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaWrap getFlexWrap(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1039592053(0xffffffffc209158b, float:-34.271038)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -749527969(0xffffffffd3531c5f, float:-9.0671409E11)
            if (r0 == r1) goto L_0x0020
            r1 = 3657802(0x37d04a, float:5.125672E-39)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "wrap"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "wrap-reverse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "nowrap"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0058
            if (r0 == r3) goto L_0x0055
            if (r0 != r2) goto L_0x003e
            com.facebook.yoga.YogaWrap r5 = com.facebook.yoga.YogaWrap.WRAP_REVERSE
            return r5
        L_0x003e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0055:
            com.facebook.yoga.YogaWrap r5 = com.facebook.yoga.YogaWrap.WRAP
            return r5
        L_0x0058:
            com.facebook.yoga.YogaWrap r5 = com.facebook.yoga.YogaWrap.NO_WRAP
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelYogaLayout.getFlexWrap(java.lang.String):com.facebook.yoga.YogaWrap");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaFlexDirection getFlexDirection(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1448970769: goto L_0x0029;
                case -1354837162: goto L_0x001f;
                case 113114: goto L_0x0015;
                case 1272730475: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "column-reverse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "row"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 2
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "column"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "row-reverse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            if (r0 == 0) goto L_0x005c
            if (r0 == r3) goto L_0x0059
            if (r0 == r2) goto L_0x0056
            if (r0 != r1) goto L_0x003f
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.ROW_REVERSE
            return r5
        L_0x003f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0056:
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.ROW
            return r5
        L_0x0059:
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.COLUMN_REVERSE
            return r5
        L_0x005c:
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.COLUMN
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelYogaLayout.getFlexDirection(java.lang.String):com.facebook.yoga.YogaFlexDirection");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaJustify getJustifyContent(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L_0x0034;
                case -46581362: goto L_0x002a;
                case 441309761: goto L_0x0020;
                case 1742952711: goto L_0x0016;
                case 1937124468: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "space-around"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 4
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "flex-end"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "space-between"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 3
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "flex-start"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "center"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            if (r0 == 0) goto L_0x006c
            if (r0 == r4) goto L_0x0069
            if (r0 == r3) goto L_0x0066
            if (r0 == r2) goto L_0x0063
            if (r0 != r1) goto L_0x004c
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.SPACE_AROUND
            return r6
        L_0x004c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0063:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.SPACE_BETWEEN
            return r6
        L_0x0066:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.FLEX_END
            return r6
        L_0x0069:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.CENTER
            return r6
        L_0x006c:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.FLEX_START
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelYogaLayout.getJustifyContent(java.lang.String):com.facebook.yoga.YogaJustify");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaAlign getAlignItems(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            switch(r0) {
                case -1881872635: goto L_0x004e;
                case -1720785339: goto L_0x0044;
                case -1364013995: goto L_0x003a;
                case -46581362: goto L_0x0030;
                case 3005871: goto L_0x0026;
                case 441309761: goto L_0x001c;
                case 1742952711: goto L_0x0012;
                case 1937124468: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0058
        L_0x0008:
            java.lang.String r0 = "space-around"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 7
            goto L_0x0059
        L_0x0012:
            java.lang.String r0 = "flex-end"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 3
            goto L_0x0059
        L_0x001c:
            java.lang.String r0 = "space-between"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 6
            goto L_0x0059
        L_0x0026:
            java.lang.String r0 = "auto"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 0
            goto L_0x0059
        L_0x0030:
            java.lang.String r0 = "flex-start"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "center"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 2
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "baseline"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 5
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "stretch"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 4
            goto L_0x0059
        L_0x0058:
            r0 = -1
        L_0x0059:
            switch(r0) {
                case 0: goto L_0x0088;
                case 1: goto L_0x0085;
                case 2: goto L_0x0082;
                case 3: goto L_0x007f;
                case 4: goto L_0x007c;
                case 5: goto L_0x0079;
                case 6: goto L_0x0076;
                case 7: goto L_0x0073;
                default: goto L_0x005c;
            }
        L_0x005c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0073:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.SPACE_AROUND
            return r4
        L_0x0076:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.SPACE_BETWEEN
            return r4
        L_0x0079:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.BASELINE
            return r4
        L_0x007c:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.STRETCH
            return r4
        L_0x007f:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.FLEX_END
            return r4
        L_0x0082:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.CENTER
            return r4
        L_0x0085:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.FLEX_START
            return r4
        L_0x0088:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.AUTO
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.view.XPanelYogaLayout.getAlignItems(java.lang.String):com.facebook.yoga.YogaAlign");
    }

    public YogaAlign getAlignContent(String str) {
        return getAlignItems(str);
    }

    public void setBorder(Border border) {
        this.f51585c = true;
        float borderWidth = border.getBorderWidth();
        this.f51589g = borderWidth;
        this.f51587e.setStrokeWidth(borderWidth);
        this.f51587e.setColor(border.getBorderColor());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f51585c) {
            this.f51586d.reset();
            this.f51588f.left = this.f51589g / 2.0f;
            this.f51588f.top = this.f51589g / 2.0f;
            this.f51588f.right = ((float) getMeasuredWidth()) - (this.f51589g / 2.0f);
            this.f51588f.bottom = ((float) getMeasuredHeight()) - (this.f51589g / 2.0f);
            this.f51586d.addRoundRect(this.f51588f, this.f51590h, Path.Direction.CW);
            canvas.drawPath(this.f51586d, this.f51587e);
        }
    }

    public void setCorner(Corner corner) {
        float[] fArr = this.f51590h;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f51590h;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f51590h;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f51590h;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
    }
}
