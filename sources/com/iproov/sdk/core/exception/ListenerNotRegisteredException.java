package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class ListenerNotRegisteredException extends IProovException {
    public ListenerNotRegisteredException(Context context) {
        super(context.getString(R.string.iproov__error_listener_not_registered), (String) null);
    }
}
