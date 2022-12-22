package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class MultiWindowUnsupportedException extends IProovException {
    public MultiWindowUnsupportedException(Context context) {
        super(context.getString(R.string.iproov__error_multi_window_mode_unsupported), context.getString(R.string.iproov__error_multi_window_mode_unsupported));
    }
}
