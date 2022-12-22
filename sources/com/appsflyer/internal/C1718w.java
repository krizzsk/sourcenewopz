package com.appsflyer.internal;

/* renamed from: com.appsflyer.internal.w */
public final class C1718w {

    /* renamed from: Ι */
    private boolean f2030;

    /* renamed from: ι */
    public String f2031;

    C1718w(String str, boolean z) {
        this.f2031 = str;
        this.f2030 = z;
    }

    /* renamed from: ɩ */
    public final boolean mo16162() {
        return this.f2030;
    }

    public final String toString() {
        return String.format("%s,%s", new Object[]{this.f2031, Boolean.valueOf(this.f2030)});
    }

    /* renamed from: com.appsflyer.internal.w$e */
    enum C1719e {
        GOOGLE(0),
        AMAZON(1);
        

        /* renamed from: Ι */
        private int f2035;

        private C1719e(int i) {
            this.f2035 = i;
        }

        public final String toString() {
            return String.valueOf(this.f2035);
        }
    }
}
