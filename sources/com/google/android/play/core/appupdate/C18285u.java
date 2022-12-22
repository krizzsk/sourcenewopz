package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* renamed from: com.google.android.play.core.appupdate.u */
final class C18285u extends AppUpdateOptions.Builder {

    /* renamed from: a */
    private Integer f52682a;

    /* renamed from: b */
    private Boolean f52683b;

    C18285u() {
    }

    public final AppUpdateOptions build() {
        String str = "";
        if (this.f52682a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.f52683b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new C18286v(this.f52682a.intValue(), this.f52683b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.f52683b = Boolean.valueOf(z);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.f52682a = Integer.valueOf(i);
        return this;
    }
}
