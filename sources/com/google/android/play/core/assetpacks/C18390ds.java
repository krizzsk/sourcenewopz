package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.ds */
final /* synthetic */ class C18390ds implements FilenameFilter {

    /* renamed from: a */
    static final FilenameFilter f53056a = new C18390ds();

    private C18390ds() {
    }

    public final boolean accept(File file, String str) {
        return C18391dt.f53057a.matcher(str).matches();
    }
}
