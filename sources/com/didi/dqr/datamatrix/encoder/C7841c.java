package com.didi.dqr.datamatrix.encoder;

import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.datamatrix.encoder.c */
/* compiled from: C40Encoder */
class C7841c implements C7844f {
    /* renamed from: a */
    public int mo58338a() {
        return 1;
    }

    C7841c() {
    }

    /* renamed from: a */
    public void mo58339a(C7845g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.mo58356h()) {
                break;
            }
            char b = gVar.mo58348b();
            gVar.f18648a++;
            int a = mo58340a(b, sb);
            int e = gVar.mo58353e() + ((sb.length() / 3) * 2);
            gVar.mo58351c(e);
            int dataCapacity = gVar.mo58358j().getDataCapacity() - e;
            if (gVar.mo58356h()) {
                if (sb.length() % 3 == 0 && HighLevelEncoder.m13810a(gVar.mo58342a(), gVar.f18648a, mo58338a()) != mo58338a()) {
                    gVar.mo58349b(0);
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && dataCapacity != 2) {
                    a = m13831a(gVar, sb, sb2, a);
                }
                while (sb.length() % 3 == 1 && (a > 3 || dataCapacity != 1)) {
                    a = m13831a(gVar, sb, sb2, a);
                }
            }
        }
        mo58341b(gVar, sb);
    }

    /* renamed from: a */
    private int m13831a(C7845g gVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        gVar.f18648a--;
        int a = mo58340a(gVar.mo58348b(), sb2);
        gVar.mo58360l();
        return a;
    }

    /* renamed from: a */
    static void m13833a(C7845g gVar, StringBuilder sb) {
        gVar.mo58347a(m13832a((CharSequence) sb));
        sb.delete(0, 3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58341b(C7845g gVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int e = gVar.mo58353e() + ((sb.length() / 3) * 2);
        gVar.mo58351c(e);
        int dataCapacity = gVar.mo58358j().getDataCapacity() - e;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                m13833a(gVar, sb);
            }
            if (gVar.mo58356h()) {
                gVar.mo58343a(254);
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (sb.length() >= 3) {
                m13833a(gVar, sb);
            }
            if (gVar.mo58356h()) {
                gVar.mo58343a(254);
            }
            gVar.f18648a--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                m13833a(gVar, sb);
            }
            if (dataCapacity > 0 || gVar.mo58356h()) {
                gVar.mo58343a(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        gVar.mo58349b(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58340a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c <= '@') {
            sb.append(1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c <= '_') {
            sb.append(1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c <= 127) {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return mo58340a((char) (c - 128), sb) + 2;
        }
    }

    /* renamed from: a */
    private static String m13832a(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * VersionRange.LEFT_OPEN) + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
