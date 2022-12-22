package com.didi.sdk.push;

import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.proxy.LogupBindListener;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({LogEventListener.class, LogupBindListener.class})
public class LogUploadHandler extends BaseLogUploadHandler {
}
