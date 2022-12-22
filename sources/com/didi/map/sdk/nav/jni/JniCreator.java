package com.didi.map.sdk.nav.jni;

import com.map.sdk.nav.libc.jni.DiDiNavWrapper;
import com.map.sdk.nav.libc.jni.JniWrapperInterface;

public class JniCreator {
    public static JniWrapperInterface get() {
        return new DiDiNavWrapper();
    }
}
