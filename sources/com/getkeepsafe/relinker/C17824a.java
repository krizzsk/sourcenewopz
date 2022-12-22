package com.getkeepsafe.relinker;

import android.os.Build;
import com.getkeepsafe.relinker.ReLinker;

/* renamed from: com.getkeepsafe.relinker.a */
/* compiled from: SystemLibraryLoader */
final class C17824a implements ReLinker.LibraryLoader {
    C17824a() {
    }

    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    public void loadPath(String str) {
        System.load(str);
    }

    public String mapLibraryName(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return System.mapLibraryName(str);
        }
        return str;
    }

    public String unmapLibraryName(String str) {
        return str.substring(3, str.length() - 3);
    }

    public String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        if (!C17825b.m37256a(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }
}
