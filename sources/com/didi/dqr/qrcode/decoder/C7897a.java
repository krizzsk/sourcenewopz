package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;

/* renamed from: com.didi.dqr.qrcode.decoder.a */
/* compiled from: BitMatrixParser */
final class C7897a {

    /* renamed from: a */
    private final BitMatrix f19030a;

    /* renamed from: b */
    private Version f19031b;

    /* renamed from: c */
    private C7899c f19032c;

    /* renamed from: d */
    private boolean f19033d;

    C7897a(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            AnalysisManager.report(EventId.QRCODE_VERSION_ERROR);
            throw FormatException.getFormatInstance();
        } else {
            this.f19030a = bitMatrix;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7899c mo58595a() throws FormatException {
        C7899c cVar = this.f19032c;
        if (cVar != null) {
            return cVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = m14216a(i3, 8, i2);
        }
        int a = m14216a(8, 7, m14216a(8, 8, m14216a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a = m14216a(8, i4, a);
        }
        int height = this.f19030a.getHeight();
        int i5 = height - 7;
        for (int i6 = height - 1; i6 >= i5; i6--) {
            i = m14216a(8, i6, i);
        }
        for (int i7 = height - 8; i7 < height; i7++) {
            i = m14216a(i7, 8, i);
        }
        C7899c b = C7899c.m14227b(a, i);
        this.f19032c = b;
        if (b != null) {
            return b;
        }
        AnalysisManager.report(EventId.QRCODE_FORMAT_INFO_ERROR);
        throw FormatException.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Version mo58597b() throws FormatException {
        Version version = this.f19031b;
        if (version != null) {
            return version;
        }
        int height = this.f19030a.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i2; i6--) {
                i4 = m14216a(i6, i5, i4);
            }
        }
        Version a = Version.m14213a(i4);
        if (a == null || a.getDimensionForVersion() != height) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = height - 9; i8 >= i2; i8--) {
                    i3 = m14216a(i7, i8, i3);
                }
            }
            Version a2 = Version.m14213a(i3);
            if (a2 == null || a2.getDimensionForVersion() != height) {
                AnalysisManager.report(EventId.QRCODE_VERSION_ERROR);
                throw FormatException.getFormatInstance();
            }
            this.f19031b = a2;
            return a2;
        }
        this.f19031b = a;
        return a;
    }

    /* renamed from: a */
    private int m14216a(int i, int i2, int i3) {
        return this.f19033d ? this.f19030a.get(i2, i) : this.f19030a.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte[] mo58598c() throws FormatException {
        C7899c a = mo58595a();
        Version b = mo58597b();
        DataMask dataMask = DataMask.values()[a.mo58604b()];
        int height = this.f19030a.getHeight();
        dataMask.unmaskBitMatrix(this.f19030a, height);
        BitMatrix a2 = b.mo58582a();
        byte[] bArr = new byte[b.getTotalCodewords()];
        int i = height - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!a2.get(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.f19030a.get(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == b.getTotalCodewords()) {
            return bArr;
        }
        AnalysisManager.report(EventId.QRCODE_CODE_WORDS_ERROR);
        throw FormatException.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo58599d() {
        if (this.f19032c != null) {
            DataMask.values()[this.f19032c.mo58604b()].unmaskBitMatrix(this.f19030a, this.f19030a.getHeight());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58596a(boolean z) {
        this.f19031b = null;
        this.f19032c = null;
        this.f19033d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo58600e() {
        int i = 0;
        while (i < this.f19030a.getWidth()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f19030a.getHeight(); i3++) {
                if (this.f19030a.get(i, i3) != this.f19030a.get(i3, i)) {
                    this.f19030a.flip(i3, i);
                    this.f19030a.flip(i, i3);
                }
            }
            i = i2;
        }
    }
}
