package com.iproov.sdk.cameray;

import android.media.Image;
import com.iproov.sdk.cameray.C19788import;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.iproov.sdk.cameray.a */
/* compiled from: YUVImageImpl */
class C19766a implements C19788import {

    /* renamed from: a */
    private final Image f54000a;

    /* renamed from: b */
    private final Map<C19788import.C19789do, Image.Plane> f54001b = new HashMap();

    /* renamed from: c */
    private final Map<C19788import.C19789do, ByteBuffer> f54002c = new HashMap();

    public C19766a(Image image) {
        this.f54000a = image;
        for (C19788import.C19789do doVar : C19788import.C19789do.values()) {
            this.f54001b.put(doVar, image.getPlanes()[doVar.ordinal()]);
            this.f54002c.put(doVar, image.getPlanes()[doVar.ordinal()].getBuffer());
        }
    }

    /* renamed from: a */
    public int mo161886a() {
        return this.f54000a.getWidth();
    }

    /* renamed from: b */
    public int mo161889b() {
        return this.f54000a.getHeight();
    }

    /* renamed from: a */
    public int mo161887a(C19788import.C19789do doVar) {
        return this.f54001b.get(doVar).getPixelStride();
    }

    /* renamed from: a */
    public void mo161888a(C19788import.C19789do doVar, int i, byte[] bArr, int i2, int i3) {
        ByteBuffer byteBuffer = this.f54002c.get(doVar);
        byteBuffer.position(i);
        byteBuffer.get(bArr, i2, i3);
    }

    /* renamed from: a */
    public byte mo161885a(C19788import.C19789do doVar, int i) {
        return this.f54002c.get(doVar).get(i);
    }

    /* renamed from: b */
    public int mo161890b(C19788import.C19789do doVar) {
        return this.f54001b.get(doVar).getRowStride();
    }
}
