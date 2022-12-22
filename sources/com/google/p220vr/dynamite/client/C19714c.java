package com.google.p220vr.dynamite.client;

/* renamed from: com.google.vr.dynamite.client.c */
/* compiled from: LoaderException */
public final class C19714c extends Exception {

    /* renamed from: a */
    private final int f53820a = 1;

    public C19714c(int i) {
    }

    public final String getMessage() {
        int i = this.f53820a;
        String str = i != 1 ? i != 2 ? "Unknown error" : "Package obsolete" : "Package not available";
        StringBuilder sb = new StringBuilder(str.length() + 17);
        sb.append("LoaderException{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
