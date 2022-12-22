package com.didi.global.globalgenerickit.template.yoga.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.didi.global.globalgenerickit.template.yoga.IParser;

public class XPanelImageView extends ImageView implements IParser {

    /* renamed from: a */
    private Context f22253a;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public XPanelImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ImageView.ScaleType.FIT_XY);
        this.f22253a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r6.equals("fitXY") != false) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r5, java.lang.String r6, com.facebook.yoga.YogaNode r7) {
        /*
            r4 = this;
            int r7 = r5.hashCode()
            r0 = -1877911644(0xffffffff901157a4, float:-2.8663724E-29)
            r1 = 0
            r2 = -1
            r3 = 1
            if (r7 == r0) goto L_0x001c
            r0 = 1900782901(0x714ba535, float:1.0084029E30)
            if (r7 == r0) goto L_0x0012
            goto L_0x0027
        L_0x0012:
            java.lang.String r7 = "localRes"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0027
            r7 = 0
            goto L_0x0028
        L_0x001c:
            java.lang.String r7 = "scaleType"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0027
            r7 = 1
            goto L_0x0028
        L_0x0027:
            r7 = -1
        L_0x0028:
            if (r7 == 0) goto L_0x009a
            if (r7 != r3) goto L_0x0083
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x00b5
            int r5 = r6.hashCode()
            r7 = -340708175(0xffffffffebb134b1, float:-4.284574E26)
            r0 = 2
            if (r5 == r7) goto L_0x005a
            r7 = 97441490(0x5ced6d2, float:1.945106E-35)
            if (r5 == r7) goto L_0x0051
            r7 = 1161480325(0x453ac885, float:2988.5325)
            if (r5 == r7) goto L_0x0047
            goto L_0x0064
        L_0x0047:
            java.lang.String r5 = "centerCrop"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0064
            r1 = 2
            goto L_0x0065
        L_0x0051:
            java.lang.String r5 = "fitXY"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0064
            goto L_0x0065
        L_0x005a:
            java.lang.String r5 = "centerInside"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0064
            r1 = 1
            goto L_0x0065
        L_0x0064:
            r1 = -1
        L_0x0065:
            if (r1 == 0) goto L_0x007d
            if (r1 == r3) goto L_0x0077
            if (r1 == r0) goto L_0x0071
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.FIT_CENTER
            r4.setScaleType(r5)
            goto L_0x00b5
        L_0x0071:
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP
            r4.setScaleType(r5)
            goto L_0x00b5
        L_0x0077:
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_INSIDE
            r4.setScaleType(r5)
            goto L_0x00b5
        L_0x007d:
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.FIT_XY
            r4.setScaleType(r5)
            goto L_0x00b5
        L_0x0083:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown view param: "
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L_0x009a:
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x00b5
            android.content.Context r5 = r4.f22253a
            android.content.res.Resources r5 = r5.getResources()
            android.content.Context r7 = r4.f22253a
            java.lang.String r7 = r7.getPackageName()
            java.lang.String r0 = "drawable"
            int r5 = r5.getIdentifier(r6, r0, r7)
            r4.setImageResource(r5)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.view.XPanelImageView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }
}
