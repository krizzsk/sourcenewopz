package p232do;

/* renamed from: do.break */
/* compiled from: Size */
public final class C20817break {

    /* renamed from: a */
    private final int f57196a;

    /* renamed from: b */
    private final int f57197b;

    public C20817break(int i, int i2) {
        this.f57196a = i;
        this.f57197b = i2;
    }

    /* renamed from: do */
    public int mo170629do() {
        return this.f57197b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20817break)) {
            return false;
        }
        C20817break breakR = (C20817break) obj;
        if (this.f57196a == breakR.f57196a && this.f57197b == breakR.f57197b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f57197b;
        int i2 = this.f57196a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    /* renamed from: if */
    public int mo170632if() {
        return this.f57196a;
    }

    public String toString() {
        return this.f57196a + "x" + this.f57197b;
    }
}
