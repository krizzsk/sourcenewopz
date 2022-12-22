package p242io.reactivex.internal.util;

import java.util.ArrayList;

/* renamed from: io.reactivex.internal.util.LinkedArrayList */
public class LinkedArrayList {

    /* renamed from: a */
    final int f59286a;

    /* renamed from: b */
    Object[] f59287b;

    /* renamed from: c */
    Object[] f59288c;

    /* renamed from: d */
    volatile int f59289d;

    /* renamed from: e */
    int f59290e;

    public LinkedArrayList(int i) {
        this.f59286a = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f59289d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            int r0 = r4.f59286a
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.f59287b = r0
            r4.f59288c = r0
            r0[r1] = r5
            r4.f59290e = r2
            r4.f59289d = r2
            goto L_0x003c
        L_0x0016:
            int r0 = r4.f59290e
            int r3 = r4.f59286a
            if (r0 != r3) goto L_0x0030
            int r0 = r3 + 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Object[] r5 = r4.f59288c
            r5[r3] = r0
            r4.f59288c = r0
            r4.f59290e = r2
            int r5 = r4.f59289d
            int r5 = r5 + r2
            r4.f59289d = r5
            goto L_0x003c
        L_0x0030:
            java.lang.Object[] r1 = r4.f59288c
            r1[r0] = r5
            int r0 = r0 + r2
            r4.f59290e = r0
            int r5 = r4.f59289d
            int r5 = r5 + r2
            r4.f59289d = r5
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.reactivex.internal.util.LinkedArrayList.add(java.lang.Object):void");
    }

    public Object[] head() {
        return this.f59287b;
    }

    public int size() {
        return this.f59289d;
    }

    public String toString() {
        int i = this.f59286a;
        int i2 = this.f59289d;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] head = head();
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(head[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    head = head[i];
                }
            }
            return arrayList.toString();
        }
    }
}
