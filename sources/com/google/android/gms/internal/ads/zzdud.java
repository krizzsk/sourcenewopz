package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdud {
    public final String label;
    public final String value;

    public zzdud(String str, String str2) {
        this.label = str;
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdud)) {
            return false;
        }
        zzdud zzdud = (zzdud) obj;
        return this.label.equals(zzdud.label) && this.value.equals(zzdud.value);
    }

    public final int hashCode() {
        String valueOf = String.valueOf(this.label);
        String valueOf2 = String.valueOf(this.value);
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }
}
