package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.e */
/* compiled from: EdifactEncoder */
final class C7843e implements C7844f {
    /* renamed from: a */
    public int mo58338a() {
        return 4;
    }

    C7843e() {
    }

    /* renamed from: a */
    public void mo58339a(C7845g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.mo58356h()) {
                break;
            }
            m13839a(gVar.mo58348b(), sb);
            gVar.f18648a++;
            if (sb.length() >= 4) {
                gVar.mo58347a(m13838a((CharSequence) sb));
                sb.delete(0, 4);
                if (HighLevelEncoder.m13810a(gVar.mo58342a(), gVar.f18648a, mo58338a()) != mo58338a()) {
                    gVar.mo58349b(0);
                    break;
                }
            }
        }
        sb.append(31);
        m13840a(gVar, (CharSequence) sb);
    }

    /* renamed from: a */
    private static void m13840a(C7845g gVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    gVar.mo58359k();
                    int dataCapacity = gVar.mo58358j().getDataCapacity() - gVar.mo58353e();
                    int i = gVar.mo58357i();
                    if (i > dataCapacity) {
                        gVar.mo58351c(gVar.mo58353e() + 1);
                        dataCapacity = gVar.mo58358j().getDataCapacity() - gVar.mo58353e();
                    }
                    if (i <= dataCapacity && dataCapacity <= 2) {
                        gVar.mo58349b(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i2 = length - 1;
                    String a = m13838a(charSequence);
                    if (!(!gVar.mo58356h()) || i2 > 2) {
                        z = false;
                    }
                    if (i2 <= 2) {
                        gVar.mo58351c(gVar.mo58353e() + i2);
                        if (gVar.mo58358j().getDataCapacity() - gVar.mo58353e() >= 3) {
                            gVar.mo58351c(gVar.mo58353e() + a.length());
                            z = false;
                        }
                    }
                    if (z) {
                        gVar.mo58360l();
                        gVar.f18648a -= i2;
                    } else {
                        gVar.mo58347a(a);
                    }
                    gVar.mo58349b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            gVar.mo58349b(0);
        }
    }

    /* renamed from: a */
    private static void m13839a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            HighLevelEncoder.m13815c(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    /* renamed from: a */
    private static String m13838a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            char c = 0;
            char charAt = charSequence.charAt(0);
            char charAt2 = length >= 2 ? charSequence.charAt(1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(3);
            }
            int i = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c;
            char c2 = (char) ((i >> 8) & 255);
            char c3 = (char) (i & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
