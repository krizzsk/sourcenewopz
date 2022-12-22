package com.didi.unifylogin.spi;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

public interface CPFVerifySerialInterface {

    public interface CpfCallback {
        void onResult(int i, String str);
    }

    public interface TestCallback {
        void onFailed();

        void onSuccess();
    }

    void flutterOpenCpf(Activity activity, String str, CpfCallback cpfCallback);

    void getCPFV2Test(Context context, TestCallback testCallback);

    void jump2CpfVerifyPage(Activity activity, Fragment fragment, CpfCallback cpfCallback, int i);
}
