package com.didi.map.setting.common.delegate;

import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.data.MapSettingItemInfo;
import com.didi.map.setting.common.data.MapSettingListInfo;
import com.didi.map.setting.common.model.MapSettingModel;
import java.util.List;

public interface IModelDelegate {
    List<MapSettingAppInfo> getInstalledThirdNav(MapSettingModel mapSettingModel);

    List<MapSettingItemInfo> getItemInfo(MapSettingModel mapSettingModel);

    MapSettingListInfo getListInfo(MapSettingModel mapSettingModel, boolean z, int i);
}
