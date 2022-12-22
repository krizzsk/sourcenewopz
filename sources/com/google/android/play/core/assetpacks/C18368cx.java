package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.cx */
final /* synthetic */ class C18368cx implements FilenameFilter {

    /* renamed from: a */
    private final String f52972a;

    C18368cx(String str) {
        this.f52972a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f52972a).concat("-")) && str.endsWith(".apk");
    }
}
