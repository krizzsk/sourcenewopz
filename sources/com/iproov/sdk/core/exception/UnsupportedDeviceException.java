package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class UnsupportedDeviceException extends IProovException {
    public UnsupportedDeviceException(Context context, String str) {
        super(reason(context), str);
    }

    private static String reason(Context context) {
        return context.getString(R.string.iproov__error_device_not_supported);
    }
}
