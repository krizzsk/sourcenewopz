package com.didi.component.business.xpanelnew;

import java.util.List;

public interface IXpCompRefresh {
    public static final int ADD_A_CARD = 1;
    public static final int REMOVE_A_CARD = 2;

    public interface IXpCompRefreshCb {
        void callback(float f, int i);

        void heightAnimValue(int i);
    }

    void compIds(List<String> list, int i, IXpCompRefreshCb iXpCompRefreshCb);

    void compRefresh(int i, String str, int i2, IXpCompRefreshCb iXpCompRefreshCb);
}
