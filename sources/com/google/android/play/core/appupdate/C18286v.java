package com.google.android.play.core.appupdate;

/* renamed from: com.google.android.play.core.appupdate.v */
final class C18286v extends AppUpdateOptions {

    /* renamed from: a */
    private final int f52684a;

    /* renamed from: b */
    private final boolean f52685b;

    /* synthetic */ C18286v(int i, boolean z) {
        this.f52684a = i;
        this.f52685b = z;
    }

    public final boolean allowAssetPackDeletion() {
        return this.f52685b;
    }

    public final int appUpdateType() {
        return this.f52684a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            return this.f52684a == appUpdateOptions.appUpdateType() && this.f52685b == appUpdateOptions.allowAssetPackDeletion();
        }
    }

    public final int hashCode() {
        return ((this.f52684a ^ 1000003) * 1000003) ^ (true != this.f52685b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.f52684a;
        boolean z = this.f52685b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
