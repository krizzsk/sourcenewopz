package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bg */
final class C18324bg extends AssetPackLocation {

    /* renamed from: a */
    private final int f52810a;

    /* renamed from: b */
    private final String f52811b;

    /* renamed from: c */
    private final String f52812c;

    C18324bg(int i, String str, String str2) {
        this.f52810a = i;
        this.f52811b = str;
        this.f52812c = str2;
    }

    public final String assetsPath() {
        return this.f52812c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.f52810a == assetPackLocation.packStorageMethod() && ((str = this.f52811b) != null ? str.equals(assetPackLocation.path()) : assetPackLocation.path() == null)) {
                String str2 = this.f52812c;
                String assetsPath = assetPackLocation.assetsPath();
                if (str2 != null ? str2.equals(assetsPath) : assetsPath == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f52810a ^ 1000003) * 1000003;
        String str = this.f52811b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f52812c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final int packStorageMethod() {
        return this.f52810a;
    }

    public final String path() {
        return this.f52811b;
    }

    public final String toString() {
        int i = this.f52810a;
        String str = this.f52811b;
        String str2 = this.f52812c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
