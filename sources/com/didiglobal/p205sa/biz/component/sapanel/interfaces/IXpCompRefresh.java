package com.didiglobal.p205sa.biz.component.sapanel.interfaces;

import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.interfaces.IXpCompRefresh */
public interface IXpCompRefresh {
    public static final int ADD_A_CARD = 1;
    public static final int REMOVE_A_CARD = 2;

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.interfaces.IXpCompRefresh$IXpCompRefreshCb */
    public interface IXpCompRefreshCb {
        void callback(float f, int i);

        void heightAnimValue(int i);
    }

    void compIds(List<String> list, int i, IXpCompRefreshCb iXpCompRefreshCb);

    void compRefresh(int i, String str, int i2, IXpCompRefreshCb iXpCompRefreshCb);
}
