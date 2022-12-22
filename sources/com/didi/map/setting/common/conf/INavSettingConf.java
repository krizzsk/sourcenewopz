package com.didi.map.setting.common.conf;

import java.util.List;

public interface INavSettingConf {
    int getAutoStartDelaySecond();

    int getDayNightMode();

    List<String> getNavPkgList();

    boolean isAutoStart();

    boolean isDoubleClickRemember();

    boolean isOpenVoice();
}
