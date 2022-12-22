package com.didi.map.setting.common.diversion;

import java.util.List;

public interface INavDiversionProvider {
    void appendNavRecord(String str);

    void clearNavRecord();

    List<String> getNavRecord();

    boolean hasStartedNav();

    void setHasStartedNav();
}
