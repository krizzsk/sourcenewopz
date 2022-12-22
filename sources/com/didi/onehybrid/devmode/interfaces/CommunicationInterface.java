package com.didi.onehybrid.devmode.interfaces;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;

public interface CommunicationInterface {
    FusionRuntimeInfo getFusionRuntimeInfo();

    void onChange(String str);
}
