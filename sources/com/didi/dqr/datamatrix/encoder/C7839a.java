package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.a */
/* compiled from: ASCIIEncoder */
final class C7839a implements C7844f {
    /* renamed from: a */
    public int mo58338a() {
        return 0;
    }

    C7839a() {
    }

    /* renamed from: a */
    public void mo58339a(C7845g gVar) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(gVar.mo58342a(), gVar.f18648a) >= 2) {
            gVar.mo58343a(m13825a(gVar.mo58342a().charAt(gVar.f18648a), gVar.mo58342a().charAt(gVar.f18648a + 1)));
            gVar.f18648a += 2;
            return;
        }
        char b = gVar.mo58348b();
        int a = HighLevelEncoder.m13810a(gVar.mo58342a(), gVar.f18648a, mo58338a());
        if (a != mo58338a()) {
            if (a == 1) {
                gVar.mo58343a(230);
                gVar.mo58349b(1);
            } else if (a == 2) {
                gVar.mo58343a(239);
                gVar.mo58349b(2);
            } else if (a == 3) {
                gVar.mo58343a(238);
                gVar.mo58349b(3);
            } else if (a == 4) {
                gVar.mo58343a(240);
                gVar.mo58349b(4);
            } else if (a == 5) {
                gVar.mo58343a(231);
                gVar.mo58349b(5);
            } else {
                throw new IllegalStateException("Illegal mode: " + a);
            }
        } else if (HighLevelEncoder.m13814b(b)) {
            gVar.mo58343a(235);
            gVar.mo58343a((char) ((b - 128) + 1));
            gVar.f18648a++;
        } else {
            gVar.mo58343a((char) (b + 1));
            gVar.f18648a++;
        }
    }

    /* renamed from: a */
    private static char m13825a(char c, char c2) {
        if (HighLevelEncoder.m13813a(c) && HighLevelEncoder.m13813a(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
