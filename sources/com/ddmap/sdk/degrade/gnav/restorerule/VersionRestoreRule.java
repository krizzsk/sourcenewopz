package com.ddmap.sdk.degrade.gnav.restorerule;

import android.text.TextUtils;
import com.ddmap.sdk.degrade.gnav.utils.VersionUtils;

public class VersionRestoreRule implements IRestoreRule<String> {

    /* renamed from: a */
    private final String f4300a;

    public VersionRestoreRule(String str) {
        this.f4300a = str;
    }

    public boolean needRestore(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f4300a) || VersionUtils.compareVersion(str, this.f4300a) < 0) {
            return false;
        }
        return true;
    }
}
