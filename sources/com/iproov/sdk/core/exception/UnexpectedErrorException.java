package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class UnexpectedErrorException extends IProovException {
    public UnexpectedErrorException(Context context, String str) {
        super(reason(context), str);
    }

    private static String reason(Context context) {
        return context.getString(R.string.iproov__error_unexpected_error);
    }

    public UnexpectedErrorException(Context context, Exception exc) {
        super(reason(context), exc);
    }
}
