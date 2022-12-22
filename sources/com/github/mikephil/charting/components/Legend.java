package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {

    /* renamed from: a */
    private LegendEntry[] f52290a;

    /* renamed from: b */
    private LegendEntry[] f52291b;

    /* renamed from: c */
    private boolean f52292c;

    /* renamed from: d */
    private LegendHorizontalAlignment f52293d;

    /* renamed from: e */
    private LegendVerticalAlignment f52294e;

    /* renamed from: f */
    private LegendOrientation f52295f;

    /* renamed from: g */
    private boolean f52296g;

    /* renamed from: h */
    private LegendDirection f52297h;

    /* renamed from: i */
    private LegendForm f52298i;

    /* renamed from: j */
    private float f52299j;

    /* renamed from: k */
    private float f52300k;

    /* renamed from: l */
    private DashPathEffect f52301l;

    /* renamed from: m */
    private float f52302m;
    public float mNeededHeight;
    public float mNeededWidth;
    public float mTextHeightMax;
    public float mTextWidthMax;

    /* renamed from: n */
    private float f52303n;

    /* renamed from: o */
    private float f52304o;

    /* renamed from: p */
    private float f52305p;

    /* renamed from: q */
    private float f52306q;

    /* renamed from: r */
    private boolean f52307r;

    /* renamed from: s */
    private List<FSize> f52308s;

    /* renamed from: t */
    private List<Boolean> f52309t;

    /* renamed from: u */
    private List<FSize> f52310u;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.f52290a = new LegendEntry[0];
        this.f52292c = false;
        this.f52293d = LegendHorizontalAlignment.LEFT;
        this.f52294e = LegendVerticalAlignment.BOTTOM;
        this.f52295f = LegendOrientation.HORIZONTAL;
        this.f52296g = false;
        this.f52297h = LegendDirection.LEFT_TO_RIGHT;
        this.f52298i = LegendForm.SQUARE;
        this.f52299j = 8.0f;
        this.f52300k = 3.0f;
        this.f52301l = null;
        this.f52302m = 6.0f;
        this.f52303n = 0.0f;
        this.f52304o = 5.0f;
        this.f52305p = 3.0f;
        this.f52306q = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.f52307r = false;
        this.f52308s = new ArrayList(16);
        this.f52309t = new ArrayList(16);
        this.f52310u = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.f52290a = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }

    public void setEntries(List<LegendEntry> list) {
        this.f52290a = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public LegendEntry[] getEntries() {
        return this.f52290a;
    }

    public float getMaximumEntryWidth(Paint paint) {
        float convertDpToPixel = Utils.convertDpToPixel(this.f52304o);
        float f = 0.0f;
        float f2 = 0.0f;
        for (LegendEntry legendEntry : this.f52290a) {
            float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.f52299j : legendEntry.formSize);
            if (convertDpToPixel2 > f2) {
                f2 = convertDpToPixel2;
            }
            String str = legendEntry.label;
            if (str != null) {
                float calcTextWidth = (float) Utils.calcTextWidth(paint, str);
                if (calcTextWidth > f) {
                    f = calcTextWidth;
                }
            }
        }
        return f + f2 + convertDpToPixel;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f = 0.0f;
        for (LegendEntry legendEntry : this.f52290a) {
            String str = legendEntry.label;
            if (str != null) {
                float calcTextHeight = (float) Utils.calcTextHeight(paint, str);
                if (calcTextHeight > f) {
                    f = calcTextHeight;
                }
            }
        }
        return f;
    }

    public LegendEntry[] getExtraEntries() {
        return this.f52291b;
    }

    public void setExtra(List<LegendEntry> list) {
        this.f52291b = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.f52291b = legendEntryArr;
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Math.min(iArr.length, strArr.length); i++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.formColor = iArr[i];
            legendEntry.label = strArr[i];
            if (legendEntry.formColor == 1122868 || legendEntry.formColor == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (legendEntry.formColor == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.f52291b = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.f52290a = legendEntryArr;
        this.f52292c = true;
    }

    public void setCustom(List<LegendEntry> list) {
        this.f52290a = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.f52292c = true;
    }

    public void resetCustom() {
        this.f52292c = false;
    }

    public boolean isLegendCustom() {
        return this.f52292c;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.f52293d;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.f52293d = legendHorizontalAlignment;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.f52294e;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.f52294e = legendVerticalAlignment;
    }

    public LegendOrientation getOrientation() {
        return this.f52295f;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.f52295f = legendOrientation;
    }

    public boolean isDrawInsideEnabled() {
        return this.f52296g;
    }

    public void setDrawInside(boolean z) {
        this.f52296g = z;
    }

    public LegendDirection getDirection() {
        return this.f52297h;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.f52297h = legendDirection;
    }

    public LegendForm getForm() {
        return this.f52298i;
    }

    public void setForm(LegendForm legendForm) {
        this.f52298i = legendForm;
    }

    public void setFormSize(float f) {
        this.f52299j = f;
    }

    public float getFormSize() {
        return this.f52299j;
    }

    public void setFormLineWidth(float f) {
        this.f52300k = f;
    }

    public float getFormLineWidth() {
        return this.f52300k;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.f52301l = dashPathEffect;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.f52301l;
    }

    public float getXEntrySpace() {
        return this.f52302m;
    }

    public void setXEntrySpace(float f) {
        this.f52302m = f;
    }

    public float getYEntrySpace() {
        return this.f52303n;
    }

    public void setYEntrySpace(float f) {
        this.f52303n = f;
    }

    public float getFormToTextSpace() {
        return this.f52304o;
    }

    public void setFormToTextSpace(float f) {
        this.f52304o = f;
    }

    public float getStackSpace() {
        return this.f52305p;
    }

    public void setStackSpace(float f) {
        this.f52305p = f;
    }

    public void setWordWrapEnabled(boolean z) {
        this.f52307r = z;
    }

    public boolean isWordWrapEnabled() {
        return this.f52307r;
    }

    public float getMaxSizePercent() {
        return this.f52306q;
    }

    public void setMaxSizePercent(float f) {
        this.f52306q = f;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.f52308s;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.f52309t;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.f52310u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateDimensions(android.graphics.Paint r28, com.github.mikephil.charting.utils.ViewPortHandler r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            float r2 = r0.f52299j
            float r2 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r2)
            float r3 = r0.f52305p
            float r3 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r3)
            float r4 = r0.f52304o
            float r4 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r4)
            float r5 = r0.f52302m
            float r5 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r5)
            float r6 = r0.f52303n
            float r6 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r6)
            boolean r7 = r0.f52307r
            com.github.mikephil.charting.components.LegendEntry[] r8 = r0.f52290a
            int r9 = r8.length
            float r10 = r27.getMaximumEntryWidth(r28)
            r0.mTextWidthMax = r10
            float r10 = r27.getMaximumEntryHeight(r28)
            r0.mTextHeightMax = r10
            int[] r10 = com.github.mikephil.charting.components.Legend.C178611.f52311x9c9dbef
            com.github.mikephil.charting.components.Legend$LegendOrientation r11 = r0.f52295f
            int r11 = r11.ordinal()
            r10 = r10[r11]
            r12 = 1
            if (r10 == r12) goto L_0x017a
            r14 = 2
            if (r10 == r14) goto L_0x0045
            goto L_0x01f7
        L_0x0045:
            float r10 = com.github.mikephil.charting.utils.Utils.getLineHeight(r28)
            float r14 = com.github.mikephil.charting.utils.Utils.getLineSpacing(r28)
            float r14 = r14 + r6
            float r6 = r29.contentWidth()
            float r15 = r0.f52306q
            float r6 = r6 * r15
            java.util.List<java.lang.Boolean> r15 = r0.f52309t
            r15.clear()
            java.util.List<com.github.mikephil.charting.utils.FSize> r15 = r0.f52308s
            r15.clear()
            java.util.List<com.github.mikephil.charting.utils.FSize> r15 = r0.f52310u
            r15.clear()
            r12 = 0
            r13 = -1
            r17 = 0
            r19 = 0
            r20 = 0
        L_0x006d:
            if (r12 >= r9) goto L_0x014f
            r15 = r8[r12]
            com.github.mikephil.charting.components.Legend$LegendForm r11 = r15.form
            r22 = r2
            com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            if (r11 == r2) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x007b:
            r2 = 0
        L_0x007c:
            float r11 = r15.formSize
            boolean r11 = java.lang.Float.isNaN(r11)
            if (r11 == 0) goto L_0x0087
            r11 = r22
            goto L_0x008d
        L_0x0087:
            float r11 = r15.formSize
            float r11 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r11)
        L_0x008d:
            java.lang.String r15 = r15.label
            r23 = r5
            java.util.List<java.lang.Boolean> r5 = r0.f52309t
            r24 = r8
            r21 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r21)
            r5.add(r8)
            r5 = -1
            if (r13 != r5) goto L_0x00a3
            r5 = 0
            goto L_0x00a5
        L_0x00a3:
            float r5 = r19 + r3
        L_0x00a5:
            if (r15 == 0) goto L_0x00c5
            java.util.List<com.github.mikephil.charting.utils.FSize> r8 = r0.f52308s
            r19 = r3
            com.github.mikephil.charting.utils.FSize r3 = com.github.mikephil.charting.utils.Utils.calcTextSize(r1, r15)
            r8.add(r3)
            if (r2 == 0) goto L_0x00b7
            float r2 = r4 + r11
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            float r5 = r5 + r2
            java.util.List<com.github.mikephil.charting.utils.FSize> r2 = r0.f52308s
            java.lang.Object r2 = r2.get(r12)
            com.github.mikephil.charting.utils.FSize r2 = (com.github.mikephil.charting.utils.FSize) r2
            float r2 = r2.width
            float r5 = r5 + r2
            goto L_0x00de
        L_0x00c5:
            r19 = r3
            java.util.List<com.github.mikephil.charting.utils.FSize> r3 = r0.f52308s
            r25 = r11
            r8 = 0
            com.github.mikephil.charting.utils.FSize r11 = com.github.mikephil.charting.utils.FSize.getInstance(r8, r8)
            r3.add(r11)
            if (r2 == 0) goto L_0x00d8
            r11 = r25
            goto L_0x00d9
        L_0x00d8:
            r11 = 0
        L_0x00d9:
            float r5 = r5 + r11
            r2 = -1
            if (r13 != r2) goto L_0x00de
            r13 = r12
        L_0x00de:
            if (r15 != 0) goto L_0x00e4
            int r2 = r9 + -1
            if (r12 != r2) goto L_0x013e
        L_0x00e4:
            r2 = r20
            r8 = 0
            int r3 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x00ed
            r11 = 0
            goto L_0x00ef
        L_0x00ed:
            r11 = r23
        L_0x00ef:
            if (r7 == 0) goto L_0x011f
            if (r3 == 0) goto L_0x011f
            float r3 = r6 - r2
            float r18 = r11 + r5
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 < 0) goto L_0x00fc
            goto L_0x011f
        L_0x00fc:
            java.util.List<com.github.mikephil.charting.utils.FSize> r3 = r0.f52310u
            com.github.mikephil.charting.utils.FSize r11 = com.github.mikephil.charting.utils.FSize.getInstance(r2, r10)
            r3.add(r11)
            r3 = r17
            float r2 = java.lang.Math.max(r3, r2)
            java.util.List<java.lang.Boolean> r3 = r0.f52309t
            r11 = -1
            if (r13 <= r11) goto L_0x0112
            r8 = r13
            goto L_0x0113
        L_0x0112:
            r8 = r12
        L_0x0113:
            r16 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r16)
            r3.set(r8, r11)
            r3 = r5
            r8 = -1
            goto L_0x0128
        L_0x011f:
            r3 = r17
            r8 = -1
            float r11 = r11 + r5
            float r20 = r2 + r11
            r2 = r3
            r3 = r20
        L_0x0128:
            int r11 = r9 + -1
            if (r12 != r11) goto L_0x013a
            java.util.List<com.github.mikephil.charting.utils.FSize> r11 = r0.f52310u
            com.github.mikephil.charting.utils.FSize r8 = com.github.mikephil.charting.utils.FSize.getInstance(r3, r10)
            r11.add(r8)
            float r17 = java.lang.Math.max(r2, r3)
            goto L_0x013c
        L_0x013a:
            r17 = r2
        L_0x013c:
            r20 = r3
        L_0x013e:
            if (r15 == 0) goto L_0x0141
            r13 = -1
        L_0x0141:
            int r12 = r12 + 1
            r3 = r19
            r2 = r22
            r8 = r24
            r19 = r5
            r5 = r23
            goto L_0x006d
        L_0x014f:
            r3 = r17
            r21 = 0
            r0.mNeededWidth = r3
            java.util.List<com.github.mikephil.charting.utils.FSize> r1 = r0.f52310u
            int r1 = r1.size()
            float r1 = (float) r1
            float r10 = r10 * r1
            java.util.List<com.github.mikephil.charting.utils.FSize> r1 = r0.f52310u
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0168
            r11 = 0
            goto L_0x0172
        L_0x0168:
            java.util.List<com.github.mikephil.charting.utils.FSize> r1 = r0.f52310u
            int r1 = r1.size()
            r16 = 1
            int r11 = r1 + -1
        L_0x0172:
            float r1 = (float) r11
            float r14 = r14 * r1
            float r10 = r10 + r14
            r0.mNeededHeight = r10
            goto L_0x01f7
        L_0x017a:
            r22 = r2
            r19 = r3
            r24 = r8
            r16 = 1
            r21 = 0
            float r2 = com.github.mikephil.charting.utils.Utils.getLineHeight(r28)
            r3 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r10 = 0
        L_0x018d:
            if (r7 >= r9) goto L_0x01f3
            r11 = r24[r7]
            com.github.mikephil.charting.components.Legend$LegendForm r12 = r11.form
            com.github.mikephil.charting.components.Legend$LegendForm r13 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            if (r12 == r13) goto L_0x0199
            r12 = 1
            goto L_0x019a
        L_0x0199:
            r12 = 0
        L_0x019a:
            float r13 = r11.formSize
            boolean r13 = java.lang.Float.isNaN(r13)
            if (r13 == 0) goto L_0x01a5
            r13 = r22
            goto L_0x01ab
        L_0x01a5:
            float r13 = r11.formSize
            float r13 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r13)
        L_0x01ab:
            java.lang.String r11 = r11.label
            if (r10 != 0) goto L_0x01b0
            r5 = 0
        L_0x01b0:
            if (r12 == 0) goto L_0x01b7
            if (r10 == 0) goto L_0x01b6
            float r5 = r5 + r19
        L_0x01b6:
            float r5 = r5 + r13
        L_0x01b7:
            if (r11 == 0) goto L_0x01e4
            if (r12 == 0) goto L_0x01bf
            if (r10 != 0) goto L_0x01bf
            float r5 = r5 + r4
            goto L_0x01cc
        L_0x01bf:
            if (r10 == 0) goto L_0x01cc
            float r8 = java.lang.Math.max(r8, r5)
            float r5 = r2 + r6
            float r3 = r3 + r5
            r5 = r8
            r8 = 0
            r10 = 0
            goto L_0x01d1
        L_0x01cc:
            r26 = r8
            r8 = r5
            r5 = r26
        L_0x01d1:
            int r11 = com.github.mikephil.charting.utils.Utils.calcTextWidth(r1, r11)
            float r11 = (float) r11
            float r8 = r8 + r11
            int r11 = r9 + -1
            if (r7 >= r11) goto L_0x01de
            float r11 = r2 + r6
            float r3 = r3 + r11
        L_0x01de:
            r26 = r8
            r8 = r5
            r5 = r26
            goto L_0x01ec
        L_0x01e4:
            float r5 = r5 + r13
            int r10 = r9 + -1
            if (r7 >= r10) goto L_0x01eb
            float r5 = r5 + r19
        L_0x01eb:
            r10 = 1
        L_0x01ec:
            float r8 = java.lang.Math.max(r8, r5)
            int r7 = r7 + 1
            goto L_0x018d
        L_0x01f3:
            r0.mNeededWidth = r8
            r0.mNeededHeight = r3
        L_0x01f7:
            float r1 = r0.mNeededHeight
            float r2 = r0.mYOffset
            float r1 = r1 + r2
            r0.mNeededHeight = r1
            float r1 = r0.mNeededWidth
            float r2 = r0.mXOffset
            float r1 = r1 + r2
            r0.mNeededWidth = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.calculateDimensions(android.graphics.Paint, com.github.mikephil.charting.utils.ViewPortHandler):void");
    }

    /* renamed from: com.github.mikephil.charting.components.Legend$1 */
    static /* synthetic */ class C178611 {

        /* renamed from: $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation */
        static final /* synthetic */ int[] f52311x9c9dbef;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52311x9c9dbef = r0
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52311x9c9dbef     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.C178611.<clinit>():void");
        }
    }
}
