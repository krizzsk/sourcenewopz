package com.didi.sdk.push.common;

import com.didi.sdk.push.dpush.LogUtil;
import com.didi.sdk.tpush.ILogCallbackListener;
import java.util.HashSet;
import java.util.Set;

public class ThirdPartyMsgManager {
    private static ThirdPartyMsgManager INSTANC = new ThirdPartyMsgManager();
    private ILoginInfoDelegate loginInfoDelegate;
    private Set<IThirdPartyMsgReceiver> receivers = new HashSet();
    private IThirdPartyMsgParamsGetter serverParamsGetter;

    private ThirdPartyMsgManager() {
    }

    public static ThirdPartyMsgManager getInstance() {
        return INSTANC;
    }

    public void init(IThirdPartyMsgParamsGetter iThirdPartyMsgParamsGetter, ILoginInfoDelegate iLoginInfoDelegate) {
        if (iThirdPartyMsgParamsGetter == null) {
            throw new RuntimeException("IThirdPartyMsgParamsGetter can not null");
        } else if (iLoginInfoDelegate != null) {
            this.serverParamsGetter = iThirdPartyMsgParamsGetter;
            this.loginInfoDelegate = iLoginInfoDelegate;
        } else {
            throw new RuntimeException("ILoginInfoDelegate can not null");
        }
    }

    public void init(IThirdPartyMsgParamsGetter iThirdPartyMsgParamsGetter, ILoginInfoDelegate iLoginInfoDelegate, ILogCallbackListener iLogCallbackListener) {
        LogUtil.setLogCallbackListener(iLogCallbackListener);
        init(iThirdPartyMsgParamsGetter, iLoginInfoDelegate);
    }

    public IThirdPartyMsgParamsGetter getServerParamsGetter() {
        return this.serverParamsGetter;
    }

    public synchronized void addMsgReceiver(IThirdPartyMsgReceiver iThirdPartyMsgReceiver) {
        LogUtil.m26293d(4, "addMsgReceiver called");
        if (iThirdPartyMsgReceiver == null) {
            LogUtil.m26293d(4, "addMsgReceiver receiver is null");
        } else {
            this.receivers.add(iThirdPartyMsgReceiver);
        }
    }

    public synchronized void removeMsgReceiver(IThirdPartyMsgReceiver iThirdPartyMsgReceiver) {
        LogUtil.m26293d(4, "removeMsgReceiver called");
        if (iThirdPartyMsgReceiver == null) {
            LogUtil.m26293d(4, "removeMsgReceiver receiver is null");
        } else {
            this.receivers.remove(iThirdPartyMsgReceiver);
        }
    }

    public synchronized void dispatchMsg(String str) {
        LogUtil.m26293d(4, "dispatchMsg called msg = " + str);
        for (IThirdPartyMsgReceiver onReceiveMsg : this.receivers) {
            onReceiveMsg.onReceiveMsg(str);
        }
    }

    public ILoginInfoDelegate getLoginInfoDelegate() {
        return this.loginInfoDelegate;
    }
}
