package com.p222hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.b */
/* compiled from: CharCircBuffer */
class C19744b {

    /* renamed from: a */
    private final int[] f53897a;

    /* renamed from: b */
    private int f53898b = 0;

    /* renamed from: c */
    private int f53899c = 0;

    /* renamed from: d */
    private boolean f53900d = true;

    C19744b(int i) {
        this.f53897a = new int[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161788a() {
        this.f53900d = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo161792b() {
        this.f53900d = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161790a(int i) {
        m38558b(i + 65536);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161789a(char c) {
        m38558b(c);
    }

    /* renamed from: b */
    private void m38558b(int i) {
        if (this.f53900d) {
            int[] iArr = this.f53897a;
            int i2 = this.f53898b;
            iArr[i2] = i;
            this.f53898b = (i2 + 1) % iArr.length;
            this.f53899c++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161791a(String str) {
        for (char a : str.toCharArray()) {
            mo161789a(a);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f53897a.length * 11) / 10);
        int i = this.f53899c;
        int[] iArr = this.f53897a;
        int length = i < iArr.length ? iArr.length - i : 0;
        while (true) {
            int[] iArr2 = this.f53897a;
            if (length >= iArr2.length) {
                return stringBuffer.toString();
            }
            int i2 = iArr2[(this.f53898b + length) % iArr2.length];
            if (i2 < 65536) {
                stringBuffer.append((char) i2);
            } else {
                stringBuffer.append(Integer.toString(i2 - 65536));
            }
            length++;
        }
    }
}
