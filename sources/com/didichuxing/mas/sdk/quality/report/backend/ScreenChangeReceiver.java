package com.didichuxing.mas.sdk.quality.report.backend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ScreenChangeReceiver extends BroadcastReceiver {
    public static ScreenState SCREEN_STATE = ScreenState.UNKNOWN;
    private static ScreenChangeReceiver mReceiver;
    private static List<ScreenChangeListener> screenChangeListeners = new ArrayList();

    public enum ScreenState {
        UNKNOWN,
        ON,
        OFF
    }

    public static void init(Context context) {
        mReceiver = new ScreenChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        SCREEN_STATE = ScreenState.ON;
        try {
            context.registerReceiver(mReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            SCREEN_STATE = ScreenState.OFF;
            synchronized (screenChangeListeners) {
                for (ScreenChangeListener screenOff : screenChangeListeners) {
                    screenOff.screenOff();
                }
            }
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            SCREEN_STATE = ScreenState.ON;
            synchronized (screenChangeListeners) {
                for (ScreenChangeListener screenOn : screenChangeListeners) {
                    screenOn.screenOn();
                }
            }
        }
    }

    public static void addScreenChangeListener(ScreenChangeListener screenChangeListener) {
        synchronized (screenChangeListeners) {
            screenChangeListeners.add(screenChangeListener);
        }
    }

    public static void removeScreenChangeListener(ScreenChangeListener screenChangeListener) {
        synchronized (screenChangeListeners) {
            screenChangeListeners.remove(screenChangeListener);
        }
    }
}
