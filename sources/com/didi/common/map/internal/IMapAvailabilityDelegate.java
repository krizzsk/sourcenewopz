package com.didi.common.map.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public interface IMapAvailabilityDelegate {
    public static final int SUCCESS = 0;

    Dialog getErrorDialog(Activity activity, int i, int i2);

    Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener);

    int isAvailable(Context context);
}
