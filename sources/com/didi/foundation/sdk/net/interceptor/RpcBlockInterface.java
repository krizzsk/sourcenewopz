package com.didi.foundation.sdk.net.interceptor;

import java.util.ArrayList;

public interface RpcBlockInterface {
    ArrayList<String> getBlackList();

    String getErrorMsg();

    int getLimitRandomTime();

    int getLimitTime();

    boolean toggle();

    void tracker596Error(String str);

    void trackerBlock(String str);
}
