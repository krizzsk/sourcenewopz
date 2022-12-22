package com.didi.map.setting.common.diversion;

import java.util.List;

public interface INavDiversionPloy {
    String getDiversionTarget(List<String> list);

    boolean needDiversion();

    void startNav(String str);
}
