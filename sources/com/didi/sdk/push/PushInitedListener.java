package com.didi.sdk.push;

import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({PushConnectionListener.class})
public class PushInitedListener implements PushConnectionListener {
    static boolean hasInited = false;

    public void onConnection(PushConnResult pushConnResult) {
        hasInited = true;
        PushClient.getClient().unregisterConnectionListener(this);
    }
}
