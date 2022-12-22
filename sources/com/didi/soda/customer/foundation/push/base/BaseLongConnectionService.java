package com.didi.soda.customer.foundation.push.base;

import android.content.Context;
import com.didi.foundation.sdk.liveconnection.ConnectionListener;
import com.didi.foundation.sdk.liveconnection.LiveConnectionService;
import com.didi.foundation.sdk.liveconnection.LogListener;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Option;
import com.didi.foundation.sdk.liveconnection.Request;

public class BaseLongConnectionService {
    public LogListener getLogListener() {
        return LiveConnectionService.getInstance().getLogListener();
    }

    public void setLogListener(LogListener logListener) {
        LiveConnectionService.getInstance().setLogListener(logListener);
    }

    public void init(Context context, Option option) {
        LiveConnectionService.getInstance().config(context, option);
    }

    public boolean isConnected() {
        return LiveConnectionService.getInstance().isConnected();
    }

    public void registerConnectListener(ConnectionListener connectionListener) {
        LiveConnectionService.getInstance().registerConnectionListener(connectionListener);
    }

    public void registerMessageListener(MessageListener messageListener) {
        LiveConnectionService.getInstance().registerMessageListener(messageListener);
    }

    public void release() {
        LiveConnectionService.getInstance().release();
    }

    public void sendRequest(Request request) {
        LiveConnectionService.getInstance().sendRequest(request);
    }

    public void startConnect() {
        LiveConnectionService.getInstance().start();
    }

    public void stopConnect() {
        LiveConnectionService.getInstance().stop();
    }

    public void unRegisterMessageListener(MessageListener messageListener) {
        LiveConnectionService.getInstance().unRegisterMessageListener(messageListener);
    }

    public void unregisterConnectionListener(ConnectionListener connectionListener) {
        LiveConnectionService.getInstance().unRegisterConnectionListener(connectionListener);
    }
}
