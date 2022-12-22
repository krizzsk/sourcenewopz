package com.didi.dqr.common;

import com.didi.dqr.NotFoundException;

public abstract class GridSampler {

    /* renamed from: a */
    private static GridSampler f18545a = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

    public static void setGridSampler(GridSampler gridSampler) {
        f18545a = gridSampler;
    }

    public static GridSampler getInstance() {
        return f18545a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void checkAndNudgePoints(com.didi.dqr.common.BitMatrix r10, float[] r11) throws com.didi.dqr.NotFoundException {
        /*
            int r0 = r10.getWidth()
            int r10 = r10.getHeight()
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        L_0x000c:
            int r5 = r11.length
            java.lang.String r6 = "dqr_cperspective_transform_failed"
            r7 = 0
            r8 = -1
            if (r3 >= r5) goto L_0x004d
            if (r4 == 0) goto L_0x004d
            r4 = r11[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r9 = r11[r5]
            int r9 = (int) r9
            if (r4 < r8) goto L_0x0045
            if (r4 > r0) goto L_0x0045
            if (r9 < r8) goto L_0x0045
            if (r9 > r10) goto L_0x0045
            if (r4 != r8) goto L_0x002b
            r11[r3] = r7
        L_0x0029:
            r4 = 1
            goto L_0x0034
        L_0x002b:
            if (r4 != r0) goto L_0x0033
            int r4 = r0 + -1
            float r4 = (float) r4
            r11[r3] = r4
            goto L_0x0029
        L_0x0033:
            r4 = 0
        L_0x0034:
            if (r9 != r8) goto L_0x003a
            r11[r5] = r7
        L_0x0038:
            r4 = 1
            goto L_0x0042
        L_0x003a:
            if (r9 != r10) goto L_0x0042
            int r4 = r10 + -1
            float r4 = (float) r4
            r11[r5] = r4
            goto L_0x0038
        L_0x0042:
            int r3 = r3 + 2
            goto L_0x000c
        L_0x0045:
            com.didi.dqrutil.analysis.AnalysisManager.report(r6)
            com.didi.dqr.NotFoundException r10 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x004d:
            int r3 = r11.length
            int r3 = r3 + -2
            r4 = 1
        L_0x0051:
            if (r3 < 0) goto L_0x008d
            if (r4 == 0) goto L_0x008d
            r4 = r11[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r9 = r11[r5]
            int r9 = (int) r9
            if (r4 < r8) goto L_0x0085
            if (r4 > r0) goto L_0x0085
            if (r9 < r8) goto L_0x0085
            if (r9 > r10) goto L_0x0085
            if (r4 != r8) goto L_0x006b
            r11[r3] = r7
        L_0x0069:
            r4 = 1
            goto L_0x0074
        L_0x006b:
            if (r4 != r0) goto L_0x0073
            int r4 = r0 + -1
            float r4 = (float) r4
            r11[r3] = r4
            goto L_0x0069
        L_0x0073:
            r4 = 0
        L_0x0074:
            if (r9 != r8) goto L_0x007a
            r11[r5] = r7
        L_0x0078:
            r4 = 1
            goto L_0x0082
        L_0x007a:
            if (r9 != r10) goto L_0x0082
            int r4 = r10 + -1
            float r4 = (float) r4
            r11[r5] = r4
            goto L_0x0078
        L_0x0082:
            int r3 = r3 + -2
            goto L_0x0051
        L_0x0085:
            com.didi.dqrutil.analysis.AnalysisManager.report(r6)
            com.didi.dqr.NotFoundException r10 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r10
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.common.GridSampler.checkAndNudgePoints(com.didi.dqr.common.BitMatrix, float[]):void");
    }
}
