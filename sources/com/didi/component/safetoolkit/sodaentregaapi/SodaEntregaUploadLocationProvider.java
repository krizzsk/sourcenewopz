package com.didi.component.safetoolkit.sodaentregaapi;

import com.didi.component.common.track.DidiTrackingClient;
import com.didi.safetoolkit.api.ISfUploadLocationService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "sodaEntrega", value = {ISfUploadLocationService.class})
public class SodaEntregaUploadLocationProvider implements ISfUploadLocationService {
    public void sendLocation() {
        DidiTrackingClient.getInstance().callTrackingAtOnce(3);
    }
}
