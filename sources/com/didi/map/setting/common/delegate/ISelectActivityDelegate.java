package com.didi.map.setting.common.delegate;

import android.os.Bundle;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.model.MapSettingModel;

public interface ISelectActivityDelegate {
    MapSettingAppInfo getMapSettingInfo(int i);

    void onCreate(Bundle bundle, MapSettingModel mapSettingModel);

    void updateListView(boolean z);
}
