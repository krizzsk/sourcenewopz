package com.microblink.blinkbarcode.secured;

import java.util.ArrayList;
import java.util.List;

/* compiled from: line */
class lIIllIIIll {
    private IlIlIlllIl IIlIIIllIl;
    private final List<lllllIIIlI> IlIllIlIIl = new ArrayList();
    private boolean IllIIIIllI = false;
    private final List<lllllIIIlI> IllIIIllII = new ArrayList();
    private boolean lIlIIIIlIl = false;
    private final List<lllllIIIlI> llIIIlllll = new ArrayList();
    private boolean llIIlIIlll = false;
    private long llIIlIlIIl = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r6 != 3) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.microblink.blinkbarcode.secured.IIIlIIIIll llIIlIlIIl(java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r16, com.microblink.blinkbarcode.secured.llIlllIIIl r17) {
        /*
            r15 = this;
            r0 = r15
            java.util.Iterator r1 = r16.iterator()
        L_0x0005:
            boolean r2 = r1.hasNext()
            r3 = 1
            r5 = 1
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()
            com.microblink.blinkbarcode.secured.lllllIIIlI r2 = (com.microblink.blinkbarcode.secured.lllllIIIlI) r2
            boolean r6 = r2.IllIIIllII()
            if (r6 != 0) goto L_0x0005
            com.microblink.blinkbarcode.secured.lllllIIIlI$llIIlIlIIl r6 = r2.IlIllIlIIl()
            int r6 = r6.ordinal()
            if (r6 == 0) goto L_0x0039
            if (r6 == r5) goto L_0x0033
            r5 = 2
            if (r6 == r5) goto L_0x002d
            r5 = 3
            if (r6 == r5) goto L_0x0033
            goto L_0x003e
        L_0x002d:
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r5 = r0.llIIIlllll
            r5.add(r2)
            goto L_0x003e
        L_0x0033:
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r5 = r0.IllIIIllII
            r5.add(r2)
            goto L_0x003e
        L_0x0039:
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r5 = r0.IlIllIlIIl
            r5.add(r2)
        L_0x003e:
            long r5 = r0.llIIlIlIIl
            long r5 = r5 + r3
            r0.llIIlIlIIl = r5
            goto L_0x0005
        L_0x0044:
            int r1 = r17.ordinal()
            if (r1 == 0) goto L_0x005a
            if (r1 == r5) goto L_0x004d
            goto L_0x0071
        L_0x004d:
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r1 = r0.llIIIlllll
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0071
            r0.IllIIIIllI = r5
            r0.lIlIIIIlIl = r5
            goto L_0x0071
        L_0x005a:
            r0.IllIIIIllI = r5
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r1 = r0.llIIIlllll
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0067
            r0.lIlIIIIlIl = r5
            goto L_0x0071
        L_0x0067:
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r1 = r0.IllIIIllII
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0071
            r0.llIIlIIlll = r5
        L_0x0071:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.llIIIlllll
            int r2 = r2.size()
            r6 = 0
            if (r2 != r5) goto L_0x0096
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.llIIIlllll
            java.lang.Object r2 = r2.get(r6)
            r7 = r2
            com.microblink.blinkbarcode.secured.lllllIIIlI r7 = (com.microblink.blinkbarcode.secured.lllllIIIlI) r7
            r8 = 1
            r10 = 0
            r12 = 0
            com.microblink.blinkbarcode.secured.llIIllllIl r2 = com.microblink.blinkbarcode.secured.IllllIIIIl.llIIlIlIIl(r7, r8, r10, r12)
            r1.add(r2)
            goto L_0x00df
        L_0x0096:
            com.microblink.blinkbarcode.secured.llIlllIIIl r2 = com.microblink.blinkbarcode.secured.llIlllIIIl.DIRECT_API
            r7 = r17
            if (r7 != r2) goto L_0x00df
            long r7 = r0.llIIlIlIIl
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x00df
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.IlIllIlIIl
            int r2 = r2.size()
            if (r2 != r5) goto L_0x00c1
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.IlIllIlIIl
            java.lang.Object r2 = r2.get(r6)
            r7 = r2
            com.microblink.blinkbarcode.secured.lllllIIIlI r7 = (com.microblink.blinkbarcode.secured.lllllIIIlI) r7
            r8 = 0
            r10 = 1
            r12 = 0
            com.microblink.blinkbarcode.secured.llIIllllIl r2 = com.microblink.blinkbarcode.secured.IllllIIIIl.llIIlIlIIl(r7, r8, r10, r12)
            r1.add(r2)
            goto L_0x00df
        L_0x00c1:
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.IllIIIllII
            int r2 = r2.size()
            if (r2 != r5) goto L_0x00df
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.IllIIIllII
            java.lang.Object r2 = r2.get(r6)
            r7 = r2
            com.microblink.blinkbarcode.secured.lllllIIIlI r7 = (com.microblink.blinkbarcode.secured.lllllIIIlI) r7
            r8 = 0
            r10 = 0
            r12 = 1
            com.microblink.blinkbarcode.secured.llIIllllIl r2 = com.microblink.blinkbarcode.secured.IllllIIIIl.llIIlIlIIl(r7, r8, r10, r12)
            r1.add(r2)
        L_0x00df:
            com.microblink.blinkbarcode.secured.IlIlIlllIl r14 = new com.microblink.blinkbarcode.secured.IlIlIlllIl
            r14.<init>(r1)
            r0.IIlIIIllIl = r14
            com.microblink.blinkbarcode.secured.IIIlIIIIll r1 = new com.microblink.blinkbarcode.secured.IIIlIIIIll
            boolean r2 = r0.IllIIIIllI
            r12 = 0
            if (r2 == 0) goto L_0x00f0
            r8 = r3
            goto L_0x00f1
        L_0x00f0:
            r8 = r12
        L_0x00f1:
            boolean r2 = r0.lIlIIIIlIl
            if (r2 == 0) goto L_0x00f7
            r10 = r3
            goto L_0x00f8
        L_0x00f7:
            r10 = r12
        L_0x00f8:
            boolean r2 = r0.llIIlIIlll
            if (r2 == 0) goto L_0x00fd
            goto L_0x00fe
        L_0x00fd:
            r3 = r12
        L_0x00fe:
            r7 = r1
            r12 = r3
            r7.<init>(r8, r10, r12, r14)
            r2 = 0
            r0.llIIlIlIIl = r2
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.IlIllIlIIl
            r2.clear()
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.IllIIIllII
            r2.clear()
            java.util.List<com.microblink.blinkbarcode.secured.lllllIIIlI> r2 = r0.llIIIlllll
            r2.clear()
            r0.IllIIIIllI = r6
            r0.lIlIIIIlIl = r6
            r0.llIIlIIlll = r6
            r2 = 0
            r0.IIlIIIllIl = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.lIIllIIIll.llIIlIlIIl(java.util.List, com.microblink.blinkbarcode.secured.llIlllIIIl):com.microblink.blinkbarcode.secured.IIIlIIIIll");
    }
}
