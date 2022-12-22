package com.didi.component.safetoolkit.saspi;

import com.didi.component.common.track.DidiTrackingClient;
import com.didi.safetoolkit.api.ISfUploadLocationService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "sa_home", value = {ISfUploadLocationService.class})
public class SAUploadLocationProvider implements ISfUploadLocationService {
    public void sendLocation() {
        DidiTrackingClient.getInstance().callTrackingAtOnce(3);
    }
}
