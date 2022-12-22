package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.i */
/* compiled from: X12Encoder */
final class C7847i extends C7841c {
    /* renamed from: a */
    public int mo58338a() {
        return 3;
    }

    C7847i() {
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
            mo58340a(b, sb);
            if (sb.length() % 3 == 0) {
                m13833a(gVar, sb);
                if (HighLevelEncoder.m13810a(gVar.mo58342a(), gVar.f18648a, mo58338a()) != mo58338a()) {
                    gVar.mo58349b(0);
                    break;
                }
            }
        }
        mo58341b(gVar, sb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58340a(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.m13815c(c);
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58341b(C7845g gVar, StringBuilder sb) {
        gVar.mo58359k();
        int dataCapacity = gVar.mo58358j().getDataCapacity() - gVar.mo58353e();
        gVar.f18648a -= sb.length();
        if (gVar.mo58357i() > 1 || dataCapacity > 1 || gVar.mo58357i() != dataCapacity) {
            gVar.mo58343a(254);
        }
        if (gVar.mo58354f() < 0) {
            gVar.mo58349b(0);
        }
    }
}
