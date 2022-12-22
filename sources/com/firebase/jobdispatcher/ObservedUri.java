package com.firebase.jobdispatcher;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ObservedUri {

    /* renamed from: a */
    private final Uri f52138a;

    /* renamed from: b */
    private final int f52139b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
        public static final int FLAG_NOTIFY_FOR_DESCENDANTS = 1;
    }

    public ObservedUri(Uri uri, int i) {
        if (uri != null) {
            this.f52138a = uri;
            this.f52139b = i;
            return;
        }
        throw new IllegalArgumentException("URI must not be null.");
    }

    public Uri getUri() {
        return this.f52138a;
    }

    public int getFlags() {
        return this.f52139b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObservedUri)) {
            return false;
        }
        ObservedUri observedUri = (ObservedUri) obj;
        if (this.f52139b != observedUri.f52139b || !this.f52138a.equals(observedUri.f52138a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f52138a.hashCode() ^ this.f52139b;
    }
}
