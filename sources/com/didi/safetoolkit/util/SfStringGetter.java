package com.didi.safetoolkit.util;

public class SfStringGetter {
    public static String getString(int i) {
        return SfContextHelper.getContext().getString(i);
    }

    public static final String getString(int i, Object... objArr) {
        return SfContextHelper.getContext().getString(i, objArr);
    }
}
