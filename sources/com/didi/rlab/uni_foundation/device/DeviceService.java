package com.didi.rlab.uni_foundation.device;

public interface DeviceService {
    double batteryLevel();

    String brand();

    String model();

    double outputVolume();

    long screenHeight();

    long screenWidth();
}
