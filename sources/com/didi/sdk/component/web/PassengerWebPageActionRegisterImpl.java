package com.didi.sdk.component.web;

import com.didi.commoninterfacelib.web.IPlatformWebPageActionRegister;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IPlatformWebPageActionRegister.class})
public class PassengerWebPageActionRegisterImpl implements IPlatformWebPageActionRegister {
    public String getAction() {
        return "didi.passenger.intent.action.PlatformProxyWebActivity";
    }
}
