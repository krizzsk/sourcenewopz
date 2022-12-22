package com.google.android.play.core.review;

import android.app.PendingIntent;

/* renamed from: com.google.android.play.core.review.a */
final class C18522a extends ReviewInfo {

    /* renamed from: a */
    private final PendingIntent f53208a;

    C18522a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f53208a = pendingIntent;
            return;
        }
        throw new NullPointerException("Null pendingIntent");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo149202a() {
        return this.f53208a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f53208a.equals(((ReviewInfo) obj).mo149202a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f53208a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f53208a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("ReviewInfo{pendingIntent=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
