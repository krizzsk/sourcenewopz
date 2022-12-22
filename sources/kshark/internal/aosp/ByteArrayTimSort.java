package kshark.internal.aosp;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lkshark/internal/aosp/ByteArrayTimSort;", "", "a", "", "c", "Lkshark/internal/aosp/ByteArrayComparator;", "entrySize", "", "([BLkshark/internal/aosp/ByteArrayComparator;I)V", "minGallop", "runBase", "", "runLen", "stackSize", "tmp", "ensureCapacity", "minCapacity", "mergeAt", "", "i", "mergeCollapse", "mergeForceCollapse", "mergeHi", "base1", "len1", "base2", "len2", "mergeLo", "pushRun", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ByteArrayTimSort.kt */
public final class ByteArrayTimSort {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final int f4680i = 32;

    /* renamed from: j */
    private static final int f4681j = 7;

    /* renamed from: k */
    private static final int f4682k = 256;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final boolean f4683l = false;

    /* renamed from: a */
    private int f4684a;

    /* renamed from: b */
    private byte[] f4685b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f4686c;

    /* renamed from: d */
    private final int[] f4687d;

    /* renamed from: e */
    private final int[] f4688e;

    /* renamed from: f */
    private final byte[] f4689f;

    /* renamed from: g */
    private final ByteArrayComparator f4690g;

    /* renamed from: h */
    private final int f4691h;

    public /* synthetic */ ByteArrayTimSort(byte[] bArr, ByteArrayComparator byteArrayComparator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, byteArrayComparator, i);
    }

    private ByteArrayTimSort(byte[] bArr, ByteArrayComparator byteArrayComparator, int i) {
        this.f4689f = bArr;
        this.f4690g = byteArrayComparator;
        this.f4691h = i;
        this.f4684a = f4681j;
        int length = bArr.length / i;
        int i2 = f4682k;
        this.f4685b = new byte[(i * (length < i2 * 2 ? length >>> 1 : i2))];
        int i3 = length < 120 ? 5 : length < 1542 ? 10 : length < 119151 ? 19 : 40;
        this.f4687d = new int[i3];
        this.f4688e = new int[i3];
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m3006a(int i, int i2) {
        int[] iArr = this.f4687d;
        int i3 = this.f4686c;
        iArr[i3] = i;
        this.f4688e[i3] = i2;
        this.f4686c = i3 + 1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r1 = r5.f4688e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r1[r0 - 1] >= r1[r0 + 1]) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (r1[r0 - 1] > (r1[r0] + r1[r0 + 1])) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r1[r0 - 2] <= (r1[r0] + r1[r0 - 1])) goto L_0x002a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3004a() {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r5.f4686c
            r1 = 1
            if (r0 <= r1) goto L_0x0048
            int r0 = r0 + -2
            if (r0 < r1) goto L_0x0018
            int[] r1 = r5.f4688e
            int r2 = r0 + -1
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + 1
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 <= r3) goto L_0x002a
        L_0x0018:
            r1 = 2
            if (r0 < r1) goto L_0x0039
            int[] r1 = r5.f4688e
            int r2 = r0 + -2
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + -1
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 > r3) goto L_0x0039
        L_0x002a:
            int[] r1 = r5.f4688e
            int r2 = r0 + -1
            r2 = r1[r2]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 >= r1) goto L_0x0044
            int r0 = r0 + -1
            goto L_0x0044
        L_0x0039:
            int[] r1 = r5.f4688e
            r2 = r1[r0]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 <= r1) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            r5.m3005a(r0)
            goto L_0x0000
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.aosp.ByteArrayTimSort.m3004a():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m3008b() {
        while (true) {
            int i = this.f4686c;
            if (i > 1) {
                int i2 = i - 2;
                if (i2 > 0) {
                    int[] iArr = this.f4688e;
                    if (iArr[i2 - 1] < iArr[i2 + 1]) {
                        i2--;
                    }
                }
                m3005a(i2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private final void m3005a(int i) {
        int i2 = i;
        boolean z = false;
        if (f4683l) {
            boolean z2 = this.f4686c >= 2;
            if (_Assertions.ENABLED && !z2) {
                throw new AssertionError("Assertion failed");
            }
        }
        if (f4683l) {
            boolean z3 = i2 >= 0;
            if (_Assertions.ENABLED && !z3) {
                throw new AssertionError("Assertion failed");
            }
        }
        if (f4683l) {
            int i3 = this.f4686c;
            boolean z4 = i2 == i3 + -2 || i2 == i3 + -3;
            if (_Assertions.ENABLED && !z4) {
                throw new AssertionError("Assertion failed");
            }
        }
        int[] iArr = this.f4687d;
        int i4 = iArr[i2];
        int[] iArr2 = this.f4688e;
        int i5 = iArr2[i2];
        int i6 = i2 + 1;
        int i7 = iArr[i6];
        int i8 = iArr2[i6];
        if (f4683l) {
            boolean z5 = i5 > 0 && i8 > 0;
            if (_Assertions.ENABLED && !z5) {
                throw new AssertionError("Assertion failed");
            }
        }
        if (f4683l) {
            boolean z6 = i4 + i5 == i7;
            if (_Assertions.ENABLED && !z6) {
                throw new AssertionError("Assertion failed");
            }
        }
        int[] iArr3 = this.f4688e;
        iArr3[i2] = i5 + i8;
        if (i2 == this.f4686c - 3) {
            int[] iArr4 = this.f4687d;
            int i9 = i2 + 2;
            iArr4[i6] = iArr4[i9];
            iArr3[i6] = iArr3[i9];
        }
        this.f4686c--;
        Companion companion = Companion;
        byte[] bArr = this.f4689f;
        int access$gallopRight = companion.gallopRight(bArr, i7, bArr, i4, i5, 0, this.f4691h, this.f4690g);
        if (f4683l) {
            boolean z7 = access$gallopRight >= 0;
            if (_Assertions.ENABLED && !z7) {
                throw new AssertionError("Assertion failed");
            }
        }
        int i10 = i4 + access$gallopRight;
        int i11 = i5 - access$gallopRight;
        if (i11 != 0) {
            Companion companion2 = Companion;
            byte[] bArr2 = this.f4689f;
            int access$gallopLeft = companion2.gallopLeft(bArr2, (i10 + i11) - 1, bArr2, i7, i8, i8 - 1, this.f4691h, this.f4690g);
            if (f4683l) {
                if (access$gallopLeft >= 0) {
                    z = true;
                }
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Assertion failed");
                }
            }
            if (access$gallopLeft != 0) {
                if (i11 <= access$gallopLeft) {
                    m3007a(i10, i11, i7, access$gallopLeft);
                } else {
                    m3009b(i10, i11, i7, access$gallopLeft);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0222, code lost:
        r9 = r26 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0228, code lost:
        if (r24 < f4681j) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x022a, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x022c, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x022f, code lost:
        if (r7 < f4681j) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0231, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0233, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0235, code lost:
        if ((r7 | r10) != false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0237, code lost:
        if (r9 >= 0) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0239, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x024a, code lost:
        r15 = r5;
        r14 = r6;
        r5 = r9;
        r13 = r22;
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e8, code lost:
        r12 = r5;
        r6 = r14;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f6, code lost:
        if (f4683l == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f8, code lost:
        if (r1 <= r6) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        if (r18 <= 0) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fc, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fe, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0101, code lost:
        if (kotlin._Assertions.ENABLED == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0103, code lost:
        if (r7 == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010d, code lost:
        throw new java.lang.AssertionError("Assertion failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010e, code lost:
        r22 = r13;
        r6 = r14;
        r26 = r5;
        r5 = r15;
        r15 = kshark.internal.aosp.ByteArrayTimSort.Companion.access$gallopRight(Companion, r3, r2, r14, r17, r1, 0, r15, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0127, code lost:
        if (r15 == 0) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0129, code lost:
        java.lang.System.arraycopy(r6, r17 * r5, r3, r16 * r5, r15 * r5);
        r16 = r16 + r15;
        r17 = r17 + r15;
        r1 = r1 - r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0138, code lost:
        if (r1 > 1) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013d, code lost:
        r7 = r16 * r5;
        r8 = r2 * r5;
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0142, code lost:
        if (r9 >= r5) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0144, code lost:
        r3[r7 + r9] = r3[r8 + r9];
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014f, code lost:
        r16 = r16 + 1;
        r2 = r2 + 1;
        r18 = r18 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0155, code lost:
        if (r18 != 0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0158, code lost:
        r24 = r15;
        r7 = kshark.internal.aosp.ByteArrayTimSort.Companion.access$gallopLeft(Companion, r6, r17, r3, r2, r18, 0, r5, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016b, code lost:
        if (r7 == 0) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x016d, code lost:
        java.lang.System.arraycopy(r3, r2 * r5, r3, r16 * r5, r7 * r5);
        r16 = r16 + r7;
        r2 = r2 + r7;
        r18 = r18 - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017b, code lost:
        if (r18 != 0) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x017e, code lost:
        r15 = r16 * r5;
        r8 = r17 * r5;
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0183, code lost:
        if (r9 >= r5) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0185, code lost:
        r3[r15 + r9] = r6[r8 + r9];
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0190, code lost:
        r16 = r16 + 1;
        r17 = r17 + 1;
        r1 = r1 - 1;
        r8 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0197, code lost:
        if (r1 != 1) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0199, code lost:
        r12 = r26;
     */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0252 A[LOOP:3: B:27:0x0084->B:143:0x0252, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x00f4 A[EDGE_INSN: B:156:0x00f4->B:56:0x00f4 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m3007a(int r26, int r27, int r28, int r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            r2 = r28
            boolean r3 = f4683l
            java.lang.String r4 = "Assertion failed"
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0028
            if (r1 <= 0) goto L_0x0018
            if (r29 <= 0) goto L_0x0018
            int r3 = r26 + r1
            if (r3 != r2) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            boolean r7 = kotlin._Assertions.ENABLED
            if (r7 == 0) goto L_0x0028
            if (r3 == 0) goto L_0x0020
            goto L_0x0028
        L_0x0020:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0028:
            byte[] r3 = r0.f4689f
            int r15 = r0.f4691h
            byte[] r14 = r0.m3010b(r1)
            int r7 = r26 * r15
            int r8 = r1 * r15
            java.lang.System.arraycopy(r3, r7, r14, r5, r8)
            int r9 = r2 * r15
            r10 = 0
        L_0x003a:
            if (r10 >= r15) goto L_0x0047
            int r11 = r7 + r10
            int r12 = r9 + r10
            byte r12 = r3[r12]
            r3[r11] = r12
            int r10 = r10 + 1
            goto L_0x003a
        L_0x0047:
            int r7 = r26 + 1
            int r2 = r2 + r6
            int r9 = r29 + -1
            if (r9 != 0) goto L_0x0056
            int r1 = r15 * 0
            int r7 = r7 * r15
            java.lang.System.arraycopy(r14, r1, r3, r7, r8)
            return
        L_0x0056:
            if (r1 != r6) goto L_0x0074
            int r2 = r2 * r15
            int r1 = r7 * r15
            int r4 = r9 * r15
            java.lang.System.arraycopy(r3, r2, r3, r1, r4)
            int r7 = r7 + r9
            int r7 = r7 * r15
            int r1 = r15 * 0
        L_0x0066:
            if (r5 >= r15) goto L_0x0073
            int r2 = r7 + r5
            int r4 = r1 + r5
            byte r4 = r14[r4]
            r3[r2] = r4
            int r5 = r5 + 1
            goto L_0x0066
        L_0x0073:
            return
        L_0x0074:
            kshark.internal.aosp.ByteArrayComparator r13 = r0.f4690g
            int r8 = r0.f4684a
            r12 = r8
            r8 = 0
        L_0x007a:
            r16 = r7
            r17 = r8
            r18 = r9
            r19 = 0
            r20 = 0
        L_0x0084:
            boolean r7 = f4683l
            if (r7 == 0) goto L_0x009e
            if (r1 <= r6) goto L_0x008e
            if (r18 <= 0) goto L_0x008e
            r7 = 1
            goto L_0x008f
        L_0x008e:
            r7 = 0
        L_0x008f:
            boolean r8 = kotlin._Assertions.ENABLED
            if (r8 == 0) goto L_0x009e
            if (r7 == 0) goto L_0x0096
            goto L_0x009e
        L_0x0096:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x009e:
            r7 = r13
            r8 = r15
            r9 = r3
            r10 = r2
            r11 = r14
            r5 = r12
            r12 = r17
            int r7 = r7.compare(r8, r9, r10, r11, r12)
            if (r7 >= 0) goto L_0x00cc
            int r7 = r16 * r15
            int r8 = r2 * r15
            r9 = 0
        L_0x00b1:
            if (r9 >= r15) goto L_0x00be
            int r10 = r7 + r9
            int r11 = r8 + r9
            byte r11 = r3[r11]
            r3[r10] = r11
            int r9 = r9 + 1
            goto L_0x00b1
        L_0x00be:
            int r16 = r16 + 1
            int r2 = r2 + 1
            int r20 = r20 + 1
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x00c9
            goto L_0x00e8
        L_0x00c9:
            r19 = 0
            goto L_0x00f0
        L_0x00cc:
            int r7 = r16 * r15
            int r8 = r17 * r15
            r9 = 0
        L_0x00d1:
            if (r9 >= r15) goto L_0x00de
            int r10 = r7 + r9
            int r11 = r8 + r9
            byte r11 = r14[r11]
            r3[r10] = r11
            int r9 = r9 + 1
            goto L_0x00d1
        L_0x00de:
            int r16 = r16 + 1
            int r17 = r17 + 1
            int r19 = r19 + 1
            int r1 = r1 + -1
            if (r1 != r6) goto L_0x00ee
        L_0x00e8:
            r12 = r5
            r6 = r14
            r5 = r15
        L_0x00eb:
            r8 = 1
            goto L_0x019b
        L_0x00ee:
            r20 = 0
        L_0x00f0:
            r7 = r19 | r20
            if (r7 < r5) goto L_0x0252
        L_0x00f4:
            boolean r7 = f4683l
            if (r7 == 0) goto L_0x010e
            if (r1 <= r6) goto L_0x00fe
            if (r18 <= 0) goto L_0x00fe
            r7 = 1
            goto L_0x00ff
        L_0x00fe:
            r7 = 0
        L_0x00ff:
            boolean r8 = kotlin._Assertions.ENABLED
            if (r8 == 0) goto L_0x010e
            if (r7 == 0) goto L_0x0106
            goto L_0x010e
        L_0x0106:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x010e:
            kshark.internal.aosp.ByteArrayTimSort$Companion r7 = Companion
            r19 = 0
            r8 = r3
            r9 = r2
            r10 = r14
            r11 = r17
            r12 = r1
            r22 = r13
            r13 = r19
            r6 = r14
            r14 = r15
            r26 = r5
            r5 = r15
            r15 = r22
            int r15 = r7.gallopRight(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r15 == 0) goto L_0x013d
            int r7 = r17 * r5
            int r8 = r16 * r5
            int r9 = r15 * r5
            java.lang.System.arraycopy(r6, r7, r3, r8, r9)
            int r16 = r16 + r15
            int r17 = r17 + r15
            int r1 = r1 - r15
            r7 = 1
            if (r1 > r7) goto L_0x013d
        L_0x013a:
            r12 = r26
            goto L_0x00eb
        L_0x013d:
            int r7 = r16 * r5
            int r8 = r2 * r5
            r9 = 0
        L_0x0142:
            if (r9 >= r5) goto L_0x014f
            int r10 = r7 + r9
            int r11 = r8 + r9
            byte r11 = r3[r11]
            r3[r10] = r11
            int r9 = r9 + 1
            goto L_0x0142
        L_0x014f:
            int r16 = r16 + 1
            int r2 = r2 + 1
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x0158
        L_0x0157:
            goto L_0x013a
        L_0x0158:
            kshark.internal.aosp.ByteArrayTimSort$Companion r7 = Companion
            r13 = 0
            r8 = r6
            r9 = r17
            r10 = r3
            r11 = r2
            r12 = r18
            r14 = r5
            r24 = r15
            r15 = r22
            int r7 = r7.gallopLeft(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r7 == 0) goto L_0x017e
            int r15 = r2 * r5
            int r8 = r16 * r5
            int r9 = r7 * r5
            java.lang.System.arraycopy(r3, r15, r3, r8, r9)
            int r16 = r16 + r7
            int r2 = r2 + r7
            int r18 = r18 - r7
            if (r18 != 0) goto L_0x017e
            goto L_0x0157
        L_0x017e:
            int r15 = r16 * r5
            int r8 = r17 * r5
            r9 = 0
        L_0x0183:
            if (r9 >= r5) goto L_0x0190
            int r10 = r15 + r9
            int r11 = r8 + r9
            byte r11 = r6[r11]
            r3[r10] = r11
            int r9 = r9 + 1
            goto L_0x0183
        L_0x0190:
            int r16 = r16 + 1
            int r17 = r17 + 1
            int r1 = r1 + -1
            r8 = 1
            if (r1 != r8) goto L_0x0222
            r12 = r26
        L_0x019b:
            if (r12 >= r8) goto L_0x019e
            r12 = 1
        L_0x019e:
            r0.f4684a = r12
            if (r1 != r8) goto L_0x01d9
            boolean r1 = f4683l
            if (r1 == 0) goto L_0x01bc
            if (r18 <= 0) goto L_0x01ab
            r23 = 1
            goto L_0x01ad
        L_0x01ab:
            r23 = 0
        L_0x01ad:
            boolean r1 = kotlin._Assertions.ENABLED
            if (r1 == 0) goto L_0x01bc
            if (r23 == 0) goto L_0x01b4
            goto L_0x01bc
        L_0x01b4:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01bc:
            int r2 = r2 * r5
            int r15 = r16 * r5
            int r1 = r18 * r5
            java.lang.System.arraycopy(r3, r2, r3, r15, r1)
            int r16 = r16 + r18
            int r16 = r16 * r5
            int r17 = r17 * r5
            r1 = 0
        L_0x01cc:
            if (r1 >= r5) goto L_0x0217
            int r2 = r16 + r1
            int r4 = r17 + r1
            byte r4 = r6[r4]
            r3[r2] = r4
            int r1 = r1 + 1
            goto L_0x01cc
        L_0x01d9:
            if (r1 == 0) goto L_0x0218
            boolean r2 = f4683l
            if (r2 == 0) goto L_0x01f3
            if (r18 != 0) goto L_0x01e3
            r7 = 1
            goto L_0x01e4
        L_0x01e3:
            r7 = 0
        L_0x01e4:
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x01f3
            if (r7 == 0) goto L_0x01eb
            goto L_0x01f3
        L_0x01eb:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01f3:
            boolean r2 = f4683l
            if (r2 == 0) goto L_0x020e
            r8 = 1
            if (r1 <= r8) goto L_0x01fd
            r21 = 1
            goto L_0x01ff
        L_0x01fd:
            r21 = 0
        L_0x01ff:
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x020e
            if (r21 == 0) goto L_0x0206
            goto L_0x020e
        L_0x0206:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x020e:
            int r2 = r17 * r5
            int r4 = r16 * r5
            int r1 = r1 * r5
            java.lang.System.arraycopy(r6, r2, r3, r4, r1)
        L_0x0217:
            return
        L_0x0218:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Comparison method violates its general contract!"
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0222:
            int r9 = r26 + -1
            int r10 = f4681j
            r11 = r24
            if (r11 < r10) goto L_0x022c
            r10 = 1
            goto L_0x022d
        L_0x022c:
            r10 = 0
        L_0x022d:
            int r11 = f4681j
            if (r7 < r11) goto L_0x0233
            r7 = 1
            goto L_0x0234
        L_0x0233:
            r7 = 0
        L_0x0234:
            r7 = r7 | r10
            if (r7 != 0) goto L_0x024a
            if (r9 >= 0) goto L_0x023a
            r9 = 0
        L_0x023a:
            int r12 = r9 + 2
            r15 = r5
            r14 = r6
            r7 = r16
            r8 = r17
            r9 = r18
            r13 = r22
            r5 = 0
            r6 = 1
            goto L_0x007a
        L_0x024a:
            r15 = r5
            r14 = r6
            r5 = r9
            r13 = r22
            r6 = 1
            goto L_0x00f4
        L_0x0252:
            r8 = 1
            r12 = r5
            r5 = 0
            r6 = 1
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.aosp.ByteArrayTimSort.m3007a(int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0284, code lost:
        r22 = r22 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0288, code lost:
        if (r1 < f4681j) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x028a, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x028c, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x028f, code lost:
        if (r13 < f4681j) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0291, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0293, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0295, code lost:
        if ((r1 | r2) != false) goto L_0x02ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0297, code lost:
        if (r22 >= 0) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0299, code lost:
        r22 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02ae, code lost:
        r14 = r6;
        r15 = r8;
        r13 = r9;
        r9 = r23;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010c, code lost:
        r22 = r8;
        r19 = r18;
        r8 = r7;
        r18 = r17;
        r17 = r16;
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0119, code lost:
        if (f4683l == false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011b, code lost:
        if (r19 <= 0) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011d, code lost:
        if (r8 <= 1) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011f, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0124, code lost:
        if (kotlin._Assertions.ENABLED == false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0126, code lost:
        if (r1 == false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0130, code lost:
        throw new java.lang.AssertionError("Assertion failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0131, code lost:
        r20 = r8;
        r23 = r9;
        r1 = r19 - kshark.internal.aosp.ByteArrayTimSort.Companion.access$gallopRight(Companion, r14, r18, r15, r26, r19, r19 - 1, r13, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0148, code lost:
        if (r1 == 0) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014a, code lost:
        r2 = r16 - r1;
        r16 = r17 - r1;
        r3 = r19 - r1;
        java.lang.System.arraycopy(r15, (r16 + 1) * r13, r15, (r2 + 1) * r13, r1 * r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015d, code lost:
        if (r3 != 0) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015f, code lost:
        r1 = r2;
        r9 = r13;
        r6 = r14;
        r8 = r15;
        r17 = r18;
        r7 = r20;
        r2 = r22;
        r18 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x016d, code lost:
        r24 = r16;
        r16 = r2;
        r2 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0174, code lost:
        r2 = r17;
        r3 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0178, code lost:
        r4 = r16 * r13;
        r5 = r18 * r13;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017d, code lost:
        if (r6 >= r13) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017f, code lost:
        r15[r4 + r6] = r14[r5 + r6];
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018a, code lost:
        r4 = r16 - 1;
        r5 = r18 - 1;
        r7 = r20 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0190, code lost:
        if (r7 != 1) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0192, code lost:
        r16 = r2;
        r18 = r3;
        r1 = r4;
        r17 = r5;
        r9 = r13;
        r6 = r14;
        r8 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019c, code lost:
        r2 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a0, code lost:
        r9 = r13;
        r6 = r14;
        r8 = r15;
        r13 = r7 - kshark.internal.aosp.ByteArrayTimSort.Companion.access$gallopLeft(Companion, r15, r2, r6, 0, r7, r7 - 1, r9, r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ba, code lost:
        if (r13 == 0) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01bc, code lost:
        r4 = r4 - r13;
        r17 = r5 - r13;
        r7 = r7 - r13;
        java.lang.System.arraycopy(r6, (r17 + 1) * r9, r8, (r4 + 1) * r9, r13 * r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01cd, code lost:
        if (r7 > 1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01cf, code lost:
        r16 = r2;
        r18 = r3;
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d5, code lost:
        r18 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d8, code lost:
        r18 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01da, code lost:
        r5 = r4 * r9;
        r14 = r2 * r9;
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01df, code lost:
        if (r15 >= r9) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e1, code lost:
        r8[r5 + r15] = r8[r14 + r15];
        r15 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ec, code lost:
        r16 = r4 - 1;
        r17 = r2 - 1;
        r19 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f2, code lost:
        if (r19 != 0) goto L_0x0284;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f4, code lost:
        r1 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m3009b(int r26, int r27, int r28, int r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r28
            r2 = r29
            boolean r3 = f4683l
            java.lang.String r10 = "Assertion failed"
            r11 = 0
            r12 = 1
            if (r3 == 0) goto L_0x0028
            if (r27 <= 0) goto L_0x0018
            if (r2 <= 0) goto L_0x0018
            int r3 = r26 + r27
            if (r3 != r1) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            boolean r4 = kotlin._Assertions.ENABLED
            if (r4 == 0) goto L_0x0028
            if (r3 == 0) goto L_0x0020
            goto L_0x0028
        L_0x0020:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r10)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0028:
            byte[] r15 = r0.f4689f
            byte[] r14 = r0.m3010b(r2)
            int r13 = r0.f4691h
            int r3 = r1 * r13
            int r4 = r2 * r13
            java.lang.System.arraycopy(r15, r3, r14, r11, r4)
            int r3 = r26 + r27
            int r3 = r3 - r12
            int r5 = r2 + -1
            int r1 = r1 + r2
            int r1 = r1 - r12
            int r6 = r1 * r13
            int r7 = r3 * r13
            r8 = 0
        L_0x0043:
            if (r8 >= r13) goto L_0x0050
            int r9 = r6 + r8
            int r16 = r7 + r8
            byte r16 = r15[r16]
            r15[r9] = r16
            int r8 = r8 + 1
            goto L_0x0043
        L_0x0050:
            int r1 = r1 + -1
            int r3 = r3 + -1
            int r6 = r27 + -1
            if (r6 != 0) goto L_0x005f
            int r1 = r1 - r5
            int r1 = r1 * r13
            java.lang.System.arraycopy(r14, r11, r15, r1, r4)
            return
        L_0x005f:
            if (r2 != r12) goto L_0x0081
            int r1 = r1 - r6
            int r3 = r3 - r6
            int r3 = r3 + r12
            int r3 = r3 * r13
            int r2 = r1 + 1
            int r2 = r2 * r13
            int r6 = r6 * r13
            java.lang.System.arraycopy(r15, r3, r15, r2, r6)
            int r1 = r1 * r13
            int r5 = r5 * r13
        L_0x0073:
            if (r11 >= r13) goto L_0x0080
            int r2 = r1 + r11
            int r3 = r5 + r11
            byte r3 = r14[r3]
            r15[r2] = r3
            int r11 = r11 + 1
            goto L_0x0073
        L_0x0080:
            return
        L_0x0081:
            kshark.internal.aosp.ByteArrayComparator r9 = r0.f4690g
            int r4 = r0.f4684a
            r8 = r4
        L_0x0086:
            r7 = r2
            r16 = r3
            r17 = r5
            r18 = r6
            r19 = 0
            r20 = 0
        L_0x0091:
            boolean r2 = f4683l
            if (r2 == 0) goto L_0x00ab
            if (r18 <= 0) goto L_0x009b
            if (r7 <= r12) goto L_0x009b
            r2 = 1
            goto L_0x009c
        L_0x009b:
            r2 = 0
        L_0x009c:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x00ab
            if (r2 == 0) goto L_0x00a3
            goto L_0x00ab
        L_0x00a3:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r10)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00ab:
            r2 = r9
            r3 = r13
            r4 = r14
            r5 = r17
            r6 = r15
            r21 = r7
            r7 = r16
            int r2 = r2.compare(r3, r4, r5, r6, r7)
            if (r2 >= 0) goto L_0x00e4
            int r2 = r1 * r13
            int r3 = r16 * r13
            r4 = 0
        L_0x00c0:
            if (r4 >= r13) goto L_0x00cd
            int r5 = r2 + r4
            int r6 = r3 + r4
            byte r6 = r15[r6]
            r15[r5] = r6
            int r4 = r4 + 1
            goto L_0x00c0
        L_0x00cd:
            int r1 = r1 + -1
            int r16 = r16 + -1
            int r19 = r19 + 1
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x00df
            r2 = r8
            r9 = r13
            r6 = r14
            r8 = r15
            r7 = r21
            goto L_0x01fd
        L_0x00df:
            r7 = r21
            r20 = 0
            goto L_0x0108
        L_0x00e4:
            int r2 = r1 * r13
            int r3 = r17 * r13
            r4 = 0
        L_0x00e9:
            if (r4 >= r13) goto L_0x00f6
            int r5 = r2 + r4
            int r6 = r3 + r4
            byte r6 = r14[r6]
            r15[r5] = r6
            int r4 = r4 + 1
            goto L_0x00e9
        L_0x00f6:
            int r1 = r1 + -1
            int r17 = r17 + -1
            int r20 = r20 + 1
            int r7 = r21 + -1
            if (r7 != r12) goto L_0x0106
            r2 = r8
            r9 = r13
            r6 = r14
            r8 = r15
            goto L_0x01fd
        L_0x0106:
            r19 = 0
        L_0x0108:
            r2 = r19 | r20
            if (r2 < r8) goto L_0x0091
            r22 = r8
            r19 = r18
            r8 = r7
            r18 = r17
            r17 = r16
            r16 = r1
        L_0x0117:
            boolean r1 = f4683l
            if (r1 == 0) goto L_0x0131
            if (r19 <= 0) goto L_0x0121
            if (r8 <= r12) goto L_0x0121
            r1 = 1
            goto L_0x0122
        L_0x0121:
            r1 = 0
        L_0x0122:
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x0131
            if (r1 == 0) goto L_0x0129
            goto L_0x0131
        L_0x0129:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r10)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0131:
            kshark.internal.aosp.ByteArrayTimSort$Companion r1 = Companion
            int r7 = r19 + -1
            r2 = r14
            r3 = r18
            r4 = r15
            r5 = r26
            r6 = r19
            r20 = r8
            r8 = r13
            r23 = r9
            int r1 = r1.gallopRight(r2, r3, r4, r5, r6, r7, r8, r9)
            int r1 = r19 - r1
            if (r1 == 0) goto L_0x0174
            int r2 = r16 - r1
            int r16 = r17 - r1
            int r3 = r19 - r1
            int r4 = r16 + 1
            int r4 = r4 * r13
            int r5 = r2 + 1
            int r5 = r5 * r13
            int r6 = r1 * r13
            java.lang.System.arraycopy(r15, r4, r15, r5, r6)
            if (r3 != 0) goto L_0x016d
            r1 = r2
            r9 = r13
            r6 = r14
            r8 = r15
            r17 = r18
            r7 = r20
            r2 = r22
            r18 = r3
            goto L_0x01fd
        L_0x016d:
            r24 = r16
            r16 = r2
            r2 = r24
            goto L_0x0178
        L_0x0174:
            r2 = r17
            r3 = r19
        L_0x0178:
            int r4 = r16 * r13
            int r5 = r18 * r13
            r6 = 0
        L_0x017d:
            if (r6 >= r13) goto L_0x018a
            int r7 = r4 + r6
            int r8 = r5 + r6
            byte r8 = r14[r8]
            r15[r7] = r8
            int r6 = r6 + 1
            goto L_0x017d
        L_0x018a:
            int r4 = r16 + -1
            int r5 = r18 + -1
            int r7 = r20 + -1
            if (r7 != r12) goto L_0x01a0
            r16 = r2
            r18 = r3
            r1 = r4
            r17 = r5
            r9 = r13
            r6 = r14
            r8 = r15
        L_0x019c:
            r2 = r22
            goto L_0x01fd
        L_0x01a0:
            kshark.internal.aosp.ByteArrayTimSort$Companion r6 = Companion
            r17 = 0
            int r19 = r7 + -1
            r9 = r13
            r13 = r6
            r6 = r14
            r14 = r15
            r8 = r15
            r15 = r2
            r16 = r6
            r18 = r7
            r20 = r9
            r21 = r23
            int r13 = r13.gallopLeft(r14, r15, r16, r17, r18, r19, r20, r21)
            int r13 = r7 - r13
            if (r13 == 0) goto L_0x01d8
            int r4 = r4 - r13
            int r17 = r5 - r13
            int r7 = r7 - r13
            int r5 = r17 + 1
            int r5 = r5 * r9
            int r14 = r4 + 1
            int r14 = r14 * r9
            int r15 = r13 * r9
            java.lang.System.arraycopy(r6, r5, r8, r14, r15)
            if (r7 > r12) goto L_0x01d5
            r16 = r2
            r18 = r3
            r1 = r4
            goto L_0x019c
        L_0x01d5:
            r18 = r17
            goto L_0x01da
        L_0x01d8:
            r18 = r5
        L_0x01da:
            int r5 = r4 * r9
            int r14 = r2 * r9
            r15 = 0
        L_0x01df:
            if (r15 >= r9) goto L_0x01ec
            int r16 = r5 + r15
            int r17 = r14 + r15
            byte r17 = r8[r17]
            r8[r16] = r17
            int r15 = r15 + 1
            goto L_0x01df
        L_0x01ec:
            int r16 = r4 + -1
            int r17 = r2 + -1
            int r19 = r3 + -1
            if (r19 != 0) goto L_0x0284
            r1 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            goto L_0x019c
        L_0x01fd:
            if (r2 >= r12) goto L_0x0200
            r2 = 1
        L_0x0200:
            r0.f4684a = r2
            if (r7 != r12) goto L_0x023e
            boolean r2 = f4683l
            if (r2 == 0) goto L_0x021c
            if (r18 <= 0) goto L_0x020c
            r2 = 1
            goto L_0x020d
        L_0x020c:
            r2 = 0
        L_0x020d:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x021c
            if (r2 == 0) goto L_0x0214
            goto L_0x021c
        L_0x0214:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r10)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x021c:
            int r1 = r1 - r18
            int r16 = r16 - r18
            int r16 = r16 + 1
            int r2 = r16 * r9
            int r3 = r1 + 1
            int r3 = r3 * r9
            int r4 = r18 * r9
            java.lang.System.arraycopy(r8, r2, r8, r3, r4)
            int r1 = r1 * r9
            int r17 = r17 * r9
        L_0x0231:
            if (r11 >= r9) goto L_0x0279
            int r2 = r1 + r11
            int r3 = r17 + r11
            byte r3 = r6[r3]
            r8[r2] = r3
            int r11 = r11 + 1
            goto L_0x0231
        L_0x023e:
            if (r7 == 0) goto L_0x027a
            boolean r2 = f4683l
            if (r2 == 0) goto L_0x0258
            if (r18 != 0) goto L_0x0248
            r2 = 1
            goto L_0x0249
        L_0x0248:
            r2 = 0
        L_0x0249:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x0258
            if (r2 == 0) goto L_0x0250
            goto L_0x0258
        L_0x0250:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r10)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0258:
            boolean r2 = f4683l
            if (r2 == 0) goto L_0x026f
            if (r7 <= 0) goto L_0x025f
            goto L_0x0260
        L_0x025f:
            r12 = 0
        L_0x0260:
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x026f
            if (r12 == 0) goto L_0x0267
            goto L_0x026f
        L_0x0267:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r10)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x026f:
            int r2 = r7 + -1
            int r1 = r1 - r2
            int r1 = r1 * r9
            int r7 = r7 * r9
            java.lang.System.arraycopy(r6, r11, r8, r1, r7)
        L_0x0279:
            return
        L_0x027a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Comparison method violates its general contract!"
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0284:
            int r22 = r22 + -1
            int r2 = f4681j
            if (r1 < r2) goto L_0x028c
            r1 = 1
            goto L_0x028d
        L_0x028c:
            r1 = 0
        L_0x028d:
            int r2 = f4681j
            if (r13 < r2) goto L_0x0293
            r2 = 1
            goto L_0x0294
        L_0x0293:
            r2 = 0
        L_0x0294:
            r1 = r1 | r2
            if (r1 != 0) goto L_0x02ae
            if (r22 >= 0) goto L_0x029b
            r22 = 0
        L_0x029b:
            int r1 = r22 + 2
            r14 = r6
            r2 = r7
            r15 = r8
            r13 = r9
            r3 = r17
            r5 = r18
            r6 = r19
            r9 = r23
            r8 = r1
            r1 = r16
            goto L_0x0086
        L_0x02ae:
            r14 = r6
            r15 = r8
            r13 = r9
            r9 = r23
            r8 = r7
            goto L_0x0117
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.aosp.ByteArrayTimSort.m3009b(int, int, int, int):void");
    }

    /* renamed from: b */
    private final byte[] m3010b(int i) {
        byte[] bArr = this.f4685b;
        if (bArr == null) {
            Intrinsics.throwNpe();
        }
        int length = bArr.length;
        int i2 = this.f4691h;
        if (length < i * i2) {
            int i3 = (i >> 1) | i;
            int i4 = i3 | (i3 >> 2);
            int i5 = i4 | (i4 >> 4);
            int i6 = i5 | (i5 >> 8);
            int i7 = (i6 | (i6 >> 16)) + 1;
            if (i7 >= 0) {
                i = Math.min(i7, (this.f4689f.length / i2) >>> 1);
            }
            this.f4685b = new byte[(i * this.f4691h)];
        }
        byte[] bArr2 = this.f4685b;
        if (bArr2 == null) {
            Intrinsics.throwNpe();
        }
        return bArr2;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JH\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JH\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J.\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lkshark/internal/aosp/ByteArrayTimSort$Companion;", "", "()V", "DEBUG", "", "INITIAL_TMP_STORAGE_LENGTH", "", "MIN_GALLOP", "MIN_MERGE", "binarySort", "", "a", "", "lo", "hi", "start", "entrySize", "c", "Lkshark/internal/aosp/ByteArrayComparator;", "checkStartAndEnd", "len", "end", "countRunAndMakeAscending", "gallopLeft", "keyArray", "keyIndex", "base", "hint", "gallopRight", "minRunLength", "n", "reverseRange", "sort", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ByteArrayTimSort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void sort(byte[] bArr, int i, ByteArrayComparator byteArrayComparator) {
            Intrinsics.checkParameterIsNotNull(bArr, Constants.FILE_ANR_KEY);
            Intrinsics.checkParameterIsNotNull(byteArrayComparator, "c");
            sort(bArr, 0, bArr.length / i, i, byteArrayComparator);
        }

        public final void sort(byte[] bArr, int i, int i2, int i3, ByteArrayComparator byteArrayComparator) {
            byte[] bArr2 = bArr;
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            ByteArrayComparator byteArrayComparator2 = byteArrayComparator;
            Intrinsics.checkParameterIsNotNull(bArr2, Constants.FILE_ANR_KEY);
            Intrinsics.checkParameterIsNotNull(byteArrayComparator2, "c");
            Companion companion = this;
            companion.checkStartAndEnd(bArr2.length / i6, i4, i5);
            int i7 = i5 - i4;
            if (i7 >= 2) {
                if (i7 < ByteArrayTimSort.f4680i) {
                    byte[] bArr3 = bArr;
                    int i8 = i;
                    int i9 = i2;
                    companion.binarySort(bArr3, i8, i9, i4 + companion.countRunAndMakeAscending(bArr3, i8, i9, i3, byteArrayComparator), i3, byteArrayComparator);
                    return;
                }
                ByteArrayTimSort byteArrayTimSort = new ByteArrayTimSort(bArr2, byteArrayComparator2, i6, (DefaultConstructorMarker) null);
                int minRunLength = companion.minRunLength(i7);
                int i10 = i7;
                int i11 = i4;
                do {
                    int countRunAndMakeAscending = companion.countRunAndMakeAscending(bArr, i11, i2, i3, byteArrayComparator);
                    if (countRunAndMakeAscending < minRunLength) {
                        int i12 = i10 <= minRunLength ? i10 : minRunLength;
                        companion.binarySort(bArr, i11, i11 + i12, i11 + countRunAndMakeAscending, i3, byteArrayComparator);
                        countRunAndMakeAscending = i12;
                    }
                    byteArrayTimSort.m3006a(i11, countRunAndMakeAscending);
                    byteArrayTimSort.m3004a();
                    i11 += countRunAndMakeAscending;
                    i10 -= countRunAndMakeAscending;
                } while (i10 != 0);
                boolean z = false;
                if (ByteArrayTimSort.f4683l) {
                    boolean z2 = i11 == i5;
                    if (_Assertions.ENABLED && !z2) {
                        throw new AssertionError("Assertion failed");
                    }
                }
                byteArrayTimSort.m3008b();
                if (ByteArrayTimSort.f4683l) {
                    if (byteArrayTimSort.f4686c == 1) {
                        z = true;
                    }
                    if (_Assertions.ENABLED && !z) {
                        throw new AssertionError("Assertion failed");
                    }
                }
            }
        }

        private final void checkStartAndEnd(int i, int i2, int i3) {
            if (i2 < 0 || i3 > i) {
                throw new ArrayIndexOutOfBoundsException("start < 0 || end > len. start=" + i2 + ", end=" + i3 + ", len=" + i);
            } else if (i2 > i3) {
                throw new IllegalArgumentException("start > end: " + i2 + " > " + i3);
            }
        }

        private final void binarySort(byte[] bArr, int i, int i2, int i3, int i4, ByteArrayComparator byteArrayComparator) {
            byte[] bArr2 = bArr;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            if (ByteArrayTimSort.f4683l) {
                boolean z = i5 <= i7 && i7 <= i6;
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Assertion failed");
                }
            }
            if (i7 == i5) {
                i7++;
            }
            byte[] bArr3 = new byte[i8];
            int i9 = i7;
            while (i9 < i6) {
                int i10 = i9 * i8;
                for (int i11 = 0; i11 < i8; i11++) {
                    bArr3[i11] = bArr2[i10 + i11];
                }
                if (ByteArrayTimSort.f4683l) {
                    boolean z2 = i5 <= i9;
                    if (_Assertions.ENABLED && !z2) {
                        throw new AssertionError("Assertion failed");
                    }
                }
                int i12 = i5;
                int i13 = i9;
                while (i12 < i13) {
                    int i14 = (i12 + i13) >>> 1;
                    int i15 = i13;
                    if (byteArrayComparator.compare(i4, bArr3, 0, bArr, i14) < 0) {
                        i13 = i14;
                    } else {
                        i12 = i14 + 1;
                        i13 = i15;
                    }
                }
                int i16 = i13;
                if (ByteArrayTimSort.f4683l) {
                    boolean z3 = i12 == i16;
                    if (_Assertions.ENABLED && !z3) {
                        throw new AssertionError("Assertion failed");
                    }
                }
                int i17 = i9 - i12;
                if (i17 == 1) {
                    int i18 = i12 * i8;
                    int i19 = (i12 + 1) * i8;
                    for (int i20 = 0; i20 < i8; i20++) {
                        bArr2[i19 + i20] = bArr2[i18 + i20];
                    }
                } else if (i17 != 2) {
                    System.arraycopy(bArr2, i12 * i8, bArr2, (i12 + 1) * i8, i17 * i8);
                } else {
                    int i21 = i12 * i8;
                    int i22 = (i12 + 1) * i8;
                    int i23 = (i12 + 2) * i8;
                    for (int i24 = 0; i24 < i8; i24++) {
                        bArr2[i23 + i24] = bArr2[i22 + i24];
                    }
                    for (int i25 = 0; i25 < i8; i25++) {
                        bArr2[i22 + i25] = bArr2[i21 + i25];
                    }
                }
                int i26 = i12 * i8;
                for (int i27 = 0; i27 < i8; i27++) {
                    bArr2[i26 + i27] = bArr3[i27];
                }
                i9++;
            }
        }

        private final int countRunAndMakeAscending(byte[] bArr, int i, int i2, int i3, ByteArrayComparator byteArrayComparator) {
            if (ByteArrayTimSort.f4683l) {
                boolean z = i < i2;
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Assertion failed");
                }
            }
            int i4 = i + 1;
            if (i4 == i2) {
                return 1;
            }
            int compare = byteArrayComparator.compare(i3, bArr, i4, bArr, i);
            int i5 = i4 + 1;
            if (compare >= 0) {
                while (i5 < i2) {
                    if (byteArrayComparator.compare(i3, bArr, i5, bArr, i5 - 1) < 0) {
                        break;
                    }
                    i5++;
                }
            } else {
                while (i5 < i2) {
                    if (byteArrayComparator.compare(i3, bArr, i5, bArr, i5 - 1) >= 0) {
                        break;
                    }
                    i5++;
                }
                reverseRange(bArr, i, i5, i3);
            }
            return i5 - i;
        }

        private final void reverseRange(byte[] bArr, int i, int i2, int i3) {
            while (true) {
                i2--;
                if (i < i2) {
                    int i4 = i * i3;
                    int i5 = i2 * i3;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = i4 + i6;
                        byte b = bArr[i7];
                        int i8 = i5 + i6;
                        bArr[i7] = bArr[i8];
                        bArr[i8] = b;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        private final int minRunLength(int i) {
            int i2 = 0;
            if (ByteArrayTimSort.f4683l) {
                boolean z = i >= 0;
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Assertion failed");
                }
            }
            while (i >= ByteArrayTimSort.f4680i) {
                i2 |= i & 1;
                i >>= 1;
            }
            return i + i2;
        }

        /* access modifiers changed from: private */
        public final int gallopLeft(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, ByteArrayComparator byteArrayComparator) {
            int i6;
            int i7;
            int i8 = i3;
            int i9 = i4;
            boolean z = false;
            if (ByteArrayTimSort.f4683l) {
                boolean z2 = i8 > 0 && i9 >= 0 && i9 < i8;
                if (_Assertions.ENABLED && !z2) {
                    throw new AssertionError("Assertion failed");
                }
            }
            int i10 = i2 + i9;
            if (byteArrayComparator.compare(i5, bArr, i, bArr2, i10) > 0) {
                int i11 = i8 - i9;
                int i12 = 1;
                int i13 = 0;
                while (i12 < i11) {
                    if (byteArrayComparator.compare(i5, bArr, i, bArr2, i10 + i12) <= 0) {
                        break;
                    }
                    int i14 = (i12 * 2) + 1;
                    if (i14 <= 0) {
                        i14 = i11;
                    }
                    int i15 = i14;
                    i13 = i12;
                    i12 = i15;
                }
                if (i12 <= i11) {
                    i11 = i12;
                }
                i6 = i13 + i9;
                i7 = i11 + i9;
            } else {
                int i16 = i9 + 1;
                int i17 = 1;
                int i18 = 0;
                while (i17 < i16) {
                    if (byteArrayComparator.compare(i5, bArr, i, bArr2, i10 - i17) > 0) {
                        break;
                    }
                    int i19 = (i17 * 2) + 1;
                    if (i19 <= 0) {
                        i19 = i16;
                    }
                    int i20 = i19;
                    i18 = i17;
                    i17 = i20;
                }
                if (i17 <= i16) {
                    i16 = i17;
                }
                int i21 = i9 - i16;
                i7 = i9 - i18;
                i6 = i21;
            }
            if (ByteArrayTimSort.f4683l) {
                boolean z3 = -1 <= i6 && i6 < i7 && i7 <= i8;
                if (_Assertions.ENABLED && !z3) {
                    throw new AssertionError("Assertion failed");
                }
            }
            int i22 = i6 + 1;
            while (i22 < i7) {
                int i23 = ((i7 - i22) >>> 1) + i22;
                if (byteArrayComparator.compare(i5, bArr, i, bArr2, i2 + i23) > 0) {
                    i22 = i23 + 1;
                } else {
                    i7 = i23;
                }
            }
            if (ByteArrayTimSort.f4683l) {
                if (i22 == i7) {
                    z = true;
                }
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Assertion failed");
                }
            }
            return i7;
        }

        /* access modifiers changed from: private */
        public final int gallopRight(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, ByteArrayComparator byteArrayComparator) {
            int i6;
            int i7;
            int i8 = i3;
            int i9 = i4;
            boolean z = false;
            if (ByteArrayTimSort.f4683l) {
                boolean z2 = i8 > 0 && i9 >= 0 && i9 < i8;
                if (_Assertions.ENABLED && !z2) {
                    throw new AssertionError("Assertion failed");
                }
            }
            int i10 = i2 + i9;
            if (byteArrayComparator.compare(i5, bArr, i, bArr2, i10) < 0) {
                int i11 = i9 + 1;
                int i12 = 1;
                int i13 = 0;
                while (i12 < i11) {
                    if (byteArrayComparator.compare(i5, bArr, i, bArr2, i10 - i12) >= 0) {
                        break;
                    }
                    int i14 = (i12 * 2) + 1;
                    if (i14 <= 0) {
                        i14 = i11;
                    }
                    int i15 = i14;
                    i13 = i12;
                    i12 = i15;
                }
                if (i12 <= i11) {
                    i11 = i12;
                }
                i6 = i9 - i11;
                i7 = i9 - i13;
            } else {
                int i16 = i8 - i9;
                int i17 = 1;
                int i18 = 0;
                while (i17 < i16) {
                    if (byteArrayComparator.compare(i5, bArr, i, bArr2, i10 + i17) < 0) {
                        break;
                    }
                    int i19 = (i17 * 2) + 1;
                    if (i19 <= 0) {
                        i19 = i16;
                    }
                    int i20 = i19;
                    i18 = i17;
                    i17 = i20;
                }
                if (i17 <= i16) {
                    i16 = i17;
                }
                i6 = i18 + i9;
                i7 = i9 + i16;
            }
            if (ByteArrayTimSort.f4683l) {
                boolean z3 = -1 <= i6 && i6 < i7 && i7 <= i8;
                if (_Assertions.ENABLED && !z3) {
                    throw new AssertionError("Assertion failed");
                }
            }
            int i21 = i6 + 1;
            while (i21 < i7) {
                int i22 = ((i7 - i21) >>> 1) + i21;
                if (byteArrayComparator.compare(i5, bArr, i, bArr2, i2 + i22) < 0) {
                    i7 = i22;
                } else {
                    i21 = i22 + 1;
                }
            }
            if (ByteArrayTimSort.f4683l) {
                if (i21 == i7) {
                    z = true;
                }
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Assertion failed");
                }
            }
            return i7;
        }
    }
}
