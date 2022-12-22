package com.google.p217ar.core;

import java.util.Map;

/* renamed from: com.google.ar.core.i */
/* compiled from: FaceCache */
final class C18666i {

    /* renamed from: a */
    private final Map<Long, AugmentedFace> f53542a = new C18667j(1, 0.75f, true);

    C18666i() {
    }

    /* renamed from: a */
    public final synchronized AugmentedFace mo149636a(long j, Session session) {
        AugmentedFace augmentedFace;
        augmentedFace = this.f53542a.get(Long.valueOf(j));
        if (augmentedFace == null) {
            augmentedFace = new AugmentedFace(j, session);
            this.f53542a.put(Long.valueOf(j), augmentedFace);
        }
        return augmentedFace;
    }
}
