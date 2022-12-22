package com.didi.common.map.adapter.googlemapadapter.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.didi.common.map.internal.IMapAvailabilityDelegate;

public class GoogleApiAvailability implements IMapAvailabilityDelegate {
    private static volatile GoogleApiAvailability googleApiAvailability;

    public static GoogleApiAvailability getInstance() {
        if (googleApiAvailability == null) {
            synchronized (GoogleApiAvailability.class) {
                if (googleApiAvailability == null) {
                    googleApiAvailability = new GoogleApiAvailability();
                }
            }
        }
        return googleApiAvailability;
    }

    private GoogleApiAvailability() {
    }

    public int isAvailable(Context context) {
        if (context == null) {
            return -1;
        }
        return com.google.android.gms.common.GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2) {
        return com.google.android.gms.common.GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2);
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return com.google.android.gms.common.GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }
}
