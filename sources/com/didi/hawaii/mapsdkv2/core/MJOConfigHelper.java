package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.view.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class MJOConfigHelper implements GLSurfaceView.EGLConfigChooser {
    public static int EGL_SAMPLES_SIZE = 1;

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, new int[]{12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 24, 12326, 8, 12338, 1, 12337, 4, 12344}, eGLConfigArr, 1, iArr);
        if (iArr[0] == 0) {
            HWLog.m16761i("hwmap", "error config eglSimpleSize=" + EGL_SAMPLES_SIZE);
            return null;
        }
        EGL_SAMPLES_SIZE = 4;
        HWLog.m16761i("hwmap", "config eglSimpleSize=" + EGL_SAMPLES_SIZE);
        return eGLConfigArr[0];
    }
}
