package com.airbnb.lottie.parser;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.didi.raven.config.RavenKey;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* renamed from: com.airbnb.lottie.parser.h */
/* compiled from: KeyframeParser */
class C1504h {

    /* renamed from: a */
    static JsonReader.Options f1611a = JsonReader.Options.m1436of(RavenKey.TYPE, RavenKey.STACK, "e", "o", "i", "h", "to", "ti");

    /* renamed from: b */
    private static final float f1612b = 100.0f;

    /* renamed from: c */
    private static final Interpolator f1613c = new LinearInterpolator();

    /* renamed from: d */
    private static SparseArrayCompat<WeakReference<Interpolator>> f1614d;

    C1504h() {
    }

    /* renamed from: a */
    private static SparseArrayCompat<WeakReference<Interpolator>> m1419a() {
        if (f1614d == null) {
            f1614d = new SparseArrayCompat<>();
        }
        return f1614d;
    }

    /* renamed from: a */
    private static WeakReference<Interpolator> m1423a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (C1504h.class) {
            weakReference = m1419a().get(i);
        }
        return weakReference;
    }

    /* renamed from: a */
    private static void m1424a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (C1504h.class) {
            f1614d.put(i, weakReference);
        }
    }

    /* renamed from: a */
    static <T> Keyframe<T> m1422a(JsonReader jsonReader, LottieComposition lottieComposition, float f, C1523u<T> uVar, boolean z) throws IOException {
        if (z) {
            return m1420a(lottieComposition, jsonReader, f, uVar);
        }
        return m1421a(jsonReader, f, uVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.view.animation.Interpolator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.value.Keyframe<T> m1420a(com.airbnb.lottie.LottieComposition r16, com.airbnb.lottie.parser.moshi.JsonReader r17, float r18, com.airbnb.lottie.parser.C1523u<T> r19) throws java.io.IOException {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r17.beginObject()
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = r5
            r8 = r7
            r9 = r8
            r10 = r9
            r14 = r10
            r15 = r14
            r6 = 0
            r13 = 0
        L_0x0014:
            boolean r11 = r17.hasNext()
            if (r11 == 0) goto L_0x0056
            com.airbnb.lottie.parser.moshi.JsonReader$Options r11 = f1611a
            int r11 = r0.selectName(r11)
            switch(r11) {
                case 0: goto L_0x0050;
                case 1: goto L_0x004b;
                case 2: goto L_0x0046;
                case 3: goto L_0x0041;
                case 4: goto L_0x003c;
                case 5: goto L_0x0031;
                case 6: goto L_0x002c;
                case 7: goto L_0x0027;
                default: goto L_0x0023;
            }
        L_0x0023:
            r17.skipValue()
            goto L_0x0014
        L_0x0027:
            android.graphics.PointF r14 = com.airbnb.lottie.parser.C1503g.m1415b(r17, r18)
            goto L_0x0014
        L_0x002c:
            android.graphics.PointF r15 = com.airbnb.lottie.parser.C1503g.m1415b(r17, r18)
            goto L_0x0014
        L_0x0031:
            int r6 = r17.nextInt()
            r11 = 1
            if (r6 != r11) goto L_0x003a
            r6 = 1
            goto L_0x0014
        L_0x003a:
            r6 = 0
            goto L_0x0014
        L_0x003c:
            android.graphics.PointF r8 = com.airbnb.lottie.parser.C1503g.m1415b(r17, r18)
            goto L_0x0014
        L_0x0041:
            android.graphics.PointF r7 = com.airbnb.lottie.parser.C1503g.m1415b(r17, r18)
            goto L_0x0014
        L_0x0046:
            java.lang.Object r9 = r2.parse(r0, r1)
            goto L_0x0014
        L_0x004b:
            java.lang.Object r10 = r2.parse(r0, r1)
            goto L_0x0014
        L_0x0050:
            double r11 = r17.nextDouble()
            float r13 = (float) r11
            goto L_0x0014
        L_0x0056:
            r17.endObject()
            if (r6 == 0) goto L_0x0061
            android.view.animation.Interpolator r0 = f1613c
            r12 = r0
            r11 = r10
            goto L_0x0100
        L_0x0061:
            if (r7 == 0) goto L_0x00fc
            if (r8 == 0) goto L_0x00fc
            float r0 = r7.x
            float r2 = -r1
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r2, (float) r1)
            r7.x = r0
            float r0 = r7.y
            r3 = -1027080192(0xffffffffc2c80000, float:-100.0)
            r6 = 1120403456(0x42c80000, float:100.0)
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r3, (float) r6)
            r7.y = r0
            float r0 = r8.x
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r2, (float) r1)
            r8.x = r0
            float r0 = r8.y
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r3, (float) r6)
            r8.y = r0
            float r0 = r7.x
            float r2 = r7.y
            float r3 = r8.x
            float r6 = r8.y
            int r2 = com.airbnb.lottie.utils.Utils.hashFor(r0, r2, r3, r6)
            java.lang.ref.WeakReference r0 = m1423a(r2)
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r3 = r0.get()
            r5 = r3
            android.view.animation.Interpolator r5 = (android.view.animation.Interpolator) r5
        L_0x00a3:
            if (r0 == 0) goto L_0x00a7
            if (r5 != 0) goto L_0x00fa
        L_0x00a7:
            float r0 = r7.x
            float r0 = r0 / r1
            r7.x = r0
            float r0 = r7.y
            float r0 = r0 / r1
            r7.y = r0
            float r0 = r8.x
            float r0 = r0 / r1
            r8.x = r0
            float r0 = r8.y
            float r0 = r0 / r1
            r8.y = r0
            float r0 = r7.x     // Catch:{ IllegalArgumentException -> 0x00c8 }
            float r1 = r7.y     // Catch:{ IllegalArgumentException -> 0x00c8 }
            float r3 = r8.x     // Catch:{ IllegalArgumentException -> 0x00c8 }
            float r5 = r8.y     // Catch:{ IllegalArgumentException -> 0x00c8 }
            android.view.animation.Interpolator r0 = androidx.core.view.animation.PathInterpolatorCompat.create(r0, r1, r3, r5)     // Catch:{ IllegalArgumentException -> 0x00c8 }
            goto L_0x00f1
        L_0x00c8:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "The Path cannot loop back on itself."
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00ec
            float r0 = r7.x
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.min(r0, r1)
            float r1 = r7.y
            float r3 = r8.x
            float r3 = java.lang.Math.max(r3, r4)
            float r4 = r8.y
            android.view.animation.Interpolator r0 = androidx.core.view.animation.PathInterpolatorCompat.create(r0, r1, r3, r4)
            goto L_0x00f1
        L_0x00ec:
            android.view.animation.LinearInterpolator r0 = new android.view.animation.LinearInterpolator
            r0.<init>()
        L_0x00f1:
            r5 = r0
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fa }
            r0.<init>(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fa }
            m1424a(r2, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fa }
        L_0x00fa:
            r12 = r5
            goto L_0x00ff
        L_0x00fc:
            android.view.animation.Interpolator r0 = f1613c
            r12 = r0
        L_0x00ff:
            r11 = r9
        L_0x0100:
            com.airbnb.lottie.value.Keyframe r0 = new com.airbnb.lottie.value.Keyframe
            r1 = 0
            r8 = r0
            r9 = r16
            r5 = r14
            r14 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0.pathCp1 = r15
            r0.pathCp2 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.C1504h.m1420a(com.airbnb.lottie.LottieComposition, com.airbnb.lottie.parser.moshi.JsonReader, float, com.airbnb.lottie.parser.u):com.airbnb.lottie.value.Keyframe");
    }

    /* renamed from: a */
    private static <T> Keyframe<T> m1421a(JsonReader jsonReader, float f, C1523u<T> uVar) throws IOException {
        return new Keyframe<>(uVar.parse(jsonReader, f));
    }
}
