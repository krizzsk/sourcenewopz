package com.didi.foundation.sdk.liveconnection;

import android.content.Context;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface LiveConnectionServiceProvider {
    void config(Context context, Option option);

    LogListener getLogListener();

    boolean isConnected();

    void registerConnectionListener(ConnectionListener connectionListener);

    void registerMessageListener(MessageListener messageListener);

    void release();

    void removeAllConnectionListener();

    void removeAllMessageListener();

    void sendRequest(Request request);

    void setLogListener(LogListener logListener);

    void start();

    void stop();

    void unRegisterConnectionListener(ConnectionListener connectionListener);

    void unRegisterMessageListener(MessageListener messageListener);
}
