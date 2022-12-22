package com.google.p217ar.core;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.google.ar.core.j */
/* compiled from: FaceCache */
final class C18667j extends LinkedHashMap<Long, AugmentedFace> {
    C18667j(int i, float f, boolean z) {
        super(1, 0.75f, true);
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry<Long, AugmentedFace> entry) {
        return size() > 10;
    }
}
