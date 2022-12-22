package com.didi.map.setting.common.delegate;

import android.os.Bundle;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.common.model.MapSettingModel;

public interface IWindowActivityDelegate {
    MapSettingAppInfo getMapSettingInfo(int i);

    boolean isNeedRemember();

    void onCreate(Bundle bundle, MapSettingModel mapSettingModel, MapSettingNavInfo mapSettingNavInfo);

    void setNeedRemember(boolean z);

    void updateListView();
}
