package com.didi.component.safetoolkit.spi;

import com.didi.component.common.track.DidiTrackingClient;
import com.didi.safetoolkit.api.ISfUploadLocationService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {ISfUploadLocationService.class})
public class UploadLocationProvider implements ISfUploadLocationService {
    public void sendLocation() {
        DidiTrackingClient.getInstance().callTrackingAtOnce(3);
    }
}
