package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.util.p064io.pem.PemObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.cardinalcommerce.a.setViewTranslationCallback */
public final class setViewTranslationCallback extends BufferedWriter {

    /* renamed from: a */
    private char[] f3095a = new char[64];

    public setViewTranslationCallback(Writer writer) {
        super(writer);
        setAnimation.getInstance();
    }

    /* renamed from: a */
    private void m2176a(byte[] bArr) throws IOException {
        int i;
        byte[] cca_continue = setOnSystemUiVisibilityChangeListener.cca_continue(bArr);
        int i2 = 0;
        while (i2 < cca_continue.length) {
            int i3 = 0;
            while (true) {
                char[] cArr = this.f3095a;
                if (i3 == cArr.length || (i = i2 + i3) >= cca_continue.length) {
                    write(this.f3095a, 0, i3);
                    newLine();
                    i2 += this.f3095a.length;
                } else {
                    cArr[i3] = (char) cca_continue[i];
                    i3++;
                }
            }
            write(this.f3095a, 0, i3);
            newLine();
            i2 += this.f3095a.length;
        }
    }

    public final void configure(setTouchscreenBlocksFocus settouchscreenblocksfocus) throws IOException {
        PemObject Cardinal = settouchscreenblocksfocus.Cardinal();
        String str = Cardinal.getInstance;
        StringBuilder sb = new StringBuilder("-----BEGIN ");
        sb.append(str);
        sb.append("-----");
        write(sb.toString());
        newLine();
        if (!Cardinal.cca_continue.isEmpty()) {
            for (setScrollCaptureHint setscrollcapturehint : Cardinal.cca_continue) {
                write(setscrollcapturehint.f2969a);
                write(": ");
                write(setscrollcapturehint.f2970b);
                newLine();
            }
            newLine();
        }
        m2176a(Cardinal.cca_continue());
        String str2 = Cardinal.getInstance;
        StringBuilder sb2 = new StringBuilder("-----END ");
        sb2.append(str2);
        sb2.append("-----");
        write(sb2.toString());
        newLine();
    }
}
