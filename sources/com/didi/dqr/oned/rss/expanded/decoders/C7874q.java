package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.q */
/* compiled from: GeneralAppIdDecoder */
final class C7874q {

    /* renamed from: a */
    private final BitArray f18861a;

    /* renamed from: b */
    private final CurrentParsingState f18862b = new CurrentParsingState();

    /* renamed from: c */
    private final StringBuilder f18863c = new StringBuilder();

    C7874q(BitArray bitArray) {
        this.f18861a = bitArray;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo58452a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            C7870m a = mo58451a(i, str);
            String a2 = C7873p.m14018a(a.mo58440a());
            if (a2 != null) {
                sb.append(a2);
            }
            String valueOf = a.mo58441b() ? String.valueOf(a.mo58442c()) : null;
            if (i == a.mo58449g()) {
                return sb.toString();
            }
            i = a.mo58449g();
            str = valueOf;
        }
    }

    /* renamed from: a */
    private boolean m14022a(int i) {
        if (i + 7 <= this.f18861a.getSize()) {
            int i2 = i;
            while (true) {
                int i3 = i + 3;
                if (i2 >= i3) {
                    return this.f18861a.get(i3);
                }
                if (this.f18861a.get(i2)) {
                    return true;
                }
                i2++;
            }
        } else if (i + 4 <= this.f18861a.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private C7871n m14024b(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.f18861a.getSize()) {
            int a = mo58450a(i, 4);
            if (a == 0) {
                return new C7871n(this.f18861a.getSize(), 10, 10);
            }
            return new C7871n(this.f18861a.getSize(), a - 1, 10);
        }
        int a2 = mo58450a(i, 7) - 8;
        return new C7871n(i2, a2 / 11, a2 % 11);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58450a(int i, int i2) {
        return m14020a(this.f18861a, i, i2);
    }

    /* renamed from: a */
    static int m14020a(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7870m mo58451a(int i, String str) throws FormatException {
        this.f18863c.setLength(0);
        if (str != null) {
            this.f18863c.append(str);
        }
        this.f18862b.mo58423a(i);
        C7870m a = m14021a();
        if (a == null || !a.mo58441b()) {
            return new C7870m(this.f18862b.mo58422a(), this.f18863c.toString());
        }
        return new C7870m(this.f18862b.mo58422a(), this.f18863c.toString(), a.mo58442c());
    }

    /* renamed from: a */
    private C7870m m14021a() throws FormatException {
        boolean z;
        C7868k kVar;
        do {
            int a = this.f18862b.mo58422a();
            if (this.f18862b.mo58425b()) {
                kVar = m14027d();
                z = kVar.mo58437b();
            } else if (this.f18862b.mo58427d()) {
                kVar = m14025c();
                z = kVar.mo58437b();
            } else {
                kVar = m14023b();
                z = kVar.mo58437b();
            }
            if (!(a != this.f18862b.mo58422a()) && !z) {
                break;
            }
        } while (!z);
        return kVar.mo58436a();
    }

    /* renamed from: b */
    private C7868k m14023b() throws FormatException {
        C7870m mVar;
        while (m14022a(this.f18862b.mo58422a())) {
            C7871n b = m14024b(this.f18862b.mo58422a());
            this.f18862b.mo58423a(b.mo58449g());
            if (b.mo58446d()) {
                if (b.mo58447e()) {
                    mVar = new C7870m(this.f18862b.mo58422a(), this.f18863c.toString());
                } else {
                    mVar = new C7870m(this.f18862b.mo58422a(), this.f18863c.toString(), b.mo58444b());
                }
                return new C7868k(mVar, true);
            }
            this.f18863c.append(b.mo58443a());
            if (b.mo58447e()) {
                return new C7868k(new C7870m(this.f18862b.mo58422a(), this.f18863c.toString()), true);
            }
            this.f18863c.append(b.mo58444b());
        }
        if (m14033i(this.f18862b.mo58422a())) {
            this.f18862b.mo58429f();
            this.f18862b.mo58424b(4);
        }
        return new C7868k(false);
    }

    /* renamed from: c */
    private C7868k m14025c() throws FormatException {
        while (m14026c(this.f18862b.mo58422a())) {
            C7869l d = m14028d(this.f18862b.mo58422a());
            this.f18862b.mo58423a(d.mo58449g());
            if (d.mo58439b()) {
                return new C7868k(new C7870m(this.f18862b.mo58422a(), this.f18863c.toString()), true);
            }
            this.f18863c.append(d.mo58438a());
        }
        if (m14032h(this.f18862b.mo58422a())) {
            this.f18862b.mo58424b(3);
            this.f18862b.mo58428e();
        } else if (m14031g(this.f18862b.mo58422a())) {
            if (this.f18862b.mo58422a() + 5 < this.f18861a.getSize()) {
                this.f18862b.mo58424b(5);
            } else {
                this.f18862b.mo58423a(this.f18861a.getSize());
            }
            this.f18862b.mo58429f();
        }
        return new C7868k(false);
    }

    /* renamed from: d */
    private C7868k m14027d() {
        while (m14029e(this.f18862b.mo58422a())) {
            C7869l f = m14030f(this.f18862b.mo58422a());
            this.f18862b.mo58423a(f.mo58449g());
            if (f.mo58439b()) {
                return new C7868k(new C7870m(this.f18862b.mo58422a(), this.f18863c.toString()), true);
            }
            this.f18863c.append(f.mo58438a());
        }
        if (m14032h(this.f18862b.mo58422a())) {
            this.f18862b.mo58424b(3);
            this.f18862b.mo58428e();
        } else if (m14031g(this.f18862b.mo58422a())) {
            if (this.f18862b.mo58422a() + 5 < this.f18861a.getSize()) {
                this.f18862b.mo58424b(5);
            } else {
                this.f18862b.mo58423a(this.f18861a.getSize());
            }
            this.f18862b.mo58430g();
        }
        return new C7868k(false);
    }

    /* renamed from: c */
    private boolean m14026c(int i) {
        int a;
        if (i + 5 > this.f18861a.getSize()) {
            return false;
        }
        int a2 = mo58450a(i, 5);
        if (a2 >= 5 && a2 < 16) {
            return true;
        }
        if (i + 7 > this.f18861a.getSize()) {
            return false;
        }
        int a3 = mo58450a(i, 7);
        if (a3 >= 64 && a3 < 116) {
            return true;
        }
        if (i + 8 <= this.f18861a.getSize() && (a = mo58450a(i, 8)) >= 232 && a < 253) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private C7869l m14028d(int i) throws FormatException {
        char c;
        int a = mo58450a(i, 5);
        if (a == 15) {
            return new C7869l(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C7869l(i + 5, (char) ((a + 48) - 5));
        }
        int a2 = mo58450a(i, 7);
        if (a2 >= 64 && a2 < 90) {
            return new C7869l(i + 7, (char) (a2 + 1));
        }
        if (a2 >= 90 && a2 < 116) {
            return new C7869l(i + 7, (char) (a2 + 7));
        }
        switch (mo58450a(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = Typography.quote;
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = Typography.amp;
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = VersionRange.LEFT_OPEN;
                break;
            case 238:
                c = VersionRange.RIGHT_OPEN;
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = Typography.less;
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = Typography.greater;
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new C7869l(i + 8, c);
    }

    /* renamed from: e */
    private boolean m14029e(int i) {
        int a;
        if (i + 5 > this.f18861a.getSize()) {
            return false;
        }
        int a2 = mo58450a(i, 5);
        if (a2 >= 5 && a2 < 16) {
            return true;
        }
        if (i + 6 <= this.f18861a.getSize() && (a = mo58450a(i, 6)) >= 16 && a < 63) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private C7869l m14030f(int i) {
        char c;
        int a = mo58450a(i, 5);
        if (a == 15) {
            return new C7869l(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C7869l(i + 5, (char) ((a + 48) - 5));
        }
        int a2 = mo58450a(i, 6);
        if (a2 >= 32 && a2 < 58) {
            return new C7869l(i + 6, (char) (a2 + 33));
        }
        switch (a2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a2);
        }
        return new C7869l(i + 6, c);
    }

    /* renamed from: g */
    private boolean m14031g(int i) {
        int i2;
        if (i + 1 > this.f18861a.getSize()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 5 && (i2 = i3 + i) < this.f18861a.getSize()) {
            if (i3 == 2) {
                if (!this.f18861a.get(i + 2)) {
                    return false;
                }
            } else if (this.f18861a.get(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* renamed from: h */
    private boolean m14032h(int i) {
        int i2 = i + 3;
        if (i2 > this.f18861a.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.f18861a.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: i */
    private boolean m14033i(int i) {
        int i2;
        if (i + 1 > this.f18861a.getSize()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 4 && (i2 = i3 + i) < this.f18861a.getSize()) {
            if (this.f18861a.get(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }
}
