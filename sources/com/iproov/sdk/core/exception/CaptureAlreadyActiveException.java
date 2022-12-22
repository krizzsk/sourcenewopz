package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class CaptureAlreadyActiveException extends IProovException {
    public CaptureAlreadyActiveException(Context context) {
        super(context.getString(R.string.iproov__error_capture_already_active), (String) null);
    }
}
