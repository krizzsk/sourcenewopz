package com.didi.unifylogin.spi;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.spi.CPFVerifySerialInterface;
import com.didichuxing.foundation.spi.ServiceLoader;

public class CPFVerifyService {
    public static final int REQUEST_CODE_CPF_AUTH = 35;

    public static boolean cpfTestVerify(Context context, CPFVerifySerialInterface.TestCallback testCallback) {
        CPFVerifySerialInterface cPFVerifySerialInterface = (CPFVerifySerialInterface) ServiceLoader.load(CPFVerifySerialInterface.class).get();
        if (cPFVerifySerialInterface == null) {
            return false;
        }
        cPFVerifySerialInterface.getCPFV2Test(context, testCallback);
        return true;
    }

    public static boolean cpfJumpTo(Activity activity, Fragment fragment, CPFVerifySerialInterface.CpfCallback cpfCallback) {
        CPFVerifySerialInterface cPFVerifySerialInterface = (CPFVerifySerialInterface) ServiceLoader.load(CPFVerifySerialInterface.class).get();
        if (cPFVerifySerialInterface == null) {
            return false;
        }
        cPFVerifySerialInterface.jump2CpfVerifyPage(activity, fragment, cpfCallback, 35);
        return true;
    }

    public static boolean flutterOpenCpf(Activity activity, String str, CPFVerifySerialInterface.CpfCallback cpfCallback) {
        CPFVerifySerialInterface cPFVerifySerialInterface = (CPFVerifySerialInterface) ServiceLoader.load(CPFVerifySerialInterface.class).get();
        if (cPFVerifySerialInterface == null) {
            return false;
        }
        cPFVerifySerialInterface.flutterOpenCpf(activity, str, cpfCallback);
        return true;
    }
}
