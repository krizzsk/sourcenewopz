package com.didichuxing.dfbasesdk.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class SensorDataCollector$1 implements SensorEventListener {
    final /* synthetic */ C15306b this$0;
    final /* synthetic */ SensorConfig val$config;
    final /* synthetic */ SensorData val$sensorData;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    SensorDataCollector$1(C15306b bVar, SensorConfig sensorConfig, SensorData sensorData) {
        this.this$0 = bVar;
        this.val$config = sensorConfig;
        this.val$sensorData = sensorData;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.this$0.m33517a(sensorEvent, this.val$config, this.val$sensorData);
    }
}
