package com.didi.sdk.push;

import com.didi.sdk.push.log.LogEventListener;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({LogEventListener.class})
public class LogEventHandler extends BaseLogEventHandler {
}
