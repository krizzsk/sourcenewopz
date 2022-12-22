package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setProgress */
public final class setProgress {

    /* renamed from: a */
    private static int f2922a = 0;

    /* renamed from: b */
    private static int f2923b = 1;
    public static setProgress configure;
    public static setCompoundDrawablePadding getInstance;
    public setTextCursorDrawable init;

    public static synchronized setProgress Cardinal() {
        setProgress setprogress;
        synchronized (setProgress.class) {
            int i = f2922a + 111;
            f2923b = i % 128;
            int i2 = i % 2;
            if (configure == null) {
                configure = new setProgress();
                getInstance = new setCompoundDrawablePadding();
                int i3 = f2923b;
                int i4 = (i3 & 1) + (i3 | 1);
                f2922a = i4 % 128;
                int i5 = i4 % 2;
            }
            setprogress = configure;
            int i6 = f2922a;
            int i7 = i6 ^ 35;
            int i8 = ((i6 & 35) | i7) << 1;
            int i9 = -i7;
            int i10 = ((i8 | i9) << 1) - (i8 ^ i9);
            f2923b = i10 % 128;
            int i11 = i10 % 2;
        }
        return setprogress;
    }
}
