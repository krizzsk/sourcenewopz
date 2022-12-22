package com.didichuxing.bigdata.p173dp.locsdk.google;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.utils.IPlayServicesAvailable;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.common.GoogleApiAvailability;

@ServiceProvider({IPlayServicesAvailable.class})
/* renamed from: com.didichuxing.bigdata.dp.locsdk.google.PlayServicesAvailable */
public class PlayServicesAvailable implements IPlayServicesAvailable {
    public int isAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }
}
