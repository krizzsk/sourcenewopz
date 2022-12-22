package com.microblink.blinkbarcode.uisettings;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

/* compiled from: line */
public abstract class ActivityRunner {
    public static final String EXTRA_SCAN_EXCEPTION = "com.microblink.blinkbarcode.scanexception";

    public static void startActivityForResult(Activity activity, int i, UISettings uISettings) {
        Intent intent = new Intent(activity, uISettings.getTargetActivity());
        uISettings.saveToIntent(intent);
        activity.startActivityForResult(intent, i);
    }

    public static void startActivityForResult(Fragment fragment, int i, UISettings uISettings) {
        Intent intent = new Intent(fragment.getActivity(), uISettings.getTargetActivity());
        uISettings.saveToIntent(intent);
        fragment.startActivityForResult(intent, i);
    }

    public static void startActivityForResult(androidx.fragment.app.Fragment fragment, int i, UISettings uISettings) {
        Intent intent = new Intent(fragment.getActivity(), uISettings.getTargetActivity());
        uISettings.saveToIntent(intent);
        fragment.startActivityForResult(intent, i);
    }
}
