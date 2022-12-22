package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class ServerException extends IProovException {
    public ServerException(Context context, String str) {
        super(context.getString(R.string.iproov__error_server), str);
    }
}
