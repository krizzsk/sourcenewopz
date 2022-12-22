package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: com.didi.map.alpha.maps.internal.a */
/* compiled from: BlockBubbleDrawer */
class C9320a {

    /* renamed from: h */
    private static final String f24564h = "公里";

    /* renamed from: i */
    private static final String f24565i = "米";

    /* renamed from: j */
    private static final String f24566j = "小时";

    /* renamed from: k */
    private static final String f24567k = "分钟";

    /* renamed from: a */
    private LinearLayout f24568a;

    /* renamed from: b */
    private LinearLayout f24569b;

    /* renamed from: c */
    private LinearLayout f24570c;

    /* renamed from: d */
    private TextView f24571d;

    /* renamed from: e */
    private TextView f24572e;

    /* renamed from: f */
    private ImageView f24573f;

    /* renamed from: g */
    private TextView f24574g;

    C9320a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0139  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.widget.LinearLayout mo72349a(android.content.Context r18, com.didi.map.alpha.maps.internal.LableMarkerManager.BlockBubbleParams r19) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            r1 = r19
            monitor-enter(r17)
            int r2 = r1.blockBubbleType     // Catch:{ all -> 0x019b }
            r3 = 5
            if (r2 != r3) goto L_0x0012
            android.widget.LinearLayout r0 = r17.m17512b(r18, r19)     // Catch:{ all -> 0x019b }
            monitor-exit(r17)
            return r0
        L_0x0012:
            java.lang.String r2 = r1.text     // Catch:{ all -> 0x019b }
            float r9 = r1.textSize     // Catch:{ all -> 0x019b }
            int[] r10 = r1.textColors     // Catch:{ all -> 0x019b }
            int r3 = r1.blockBubbleType     // Catch:{ all -> 0x019b }
            int[] r11 = r1.padding     // Catch:{ all -> 0x019b }
            java.lang.String r12 = r1.fileName     // Catch:{ all -> 0x019b }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x019b }
            r4 = 0
            if (r1 == 0) goto L_0x0027
            monitor-exit(r17)
            return r4
        L_0x0027:
            java.lang.String r1 = "_"
            java.lang.String[] r13 = r2.split(r1)     // Catch:{ all -> 0x019b }
            int r1 = r13.length     // Catch:{ all -> 0x019b }
            r14 = 2
            if (r1 >= r14) goto L_0x003a
            java.lang.String r0 = "BlockLableBubble"
            java.lang.String r1 = "getRootLayoutView infoArray.length < 2"
            com.didi.hawaii.log.HWLog.m16761i(r0, r1)     // Catch:{ all -> 0x019b }
            monitor-exit(r17)
            return r4
        L_0x003a:
            android.widget.LinearLayout r1 = r8.f24568a     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x0045
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r1.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f24568a = r1     // Catch:{ all -> 0x019b }
        L_0x0045:
            android.widget.LinearLayout r1 = r8.f24568a     // Catch:{ all -> 0x019b }
            r1.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24568a     // Catch:{ all -> 0x019b }
            r15 = 1
            r1.setOrientation(r15)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24568a     // Catch:{ all -> 0x019b }
            r1.setGravity(r15)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r7 = -2
            r1.<init>(r7, r7)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f24568a     // Catch:{ all -> 0x019b }
            r2.setLayoutParams(r1)     // Catch:{ all -> 0x019b }
            r6 = 3
            r5 = 0
            if (r3 != r15) goto L_0x00d4
            int r1 = r13.length     // Catch:{ all -> 0x019b }
            if (r1 < r6) goto L_0x00d4
            r1 = r13[r14]     // Catch:{ all -> 0x019b }
            java.lang.String r2 = ","
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ all -> 0x019b }
            int r2 = r1.length     // Catch:{ all -> 0x019b }
            if (r2 < r14) goto L_0x00cb
            r16 = r10[r15]     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f24570c     // Catch:{ all -> 0x019b }
            if (r2 != 0) goto L_0x007f
            android.widget.LinearLayout r2 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r2.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f24570c = r2     // Catch:{ all -> 0x019b }
        L_0x007f:
            android.widget.LinearLayout r2 = r8.f24570c     // Catch:{ all -> 0x019b }
            r2.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f24570c     // Catch:{ all -> 0x019b }
            r2.setOrientation(r5)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r2.<init>(r7, r7)     // Catch:{ all -> 0x019b }
            r3 = r11[r5]     // Catch:{ all -> 0x019b }
            r4 = r11[r15]     // Catch:{ all -> 0x019b }
            r7 = r11[r14]     // Catch:{ all -> 0x019b }
            r14 = r11[r6]     // Catch:{ all -> 0x019b }
            r2.setMargins(r3, r4, r7, r14)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f24568a     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r4 = r8.f24570c     // Catch:{ all -> 0x019b }
            r3.addView(r4, r2)     // Catch:{ all -> 0x019b }
            android.widget.TextView r3 = r8.f24574g     // Catch:{ all -> 0x019b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x019b }
            r2.<init>()     // Catch:{ all -> 0x019b }
            r4 = r1[r5]     // Catch:{ all -> 0x019b }
            r2.append(r4)     // Catch:{ all -> 0x019b }
            r1 = r1[r15]     // Catch:{ all -> 0x019b }
            r2.append(r1)     // Catch:{ all -> 0x019b }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x019b }
            r7 = 1
            r1 = r17
            r2 = r18
            r14 = 0
            r5 = r9
            r14 = 3
            r6 = r16
            android.widget.TextView r1 = r1.m17509a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x019b }
            r8.f24574g = r1     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f24570c     // Catch:{ all -> 0x019b }
            r2.addView(r1)     // Catch:{ all -> 0x019b }
            goto L_0x00db
        L_0x00cb:
            r14 = 3
            java.lang.String r1 = "BlockLableBubble"
            java.lang.String r2 = "getTextLabels accidentInfo.length < 2"
            com.didi.hawaii.log.HWLog.m16761i(r1, r2)     // Catch:{ all -> 0x019b }
            goto L_0x00db
        L_0x00d4:
            r14 = 3
            if (r3 == r14) goto L_0x00de
            r1 = 4
            if (r3 != r1) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r1 = 0
            r14 = -2
            goto L_0x0133
        L_0x00de:
            int r1 = r13.length     // Catch:{ all -> 0x019b }
            if (r1 < r14) goto L_0x0131
            r1 = 2
            r4 = r13[r1]     // Catch:{ all -> 0x019b }
            r6 = r10[r15]     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24570c     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x00f1
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r1.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f24570c = r1     // Catch:{ all -> 0x019b }
        L_0x00f1:
            android.widget.LinearLayout r1 = r8.f24570c     // Catch:{ all -> 0x019b }
            r1.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24570c     // Catch:{ all -> 0x019b }
            r2 = 0
            r1.setOrientation(r2)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r7 = -2
            r1.<init>(r7, r7)     // Catch:{ all -> 0x019b }
            r3 = r11[r2]     // Catch:{ all -> 0x019b }
            r2 = r11[r15]     // Catch:{ all -> 0x019b }
            r5 = 2
            r7 = r11[r5]     // Catch:{ all -> 0x019b }
            r5 = r11[r14]     // Catch:{ all -> 0x019b }
            r1.setMargins(r3, r2, r7, r5)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f24568a     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f24570c     // Catch:{ all -> 0x019b }
            r2.addView(r3, r1)     // Catch:{ all -> 0x019b }
            android.widget.TextView r3 = r8.f24574g     // Catch:{ all -> 0x019b }
            r7 = 1
            r1 = r17
            r2 = r18
            r5 = r9
            r14 = -2
            android.widget.TextView r1 = r1.m17509a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x019b }
            r8.f24574g = r1     // Catch:{ all -> 0x019b }
            r2 = 17
            r1.setGravity(r2)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24570c     // Catch:{ all -> 0x019b }
            android.widget.TextView r2 = r8.f24574g     // Catch:{ all -> 0x019b }
            r1.addView(r2)     // Catch:{ all -> 0x019b }
            goto L_0x0132
        L_0x0131:
            r14 = -2
        L_0x0132:
            r1 = 0
        L_0x0133:
            r2 = r10[r1]     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24569b     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x0140
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r1.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f24569b = r1     // Catch:{ all -> 0x019b }
        L_0x0140:
            android.widget.LinearLayout r1 = r8.f24569b     // Catch:{ all -> 0x019b }
            r1.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24569b     // Catch:{ all -> 0x019b }
            r3 = 0
            r1.setOrientation(r3)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r1.<init>(r14, r14)     // Catch:{ all -> 0x019b }
            r4 = r11[r3]     // Catch:{ all -> 0x019b }
            r3 = r11[r15]     // Catch:{ all -> 0x019b }
            r5 = 2
            r5 = r11[r5]     // Catch:{ all -> 0x019b }
            r6 = 3
            r6 = r11[r6]     // Catch:{ all -> 0x019b }
            r1.setMargins(r4, r3, r5, r6)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f24568a     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r4 = r8.f24569b     // Catch:{ all -> 0x019b }
            r3.addView(r4, r1)     // Catch:{ all -> 0x019b }
            r1 = 0
            r1 = r13[r1]     // Catch:{ all -> 0x019b }
            android.widget.TextView r1 = r8.m17510a(r0, r1, r9, r2)     // Catch:{ all -> 0x019b }
            r8.f24571d = r1     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f24569b     // Catch:{ all -> 0x019b }
            r3.addView(r1)     // Catch:{ all -> 0x019b }
            r1 = r13[r15]     // Catch:{ all -> 0x019b }
            android.widget.TextView r1 = r8.m17513b(r0, r1, r9, r2)     // Catch:{ all -> 0x019b }
            r8.f24572e = r1     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r1.<init>(r14, r14)     // Catch:{ all -> 0x019b }
            r2 = 1093664768(0x41300000, float:11.0)
            int r2 = com.didi.hawaii.utils.DisplayUtils.dip2px(r0, r2)     // Catch:{ all -> 0x019b }
            r1.leftMargin = r2     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f24569b     // Catch:{ all -> 0x019b }
            android.widget.TextView r3 = r8.f24572e     // Catch:{ all -> 0x019b }
            r2.addView(r3, r1)     // Catch:{ all -> 0x019b }
            android.graphics.drawable.NinePatchDrawable r0 = com.didi.hawaii.utils.BitmapUtil.getNinePatchDrawable(r0, r12)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f24568a     // Catch:{ all -> 0x019b }
            r1.setBackgroundDrawable(r0)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r0 = r8.f24568a     // Catch:{ all -> 0x019b }
            monitor-exit(r17)
            return r0
        L_0x019b:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.alpha.maps.internal.C9320a.mo72349a(android.content.Context, com.didi.map.alpha.maps.internal.LableMarkerManager$BlockBubbleParams):android.widget.LinearLayout");
    }

    /* renamed from: b */
    private LinearLayout m17512b(Context context, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        String str = blockBubbleParams.text;
        float f = blockBubbleParams.textSize;
        int[] iArr = blockBubbleParams.textColors;
        int i = blockBubbleParams.blockBubbleType;
        int[] iArr2 = blockBubbleParams.padding;
        String str2 = blockBubbleParams.fileName;
        String str3 = blockBubbleParams.thumbUrl;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            HWLog.m16761i("BlockLableBubble", "getHorizontalRootLayoutView text =" + str + ", thumbUrl = " + str3);
            return null;
        }
        String[] split = str.split("_");
        if (split.length < 2) {
            HWLog.m16761i("BlockLableBubble", "getHorizontalRootLayoutView infoArray.length < 2");
            return null;
        }
        Bitmap loadBitmapFromUrl = BitmapUtil.loadBitmapFromUrl(str3, (AsyncNetUtils.Callback) null);
        if (loadBitmapFromUrl == null) {
            HWLog.m16761i("BlockLableBubble", "bitmap can't be null");
            return null;
        }
        if (this.f24568a == null) {
            this.f24568a = new LinearLayout(context);
        }
        this.f24568a.removeAllViews();
        this.f24568a.setOrientation(0);
        this.f24568a.setGravity(16);
        this.f24568a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (this.f24573f == null) {
            this.f24573f = new BlockBubbleDrawer$1(this, context);
        }
        this.f24573f.setBackgroundColor(Color.parseColor("#B3FFFFFF"));
        this.f24573f.setPadding(1, 1, 1, 1);
        this.f24573f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f24573f.setImageBitmap(loadBitmapFromUrl);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(context, 46.0f), DisplayUtils.dip2px(context, 46.0f));
        int dip2px = DisplayUtils.dip2px(context, 4.5f);
        layoutParams.setMargins(dip2px, dip2px, 0, dip2px);
        this.f24568a.addView(this.f24573f, layoutParams);
        int i2 = iArr[0];
        if (this.f24569b == null) {
            this.f24569b = new LinearLayout(context);
        }
        this.f24569b.removeAllViews();
        this.f24569b.setOrientation(1);
        this.f24569b.setGravity(3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(DisplayUtils.dip2px(context, 7.0f), iArr2[1], DisplayUtils.dip2px(context, 7.5f), iArr2[3]);
        this.f24568a.addView(this.f24569b, layoutParams2);
        this.f24571d = m17510a(context, split[0], f, i2);
        this.f24569b.addView(this.f24571d, new LinearLayout.LayoutParams(-2, -2));
        this.f24572e = m17513b(context, split[1], f, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = DisplayUtils.dip2px(context, 1.0f);
        this.f24569b.addView(this.f24572e, layoutParams3);
        this.f24568a.setBackgroundDrawable(BitmapUtil.getNinePatchDrawable(context, str2));
        return this.f24568a;
    }

    /* renamed from: a */
    private TextView m17510a(Context context, String str, float f, int i) {
        StringBuilder sb;
        String str2;
        int parseInt = Integer.parseInt(str);
        String a = m17511a(parseInt);
        if (parseInt < 1000) {
            sb = new StringBuilder();
            sb.append(a);
            str2 = f24565i;
        } else {
            sb = new StringBuilder();
            sb.append(a);
            str2 = f24564h;
        }
        sb.append(str2);
        return m17509a(context, this.f24571d, sb.toString(), f, i, true);
    }

    /* renamed from: b */
    private TextView m17513b(Context context, String str, float f, int i) {
        String[] b = m17514b(Integer.parseInt(str));
        char c = 1;
        char c2 = b[1].length() > 0 ? (char) 1 : 0;
        if (b[3].length() <= 0) {
            c = 0;
        }
        String str2 = "";
        if (c2 > 0) {
            str2 = str2 + b[0] + f24566j;
        }
        if (c > 0) {
            str2 = str2 + b[2] + f24567k;
        }
        return m17509a(context, this.f24572e, str2, f, i, true);
    }

    /* renamed from: a */
    private TextView m17509a(Context context, TextView textView, String str, float f, int i, boolean z) {
        if (textView == null) {
            textView = new TextView(context);
        }
        textView.setTextSize(1, f);
        textView.getPaint().setFakeBoldText(z);
        textView.setText(str);
        textView.setGravity(BadgeDrawable.TOP_START);
        textView.setTextColor(i);
        textView.setSingleLine();
        textView.setHorizontallyScrolling(false);
        return textView;
    }

    /* renamed from: a */
    private String m17511a(int i) {
        if (i < 1000) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder();
        int i2 = i / 1000;
        int i3 = (i / 100) % 10;
        if (i3 > 0) {
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
        } else {
            sb.append(i2);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String[] m17514b(int i) {
        String[] strArr = new String[4];
        int i2 = i / 3600;
        if (i2 > 0) {
            strArr[0] = "" + i2;
            strArr[1] = f24566j;
        } else {
            strArr[0] = "";
            strArr[1] = "";
        }
        int i3 = i - (i2 * 3600);
        if (i3 < 60) {
            strArr[2] = "1";
            strArr[3] = f24567k;
            return strArr;
        } else if (i3 <= 60 || i3 > 120) {
            int i4 = i3 / 30;
            if (i4 % 2 == 0) {
                strArr[2] = "" + (i4 / 2);
                strArr[3] = f24567k;
            } else {
                strArr[2] = "" + ((i4 / 2) + 1);
                strArr[3] = f24567k;
            }
            return strArr;
        } else {
            strArr[2] = "2";
            strArr[3] = f24567k;
            return strArr;
        }
    }
}
