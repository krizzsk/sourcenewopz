package com.didi.safetoolkit.util;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class BroadcastUtil {
    public static void sendBroadcast(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
