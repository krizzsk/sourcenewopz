package com.cardinalcommerce.p060a;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.cardinalcommerce.shared.models.enums.ButtonType;
import com.cardinalcommerce.shared.userinterfaces.LabelCustomization;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.taxis99.R;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* renamed from: com.cardinalcommerce.a.setPaintFlags */
public final class setPaintFlags {

    /* renamed from: a */
    private static final setTextMetricsParams f2911a = setTextMetricsParams.getSDKVersion();

    /* renamed from: b */
    private static int f2912b = 0;

    /* renamed from: c */
    private static int f2913c = 1;

    static {
        int i = f2912b;
        int i2 = (i ^ 111) + ((i & 111) << 1);
        f2913c = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00df, code lost:
        if ((r9 != null ? 10 : org.apache.commons.p071io.IOUtils.DIR_SEPARATOR_WINDOWS) != 10) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f2, code lost:
        if ((r9 == null) != true) goto L_0x00f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cca_continue(com.cardinalcommerce.p060a.setHyphenationFrequency r7, com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r8, android.app.Activity r9) {
        /*
            int r0 = f2913c
            r1 = r0 | 104(0x68, float:1.46E-43)
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ 104(0x68, float:1.46E-43)
            int r1 = r1 - r0
            r0 = 0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r3 = r1 % 128
            f2912b = r3
            int r1 = r1 % 2
            java.lang.String r1 = r8.getTextColor()
            if (r1 == 0) goto L_0x001a
            r1 = 0
            goto L_0x001b
        L_0x001a:
            r1 = 1
        L_0x001b:
            r3 = 0
            if (r1 == 0) goto L_0x001f
            goto L_0x005f
        L_0x001f:
            int r1 = f2912b
            r4 = r1 ^ 41
            r1 = r1 & 41
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2913c = r1
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r1 == r2) goto L_0x0040
            java.lang.String r1 = r8.getTextColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTextColor(r1)
            goto L_0x004c
        L_0x0040:
            java.lang.String r1 = r8.getTextColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTextColor(r1)
            int r1 = r3.length     // Catch:{ all -> 0x01c8 }
        L_0x004c:
            int r1 = f2912b
            r4 = r1 & 78
            r1 = r1 | 78
            int r4 = r4 + r1
            r1 = r4 ^ -1
            r4 = r4 & -1
            int r4 = r4 << r2
            int r1 = r1 + r4
            int r4 = r1 % 128
            f2913c = r4
            int r1 = r1 % 2
        L_0x005f:
            int r1 = r8.getTextFontSize()
            if (r1 <= 0) goto L_0x0067
            r1 = 0
            goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            if (r1 == 0) goto L_0x006b
            goto L_0x00a5
        L_0x006b:
            int r1 = f2913c
            r4 = r1 & 119(0x77, float:1.67E-43)
            int r5 = ~r4
            r1 = r1 | 119(0x77, float:1.67E-43)
            r1 = r1 & r5
            int r4 = r4 << r2
            int r4 = -r4
            int r4 = -r4
            int r4 = ~r4
            int r1 = r1 - r4
            int r1 = r1 - r2
            int r4 = r1 % 128
            f2912b = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0083
            r1 = 1
            goto L_0x0084
        L_0x0083:
            r1 = 0
        L_0x0084:
            if (r1 == r2) goto L_0x008f
            int r1 = r8.getTextFontSize()
            float r1 = (float) r1
            r7.setTextSize(r1)
            goto L_0x0098
        L_0x008f:
            int r1 = r8.getTextFontSize()
            float r1 = (float) r1
            r7.setTextSize(r1)
            int r1 = r3.length     // Catch:{ all -> 0x01c6 }
        L_0x0098:
            int r1 = f2913c
            r4 = r1 & 15
            r1 = r1 | 15
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2912b = r1
            int r4 = r4 % 2
        L_0x00a5:
            java.lang.String r1 = r8.getTextFontName()
            if (r1 == 0) goto L_0x00ad
            r1 = 0
            goto L_0x00ae
        L_0x00ad:
            r1 = 1
        L_0x00ae:
            r4 = 10
            if (r1 == 0) goto L_0x00b3
            goto L_0x0116
        L_0x00b3:
            int r1 = f2913c
            r5 = r1 ^ 79
            r6 = r1 & 79
            r5 = r5 | r6
            int r5 = r5 << r2
            int r6 = ~r6
            r1 = r1 | 79
            r1 = r1 & r6
            int r1 = -r1
            int r1 = ~r1
            int r5 = r5 - r1
            int r5 = r5 - r2
            int r1 = r5 % 128
            f2912b = r1
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x00cd
            r1 = 1
            goto L_0x00ce
        L_0x00cd:
            r1 = 0
        L_0x00ce:
            if (r1 == r2) goto L_0x00e2
            java.lang.String r1 = r8.getTextFontName()
            android.graphics.Typeface r9 = m2049a(r1, r9)
            if (r9 == 0) goto L_0x00dd
            r1 = 10
            goto L_0x00df
        L_0x00dd:
            r1 = 92
        L_0x00df:
            if (r1 == r4) goto L_0x00f4
            goto L_0x0116
        L_0x00e2:
            java.lang.String r1 = r8.getTextFontName()
            android.graphics.Typeface r9 = m2049a(r1, r9)
            super.hashCode()     // Catch:{ all -> 0x01c4 }
            if (r9 == 0) goto L_0x00f1
            r1 = 0
            goto L_0x00f2
        L_0x00f1:
            r1 = 1
        L_0x00f2:
            if (r1 == r2) goto L_0x0116
        L_0x00f4:
            int r1 = f2913c
            r5 = r1 & 111(0x6f, float:1.56E-43)
            r1 = r1 | 111(0x6f, float:1.56E-43)
            int r5 = r5 + r1
            int r1 = r5 % 128
            f2912b = r1
            int r5 = r5 % 2
            r1 = 34
            if (r5 == 0) goto L_0x0108
            r5 = 33
            goto L_0x010a
        L_0x0108:
            r5 = 34
        L_0x010a:
            if (r5 == r1) goto L_0x0113
            r7.setTypeface(r9)
            int r9 = r3.length     // Catch:{ all -> 0x0111 }
            goto L_0x0116
        L_0x0111:
            r7 = move-exception
            throw r7
        L_0x0113:
            r7.setTypeface(r9)
        L_0x0116:
            android.graphics.drawable.GradientDrawable r9 = new android.graphics.drawable.GradientDrawable
            r9.<init>()
            java.lang.String r1 = r8.getBackgroundColor()
            if (r1 == 0) goto L_0x0124
            r1 = 48
            goto L_0x0126
        L_0x0124:
            r1 = 10
        L_0x0126:
            if (r1 == r4) goto L_0x015a
            int r1 = f2912b
            r4 = r1 & 7
            r1 = r1 ^ 7
            r1 = r1 | r4
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2913c = r1
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x013a
            r1 = 1
            goto L_0x013b
        L_0x013a:
            r1 = 0
        L_0x013b:
            if (r1 == r2) goto L_0x0149
            java.lang.String r1 = r8.getBackgroundColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r9.setColor(r1)
            goto L_0x015a
        L_0x0149:
            java.lang.String r1 = r8.getBackgroundColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r9.setColor(r1)
            r1 = 67
            int r1 = r1 / r0
            goto L_0x015a
        L_0x0158:
            r7 = move-exception
            throw r7
        L_0x015a:
            int r1 = r8.getCornerRadius()
            if (r1 <= 0) goto L_0x0162
            r1 = 1
            goto L_0x0163
        L_0x0162:
            r1 = 0
        L_0x0163:
            if (r1 == 0) goto L_0x01ac
            int r1 = f2913c
            r4 = r1 ^ 85
            r5 = r1 & 85
            r4 = r4 | r5
            int r4 = r4 << r2
            r5 = r1 & -86
            int r1 = ~r1
            r1 = r1 & 85
            r1 = r1 | r5
            int r4 = r4 - r1
            int r1 = r4 % 128
            f2912b = r1
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x017e
            r1 = 1
            goto L_0x017f
        L_0x017e:
            r1 = 0
        L_0x017f:
            if (r1 == r2) goto L_0x018a
            int r8 = r8.getCornerRadius()
            float r8 = (float) r8
            r9.setCornerRadius(r8)
            goto L_0x0195
        L_0x018a:
            int r8 = r8.getCornerRadius()
            float r8 = (float) r8
            r9.setCornerRadius(r8)
            super.hashCode()     // Catch:{ all -> 0x01aa }
        L_0x0195:
            int r8 = f2913c
            r1 = r8 & 87
            r8 = r8 ^ 87
            r8 = r8 | r1
            int r8 = -r8
            int r8 = -r8
            r4 = r1 ^ r8
            r8 = r8 & r1
            int r8 = r8 << r2
            int r4 = r4 + r8
            int r8 = r4 % 128
            f2912b = r8
            int r4 = r4 % 2
            goto L_0x01ac
        L_0x01aa:
            r7 = move-exception
            throw r7
        L_0x01ac:
            r7.setBackground(r9)
            int r7 = f2913c
            int r7 = r7 + 87
            int r8 = r7 % 128
            f2912b = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x01bc
            goto L_0x01bd
        L_0x01bc:
            r2 = 0
        L_0x01bd:
            if (r2 == 0) goto L_0x01c3
            int r7 = r3.length     // Catch:{ all -> 0x01c1 }
            return
        L_0x01c1:
            r7 = move-exception
            throw r7
        L_0x01c3:
            return
        L_0x01c4:
            r7 = move-exception
            throw r7
        L_0x01c6:
            r7 = move-exception
            throw r7
        L_0x01c8:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setPaintFlags.cca_continue(com.cardinalcommerce.a.setHyphenationFrequency, com.cardinalcommerce.shared.userinterfaces.ButtonCustomization, android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if ((r11.getLabelCustomization() != null ? '+' : 'J') != '+') goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if ((r0 != null ? org.apache.commons.lang3.CharUtils.f5620CR : '2') != 13) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r5 != 21) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        if ((r0 > 0) != true) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getInstance(com.cardinalcommerce.p060a.setShowSoftInputOnFocus r10, com.cardinalcommerce.shared.userinterfaces.UiCustomization r11, android.app.Activity r12) {
        /*
            int r0 = f2913c
            int r0 = r0 + 105
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            int r0 = r0 - r2
            int r0 = r0 - r1
            int r3 = r0 % 128
            f2912b = r3
            int r0 = r0 % 2
            r3 = 84
            if (r0 == 0) goto L_0x0016
            r0 = 84
            goto L_0x0018
        L_0x0016:
            r0 = 75
        L_0x0018:
            r4 = 0
            if (r0 == r3) goto L_0x002c
            com.cardinalcommerce.shared.userinterfaces.LabelCustomization r0 = r11.getLabelCustomization()
            r3 = 43
            if (r0 == 0) goto L_0x0026
            r0 = 43
            goto L_0x0028
        L_0x0026:
            r0 = 74
        L_0x0028:
            if (r0 == r3) goto L_0x003e
            goto L_0x013d
        L_0x002c:
            com.cardinalcommerce.shared.userinterfaces.LabelCustomization r0 = r11.getLabelCustomization()
            int r3 = r4.length     // Catch:{ all -> 0x01a4 }
            r3 = 13
            if (r0 == 0) goto L_0x0038
            r0 = 13
            goto L_0x003a
        L_0x0038:
            r0 = 50
        L_0x003a:
            if (r0 == r3) goto L_0x003e
            goto L_0x013d
        L_0x003e:
            int r0 = f2912b
            int r0 = r0 + 13
            int r0 = r0 - r1
            r3 = r0 | -1
            int r3 = r3 << r1
            r0 = r0 ^ -1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f2913c = r0
            int r3 = r3 % 2
            r0 = 92
            r5 = 31
            if (r3 != 0) goto L_0x0058
            r3 = 92
            goto L_0x005a
        L_0x0058:
            r3 = 31
        L_0x005a:
            if (r3 == r0) goto L_0x006e
            com.cardinalcommerce.shared.userinterfaces.LabelCustomization r11 = r11.getLabelCustomization()
            int r0 = r11.getTextFontSize()
            r3 = 21
            if (r0 <= 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r5 = 21
        L_0x006b:
            if (r5 == r3) goto L_0x009b
            goto L_0x0081
        L_0x006e:
            com.cardinalcommerce.shared.userinterfaces.LabelCustomization r11 = r11.getLabelCustomization()
            int r0 = r11.getTextFontSize()
            super.hashCode()     // Catch:{ all -> 0x01a2 }
            if (r0 <= 0) goto L_0x007d
            r0 = 1
            goto L_0x007e
        L_0x007d:
            r0 = 0
        L_0x007e:
            if (r0 == r1) goto L_0x0081
            goto L_0x009b
        L_0x0081:
            int r0 = r11.getTextFontSize()
            float r0 = (float) r0
            r10.setTextSize(r0)
            int r0 = f2913c
            r3 = r0 & 126(0x7e, float:1.77E-43)
            r0 = r0 | 126(0x7e, float:1.77E-43)
            int r3 = r3 + r0
            r0 = r3 & -1
            r3 = r3 | -1
            int r0 = r0 + r3
            int r3 = r0 % 128
            f2912b = r3
            int r0 = r0 % 2
        L_0x009b:
            java.lang.String r0 = r11.getTextColor()
            if (r0 == 0) goto L_0x00a3
            r0 = 1
            goto L_0x00a4
        L_0x00a3:
            r0 = 0
        L_0x00a4:
            if (r0 == r1) goto L_0x00a7
            goto L_0x00e3
        L_0x00a7:
            int r0 = f2912b
            r3 = r0 & 125(0x7d, float:1.75E-43)
            r0 = r0 ^ 125(0x7d, float:1.75E-43)
            r0 = r0 | r3
            int r0 = -r0
            int r0 = -r0
            r5 = r3 ^ r0
            r0 = r0 & r3
            int r0 = r0 << r1
            int r5 = r5 + r0
            int r0 = r5 % 128
            f2913c = r0
            int r5 = r5 % 2
            java.lang.String r0 = r11.getTextColor()
            int r0 = android.graphics.Color.parseColor(r0)
            r10.setTextColor(r0)
            android.graphics.drawable.Drawable[] r0 = r10.getCompoundDrawablesRelative()
            int r3 = r0.length
            int r5 = f2913c
            r6 = r5 ^ 54
            r5 = r5 & 54
            int r5 = r5 << r1
            int r6 = r6 + r5
            int r6 = r6 - r2
            int r6 = r6 - r1
            int r5 = r6 % 128
            f2912b = r5
            int r6 = r6 % 2
            r5 = 0
        L_0x00dc:
            if (r5 >= r3) goto L_0x00e0
            r6 = 1
            goto L_0x00e1
        L_0x00e0:
            r6 = 0
        L_0x00e1:
            if (r6 == r1) goto L_0x015a
        L_0x00e3:
            java.lang.String r0 = r11.getTextFontName()
            if (r0 == 0) goto L_0x00eb
            r0 = 1
            goto L_0x00ec
        L_0x00eb:
            r0 = 0
        L_0x00ec:
            if (r0 == r1) goto L_0x00ef
            goto L_0x013d
        L_0x00ef:
            int r0 = f2912b
            r3 = r0 | 86
            int r3 = r3 << r1
            r0 = r0 ^ 86
            int r3 = r3 - r0
            r0 = r3 | -1
            int r0 = r0 << r1
            r3 = r3 ^ -1
            int r0 = r0 - r3
            int r3 = r0 % 128
            f2913c = r3
            int r0 = r0 % 2
            java.lang.String r11 = r11.getTextFontName()
            android.graphics.Typeface r11 = m2049a(r11, r12)
            if (r11 == 0) goto L_0x010f
            r12 = 1
            goto L_0x0110
        L_0x010f:
            r12 = 0
        L_0x0110:
            if (r12 == r1) goto L_0x0113
            goto L_0x013d
        L_0x0113:
            int r12 = f2912b
            r0 = r12 ^ 118(0x76, float:1.65E-43)
            r12 = r12 & 118(0x76, float:1.65E-43)
            int r12 = r12 << r1
            int r0 = r0 + r12
            r12 = r0 & -1
            r0 = r0 | -1
            int r12 = r12 + r0
            int r0 = r12 % 128
            f2913c = r0
            int r12 = r12 % 2
            r10.setTypeface(r11)
            int r10 = f2912b
            r11 = r10 & 55
            int r12 = ~r11
            r10 = r10 | 55
            r10 = r10 & r12
            int r11 = r11 << r1
            r12 = r10 | r11
            int r12 = r12 << r1
            r10 = r10 ^ r11
            int r12 = r12 - r10
            int r10 = r12 % 128
            f2913c = r10
            int r12 = r12 % 2
        L_0x013d:
            int r10 = f2913c
            r11 = r10 & 91
            r10 = r10 ^ 91
            r10 = r10 | r11
            int r10 = -r10
            int r10 = -r10
            int r10 = ~r10
            int r11 = r11 - r10
            int r11 = r11 - r1
            int r10 = r11 % 128
            f2912b = r10
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x0152
            goto L_0x0153
        L_0x0152:
            r1 = 0
        L_0x0153:
            if (r1 == 0) goto L_0x0159
            int r10 = r4.length     // Catch:{ all -> 0x0157 }
            return
        L_0x0157:
            r10 = move-exception
            throw r10
        L_0x0159:
            return
        L_0x015a:
            int r6 = f2913c
            int r6 = r6 + 37
            int r7 = r6 % 128
            f2912b = r7
            int r6 = r6 % 2
            r6 = r0[r5]
            if (r6 == 0) goto L_0x018b
            android.graphics.PorterDuffColorFilter r7 = new android.graphics.PorterDuffColorFilter
            java.lang.String r8 = r11.getTextColor()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r9 = android.graphics.PorterDuff.Mode.SRC_IN
            r7.<init>(r8, r9)
            r6.setColorFilter(r7)
            int r6 = f2912b
            int r6 = r6 + 127
            int r6 = r6 - r1
            r7 = r6 ^ -1
            r6 = r6 & -1
            int r6 = r6 << r1
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2913c = r6
            int r7 = r7 % 2
        L_0x018b:
            r6 = r5 | 1
            int r6 = r6 << r1
            r5 = r5 ^ 1
            int r5 = r6 - r5
            int r6 = f2912b
            r7 = r6 & 37
            r6 = r6 ^ 37
            r6 = r6 | r7
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2913c = r6
            int r7 = r7 % 2
            goto L_0x00dc
        L_0x01a2:
            r10 = move-exception
            throw r10
        L_0x01a4:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setPaintFlags.getInstance(com.cardinalcommerce.a.setShowSoftInputOnFocus, com.cardinalcommerce.shared.userinterfaces.UiCustomization, android.app.Activity):void");
    }

    public static void init(setShowSoftInputOnFocus setshowsoftinputonfocus, UiCustomization uiCustomization, Activity activity) {
        int i = f2912b + 87;
        f2913c = i % 128;
        int i2 = i % 2;
        if ((uiCustomization.getLabelCustomization() != null ? 5 : '+') != '+') {
            int i3 = f2912b;
            int i4 = ((i3 ^ 105) | (i3 & 105)) << 1;
            int i5 = -(((~i3) & 105) | (i3 & -106));
            int i6 = ((i4 | i5) << 1) - (i5 ^ i4);
            f2913c = i6 % 128;
            int i7 = i6 % 2;
            LabelCustomization labelCustomization = uiCustomization.getLabelCustomization();
            if ((labelCustomization.getHeadingTextFontSize() > 0 ? 'X' : Matrix.MATRIX_TYPE_ZERO) == 'X') {
                int i8 = (f2913c + 110) - 1;
                f2912b = i8 % 128;
                int i9 = i8 % 2;
                setshowsoftinputonfocus.setTextSize((float) labelCustomization.getHeadingTextFontSize());
                int i10 = f2912b;
                int i11 = i10 & 83;
                int i12 = (i11 - (~(-(-((i10 ^ 83) | i11))))) - 1;
                f2913c = i12 % 128;
                int i13 = i12 % 2;
            }
            if ((labelCustomization.getHeadingTextColor() != null ? 30 : '$') != '$') {
                int i14 = f2912b;
                int i15 = i14 & 11;
                int i16 = (i15 - (~(-(-((i14 ^ 11) | i15))))) - 1;
                f2913c = i16 % 128;
                int i17 = i16 % 2;
                setshowsoftinputonfocus.setTextColor(Color.parseColor(labelCustomization.getHeadingTextColor()));
                int i18 = f2913c;
                int i19 = i18 & 57;
                int i20 = ((i18 | 57) & (~i19)) + (i19 << 1);
                f2912b = i20 % 128;
                int i21 = i20 % 2;
            }
            if ((labelCustomization.getHeadingTextFontName() != null ? '!' : 'G') != 'G') {
                int i22 = f2912b + 59;
                f2913c = i22 % 128;
                int i23 = i22 % 2;
                Typeface a = m2049a(labelCustomization.getHeadingTextFontName(), activity);
                if (!(a == null)) {
                    int i24 = f2912b;
                    int i25 = ((i24 & 31) - (~(-(-(i24 | 31))))) - 1;
                    f2913c = i25 % 128;
                    char c = i25 % 2 == 0 ? '?' : '4';
                    setshowsoftinputonfocus.setTypeface(a);
                    if (c == '?') {
                        Object obj = null;
                        super.hashCode();
                    }
                }
            }
        }
        int i26 = f2912b;
        int i27 = i26 | 49;
        int i28 = i27 << 1;
        int i29 = -((~(i26 & 49)) & i27);
        int i30 = (i28 ^ i29) + ((i29 & i28) << 1);
        f2913c = i30 % 128;
        int i31 = i30 % 2;
    }

    public static void init(setBreakStrategy setbreakstrategy, UiCustomization uiCustomization, Activity activity) {
        int i;
        int i2;
        Typeface a;
        if (uiCustomization.getLabelCustomization() != null) {
            LabelCustomization labelCustomization = uiCustomization.getLabelCustomization();
            if (labelCustomization.getTextFontSize() > 0) {
                setbreakstrategy.setTextSize((float) labelCustomization.getTextFontSize());
            }
            if (labelCustomization.getTextColor() != null) {
                setbreakstrategy.setTextColor(Color.parseColor(labelCustomization.getTextColor()));
            }
            if (!(labelCustomization.getTextFontName() == null || (a = m2049a(labelCustomization.getTextFontName(), activity)) == null)) {
                setbreakstrategy.setTypeface(a);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int[][] iArr = {new int[]{-16842912}, new int[]{16842912}};
            int[] iArr2 = new int[2];
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                i = Color.parseColor(uiCustomization.getButtonCustomization(ButtonType.VERIFY).getBackgroundColor());
            } else {
                i = activity.getResources().getColor(R.color.blue);
            }
            iArr2[0] = i;
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                i2 = Color.parseColor(uiCustomization.getButtonCustomization(ButtonType.VERIFY).getBackgroundColor());
            } else {
                i2 = activity.getResources().getColor(R.color.blue);
            }
            iArr2[1] = i2;
            setbreakstrategy.setButtonTintList(new ColorStateList(iArr, iArr2));
        }
    }

    public static void configure(setElegantTextHeight seteleganttextheight, UiCustomization uiCustomization, Activity activity) {
        int i;
        Drawable drawable;
        Typeface a;
        if (uiCustomization.getLabelCustomization() != null) {
            LabelCustomization labelCustomization = uiCustomization.getLabelCustomization();
            if (labelCustomization.getTextFontSize() > 0) {
                seteleganttextheight.setTextSize((float) labelCustomization.getTextFontSize());
            }
            if (labelCustomization.getTextColor() != null) {
                seteleganttextheight.setTextColor(Color.parseColor(labelCustomization.getTextColor()));
            }
            if (!(labelCustomization.getTextFontName() == null || (a = m2049a(labelCustomization.getTextFontName(), activity)) == null)) {
                seteleganttextheight.setTypeface(a);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int[][] iArr = {new int[]{-16842912}, new int[]{16842912}};
            int[] iArr2 = new int[2];
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                i = Color.parseColor(uiCustomization.getButtonCustomization(ButtonType.VERIFY).getBackgroundColor());
            } else {
                i = activity.getResources().getColor(R.color.blue);
            }
            iArr2[0] = i;
            iArr2[1] = -12303292;
            ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
            seteleganttextheight.setButtonTintList(colorStateList);
            if (Build.VERSION.SDK_INT >= 23) {
                drawable = seteleganttextheight.getButtonDrawable();
            } else {
                drawable = CompoundButtonCompat.getButtonDrawable(seteleganttextheight);
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                DrawableCompat.setTint(wrap, Color.parseColor(uiCustomization.getButtonCustomization(ButtonType.VERIFY).getBackgroundColor()));
                seteleganttextheight.setButtonTintList(colorStateList);
                return;
            }
            DrawableCompat.setTint(wrap, activity.getResources().getColor(R.color.blue));
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.Typeface, java.lang.Object, java.lang.String] */
    /* renamed from: a */
    private static Typeface m2049a(String str, Activity activity) {
        Typeface typeface;
        int i = (f2912b + 125) - 1;
        int i2 = (i & -1) + (i | -1);
        f2913c = i2 % 128;
        ? r3 = 0;
        if ((i2 % 2 == 0 ? (char) 1 : 2) != 2) {
            try {
                typeface = Typeface.createFromAsset(activity.getAssets(), str);
                super.hashCode();
            } catch (Exception e) {
                setTextMetricsParams settextmetricsparams = f2911a;
                StringBuilder sb = new StringBuilder("font not found: ");
                sb.append(str);
                sb.append(e.getMessage());
                settextmetricsparams.configure("13201", sb.toString(), r3);
                return r3;
            }
        } else {
            typeface = Typeface.createFromAsset(activity.getAssets(), str);
        }
        int i3 = f2913c;
        int i4 = i3 & 75;
        int i5 = (i4 - (~(-(-((i3 ^ 75) | i4))))) - 1;
        f2912b = i5 % 128;
        if ((i5 % 2 != 0 ? 10 : '9') == '9') {
            return typeface;
        }
        int i6 = 9 / 0;
        return typeface;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if ((r14 != null ? 'c' : 0) != 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        if ((r14 == null) != true) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cca_continue(com.cardinalcommerce.p060a.setLetterSpacing r13, com.cardinalcommerce.shared.userinterfaces.UiCustomization r14, android.app.Activity r15) {
        /*
            int r0 = f2913c
            r1 = r0 | 7
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ 7
            int r0 = -r0
            r3 = r1 | r0
            int r3 = r3 << r2
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f2912b = r0
            r0 = 2
            int r3 = r3 % r0
            r1 = 0
            if (r3 == 0) goto L_0x0019
            r3 = 1
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            r4 = 99
            r5 = 0
            if (r3 == 0) goto L_0x002b
            int r3 = r5.length     // Catch:{ all -> 0x0029 }
            if (r14 == 0) goto L_0x0025
            r3 = 99
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 == 0) goto L_0x020e
            goto L_0x0032
        L_0x0029:
            r13 = move-exception
            throw r13
        L_0x002b:
            if (r14 == 0) goto L_0x002f
            r3 = 0
            goto L_0x0030
        L_0x002f:
            r3 = 1
        L_0x0030:
            if (r3 == r2) goto L_0x020e
        L_0x0032:
            int r3 = f2913c
            r6 = r3 & 41
            int r7 = ~r6
            r3 = r3 | 41
            r3 = r3 & r7
            int r6 = r6 << r2
            r7 = r3 | r6
            int r7 = r7 << r2
            r3 = r3 ^ r6
            int r7 = r7 - r3
            int r3 = r7 % 128
            f2912b = r3
            int r7 = r7 % r0
            com.cardinalcommerce.shared.userinterfaces.TextBoxCustomization r3 = r14.getTextBoxCustomization()
            if (r3 == 0) goto L_0x020e
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            android.content.res.Resources r6 = r15.getResources()
            r7 = 2131100441(0x7f060319, float:1.7813264E38)
            int r6 = r6.getColor(r7)
            com.cardinalcommerce.shared.userinterfaces.TextBoxCustomization r14 = r14.getTextBoxCustomization()
            r7 = 12
            if (r14 == 0) goto L_0x0066
            r8 = 12
            goto L_0x0068
        L_0x0066:
            r8 = 24
        L_0x0068:
            r9 = 52
            if (r8 == r7) goto L_0x006e
            goto L_0x01ed
        L_0x006e:
            int r7 = f2913c
            r8 = r7 & 7
            r7 = r7 | 7
            int r7 = -r7
            int r7 = -r7
            r10 = r8 ^ r7
            r7 = r7 & r8
            int r7 = r7 << r2
            int r10 = r10 + r7
            int r7 = r10 % 128
            f2912b = r7
            int r10 = r10 % r0
            int r7 = r14.getBorderWidth()
            if (r7 <= 0) goto L_0x0088
            r7 = 0
            goto L_0x0089
        L_0x0088:
            r7 = 1
        L_0x0089:
            if (r7 == r2) goto L_0x00ab
            int r7 = f2913c
            int r7 = r7 + 54
            r8 = r7 | -1
            int r8 = r8 << r2
            r7 = r7 ^ -1
            int r8 = r8 - r7
            int r7 = r8 % 128
            f2912b = r7
            int r8 = r8 % r0
            int r7 = r14.getBorderWidth()
            int r8 = f2913c
            r10 = r8 & 111(0x6f, float:1.56E-43)
            r8 = r8 | 111(0x6f, float:1.56E-43)
            int r10 = r10 + r8
            int r8 = r10 % 128
            f2912b = r8
            int r10 = r10 % r0
            goto L_0x00ac
        L_0x00ab:
            r7 = 1
        L_0x00ac:
            java.lang.String r8 = r14.getBorderColor()
            if (r8 == 0) goto L_0x00b4
            r8 = 1
            goto L_0x00b5
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            r10 = 26
            if (r8 == 0) goto L_0x00ff
            int r8 = f2913c
            r11 = r8 & -100
            int r12 = ~r8
            r12 = r12 & r4
            r11 = r11 | r12
            r4 = r4 & r8
            int r4 = r4 << r2
            int r11 = r11 + r4
            int r4 = r11 % 128
            f2912b = r4
            int r11 = r11 % r0
            java.lang.String r4 = r14.getBorderColor()
            boolean r4 = r4.isEmpty()
            r8 = 22
            if (r4 != 0) goto L_0x00d7
            r4 = 26
            goto L_0x00d9
        L_0x00d7:
            r4 = 22
        L_0x00d9:
            if (r4 == r8) goto L_0x00ff
            int r4 = f2912b
            r6 = r4 & 107(0x6b, float:1.5E-43)
            int r8 = ~r6
            r4 = r4 | 107(0x6b, float:1.5E-43)
            r4 = r4 & r8
            int r6 = r6 << r2
            int r4 = r4 + r6
            int r6 = r4 % 128
            f2913c = r6
            int r4 = r4 % r0
            java.lang.String r4 = r14.getBorderColor()
            int r6 = android.graphics.Color.parseColor(r4)
            int r4 = f2913c
            r8 = r4 ^ 63
            r4 = r4 & 63
            int r4 = r4 << r2
            int r8 = r8 + r4
            int r4 = r8 % 128
            f2912b = r4
            int r8 = r8 % r0
        L_0x00ff:
            int r4 = r14.getCornerRadius()
            if (r4 <= 0) goto L_0x0107
            r4 = 0
            goto L_0x0108
        L_0x0107:
            r4 = 1
        L_0x0108:
            if (r4 == 0) goto L_0x010c
            r4 = 2
            goto L_0x0128
        L_0x010c:
            int r4 = f2912b
            r8 = r4 & 85
            r4 = r4 | 85
            int r8 = r8 + r4
            int r4 = r8 % 128
            f2913c = r4
            int r8 = r8 % r0
            int r4 = r14.getCornerRadius()
            int r8 = f2912b
            r11 = r8 & 119(0x77, float:1.67E-43)
            r8 = r8 | 119(0x77, float:1.67E-43)
            int r11 = r11 + r8
            int r8 = r11 % 128
            f2913c = r8
            int r11 = r11 % r0
        L_0x0128:
            r3.setStroke(r7, r6)
            float r4 = (float) r4
            r3.setCornerRadius(r4)
            r13.setBackground(r3)
            java.lang.String r3 = r14.getTextColor()
            if (r3 == 0) goto L_0x013b
            r3 = 52
            goto L_0x013d
        L_0x013b:
            r3 = 77
        L_0x013d:
            if (r3 == r9) goto L_0x0140
            goto L_0x0162
        L_0x0140:
            int r3 = f2913c
            int r3 = r3 + 98
            int r3 = r3 - r2
            int r4 = r3 % 128
            f2912b = r4
            int r3 = r3 % r0
            java.lang.String r3 = r14.getTextColor()
            int r3 = android.graphics.Color.parseColor(r3)
            r13.setTextColor(r3)
            int r3 = f2912b
            r4 = r3 ^ 17
            r3 = r3 & 17
            int r3 = r3 << r2
            int r4 = r4 + r3
            int r3 = r4 % 128
            f2913c = r3
            int r4 = r4 % r0
        L_0x0162:
            int r3 = r14.getTextFontSize()
            if (r3 <= 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            r10 = 52
        L_0x016b:
            if (r10 == r9) goto L_0x0195
            int r3 = f2912b
            r4 = r3 | 1
            int r6 = r4 << 1
            r3 = r3 & r2
            int r3 = ~r3
            r3 = r3 & r4
            int r6 = r6 - r3
            int r3 = r6 % 128
            f2913c = r3
            int r6 = r6 % r0
            int r3 = r14.getTextFontSize()
            float r3 = (float) r3
            r13.setTextSize(r3)
            int r3 = f2912b
            r4 = r3 ^ 83
            r3 = r3 & 83
            r3 = r3 | r4
            int r3 = r3 << r2
            int r4 = -r4
            int r4 = ~r4
            int r3 = r3 - r4
            int r3 = r3 - r2
            int r4 = r3 % 128
            f2913c = r4
            int r3 = r3 % r0
        L_0x0195:
            java.lang.String r3 = r14.getTextFontName()
            if (r3 == 0) goto L_0x019d
            r3 = 0
            goto L_0x019e
        L_0x019d:
            r3 = 1
        L_0x019e:
            if (r3 == r2) goto L_0x01ed
            int r3 = f2913c
            int r3 = r3 + 95
            int r3 = r3 - r2
            int r3 = r3 - r1
            int r3 = r3 - r2
            int r4 = r3 % 128
            f2912b = r4
            int r3 = r3 % r0
            java.lang.String r14 = r14.getTextFontName()
            android.graphics.Typeface r14 = m2049a(r14, r15)
            r15 = 49
            if (r14 == 0) goto L_0x01bb
            r3 = 49
            goto L_0x01bd
        L_0x01bb:
            r3 = 67
        L_0x01bd:
            if (r3 == r15) goto L_0x01c0
            goto L_0x01ed
        L_0x01c0:
            int r15 = f2912b
            int r15 = r15 + 30
            r3 = r15 | -1
            int r3 = r3 << r2
            r15 = r15 ^ -1
            int r3 = r3 - r15
            int r15 = r3 % 128
            f2913c = r15
            int r3 = r3 % r0
            if (r3 != 0) goto L_0x01d3
            r15 = 0
            goto L_0x01d4
        L_0x01d3:
            r15 = 1
        L_0x01d4:
            r13.setTypeface(r14)
            if (r15 == r2) goto L_0x01dd
            int r13 = r5.length     // Catch:{ all -> 0x01db }
            goto L_0x01dd
        L_0x01db:
            r13 = move-exception
            throw r13
        L_0x01dd:
            int r13 = f2912b
            r14 = r13 & 45
            r13 = r13 | 45
            r15 = r14 ^ r13
            r13 = r13 & r14
            int r13 = r13 << r2
            int r15 = r15 + r13
            int r13 = r15 % 128
            f2913c = r13
            int r15 = r15 % r0
        L_0x01ed:
            int r13 = f2913c
            r14 = r13 & -44
            int r15 = ~r13
            r15 = r15 & 43
            r14 = r14 | r15
            r13 = r13 & 43
            int r13 = r13 << r2
            int r14 = r14 + r13
            int r13 = r14 % 128
            f2912b = r13
            int r14 = r14 % r0
            r13 = 38
            if (r14 == 0) goto L_0x0205
            r14 = 38
            goto L_0x0207
        L_0x0205:
            r14 = 36
        L_0x0207:
            if (r14 == r13) goto L_0x020a
            return
        L_0x020a:
            int r9 = r9 / r1
            return
        L_0x020c:
            r13 = move-exception
            throw r13
        L_0x020e:
            r14 = 2131232598(0x7f080756, float:1.808131E38)
            r13.setBackgroundResource(r14)
            android.content.res.Resources r14 = r15.getResources()
            r15 = 2131100442(0x7f06031a, float:1.7813266E38)
            int r14 = r14.getColor(r15)
            r13.setTextColor(r14)
            int r13 = f2913c
            r14 = r13 | 115(0x73, float:1.61E-43)
            int r14 = r14 << r2
            r13 = r13 ^ 115(0x73, float:1.61E-43)
            int r14 = r14 - r13
            int r13 = r14 % 128
            f2912b = r13
            int r14 = r14 % r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setPaintFlags.cca_continue(com.cardinalcommerce.a.setLetterSpacing, com.cardinalcommerce.shared.userinterfaces.UiCustomization, android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fb, code lost:
        if ((r9 != null ? '#' : org.apache.commons.p071io.IOUtils.DIR_SEPARATOR_UNIX) != '#') goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0111, code lost:
        if ((r9 != null ? 16 : '`') != '`') goto L_0x0113;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void configure(com.cardinalcommerce.p060a.setShowSoftInputOnFocus r7, com.cardinalcommerce.shared.userinterfaces.UiCustomization r8, android.app.Activity r9) {
        /*
            int r0 = f2912b
            r1 = r0 | 19
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -20
            int r0 = ~r0
            r0 = r0 & 19
            r0 = r0 | r3
            int r1 = r1 - r0
            int r0 = r1 % 128
            f2913c = r0
            int r1 = r1 % 2
            r0 = 0
            if (r7 == 0) goto L_0x0018
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            r3 = 88
            if (r1 == r2) goto L_0x01d6
            int r1 = f2912b
            r4 = r1 & 13
            r1 = r1 | 13
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2913c = r1
            int r4 = r4 % 2
            com.cardinalcommerce.shared.models.enums.ButtonType r1 = com.cardinalcommerce.shared.models.enums.ButtonType.CANCEL
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r1 = r8.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r1)
            r4 = 72
            if (r1 == 0) goto L_0x0037
            r1 = 42
            goto L_0x0039
        L_0x0037:
            r1 = 72
        L_0x0039:
            if (r1 == r4) goto L_0x01d6
            int r1 = f2913c
            r4 = r1 ^ 35
            r5 = 35
            r1 = r1 & r5
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2912b = r1
            int r4 = r4 % 2
            com.cardinalcommerce.shared.models.enums.ButtonType r1 = com.cardinalcommerce.shared.models.enums.ButtonType.CANCEL
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r8 = r8.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r1)
            java.lang.String r1 = r8.getTextColor()
            r4 = 20
            if (r1 == 0) goto L_0x005b
            r1 = 20
            goto L_0x005c
        L_0x005b:
            r1 = 6
        L_0x005c:
            if (r1 == r4) goto L_0x005f
            goto L_0x008a
        L_0x005f:
            int r1 = f2913c
            r4 = r1 & 35
            r1 = r1 | r5
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2912b = r1
            int r4 = r4 % 2
            java.lang.String r1 = r8.getTextColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTextColor(r1)
            int r1 = f2912b
            r4 = r1 | 46
            int r4 = r4 << r2
            r1 = r1 ^ 46
            int r4 = r4 - r1
            r1 = r4 ^ -1
            r4 = r4 & -1
            int r4 = r4 << r2
            int r1 = r1 + r4
            int r4 = r1 % 128
            f2913c = r4
            int r1 = r1 % 2
        L_0x008a:
            int r1 = r8.getTextFontSize()
            if (r1 <= 0) goto L_0x0092
            r1 = 1
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            r4 = 0
            if (r1 == 0) goto L_0x00cb
            int r1 = f2913c
            r6 = r1 | 17
            int r6 = r6 << r2
            r1 = r1 ^ 17
            int r6 = r6 - r1
            int r1 = r6 % 128
            f2912b = r1
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x00a8
            r1 = 0
            goto L_0x00a9
        L_0x00a8:
            r1 = 1
        L_0x00a9:
            if (r1 == r2) goto L_0x00b9
            int r1 = r8.getTextFontSize()
            float r1 = (float) r1
            r7.setTextSize(r1)
            super.hashCode()     // Catch:{ all -> 0x00b7 }
            goto L_0x00c1
        L_0x00b7:
            r7 = move-exception
            throw r7
        L_0x00b9:
            int r1 = r8.getTextFontSize()
            float r1 = (float) r1
            r7.setTextSize(r1)
        L_0x00c1:
            int r1 = f2912b
            int r1 = r1 + 95
            int r6 = r1 % 128
            f2913c = r6
            int r1 = r1 % 2
        L_0x00cb:
            java.lang.String r1 = r8.getTextFontName()
            if (r1 == 0) goto L_0x00d3
            r1 = 1
            goto L_0x00d4
        L_0x00d3:
            r1 = 0
        L_0x00d4:
            if (r1 == r2) goto L_0x00d7
            goto L_0x0133
        L_0x00d7:
            int r1 = f2912b
            int r1 = r1 + 30
            int r1 = r1 - r2
            int r6 = r1 % 128
            f2913c = r6
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x00e6
            r1 = 0
            goto L_0x00e7
        L_0x00e6:
            r1 = 1
        L_0x00e7:
            if (r1 == r2) goto L_0x0100
            java.lang.String r1 = r8.getTextFontName()
            android.graphics.Typeface r9 = m2049a(r1, r9)
            r1 = 97
            int r1 = r1 / r0
            if (r9 == 0) goto L_0x00f9
            r1 = 35
            goto L_0x00fb
        L_0x00f9:
            r1 = 47
        L_0x00fb:
            if (r1 == r5) goto L_0x0113
            goto L_0x0133
        L_0x00fe:
            r7 = move-exception
            throw r7
        L_0x0100:
            java.lang.String r1 = r8.getTextFontName()
            android.graphics.Typeface r9 = m2049a(r1, r9)
            r1 = 96
            if (r9 == 0) goto L_0x010f
            r5 = 16
            goto L_0x0111
        L_0x010f:
            r5 = 96
        L_0x0111:
            if (r5 == r1) goto L_0x0133
        L_0x0113:
            int r1 = f2913c
            r5 = r1 | 111(0x6f, float:1.56E-43)
            int r5 = r5 << r2
            r1 = r1 ^ 111(0x6f, float:1.56E-43)
            int r5 = r5 - r1
            int r1 = r5 % 128
            f2912b = r1
            int r5 = r5 % 2
            r7.setTypeface(r9)
            int r9 = f2912b
            r1 = r9 | 88
            int r1 = r1 << r2
            r9 = r9 ^ r3
            int r1 = r1 - r9
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r9 = r1 % 128
            f2913c = r9
            int r1 = r1 % 2
        L_0x0133:
            java.lang.String r9 = "#00FF0000"
            int r9 = android.graphics.Color.parseColor(r9)
            r7.setBackgroundColor(r9)
            android.graphics.drawable.GradientDrawable r9 = new android.graphics.drawable.GradientDrawable
            r9.<init>()
            java.lang.String r1 = r8.getBackgroundColor()
            if (r1 == 0) goto L_0x0149
            r1 = 0
            goto L_0x014a
        L_0x0149:
            r1 = 1
        L_0x014a:
            if (r1 == r2) goto L_0x018d
            int r1 = f2912b
            int r1 = r1 + 45
            int r5 = r1 % 128
            f2913c = r5
            int r1 = r1 % 2
            r5 = 8
            if (r1 != 0) goto L_0x015d
            r1 = 8
            goto L_0x015f
        L_0x015d:
            r1 = 78
        L_0x015f:
            if (r1 == r5) goto L_0x016d
            java.lang.String r1 = r8.getBackgroundColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r9.setColor(r1)
            goto L_0x0179
        L_0x016d:
            java.lang.String r1 = r8.getBackgroundColor()
            int r1 = android.graphics.Color.parseColor(r1)
            r9.setColor(r1)
            int r1 = r4.length     // Catch:{ all -> 0x018b }
        L_0x0179:
            int r1 = f2912b
            r4 = r1 | 107(0x6b, float:1.5E-43)
            int r5 = r4 << 1
            r1 = r1 & 107(0x6b, float:1.5E-43)
            int r1 = ~r1
            r1 = r1 & r4
            int r5 = r5 - r1
            int r1 = r5 % 128
            f2913c = r1
            int r5 = r5 % 2
            goto L_0x018d
        L_0x018b:
            r7 = move-exception
            throw r7
        L_0x018d:
            int r1 = r8.getCornerRadius()
            if (r1 <= 0) goto L_0x0195
            r1 = 1
            goto L_0x0196
        L_0x0195:
            r1 = 0
        L_0x0196:
            if (r1 == 0) goto L_0x01c0
            int r1 = f2913c
            r4 = r1 & -42
            int r5 = ~r1
            r5 = r5 & 41
            r4 = r4 | r5
            r1 = r1 & 41
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2912b = r1
            int r4 = r4 % 2
            int r8 = r8.getCornerRadius()
            float r8 = (float) r8
            r9.setCornerRadius(r8)
            int r8 = f2912b
            r1 = r8 ^ 11
            r8 = r8 & 11
            int r8 = r8 << r2
            int r1 = r1 + r8
            int r8 = r1 % 128
            f2913c = r8
            int r1 = r1 % 2
        L_0x01c0:
            r7.setBackground(r9)
            int r7 = f2912b
            r8 = r7 ^ 55
            r7 = r7 & 55
            r7 = r7 | r8
            int r7 = r7 << r2
            int r8 = -r8
            r9 = r7 & r8
            r7 = r7 | r8
            int r9 = r9 + r7
            int r7 = r9 % 128
            f2913c = r7
            int r9 = r9 % 2
        L_0x01d6:
            int r7 = f2913c
            r8 = r7 & 99
            r7 = r7 | 99
            int r8 = r8 + r7
            int r7 = r8 % 128
            f2912b = r7
            int r8 = r8 % 2
            r7 = 51
            if (r8 == 0) goto L_0x01ea
            r8 = 88
            goto L_0x01ec
        L_0x01ea:
            r8 = 51
        L_0x01ec:
            if (r8 == r7) goto L_0x01f2
            int r3 = r3 / r0
            return
        L_0x01f0:
            r7 = move-exception
            throw r7
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setPaintFlags.configure(com.cardinalcommerce.a.setShowSoftInputOnFocus, com.cardinalcommerce.shared.userinterfaces.UiCustomization, android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if ((r7.getToolbarCustomization() == null ? 30 : ':') != ':') goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        if ((r7.getToolbarCustomization() != null) != true) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        r7 = r7.getToolbarCustomization();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (r7.getBackgroundColor() == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r2 == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        r2 = ((f2912b + 77) - 1) - 1;
        f2913c = r2 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        if ((r2 % 2) != 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        r2 = '-';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r2 = 'S';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        if (r2 == '-') goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        r6.setBackgroundColor(android.graphics.Color.parseColor(r7.getBackgroundColor()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r6.setBackgroundColor(android.graphics.Color.parseColor(r7.getBackgroundColor()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r2 = 77 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ba, code lost:
        if (r7.getHeaderText() == null) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r2 == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r2 = f2912b;
        r4 = r2 ^ 11;
        r2 = -(-((r2 & 11) << 1));
        r5 = (r4 ^ r2) + ((r2 & r4) << 1);
        f2913c = r5 % 128;
        r5 = r5 % 2;
        r6.setTitle((java.lang.CharSequence) r7.getHeaderText());
        r2 = f2912b + 31;
        f2913c = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ea, code lost:
        if (r7.getTextColor() == null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ec, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ee, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ef, code lost:
        if (r2 == false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f2, code lost:
        r2 = f2913c;
        r4 = ((r2 ^ 29) | (r2 & 29)) << 1;
        r2 = -(((~r2) & 29) | (r2 & -30));
        r5 = ((r4 | r2) << 1) - (r2 ^ r4);
        f2912b = r5 % 128;
        r5 = r5 % 2;
        r6.setTitleTextColor(android.graphics.Color.parseColor(r7.getTextColor()));
        r6 = f2913c + 105;
        f2912b = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0121, code lost:
        r6 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r8.findViewById(com.taxis99.R.id.toolbarButton);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012d, code lost:
        if (r7.getButtonText() == null) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012f, code lost:
        r8 = kotlin.text.Typography.amp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0132, code lost:
        r8 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0134, code lost:
        if (r8 == 9) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0136, code lost:
        r8 = f2912b;
        r3 = ((((r8 ^ 119) | (r8 & 119)) << 1) - (~(-(((~r8) & 119) | (r8 & -120))))) - 1;
        f2913c = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0151, code lost:
        if ((r3 % 2) != 0) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0153, code lost:
        r2 = kotlin.text.Typography.quote;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0156, code lost:
        r2 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0157, code lost:
        if (r2 == '\"') goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0159, code lost:
        r6.setCCAText(r7.getButtonText());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0161, code lost:
        r6.setCCAText(r7.getButtonText());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r6 = 43 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016b, code lost:
        r6 = (f2912b + 56) - 1;
        f2913c = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0179, code lost:
        r6 = f2912b;
        r7 = (r6 | 27) << 1;
        r6 = -(r6 ^ 27);
        r8 = ((r7 | r6) << 1) - (r6 ^ r7);
        f2913c = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x018c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void configure(androidx.appcompat.widget.Toolbar r6, com.cardinalcommerce.shared.userinterfaces.UiCustomization r7, android.app.Activity r8) {
        /*
            int r0 = f2913c
            r1 = r0 & 93
            r0 = r0 ^ 93
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2912b = r0
            int r2 = r2 % 2
            r0 = 0
            r1 = 1
            if (r2 == 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            r3 = 2131434671(0x7f0b1caf, float:1.8491163E38)
            if (r2 == r1) goto L_0x002f
            com.cardinalcommerce.shared.userinterfaces.ToolbarCustomization r2 = r7.getToolbarCustomization()
            r4 = 58
            if (r2 != 0) goto L_0x002a
            r2 = 30
            goto L_0x002c
        L_0x002a:
            r2 = 58
        L_0x002c:
            if (r2 == r4) goto L_0x0075
            goto L_0x003d
        L_0x002f:
            com.cardinalcommerce.shared.userinterfaces.ToolbarCustomization r2 = r7.getToolbarCustomization()
            r4 = 91
            int r4 = r4 / r0
            if (r2 != 0) goto L_0x003a
            r2 = 0
            goto L_0x003b
        L_0x003a:
            r2 = 1
        L_0x003b:
            if (r2 == r1) goto L_0x0075
        L_0x003d:
            r7 = 2131957847(0x7f131857, float:1.955229E38)
            r6.setTitle((int) r7)
            android.view.View r6 = r8.findViewById(r3)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r6 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r6
            android.content.res.Resources r7 = r8.getResources()
            r0 = 2131953556(0x7f130794, float:1.9543586E38)
            java.lang.String r7 = r7.getString(r0)
            r6.setCCAText(r7)
            android.content.res.Resources r7 = r8.getResources()
            r8 = 2131099853(0x7f0600cd, float:1.781207E38)
            int r7 = r7.getColor(r8)
            r6.setTextColor(r7)
            int r6 = f2912b
            int r6 = r6 + 64
            r7 = r6 & -1
            r6 = r6 | -1
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2913c = r6
            int r7 = r7 % 2
            return
        L_0x0075:
            com.cardinalcommerce.shared.userinterfaces.ToolbarCustomization r7 = r7.getToolbarCustomization()
            java.lang.String r2 = r7.getBackgroundColor()
            if (r2 == 0) goto L_0x0081
            r2 = 0
            goto L_0x0082
        L_0x0081:
            r2 = 1
        L_0x0082:
            if (r2 == 0) goto L_0x0085
            goto L_0x00b6
        L_0x0085:
            int r2 = f2912b
            int r2 = r2 + 77
            int r2 = r2 - r1
            int r2 = r2 - r1
            int r4 = r2 % 128
            f2913c = r4
            int r2 = r2 % 2
            r4 = 45
            if (r2 != 0) goto L_0x0098
            r2 = 45
            goto L_0x009a
        L_0x0098:
            r2 = 83
        L_0x009a:
            if (r2 == r4) goto L_0x00a8
            java.lang.String r2 = r7.getBackgroundColor()
            int r2 = android.graphics.Color.parseColor(r2)
            r6.setBackgroundColor(r2)
            goto L_0x00b6
        L_0x00a8:
            java.lang.String r2 = r7.getBackgroundColor()
            int r2 = android.graphics.Color.parseColor(r2)
            r6.setBackgroundColor(r2)
            r2 = 77
            int r2 = r2 / r0
        L_0x00b6:
            java.lang.String r2 = r7.getHeaderText()
            if (r2 == 0) goto L_0x00be
            r2 = 1
            goto L_0x00bf
        L_0x00be:
            r2 = 0
        L_0x00bf:
            if (r2 == 0) goto L_0x00e6
            int r2 = f2912b
            r4 = r2 ^ 11
            r2 = r2 & 11
            int r2 = r2 << r1
            int r2 = -r2
            int r2 = -r2
            r5 = r4 ^ r2
            r2 = r2 & r4
            int r2 = r2 << r1
            int r5 = r5 + r2
            int r2 = r5 % 128
            f2913c = r2
            int r5 = r5 % 2
            java.lang.String r2 = r7.getHeaderText()
            r6.setTitle((java.lang.CharSequence) r2)
            int r2 = f2912b
            int r2 = r2 + 31
            int r4 = r2 % 128
            f2913c = r4
            int r2 = r2 % 2
        L_0x00e6:
            java.lang.String r2 = r7.getTextColor()
            if (r2 == 0) goto L_0x00ee
            r2 = 0
            goto L_0x00ef
        L_0x00ee:
            r2 = 1
        L_0x00ef:
            if (r2 == 0) goto L_0x00f2
            goto L_0x0121
        L_0x00f2:
            int r2 = f2913c
            r4 = r2 ^ 29
            r5 = r2 & 29
            r4 = r4 | r5
            int r4 = r4 << r1
            r5 = r2 & -30
            int r2 = ~r2
            r2 = r2 & 29
            r2 = r2 | r5
            int r2 = -r2
            r5 = r4 | r2
            int r5 = r5 << r1
            r2 = r2 ^ r4
            int r5 = r5 - r2
            int r2 = r5 % 128
            f2912b = r2
            int r5 = r5 % 2
            java.lang.String r2 = r7.getTextColor()
            int r2 = android.graphics.Color.parseColor(r2)
            r6.setTitleTextColor((int) r2)
            int r6 = f2913c
            int r6 = r6 + 105
            int r2 = r6 % 128
            f2912b = r2
            int r6 = r6 % 2
        L_0x0121:
            android.view.View r6 = r8.findViewById(r3)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r6 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r6
            java.lang.String r8 = r7.getButtonText()
            r2 = 9
            if (r8 == 0) goto L_0x0132
            r8 = 38
            goto L_0x0134
        L_0x0132:
            r8 = 9
        L_0x0134:
            if (r8 == r2) goto L_0x0179
            int r8 = f2912b
            r2 = 119(0x77, float:1.67E-43)
            r3 = r8 ^ 119(0x77, float:1.67E-43)
            r4 = r8 & 119(0x77, float:1.67E-43)
            r3 = r3 | r4
            int r3 = r3 << r1
            r4 = r8 & -120(0xffffffffffffff88, float:NaN)
            int r8 = ~r8
            r8 = r8 & r2
            r8 = r8 | r4
            int r8 = -r8
            int r8 = ~r8
            int r3 = r3 - r8
            int r3 = r3 - r1
            int r8 = r3 % 128
            f2913c = r8
            int r3 = r3 % 2
            r8 = 34
            if (r3 != 0) goto L_0x0156
            r2 = 34
            goto L_0x0157
        L_0x0156:
            r2 = 6
        L_0x0157:
            if (r2 == r8) goto L_0x0161
            java.lang.String r7 = r7.getButtonText()
            r6.setCCAText(r7)
            goto L_0x016b
        L_0x0161:
            java.lang.String r7 = r7.getButtonText()
            r6.setCCAText(r7)
            r6 = 43
            int r6 = r6 / r0
        L_0x016b:
            int r6 = f2912b
            int r6 = r6 + 56
            int r6 = r6 - r1
            int r7 = r6 % 128
            f2913c = r7
            int r6 = r6 % 2
            goto L_0x0179
        L_0x0177:
            r6 = move-exception
            throw r6
        L_0x0179:
            int r6 = f2912b
            r7 = r6 | 27
            int r7 = r7 << r1
            r6 = r6 ^ 27
            int r6 = -r6
            r8 = r7 | r6
            int r8 = r8 << r1
            r6 = r6 ^ r7
            int r8 = r8 - r6
            int r6 = r8 % 128
            f2913c = r6
            int r8 = r8 % 2
            return
        L_0x018d:
            r6 = move-exception
            throw r6
        L_0x018f:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setPaintFlags.configure(androidx.appcompat.widget.Toolbar, com.cardinalcommerce.shared.userinterfaces.UiCustomization, android.app.Activity):void");
    }
}
