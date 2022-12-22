package com.didi.dqr.oned.rss.expanded;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Result;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitArray;
import com.didi.dqr.common.detector.MathUtils;
import com.didi.dqr.oned.OneDReader;
import com.didi.dqr.oned.rss.AbstractRSSReader;
import com.didi.dqr.oned.rss.DataCharacter;
import com.didi.dqr.oned.rss.FinderPattern;
import com.didi.dqr.oned.rss.RSSUtils;
import com.didi.dqr.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {

    /* renamed from: a */
    private static final int[] f18802a = {7, 5, 4, 3, 1};

    /* renamed from: b */
    private static final int[] f18803b = {4, 20, 52, 104, 204};

    /* renamed from: c */
    private static final int[] f18804c = {0, 348, 1388, 2948, 3988};

    /* renamed from: d */
    private static final int[][] f18805d = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: e */
    private static final int[][] f18806e = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: f */
    private static final int f18807f = 0;

    /* renamed from: g */
    private static final int f18808g = 1;

    /* renamed from: h */
    private static final int f18809h = 2;

    /* renamed from: i */
    private static final int f18810i = 3;

    /* renamed from: j */
    private static final int f18811j = 4;

    /* renamed from: k */
    private static final int f18812k = 5;

    /* renamed from: l */
    private static final int[][] f18813l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: m */
    private static final int f18814m = 11;

    /* renamed from: n */
    private final List<C7856b> f18815n = new ArrayList(11);

    /* renamed from: o */
    private final List<C7857c> f18816o = new ArrayList();

    /* renamed from: p */
    private final int[] f18817p = new int[2];

    /* renamed from: q */
    private boolean f18818q;

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f18815n.clear();
        this.f18818q = false;
        try {
            return m13952a(mo58403a(i, bitArray));
        } catch (NotFoundException unused) {
            this.f18815n.clear();
            this.f18818q = true;
            return m13952a(mo58403a(i, bitArray));
        }
    }

    public void reset() {
        this.f18815n.clear();
        this.f18816o.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C7856b> mo58403a(int i, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.f18815n.add(mo58401a(bitArray, this.f18815n, i));
            } catch (NotFoundException e) {
                if (this.f18815n.isEmpty()) {
                    throw e;
                } else if (m13963b()) {
                    return this.f18815n;
                } else {
                    boolean z = !this.f18816o.isEmpty();
                    m13957a(i, false);
                    if (z) {
                        List<C7856b> a = m13955a(false);
                        if (a != null) {
                            return a;
                        }
                        List<C7856b> a2 = m13955a(true);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    /* renamed from: a */
    private List<C7856b> m13955a(boolean z) {
        List<C7856b> list = null;
        if (this.f18816o.size() > 25) {
            this.f18816o.clear();
            return null;
        }
        this.f18815n.clear();
        if (z) {
            Collections.reverse(this.f18816o);
        }
        try {
            list = m13954a((List<C7857c>) new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.f18816o);
        }
        return list;
    }

    /* renamed from: a */
    private List<C7856b> m13954a(List<C7857c> list, int i) throws NotFoundException {
        while (i < this.f18816o.size()) {
            C7857c cVar = this.f18816o.get(i);
            this.f18815n.clear();
            for (C7857c a : list) {
                this.f18815n.addAll(a.mo58412a());
            }
            this.f18815n.addAll(cVar.mo58412a());
            if (m13964b(this.f18815n)) {
                if (m13963b()) {
                    return this.f18815n;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return m13954a((List<C7857c>) arrayList, i + 1);
                } catch (NotFoundException unused) {
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: b */
    private static boolean m13964b(List<C7856b> list) {
        boolean z;
        for (int[] iArr : f18813l) {
            if (list.size() <= iArr.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i).mo58407d().getValue() != iArr[i]) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m13957a(int i, boolean z) {
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= this.f18816o.size()) {
                break;
            }
            C7857c cVar = this.f18816o.get(i2);
            if (cVar.mo58414b() > i) {
                z2 = cVar.mo58413a(this.f18815n);
                break;
            } else {
                z3 = cVar.mo58413a(this.f18815n);
                i2++;
            }
        }
        if (!z2 && !z3 && !m13961a((Iterable<C7856b>) this.f18815n, (Iterable<C7857c>) this.f18816o)) {
            this.f18816o.add(i2, new C7857c(this.f18815n, i, z));
            m13958a(this.f18815n, this.f18816o);
        }
    }

    /* renamed from: a */
    private static void m13958a(List<C7856b> list, List<C7857c> list2) {
        boolean z;
        Iterator<C7857c> it = list2.iterator();
        while (it.hasNext()) {
            C7857c next = it.next();
            if (next.mo58412a().size() != list.size()) {
                Iterator<C7856b> it2 = next.mo58412a().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    C7856b next2 = it2.next();
                    Iterator<C7856b> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m13961a(Iterable<C7856b> iterable, Iterable<C7857c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<C7857c> it = iterable2.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                C7857c next = it.next();
                Iterator<C7856b> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    C7856b next2 = it2.next();
                    Iterator<C7856b> it3 = next.mo58412a().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z2 = true;
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C7857c> mo58402a() {
        return this.f18816o;
    }

    /* renamed from: a */
    static Result m13952a(List<C7856b> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(C7855a.m13969a(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).mo58407d().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).mo58407d().getResultPoints();
        return new Result(parseInformation, (byte[]) null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    /* renamed from: b */
    private boolean m13963b() {
        C7856b bVar = this.f18815n.get(0);
        DataCharacter b = bVar.mo58405b();
        DataCharacter c = bVar.mo58406c();
        if (c == null) {
            return false;
        }
        int checksumPortion = c.getChecksumPortion();
        int i = 2;
        for (int i2 = 1; i2 < this.f18815n.size(); i2++) {
            C7856b bVar2 = this.f18815n.get(i2);
            checksumPortion += bVar2.mo58405b().getChecksumPortion();
            i++;
            DataCharacter c2 = bVar2.mo58406c();
            if (c2 != null) {
                checksumPortion += c2.getChecksumPortion();
                i++;
            }
        }
        if (((i - 4) * 211) + (checksumPortion % 211) == b.getValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m13951a(BitArray bitArray, int i) {
        if (bitArray.get(i)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7856b mo58401a(BitArray bitArray, List<C7856b> list, int i) throws NotFoundException {
        FinderPattern a;
        DataCharacter dataCharacter;
        boolean z = list.size() % 2 == 0;
        if (this.f18818q) {
            z = !z;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            m13962b(bitArray, list, i2);
            a = m13953a(bitArray, i, z);
            if (a == null) {
                i2 = m13951a(bitArray, this.f18817p[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        DataCharacter a2 = mo58400a(bitArray, a, z, true);
        if (list.isEmpty() || !list.get(list.size() - 1).mo58408e()) {
            try {
                dataCharacter = mo58400a(bitArray, a, z, false);
            } catch (NotFoundException unused) {
                dataCharacter = null;
            }
            return new C7856b(a2, dataCharacter, a, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: b */
    private void m13962b(BitArray bitArray, List<C7856b> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = list.get(list.size() - 1).mo58407d().getStartEnd()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.f18818q) {
            z = !z;
        }
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (!z2) {
                break;
            }
            i++;
        }
        boolean z3 = z2;
        int i2 = 0;
        int i3 = i;
        while (i < size) {
            if (bitArray.get(i) != z3) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        m13959a(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.f18817p;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        m13959a(decodeFinderCounters);
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                decodeFinderCounters[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static void m13959a(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    /* renamed from: a */
    private FinderPattern m13953a(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.f18817p[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.f18817p;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.f18817p;
            int i7 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = nextUnset;
            i3 = i7;
            i4 = nextUnset - this.f18817p[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i4;
        try {
            return new FinderPattern(parseFinderValue(decodeFinderCounters, f18805d), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public DataCharacter mo58400a(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        BitArray bitArray2 = bitArray;
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i = 0; i < dataCharacterCounters.length; i++) {
            dataCharacterCounters[i] = 0;
        }
        if (z2) {
            OneDReader.recordPatternInReverse(bitArray2, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray2, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / ((float) 17);
        float f = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(sum - f) / f <= 0.3f) {
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
                float f2 = (((float) dataCharacterCounters[i4]) * 1.0f) / sum;
                int i5 = (int) (0.5f + f2);
                if (i5 < 1) {
                    if (f2 >= 0.3f) {
                        i5 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i5 > 8) {
                    if (f2 <= 8.7f) {
                        i5 = 8;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i6 = i4 / 2;
                if ((i4 & 1) == 0) {
                    oddCounts[i6] = i5;
                    oddRoundingErrors[i6] = f2 - ((float) i5);
                } else {
                    evenCounts[i6] = i5;
                    evenRoundingErrors[i6] = f2 - ((float) i5);
                }
            }
            m13956a(17);
            int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (z2 ^ true ? 1 : 0)) - 1;
            int i7 = 0;
            int i8 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                if (m13960a(finderPattern, z, z2)) {
                    i7 += oddCounts[length2] * f18806e[value][length2 * 2];
                }
                i8 += oddCounts[length2];
            }
            int i9 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                if (m13960a(finderPattern, z, z2)) {
                    i9 += evenCounts[length3] * f18806e[value][(length3 * 2) + 1];
                }
            }
            int i10 = i7 + i9;
            if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i11 = (13 - i8) / 2;
            int i12 = f18802a[i11];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i12, true) * f18803b[i11]) + RSSUtils.getRSSvalue(evenCounts, 9 - i12, false) + f18804c[i11], i10);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static boolean m13960a(FinderPattern finderPattern, boolean z, boolean z2) {
        return finderPattern.getValue() != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13956a(int r11) throws com.didi.dqr.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.getOddCounts()
            int r0 = com.didi.dqr.common.detector.MathUtils.sum(r0)
            int[] r1 = r10.getEvenCounts()
            int r1 = com.didi.dqr.common.detector.MathUtils.sum(r1)
            r2 = 4
            r3 = 13
            r4 = 0
            r5 = 1
            if (r0 <= r3) goto L_0x001a
            r6 = 0
            r7 = 1
            goto L_0x0020
        L_0x001a:
            if (r0 >= r2) goto L_0x001e
            r6 = 1
            goto L_0x001f
        L_0x001e:
            r6 = 0
        L_0x001f:
            r7 = 0
        L_0x0020:
            if (r1 <= r3) goto L_0x0025
            r2 = 0
            r3 = 1
            goto L_0x002b
        L_0x0025:
            if (r1 >= r2) goto L_0x0029
            r2 = 1
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            r3 = 0
        L_0x002b:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r5) goto L_0x0034
            r11 = 1
            goto L_0x0035
        L_0x0034:
            r11 = 0
        L_0x0035:
            r9 = r1 & 1
            if (r9 != 0) goto L_0x003a
            r4 = 1
        L_0x003a:
            if (r8 != r5) goto L_0x0052
            if (r11 == 0) goto L_0x0048
            if (r4 != 0) goto L_0x0043
            r5 = r6
        L_0x0041:
            r7 = 1
            goto L_0x007d
        L_0x0043:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0048:
            if (r4 == 0) goto L_0x004d
            r5 = r6
        L_0x004b:
            r3 = 1
            goto L_0x007d
        L_0x004d:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0052:
            r9 = -1
            if (r8 != r9) goto L_0x0069
            if (r11 == 0) goto L_0x005f
            if (r4 != 0) goto L_0x005a
            goto L_0x007d
        L_0x005a:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r5 = r6
            r2 = 1
            goto L_0x007d
        L_0x0064:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0069:
            if (r8 != 0) goto L_0x00c7
            if (r11 == 0) goto L_0x007a
            if (r4 == 0) goto L_0x0075
            if (r0 >= r1) goto L_0x0072
            goto L_0x004b
        L_0x0072:
            r5 = r6
            r2 = 1
            goto L_0x0041
        L_0x0075:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x007a:
            if (r4 != 0) goto L_0x00c2
            r5 = r6
        L_0x007d:
            if (r5 == 0) goto L_0x0092
            if (r7 != 0) goto L_0x008d
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            increment(r11, r0)
            goto L_0x0092
        L_0x008d:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0092:
            if (r7 == 0) goto L_0x009f
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            decrement(r11, r0)
        L_0x009f:
            if (r2 == 0) goto L_0x00b4
            if (r3 != 0) goto L_0x00af
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getOddRoundingErrors()
            increment(r11, r0)
            goto L_0x00b4
        L_0x00af:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00b4:
            if (r3 == 0) goto L_0x00c1
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getEvenRoundingErrors()
            decrement(r11, r0)
        L_0x00c1:
            return
        L_0x00c2:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00c7:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.rss.expanded.RSSExpandedReader.m13956a(int):void");
    }
}
