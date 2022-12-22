package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchy inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, @Nullable AttributeSet attributeSet) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        GenericDraweeHierarchyBuilder updateBuilder = updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return updateBuilder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:152:0x022a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder r20, android.content.Context r21, @javax.annotation.Nullable android.util.AttributeSet r22) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r4 = 0
            if (r2 == 0) goto L_0x0238
            int[] r6 = com.didi.passenger.C10448R.styleable.GenericDraweeHierarchy
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r2, r6)
            int r7 = r2.getIndexCount()     // Catch:{ all -> 0x0217 }
            r6 = 0
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 1
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
            r16 = 1
            r17 = 0
        L_0x0020:
            if (r8 >= r7) goto L_0x01af
            int r5 = r2.getIndex(r8)     // Catch:{ all -> 0x01aa }
            if (r5 != 0) goto L_0x0039
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r5 = getScaleTypeFromXml(r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setActualImageScaleType(r5)     // Catch:{ all -> 0x0036 }
        L_0x002f:
            r4 = r16
            r16 = r17
        L_0x0033:
            r3 = 0
            goto L_0x019f
        L_0x0036:
            r0 = move-exception
            goto L_0x0221
        L_0x0039:
            r3 = 6
            if (r5 != r3) goto L_0x0044
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setPlaceholderImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x0044:
            r3 = 8
            if (r5 != r3) goto L_0x0050
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setPressedStateOverlay(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x0050:
            r3 = 10
            if (r5 != r3) goto L_0x005c
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setProgressBarImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x005c:
            r3 = 2
            if (r5 != r3) goto L_0x0067
            int r3 = r2.getInt(r5, r4)     // Catch:{ all -> 0x0036 }
            r0.setFadeDuration(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x0067:
            r3 = 28
            if (r5 != r3) goto L_0x0074
            r3 = 0
            float r5 = r2.getFloat(r5, r3)     // Catch:{ all -> 0x0036 }
            r0.setDesiredAspectRatio(r5)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x0074:
            r3 = 7
            if (r5 != r3) goto L_0x007f
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setPlaceholderImageScaleType(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x007f:
            r3 = 12
            if (r5 != r3) goto L_0x008b
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setRetryImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x008b:
            r3 = 13
            if (r5 != r3) goto L_0x0097
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setRetryImageScaleType(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x0097:
            r3 = 3
            if (r5 != r3) goto L_0x00a2
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setFailureImage((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x00a2:
            r3 = 4
            if (r5 != r3) goto L_0x00ad
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setFailureImageScaleType(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x00ad:
            r3 = 11
            if (r5 != r3) goto L_0x00ba
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r3 = getScaleTypeFromXml(r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setProgressBarImageScaleType(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x00ba:
            r3 = 9
            if (r5 != r3) goto L_0x00c5
            int r6 = r2.getInteger(r5, r6)     // Catch:{ all -> 0x0036 }
        L_0x00c2:
            r3 = 0
            goto L_0x01a3
        L_0x00c5:
            r3 = 1
            if (r5 != r3) goto L_0x00d1
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setBackground(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x00d1:
            r3 = 5
            if (r5 != r3) goto L_0x00dd
            android.graphics.drawable.Drawable r3 = getDrawable(r1, r2, r5)     // Catch:{ all -> 0x0036 }
            r0.setOverlay(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x00dd:
            r3 = 14
            if (r5 != r3) goto L_0x00ee
            com.facebook.drawee.generic.RoundingParams r3 = getRoundingParams(r20)     // Catch:{ all -> 0x0036 }
            boolean r5 = r2.getBoolean(r5, r4)     // Catch:{ all -> 0x0036 }
            r3.setRoundAsCircle(r5)     // Catch:{ all -> 0x0036 }
            goto L_0x002f
        L_0x00ee:
            r3 = 24
            if (r5 != r3) goto L_0x00f9
            r3 = r17
            int r17 = r2.getDimensionPixelSize(r5, r3)     // Catch:{ all -> 0x0036 }
            goto L_0x00c2
        L_0x00f9:
            r3 = r17
            r4 = 20
            if (r5 != r4) goto L_0x0106
            boolean r9 = r2.getBoolean(r5, r9)     // Catch:{ all -> 0x0036 }
        L_0x0103:
            r17 = r3
            goto L_0x00c2
        L_0x0106:
            r4 = 21
            if (r5 != r4) goto L_0x010f
            boolean r11 = r2.getBoolean(r5, r11)     // Catch:{ all -> 0x0036 }
            goto L_0x0103
        L_0x010f:
            r4 = 16
            if (r5 != r4) goto L_0x0118
            boolean r15 = r2.getBoolean(r5, r15)     // Catch:{ all -> 0x0036 }
            goto L_0x0103
        L_0x0118:
            r4 = 17
            if (r5 != r4) goto L_0x0121
            boolean r13 = r2.getBoolean(r5, r13)     // Catch:{ all -> 0x0036 }
            goto L_0x0103
        L_0x0121:
            r4 = 22
            if (r5 != r4) goto L_0x012a
            boolean r10 = r2.getBoolean(r5, r10)     // Catch:{ all -> 0x0036 }
            goto L_0x0103
        L_0x012a:
            r4 = 19
            if (r5 != r4) goto L_0x0133
            boolean r12 = r2.getBoolean(r5, r12)     // Catch:{ all -> 0x0036 }
            goto L_0x0103
        L_0x0133:
            r4 = 18
            if (r5 != r4) goto L_0x0143
            r4 = r16
            boolean r16 = r2.getBoolean(r5, r4)     // Catch:{ all -> 0x013e }
            goto L_0x0103
        L_0x013e:
            r0 = move-exception
            r16 = r4
            goto L_0x0221
        L_0x0143:
            r4 = r16
            r1 = 15
            if (r5 != r1) goto L_0x0153
            boolean r14 = r2.getBoolean(r5, r14)     // Catch:{ all -> 0x013e }
            r17 = r3
            r16 = r4
            goto L_0x00c2
        L_0x0153:
            r1 = 23
            if (r5 != r1) goto L_0x0167
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r20)     // Catch:{ all -> 0x013e }
            r16 = r3
            r3 = 0
            int r5 = r2.getColor(r5, r3)     // Catch:{ all -> 0x013e }
            r1.setOverlayColor(r5)     // Catch:{ all -> 0x013e }
            goto L_0x0033
        L_0x0167:
            r16 = r3
            r1 = 27
            if (r5 != r1) goto L_0x017c
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r20)     // Catch:{ all -> 0x013e }
            r3 = 0
            int r5 = r2.getDimensionPixelSize(r5, r3)     // Catch:{ all -> 0x013e }
            float r3 = (float) r5     // Catch:{ all -> 0x013e }
            r1.setBorderWidth(r3)     // Catch:{ all -> 0x013e }
            goto L_0x0033
        L_0x017c:
            r1 = 25
            if (r5 != r1) goto L_0x018e
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r20)     // Catch:{ all -> 0x013e }
            r3 = 0
            int r5 = r2.getColor(r5, r3)     // Catch:{ all -> 0x013e }
            r1.setBorderColor(r5)     // Catch:{ all -> 0x013e }
            goto L_0x0033
        L_0x018e:
            r1 = 26
            if (r5 != r1) goto L_0x0033
            com.facebook.drawee.generic.RoundingParams r1 = getRoundingParams(r20)     // Catch:{ all -> 0x013e }
            r3 = 0
            int r5 = r2.getDimensionPixelSize(r5, r3)     // Catch:{ all -> 0x013e }
            float r5 = (float) r5     // Catch:{ all -> 0x013e }
            r1.setPadding(r5)     // Catch:{ all -> 0x013e }
        L_0x019f:
            r17 = r16
            r16 = r4
        L_0x01a3:
            int r8 = r8 + 1
            r1 = r21
            r4 = 0
            goto L_0x0020
        L_0x01aa:
            r0 = move-exception
            r4 = r16
            goto L_0x0221
        L_0x01af:
            r4 = r16
            r16 = r17
            r3 = 0
            r2.recycle()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x01f0
            android.content.res.Resources r1 = r21.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.getLayoutDirection()
            r2 = 1
            if (r1 != r2) goto L_0x01f0
            if (r9 == 0) goto L_0x01d2
            if (r12 == 0) goto L_0x01d2
            r1 = 1
            goto L_0x01d3
        L_0x01d2:
            r1 = 0
        L_0x01d3:
            if (r11 == 0) goto L_0x01d9
            if (r10 == 0) goto L_0x01d9
            r2 = 1
            goto L_0x01da
        L_0x01d9:
            r2 = 0
        L_0x01da:
            if (r13 == 0) goto L_0x01e0
            if (r4 == 0) goto L_0x01e0
            r4 = 1
            goto L_0x01e1
        L_0x01e0:
            r4 = 0
        L_0x01e1:
            if (r15 == 0) goto L_0x01e8
            if (r14 == 0) goto L_0x01e8
            r18 = 1
            goto L_0x01ea
        L_0x01e8:
            r18 = 0
        L_0x01ea:
            r5 = r1
            r1 = r4
            r4 = r6
            r3 = r16
            goto L_0x023f
        L_0x01f0:
            if (r9 == 0) goto L_0x01f6
            if (r10 == 0) goto L_0x01f6
            r1 = 1
            goto L_0x01f7
        L_0x01f6:
            r1 = 0
        L_0x01f7:
            if (r11 == 0) goto L_0x01fd
            if (r12 == 0) goto L_0x01fd
            r2 = 1
            goto L_0x01fe
        L_0x01fd:
            r2 = 0
        L_0x01fe:
            if (r13 == 0) goto L_0x0204
            if (r14 == 0) goto L_0x0204
            r5 = 1
            goto L_0x0205
        L_0x0204:
            r5 = 0
        L_0x0205:
            if (r15 == 0) goto L_0x020b
            if (r4 == 0) goto L_0x020b
            r4 = 1
            goto L_0x020c
        L_0x020b:
            r4 = 0
        L_0x020c:
            r18 = r4
            r4 = r6
            r3 = r16
            r19 = r5
            r5 = r1
            r1 = r19
            goto L_0x023f
        L_0x0217:
            r0 = move-exception
            r9 = 1
            r10 = 1
            r11 = 1
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
            r16 = 1
        L_0x0221:
            r2.recycle()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x0237
            android.content.res.Resources r1 = r21.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.getLayoutDirection()
            r2 = 1
        L_0x0237:
            throw r0
        L_0x0238:
            r2 = 1
            r3 = 0
            r1 = 1
            r4 = 0
            r5 = 1
            r18 = 1
        L_0x023f:
            android.graphics.drawable.Drawable r6 = r20.getProgressBarImage()
            if (r6 == 0) goto L_0x0253
            if (r4 <= 0) goto L_0x0253
            com.facebook.drawee.drawable.AutoRotateDrawable r6 = new com.facebook.drawee.drawable.AutoRotateDrawable
            android.graphics.drawable.Drawable r7 = r20.getProgressBarImage()
            r6.<init>(r7, r4)
            r0.setProgressBarImage((android.graphics.drawable.Drawable) r6)
        L_0x0253:
            if (r3 <= 0) goto L_0x0270
            com.facebook.drawee.generic.RoundingParams r4 = getRoundingParams(r20)
            if (r5 == 0) goto L_0x025d
            float r5 = (float) r3
            goto L_0x025e
        L_0x025d:
            r5 = 0
        L_0x025e:
            if (r2 == 0) goto L_0x0262
            float r2 = (float) r3
            goto L_0x0263
        L_0x0262:
            r2 = 0
        L_0x0263:
            if (r1 == 0) goto L_0x0267
            float r1 = (float) r3
            goto L_0x0268
        L_0x0267:
            r1 = 0
        L_0x0268:
            if (r18 == 0) goto L_0x026c
            float r3 = (float) r3
            goto L_0x026d
        L_0x026c:
            r3 = 0
        L_0x026d:
            r4.setCornersRadii(r5, r2, r1, r3)
        L_0x0270:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.GenericDraweeHierarchyInflater.updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder, android.content.Context, android.util.AttributeSet):com.facebook.drawee.generic.GenericDraweeHierarchyBuilder");
    }

    private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    @Nullable
    private static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    @Nullable
    private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils.ScaleType.FIT_XY;
            case 1:
                return ScalingUtils.ScaleType.FIT_START;
            case 2:
                return ScalingUtils.ScaleType.FIT_CENTER;
            case 3:
                return ScalingUtils.ScaleType.FIT_END;
            case 4:
                return ScalingUtils.ScaleType.CENTER;
            case 5:
                return ScalingUtils.ScaleType.CENTER_INSIDE;
            case 6:
                return ScalingUtils.ScaleType.CENTER_CROP;
            case 7:
                return ScalingUtils.ScaleType.FOCUS_CROP;
            case 8:
                return ScalingUtils.ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
