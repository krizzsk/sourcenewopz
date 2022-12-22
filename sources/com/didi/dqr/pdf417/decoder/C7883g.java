package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.ResultPoint;

/* renamed from: com.didi.dqr.pdf417.decoder.g */
/* compiled from: DetectionResultRowIndicatorColumn */
final class C7883g extends C7882f {

    /* renamed from: a */
    private final boolean f18952a;

    C7883g(C7878c cVar, boolean z) {
        super(cVar);
        this.f18952a = z;
    }

    /* renamed from: f */
    private void m14151f() {
        for (C7879d dVar : mo58541b()) {
            if (dVar != null) {
                dVar.mo58496b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58544a(C7876a aVar) {
        C7879d[] b = mo58541b();
        m14151f();
        m14149a(b, aVar);
        C7878c a = mo58537a();
        ResultPoint e = this.f18952a ? a.mo58490e() : a.mo58491f();
        ResultPoint g = this.f18952a ? a.mo58492g() : a.mo58493h();
        int b2 = mo58540b((int) e.getY());
        int b3 = mo58540b((int) g.getY());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (b2 < b3) {
            if (b[b2] != null) {
                C7879d dVar = b[b2];
                int h = dVar.mo58503h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.mo58503h();
                    } else if (h < 0 || dVar.mo58503h() >= aVar.mo58479c() || h > b2) {
                        b[b2] = null;
                    } else {
                        if (i3 > 2) {
                            h *= i3 - 2;
                        }
                        boolean z = h >= b2;
                        for (int i4 = 1; i4 <= h && !z; i4++) {
                            z = b[b2 - i4] != null;
                        }
                        if (z) {
                            b[b2] = null;
                        } else {
                            i = dVar.mo58503h();
                        }
                    }
                    i2 = 1;
                }
            }
            b2++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo58545c() {
        int h;
        C7876a d = mo58546d();
        if (d == null) {
            return null;
        }
        m14150b(d);
        int c = d.mo58479c();
        int[] iArr = new int[c];
        for (C7879d dVar : mo58541b()) {
            if (dVar != null && (h = dVar.mo58503h()) < c) {
                iArr[h] = iArr[h] + 1;
            }
        }
        return iArr;
    }

    /* renamed from: b */
    private void m14150b(C7876a aVar) {
        C7878c a = mo58537a();
        ResultPoint e = this.f18952a ? a.mo58490e() : a.mo58491f();
        ResultPoint g = this.f18952a ? a.mo58492g() : a.mo58493h();
        int b = mo58540b((int) g.getY());
        C7879d[] b2 = mo58541b();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int b3 = mo58540b((int) e.getY()); b3 < b; b3++) {
            if (b2[b3] != null) {
                C7879d dVar = b2[b3];
                dVar.mo58496b();
                int h = dVar.mo58503h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.mo58503h();
                    } else if (dVar.mo58503h() >= aVar.mo58479c()) {
                        b2[b3] = null;
                    } else {
                        i = dVar.mo58503h();
                    }
                    i2 = 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C7876a mo58546d() {
        C7879d[] b = mo58541b();
        C7877b bVar = new C7877b();
        C7877b bVar2 = new C7877b();
        C7877b bVar3 = new C7877b();
        C7877b bVar4 = new C7877b();
        for (C7879d dVar : b) {
            if (dVar != null) {
                dVar.mo58496b();
                int g = dVar.mo58502g() % 30;
                int h = dVar.mo58503h();
                if (!this.f18952a) {
                    h += 2;
                }
                int i = h % 3;
                if (i == 0) {
                    bVar2.mo58482a((g * 3) + 1);
                } else if (i == 1) {
                    bVar4.mo58482a(g / 3);
                    bVar3.mo58482a(g % 3);
                } else if (i == 2) {
                    bVar.mo58482a(g + 1);
                }
            }
        }
        if (bVar.mo58483a().length == 0 || bVar2.mo58483a().length == 0 || bVar3.mo58483a().length == 0 || bVar4.mo58483a().length == 0 || bVar.mo58483a()[0] < 1 || bVar2.mo58483a()[0] + bVar3.mo58483a()[0] < 3 || bVar2.mo58483a()[0] + bVar3.mo58483a()[0] > 90) {
            return null;
        }
        C7876a aVar = new C7876a(bVar.mo58483a()[0], bVar2.mo58483a()[0], bVar3.mo58483a()[0], bVar4.mo58483a()[0]);
        m14149a(b, aVar);
        return aVar;
    }

    /* renamed from: a */
    private void m14149a(C7879d[] dVarArr, C7876a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            C7879d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int g = dVar.mo58502g() % 30;
                int h = dVar.mo58503h();
                if (h > aVar.mo58479c()) {
                    dVarArr[i] = null;
                } else {
                    if (!this.f18952a) {
                        h += 2;
                    }
                    int i2 = h % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && g + 1 != aVar.mo58477a()) {
                                dVarArr[i] = null;
                            }
                        } else if (g / 3 != aVar.mo58478b() || g % 3 != aVar.mo58481e()) {
                            dVarArr[i] = null;
                        }
                    } else if ((g * 3) + 1 != aVar.mo58480d()) {
                        dVarArr[i] = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo58547e() {
        return this.f18952a;
    }

    public String toString() {
        return "IsLeft: " + this.f18952a + 10 + super.toString();
    }
}
