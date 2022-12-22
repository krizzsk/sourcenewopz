package com.cardinalcommerce.dependencies.internal.bouncycastle.util.p064io.pem;

import com.cardinalcommerce.p060a.setOnCapturedPointerListener;
import com.cardinalcommerce.p060a.setTouchscreenBlocksFocus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.util.io.pem.PemObject */
public class PemObject implements setTouchscreenBlocksFocus {

    /* renamed from: a */
    private static final List f3228a = Collections.unmodifiableList(new ArrayList());

    /* renamed from: b */
    private byte[] f3229b;
    public List cca_continue;
    public String getInstance;

    public PemObject(String str, List list, byte[] bArr) {
        this.getInstance = str;
        this.cca_continue = Collections.unmodifiableList(list);
        this.f3229b = bArr;
    }

    public PemObject(String str, byte[] bArr) {
        this(str, f3228a, bArr);
    }

    public final PemObject Cardinal() throws setOnCapturedPointerListener {
        return this;
    }

    public final byte[] cca_continue() {
        return this.f3229b;
    }
}
