package com.didi.dqr.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;

/* renamed from: com.didi.dqr.datamatrix.encoder.b */
/* compiled from: Base256Encoder */
final class C7840b implements C7844f {
    /* renamed from: a */
    public int mo58338a() {
        return 5;
    }

    C7840b() {
    }

    /* renamed from: a */
    public void mo58339a(C7845g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!gVar.mo58356h()) {
                break;
            }
            sb.append(gVar.mo58348b());
            gVar.f18648a++;
            if (HighLevelEncoder.m13810a(gVar.mo58342a(), gVar.f18648a, mo58338a()) != mo58338a()) {
                gVar.mo58349b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int e = gVar.mo58353e() + length + 1;
        gVar.mo58351c(e);
        boolean z = gVar.mo58358j().getDataCapacity() - e > 0;
        if (gVar.mo58356h() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            gVar.mo58343a(m13828a(sb.charAt(i), gVar.mo58353e() + 1));
        }
    }

    /* renamed from: a */
    private static char m13828a(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
