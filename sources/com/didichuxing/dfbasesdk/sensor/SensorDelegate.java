package com.didichuxing.dfbasesdk.sensor;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;

public class SensorDelegate {

    /* renamed from: a */
    private static volatile Context f46663a;

    /* renamed from: b */
    private static int f46664b;

    @Deprecated
    public static String getError() {
        return "{}";
    }

    @Deprecated
    public static boolean hasCollected() {
        return false;
    }

    @Deprecated
    public static boolean isCollectingData() {
        return false;
    }

    public static void init(Context context) {
        if (f46663a == null && context != null) {
            f46663a = context.getApplicationContext();
            addSensorConfig(getAllSensors());
        }
    }

    public static void addSensorConfig(List<SensorConfig> list) {
        if (f46663a == null) {
        }
    }

    public static void onSdklaunch() {
        if (f46663a == null) {
        }
    }

    public static void onSdkPageStart() {
        f46664b = Math.max(f46664b + 1, 1);
        if (f46663a == null) {
        }
    }

    public static void onSdkPageStop() {
        f46664b = Math.max(f46664b - 1, 0);
        if (f46663a == null) {
        }
    }

    public static void onSdkFinish() {
        if (f46663a == null) {
        }
    }

    public static String getData() {
        if (f46663a == null) {
            return null;
        }
        return C15306b.m33516a(f46663a).mo115727c();
    }

    public static List<SensorConfig> getAllSensors() {
        LinkedList linkedList = new LinkedList();
        for (int i : SensorData.types) {
            SensorConfig sensorConfig = new SensorConfig();
            sensorConfig.type = i;
            linkedList.add(sensorConfig);
        }
        return linkedList;
    }
}
