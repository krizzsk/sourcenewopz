package com.google.android.play.core.splitcompat;

import java.io.File;

/* renamed from: com.google.android.play.core.splitcompat.q */
final class C18547q {

    /* renamed from: a */
    private final File f53253a;

    /* renamed from: b */
    private final String f53254b;

    C18547q() {
    }

    C18547q(File file, String str) {
        this();
        if (file != null) {
            this.f53253a = file;
            if (str != null) {
                this.f53254b = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo149238a() {
        return this.f53253a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo149239b() {
        return this.f53254b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C18547q) {
            C18547q qVar = (C18547q) obj;
            return this.f53253a.equals(qVar.mo149238a()) && this.f53254b.equals(qVar.mo149239b());
        }
    }

    public int hashCode() {
        return ((this.f53253a.hashCode() ^ 1000003) * 1000003) ^ this.f53254b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f53253a);
        String str = this.f53254b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
