package com.google.android.play.core.assetpacks;

public abstract class AssetPackLocation {

    /* renamed from: a */
    private static final AssetPackLocation f52701a = new C18324bg(1, (String) null, (String) null);

    /* renamed from: a */
    static AssetPackLocation m37424a() {
        return f52701a;
    }

    /* renamed from: a */
    static AssetPackLocation m37425a(String str, String str2) {
        return new C18324bg(0, str, str2);
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
